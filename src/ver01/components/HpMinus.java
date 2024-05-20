package ver01.components;

import javax.swing.ImageIcon;

import ver01.interfaces.Useable;

public class HpMinus extends Items implements Useable{

	private ImageIcon hpMinus; // 체력 -10
	
	public HpMinus() {
		initData();
		setInitLayout();
	}

	private void initData() {
		hpMinus = new ImageIcon("images/hj_phmi.png");
	}
	
	private void setInitLayout() {
		setIcon(hpMinus);
		setSize(50, 50);
		setLocation(1200, 200);
	}
	
	public ImageIcon getHpMinus() {
		return hpMinus;
	}

	public void setHpMinus(ImageIcon hpMinus) {
		this.hpMinus = hpMinus;
	}

	@Override
	public int useItems(int input) {
		int resulthp = input - 10;
		return resulthp;
	}

}
