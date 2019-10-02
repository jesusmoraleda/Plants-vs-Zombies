package tp.p3.control.command;


import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("HELP","[H]elp", "print this help message");
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("Available commands:");
		System.out.println(CommandParser.commandHelp());
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();
		
		if(commandWords[0].equals("H")|| commandWords[0].equals("HELP")) {
			if(commandWords.length > 1) {
				throw new CommandParseException("Help command has no arguments");
			}
			command = new HelpCommand();
		}
		return command;
	}

}
