package tp.p3.control;
import tp.p3.objects.plants.Sunflower;

public class SuncoinManager {
	private final int INITIAL_SUNCOINS=50;

	private int suncoins;

	public SuncoinManager(){
		this.suncoins=INITIAL_SUNCOINS;
	}

	public void addSuncoin(Sunflower sunflower) {
		if(sunflower.getTime() == 1) {
			this.suncoins += sunflower.getFrequency();
			sunflower.setTime(0);
		}
		else {
			sunflower.setTime(1);
		}
	}

	public void removeSuncoins(int costPlant) {
		this.suncoins-=costPlant;
	}

	public int getSuncoins() {
		return this.suncoins;
	}
	public void setSuncoins(int sunCoins) {
		this.suncoins = sunCoins;
	}
}
