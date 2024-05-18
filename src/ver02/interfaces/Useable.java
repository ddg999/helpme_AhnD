package ver02.interfaces;

import ver02.service.DeathNotePlayerService;
import ver02.service.DropNote_2P_PlayerService;
import ver02.service.Score;

public interface Useable {
	
	// public default void useItems() {}
	
	public default void useItems(DropNote_2P_PlayerService dropNotePlayerService) {}
	public default void useItems(DeathNotePlayerService dropNotePlayerService) {}
	
}
