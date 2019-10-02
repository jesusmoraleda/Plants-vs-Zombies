package tp.p3;

import tp.p3.control.Controller;
import tp.p3.exception.ArgumentException;
import tp.p3.logic.Game;
public class PlantsVsZombies {

	public static void main(String[] args) {
		try {
			if(args.length == 0 || args.length > 2) {
				throw new ArgumentException("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]");
			}
			if(!args[0].equals("EASY") && !args[0].equals("HARD") && !args[0].equals("INSANE")) {
				throw new ArgumentException("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
			}
		}
		catch(NumberFormatException ex){
			System.err.println("Introduced seed is not valid");
			System.err.println("The seed 0 and the EASY level will be used");
			args = new String[2];
			args[0] = "EASY";
			args[1] = "0";
		}
		catch(ArgumentException ex) {
			System.err.println(ex.getMessage());
			System.err.println("The seed 0 and the EASY level will be used");
			args = new String[2];
			args[0] = "EASY";
			args[1] = "0";
		}
		finally {
			Game game = new Game(args[0], args[1]);
			Controller control = new Controller(game);
			control.run();
		}
	}
}
