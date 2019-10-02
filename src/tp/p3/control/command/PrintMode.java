package tp.p3.control.command;

import tp.p3.exception.CommandParseException;
import tp.p3.logic.DebugPrinter;
import tp.p3.logic.Game;
import tp.p3.logic.ReleasePrinter;

public class PrintMode extends Command{
	private String[] commandWords;
	public PrintMode(String[] commandWords) {
		super("PRINTMODE", "[P]rintmode <mode>", "change print mode [Release|Debug].");
		this.commandWords=commandWords;
	}

	@Override
	public boolean execute(Game game) {
		if(commandWords[1].equals("RELEASE")) {
			game.setBoardPrinter(new ReleasePrinter());
			//game.getBoardPrinter().printGame(game);
		}
		else if(commandWords[1].equals("DEBUG")) {
			game.setBoardPrinter(new DebugPrinter());
			//game.getBoardPrinter().printGame(game);
		}
		
		return true;
		
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();
		//commandWords[1] = commandWords[1].toUpperCase();
		if(commandWords[0].equals("P")|| commandWords[0].equals("PRINTMODE")) {
			if(commandWords.length != 2) {
				throw new CommandParseException("Incorrect number of arguments for printmode command: [P]rintMode release|debug");
			}
			
			if(commandWords[1].equals("RELEASE") || commandWords[1].equals("DEBUG")) {
				return  new PrintMode(commandWords);
			}
			else {
				throw new CommandParseException("Unknown print mode: " + commandWords[1]);
			}
			
		}
		return command;
	}

}
