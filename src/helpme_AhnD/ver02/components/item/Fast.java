package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class Fast extends Items implements Useable{

	private ImageIcon itemSpeedFast;

	public Fast() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		itemSpeedFast = new ImageIcon(Define.IMG_ITEMS_FAST);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}
	
	private void setInitLayout() {
		setIcon(itemSpeedFast);
		setSize(50, 50);
		setLocation(X, Y);
	}
	
	// todo 스피드 빠르게
	
}
