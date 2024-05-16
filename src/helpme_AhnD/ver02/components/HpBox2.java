package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DropNotePlayerService;

public class HpBox2 extends JLabel {

	DeathNotePlayerService playerService;
	private int player;

	private int x;
	private int y = 180;

	private ImageIcon hpFull;
	private ImageIcon hpHalf;

	public HpBox2(DeathNotePlayerService deathNotePlayerService, int player) {
		this.playerService = deathNotePlayerService;
		this.player = player;
		hpFull = new ImageIcon("images/hp/HP_HPFULL.png");
		hpHalf = new ImageIcon("images/hp/HP_HPHALF.png");
		new Thread(new hp1()).start();
		new Thread(new hp2()).start();
		new Thread(new hp3()).start();
	}

	// hp 첫번째 하트
	class hp1 extends JLabel implements Runnable {

		public hp1() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x = 410;
			} else if (player == 2) {
				x = 1125;
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
				while (DropNoteFrame.isRunning()) {
					if (playerService.getScore().getHp() >= 20) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 10) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
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

	// hp 두번째 하트
	class hp2 extends JLabel implements Runnable {

		public hp2() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x = 460;
			} else if (player == 2) {
				x = 1075;
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
				while (DropNoteFrame.isRunning()) {
					if (playerService.getScore().getHp() >= 40) {
						setIcon(hpFull);
					} else if (playerService.getScore().getHp() >= 30) {
						setIcon(hpHalf);
					} else {
						setIcon(null);
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

	// hp 세번째 하트
	class hp3 extends JLabel implements Runnable {

		public hp3() {
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == 1) {
				x = 510;
			} else if (player == 2) {
				x = 1025;
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
			}
		}
	}
}
