package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class HpMinus extends Items implements Useable{

	private ImageIcon hpMinus; // 체력 -10
	
	public HpMinus() {
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
