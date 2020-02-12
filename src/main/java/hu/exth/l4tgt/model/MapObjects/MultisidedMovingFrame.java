package hu.exth.l4tgt.model.MapObjects;

public class MultisidedMovingFrame extends MultisidedStandingFrame{

	protected int movingleft;
	protected int movingright;
	protected int movingup;
	protected int movingdown;
	protected int currentMoving;


	public MultisidedMovingFrame(int up, int down, int left, int right, int movingup, int movingdown, int movingleft,
			int movingright,int id) {
		super(up, down, left, right);
		this.movingleft = movingleft;
		this.movingright = movingright;
		this.movingup = movingup;
		this.movingdown = movingdown;

		currentMoving=movingdown;
	}
	public MultisidedMovingFrame(MultisidedMovingFrame a) {

		this.currentMoving=a.currentMoving;
		this.movingleft=a.movingleft;
		this.movingright=a.movingright;
		this.movingup=a.movingup;
		this.movingdown=a.movingdown;
		
		this.standLeftTextureId=a.standLeftTextureId;
		this.standRightTextureId=a.standRightTextureId;
		this.standUpTextureId=a.standUpTextureId;
		this.standDownTextureId=a.standDownTextureId;
		this.currentStandingId =a.currentStandingId;
	}
	
	public int getMovingleft() {
		return movingleft;
	}
	public void setMovingleft(int movingleft) {
		this.movingleft = movingleft;
	}
	public int getMovingright() {
		return movingright;
	}
	public void setMovingright(int movingright) {
		this.movingright = movingright;
	}
	public int getMovingup() {
		return movingup;
	}
	public void setMovingup(int movingup) {
		this.movingup = movingup;
	}
	public int getMovingdown() {
		return movingdown;
	}
	public void setMovingdown(int movingdown) {
		this.movingdown = movingdown;
	}

	public int getCurrentMoving() {
		return currentMoving;
	}

	public void setCurrentMoving(int currentMoving) {
		this.currentMoving = currentMoving;
	}
	

	

	



}
