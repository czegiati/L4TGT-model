package hu.exth.l4tgt.model.MapObjects;

import hu.exth.l4tgt.model.Map.Map;
import hu.exth.l4tgt.model.Map.Direction.MovementDirection;

public abstract class MapObject {

    protected int id;
    protected int x;
    protected int y;
    protected int destinationX;
    protected int destinationY;
    protected volatile double movementIndicator=0.0;
    protected String mapName;

    protected int standUpTextureId;
    protected int standDownTextureId;
    protected int standRightTextureId;
    protected int standLeftTextureId;

    protected int movingUpId;
    protected int movingDownId;
    protected int movingRightId;
    protected int movingLeftId;
    
    protected int currentStandingId;
    protected int currentMovingId;


    public abstract void afterMoving();

    public void setFaceDirection(MovementDirection a) {
        switch(a) {
            case Up:
                setCurrentStandingId(this.getStandUpTextureId());
                this.setCurrentMovingId(this.getMovingUpId());
                break;

            case Down:
                this.setCurrentStandingId(this.getStandDownTextureId());
                this.setCurrentMovingId(this.getMovingDownId());
                break;

            case Left:
                this.setCurrentStandingId(this.getStandLeftTextureId());
                this.setCurrentMovingId(this.getMovingLeftId());
                break;

            case Right:
                this.setCurrentStandingId(this.getStandRightTextureId());
                this.setCurrentMovingId(this.getMovingRightId());
                break;
        }
    }

    public MovementDirection getFaceDirection() {
        if(this.getCurrentStandingId()== this.getStandUpTextureId())
            return MovementDirection.Up;
        else if(this.getCurrentStandingId()== this.getStandDownTextureId())
            return MovementDirection.Down;
        else if(this.getCurrentStandingId()== this.getStandLeftTextureId())
            return MovementDirection.Left;
        else
            return MovementDirection.Right;
    }

    public void moveToDirection(Map map, MovementDirection direction){
        if(setDestinationCoordinatesWithDirection(map,direction)){
           MovementThread t= new MovementThread(this,30);
           t.start();
        }
    }


    public boolean setDestinationCoordinatesWithDirection(Map map,MovementDirection direction){
        switch(direction){
            case Up:
                if(y-1>=0 && map.canMoveTo(this.x,this.y,direction)){
                    this.setDestinationY(this.getY()-1);
                    return true;
                }
                break;
            case Down:
                if(y+1<=map.getHeight()-1  && map.canMoveTo(this.x,this.y,direction)){
                    this.setDestinationY(this.getY()+1);
                    return true;
                }
                break;
            case Left:
                if(x-1>=0 && map.canMoveTo(this.x,this.y,direction)){
                    this.setDestinationX(this.getX()-1);
                    return true;
                }
                break;
            case Right:
                if(x+1<=map.getWidth()-1  && map.canMoveTo(this.x,this.y,direction)){
                    this.setDestinationX(this.getX()+1);
                    return true;
                }
                break;
        }
        return false;
    }

    
    public int getStandUpTextureId() {
        return standUpTextureId;
    }

    public void setStandUpTextureId(int standUpTextureId) {
        this.standUpTextureId = standUpTextureId;
    }

    public int getStandDownTextureId() {
        return standDownTextureId;
    }

    public void setStandDownTextureId(int standDownTextureId) {
        this.standDownTextureId = standDownTextureId;
    }

    public int getStandRightTextureId() {
        return standRightTextureId;
    }

    public void setStandRightTextureId(int standRightTextureId) {
        this.standRightTextureId = standRightTextureId;
    }

    public int getStandLeftTextureId() {
        return standLeftTextureId;
    }

    public void setStandLeftTextureId(int standLeftTextureId) {
        this.standLeftTextureId = standLeftTextureId;
    }

    public int getMovingUpId() {
        return movingUpId;
    }

    public void setMovingUpId(int movingUpId) {
        this.movingUpId = movingUpId;
    }

    public int getMovingDownId() {
        return movingDownId;
    }

    public void setMovingDownId(int movingDownId) {
        this.movingDownId = movingDownId;
    }

    public int getMovingRightId() {
        return movingRightId;
    }

    public void setMovingRightId(int movingRightId) {
        this.movingRightId = movingRightId;
    }

    public int getMovingLeftId() {
        return movingLeftId;
    }

    public void setMovingLeftId(int movingLeftId) {
        this.movingLeftId = movingLeftId;
    }

    public int getCurrentStandingId() {
        return currentStandingId;
    }

    public void setCurrentStandingId(int currentStandingId) {
        this.currentStandingId = currentStandingId;
    }

    public int getCurrentMovingId() {
        return currentMovingId;
    }

    public void setCurrentMovingId(int currentMovingId) {
        this.currentMovingId = currentMovingId;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    public double getMovementIndicator() {
        return movementIndicator;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
