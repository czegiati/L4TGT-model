package hu.exth.l4tgt.model.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;


public class Animation {
SpriteSheet spriteSheet;
Timeline animationtime;
EventHandler<ActionEvent> event;
int current_image=0;


public Animation(SpriteSheet ss){
	event= e -> 
	{
		current_image++;
		if(current_image>= spriteSheet.getNumberOfSprites())	
		{
			current_image=0;
		}
	};
	
	this.spriteSheet=ss;
	animationtime = new Timeline();
	if(this.spriteSheet.getRepeat()) {
	animationtime.setCycleCount(Timeline.INDEFINITE);
	}
	else animationtime.setCycleCount(100);
	animationtime.getKeyFrames().add(
            new KeyFrame(Duration.millis(1000/this.spriteSheet.getFps()), event, new KeyValue[0]) );
	
	

	
}



public void StartAnimation() {
	animationtime.playFromStart();
}
public void StopAnimation() {
	animationtime.stop();
}

public void drawAnimation(GraphicsContext gc,int wheretodrawX,int wheretodrawY,int width,int height) {
	 gc.drawImage(
			this.spriteSheet.getImage(),
			this.spriteSheet.getX(current_image),
			this.spriteSheet.getY(current_image),
			this.spriteSheet.getSingleFrameWidth(),
			this.spriteSheet.getSingleFrameHeight(),
			wheretodrawX,
			wheretodrawY,
			width,
			height);
		}



public SpriteSheet getSpriteSheet() {
	return spriteSheet;
}



public void setSpriteSheet(SpriteSheet spriteSheet) {
	this.spriteSheet = spriteSheet;
}



public Timeline getAnimationtime() {
	return animationtime;
}



public void setAnimationtime(Timeline animationtime) {
	this.animationtime = animationtime;
}



public boolean isRepeat() {
	return this.spriteSheet.getRepeat();
}



public void setRepeat(boolean repeat) {
	this.spriteSheet.setRepeat(repeat);
}



public int getCurrent_image() {
	return current_image;
}



public void setCurrent_image(int current_image) {
	this.current_image = current_image;
}



}
