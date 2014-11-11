package test.com.anz.toyrobot;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.com.anz.toyrobot.Simulator;
import main.com.anz.toyrobot.command.CommandProcessor;

import org.junit.Before;
import org.junit.Test;

public class TestCommandProcessor {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_all_valid_commands() {
		CommandProcessor processor=new CommandProcessor("/Documents/workspace/HKToyRobot/src/resources/test_valid_commands_input.txt"); 
		processor.processCommands();
		
		ArrayList<String> commandList=processor.getCommands();
		assertEquals("number of Valid Commands 3", 3, commandList.size()); 
	}
	
	@Test
	public void test_invalid_commands() {
		CommandProcessor processor=new CommandProcessor("/Documents/workspace/HKToyRobot/src/resources/test_invalid_commands_input.txt"); 
		processor.processCommands();
		
		ArrayList<String> commandList=processor.getCommands();
		assertEquals("number of Valid Commands 2", 2, commandList.size()); 
	}
	
	@Test
	public void test_never_placed_on_table() {
		CommandProcessor processor=new CommandProcessor("/Documents/workspace/HKToyRobot/src/resources/test_never_placed_on_table.txt"); 
		processor.processCommands();
		
		ArrayList<String> commandList=processor.getCommands();

		assertEquals("number of Valid Commands 0", 0, commandList.size()); 
	}


}
