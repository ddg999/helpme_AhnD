package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ItemHpPlus extends Items implements Useable {
	
	private ImageIcon hpPlus; // 체력 +20

	public ItemHpPlus() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		hpPlus = new ImageIcon(Define.IMG_ITEMS_HP_PLUS);
	}

	private void setInitLayout() {
		setIcon(hpPlus);
		setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public int useItems(int input) {
		return input + 20;
	}
	



}
