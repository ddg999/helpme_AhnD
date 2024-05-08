package helpme_AhnD.ver01.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hp extends JLabel {

	private int hp;
	private ImageIcon hp100;
	private ImageIcon hp80;
	private ImageIcon hp60;
	private ImageIcon hp40;
	private ImageIcon hp20;
	private ImageIcon hp0;

	// 생성자
	public Hp(int x, int y) {
		initData();
		setInitLayout();
		setLocation(x, y);
	}

	public void initData() {
		hp = 100;
		hp100 = new ImageIcon("images/hp/hp100.png");
		hp80 = new ImageIcon("images/hp/hp80.png");
		hp60 = new ImageIcon("images/hp/hp60.png");
		hp40 = new ImageIcon("images/hp/hp40.png");
		hp20 = new ImageIcon("images/hp/hp20.png");
		hp0 = new ImageIcon("images/hp/hp0.png");
	}

	public void setInitLayout() {
		setIcon(hp100);
		setSize(100, 100);
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
}