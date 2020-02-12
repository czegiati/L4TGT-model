package hu.exth.l4tgt.model.Dialog.interfaces;

import hu.exth.l4tgt.model.Dialog.CharacterDialog;
import hu.exth.l4tgt.model.Dialog.DialogElement;

import java.util.List;

public interface CharacterDialogHandler {

    List<DialogElement> getSubdialogsOf(int rootId);
    DialogElement getDialogElementById(int rootId);
    int getDialogId(DialogElement element);

    CharacterDialog getCharacterDialogById(int id);
    int getCharacterDialog(CharacterDialog cd);
}
