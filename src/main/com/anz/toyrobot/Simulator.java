package main.com.anz.toyrobot;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.com.anz.toyrobot.command.CommandProcessor;
import main.com.anz.toyrobot.exception.InvalidPositionException;
import main.com.anz.toyrobot.model.Direction;
import main.com.anz.toyrobot.model.Position;
import main.com.anz.toyrobot.model.Table;
import main.com.anz.toyrobot.model.ToyRobot;

public class Simulator {
	
	final static String INPUT_FILE_PATH="/Documents/workspace/HKToyRobot/src/resources/input.txt";
	static ToyRobot robot;
	static Position position;
	static Table table;
	static Direction direction;
	private static final Logger logger =
	        Logger.getLogger(Simulator.class.getName());

	public static void main(String[] args) {

		table = new Table(5, 5);
		CommandProcessor processor=new CommandProcessor(INPUT_FILE_PATH); 
		processor.processCommands();
		simulate(processor.getCommands());
		

	}

	public static ToyRobot placeRobot(int x, int y, Direction direction) {
		if (table.isOnTableTop(x) && table.isOnTableTop(y)) {
			if (robot == null) {
				position = new Position(x, y);
				robot = new ToyRobot(table, position, direction);
			} else {
				position.setX(x);
				position.setY(y);
				robot.place(position, direction);
			}
			return robot;

		}
		return null;
	}


	public static void simulate(ArrayList<String> commandList) {
		for (int i = 0; i < commandList.size(); i++) {
			String currentCommand=commandList.get(i);
			if (currentCommand.contains("PLACE")) {
				char x = currentCommand.charAt(6);
				char y = currentCommand.charAt(8);
				String direction = currentCommand.substring(10);
				robot = placeRobot(Character.getNumericValue(x),
						Character.getNumericValue(y),
						Direction.valueOf(direction));
			} else if (currentCommand.equals("MOVE")) {
					try{
						robot.move();
					}catch(InvalidPositionException ex){
						ex.setCommand(currentCommand);
						ex.setCommandNumber(i+1);
						logger.log(Level.INFO,ex.getMessage());
					}
						
			} else if (currentCommand.equals("LEFT")) {
				robot.left();
			} else if (currentCommand.equals("RIGHT")) {
				robot.right();
			} else if (currentCommand.equals("REPORT")) {
				robot.report();
			}
		}
	}
	
	public static ToyRobot getRobot(){
		return robot;
	}
	
	public static void setTable(Table ntable){
		table=ntable;
	}

}
