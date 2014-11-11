package main.com.anz.toyrobot.model;

public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	private static Direction[] directions=values();
	
	public Direction next(){
		int nextOrdinal=this.ordinal()+1;
		if(nextOrdinal<directions.length){
			return directions[nextOrdinal];
		}else{
			return directions[0];
		}
	}
	
	public Direction previous(){
		int previousOrdinal=this.ordinal()-1;
		if(previousOrdinal>=0){
			return directions[previousOrdinal];
		}else{
			return directions[directions.length-1];
		}
	}
	
}
