package helpme_AhnD.interfaces;

import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;

public interface Useable {
	
	// public default void useItems() {}
	
	public default void useItems(DropNote_2P_PlayerService PlayerService) {}
	public default void useItems(TryCatch_2P_PlayerService PlayerService) {}
	
}
