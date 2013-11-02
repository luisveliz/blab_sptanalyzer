package animation;

public class Params3d 
{
	
	int radialDistance;
	int horizontalAngle;
	int verticalAngle;
	int fps;
	
	boolean antialiasing;
	boolean lightning;
	boolean showAll;
	boolean showParticles;
	boolean showTrajectories;
	
	public Params3d(int radialDistance, int verticalAngle, int horizontalAngle, 
			int fps, boolean antialiasing, boolean lightning, boolean showAll, 
			boolean showParticles, boolean showTrajectories)
	{
		this.radialDistance = radialDistance;
		this.horizontalAngle = horizontalAngle;
		this.verticalAngle = verticalAngle;
		this.fps = fps;
		
		this.antialiasing = antialiasing;
		this.lightning = lightning;
		this.showAll = showAll;
		this.showParticles = showParticles;
		this.showTrajectories = showTrajectories;
	}


	public boolean isShowParticles() {
		return showParticles;
	}


	public void setShowParticles(boolean showParticles) {
		this.showParticles = showParticles;
	}


	public boolean isShowTrajectories() {
		return showTrajectories;
	}


	public void setShowTrajectories(boolean showTrajectories) {
		this.showTrajectories = showTrajectories;
	}


	public int getRadialDistance() {
		return radialDistance;
	}


	public void setRadialDistance(int radialDistance) {
		this.radialDistance = radialDistance;
	}


	public int getHorizontalAngle() {
		return horizontalAngle;
	}


	public void setHorizontalAngle(int horizontalAngle) {
		this.horizontalAngle = horizontalAngle;
	}


	public int getVerticalAngle() {
		return verticalAngle;
	}


	public void setVerticalAngle(int verticalAngle) {
		this.verticalAngle = verticalAngle;
	}


	public int getFps() {
		return fps;
	}


	public void setFps(int fps) {
		this.fps = fps;
	}


	public boolean isAntialiasing() {
		return antialiasing;
	}


	public void setAntialiasing(boolean antialiasing) {
		this.antialiasing = antialiasing;
	}


	public boolean isLightning() {
		return lightning;
	}


	public void setLightning(boolean lightning) {
		this.lightning = lightning;
	}
	
	public boolean isShowAll() {
		return showAll;
	}


	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

}
