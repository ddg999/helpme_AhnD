package helpme_AhnD.ver01.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Items extends JLabel {

	private int x;
	private int y;

	private int hp; // 체력
	private int hide; // 숨김
	private int reverse; // 반전
	private int score; // 점수

	private ImageIcon hpPlus; // 체력 2배
	private ImageIcon hpMinus; // 체력 깍임
	private ImageIcon screenHide; // 화면 숨김
	private ImageIcon keyReverse; // 키반전
	private ImageIcon scoreDouble; // 점수 2배

	public Items() {
		initData();
		setInitLayout();
	}

	private void initData() {
		hpPlus = new ImageIcon("images/hj_phpl.png");
		hpMinus = new ImageIcon("images/hj_phmi.png");
		screenHide = new ImageIcon("images/hj_bomb.png");
		keyReverse = new ImageIcon("images/hj_reverse.png");
		scoreDouble = new ImageIcon("images/hj_doublescore.png");
	}

	private void setInitLayout() {
//		setIcon(hpPlus);
//		setSize(50, 50);
//		setLocation(1200, 200);
		
		setIcon(screenHide);
		setSize(622, 565);
		setLocation(1300, 100);
	}

	// get, set
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

	public int getReverse() {
		return reverse;
	}

	public void setReverse(int reverse) {
		this.reverse = reverse;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ImageIcon getHpPlus() {
		return hpPlus;
	}

	public void setHpPlus(ImageIcon hpPlus) {
		this.hpPlus = hpPlus;
	}

	public ImageIcon getHpMinus() {
		return hpMinus;
	}

	public void setHpMinus(ImageIcon hpMinus) {
		this.hpMinus = hpMinus;
	}

	public ImageIcon getScreenHide() {
		return screenHide;
	}

	public void setScreenHide(ImageIcon screenHide) {
		this.screenHide = screenHide;
	}

	public ImageIcon getKeyReverse() {
		return keyReverse;
	}

	public void setKeyReverse(ImageIcon keyReverse) {
		this.keyReverse = keyReverse;
	}

	public ImageIcon getScoreDouble() {
		return scoreDouble;
	}

	public void setScoreDouble(ImageIcon scoreDouble) {
		this.scoreDouble = scoreDouble;
	}

	public int hpPlus(int hp) {
		int resulthp = hp + 20;
		return resulthp;
	}
	
	public int hpMinus(int hp) {
		int resulthp = hp - 10;
		return resulthp;
	}

	public int scoreDouble(int score) {
		score = score * 2;
		return score;
	}
	
	
	
}
