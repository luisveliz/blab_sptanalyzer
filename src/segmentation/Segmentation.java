package segmentation;

import data.Trajectory;

public class Segmentation {
	
	
	
	/*---------------Automatic Segmentation-------------------*/
	public void jButton_CalculateDIF_clicked()
	{
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				Trajectory traj = thinker.getSelectedTraj();
				Segmentator segmentator = new Segmentator(traj, gui);
				traj.setDif(segmentator.getDif(gui.jSpinner_wMax_getValue(),gui.jSpinner_wMin_getValue(), gui.jSpinner_NF_getValue()));
				gui.getJFreeChart_SegmentationParams().setTime(segmentator.getTime());
				gui.getJFreeChart_SegmentationParams().setD(traj.getDif());
			}
		};
		Thread hilo = new Thread(run);
		hilo.start();
		
	}
	public void jButton_CalculateDEV_clicked()
	{
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				Trajectory traj = thinker.getSelectedTraj();
				Segmentator segmentator = new Segmentator(traj, gui);
				traj.setDev(segmentator.getDev(gui.jSpinner_DevWMax_getValue(),gui.jSpinner_DevWMin_getValue(), gui.jSpinner_Ndiff_getValue(),gui.jSpinner_NDev_getValue()));
				gui.getJFreeChart_SegmentationParams().setTime(segmentator.getTime());
				gui.getJFreeChart_SegmentationParams().setDev(traj.getDev());
			}
		};
		Thread hilo = new Thread(run);
		hilo.start();
	}
	public void jButton_CalculateASYM_clicked()
	{
		Runnable run = new Runnable() {
			@Override
			public void run() {
				Trajectory traj = thinker.getSelectedTraj();
				Segmentator segmentator = new Segmentator(traj, gui);
				traj.setAsym(segmentator.getAsym(gui.jSpinner_AsymWMax_getValue(),gui.jSpinner_AsymWMin_getValue()));
				gui.getJFreeChart_SegmentationParams().setTime(segmentator.getTime());
				gui.getJFreeChart_SegmentationParams().setAsym(traj.getAsym());
			}
		};
		Thread hilo = new Thread(run);
		hilo.start();
	}
	public void jButton_Segmentation_clicked()
	{
		
	}

}
