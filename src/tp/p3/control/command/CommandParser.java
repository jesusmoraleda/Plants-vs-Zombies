package tp.p3.control.command;

import tp.p3.exception.CommandParseException;

public class CommandParser {
	private static String[] commandWords;
	
	private static Command[] availableCommands = {new AddCommand(commandWords), new HelpCommand(),
	 new ResetCommand(), new ExitCommand(),new ListCommand(), new UpdateCommand(), new IntroCommand(), 
	 new PrintMode(commandWords), new SaveCommand(null), new LoadCommand(null) };
	
	
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		int i = 0;
		Command command = null;
		while(i < availableCommands.length) {
			command = availableCommands[i].parse(commandWords);
			if(command != null) {
				return command;
			}
			else i++;
		}
		return command;
	}
	public static String commandHelp() {
		String cadena = "";
		for (int i = 0; i < availableCommands.length; i++) {
			cadena += "    " + availableCommands[i].helpText() + '\n';
		}
		return cadena;
		
	}
}
