package tp.p3.control;

import java.util.Scanner;

import tp.p3.control.command.Command;
import tp.p3.control.command.CommandParser;
import tp.p3.control.command.UpdateCommand;
import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.CommandParseException;
import tp.p3.logic.Game;

public class Controller {
	private Game game;
	private Scanner in;
	private boolean print;

	public Controller(Game game) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.print = true;
	}

	public void run() {
		String[] words;
		Command command = null;
		Command commandUpdate = new UpdateCommand();
		
		System.out.println("Welcome to plantsVsZombies v3.0");
		System.out.println();
		this.game.getBoardPrinter().printGame(game);

		do {
			try {

				do {
					System.out.print("Command >");
					words = in.nextLine().toUpperCase().split(" ");
					command = CommandParser.parseCommand(words);
					if (command != null) {
						this.print = command.execute(game);
					}
					else {
						throw new CommandParseException("Unknown command " + words[0]);
					}

				}while(command == null);

				if(this.print) {
					game.ComputerAction();
					commandUpdate.execute(game);
					this.game.getBoardPrinter().printGame(game);
				}
			}
			catch(CommandParseException | CommandExecuteException ex) {
				System.err.println(ex.getMessage());
			}
		}while(!this.game.getExit() && !game.ZombiesWin() && !game.UserWins());
	}

	public void setPrint(boolean print) {
		this.print = print;
	}
	public Game getGame() {
		return this.game;
	}
	public void setGame(Game game) {
		this.game = game;
	}


}
