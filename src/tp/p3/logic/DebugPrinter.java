package tp.p3.logic;

public class DebugPrinter extends BoardPrinter{
	private int max_list;
	private int max_objects = 7;
	private String vDelimiter = "|";
	private String hDelimiter = "-";

	@Override
	public String printGame(Game game) {
		encodeGame(game);

		System.out.println("Number of cycles: " + game.getCycles());
		System.out.println("Sun coins: " + game.getSuncoinManager().getSuncoins());
		System.out.println("Remaining zombies: " + game.getZombieManager().getZombies_left());
		System.out.println("Level: " + game.getLevel());
		System.out.println("Seed: " + game.getSeed());

		pintarhDelimiter();
		
		if(max_list == 0) System.out.print(" -- \n"+vDelimiter +"  "+vDelimiter +"\n -- ");
		else System.out.print(vDelimiter);

		if(game.getGameObjectList().dameSize() > max_objects) {
			for(int i = 0; i < max_objects;i++) {
				System.out.print(game.getGameObjectList().toStringDebug(i));
				System.out.print(vDelimiter);
			}
			pintarhDelimiter();
			System.out.print(vDelimiter);
			for(int i = max_objects; i < game.getGameObjectList().dameSize();i++) {
				System.out.print(game.getGameObjectList().toStringDebug(i));
				System.out.print(vDelimiter);
			}
			
		}
		else {
			for(int i = 0; i < game.getGameObjectList().dameSize();i++) {
				System.out.print(game.getGameObjectList().toStringDebug(i));
				System.out.print(vDelimiter);
			}
		}
		
		
		pintarhDelimiter();
		System.out.println();
		return null;
	}
	public void pintarhDelimiter() {
		System.out.println();
		System.out.print(" ");
		for(int i = 0; i < max_list; i++) {
			System.out.print(hDelimiter);
		}

		System.out.println();
	}

	@Override
	public void encodeGame(Game game) {
		this.max_list = game.getGameObjectList().dameSize()*20;
		if(max_list >140) {
			max_list = 140;
		}

	}

}
