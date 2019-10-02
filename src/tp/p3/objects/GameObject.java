package tp.p3.objects;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public abstract class GameObject {
	protected Game game;
	protected int posx;
	protected int posy;
	protected int life;
	protected int time;
	
	public GameObject(Game game, int posx ,int posy, int life, int time) {
		this.game = game;
		this.posx = posx;
		this.posy = posy;
		this.life = life;
		this.time = time;
	}
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	//metodos comunes a todos los objectos
	public boolean isAlive() {
		return this.life > 0;
	}
	public int dameResistencia() {
		return this.life;
	}
	
	public abstract void update();
	public abstract String toString();
	public abstract String toStringDebug();
	public abstract boolean esZombie();
	public abstract void plantReceivesHarm(int harm);
	public abstract boolean zombieReceivesHarm(int harm);
	public abstract void store(BufferedWriter bw) throws IOException;

	
}
