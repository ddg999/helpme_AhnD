package helpme_AhnD.ver01.service;

import javax.swing.JLabel;

public class ComboBox extends JLabel {

	private int combo;

	public ComboBox(Score score) {
		combo = score.getCombo();
		initData();
		setInitLayout();
	}

	public void initData() {

	}

	public void setInitLayout() {
		setText(combo + "combo");
	}

}
