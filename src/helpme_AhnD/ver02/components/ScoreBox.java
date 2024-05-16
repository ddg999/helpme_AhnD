package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.components.ScoreBox2.scoreNum1;
import helpme_AhnD.ver02.components.ScoreBox2.scoreNum2;
import helpme_AhnD.ver02.components.ScoreBox2.scoreNum3;
import helpme_AhnD.ver02.components.ScoreBox2.scoreNum4;
import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Digit;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class ScoreBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private ImageIcon scoreBox;
	private ImageIcon[] scoreNum;

	private int x;
	private int y = 20;
	private final int MAX_SCORE = 9999;

	public ScoreBox(DropNotePlayerService dropNotePlayerService, Player player) {
		this.playerService = dropNotePlayerService;
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new ScoreNum(Digit.ONES)).start();
		new Thread(new ScoreNum(Digit.TENS)).start();
		new Thread(new ScoreNum(Digit.HUNDREDS)).start();
		new Thread(new ScoreNum(Digit.THOUSANDS)).start();
	}

	public void initData() {
		if (player == Player.LEFTPLAYER) {
			x = 410;
		} else if (player == Player.RIGHTPLAYER) {
			x = 870;
		}
		scoreBox = new ImageIcon(Define.IMG_SCORE_SCOREBOX);
		scoreNum = new ImageIcon[10];
		scoreNum[0] = new ImageIcon(Define.IMG_SCORE_0);
		scoreNum[1] = new ImageIcon(Define.IMG_SCORE_1);
		scoreNum[2] = new ImageIcon(Define.IMG_SCORE_2);
		scoreNum[3] = new ImageIcon(Define.IMG_SCORE_3);
		scoreNum[4] = new ImageIcon(Define.IMG_SCORE_4);
		scoreNum[5] = new ImageIcon(Define.IMG_SCORE_5);
		scoreNum[6] = new ImageIcon(Define.IMG_SCORE_6);
		scoreNum[7] = new ImageIcon(Define.IMG_SCORE_7);
		scoreNum[8] = new ImageIcon(Define.IMG_SCORE_8);
		scoreNum[9] = new ImageIcon(Define.IMG_SCORE_9);
	}

	public void setInitLayout() {
		setIcon(scoreBox);
		setSize(304, 160);
		setLocation(x, y);
		playerService.getmContext().add(this);
	}

	class ScoreNum extends JLabel implements Runnable {

		private Digit digit;
		private int x;
		private int y = 103;

		public ScoreNum(Digit digit) {
			this.digit = digit;
			initData();
			setInitLayout();
		}

		public void initData() {
			switch (digit) {
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 620;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1080;
				}
				break;
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 570;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1030;
				}
				break;
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 520;
				} else if (player == Player.RIGHTPLAYER) {
					x = 980;
				}
				break;
			case THOUSANDS:
				if (player == Player.LEFTPLAYER) {
					x = 470;
				} else if (player == Player.RIGHTPLAYER) {
					x = 930;
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
				if (playerService.getScore().getScore() >= MAX_SCORE) {
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
