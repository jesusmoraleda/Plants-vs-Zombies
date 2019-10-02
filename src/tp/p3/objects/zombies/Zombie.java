package tp.p3.objects.zombies;

import tp.p3.logic.Game;
import tp.p3.objects.GameObject;

public abstract class Zombie extends GameObject{
	protected int harm;
	protected int speed;
	protected int timeToMove;

	public Zombie(Game game, int posx, int posy, int life,int harm, int speed, int frecuency, int time) {
		super(game, posx, posy, life, time);
		this.harm = harm;
		this.speed = speed;
		this.timeToMove = frecuency;
	}


	public int getHarm() {
		return harm;
	}
	public int getSpeed() {
		return speed;
	}
	public void setVelocidad(int speed) {
		this.speed = speed;
	}

	public void avanza(int posy) { 
		posy-=this.speed;
		super.setPosy(posy);
	}

	/*@Override
	public void update() {
		if((this.movement == this.timeToMove) && (game.nohayNadieDelante(this))) {
			game.avanzar(this);
			this.movement = 0;
		}
		else {
			game.zombiePega(this);
			movement++;
		}

	}*/

	@Override
	public boolean zombieReceivesHarm(int harm) {
		this.life -= harm;
		return true;
	}
	@Override
	public void plantReceivesHarm(int zombie_HARM) {}


	@Override
	public boolean esZombie() {
		return true;
	}

}
