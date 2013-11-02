package animation;


import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import bTools.BMaths;
import data.Particle;
import data.Trajectory;

public class LwjglObject //extends JPanel
{
	/** Game title */
	public static final String GAME_TITLE = "My Game";
	 
	/** Desired frame time */
	private static final int FRAMERATE = 30;
	 
	/** Exit the game */
	private static boolean finished;
	 
	/** Angle of rotating square */
	private static float angle;

	private Thread gameThread;
	
	/////////////////////////////////////////////
	static float[] red   = {1.0f,0.0f,0.0f};
	static float[] green = {0.0f,1.0f,0.0f};
	static float[] blue  = {0.0f,0.0f,1.0f};
	static float[] white = {1.0f,1.0f,1.0f};
	
	
	 public static final int SIZE_FLOAT = 4;
	//light	
	static private float light_pos[] = {1.0f, 1.0f, 1.0f, 0.0f};	
	//luz difusa y especular
	static private float light_color[] = {1.0f, 1.0f, 1.0f, 1.0f};	 
	//luz ambiental
	static private float light_ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
	
	//material	
	static private float mat_ambient_diffuse[] = {0.0f, 1.0f, 0.0f, 1.0f};
	static private float mat_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
	static private float mat_shininess = 0.5f;
    
    float[][][] trajectories;
	float[][] trayectoria;
	float width;
	float height;
	static int frame;
	static int nFrames;
	
	
	boolean lightning;
	boolean antialiasing;
	boolean showAll;
	
	boolean showParticles;
	boolean showTrajectories;

	int radialDistance;
	int verticalAngle;
	int horizontalAngle;
	
	float centroX;
	float centroY;
	float centroZ;
	
	/////////////////////////////////////////////////
	public float[][][] getTripleTrajs(Trajectory[] trajs)
	{
		
		float[][][] tripleTrajs = new float[trajs.length][3][];
		
		Particle[] particlesPro;
		for(int i=0;i<trajs.length;i++)
		{
			particlesPro = trajs[i].getParticlesPro();
			tripleTrajs[i] = new float[3][particlesPro.length];
			for(int j=0;j<particlesPro.length;j++)
			{
				tripleTrajs[i][0][j] = (float) particlesPro[j].getX();
				tripleTrajs[i][1][j] = (float) particlesPro[j].getY();
				tripleTrajs[i][2][j] = 0;
			}
		}
		
		
		return tripleTrajs;
	}
	/**
	 * Application init
	 * @param args Commandline args
	 */
	public LwjglObject(int width, int height, int length, Trajectory[] trajs, final GUI3DAnimation gui_3d)
	{
		
		float[][][] trajectories = getTripleTrajs(trajs);
		System.out.println("creando lwjglobject!");
		this.trajectories = trajectories;
		this.trayectoria = trajectories[0];
		
		this.width = (float)width;
		this.height = (float)height;
		frame = 0;
		nFrames = length;
		
		antialiasing = true;
		lightning = true;
		showAll = true;
		radialDistance = 10;
		verticalAngle = 90;
		horizontalAngle = 0;

		gameThread = new Thread(){
			public void run() {
				boolean fullscreen = false;
				try 
				{
					System.out.println("init lwjglobject!");
					init(fullscreen, gui_3d.get3dCanvas());
					System.out.println("gamerun lwjglobject!");
					gamerun();
				}
				catch (Exception e) 
				{
					e.printStackTrace(System.err);
					Sys.alert(GAME_TITLE, "An error occured and the game will exit.");
				}
				finally 
				{
					cleanup();
				}
				//System.exit(0);
			}
		};
		//gameThread.start();
		System.out.println("lwjglobject creado");
		
	}	  
	public void pause()
	{
		//gameThread.interrupt();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void resume()
	{
		gameThread.start();		
	}
	
	public void setRadialDistance(int radialDistance) {
		this.radialDistance = radialDistance;
	}

	public void setVerticalAngle(int verticalAngle) {
		this.verticalAngle = verticalAngle;
	}

	public void setHorizontalAngle(int horizontalAngle) {
		this.horizontalAngle = horizontalAngle;
	}

	public void setLightning(boolean lightning) {
		this.lightning = lightning;
	}
	public void setAntialiasing(boolean antialiasing) {
		this.antialiasing = antialiasing;
	}
	public void setShowAll(boolean showAll)
	{
		this.showAll = showAll;
	}
	public void setShowParticles(boolean showParticles) 
	{
		this.showParticles = showParticles;
	}

	public void setShowTrajectories(boolean showTrajectories) 
	{
		this.showTrajectories = showTrajectories;
	}
	public void setTrayectoria(float[][] trayectoria)
	{
		this.trayectoria = trayectoria;		
		frame = 0;
		nFrames = trayectoria[0].length-1;
		centroX = BMaths.avg(trayectoria[1]);
		centroY = BMaths.avg(trayectoria[2])*1000;
		centroZ = BMaths.avg(trayectoria[0]);
	}
	public void setTrajectories(float[][][] trajectories)
	{
		this.trajectories = trajectories;
	}
	
	/*-----------------------------------------------------------------------------------------------*/
	 
	/**
	 * Initialise the game
	 * @throws Exception if init fails
	 */
	private static void init(boolean fullscreen, Canvas canvas3d) throws Exception 
	{
		// Create a fullscreen window with 1:1 orthographic 2D projection (default)
		Display.setParent(canvas3d);
		//Display.setTitle(GAME_TITLE);	    
	    Display.setFullscreen(fullscreen);
	    DisplayMode displaymode = new DisplayMode(canvas3d.getWidth(),canvas3d.getHeight());
	    Display.setDisplayMode(displaymode);
	    // Enable vsync if we can (due to how OpenGL works, it cannot be guarenteed to always work)
	    Display.setVSyncEnabled(true);

	    // Create default display of 640x480
	    Display.create();
	    // Put the window into orthographic projection mode with 1:1 pixel ratio.
	    // We haven't used GLU here to do this to avoid an unnecessary dependency.
	    GL11.glMatrixMode(GL11.GL_PROJECTION);
	    GL11.glLoadIdentity();
	    //GL11.glOrtho(0.0, Display.getDisplayMode().getWidth(), 0.0, Display.getDisplayMode().getHeight(), 1, 20);
	    GLU.gluPerspective(45.0f, 16.0f/9.0f, 1.0f, 1000.0f);	    
	    GL11.glMatrixMode(GL11.GL_MODELVIEW);
	    GL11.glLoadIdentity();
	    GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
		
        FloatBuffer light_ambient_buffer = allocFloats(light_ambient);
        FloatBuffer light_color_buffer = allocFloats(light_color);
        FloatBuffer light_pos_buffer = allocFloats(light_pos);
		
		//Light
		GL11.glLight(GL11.GL_LIGHT0, GL11.GL_AMBIENT, light_ambient_buffer);      
	    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, light_color_buffer);
	    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_SPECULAR, light_color_buffer);      
	    GL11.glLight(GL11.GL_LIGHT0, GL11.GL_POSITION, light_pos_buffer);      
	    GL11.glEnable(GL11.GL_LIGHT0);
		
		//GL11.glEnable(GL.GL_LIGHTING);	    
	    
	    GL11.glEnable(GL11.GL_POINT_SMOOTH);
	    GL11.glEnable(GL11.GL_LINE_SMOOTH);
	    GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
	    GL11.glEnable(GL11.GL_BLEND);
	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	    GL11.glHint(GL11.GL_POINT_SMOOTH_HINT, GL11.GL_NICEST);
	    GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
	    GL11.glHint(GL11.GL_POLYGON_SMOOTH_HINT, GL11.GL_NICEST);
	    //TODO add multisample

	}
	 
	/**
	 * Runs the game (the "main loop")
	 */
	private void gamerun() 
	{
		while (!finished) 
		{
			//Always call Window.update(), all the time - it does some behind the
			//scenes work, and also displays the rendered output
			Display.update();
			
	 
			// Check for close requests
			if (Display.isCloseRequested()) 
			{
				finished = true;
			} 
			// The window is in the foreground, so we should play the game
			else if (Display.isActive()) 
			{
				logic();
				//renderDefault();
				render();
				Display.sync(FRAMERATE);
			} 
			//The window is not in the foreground, so we can allow other stuff to run and
			//infrequently update
			else 
			{
				try 
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e) 
				{
					System.out.println("error lwjgl!!!!!!!!!!");
				}
				logic();
				
				// Only bother rendering if the window is visible or dirty
				if (Display.isVisible() || Display.isDirty()) 
				{
					//renderDefault();
					render();
				}
			}
    	}
	}
	 
	/**
	 * Do any game-specific cleanup
	 */
	private static void cleanup() 
	{
		// Close the window
	    Display.destroy();
	}
	 
	/**
	 * Do all calculations, handle input, etc.
	 */
	private static void logic() 
	{
		// Example input handler: we'll check for the ESC key and finish the game instantly when it's pressed
	    if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) 
	    {
	    	finished = true;
	    }
	}
	/**
	 * Render the current frame
	 */
	private void render()
	{
		if(!antialiasing)
		{
			GL11.glDisable(GL11.GL_POINT_SMOOTH);
		    GL11.glDisable(GL11.GL_LINE_SMOOTH);
		    GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
		}
		else
		{
			GL11.glEnable(GL11.GL_POINT_SMOOTH);
		    GL11.glEnable(GL11.GL_LINE_SMOOTH);
		    GL11.glEnable(GL11.GL_POLYGON_SMOOTH);			
		}
		/*if(lightning)
		{
			GL11.glEnable(GL.GL_LIGHTING);
		}
		else
		{
			GL11.glDisable(GL.GL_LIGHTING);
		}*/
		
		
		//System.out.println("Frame:"+frame);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		//Camera		
		/*GLU.gluLookAt(10.0f, 10.0f, 30.0f,
					  0.0f, 0.0f, 0.0f, 
					  0.0f, 1.0f, 0.0f);*/
		/*GLU.gluLookAt(0.0f, 0.0f, 30.0f,
					   0.0f, 0.0f, 0.0f, 
				  	   0.0f, 1.0f, 0.0f);*/
		GLU.gluLookAt((float)(radialDistance*Math.cos(verticalAngle*Math.PI/180)*Math.sin(horizontalAngle*Math.PI/180)), 
					  (float)(radialDistance*Math.sin(verticalAngle*Math.PI/180)), 
					  (float)(radialDistance*Math.cos(verticalAngle*Math.PI/180)*Math.cos(horizontalAngle*Math.PI/180)),
				  //0.0f, 0.0f, 0.0f, 
					  centroX, centroY, centroZ,
				  0.0f, 1.0f, 0.0f);
		
		//Info		
		GL11.glPushMatrix();
			//System.out.println("glPrint(HOLAAAAAAAAA);");
			//glPrint("HOLAAAAAAAAA");
		GL11.glPushMatrix();
		
		//Axis
		GL11.glLineWidth(5);
		axis();
		//System.out.println("ejes dibujados;");
		
		//Box
		GL11.glLineWidth(2);
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		box();
		
		//XY Lines
		/*GL11.glLineWidth(1);
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		lines();*/
		//System.out.println("lineas dibujadas;");
		
		/*
		//Planes
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		planes();	
		System.out.println("planos dibujados;");
		*/		
		
		//Origin
		GL11.glPushMatrix();
			GL11.glColor3f(1.0f, 0.0f, 0.0f);
			Sphere bolita0 = new Sphere();      
			bolita0.setDrawStyle(GLU.GLU_FILL);
			bolita0.draw(1.0f, 5, 5);			
		GL11.glPopMatrix();
		
		
		GL11.glEnable(GL11.GL_LIGHTING);
		/*--------------------------Particles-------------------------------------*/
		//Establecemos el material de la esfera
		FloatBuffer mat_ambient_diffuse_buffer = allocFloats(mat_ambient_diffuse);
		FloatBuffer mat_specular_buffer = allocFloats(mat_specular);
		
	    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT_AND_DIFFUSE, mat_ambient_diffuse_buffer);
	    GL11.glMaterial(GL11.GL_FRONT, GL11.GL_SPECULAR, mat_specular_buffer);
	    GL11.glMaterialf(GL11.GL_FRONT, GL11.GL_SHININESS, mat_shininess);
		
		if(showParticles)
		{
		    /*-------------Selected Particle-------------------*/
		    Sphere bolita = new Sphere();
		    if(frame<trayectoria[0].length)
			{
		    	GL11.glPushMatrix();			
					GL11.glTranslatef(trayectoria[1][frame], trayectoria[2][frame]*1000, trayectoria[0][frame]);
					bolita.setDrawStyle(GLU.GLU_FILL);
					bolita.draw(3.0f, 20, 20);
				GL11.glPopMatrix();
			}
			
		    /*-----------Other particles-------------------*/
		    if(showAll)
			{
				for(int i=0;i<trajectories.length;i++)
				{
					if(frame<trajectories[i][0].length)
					{				
						GL11.glPushMatrix();			
							GL11.glTranslatef(trajectories[i][1][frame], trajectories[i][2][frame]*1000, trajectories[i][0][frame]);
							bolita = new Sphere();      
				        	bolita.setDrawStyle(GLU.GLU_FILL);
				        	bolita.draw(2.0f, 20, 20);
				        GL11.glPopMatrix();			
					}
				}
			}
			
		}
		GL11.glDisable(GL11.GL_LIGHTING);
		if(showTrajectories)
		{
			/*---------------------------------Trajectories-----------------------------------*/	
			/*----------Selected Traj-------------------*/		
			GL11.glColor3f(1.0f, 0.0f, 1.0f);
			GL11.glLineWidth(3.0f);
			GL11.glBegin(GL11.GL_LINE_STRIP);
			for(int i=0;i<nFrames && i<trayectoria[0].length;i++)
			{
				GL11.glVertex3f(trayectoria[1][i], trayectoria[2][i]*1000, trayectoria[0][i]);
			}
			GL11.glEnd();
		    
			/*-----------Other trajs-------------------*/
			if(showAll)
			{
				GL11.glColor3f(1.0f, 1.0f, 1.0f);
				GL11.glLineWidth(2.0f);
				for(int i=0;i<trajectories.length;i++)
				{
					GL11.glBegin(GL11.GL_LINE_STRIP);
					for(int j=0;j<nFrames && j<trajectories[i][0].length;j++)
					{
						GL11.glVertex3f(trajectories[i][1][j], trajectories[i][2][j]*1000, trajectories[i][0][j]);
					}
					GL11.glEnd();			
				}
			}
		}
		
		
			
		frame = frame<nFrames ? frame+1 : 0;
	}
	private void box()
	{
		GL11.glPushMatrix();
			GL11.glBegin(GL11.GL_LINE_STRIP);
				GL11.glVertex3f(0.0f, 0.0f, 0.0f);
				GL11.glVertex3f(0.0f, 0.0f, height);
				GL11.glVertex3f(height, 0.0f, height);
				GL11.glVertex3f(height, 0.0f, 0.0f);
				GL11.glVertex3f(0.0f, 0.0f, 0.0f);
			GL11.glEnd();
			GL11.glBegin(GL11.GL_LINE_STRIP);
				GL11.glVertex3f(0.0f, 10.0f, 0.0f);
				GL11.glVertex3f(0.0f, 10.0f, height);
				GL11.glVertex3f(height, 10.0f, height);
				GL11.glVertex3f(height, 10.0f, 0.0f);
				GL11.glVertex3f(0.0f, 10.0f, 0.0f);
			GL11.glEnd();
			GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex3f(0.0f, 0.0f, 0.0f);
				GL11.glVertex3f(0.0f, 10.0f, 0.0f);
				
				GL11.glVertex3f(0.0f, 0.0f, height);
				GL11.glVertex3f(0.0f, 10.0f, height);
				
				GL11.glVertex3f(height, 0.0f, height);
				GL11.glVertex3f(height, 10.0f, height);
				
				GL11.glVertex3f(height, 0.0f, 0.0f);
				GL11.glVertex3f(height, 10.0f, 0.0f);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	private void planes()
	{
		GL11.glPushMatrix();		
		GL11.glLineWidth(0.5f);
		//XY
		GL11.glBegin(GL11.GL_LINES);
		for(int i=0;i<5;i++)
		{
			GL11.glVertex3f(   0.0f, (float)i,0.0f);
			GL11.glVertex3f(   5.0f, (float)i,0.0f);
			GL11.glVertex3f((float)i,    0.0f,0.0f);
			GL11.glVertex3f((float)i,    5.0f,0.0f);
		}
		GL11.glEnd();
		
		//YZ
		GL11.glBegin(GL11.GL_LINES);
		for(int i=0;i<5;i++)
		{
			GL11.glVertex3f(0.0f, (float)i,    0.0f);
			GL11.glVertex3f(0.0f, (float)i,    5.0f);
			GL11.glVertex3f(0.0f,     0.0f,(float)i);
			GL11.glVertex3f(0.0f,     5.0f,(float)i);
		}
		GL11.glEnd();

		//XZ		
		GL11.glBegin(GL11.GL_LINES);
		for(int i=0;i<5;i++)
		{
			GL11.glVertex3f((float)i, 0.0f,    0.0f);
			GL11.glVertex3f((float)i, 0.0f,    5.0f);
			GL11.glVertex3f(    0.0f, 0.0f,(float)i);
			GL11.glVertex3f(    5.0f, 0.0f,(float)i);
		}
		GL11.glEnd();
		
		//YZ
		GL11.glBegin(GL11.GL_LINES);
		for(int i=0;i<5;i++)
		{
			GL11.glVertex3f(5.0f, (float)i,    0.0f);
			GL11.glVertex3f(5.0f, (float)i,    5.0f);
			GL11.glVertex3f(5.0f,     0.0f,(float)i);
			GL11.glVertex3f(5.0f,     5.0f,(float)i);
		}
		GL11.glEnd();
	GL11.glPopMatrix();
		
	}
	private void lines()
	{
		GL11.glPushMatrix();
			GL11.glBegin(GL11.GL_LINES);
			for(int i=0;i<20;i++)
			{
				//Paralelas eje Z
				GL11.glVertex3f( i, 0,   0.0f);
				GL11.glVertex3f( i, 0,  20.0f);
				
				//Paralelas eje X
				GL11.glVertex3f(  0.0f, 0.0f, i);
				GL11.glVertex3f( 20.0f, 0.0f, i);				
			}
			GL11.glEnd();
		GL11.glPopMatrix();
		
	}
	private void axis()
	{
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_LINES);			
			//Eje X
			GL11.glColor3f(1.0f, 0.0f, 0.0f);
			GL11.glVertex3f(0.0f, 0,  0.0f);
			GL11.glVertex3f(50.0f, 0,  0.0f);
			
			//Eje Y
			GL11.glColor3f(0.0f, 1.0f, 0.0f);
			GL11.glVertex3f(0.0f, -20.0f, 0.0f);
			GL11.glVertex3f(0.0f,  20.0f, 0.0f);
			
			//Eje Z
			GL11.glColor3f(0.0f, 0.0f, 1.0f);
			GL11.glVertex3f(0.0f, 0.0f,  0.0f);
			GL11.glVertex3f(0.0f, 0.0f, 50.0f);			
			
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	private static FloatBuffer allocFloats(float[] floatarray) 
	{
		FloatBuffer fb = ByteBuffer.allocateDirect(floatarray.length * SIZE_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer();
	    fb.put(floatarray).flip();
	    return fb;
    }
	private void glPrint(String msg) 
	{                                      // Custom GL "Print" Routine
        if(msg != null) 
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
            for(int i=0;i<msg.length();i++) 
            {
                GL11.glCallList(msg.charAt(i));
                GL11.glTranslatef(0.05f, 0.0f, 0.0f);
            }
        }
    }
}
