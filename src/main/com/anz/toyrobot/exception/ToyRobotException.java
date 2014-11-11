package main.com.anz.toyrobot.exception;

public class ToyRobotException extends Exception {
	int commandNumber;
	String invalidCommand;
	String message;

	public ToyRobotException(String message) {
        super(message);
        this.message=message;
    }	
	
	public void setCommandNumber(int number){
		this.commandNumber=number;
	}
	
	public void setCommand(String command){
		this.invalidCommand=command;
	}
	
	@Override
	public String getMessage(){
		StringBuilder sb=new StringBuilder();
		return sb.append("Command #: ").append(commandNumber).append(" - ").append(invalidCommand).append(" - ").append(message).toString();
		
	}
}
