package hu.exth.l4tgt.model.Map.Direction;

import java.util.HashMap;

public class Movements {
	
	private HashMap<MovementDirection, MovementType> hashmap = new HashMap<MovementDirection, MovementType>();
	
	public Movements(){
		hashmap.put(MovementDirection.Up, MovementType.None);
		hashmap.put(MovementDirection.Down, MovementType.None);
		hashmap.put(MovementDirection.Left, MovementType.None);
		hashmap.put(MovementDirection.Right, MovementType.None);
	}
	
	public Movements(MovementType up,MovementType down,MovementType left,MovementType right){
		hashmap.put(MovementDirection.Up, up);
		hashmap.put(MovementDirection.Down, down);
		hashmap.put(MovementDirection.Left, left);
		hashmap.put(MovementDirection.Right, right);
	}
	
	 public void setUp(MovementType type) {
		 hashmap.remove(MovementDirection.Up);
		 hashmap.put(MovementDirection.Up, type);
	 }
	
	 public void setDown(MovementType type) {
		 hashmap.remove(MovementDirection.Down);
		 hashmap.put(MovementDirection.Down, type);
	 }
	
	 public void setLeft(MovementType type) {
		 hashmap.remove(MovementDirection.Left);
		 hashmap.put(MovementDirection.Left, type);
	 }
	 
	 public void setRight(MovementType type) {
		 hashmap.remove(MovementDirection.Right);
		 hashmap.put(MovementDirection.Right, type);
	 }
	 
		public void set(MovementDirection direction,MovementType type) {
			hashmap.remove(direction);
			 hashmap.put(direction, type);
		}
	 
	 public MovementType getUp() {
		 return hashmap.get(MovementDirection.Up);
	 }
	
	 public MovementType getDown() {
		 return hashmap.get(MovementDirection.Down);
	 }
	
	 public MovementType getLeft() {
		 return hashmap.get(MovementDirection.Left);
	 }
	 
	 public MovementType getRight() {
		 return hashmap.get(MovementDirection.Right);
	 }
	public MovementType get(MovementDirection direction) {
		return hashmap.get(direction);
	}

	@Override
	public String toString() {
		return "Movements [hashmap=" + hashmap + "]";
	}


	
	
}
