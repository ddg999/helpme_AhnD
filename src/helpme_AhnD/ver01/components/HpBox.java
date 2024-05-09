package helpme_AhnD.ver01.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver01.service.Score;

public class HpBox extends JLabel {

	private Score score;
	private int x;
	private int y;
	private ImageIcon hp100;
	private ImageIcon hp80;
	private ImageIcon hp60;
	private ImageIcon hp40;
	private ImageIcon hp20;
	private ImageIcon hp0;

	public HpBox(Score score) {
		this.score = score;
		initData();
		setInitLayout();
	}

	public void initData() {
		// 체력표시 파일
		hp100 = new ImageIcon("images/hp/hp100.png");
		hp80 = new ImageIcon("images/hp/hp80.png");
		hp60 = new ImageIcon("images/hp/hp60.png");
		hp40 = new ImageIcon("images/hp/hp40.png");
		hp20 = new ImageIcon("images/hp/hp20.png");
		hp0 = new ImageIcon("images/hp/hp0.png");
		x = 100;
		y = 100;
	}

	public void setInitLayout() {
		setIcon(hp100);
		setSize(100, 100);
		setLocation(x, y);
	}

	public void checkHp() {
		if (score.getHp() >= 100) {
			setIcon(hp100);
		} else if (score.getHp() >= 80) {
			setIcon(hp80);
		} else if (score.getHp() >= 60) {
			setIcon(hp60);
		} else if (score.getHp() >= 40) {
			setIcon(hp40);
		} else if (score.getHp() > 0) {
			setIcon(hp20);
		} else if (score.getHp() <= 0) {
			setIcon(hp0);
		}
	}
}
