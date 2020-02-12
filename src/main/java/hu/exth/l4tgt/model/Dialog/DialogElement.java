package hu.exth.l4tgt.model.Dialog;

import java.util.List;
import java.util.stream.Collectors;

public class DialogElement {

private String start_dialog="";
private String answer_dialog="";



public DialogElement(String name,String dialog){
this.start_dialog=name;
this.answer_dialog=dialog;
}

public String getFirstDialog() {
	return start_dialog;
}

public void setFirstDialog(String name) {
	this.start_dialog = name;
}

public String getAnswerDialog() {
	return answer_dialog;
}

public void setAnswerDialog(String dialog) {
	this.answer_dialog = dialog;
}


public List<String> getNameOfSubDialogs(CharacterDialog cd){
		return cd.getSubdialogs(this).stream().map(o -> o.start_dialog).collect(Collectors.toList());
	}

@Override
public String toString() {
	return "[ " + start_dialog + "\n" + answer_dialog + " ]";
}




}
