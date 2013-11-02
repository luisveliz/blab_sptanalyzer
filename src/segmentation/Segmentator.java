package segmentation;

import ij.IJ;
import simulator.Simulator;
import typeOfMotion.Evaluator;
import typeOfMotion.Fitter;
import typeOfMotion.GUI;
import data.Metrics;
import data.Particle;
import data.Trajectory;

public class Segmentator 
{
	final static int DIF = 0;
	final static int DEV = 1;
	final static int ASYM = 2;
	
	int nf = 5;
	int wMin;//odd
	int wMax;//odd
	
	int ndiff = 5;
	int ndev = 50;
	
	double[] dif;
	double[] dev;
	double[] asym;
	
	Trajectory traj;
	int length;
	
	GUI gui;
	
	public Segmentator(Trajectory traj, GUI gui)
	{
		this.gui = gui;
		
		Particle[] trajParticles = traj.getParticles();
		int nPoints = 20;
		int[] framess = new int[nPoints];
		for (int i = 0; i < framess.length; i++) {
			framess[i]=i+1;
		}

		//TODO revisar metricas!!!!!!
		Metrics metrics = new Metrics(traj.getMetrics().getFrameStep(),1,0,0);
		Particle[] inicio = Simulator.sim2stateTraj(0, trajParticles[0].getX(),trajParticles[0].getY(), nPoints-1, traj.getMicroD(), traj.getMicroD(), 0, 1, framess, metrics).getParticles();
		Particle[] end = Simulator.sim2stateTraj(0, trajParticles[trajParticles.length-1].getX(),trajParticles[trajParticles.length-1].getY(), nPoints-1, traj.getMicroD(), traj.getMicroD(), 0, 1, framess, metrics).getParticles();
		
		Particle[] nueva = new Particle[40+trajParticles.length];
		int[] frames = new int[nueva.length];
		for(int i=0;i<nueva.length;i++)
		{
			frames[i] = i+1;
			if(i<nPoints)
			{
				System.out.println("inicio i:"+i);
				nueva[i] = inicio[nPoints-1-i];
			}
			else if(i<nPoints+trajParticles.length)
			{
				System.out.println("traj i:"+i);
				nueva[i] = trajParticles[i-nPoints];
			}
			else
			{
				System.out.println("end i:"+i);
				nueva[i] = end[i-nPoints-trajParticles.length];
			}
		}
		this.traj = new Trajectory(0, nueva, frames, traj.getMetrics());
		length = this.traj.getLength();
	}
	
	public double[] getDif(int wMax, int wMin, int nf)
	{
		this.nf = nf;
		this.wMin = wMin;
		if(length*0.75<wMax)
			this.wMax = (int)(length*0.75);
		else
			this.wMax = wMax;
		dif = new double[traj.getParticles().length];
		calculate(DIF);
		return dif;
	}
	public double[] getDev(int wMax, int wMin, int ndiff, int ndev)
	{
		this.ndiff = ndiff;
		this.ndev = ndev;
		this.wMin = wMin;
		if(length*0.75<wMax)
			this.wMax = (int)(length*0.75);
		else
			this.wMax = wMax;
		dev = new double[traj.getParticles().length];
		calculate(DEV);
		return dev;
	}
	public double[] getAsym(int wMax, int wMin)
	{
		this.wMin = wMin;
		if(length*0.75<wMax)
			this.wMax = (int)(length*0.75);
		else
			this.wMax = wMax;
		asym = new double[traj.getParticles().length];
		calculate(ASYM);
		return asym;
	}
	
	private void calculate(int option)
	{		
		int minIndex = (wMin-1)/2;
		IJ.log("minIndex:"+minIndex);
		for(int i=0;i<length;i++)
		{
//			System.out.println("particle index:"+i);
			if(i<minIndex || i>=length-minIndex)
			{
//				System.out.println("0");
				switch(option)
				{
					case DIF:dif[i]=0;break;
					case DEV:dev[i]=0;break;
					case ASYM:asym[i]=0;break;
				}
			}
			else
			{
//				System.out.println("rolling window");
				rollingWindow(i, option);
			}
			switch(option)
			{
				case DIF:gui.jProgressBar_Dif_setValue((i+1)*100/length);break;
				case DEV:gui.jProgressBar_Dev_setValue((i+1)*100/length);break;
				case ASYM:gui.jProgressBar_Asym_setValue((i+1)*100/length);break;
			}
			
		}
	}
	public void rollingWindow(int particleIndex, int option)
	{
		int start, end;
		double[] tdif = new double[wMax-wMin+1];
		double[] tdev = new double[wMax-wMin+1];
		double[] tasym = new double[wMax-wMin+1];
		for(int i=wMin;i<=wMax;i++)
		{
//			System.out.println("window size:"+i);
			start = particleIndex-(i-1)/2;
			end = particleIndex+i/2;
//			System.out.println("start particle:"+start);
//			System.out.println("end particle:"+end);
			if(start<0 || end>traj.getLength() || traj.getNumOfRealParticlesBetween(start,end)<5)
			{
//				System.out.println("00");
				switch(option)
				{
					case DIF:tdif[i-wMin] = 50;break;
					case DEV:tdev[i-wMin] = 50;break;
					case ASYM:tasym[i-wMin] = 0;break;
				}
			}
			else
			{
//				System.out.println("subtraj");
				switch(option)
				{
					case DIF:tdif[i-wMin] = calculateDif(traj.getTempSubtraj(start, end));break;
					case DEV:tdev[i-wMin] = calculateDev(traj.getTempSubtraj(start, end));break;
					case ASYM:tasym[i-wMin] = calculateAsym(traj.getTempSubtraj(start, end));break;
				}
			}
		}
		switch(option)
		{
			case DIF:dif[particleIndex] = getMin(tdif);break;
			case DEV:dev[particleIndex] = getMin(tdev);break;
			case ASYM:asym[particleIndex] = getMin(tasym);break;
		}
	}
	
	private double calculateDif(Trajectory subtraj)
	{
		double[] result = Fitter.normalFitLM(getFirst(subtraj.getTimeLag(),nf),getFirst(subtraj.getMSD(),nf), false, true, getFirst(subtraj.getMSDVar(),nf));
		return result[0];		
	}
	private double calculateDev(Trajectory subtraj)
	{
		double[] timelag = subtraj.getTimeLag();
		double[] msd = subtraj.getMSD();
		double[] msdVar = subtraj.getMSDVar();
		double[] result = Fitter.normalFitLM(getFirst(timelag,ndiff),getFirst(msd,ndiff), false, true, getFirst(msdVar,ndiff));
		double[] linfit = Evaluator.funcNormal(timelag,result[0]); 
		
		double dev = 0;
		for(int i=0;i<ndev;i++)
		{
			dev +=  (msd[i]-linfit[i])/linfit[i];
			System.out.println("msd:"+msd[i]+" linfit:"+linfit[i]+" dev:"+dev);
		}
		
		return dev/ndev;		
	}
	private double calculateAsym(Trajectory subtraj)
	{
		int X=0;
		int Y=1;
//		int Z=2;
//		double[][] R = new double[3][3];
		double[][] R = new double[2][2];
		
		double[] x = subtraj.getX();
		double[] y = subtraj.getY();
//		double[] z = new double[x.length];
		
		double xavg = 0, yavg = 0, zavg = 0;
		double xxavg = 0, yyavg = 0, zzavg = 0;
		double xyavg = 0, xzavg = 0, yzavg = 0;
		
		for(int i=0;i<x.length;i++)
		{
			xavg+=x[i];
			yavg+=y[i];
//			zavg+=z[i];
			
			xxavg+=x[i]*x[i];
			yyavg+=y[i]*y[i];
//			zzavg+=z[i]*z[i];
			
			xyavg+=x[i]*y[i];
//			xzavg+=x[i]*1.0;
//			yzavg+=y[i]*1.0;
		}
		xavg/=x.length;yavg/=y.length;
//		zavg/=z.length;
		xxavg/=x.length;yyavg/=x.length;
//		zzavg/=x.length;
		xyavg/=x.length;xzavg/=x.length;yzavg/=x.length;
		
		R[X][X]= xxavg - xavg*xavg; 
		R[X][Y]= xyavg - xavg*yavg;
//		R[X][Z]= xzavg - xavg*1.0;
		
		R[Y][X]= R[X][Y];
		R[Y][Y]= yyavg - yavg*yavg;
//		R[Y][Z]= yzavg - yavg*1.0;
		
//		R[Z][X]= R[X][Z];
//		R[Z][Y]= R[Y][Z];
//		R[Z][Z]= zzavg - zavg*zavg;
//		R[Z][Z]= 1.0 - 1.0*1.0;
		/*Matrix Rtrix = new Matrix(R);
		EigenvalueDecomposition ed = Rtrix.eig();	
		double[] eigen = ed.getRealEigenvalues();
		double r1e = eigen[0];
		double r2e = eigen[1];
		System.out.println("eigenvalues getReal...: "+r1e+" "+r2e);*/
		
		double r1 = 0.5*((R[X][X]+R[Y][Y])+Math.sqrt((Math.pow(R[X][X]-R[Y][Y],2)+4*R[X][Y]*R[X][Y])));
		double r2 = 0.5*((R[X][X]+R[Y][Y])-Math.sqrt((Math.pow(R[X][X]-R[Y][Y],2)+4*R[X][Y]*R[X][Y])));
//		System.out.println("eigenvalues formula...: "+r1+" "+r2);
		/*if(r1<r2)return r1/r2;
		else return r2/r1;*/
		return Math.pow(r1-r2, 2)/Math.pow(r1+r2, 2);
		
//		double r3 = Math.pow(Math.sqrt(eigen[2]),2);
//		return -Math.log(1-(Math.pow((r1-r2),2)+Math.pow((r1-r3),2)+Math.pow((r2-r3),2))/(2*(r1+r2+r3)));		
	}
	private double getMin(double[] values)
	{
		double min = values[0];
		for(int i=0;i<values.length;i++)
			if(values[i]<min)min=values[i];
		return min;
	}
	private double getMax(double[] values)
	{
		double max =  values[0];
		for(int i=0;i<values.length;i++)
			if(values[i]>max)max=values[i];
		return max;
	}
	public double[] getFirst(double[] values, int n)
	{
		double[] first = new double[n];
		for(int i=0; i<n;i++)
			first[i] = values[i];
		return values;
	}
	
	public double[] getTime()
	{
		return traj.getTime();
	}
}
