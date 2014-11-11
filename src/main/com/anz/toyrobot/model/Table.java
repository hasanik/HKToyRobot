package main.com.anz.toyrobot.model;

public class Table {
	private int xmin;
	private int xmax;
	private int ymin;
	private int ymax;
	
	public Table(int width,int height){
		xmin=0;
		ymin=0;
		xmax=width;
		ymax=height;
		
	}
	
	public int getXmin() {
		return xmin;
	}

	public int getXmax() {
		return xmax;
	}

	public int getYmin() {
		return ymin;
	}

	public int getYmax() {
		return ymax;
	}

	
	public boolean isOnTableTop(int value){
		if(value<=getXmax() && value <=getYmax() && value >=getXmin() && value>=getYmin()){
			return true;
		}
		return false;
	}

}
