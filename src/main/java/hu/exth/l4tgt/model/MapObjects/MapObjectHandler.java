package hu.exth.l4tgt.model.MapObjects;

public interface MapObjectHandler {
    MapObject getMapObjectById(String name);
    boolean isDesignated(String name,int x,int y);
}
