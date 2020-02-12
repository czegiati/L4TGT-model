package hu.exth.l4tgt.model.Map;

import hu.exth.l4tgt.model.config.ConfigurationHandler;

import java.util.HashMap;

public class MapTileTextures {
private HashMap<MapTileTextureType,Integer> TileTextures=new  HashMap<MapTileTextureType,Integer>();

public MapTileTextures(){
	TileTextures.put(MapTileTextureType.base, ConfigurationHandler.getConfig().getTextureHandler().getIdByName("placeholder"));
	TileTextures.put(MapTileTextureType.underlap, null);
	TileTextures.put(MapTileTextureType.middle, null);
	TileTextures.put(MapTileTextureType.overlap, null);
}

public void setBaseTexture(Integer a) {
	TileTextures.remove(MapTileTextureType.base);
	TileTextures.put(MapTileTextureType.base, a);
}

public void setUnderlapTexture(Integer a ) {
	TileTextures.remove(MapTileTextureType.underlap);
	TileTextures.put(MapTileTextureType.underlap, a);
}

public void setMiddleTexture(Integer a) {
	TileTextures.remove(MapTileTextureType.middle);
	TileTextures.put(MapTileTextureType.middle, a);
}

public void setOverlapTexture(Integer a) {
	TileTextures.remove(MapTileTextureType.overlap);
	TileTextures.put(MapTileTextureType.overlap, a);
}

public Integer getBaseTexture() {
	return TileTextures.get(MapTileTextureType.base);
}

public Integer getUnderlapTexture() {
	return TileTextures.get(MapTileTextureType.underlap);
}

public Integer getMiddleTexture() {
	return TileTextures.get(MapTileTextureType.middle);
}

public Integer getOverlapTexture() {
	return TileTextures.get(MapTileTextureType.overlap);
}

public void set(MapTileTextureType type,Integer tex) {
	TileTextures.remove(type);
	TileTextures.put(type,tex);
}
public Integer get(MapTileTextureType type) {
	return TileTextures.get(type);
}

}
