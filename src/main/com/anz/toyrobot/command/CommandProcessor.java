package main.com.anz.toyrobot.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;



public class CommandProcessor {
	
	 private ArrayList<String> commandList;
	
	 Pattern placeCommand = Pattern.compile("^PLACE\\b\\s\\d,\\d,\\b(NORTH|SOUTH|EAST|WEST)$");
	 Pattern leftCommand = Pattern.compile("^LEFT$");
	 Pattern rightCommand = Pattern.compile("^RIGHT$");
	 Pattern moveCommand = Pattern.compile("^MOVE$");
	 Pattern reportCommand = Pattern.compile("^REPORT$");
	 
	 private String inputFilePath;
	 
	 public CommandProcessor(String filepath){
		this.inputFilePath=filepath; 
		commandList=new ArrayList<String>();
	 }
	
	
	public void processCommands(){
		Charset charset = Charset.forName("US-ASCII");
		Path file=Paths.get(System.getProperty("user.home"),inputFilePath);
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        
		        if(isValidCommand(line)){
		        	if(line.contains("PLACE")||commandList.size()!=0){
		        	saveCommand(line);
		        	System.out.println(line);
		        	}
		        }
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public ArrayList<String> getCommands(){
		return commandList;
	}
	
	private void saveCommand(String command){
		commandList.add(command);
	}
	
	private boolean isValidCommand(String value){
		
		return placeCommand.matcher(value).matches()||
				leftCommand.matcher(value).matches()||
				rightCommand.matcher(value).matches()||
				moveCommand.matcher(value).matches()||
				reportCommand.matcher(value).matches();
		
	}

}
