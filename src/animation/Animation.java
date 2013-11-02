package animation;

import main.Thinker;
import data.Movie;
import direction.GUIDirection;

public class Animation 
{
	
	Thinker thinker;
	GUI3DAnimation gui;
	
	LwjglObject lwjglObject;
	
	
	public Animation(Thinker thinker)
	{
		this.thinker = thinker;
		gui = new GUI3DAnimation(this);
		gui.setLocation(thinker.gui.getX(),thinker.gui.getY());
		Movie movie = thinker.getParticleTracker().getMovie();
		lwjglObject = new LwjglObject(movie.getWidth(), movie.getHeight(), movie.getLenght(), thinker.getSelectedSet().getTrajs(), gui);
	}
	public void openGUI()
	{
		gui.setVisible(true);
		gui.setLocation(thinker.gui.getX(),thinker.gui.getY());
	}
	public void jButton_Show_clicked()
	{
		lwjglObject.resume();
	}

	public void updateGL()
	{
		Params3d params3d = gui.getParams3d();
		lwjglObject.setAntialiasing(params3d.isAntialiasing());
		lwjglObject.setLightning(params3d.isLightning());
		lwjglObject.setRadialDistance(params3d.getRadialDistance());
		lwjglObject.setVerticalAngle(params3d.getVerticalAngle());
		lwjglObject.setHorizontalAngle(params3d.getHorizontalAngle());
		lwjglObject.setShowAll(params3d.isShowAll());	
		lwjglObject.setShowParticles(params3d.isShowParticles());
		lwjglObject.setShowTrajectories(params3d.isShowTrajectories());
		
	}

}
