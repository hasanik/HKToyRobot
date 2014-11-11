package main.com.anz.toyrobot.model;

public class Position {
	private int currentX;
	private int currentY;
	
	public Position(int xposition,int yposition){
		currentX=xposition;
		currentY=yposition;
	}
	public int getX() {
		return currentX;
	}
	public void setX(int x) {
		this.currentX = x;
	}
	public int getY() {
		return currentY;
	}
	public void setY(int y) {
		this.currentY = y;
	}
	
	
}
