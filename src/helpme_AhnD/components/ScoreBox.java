package helpme_AhnD.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.PlayerService;
import helpme_AhnD.state.Digit;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class ScoreBox extends JLabel {

	GameSelectFrame mContext;
	PlayerService playerService;
	private Player player;

	private ImageIcon scoreBox;
	private ImageIcon[] scoreNum;

	private int x;
	private int y = 20;
	private final int MAX_SCORE = 9999;

	public ScoreBox(PlayerService playerService, Player player) {
		this.playerService = playerService;
		mContext = playerService.getmContext();
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
		} else if (player == Player.SOLO) {
			x = 640;
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
		switch (mContext.getSelectNumber()) {
		case GameSelectFrame.GAMENAME_DROPNOTE_1P:
			playerService.getDropNoteFrame_1P().add(this);
			break;
		case GameSelectFrame.GAMENAME_DROPNOTE_2P:
			playerService.getDropNoteFrame_2P().add(this);
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_1P:
			playerService.getTryCatchFrame_1P().add(this);
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_2P:
			playerService.getTryCatchFrame_2P().add(this);
			break;
		}
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
			// 일의 자리수 좌표 세팅
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 620;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1080;
				} else if (player == Player.SOLO) {
					x = 850;
				}
				break;
			// 십의 자리수 좌표 세팅
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 570;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1030;
				} else if (player == Player.SOLO) {
					x = 800;
				}
				break;
			// 백의 자리수 좌표 세팅
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 520;
				} else if (player == Player.RIGHTPLAYER) {
					x = 980;
				} else if (player == Player.SOLO) {
					x = 750;
				}
				break;
			// 천의 자리수 좌표 세팅
			case THOUSANDS:
				if (player == Player.LEFTPLAYER) {
					x = 470;
				} else if (player == Player.RIGHTPLAYER) {
					x = 930;
				} else if (player == Player.SOLO) {
					x = 700;
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
			switch (mContext.getSelectNumber()) {
			case GameSelectFrame.GAMENAME_DROPNOTE_1P:
				playerService.getDropNoteFrame_1P().add(this, 0);
				break;
			case GameSelectFrame.GAMENAME_DROPNOTE_2P:
				playerService.getDropNoteFrame_2P().add(this, 0);
				break;
			case GameSelectFrame.GAMENAME_TRYCATCH_1P:
				playerService.getTryCatchFrame_1P().add(this, 0);
				break;
			case GameSelectFrame.GAMENAME_TRYCATCH_2P:
				playerService.getTryCatchFrame_2P().add(this, 0);
				break;
			}
		}

		@Override
		public void run() {
			while (GameSelectFrame.isGameRunning()) {
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
