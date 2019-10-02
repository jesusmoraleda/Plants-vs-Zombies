package tp.p3.control.command;


import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class ResetCommand extends Command {

	public ResetCommand() {
		super("RESET", "[R]eset", "Starts a new game");
	}

	@Override
	public boolean execute(Game game) {
		game.reset();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();
		
		if(commandWords[0].equals("R")|| commandWords[0].equals("RESET")) {
			if(commandWords.length > 1) {
				throw new CommandParseException("reset command has no arguments");
			}
			command = new ResetCommand();
		}
		return command;
	}

}
