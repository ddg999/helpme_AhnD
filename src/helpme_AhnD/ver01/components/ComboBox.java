package helpme_AhnD.ver01.components;

import javax.swing.JLabel;

import helpme_AhnD.ver01.service.Score;

public class ComboBox extends JLabel implements Runnable {

	private Score score;
	private int x;
	private int y;
	private boolean isRun; // 게임 실행중

	public ComboBox(Score score) {
		this.score = score;
		initData();
		setInitLayout();
	}

	public void initData() {
		x = 100;
		y = 200;
	}

	public void setInitLayout() {
		setLocation(x, y);
	}

	@Override
	public void run() {
		while (isRun) {
			setText(score.getCombo() + "combo");
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
