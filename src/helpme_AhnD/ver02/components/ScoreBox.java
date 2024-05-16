package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;

public class ScoreBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private ImageIcon scoreBox;
	private ImageIcon[] scoreNum;

	private int x;
	private int y;
	private boolean isRun = true; // 게임 실행중

	public ScoreBox(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new scoreNum1()).start();
		new Thread(new scoreNum2()).start();
		new Thread(new scoreNum3()).start();
		new Thread(new scoreNum4()).start();
	}

	public void initData() {
		if (player == Player.LEFTPLAYER) {
			x = 410;
			y = 20;
		} else if (player == Player.RIGHTPLAYER) {
			x = 870;
			y = 20;
		}
		scoreBox = new ImageIcon("images/score/scoreScore.jpg");
		scoreNum = new ImageIcon[10];
		scoreNum[0] = new ImageIcon("images/score/SCORE_0.png");
		scoreNum[1] = new ImageIcon("images/score/SCORE_1.png");
		scoreNum[2] = new ImageIcon("images/score/SCORE_2.png");
		scoreNum[3] = new ImageIcon("images/score/SCORE_3.png");
		scoreNum[4] = new ImageIcon("images/score/SCORE_4.png");
		scoreNum[5] = new ImageIcon("images/score/SCORE_5.png");
		scoreNum[6] = new ImageIcon("images/score/SCORE_6.png");
		scoreNum[7] = new ImageIcon("images/score/SCORE_7.png");
		scoreNum[8] = new ImageIcon("images/score/SCORE_8.png");
		scoreNum[9] = new ImageIcon("images/score/SCORE_9.png");
	}

	public void setInitLayout() {
		setIcon(scoreBox);
		setSize(304, 160);
		setLocation(x, y);
		playerService.getmContext().add(this);
	}

	// score 1000의 자리 숫자
	class scoreNum1 extends JLabel implements Runnable {

		private int x1;
		private int y1;

		public scoreNum1() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x1 = 470;
				y1 = 103;
			} else if (player == Player.RIGHTPLAYER) {
				x1 = 930;
				y1 = 103;
			}
		}

		public void setInitLayout() {
			setIcon(scoreNum[0]);
			setSize(33, 57);
			setLocation(x1, y1);
			playerService.getmContext().add(this, 0); // add 우선순위??
		}

		@Override
		public void run() {
			while (isRun) {
				if (playerService.getScore().getScore() >= 9999) {
					setIcon(scoreNum[9]);
				} else {
					for (int i = 0; i < scoreNum.length; i++) {
						if ((playerService.getScore().getScore() % 10000) / 1000 == i) {
							setIcon(scoreNum[i]);
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

	// score 100의 자리 숫자
	class scoreNum2 extends JLabel implements Runnable {

		private int x2;
		private int y2;

		public scoreNum2() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x2 = 520;
				y2 = 103;
			} else if (player == Player.RIGHTPLAYER) {
				x2 = 980;
				y2 = 103;
			}
		}

		public void setInitLayout() {
			setIcon(scoreNum[0]);
			setSize(33, 57);
			setLocation(x2, y2);
			playerService.getmContext().add(this, 0); // add 우선순위??
		}

		@Override
		public void run() {
			while (isRun) {
				if (playerService.getScore().getScore() >= 9999) {
					setIcon(scoreNum[9]);
				} else {
					for (int i = 0; i < scoreNum.length; i++) {
						if ((playerService.getScore().getScore() % 1000) / 100 == i) {
							setIcon(scoreNum[i]);
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

	// score 10의 자리 숫자
	class scoreNum3 extends JLabel implements Runnable {

		private int x3;
		private int y3;

		public scoreNum3() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x3 = 570;
				y3 = 103;
			} else if (player == Player.RIGHTPLAYER) {
				x3 = 1030;
				y3 = 103;
			}
		}

		public void setInitLayout() {
			setIcon(scoreNum[0]);
			setSize(33, 57);
			setLocation(x3, y3);
			playerService.getmContext().add(this, 0); // add 우선순위??
		}

		@Override
		public void run() {
			while (isRun) {
				if (playerService.getScore().getScore() >= 9999) {
					setIcon(scoreNum[9]);
				} else {
					for (int i = 0; i < scoreNum.length; i++) {
						if ((playerService.getScore().getScore() % 100) / 10 == i) {
							setIcon(scoreNum[i]);
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

	// score 1의 자리 숫자
	class scoreNum4 extends JLabel implements Runnable {

		private int x4;
		private int y4;

		public scoreNum4() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x4 = 620;
				y4 = 103;
			} else if (player == Player.RIGHTPLAYER) {
				x4 = 1080;
				y4 = 103;
			}
		}

		public void setInitLayout() {
			setIcon(scoreNum[0]);
			setSize(33, 57);
			setLocation(x4, y4);
			playerService.getmContext().add(this, 0); // add 우선순위??
		}

		@Override
		public void run() {
			while (isRun) {
				if (playerService.getScore().getScore() >= 9999) {
					setIcon(scoreNum[9]);
				} else {
					for (int i = 0; i < scoreNum.length; i++) {
						if (playerService.getScore().getScore() % 10 == i) {
							setIcon(scoreNum[i]);
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
}
