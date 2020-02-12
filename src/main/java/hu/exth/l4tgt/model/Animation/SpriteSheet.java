package hu.exth.l4tgt.model.Animation;

import javafx.scene.image.Image;

public class SpriteSheet {
//progression: 	primary: right -> left
//				secondary: up -> down
private int id;
private String name;
private String URL;
private Image image;
private int singleFrameWidth;
private int singleFrameHeight;
private int numberOfSprites;
int fps=12;
boolean repeat=true;

public SpriteSheet(String URL, int number_of_sprites,int id,String name,int fps,boolean repeat,int size) {	
	this.repeat=repeat;
	this.fps=fps;
	this.id=id;
	this.name=name;
	this.URL=URL;
	image=new Image(URL);
	this.numberOfSprites=number_of_sprites;
	this.singleFrameHeight=(int)(image.getWidth()/(double)this.numberOfSprites);
	this.singleFrameWidth=(int)(image.getWidth()/(double)this.numberOfSprites);
	
}

public SpriteSheet(String URL, int number_of_sprites,int id,String name,int size) {	
	this.id=id;
	this.name=name;
	this.URL=URL;
	image=new Image(URL);
	this.numberOfSprites=number_of_sprites;
	this.singleFrameHeight=size;
	this.singleFrameWidth=size;
	
}

public int getX(int i) {	
	return(int)((double)(i*singleFrameWidth)%image.getWidth());
	
}
public int getY(int i) {
	return Math.floorDiv(i*numberOfSprites, (int)image.getWidth());
}

public Animation makeAnimation() {
	return new Animation(this);
}
public String getURL() {
	return URL;
}

public void setURL(String uRL) {
	URL = uRL;
}

public Image getImage() {
	return image;
}

public void setImage(Image image) {
	this.image = image;
}

public int getSingleFrameWidth() {
	return singleFrameWidth;
}

public void setSingleFrameWidth(int singleFrameWidth) {
	this.singleFrameWidth = singleFrameWidth;
}

public int getSingleFrameHeight() {
	return singleFrameHeight;
}

public void setSingleFrameHeight(int singleFrameHeight) {
	this.singleFrameHeight = singleFrameHeight;
}

public int getNumberOfSprites() {
	return numberOfSprites;
}

public void setNumberOfSprites(int numberOfSprites) {
	this.numberOfSprites = numberOfSprites;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getFps() {
	return fps;
}

public void setFps(int fps) {
	this.fps = fps;
}

public boolean getRepeat() {
	return repeat;
}

public void setRepeat(boolean repeat) {
	this.repeat = repeat;
}






}
