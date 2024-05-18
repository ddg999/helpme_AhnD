package helpme_AhnD.interfaces;

import helpme_AhnD.service.DropNote_2P_PlayerService;
import ver02.service.DeathNotePlayerService;

public interface Useable {
	
	// public default void useItems() {}
	
	public default void useItems(DropNote_2P_PlayerService dropNotePlayerService) {}
	public default void useItems(DeathNotePlayerService dropNotePlayerService) {}
	
}
