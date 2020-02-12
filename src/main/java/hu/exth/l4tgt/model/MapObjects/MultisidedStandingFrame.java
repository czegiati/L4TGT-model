package hu.exth.l4tgt.model.MapObjects;

public abstract class MultisidedStandingFrame {
	
protected int standUpTextureId;
protected int standDownTextureId;
protected int standRightTextureId;
protected int standLeftTextureId;
protected int currentStandingId;

public MultisidedStandingFrame(int up,int down,int left,int right){
	this.standDownTextureId=down;
	this.standLeftTextureId=left;
	this.standRightTextureId=right;
	this.standUpTextureId=up;
	currentStandingId =down;
}
public MultisidedStandingFrame() {}


public int getStandUpTextureId() {
	return standUpTextureId;
}


public void setStandUpTextureId(int standUpTextureId) {
	this.standUpTextureId = standUpTextureId;
}


public int getStandDownTextureId() {
	return standDownTextureId;
}


public void setStandDownTextureId(int standDownTextureId) {
	this.standDownTextureId = standDownTextureId;
}


public int getStandRightTextureId() {
	return standRightTextureId;
}


public void setStandRightTextureId(int standRightTextureId) {
	this.standRightTextureId = standRightTextureId;
}


public int getStandLeftTextureId() {
	return standLeftTextureId;
}


public void setStandLeftTextureId(int standLeftTextureId) {
	this.standLeftTextureId = standLeftTextureId;
}
public int getCurrentStandingId() {
	return currentStandingId;
}
public void setCurrentStandingId(int current) {
	this.currentStandingId = current;
}



}
