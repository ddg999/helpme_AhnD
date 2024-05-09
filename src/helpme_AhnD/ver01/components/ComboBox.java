package helpme_AhnD.ver01.components;

import javax.swing.JLabel;

import helpme_AhnD.ver01.service.Score;

public class ComboBox extends JLabel {

	Score score;

	private int combo;
	private int x;
	private int y;

	public ComboBox(Score score) {
		this.combo = score.getCombo();
		initData();
		setInitLayout();
	}

	public void initData() {
		x = 100;
		y = 200;
	}

	public void setInitLayout() {
		setText(combo + "combo");
		setLocation(x, y);
	}

}
