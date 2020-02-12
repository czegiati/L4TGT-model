package hu.exth.l4tgt.model.Textures;
import javafx.scene.image.Image;

public class Texture {
	private String textureGroup;
	private String textureName;
	private Image texture;
	private String URL;
	private int Id;
	
	public Texture(String textureName,Image texture,boolean iseffect,int id) {
		this.texture=texture;
		this.textureName=textureName;
		this.URL=texture.getUrl();
		this.Id=id;
		this.textureGroup="Other";
	}
	
	public Texture(int id,String group,String textureName,String path,boolean iseffect,boolean isicon,boolean isspecial) {
		this.texture=new Image(path);
		this.URL=path;
		this.textureName=textureName;
		this.Id=id;
		if(group==null) {this.textureGroup="Other";} else this.textureGroup=group;
	}
	
	public Texture() {}
	public String getTextureName() {return textureName;}
	public void setTextureName(String t) {this.textureName=t;}
	
	public Image getTexture() {return texture;};
	public void setTexture(Texture t) {this.texture=t.texture; this.URL=texture.getUrl();}

	public int getId() {return Id;};
	public void setId(int newi) {this.Id=newi;};

	public String getTextureGroup() {return this.textureGroup;}
	public void setTextureGroup(String g) {this.textureGroup=g;}
	
	public String getURL() {return this.URL;}
	public void setURL(String url) {this.texture=new Image(url); this.URL=url;}

}
