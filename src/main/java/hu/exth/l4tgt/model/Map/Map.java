package hu.exth.l4tgt.model.Map;
import java.util.ArrayList;
import java.util.List;


public class Map {

	private List<MapTile> Map;
	private int width;
	private int height;
	private String Name;
	
	public Map(int size) {generateEmptyMap(size);}
	
	public void generateEmptyMap(int size){
		List<MapTile> map=new ArrayList<MapTile>();
		for(int y=0; y<size ; y++) {
			for(int x=0;x<size;x++) {
				MapTile mtile= new MapTile(x,y);
				if(x==2 && y==2)
					mtile.getTextures().setBaseTexture(2);
				
				
				map.add(mtile);
				
			}
			}
		width=size;
		height=size;
		Map= map;
	}
	
	public String getName() {return Name;}
	
	public void setName(String name) {this.Name=name;}
	
	public List<MapTile> getMap(){return Map;}
	

	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public MapTile get(int x,int y) {
		return this.Map.get(x+y*this.width);
	}
	public boolean isPresent(int x, int y) {
		boolean xr= (x>=0 && x< this.width);
		boolean yr= (y>=0 && y< this.height);
		if((x+y*this.width)>=0 && (x+y*this.width)< this.width*this.height && yr && xr)
		return true;
		else
		return false;
	}
	
	public boolean TextureisNotNull(int x, int y,MapTileTextureType a) {
		return this.Map.get(x+y*this.width).getTextures().get(a) !=null;
	}
		
}




