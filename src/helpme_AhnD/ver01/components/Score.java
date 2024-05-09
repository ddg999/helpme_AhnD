package helpme_AhnD.ver01.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver01.interfaces.Useable;

public class Score extends Items implements Useable{

	private ImageIcon scoreDouble; // 점수 2배

	public Score() {
		initData();
		setInitLayout();
	}

	public int score(int score) {
		int resultScore = score * 2;
		return resultScore;
	}

	private void initData() {
		scoreDouble = new ImageIcon("images/hj_doublescore.png");
	}

	private void setInitLayout() {
		setIcon(scoreDouble);
		setSize(50, 50);
		setLocation(1200, 150);
	}

	public ImageIcon getScoreDouble() {
		return scoreDouble;
	}

	public void setScoreDouble(ImageIcon scoreDouble) {
		this.scoreDouble = scoreDouble;
	}

	@Override
	public int useItems(int input) {
		int resultScore = input * 2;
		return resultScore;
	}
	
}
