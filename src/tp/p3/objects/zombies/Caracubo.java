package tp.p3.objects.zombies;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p3.logic.Game;

public class Caracubo extends Zombie {
	public static final int LIFE = 8;
	public static final int HARM = 1;
	public static final int SPEED = 1;
	public static final int TIMETOMOVE = 3;
	
	public Caracubo(Game game, int posx, int posy) {
		super(game, posx, posy,LIFE,HARM,SPEED,TIMETOMOVE, TIMETOMOVE);
	}

	@Override
	public String toString() {
		return " W [" + this.life + "] ";
	}

	@Override
	public String toStringDebug() {
		return "W[l:" + this.life + ",x:" + this.posx + ",y:" + this.posy + ",t:" +time + "]";
	}

	@Override
	public void store(BufferedWriter bw) throws IOException {
		bw.write("W:" + this.life + ":" + this.posx + ":" + this.posy + ":" + time);
		
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
