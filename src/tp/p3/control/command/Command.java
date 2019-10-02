package tp.p3.control.command;


import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public abstract class Command {
	private String helpText;
	private String commandText;
	protected final String commandName;
	
	public Command(String commandText, String commandInfo, String helpInfo){
		this.commandText = commandInfo;
		helpText = helpInfo;
		String[] commandInfoWords = commandText.split("\\s+");
		commandName = commandInfoWords[0];
	}
	/**
	Some commands may generate an error in the execute or parse methods.
	In the absence of exceptions , they must the tell the controller not to print the board
	 * @throws CommandExecuteException 
	 **/
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	public String helpText(){
		return " " + commandText + ": " + helpText;
	}
	// returns true if string argument is a valid filename
	public static boolean isValidFilename(String filename) { 
		try {
			Paths.get(filename);
			return true;
		}
		catch (InvalidPathException ipe) {
			return false;
		}
	}

	// returns true if file with that name exists (in which case, it may not be accessible )
	public static boolean fileExists(String filename) {
		try {
			Path path = Paths.get(filename);
			return Files.exists (path) && Files.isRegularFile(path);
		} 
		catch (InvalidPathException ipe) {
			return false; // filename invalid => file cannot exist
		}
	}

	// returns true if file wth that name exists and is readable
	public static boolean isReadable(String filename) {
		try {
			Path path = Paths.get(filename);
			return Files.exists (path) && Files.isRegularFile(path) && Files.isReadable(path);
		} 
		catch (InvalidPathException ipe) {
			return false; // filename invalid => file cannot exist , never mind be readable
		}
	}

}
