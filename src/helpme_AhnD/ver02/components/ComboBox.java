package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Digit;
import helpme_AhnD.ver02.state.Player;

public class ComboBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private ImageIcon comboBox;
	private ImageIcon[] comboNum;
	private ImageIcon comboExcellent;
	private ImageIcon comboGood;
	private ImageIcon comboBad;
	private ImageIcon comboMiss;

	private int x;
	private int y;
	private boolean isRun = true; // 게임 실행중

	public ComboBox(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		new Thread(new comboNum(Digit.ONES)).start();
		new Thread(new comboNum(Digit.TENS)).start();
		new Thread(new comboNum(Digit.HUNDREDS)).start();
	}

	public void initData() {
		if (player == Player.LEFTPLAYER) {
			x = 280;
			y = 450;
		} else if (player == Player.RIGHTPLAYER) {
			x = 1205;
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

	class comboNum extends JLabel implements Runnable {

		private Digit digit;
		private int x;
		private int y;

		public comboNum(Digit digit) {
			this.digit = digit;
			initData();
			setInitLayout();
		}

		public void initData() {
			switch (digit) {
			case ONES:
				if (player == Player.LEFTPLAYER) {
					x = 344;
					y = 525;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1269;
					y = 525;
				}
				break;
			case TENS:
				if (player == Player.LEFTPLAYER) {
					x = 312;
					y = 525;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1237;
					y = 525;
				}
				break;
			case HUNDREDS:
				if (player == Player.LEFTPLAYER) {
					x = 280;
					y = 525;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1205;
					y = 525;
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
				if (playerService.getScore().getCombo() >= 9999) {
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
