package tp.p3.objects.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Nuez extends Plant {
	public static final int LIFE = 10;
	public static final int COST = 50;
	public static final int FREQUENCY = 0;
	public static final int HARM = 0;


	public Nuez(Game game, int posx, int posy) {
		super(game, posx, posy,LIFE,COST,FREQUENCY,HARM, FREQUENCY);
	}

	@Override
	public void update() {}

	@Override
	public String toString() {
		if(this.life == 10) {
			return " N[" + this.life + "] ";
		}
		return " N [" + this.life + "] ";
	}

	@Override
	public String toStringDebug() {
		return "N[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +this.time + "]";
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		
		bw.write("P:" + this.life + ":" + this.posx + ":" + this.posy + ":" + this.frequency);
	}
	


}
