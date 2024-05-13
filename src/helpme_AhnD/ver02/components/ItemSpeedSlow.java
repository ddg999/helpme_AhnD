package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class ItemSpeedSlow extends Items implements Useable{
	
	private ImageIcon itemSpeedSlow;

	public ItemSpeedSlow() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		itemSpeedSlow = new ImageIcon("images/slow.png");
	}
	
	private void setInitLayout() {
		setIcon(itemSpeedSlow);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 스피드 느리게

}
