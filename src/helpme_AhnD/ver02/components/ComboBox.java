package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Digit;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class ComboBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private ImageIcon comboBox;
	private ImageIcon[] comboNum;

	private int x;
	private int y = 450;
	private final int MAX_COMBO = 9999;

	public ComboBox(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new ComboNum(Digit.ONES)).start();
		new Thread(new ComboNum(Digit.TENS)).start();
		new Thread(new ComboNum(Digit.HUNDREDS)).start();
	}

	public void initData() {
		if (player == Player.LEFTPLAYER) {
			x = 280;
		} else if (player == Player.RIGHTPLAYER) {
			x = 1205;
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
		playerService.getmContext().add(this);
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
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 344;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1269;
				}
				break;
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 312;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1237;
				}
				break;
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 280;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1205;
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
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (DropNoteFrame.isRunning()) {
				if (playerService.getScore().getCombo() >= MAX_COMBO) {
					setIcon(comboNum[9]);
				} else {
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
