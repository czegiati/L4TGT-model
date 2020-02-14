package hu.exth.l4tgt.controller;

public interface CameraController {

    int getOffTilesX();
    int getOffTilesY();
    int getOffPixelX();
    int getOffPixelY();

    default void setKeyFunctions(Object... objects){
        setKeyFunctionsArray(objects);
    }

    void setKeyFunctionsArray(Object[] objects);

}