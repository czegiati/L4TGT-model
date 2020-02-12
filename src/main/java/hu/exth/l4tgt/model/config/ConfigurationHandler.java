package hu.exth.l4tgt.model.config;

import hu.exth.l4tgt.model.Dialog.interfaces.CharacterDialogHandler;
import hu.exth.l4tgt.model.MapObjects.MapObjectHandler;
import hu.exth.l4tgt.model.Textures.TextureHandler;
import hu.exth.l4tgt.model.Trigger.TriggerHandler;

/**
 * Manages all I/O handlers
 */
public abstract class ConfigurationHandler {

    public static ConfigurationHandler config;
    private CharacterDialogHandler dialogHandler;
    private MapObjectHandler mapObjectHandler;
    private TextureHandler textureHandler;
    private TriggerHandler triggerHandler;




    public static ConfigurationHandler getConfig() {
        return config;
    }

    public static void setConfig(ConfigurationHandler config) {
        ConfigurationHandler.config = config;
    }

    public CharacterDialogHandler getDialogHandler() {
        return dialogHandler;
    }

    public void setDialogHandler(CharacterDialogHandler dialogHandler) {
        this.dialogHandler = dialogHandler;
    }

    public MapObjectHandler getMapObjectHandler() {
        return mapObjectHandler;
    }

    public void setMapObjectHandler(MapObjectHandler mapObjectHandler) {
        this.mapObjectHandler = mapObjectHandler;
    }

    public TextureHandler getTextureHandler() {
        return textureHandler;
    }

    public void setTextureHandler(TextureHandler textureHandler) {
        this.textureHandler = textureHandler;
    }

    public TriggerHandler getTriggerHandler() {
        return triggerHandler;
    }

    public void setTriggerHandler(TriggerHandler triggerHandler) {
        this.triggerHandler = triggerHandler;
    }
}
