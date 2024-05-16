package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Digit;
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
		new Thread(new scoreNum(Digit.ONES)).start();
		new Thread(new scoreNum(Digit.TENS)).start();
		new Thread(new scoreNum(Digit.HUNDREDS)).start();
		new Thread(new scoreNum(Digit.THOUSANDS)).start();
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

	class scoreNum extends JLabel implements Runnable {

		private Digit digit;
		private int x;
		private int y;

		public scoreNum(Digit digit) {
			this.digit = digit;
			initData();
			setInitLayout();
		}

		public void initData() {
			switch (digit) {
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 620;
					y = 103;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1080;
					y = 103;
				}
				break;
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 570;
					y = 103;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1030;
					y = 103;
				}
				break;
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 520;
					y = 103;
				} else if (player == Player.RIGHTPLAYER) {
					x = 980;
					y = 103;
				}
				break;
			case THOUSANDS:
				if (player == Player.LEFTPLAYER) {
					x = 470;
					y = 103;
				} else if (player == Player.RIGHTPLAYER) {
					x = 930;
					y = 103;
				}
				break;
			default:
				break;
			}
		}

		public void setInitLayout() {
			setIcon(scoreNum[0]);
			setSize(33, 57);
			setLocation(x, y);
			playerService.getmContext().add(this, 0); // add 우선순위??
		}

		@Override
		public void run() {
			while (DropNoteFrame.isRunning()) {
				if (playerService.getScore().getScore() >= 9999) {
					setIcon(scoreNum[9]);
				} else {
					switch (digit) {
					case ONES:
						for (int i = 0; i < scoreNum.length; i++) {
							if (playerService.getScore().getScore() % 10 == i) {
								setIcon(scoreNum[i]);
							}
						}
						break;
					case TENS:
						for (int i = 0; i < scoreNum.length; i++) {
							if ((playerService.getScore().getScore() % 100) / 10 == i) {
								setIcon(scoreNum[i]);
							}
						}
						break;
					case HUNDREDS:
						for (int i = 0; i < scoreNum.length; i++) {
							if ((playerService.getScore().getScore() % 1000) / 100 == i) {
								setIcon(scoreNum[i]);
							}
						}
						break;
					case THOUSANDS:
						for (int i = 0; i < scoreNum.length; i++) {
							if ((playerService.getScore().getScore() % 10000) / 1000 == i) {
								setIcon(scoreNum[i]);
							}
						}
						break;
					default:
						break;
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
