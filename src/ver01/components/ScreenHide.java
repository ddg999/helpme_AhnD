package ver01.components;

import javax.swing.ImageIcon;

import ver01.interfaces.Useable;

public class ScreenHide extends Items implements Useable {

	private ImageIcon screenHide; // 화면 숨김

	public ScreenHide() {
		initData();
		setInitLayout();
	}

	private void initData() {
		screenHide = new ImageIcon("images/hj_bomb.png");
	}

	private void setInitLayout() {
		setIcon(screenHide);
		setSize(622, 565);
		setLocation(1200, 200);
	}

	public ImageIcon getScreenHide() {
		return screenHide;
	}

	public void setScreenHide(ImageIcon screenHide) {
		this.screenHide = screenHide;
	}

}
