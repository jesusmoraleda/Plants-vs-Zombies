package tp.p3.objects.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Petacereza extends Plant {
	public static final int LIFE = 2;
	public static final int COST = 50;
	public static final int FREQUENCY = 2;
	public static final int HARM = 10;
	

	public Petacereza(Game game, int posx, int posy) {
		super(game,posx, posy,LIFE,COST,FREQUENCY,HARM, FREQUENCY);
	}

	@Override
	public void update() {
		if(this.time == 0) {
			this.game.explota(this.posx, this.posy, this.harm);
			this.life = 0;
		}
		else this.time--;
	}

	@Override
	public String toString() {
		return " C [" + this.life + "] ";
	}

	@Override
	public String toStringDebug() {
		return "C[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +time + "]";
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("C:" + this.life + ":" + this.posx + ":" + this.posy + ":" + time);
		
	}


}
