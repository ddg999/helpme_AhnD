package helpme_AhnD.service;

import helpme_AhnD.frame.*;
import helpme_AhnD.state.Player;
public abstract class PlayerService {
	public PlayerService() {
	}
	public abstract Score getScore(); 
	
	public DropNoteFrame_2P getDropNoteFrame_2P() {
		return null;
	}
	public DropNoteFrame_1P getDropNoteFrame_1P() {
		return null;
	}
	public abstract GameSelectFrame getmContext();
	
	public abstract Player getPlayer();
}
