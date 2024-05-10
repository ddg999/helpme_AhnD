package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ItemHpMinus extends Items implements Useable{

	private ImageIcon hpMinus; // 체력 -10
	
	public ItemHpMinus() {
		initData();
		setInitLayout();
	}

	private void initData() {
		hpMinus = new ImageIcon(Define.IMG_ITEMS_HP_MINUS);
	}
	
	private void setInitLayout() {
		setIcon(hpMinus);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	@Override
	public int useItems(int input) {
		return input - 10;
	}

}
