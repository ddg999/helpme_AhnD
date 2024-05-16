package helpme_AhnD.ver02.interfaces;

import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.service.Score;

public interface Useable {
	
	// public default void useItems() {}
	
	public default void useItems(DropNotePlayerService dropNotePlayerService) {}
	
}
