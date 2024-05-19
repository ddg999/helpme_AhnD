package helpme_AhnD.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.service.PlayerService;
import helpme_AhnD.state.Digit;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class ComboBox extends JLabel {
	// 현재 콤보 수를 띄우는 라벨
	
	GameSelectFrame mContext;
	PlayerService playerService;
	private Player player;

	private ImageIcon comboBox;
	private ImageIcon[] comboNum;

	private int x;
	private int y = 450;
	private final int MAX_COMBO = 999;

	public ComboBox(PlayerService playerService, Player player) {
		this.playerService = playerService;
		mContext = playerService.getmContext();
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new ComboNum(Digit.ONES)).start(); // 일의 자리수 실시간 출력
		new Thread(new ComboNum(Digit.TENS)).start(); // 십의 자리수 실시간 출력
		new Thread(new ComboNum(Digit.HUNDREDS)).start(); // 백의 자리수 실시간 출력
	}

	public void initData() {
		if (player == Player.LEFTPLAYER) {
			x = 280;
		} else if (player == Player.RIGHTPLAYER) {
			x = 1205;
		} else if (player == Player.SOLO) {
			x = 743;
		}
		comboBox = new ImageIcon(Define.IMG_COMBO_COMBO);
		comboNum = new ImageIcon[10];
		comboNum[0] = new ImageIcon(Define.IMG_COMBO_0);
		comboNum[1] = new ImageIcon(Define.IMG_COMBO_1);
		comboNum[2] = new ImageIcon(Define.IMG_COMBO_2);
		comboNum[3] = new ImageIcon(Define.IMG_COMBO_3);
		comboNum[4] = new ImageIcon(Define.IMG_COMBO_4);
		comboNum[5] = new ImageIcon(Define.IMG_COMBO_5);
		comboNum[6] = new ImageIcon(Define.IMG_COMBO_6);
		comboNum[7] = new ImageIcon(Define.IMG_COMBO_7);
		comboNum[8] = new ImageIcon(Define.IMG_COMBO_8);
		comboNum[9] = new ImageIcon(Define.IMG_COMBO_9);
	}

	public void setInitLayout() {
		setIcon(comboBox);
		setSize(100, 100);
		setLocation(x, y);
		switch (mContext.getSelectNumber()) {
		case GameSelectFrame.GAMENAME_DROPNOTE_1P:
			playerService.getDropNoteFrame_1P().add(this);
			break;
		case GameSelectFrame.GAMENAME_DROPNOTE_2P:
			playerService.getDropNoteFrame_2P().add(this);
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_1P:
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_2P:
			playerService.getTryCatchFrame_2P().add(this);
			break;
		}
	}

	class ComboNum extends JLabel implements Runnable {

		private Digit digit;
		private int x;
		private int y = 525;

		public ComboNum(Digit digit) {
			this.digit = digit;
			initData();
			setInitLayout();
		}

		public void initData() {
			switch (digit) {
			// 일의 자리수 좌표 세팅
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 344;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1269;
				} else if (player == Player.SOLO) {
					x = 807;
				}
				break;
			// 십의 자리수 좌표 세팅
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 312;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1237;
				} else if (player == Player.SOLO) {
					x = 775;
				}
				break;
			// 백의 자리수 좌표 세팅
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 280;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1205;
				} else if (player == Player.SOLO) {
					x = 743;
				}
				break;
			default:
				break;
			}
		}

		public void setInitLayout() {
			setIcon(comboNum[0]);
			setSize(30, 46);
			setLocation(x, y);
			switch (mContext.getSelectNumber()) {
			case GameSelectFrame.GAMENAME_DROPNOTE_1P:
				playerService.getDropNoteFrame_1P().add(this);
				break;
			case GameSelectFrame.GAMENAME_DROPNOTE_2P:
				playerService.getDropNoteFrame_2P().add(this);
				break;
			case GameSelectFrame.GAMENAME_TRYCATCH_1P:
				break;
			case GameSelectFrame.GAMENAME_TRYCATCH_2P:
				playerService.getTryCatchFrame_2P().add(this);
				break;
			}
		}

		@Override
		public void run() {
			while (GameSelectFrame.isGameRunning()) {
				if (playerService.getScore().getCombo() >= MAX_COMBO) {
					setIcon(comboNum[9]);
				} else {
					// 반복문 돌면서 각 자리의 수와 같은 i 값에 해당하는 이미지로 변경
					switch (digit) {
					case ONES:
						for (int i = 0; i < comboNum.length; i++) {
							if (playerService.getScore().getCombo() % 10 == i) {
								setIcon(comboNum[i]);
							}
						}
						break;
					case TENS:
						for (int i = 0; i < comboNum.length; i++) {
							if ((playerService.getScore().getCombo() % 100) / 10 == i) {
								setIcon(comboNum[i]);
							}
						}
						break;
					case HUNDREDS:
						for (int i = 0; i < comboNum.length; i++) {
							if ((playerService.getScore().getCombo() % 1000) / 100 == i) {
								setIcon(comboNum[i]);
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
