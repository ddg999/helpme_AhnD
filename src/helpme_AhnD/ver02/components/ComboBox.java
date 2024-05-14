package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DropNotePlayerService;

public class ComboBox extends JLabel {

	DropNotePlayerService playerService;
	private ImageIcon comboBox;
	private ImageIcon[] comboNum;
	private ImageIcon comboExcellent;
	private ImageIcon comboGood;
	private ImageIcon comboBad;
	private ImageIcon comboMiss;

	private int x;
	private int y;
	private int player;
	private boolean isRun = true; // 게임 실행중

	public ComboBox(DropNotePlayerService playerService, int player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new comboNum1()).start();
		new Thread(new comboNum2()).start();
		new Thread(new comboNum3()).start();
	}

	public void initData() {
		if (player == 1) {
			x = 350;
			y = 450;
		} else if (player == 2) {
			x = 1150;
			y = 450;
		}
		comboBox = new ImageIcon("images/combo/COMBO_COMBO.png");
		comboNum = new ImageIcon[10];
		comboNum[0] = new ImageIcon("images/combo/COMBO_0.png");
		comboNum[1] = new ImageIcon("images/combo/COMBO_1.png");
		comboNum[2] = new ImageIcon("images/combo/COMBO_2.png");
		comboNum[3] = new ImageIcon("images/combo/COMBO_3.png");
		comboNum[4] = new ImageIcon("images/combo/COMBO_4.png");
		comboNum[5] = new ImageIcon("images/combo/COMBO_5.png");
		comboNum[6] = new ImageIcon("images/combo/COMBO_6.png");
		comboNum[7] = new ImageIcon("images/combo/COMBO_7.png");
		comboNum[8] = new ImageIcon("images/combo/COMBO_8.png");
		comboNum[9] = new ImageIcon("images/combo/COMBO_9.png");
		comboExcellent = new ImageIcon("images/combo/COMBO_EXCELLENT.png");
		comboGood = new ImageIcon("images/combo/COMBO_GOOD.png");
		comboBad = new ImageIcon("images/combo/COMBO_BAD.png");
		comboMiss = new ImageIcon("images/combo/miss.png");
	}

	public void setInitLayout() {
		setIcon(comboBox);
		setSize(100, 100);
		setLocation(x, y);
		playerService.getmContext().add(this);
	}

	// combo 100의 자리 숫자
	class comboNum1 extends JLabel implements Runnable {

		private int x1;
		private int y1;

		public comboNum1() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x1 = 350;
				y1 = 525;
			} else if (player == 2) {
				x1 = 1150;
				y1 = 525;
			}
		}

		public void setInitLayout() {
			setIcon(comboNum[0]);
			setSize(30, 46);
			setLocation(x1, y1);
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (isRun) {
				if (playerService.getScore().getCombo() >= 9999) {
					setIcon(comboNum[9]);
				} else {
					for (int i = 0; i < comboNum.length; i++) {
						if ((playerService.getScore().getCombo() % 1000) / 100 == i) {
							setIcon(comboNum[i]);
						}
					}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// combo 10의 자리 숫자
	class comboNum2 extends JLabel implements Runnable {

		private int x2;
		private int y2;

		public comboNum2() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x2 = 382;
				y2 = 525;
			} else if (player == 2) {
				x2 = 1182;
				y2 = 525;
			}
		}

		public void setInitLayout() {
			setIcon(comboNum[0]);
			setSize(30, 46);
			setLocation(x2, y2);
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (isRun) {
				for (int i = 0; i < comboNum.length; i++) {
					if ((playerService.getScore().getCombo() % 100) / 10 == i) {
						setIcon(comboNum[i]);
					}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// combo 1의 자리 숫자
	class comboNum3 extends JLabel implements Runnable {

		private int x3;
		private int y3;

		public comboNum3() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x3 = 414;
				y3 = 525;
			} else if (player == 2) {
				x3 = 1214;
				y3 = 525;
			}
		}

		public void setInitLayout() {
			setIcon(comboNum[0]);
			setSize(30, 46);
			setLocation(x3, y3);
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (isRun) {
				for (int i = 0; i < comboNum.length; i++) {
					if (playerService.getScore().getCombo() % 10 == i) {
						setIcon(comboNum[i]);
					}
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
