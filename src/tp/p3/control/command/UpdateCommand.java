package tp.p3.control.command;

import tp.p3.logic.Game;
import tp.p3.objects.GameObject;
import tp.p3.objects.GameObjectList;

public class UpdateCommand extends NoParamsCommand {

	public UpdateCommand() {
		super("Update","[]UPDATE", "Update the game");
	}

	@Override
	public boolean execute(Game game) {
		int i=0;
		GameObjectList lista = game.getGameObjectList();
		GameObject objeto;
		
		while (i<lista.dameSize()) {
			objeto = lista.dameObjeto(i);
			objeto.update();
			i++;
		}
		
		lista.matanza();
		game.updateCycles(); 
		return true;
	}
}
