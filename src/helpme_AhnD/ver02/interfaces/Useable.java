package helpme_AhnD.ver02.interfaces;

import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.service.ScoreService;

public interface Useable {
	
	// public default void useItems() {}
	
	public default void useItems(DropNotePlayerService dropNotePlayerService) {}
	public default void useItems(DeathNotePlayerService dropNotePlayerService) {}
	
}
