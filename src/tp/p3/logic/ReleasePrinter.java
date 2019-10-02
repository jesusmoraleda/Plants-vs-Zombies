package tp.p3.logic;

public class ReleasePrinter extends BoardPrinter{
	public static int number_of_columns;
	public static int number_of_rows;
	private int list_size;

	//private int cellSize = 8;
	private String vDelimiter = "|";
	private String hDelimiter = "-";
	private String[][] tablero;
	
	@Override
	public String printGame(Game game) {
		encodeGame(game);
		
		System.out.println("Number of cycles: " + game.getCycles());
		System.out.println("Sun coins: " + game.getSuncoinManager().getSuncoins());
		System.out.println("Remaining zombies: " + game.getZombieManager().getZombies_left());
		System.out.println();
		rellenaTablero(game);
		
		int j = 0;

		while(j < 4) {
			System.out.print(" ");
			for(int i = 0; i < this.list_size*2 - 1; i++) {
				System.out.print(hDelimiter);
			}
			System.out.print('\n');
			for(int i = 0; i < number_of_columns; i++) {
				System.out.print(vDelimiter + tablero[j][i]);
			}
			System.out.println(vDelimiter);
			j++;
		}
		System.out.print(" ");
		for(int i = 0; i < list_size*2 - 1; i++) {
			System.out.print(hDelimiter);
		}
		System.out.println();
		System.out.println();

		return hDelimiter;
	}
	public void rellenaTablero(Game game) {
		int posObject = 0;
		for(int i = 0; i < number_of_rows; i++) {
			for(int j = 0; j < number_of_columns; j++) {
				posObject = game.getGameObjectList().estaOcupado(i,j);
				if(posObject != -1) {
					tablero[i][j] = game.getGameObjectList().toString(posObject);
				}
				else tablero[i][j] = "       ";
			}
		}
	}

	@Override
	public void encodeGame(Game game) {
		this.number_of_columns = 8;
		this.number_of_rows = 4;
		this.list_size = number_of_columns * number_of_rows;
		this.tablero = new String[number_of_rows][number_of_columns];
	}

}
