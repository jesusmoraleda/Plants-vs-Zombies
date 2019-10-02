package tp.p3.objects.plants;

import tp.p3.logic.Game;
import tp.p3.objects.GameObject;

public abstract class Plant extends GameObject{
	protected int cost;
	protected int frequency;//guisantes por ciclo o soles por ciclo
	protected int harm;

	public Plant (Game game, int posx, int posy,int life, int cost, int frequency,int harm, int time) {
		super(game, posx, posy, life, time);
		this.cost = cost;
		this.frequency = frequency;
		this.harm = harm;
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public int getHarm() {
		return harm;
	}
	@Override
	public void plantReceivesHarm(int zombie_HARM) {
		this.life -= zombie_HARM;
	}
	
	@Override
	public boolean zombieReceivesHarm(int harm) {
		return false;
	}
	
	@Override
	public boolean esZombie() {
		return false;
	}
	
	
	

	
}
