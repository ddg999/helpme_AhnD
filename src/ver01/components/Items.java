package ver01.components;

import javax.swing.JLabel;

import ver01.interfaces.Useable;

public class Items extends JLabel implements Useable{

	private int x;
	private int y;
	
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
