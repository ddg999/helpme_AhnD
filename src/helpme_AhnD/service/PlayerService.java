package helpme_AhnD.service;

import helpme_AhnD.dropnote_2p.Score;
import helpme_AhnD.frame.*;
public abstract class PlayerService {
	public PlayerService() {
	}
	public abstract Score getScore(); 
	
	public DropNoteFrame_2P getDropNoteFrame_2P() {
		return null;
	}
	public abstract GameSelectFrame getmContext();
}
