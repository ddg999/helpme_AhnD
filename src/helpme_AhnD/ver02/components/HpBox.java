package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;

public class HpBox extends JLabel {

	DropNotePlayerService playerService;
	private Player player;

	private final int FIRSTHEART = 1;
	private final int SECONDHEART = 2;
	private final int THIRDHEART = 3;
	private int x;
	private int y = 180;

	private ImageIcon hpFull;
	private ImageIcon hpHalf;

	public HpBox(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		hpFull = new ImageIcon("images/hp/HP_HPFULL.png");
		hpHalf = new ImageIcon("images/hp/HP_HPHALF.png");
		new Thread(new Heart(FIRSTHEART)).start();
		new Thread(new Heart(SECONDHEART)).start();
		new Thread(new Heart(THIRDHEART)).start();
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
			case FIRSTHEART:
				if (player == Player.LEFTPLAYER) {
					x = 410;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1125;
				}
				break;
			case SECONDHEART:
				if (player == Player.LEFTPLAYER) {
					x = 460;
				} else if (player == Player.RIGHTPLAYER) {
					x = 1075;
				}
				break;
			case THIRDHEART:
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
				case FIRSTHEART:
					if (playerService.getScore().getHp() >= 20) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 10) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case SECONDHEART:
					if (playerService.getScore().getHp() >= 40) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 30) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
					}
					break;
				case THIRDHEART:
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
