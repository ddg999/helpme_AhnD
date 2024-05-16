package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class HpBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private final int FIRST_HEART = 1;
	private final int SECOND_HEART = 2;
	private final int THIRD_HEART = 3;
	private int x;
	private int y = 180;

	private ImageIcon hpFull;
	private ImageIcon hpHalf;

	public HpBox(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		hpFull = new ImageIcon(Define.IMG_HP_HPFULL);
		hpHalf = new ImageIcon(Define.IMG_HP_HPHALF);
		new Thread(new Heart(FIRST_HEART)).start();
		new Thread(new Heart(SECOND_HEART)).start();
		new Thread(new Heart(THIRD_HEART)).start();
	}

	class Heart extends JLabel implements Runnable {

		private int order;

		public Heart(int order) {
			this.order = order;
			initData();
			setInitLayout();
		}

		public void initData() {
			switch (order) {
			case FIRST_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 410;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1125;
				}
				break;
			case SECOND_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 460;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1075;
				}
				break;
			case THIRD_HEART:
				if (player == Player.LEFTPLAYER) {
					x = 510;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1025;
				}
				break;
			default:
				break;
			}
		}

		public void setInitLayout() {
			setIcon(hpFull);
			setSize(50, 50);
			setLocation(x, y);
			playerService.getmContext().add(this);
		}

		@Override
		public void run() {
			while (DropNoteFrame.isRunning()) {
				switch (order) {
				case FIRST_HEART:
					if (playerService.getScore().getHp() >= 20) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 10) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case SECOND_HEART:
					if (playerService.getScore().getHp() >= 40) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 30) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case THIRD_HEART:
					if (playerService.getScore().getHp() >= 60) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 50) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
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
