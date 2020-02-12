package hu.exth.l4tgt.model.Textures;




public abstract class Texture {
	private String textureGroup;
	private String textureName;
	private String URL;
	private int Id;
	


	
	public Texture() {}
	public String getTextureName() {return textureName;}
	public void setTextureName(String t) {this.textureName=t;}
	


	public int getId() {return Id;};
	public void setId(int newi) {this.Id=newi;};

	public String getTextureGroup() {return this.textureGroup;}
	public void setTextureGroup(String g) {this.textureGroup=g;}
	
	public String getURL() {return this.URL;}


}
