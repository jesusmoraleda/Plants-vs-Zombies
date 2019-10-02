package tp.p3.control.command;

import tp.p3.exception.CommandParseException;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String commandText, String commandInfo, String helpInfo) {
		super(commandText, commandInfo, helpInfo);
	}
	public Command parse(String[] commandWords)throws CommandParseException {
		return null;
	}
	

}
