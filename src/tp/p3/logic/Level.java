package tp.p3.logic;

public class Level {
	public enum Levels
	{
	   EASY, HARD, INSANE
	}
}
/*public static final int NUMBER_OF_COLUMNS = 7;
public static final int NUMBER_OF_ROWS = 4;
public static final int LIST_SIZE = NUMBER_OF_COLUMNS * NUMBER_OF_ROWS;

private int cellSize = 7;
private String vDelimiter = "|";
private String hDelimiter = "-";
private String[][] tablero = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];


public String toString(Game game) {
	System.out.println("Number of cycles: " + game.getCycles());
	System.out.println("Sun coins: " + game.getSuncoinManager().getSuncoins());
	System.out.println("Remaining zombies: " + game.getZombieManager().getZombies_left());
	System.out.println();
	rellenaTablero(game);
	//intentar usar un stringbuilder
	int j = 0;
	
	while(j < 4) {
		System.out.print(" ");
		for(int i = 0; i < LIST_SIZE*2 - 1; i++) {
			System.out.print(hDelimiter);
		}
		System.out.print('\n');
		for(int i = 0; i < cellSize; i++) {
			System.out.print(vDelimiter + tablero[j][i]);
		}
		System.out.println(vDelimiter);
		j++;
	}
	System.out.print(" ");
	for(int i = 0; i < LIST_SIZE*2 - 1; i++) {
		System.out.print(hDelimiter);
	}
	System.out.println();
	
	return hDelimiter;

}
public void rellenaTablero(Game game) {
	int posObject = 0;
	for(int i = 0; i < NUMBER_OF_ROWS; i++) {
		for(int j = 0; j < NUMBER_OF_COLUMNS; j++) {
			posObject = game.getGameObjectList().estaOcupado(i,j);
			if(posObject != -1) {
				tablero[i][j] = game.getGameObjectList().toString(posObject);
			}
			else tablero[i][j] = "       ";
		}
	}
}*/