package hu.exth.l4tgt.model.Map;

import hu.exth.l4tgt.model.Map.Direction.Movements;
import hu.exth.l4tgt.model.Textures.Texture;
import hu.exth.l4tgt.model.config.ConfigurationHandler;

public class MapTile {
	
private int x;
private int y;
MapTileTextures textures=new MapTileTextures();
private Movements movements=new Movements();

 public MapTile(int x1, int y1){
	 x=x1;
	 y=y1; 
	 
 }
 public MapTile(){textures.setBaseTexture(ConfigurationHandler.config.getTextureHandler().getIdByName("nothing"));x=0;y=0;}
 public MapTile( int a){textures=new MapTileTextures();;x=0;y=0;}
 public MapTile(MapTile mapt, Texture textur){textures=mapt.getTextures();x=mapt.getX(); y=mapt.getY();}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public void setX(int newX) {x=newX;}
public void setY(int newY) {y=newY;}


public Movements getMovements() {
	return movements;
}
public void setMovements(Movements movements) {
	this.movements = movements;
}
public MapTileTextures getTextures() {
	return textures;
}
public void setTextures(MapTileTextures textures) {
	this.textures = textures;
}

}
