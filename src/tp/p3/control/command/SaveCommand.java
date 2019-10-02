package tp.p3.control.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class SaveCommand extends Command{
	private String filename;

	public SaveCommand(String filename) {
		super("SAVE", "[Save]", "Save the game");
		this.filename = filename;

	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try{
			this.filename = filename + ".dat";
			if(isValidFilename(filename)) {

				BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
				
				bw.write("Plants Vs Zombies v3.0" +"\r\n");
				bw.write("\r\n");
				
				game.store(bw);
				
				bw.close();
				System.out.println("Game successfully saved in file " + filename
						+ ". Use the load command to reload it");
				System.out.println();
				


			}
			else throw new CommandExecuteException("the filename contains invalid characters");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		//commandWords[0] = commandWords[0].toUpperCase();

		if(commandWords[0].equals("SAVE")) {
			if(commandWords.length > 2) {
				throw new CommandParseException("Incorrect number of arguments for save");
			}
			command = new SaveCommand(commandWords[1]);
		}

		return command;
	}


}
