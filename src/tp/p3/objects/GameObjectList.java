package tp.p3.objects;

import java.util.ArrayList;
import java.util.List;

import tp.p3.objects.plants.Plant;
import tp.p3.objects.zombies.Zombie;

public class GameObjectList {
	private List<GameObject> gameObjectList; 

	public GameObjectList() {
		this.gameObjectList = new ArrayList<GameObject>();
	}

	public void addPlanta(Plant plant) {
		this.gameObjectList.add(plant);

	}

	public void addZombie(Zombie zombie) {
		this.gameObjectList.add(zombie);

	}

	public int noHayNadie(int posx, int posy) {
		for (int i = 0; i < this.gameObjectList.size(); i++) {
			if (this.gameObjectList.get(i).getPosx() == posx && this.gameObjectList.get(i).getPosy() == posy) {
				return i;
			}
		}
		return -1;
	}

	public GameObject dameObjeto(int j) {
		return this.gameObjectList.get(j);
	}
	public void setObjeto(GameObject object, int j) {
		this.gameObjectList.set(j, object);
	}

	public int dameSize() {
		return this.gameObjectList.size();
	}

	public void zombiePega(Zombie zombie) {
		int i = 0;
		while(i < this.gameObjectList.size()) {
			if (this.gameObjectList.get(i).getPosx() == zombie.getPosx() && this.gameObjectList.get(i).getPosy() == zombie.getPosy() - 1) {
				this.gameObjectList.get(i).plantReceivesHarm(zombie.getHarm());
				break;
			}
			i++;
		}

	}

	public void matanza() {
		for(int i = 0; i < this.gameObjectList.size(); i++) {
			if(!this.gameObjectList.get(i).isAlive()) {
				die(i);
				i--;//i-- porque si eliminamos un elemento la lista va decreciendo
			}
		}

	}

	private void die(int i) {
		int j = i+1;
		while(j < this.gameObjectList.size()) {
			this.gameObjectList.set(j-1, this.gameObjectList.get(j));
			j++;
		}
		this.gameObjectList.remove(j-1);
	}

	public int estaOcupado(int posx, int posy) {
		for(int i = 0; i < this.gameObjectList.size(); i++) {
			if(this.gameObjectList.get(i).getPosx() == posx && this.gameObjectList.get(i).getPosy() == posy ) {
				return i;
			}
		}
		return -1;
	}

	public String toString(int posObject) {
		return this.gameObjectList.get(posObject).toString();
	}

	public boolean noQuedanZombiesEnLaLista() {
		for(int i = 0; i < this.gameObjectList.size();i++) {
			if(this.gameObjectList.get(i).esZombie()) {
				return false;
			}
		}
		return true;
	}

	public boolean ZombiesWin() {
		for(int i = 0; i < this.gameObjectList.size();i++) {
			if(this.gameObjectList.get(i).esZombie() && this.gameObjectList.get(i).getPosy() == 0) {
				return true;
			}
		}
		return false;

	}

	public int hayZombie(int posx, int posy) {
		int i = 0;
		while(i < this.gameObjectList.size()) {
			if(this.gameObjectList.get(i).getPosx() == posx && this.gameObjectList.get(i).getPosy() == posy) {
				return i;
			}
			else i++;
		}
		return -1;
	}

	public String toStringDebug(int i) {
		return this.gameObjectList.get(i).toStringDebug();
	}
	public String nameToFile() {
		String cadena = "";
		int i;
		for(i = 1; i < this.gameObjectList.size(); i++) {
			cadena += "Ob" + i + ", ";
		}
		cadena += "Ob" + i;
		return cadena;
	}

}
