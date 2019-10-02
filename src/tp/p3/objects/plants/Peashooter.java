package tp.p3.objects.plants;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Peashooter extends Plant  {
	public static final int LIFE = 3;
	public static final int COST = 20;
	public static final int FREQUENCY = 1;
	public static final int HARM = 1;


	public Peashooter(Game game, int posx, int posy) {
		super(game,posx, posy,LIFE,COST,FREQUENCY,HARM, 0);
	}


	@Override
	public void update() {
		this.game.disparaZombie(this.getPosx(), this.harm);
	}

	@Override
	public String toString() {
		return " P [" + this.life + "] ";

	}

	@Override
	public String toStringDebug() {
		return "P[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +time + "]";
	}
	//symbol:lr:x:y:t
	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("P:" + this.life + ":" + this.posx + ":" + this.posy + ":" + "0");
	}

}
