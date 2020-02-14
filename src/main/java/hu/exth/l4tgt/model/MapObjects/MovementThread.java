package hu.exth.l4tgt.model.MapObjects;

public class MovementThread extends Thread {


    private volatile MapObject mapObject;
    private static final int sleeptime=50;
    private int segments;
    private volatile double i;

    public MovementThread(MapObject o, int segments) {
        this.mapObject=o;
        this.segments=segments;
        //System.out.println("Journey started from ("+mapObject.getX()+","+mapObject.getY()+") to ("+mapObject.getDestinationX()+","+mapObject.getDestinationY()+")");

    }

    @Override
    public void run() {

        i=0.0;
        while(i<=1.0){
            System.out.println(i);
            mapObject.movementIndicator=i;
            i+=1.0/segments;
            try {
                sleep(sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mapObject.movementIndicator=0.0;
        mapObject.setX(mapObject.getDestinationX());
        mapObject.setY(mapObject.getDestinationY());
       // System.out.println("Journey ended on ("+mapObject.getX()+","+mapObject.getY()+")");
        mapObject.afterMoving();
    }

}
