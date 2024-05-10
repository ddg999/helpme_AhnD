package helpme_AhnD.ver02.components;

import javax.swing.JLabel;

import helpme_AhnD.ver02.interfaces.Useable;

public class Items extends JLabel implements Useable{

	protected int x;
	protected int y;
	
	// get, set
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
