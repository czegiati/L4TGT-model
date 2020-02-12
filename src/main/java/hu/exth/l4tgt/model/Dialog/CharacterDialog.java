package hu.exth.l4tgt.model.Dialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.exth.l4tgt.model.config.ConfigurationHandler;

public class CharacterDialog {


	int root;
	Map<Integer,ArrayList<Integer>> dialogConnections=new HashMap<>();
	Map<Integer,Integer> events=new HashMap<>();

public CharacterDialog(DialogElement startDialog) {
	this.root= ConfigurationHandler.config.getDialogHandler().getDialogId(startDialog);
}

public CharacterDialog(int startDialogID) {
	this.root=startDialogID;
}

public DialogElement getRoot() {
	return ConfigurationHandler.config.getDialogHandler().getDialogElementById(root);
}

public void setRoot(DialogElement root) {
	this.root = ConfigurationHandler.config.getDialogHandler().getDialogId(root);
}


	public ArrayList<Integer> getSubdialogIDs(int ID){
		return this.dialogConnections.get(ID);
	}

	public ArrayList<Integer> getKeys(){
		ArrayList<Integer> temp=new ArrayList<>();
		for(Integer i: dialogConnections.keySet())
		{
			temp.add(i);
		}
		return temp;
	}

	public ArrayList<DialogElement> getKeyElements(){
		ArrayList<DialogElement> elements=new ArrayList<>();
		for(int i: getKeys())
		{
			elements.add(ConfigurationHandler.config.getDialogHandler().getDialogElementById(i));
		}
		return elements;
	}

public List<DialogElement> getSubdialogs(int dialogId){
	return ConfigurationHandler.config.getDialogHandler().getSubdialogsOf(dialogId);
	}

	public List<DialogElement> getSubdialogs(DialogElement dialog){
		return ConfigurationHandler.config.getDialogHandler().getSubdialogsOf(ConfigurationHandler.config.getDialogHandler().getDialogId(dialog));
	}


public void addNewDialogConnection(int ID, int... subdialogs){
    if(!this.dialogConnections.keySet().contains(ID))
        new IllegalArgumentException("The given parent dialog should be first added to the dialogtree.");
		for(int i: subdialogs)
		{
			dialogConnections.get(ID).add(i);
		}
	}

public void addNewDialogConnection(DialogElement base,DialogElement... subdialogs){
    if(!this.dialogConnections.keySet().contains(ConfigurationHandler.config.getDialogHandler().getDialogId(base)))
        new IllegalArgumentException("The given parent dialog should be first added to the dialogtree.");
		for(DialogElement i: subdialogs)
		{
			dialogConnections.get(ConfigurationHandler.config.getDialogHandler().getDialogId(base)).add(ConfigurationHandler.config.getDialogHandler().getDialogId(i));
		}
	}

public void addNewDialogConnection(DialogElement base,ArrayList<DialogElement> subdialogs){
    if(!this.dialogConnections.keySet().contains(ConfigurationHandler.config.getDialogHandler().getDialogId(base)))
        new IllegalArgumentException("The given parent dialog should be first added to the dialogtree.");
		for(DialogElement i: subdialogs)
		{
			dialogConnections.get(ConfigurationHandler.config.getDialogHandler().getDialogId(base)).add(ConfigurationHandler.config.getDialogHandler().getDialogId(i));
		}
	}

public void addDialogElement(DialogElement dialogElement){
    this.dialogConnections.put(ConfigurationHandler.config.getDialogHandler().getDialogId(dialogElement),new ArrayList<>());
}

public void addDialogElement(int ID){
    this.dialogConnections.put(ID,new ArrayList<>());
}

public void deleteDialogConnection(int ID,int... toBeRemoved){
		for(Integer i: toBeRemoved)
		{
			dialogConnections.get(ID).remove(i);
		}
	}

public void removeDialogElement(int ID){
    this.dialogConnections.remove(ID);
    for(int i: dialogConnections.keySet()){
    	if(dialogConnections.get(i).contains(ID))
		{
			dialogConnections.get(i).remove((Integer)ID);
		}
	}
}
public ArrayList<Integer> getAllDialogElements() {
		ArrayList<Integer> elements = new ArrayList<>();

		for (Integer entryKey : this.dialogConnections.keySet()) {
			Integer temp=entryKey;
			if(!elements.contains(temp))
				elements.add(temp);
			for (Integer subDialogID : this.dialogConnections.get(entryKey)) {
				temp=subDialogID;
				if(!elements.contains(temp))
					elements.add(temp);
			}
		}
		return elements;
	}

public void addEvent(int dialogElementID, int eventID){
	this.events.put(dialogElementID,eventID);
}

public void deleteEvent(int dialogElementID){
	this.events.remove(dialogElementID);
}

public Integer getEvent(int dialogID){
	if(!events.containsKey(dialogID))
		return null;
	return events.get(dialogID);
}

	@Override
public String toString() {
		String str= "CharacterDialog -> " +
				"root=" + root +
				",\n dialogConnections=" + dialogConnections+"\n";



		return str;
	}


}

