package tp.p3.control.command;

import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;
import tp.p3.logic.factories.PlantFactory;

public class AddCommand extends Command {
	private String[] command;
	public AddCommand(String[] commandWords) {
		super("ADD","[A]dd","Add <plant> <x> <y>: Adds a plant in position x, y");
		command = commandWords;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		game.add(command);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		if(validCommand(commandWords)) {
			command = new AddCommand(commandWords);
		}
		return command;
	}

	public boolean validCommand(String[] commandWords) throws CommandParseException {
		boolean available_plants = false;
		
		if((commandWords[0].equals("A") || commandWords[0].equals("ADD"))) {
			if(commandWords.length != 4) {
				throw new CommandParseException("Incorrect number of arguments for add command: [A]dd <plant> <x> <y>");
			}
			for(int i = 0; i < PlantFactory.availablePlants.length; i++) {
				if(commandWords[1].equals(PlantFactory.availablePlants[i]) ||
						commandWords[1].equals(PlantFactory.a_of_availablePlants[i])) {
					available_plants = true;
				}
			}
			if (!available_plants) {
				throw new CommandParseException("Unknown plant name: " + commandWords[1]);
			}
			return true;
		}
		else return false;
		
	}

}
