package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class SpeedSlow extends Items implements Useable{
	
	private ImageIcon itemSpeedSlow;

	public SpeedSlow() {
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
