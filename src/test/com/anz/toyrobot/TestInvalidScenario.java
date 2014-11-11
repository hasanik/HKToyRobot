package test.com.anz.toyrobot;

import java.util.ArrayList;

import org.junit.Test;

import main.com.anz.toyrobot.Simulator;
import main.com.anz.toyrobot.exception.InvalidPositionException;
import main.com.anz.toyrobot.model.Direction;
import main.com.anz.toyrobot.model.Table;
import junit.framework.TestCase;

public class TestInvalidScenario extends TestCase {
	static Table table;
	protected void setUp() throws Exception {
		table = new Table(5, 5);
	}
	
	@Test
	public void test_out_of_table(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 1,2,EAST");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 5", 5, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 2", 2, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be East", Direction.EAST, Simulator.getRobot().getCurrentDirection()); 
     
	} 
	

	@Test
	public void test_start_at_PLACE(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("PLACE 1,2,EAST");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 3", 3, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 2", 2, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be East", Direction.EAST, Simulator.getRobot().getCurrentDirection()); 
     
	} 
	
	@Test
	public void test_ignore_invalid_commands(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("error");
		testCommands.add("PLACE 1,2,EAST");
		testCommands.add("MOVE");
		testCommands.add("error");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 2", 2, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 2", 2, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be East", Direction.EAST, Simulator.getRobot().getCurrentDirection()); 
     
	} 


}
