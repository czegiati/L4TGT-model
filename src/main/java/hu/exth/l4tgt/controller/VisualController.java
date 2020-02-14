package hu.exth.l4tgt.controller;

public abstract class VisualController {

    protected int tileSize;
    protected int widthInTiles;
    protected int heightInTiles;

    protected CameraController cameraController;

    public VisualController(int tileSize, int widthInTiles, int heightInTiles, CameraController cameraController) {
        this.tileSize = tileSize;
        this.widthInTiles = widthInTiles;
        this.heightInTiles = heightInTiles;
        this.cameraController = cameraController;
    }

    public abstract void draw();
    public abstract void refresh();


}
