package main.com.anz.toyrobot.model;

import main.com.anz.toyrobot.exception.InvalidPositionException;



public class ToyRobot {
	private Position currentPosition;
	private Table currentTable;
	private Direction currentDirection;
	private boolean isPlaced;
	
	public ToyRobot(Table table,Position position,Direction direction){
		this.currentTable=table;
		this.currentPosition=position;
		this.currentDirection=direction;
		this.isPlaced=true;
	}
	
	public void place(Position position,Direction direction){
		setCurrentPosition(position);
		setCurrentDirection(direction);
	}
	
	public void move() throws InvalidPositionException{
		if(isPlaced){

			switch(currentDirection){
			case NORTH:
				//move up
				int nextPY=currentPosition.getY()+1;
				if(currentTable.isOnTableTop(nextPY)){
					currentPosition.setY(nextPY);
				}else{
					throw new InvalidPositionException("Invalid Position.Discarding Command.");
				}
				break;
			case EAST:
				//move right
				int nextPX=currentPosition.getX()+1;
				if(currentTable.isOnTableTop(nextPX)){
					currentPosition.setX(nextPX);
				}
				break;
			case SOUTH:
				//move down
				int nextNY=currentPosition.getY()-1;
				if(currentTable.isOnTableTop(nextNY)){
					currentPosition.setY(nextNY);
				}
				
				break;
			case WEST:
				//move left
				int nextNX=currentPosition.getX()-1;
				if(currentTable.isOnTableTop(nextNX)){
					currentPosition.setX(nextNX);
				}
				break;
			}
		}
		
	}
	
	public void left(){
		if(isPlaced){
			currentDirection=currentDirection.previous();
		}
	}
	
	public void right(){
		if(isPlaced){
			currentDirection=currentDirection.next();
		}
	}
	
	public void report(){
		System.out.println("Output:"+" "+currentPosition.getX()+","+currentPosition.getY()+","+currentDirection.toString());
	}
	
	
	public Position getCurrentPosition() {
		return currentPosition;
	}
	private void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Table getCurrentTable() {
		return currentTable;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}
	private void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}
	public boolean isPlaced() {
		return isPlaced;
	}

	

}
