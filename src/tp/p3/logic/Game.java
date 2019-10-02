package tp.p3.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import tp.p3.control.*;
import tp.p3.exception.CommandExecuteException;
import tp.p3.exception.FileContentsException;
import tp.p3.logic.factories.PlantFactory;
import tp.p3.logic.factories.ZombieFactory;
import tp.p3.objects.*;
import tp.p3.objects.plants.Plant;
import tp.p3.objects.zombies.Zombie;

public class Game {
	//private static final int ROWS = 4;
	//private static final int COLUMNS = 8;
	public static final String wrongPrefixMsg = "unknown game attribute: ";
	public static final String lineTooLongMsg = "too many words on line commencing: ";
	public static final String lineTooShortMsg = "missing data on line commencing: ";

	private GameObjectList gameObjectList;
	protected SuncoinManager suncoinManager;
	private Random ram;
	private ZombieManager zombieManager;
	private int cycles;
	private String level;//Para el reset
	private String seed;//Para el reset
	boolean exit = false;
	private BoardPrinter boardPrinter;



	public Game(String level, String seed) {
		this.gameObjectList = new GameObjectList();
		this.suncoinManager = new SuncoinManager();
		this.ram = new Random(Integer.parseInt(seed));
		this.seed= seed;
		this.level = level;
		this.zombieManager = new ZombieManager(level);
		this.cycles = 0;
		this.boardPrinter = new ReleasePrinter();
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}
	public boolean getExit() {
		return this.exit;
	}
	public GameObjectList getGameObjectList() {
		return gameObjectList;
	}
	public int getCycles() {
		return cycles;
	}
	public SuncoinManager getSuncoinManager() {
		return suncoinManager;
	}
	public ZombieManager getZombieManager() {
		return zombieManager;
	}
	public Random getRam() {
		return ram;
	}
	public String getSeed() {
		return seed;
	}public String getLevel() {
		return level;
	}
	public BoardPrinter getBoardPrinter() {
		return boardPrinter;
	}

	public void setBoardPrinter(BoardPrinter boardPrinter) {
		this.boardPrinter = boardPrinter;
	}
	public void updateCycles() {
		this.cycles++;
	}


	public void ComputerAction() {
		zombieManager.isZombieAdded(this);
	}

	public void add(String[] command) throws CommandExecuteException {
		try {
			int posx = Integer.parseInt(command[2]);
			int posy = Integer.parseInt(command[3]);

			String plantName = command[1];

			if(posx < ReleasePrinter.number_of_rows && posx >= 0 && posy < ReleasePrinter.number_of_columns - 1 && posy >= 0) {
				if(this.gameObjectList.noHayNadie(posx,posy) == -1) {
					Plant plant = PlantFactory.getPlant(plantName, this,posx,posy);
					addPlantToGame(plant);
				}
				else {
					throw new CommandExecuteException("Failed to add plant: position( " +
							posx + ", " + posy +") is already occupied");
				}
			}
			else {
				throw new CommandExecuteException("Failed to add plant: (" +
						posx + ", " + posy +") is an invalid position");
			}
		}
		catch(NumberFormatException e) {
			throw new CommandExecuteException("Invalid argument for add command, number expected: [A]dd <plant> <x> <y>");
		}
	}

	public void exit() {
		System.out.println("Game Over");		
	}

	public void list() {
		PlantFactory.listOfAvilablePlants();
	}

	public void reset() {
		this.gameObjectList = new GameObjectList();
		this.suncoinManager = new SuncoinManager();
		this.zombieManager = new ZombieManager(level);
		this.cycles = -1;
		this.boardPrinter = new ReleasePrinter();
	}
	public void avanzar(Zombie zombie) {
		zombie.avanza(zombie.getPosy());
	}

	public void zombiePega(Zombie zombie) {
		this.gameObjectList.zombiePega(zombie);
	}

	public boolean nohayNadieDelante(Zombie zombie) {
		if(this.gameObjectList.noHayNadie(zombie.getPosx(), zombie.getPosy() - 1) == -1) {
			return true;
		}
		return false;
	}

	public boolean ZombiesWin() {
		if(this.gameObjectList.ZombiesWin()) {
			System.out.println("ZOMBIES WIN :(");
			return true;
		}
		else return false;

	}

	public boolean UserWins() {
		if (this.gameObjectList.noQuedanZombiesEnLaLista() && zombieManager.getZombies_left()==0) {
			System.out.println("USER WINS! :)");
			return true;
		}
		return false;
	}

	public void addPlantToGame(Plant plant) throws CommandExecuteException {
		if(suncoinManager.getSuncoins()>= plant.getCost()) {
			this.gameObjectList.addPlanta(plant);
			suncoinManager.removeSuncoins(plant.getCost());
		}
		else {
			throw new CommandExecuteException("Failed to add Peashooter: not enough suncoins to buy it");
		}
	}

	public void disparaZombie(int posx, int harm) {
		int i = 0;

		while(i < this.gameObjectList.dameSize()) {
			if(this.gameObjectList.dameObjeto(i).getPosx() == posx) {
				if(this.gameObjectList.dameObjeto(i).zombieReceivesHarm(harm)) {
					break;
				}	
			}
			i++;
		}
	}

	public void explota(int posx, int posy, int harm) {
		int i = 0;

		while(i < this.gameObjectList.dameSize()) {
			GameObject object = gameObjectList.dameObjeto(i);
			if(estaAlrededor(object, posx, posy)){
				object.zombieReceivesHarm(harm);
			}
			i++;
		}
	}

	public boolean estaAlrededor(GameObject object, int posx, int posy) {
		if((object.getPosx() == posx && object.getPosy() == posy + 1) ||
				(object.getPosx() == posx + 1 && object.getPosy() == posy + 1) ||
				(object.getPosx() == posx + 1 && object.getPosy() == posy) ||
				(object.getPosx() == posx + 1 && object.getPosy() == posy - 1) ||
				(object.getPosx() == posx && object.getPosy() == posy - 1) ||
				(object.getPosx() == posx - 1 && object.getPosy() == posy - 1) ||
				(object.getPosx() == posx - 1 && object.getPosy() == posy) ||
				(object.getPosx() == posx - 1 && object.getPosy() == posy + 1)) {
			return true;
		}
		else return false;
	}
	public void store(BufferedWriter bw) throws IOException {
		bw.write("cycle: " + this.cycles + "\r\n");
		bw.write("sunCoins: " + this.suncoinManager.getSuncoins() + "\r\n");
		bw.write("level: " + this.level + "\r\n");
		bw.write("remZombies: " + this.zombieManager.getZombies_left() + "\r\n");
		bw.write("objectList: " + this.gameObjectList.nameToFile() + "\r\n");
		bw.write("\r\n");

		for(int i = 0; i < this.gameObjectList.dameSize(); i++) {
			this.gameObjectList.dameObjeto(i).store(bw);
			bw.write("\r\n");
		}

	}
	public String[] loadLine(BufferedReader inStream, String prefix, boolean isList)
			throws IOException, FileContentsException {
		String line = inStream.readLine().trim();
		// absence of the prefix is invalid
		if (!line.startsWith(prefix + ":"))
			throw new FileContentsException(wrongPrefixMsg + prefix);
		// cut the prefix and the following colon off the line
		// then trim it to get the attribute contents
		String contentString = line.substring(prefix.length()+1).trim();
		String[] words;
		// the attribute contents are not empty
		if (!contentString.equals("")) {
			if (!isList ) {
				// split non−list attribute contents into words
				// using 1−or−more−white−spaces as separator
				words = contentString.split("\\s+");
				// a non−list attribute with contents of more than one word is invalid
				if (words.length != 1)
					throw new FileContentsException(lineTooLongMsg + prefix);
			} else
				// split list attribute contents into words
				// using comma+0−or−more−white−spaces as separator
				words = contentString.split(",\\s*");
			// the attribute contents are empty
		} else {
			// a non−list attribute with empty contents is invalid
			if (!isList )
				throw new FileContentsException(lineTooShortMsg + prefix);
			// a list attibute with empty contents is valid;
			// use a zero−length array to store its words
			words = new String[0];
		}
		return words;
	}
	public boolean load(BufferedReader br) {

		try {
			String[] cycles = loadLine(br, "cycle", true);
			int loadCycles = Integer.parseInt(cycles[0]);
			String[] sunCoins = loadLine(br, "sunCoins", true);
			int loadSuncoins = (Integer.parseInt(sunCoins[0]));
			String[] level = loadLine(br, "level", true);
			String loadLevel = level[0];
			String[] remZombies = loadLine(br, "remZombies", true);
			int loadZombies_left = Integer.parseInt(remZombies[0]);
			String[] size = loadLine(br, "objectList", true);
			int tamano = size.length;
			if(!br.readLine().equals("")){
				throw new FileContentsException("missing a blank line");
			}
			GameObjectList loadGameObjectList = new GameObjectList();
			for(int i = 0; i < tamano; i++) {
				String linea = br.readLine();
				String[] words = linea.split(":");
				Plant plant = PlantFactory.getPlant(words[0], this,Integer.parseInt(words[2]),
													Integer.parseInt(words[3]));
				if(plant == null) {
					Zombie zombie = ZombieFactory.getZombie(words[0], this,Integer.parseInt(words[2]),
							Integer.parseInt(words[3]));
					if(zombie == null) {
						throw new FileContentsException("Object not valid");
					}
					else {
						loadGameObjectList.addZombie(zombie);
						zombie.setLife(Integer.parseInt(words[1]));
						zombie.setTime(Integer.parseInt(words[4]));
					}
				}
				else {
					loadGameObjectList.addPlanta(plant);
					plant.setLife(Integer.parseInt(words[1]));
					plant.setTime(Integer.parseInt(words[4]));
				}
			}
			this.gameObjectList = loadGameObjectList;
			this.cycles = loadCycles;
			this.suncoinManager.setSuncoins(loadSuncoins);
			this.level = loadLevel;
			this.zombieManager.setZombies_left(loadZombies_left);
			return true;
			

		} catch (IOException  | FileContentsException e) {
			//System.err.println("Fallo al leer el archivo");
			return false;
		} 


	}

}

