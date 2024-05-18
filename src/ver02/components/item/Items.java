package ver02.components.item;

import javax.swing.JLabel;

import ver02.interfaces.Useable;

public class Items extends JLabel implements Useable {
	
	// 좌표
	public static final int X = 55;
	public static final int Y = 80;
	// 크기
	protected final int WIDTH = 50;
	protected final int HEIGHT = 50;
	
	// 타입 정의
	protected int buffType;
	public static final int BUFF = 0;
	public static final int DEBUFF = 1;
	protected int durationType;
	public static final int IMMEDIATE = 2;
	public static final int DURATION = 3;
	public static final int DURATION_TIME = 5000; // 지속시간 밀리초

	// get, set
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getBuffType() {
		return buffType;
	}

	public int getDurationType() {
		return durationType;
	}

}
