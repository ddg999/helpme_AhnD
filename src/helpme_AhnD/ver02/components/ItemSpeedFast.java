package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class ItemSpeedFast extends Items implements Useable{

	private ImageIcon itemSpeedFast;

	public ItemSpeedFast() {
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
