package tp.p3.control.command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class LoadCommand extends Command{
	private String filename;

	public LoadCommand(String filename) {
		super("LOAD", "[Load]", "Load the game");
		this.filename = filename;

	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try{
			if(isReadable(filename)) {

				BufferedReader br = new BufferedReader(new FileReader(filename));

				if(br.readLine().equals("Plants Vs Zombies v3.0")) {
					if(br.readLine().equals("")) {
						if(game.load(br)) {
							System.out.println("Game successfully loaded in file " + filename);
						}
						else {
							System.err.println("Fallo al leer el archivo");
						}
						System.out.println();
						game.getBoardPrinter().printGame(game);
					}
					else throw new CommandExecuteException("missing the blank line");
				}
				else throw new CommandExecuteException("la cabecera no es correcta");




			}
			else throw new CommandExecuteException("File not found");
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

		if(commandWords[0].equals("LOAD")) {
			if(commandWords.length > 2) {
				throw new CommandParseException("Incorrect number of arguments for load");
			}
			command = new LoadCommand(commandWords[1]);
		}

		return command;
	}

}
