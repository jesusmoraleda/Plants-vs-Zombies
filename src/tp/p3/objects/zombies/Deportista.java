package tp.p3.objects.zombies;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Deportista extends Zombie {
	public static final int LIFE = 2;
	public static final int HARM = 1;
	public static final int SPEED = 1;
	public static final int TIMETOMOVE = 0;

	public Deportista(Game game, int posx, int posy) {
		super(game, posx, posy, LIFE, HARM, SPEED, TIMETOMOVE, TIMETOMOVE);
	}

	@Override
	public String toString() {
		return " X [" + this.life + "] ";

	}

	@Override
	public String toStringDebug() {
		return "X[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +time + "]";
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("X:" + this.life + ":" + this.posx + ":" + this.posy + ":" + time);
	}

	@Override
	public void update() {
		if((this.time == 0) && (game.nohayNadieDelante(this))) {
			game.avanzar(this);
			this.time = TIMETOMOVE;
		}
		else {
			game.zombiePega(this);
			time--;
		}
		
	}



}
