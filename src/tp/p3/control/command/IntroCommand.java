package tp.p3.control.command;

import tp.p3.logic.Game;

public class IntroCommand extends Command {

	public IntroCommand() {
		super("Intro", "[Intro]", "Update the game without any user action.");
		
	}

	@Override
	public boolean execute(Game game) {
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command command = null;
		if(commandWords[0].equals("")) {
			command  = new IntroCommand();
		}
		return command;
	}

}
