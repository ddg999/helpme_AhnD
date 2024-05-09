package helpme_AhnD.ver02.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.TestFramekh;

public class Note extends JLabel {
	private ImageIcon noteSample;
	private TestFramekh mContext;
	private int player; // player 0는 왼쪽 1은 오른쪽
	public final static int LEFT_PLAYER = 0;
	public final static int RIGHT_PLAYER = 1;

	// 길이에 대한 상수
	private final int HALF_WIDTH = 800;
	private final int NOTE_WIDTH = 60;
	private final int NOTE_HEIGHT = 60;
	private final int PADDING = 100;

	// 노트가 생겨날 위치에 대한 좌표
	private final static int LAST_COORDINATE = 9; // 12곳에서 노트가 생길 수 있음
	private int[] x = new int[LAST_COORDINATE];
	private int[] y = new int[LAST_COORDINATE];
	private int indexX;
	private int indexY;
	// 중복을 피하기 위해 이미 그 좌표가 사용중인지 확인
	private static boolean[][] isUse = new boolean[LAST_COORDINATE][LAST_COORDINATE];

	public Note(int player, TestFramekh mContext) {
		this.player = player;
		this.mContext = mContext;
		initData();
		setInitLayout();

		new Thread(() -> {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setIcon(null);
			isUse[indexX][indexY] = false;
			mContext.remove(this);
			mContext.repaint();
		}).start();
	}

	private void initData() {
		noteSample = new ImageIcon("images/upKey1.png");
		for (int i = 0; i < x.length; i++) {
			x[i] = PADDING + i * NOTE_WIDTH;
			y[i] = PADDING + i * NOTE_HEIGHT;
		}
		for (int i = 4; i < 9; i++) {
			for (int j = 4; j < isUse.length; j++) {
				isUse[i][j] = true;
			}
		}
	}
	private void setInitLayout() {
		setIcon(noteSample);
		setSize(NOTE_WIDTH, NOTE_HEIGHT);
		do {
			indexX = (new Random()).nextInt(LAST_COORDINATE); // 0 ~ 8 사이의 랜덤 인덱스 값
			indexY = (new Random()).nextInt(LAST_COORDINATE); // 0 ~ 8 사이의 랜덤 인덱스 값
		} while (isUse[indexX][indexY]);
		isUse[indexX][indexY] = true;
		if (player == LEFT_PLAYER) {
			setLocation(x[indexX], y[indexY]); // 12 * 12 의 박스 안에서 랜덤한 위치에 생성됨
		} else if (player == RIGHT_PLAYER) {
			x[indexX] += HALF_WIDTH;
			setLocation(x[indexX], y[indexY]);
		}
	}

}