package test.com.anz.toyrobot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.com.anz.toyrobot.Simulator;
import main.com.anz.toyrobot.model.Direction;
import main.com.anz.toyrobot.model.Table;

import org.junit.Before;
import org.junit.Test;

public class TestValidScenario {
	static Table table;
	@Before
	public void setUp() throws Exception {
		table = new Table(5, 5);
	}

	@Test
	public void test_move_across(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 0,0,NORTH");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("LEFT");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("LEFT");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 5", 5, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 5", 5, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be East", Direction.EAST, Simulator.getRobot().getCurrentDirection()); 
     
	} 
	
	@Test
	public void test_scenario_one(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 0,0,WEST");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 0", 0, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 1", 1, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be North", Direction.NORTH, Simulator.getRobot().getCurrentDirection()); 
     
	} 
	
	@Test
	public void test_scenario_move_south(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 1,2,EAST");
		testCommands.add("MOVE");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("MOVE");
		testCommands.add("RIGHT");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 3", 3, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 1", 1, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be West", Direction.WEST, Simulator.getRobot().getCurrentDirection()); 
     
	} 
	
	@Test
	public void test_turn_360(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 4,4,NORTH");
		testCommands.add("LEFT");
		testCommands.add("LEFT");
		testCommands.add("LEFT");
		testCommands.add("LEFT");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 4", 4, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 4", 4, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be North", Direction.NORTH, Simulator.getRobot().getCurrentDirection()); 
     
	}
	
	@Test
	public void test_turn_360_right(){
		ArrayList<String> testCommands=new ArrayList<String>();
		testCommands.add("PLACE 4,4,NORTH");
		testCommands.add("RIGHT");
		testCommands.add("RIGHT");
		testCommands.add("RIGHT");
		testCommands.add("RIGHT");
		testCommands.add("RIGHT");
		testCommands.add("REPORT");
		
		Simulator.setTable(table);
		Simulator.simulate(testCommands);
		assertEquals("X Coordinate should be 4", 4, Simulator.getRobot().getCurrentPosition().getX()); 
		assertEquals("Y Coordinate should be 4", 4, Simulator.getRobot().getCurrentPosition().getY()); 
		assertEquals("Direction must be EAST", Direction.EAST, Simulator.getRobot().getCurrentDirection()); 
     
	}
	
	
	


}
