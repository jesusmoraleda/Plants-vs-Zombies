package tp.p3.logic.factories;

import tp.p3.logic.Game;
import tp.p3.objects.plants.*;

public class PlantFactory {
	public static String[] a_of_availablePlants = { "S", "P", "C", "N"};
	public static String[] availablePlants = { "SUNFLOWER", "PEASHOOTER", "PETACEREZA", "NUEZ"};
	
	public static Plant getPlant(String plantName, Game game, int posx, int posy){
		if(plantName.equals("SUNFLOWER") || (plantName.equals("S"))) {
			return new Sunflower(game,posx,posy);
		}
		else if(plantName.equals("PETACEREZA") || plantName.equals("C")) {
			return new Petacereza(game,posx,posy);
		}
		else if(plantName.equals("NUEZ") || plantName.equals("N")) {
			return new Nuez(game,posx,posy);
		}
		else if(plantName.equals("PEASHOOTER") || plantName.equals("P")) {
			return new Peashooter(game,posx,posy);
		}
		else return null;
	}
	public static void listOfAvilablePlants() {
		for(int i = 0; i < availablePlants.length; i++) {
			if(availablePlants[i].equals("SUNFLOWER")) {
				System.out.println("[S]unflower: Cost: " + Sunflower.COST +" suncoins Harm: "+ Sunflower.HARM);
			}
			else if(availablePlants[i].equals("PETACEREZA")) {
				System.out.println("Peta[C]ereza: Cost: " + Petacereza.COST +" suncoins Harm: "+ Petacereza.HARM);
			}
			else if(availablePlants[i].equals("NUEZ")) {
				System.out.println("[N]uez: Cost: " + Nuez.COST +" suncoins Harm: "+ Nuez.HARM);
			}
			else {
				System.out.println("[P]eashooter: Cost: " + Peashooter.COST +" suncoins Harm: "+ Peashooter.HARM);
			}
		}
		
	}

}
