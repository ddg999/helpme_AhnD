package helpme_AhnD.ver02.interfaces;

import javax.swing.JLabel;

import helpme_AhnD.ver02.state.Player;

public interface Useable {
	
	public default int useItems(int input) {
		return 0;
	}
	
	public default void useItems() {}
	
	public default JLabel useItems(Player place) {
		return null;
	}
}
