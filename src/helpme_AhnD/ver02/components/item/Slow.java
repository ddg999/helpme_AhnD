package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class Slow extends Items implements Useable{
	
	private ImageIcon slow;

	public Slow() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		slow = new ImageIcon(Define.IMG_ITEMS_SLOW);
		buffType = Items.BUFF;
		durationType = Items.DURATION;
	}
	
	private void setInitLayout() {
		setIcon(slow);
		setSize(50, 50);
		setLocation(X, Y);
	}
	
	// todo 스피드 느리게

}
