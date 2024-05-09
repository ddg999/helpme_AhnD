package helpme_AhnD.ver02.interfaces;

public interface Useable {
	
	public default int useItems(int input) {
		return 0;
	}
	
	public default void useItems() {}

}
