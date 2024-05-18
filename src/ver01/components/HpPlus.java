package ver01.components;

import javax.swing.ImageIcon;

import ver01.interfaces.Useable;

public class HpPlus extends Items implements Useable {
	
	private ImageIcon hpPlus; // 체력 +20

	public HpPlus() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		hpPlus = new ImageIcon("images/hj_phpl.png");
	}

	private void setInitLayout() {
		setIcon(hpPlus);
		setSize(50, 50);
		setLocation(1200, 200);
	}

	// get, set
	public ImageIcon getHpPlus() {
		return hpPlus;
	}

	public void setHpPlus(ImageIcon hpPlus) {
		this.hpPlus = hpPlus;
	}

	@Override
	public int useItems(int input) {
		int resulthp = input + 20;
		return resulthp;
	}
	



}
