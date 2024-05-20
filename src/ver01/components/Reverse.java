package ver01.components;

import javax.swing.ImageIcon;

import ver01.interfaces.Useable;

public class Reverse extends Items implements Useable {

	private ImageIcon reverse; // 점수 2배

	public Reverse() {
		initData();

	}

	private void initData() {
		reverse = new ImageIcon("images/hj_reverse.png");
	}

	private void setInitLayout() {
		setIcon(reverse);
		setSize(50, 50);
		setLocation(1200, 150);
	}

	public ImageIcon getScoreDouble() {
		return reverse;
	}

	public void setScoreDouble(ImageIcon reverse) {
		this.reverse = reverse;
	}

}
