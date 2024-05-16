package helpme_AhnD.ver02.components.item;

import javax.swing.JLabel;

import helpme_AhnD.ver02.interfaces.Useable;

public class Items extends JLabel implements Useable {

	public static final int X = 55;
	public static final int Y = 80;
	protected int buffType;
	public static final int BUFF = 0;
	public static final int DEBUFF = 1;
	protected int durationType;
	public static final int IMMEDIATE = 2;
	public static final int DURATION = 3;

	// get, set
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getBuffType() {
		return buffType;
	}

	public int getDurationType() {
		return durationType;
	}

}
