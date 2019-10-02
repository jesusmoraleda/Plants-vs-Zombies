package tp.p3.control;

import tp.p3.logic.Game;
import tp.p3.logic.ReleasePrinter;
import tp.p3.logic.factories.ZombieFactory;
import tp.p3.objects.zombies.Zombie;

public class ZombieManager {
	private int zombies_left;
	private double frecuencia;

	public ZombieManager(String level) {
		if(level.equals("EASY")) {
			this.zombies_left = 3;
			this.frecuencia = 0.1;
		}
		else if(level.equals("HARD")) {
			this.zombies_left = 5;
			this.frecuencia = 0.2;
		}
		else if (level.equals("INSANE")) {
			this.zombies_left = 10;
			this.frecuencia = 0.3;
		}
		else {
			this.zombies_left = 3;
			this.frecuencia = 0.1;
			System.out.println("Nivel no valido, se cargara nivel EASY");
		}
	}

	public int getZombies_left() {
		return zombies_left;
	}
	public void setZombies_left(int zombies_left) {
		this.zombies_left = zombies_left;
	}
	
	public boolean isZombieAdded(Game game) {
		boolean libre = true;
		int posx = 0, posy = ReleasePrinter.number_of_columns - 1;
		String tipo_zombie = null;
		
		double numero = (game.getRam().nextDouble());
		
		if(numero < this.frecuencia && this.zombies_left > 0) {//para ver si se añade zombie
			while(libre) {//bucle para ver en que pos metes el zombie
				posx = (int) (game.getRam().nextInt(4));//fila del zombie
				//comprueba que no haya zombie en esa posicion
				if((game.getGameObjectList().hayZombie(posx, posy) == -1)) {
					libre = false;
				}
			}
			
			numero = (game.getRam().nextInt(3));
			if(numero == 0) {
				tipo_zombie = "ZOMBIECOMUN";
			}else if(numero == 1) {
				tipo_zombie = "CARACUBO";
			}else tipo_zombie = "DEPORTISTA";
			
			Zombie zombie = ZombieFactory.getZombie(tipo_zombie, game, posx, posy);
			game.getGameObjectList().addZombie(zombie);
			this.zombies_left--;
		}
		return false;
	}


}
