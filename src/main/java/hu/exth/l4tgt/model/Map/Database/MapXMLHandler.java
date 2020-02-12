package hu.exth.l4tgt.model.Map.Database;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import hu.exth.l4tgt.model.Map.Map;
import hu.exth.l4tgt.model.Map.MapTile;
import hu.exth.l4tgt.model.Map.MapTileTextureType;
import hu.exth.l4tgt.model.Map.MapTileTextures;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import hu.exth.l4tgt.model.Map.Direction.MovementType;
import hu.exth.l4tgt.model.Map.Direction.Movements;

public class MapXMLHandler {

	
	
   public static void savePathMap(String outputPath, Map mymap) {
	   
      try{
    	  Element pathmap = new Element("Pathmap");

    	pathmap.setAttribute("width",((Integer)mymap.getWidth()).toString());
       	pathmap.setAttribute("height", ((Integer)mymap.getHeight()).toString());
        
        if(mymap.getName()==null)
        	pathmap.setAttribute("name","");
        else
        	pathmap.setAttribute("name",mymap.getName());
         Document doc = new Document(pathmap);

         
         for(MapTile mt:mymap.getMap())
         {
        Element maptile=new Element("Maptile");
        maptile.setAttribute("x",((Integer)mt.getX()).toString());
        maptile.setAttribute("y",((Integer)mt.getY()).toString());
        pathmap.addContent(maptile);
        	
        	Element up= new Element("Up");
        	up.setText(mt.getMovements().getUp().toString());
        	maptile.addContent(up);
        	
        	Element down= new Element("Down");
        	down.setText(mt.getMovements().getDown().toString());
        	maptile.addContent(down);
        	
        	Element left= new Element("Left");
        	left.setText(mt.getMovements().getLeft().toString());
        	maptile.addContent(left);
        	
        	Element right= new Element("Right");
        	right.setText(mt.getMovements().getRight().toString());
        	maptile.addContent(right);
        	
         }
        
         XMLOutputter xmlOutput = new XMLOutputter();

         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutput.output(doc, new FileWriter(outputPath)); 

      } catch(IOException e) {

         e.printStackTrace();
      }
   }

   
   
   public static void LoadPathMap(String input,Map mymap){
	   int width=0;
	   int height=0;
	   String name="";
	   try {
		   
	         File inputFile = new File(input);
	         SAXBuilder saxBuilder = new SAXBuilder();
	         Document document = saxBuilder.build(inputFile);
	         Element classElement = document.getRootElement();
	         
	        width=Integer.parseInt( classElement.getAttribute("width").getValue());
	        height=Integer.parseInt( classElement.getAttribute("height").getValue());
	        name=classElement.getAttribute("name").getValue();
	        
	        if(mymap.getWidth()!=width || mymap.getHeight()!=height) {return ;}
	        //mymap.setName(name);
	         List<Element> pathmap = classElement.getChildren("Maptile");
	         for (Element maptile :pathmap) 
	         {    
	        	 int x=Integer.parseInt(maptile.getAttribute("x").getValue());
	        	 int y=Integer.parseInt(maptile.getAttribute("y").getValue());
	        	 Movements movements=new Movements();
	        	movements.setUp(MovementType.valueOf(maptile.getChild("Up").getText()));
	        	movements.setDown(MovementType.valueOf(maptile.getChild("Down").getText()));
	        	movements.setLeft(MovementType.valueOf(maptile.getChild("Left").getText()));
	        	movements.setRight(MovementType.valueOf(maptile.getChild("Right").getText()));
	        	mymap.getMap().get(x+y*width).setMovements(movements);
	         }
	         
	    } catch(JDOMException e) {
	         e.printStackTrace();
	    } catch(IOException ioe) {
	         ioe.printStackTrace();
	    }
	   
   }
   
   
   

	  
   public static void saveTextureMap(String outputPath,Map mymap) {
	   
	      try{
	    	  Element texhmap = new Element("Texturemap");

	    	  texhmap.setAttribute("width",((Integer)mymap.getWidth()).toString());
	    	  texhmap.setAttribute("height", ((Integer)mymap.getHeight()).toString());
	        
	        if(mymap.getName()==null)
	        	texhmap.setAttribute("name","");
	        else
	        	texhmap.setAttribute("name",mymap.getName());
	         Document doc = new Document(texhmap);

	         
	         for(MapTile mt:mymap.getMap()) 
	         {
	        Element maptile=new Element("Maptile");
	        maptile.setAttribute("x",((Integer)mt.getX()).toString());
	        maptile.setAttribute("y",((Integer)mt.getY()).toString());
	        texhmap.addContent(maptile);
	        	
		        Element textures=new Element("Textures");
		        if(mt.getTextures().getBaseTexture()==null)
		        	textures.setAttribute(MapTileTextureType.base.toString(),"");
		        else
		        	textures.setAttribute(MapTileTextureType.base.toString(),mt.getTextures().getBaseTexture().toString());
		        
		        if(mt.getTextures().getUnderlapTexture()==null)
		        	textures.setAttribute(MapTileTextureType.underlap.toString(),"");
		        else
		        	textures.setAttribute(MapTileTextureType.underlap.toString(),mt.getTextures().getUnderlapTexture().toString());
		        
		        if(mt.getTextures().getMiddleTexture()==null)
		        	textures.setAttribute(MapTileTextureType.middle.toString(),"");
		        else
		        	textures.setAttribute(MapTileTextureType.middle.toString(),mt.getTextures().getMiddleTexture().toString());
		        
		        if(mt.getTextures().getOverlapTexture()==null)
		        	textures.setAttribute(MapTileTextureType.overlap.toString(),"");
		        else 
		        	textures.setAttribute(MapTileTextureType.overlap.toString(),mt.getTextures().getOverlapTexture().toString());
		        
	        maptile.addContent(textures);
	         }
	        
	         XMLOutputter xmlOutput = new XMLOutputter();

	         xmlOutput.setFormat(Format.getPrettyFormat());
	         xmlOutput.output(doc, new FileWriter(outputPath)); 

	      } catch(IOException e) {

	         e.printStackTrace();
	      }
	   }
   
   public static void loadTextureMap(String input,Map mymap) {
	   
	   int width=0;
	   int height=0;
	   String name="";
	   try {
		   
	         File inputFile = new File(input);
	         SAXBuilder saxBuilder = new SAXBuilder();
	         Document document = saxBuilder.build(inputFile);
	         Element classElement = document.getRootElement();
	         
	        width=Integer.parseInt( classElement.getAttribute("width").getValue());
	        height=Integer.parseInt( classElement.getAttribute("height").getValue());
	        name=classElement.getAttribute("name").getValue();
	        
	        if(mymap.getWidth()!=width || mymap.getHeight()!=height) {return ;}
	        //mymap.setName(name);
	         List<Element> texmap = classElement.getChildren("Maptile");
	         for (Element maptile :texmap) 
	         {    
	        	 int x=Integer.parseInt(maptile.getAttribute("x").getValue());
	        	 int y=Integer.parseInt(maptile.getAttribute("y").getValue());
	        	 MapTileTextures texs=new MapTileTextures();
	        	 
	        	if(maptile.getChild("Textures").getAttribute("base").getValue().equals("")) 
	        		texs.setBaseTexture(null);
	        	else
	        		texs.setBaseTexture(Integer.parseInt(maptile.getChild("Textures").getAttribute(MapTileTextureType.base.toString()).getValue()));
	        	
	        	if(maptile.getChild("Textures").getAttribute("underlap").getValue().equals("")) 
	        		texs.setUnderlapTexture(null);
	        	else
	        		texs.setUnderlapTexture(Integer.parseInt(maptile.getChild("Textures").getAttribute(MapTileTextureType.underlap.toString()).getValue()));
	        	
	        	if(maptile.getChild("Textures").getAttribute("middle").getValue().equals("")) 
	        		texs.setMiddleTexture(null);
	        	else
	        		texs.setMiddleTexture(Integer.parseInt(maptile.getChild("Textures").getAttribute(MapTileTextureType.middle.toString()).getValue()));
	        	
	        	if(maptile.getChild("Textures").getAttribute("overlap").getValue().equals("")) 
	        		texs.setOverlapTexture(null);
	        	else
	        		texs.setOverlapTexture(Integer.parseInt(maptile.getChild("Textures").getAttribute(MapTileTextureType.overlap.toString()).getValue()));
	        	
	        	
	        	
	        	mymap.getMap().get(x+y*width).setTextures(texs);
	         }
	         
	    } catch(JDOMException e) {
	         e.printStackTrace();
	    } catch(IOException ioe) {
	         ioe.printStackTrace();
	    }
	   
	
   
   
   }
   
}
 

   
   

   
   

   
   
   
   
   
   
   
   
   
   
   
