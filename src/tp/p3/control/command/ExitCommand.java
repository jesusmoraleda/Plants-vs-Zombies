package tp.p3.control.command;

import tp.p3.logic.Game;

public class ExitCommand extends Command {

	public ExitCommand() {
		super("EXIT", "[E]xit", "Terminate the game.");
	}

	@Override
	public boolean execute(Game game) {
		game.setExit(true);
		game.exit();
		return false;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();
	
		if(commandWords[0].equals("E")|| commandWords[0].equals("EXIT")) {
			command = new ExitCommand();
		}
		return command;
	}

}
