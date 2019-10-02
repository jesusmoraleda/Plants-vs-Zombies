package tp.p3.objects.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Sunflower extends Plant {
	public static final int LIFE = 1;
	public static final int COST = 20;
	public static final int FREQUENCY = 10;
	public static final int HARM = 0;
	

	public Sunflower(Game game, int posx, int posy) {
		super(game,posx, posy,LIFE,COST,FREQUENCY,HARM, 0);

	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public void update() {
		game.getSuncoinManager().addSuncoin(this);
		
	}
	@Override
	public String toString() {
		return " S [" + this.life + "] ";
	}
	@Override
	public String toStringDebug() {
		return "S[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +time + "]";
	}
	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("S:" + this.life + ":" + this.posx + ":" + this.posy + ":" + time);
		
	}

	
	
	
}
