package tp.p3.control.command;

import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class ListCommand extends Command {

	public ListCommand() {
		super("LIST", "[L]ist", "Prints the list of available plants");
	}

	@Override
	public boolean execute(Game game) {
		game.list();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();
		
		if(commandWords[0].equals("L")|| commandWords[0].equals("LIST")) {
			if(commandWords.length > 1) {
				throw new CommandParseException("List command has no arguments");
			}
			command = new ListCommand();
		}
		return command;
	}

}
