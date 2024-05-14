package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class SpeedFast extends Items implements Useable{

	private ImageIcon itemSpeedFast;

	public SpeedFast() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		itemSpeedFast = new ImageIcon("images/fast.png");
	}
	
	private void setInitLayout() {
		setIcon(itemSpeedFast);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 스피드 빠르게
	
}
