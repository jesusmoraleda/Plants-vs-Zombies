package tp.p3.logic.factories;

import tp.p3.logic.Game;
import tp.p3.objects.zombies.Caracubo;
import tp.p3.objects.zombies.Deportista;
import tp.p3.objects.zombies.Zombie;
import tp.p3.objects.zombies.ZombieComun;


public class ZombieFactory {
	private static String[] availableZombies = { "ZOMBIECOMUN", "CARACUBO", "DEPORTISTA" };

	public static Zombie getZombie(String zombieName, Game game, int posx, int posy){
		if(zombieName.equals("ZOMBIECOMUN") || zombieName.equals("Z")) {
			return new ZombieComun(game,posx, posy);
		}else if(zombieName.equals("DEPORTISTA") || zombieName.equals("X")){
			return new Deportista(game,posx, posy);
		}
		else if(zombieName.equals("CARACUBO") || zombieName.equals("C")){
			return new Caracubo(game,posx, posy);
		}
		else return null;

	}
	public static void listOfAvilableZombies() {
		for(int i = 0; i < availableZombies.length; i++) {
			if(availableZombies[i].equals("ZOMBIECOMUN")) {
				System.out.println("[Z]ombie comun: speed: " + ZombieComun.SPEED +" Harm: "+ ZombieComun.HARM + " Life: " + ZombieComun.LIFE);
			}else if(availableZombies[i].equals("DEPORTISTA")) {
				System.out.println("[Z]ombie deportista [X]: speed: " + Deportista.SPEED +" Harm: "+ Deportista.HARM + " Life: " + Deportista.LIFE);
			}
			else {
				System.out.println("Zombie [C]aracubo: speed: " + Caracubo.SPEED +" Harm: "+ Caracubo.HARM + " Life: " + Caracubo.LIFE);

			}
		}

	}

}
