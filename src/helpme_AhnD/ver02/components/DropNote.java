package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class DropNote extends JLabel implements Runnable {

	DropNoteFrame mContext;
	DropNotePlayerService playerService;
	private Player player;

	private ImageIcon noteBall;

	private int x;
	private int y;
	private int noteSpeed = 2;

	private int place;
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;

	boolean isPerfect;
	boolean isExcellent;
	boolean isGood;
	boolean isBad;
	boolean isMiss;

	private boolean drop = true;
	private boolean isJudged = false;

	public DropNote(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		addEventListener();
		new Thread(new judgeImage(player)).start();
	}

	public void initData() {
		noteBall = new ImageIcon(Define.IMG_DROPNOTE_NOTE);
		Random random = new Random();
		place = random.nextInt(4);
		switch (player) {
		case LEFTPLAYER:
			if (place == LEFT) {
				x = 150;
			} else if (place == UP) {
				x = 250;
			} else if (place == RIGHT) {
				x = 350;
			} else if (place == DOWN) {
				x = 450;
			}
			break;
		case RIGHTPLAYER:
			if (place == LEFT) {
				x = 1080;
			} else if (place == UP) {
				x = 1180;
			} else if (place == RIGHT) {
				x = 1280;
			} else if (place == DOWN) {
				x = 1380;
			}
			break;
		default:
			break;
		}
	}

	public void setInitLayout() {
		setSize(50, 50);
		setIcon(noteBall);
		setLocation(x, 0);
		playerService.getmContext().add(this);
	}

	class judgeImage extends JLabel implements Runnable {

		private ImageIcon perfect;
		private ImageIcon excellent;
		private ImageIcon good;
		private ImageIcon bad;
		private ImageIcon miss;
		private Player player;

		private int x;
		private int y = 415;

		public judgeImage(Player player) {
			this.player = player;
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x = 260;
			} else if (player == Player.RIGHTPLAYER) {
				x = 1185;
			}
			perfect = new ImageIcon("images/combo/COMBO_PERFECT.png");
			excellent = new ImageIcon("images/combo/COMBO_EXCELLENT.png");
			good = new ImageIcon("images/combo/COMBO_GOOD.png");
			bad = new ImageIcon("images/combo/COMBO_BAD.png");
			miss = new ImageIcon("images/combo/miss.png");
		}

		public void setInitLayout() {
			setIcon(null);
			setLocation(x, y);
			setSize(132, 36);
			playerService.getmContext().add(this, 0);
		}

		@Override
		public void run() {
			while (DropNoteFrame.isRunning()) {
				if (isPerfect) {
					setIcon(perfect);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isPerfect = false;
					setIcon(null);
				} else if (isExcellent) {
					setIcon(excellent);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isExcellent = false;
					setIcon(null);
				} else if (isGood) {
					if (player == Player.LEFTPLAYER) {
						setLocation(290, y);
					} else {
						setLocation(1215, y);
					}
					setIcon(good);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isGood = false;
					setIcon(null);
				} else if (isBad) {
					if (player == Player.LEFTPLAYER) {
						setLocation(300, y);
					} else {
						setLocation(1225, y);
					}
					setIcon(bad);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isBad = false;
					setIcon(null);
				} else if (isMiss) {
					if (player == Player.LEFTPLAYER) {
						setLocation(293, y);
					} else {
						setLocation(1218, y);
					}
					setIcon(miss);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isMiss = false;
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

	public void judge() {
		if (y < 640) {
			return;
		}
		if (perfectZone()) {
			isPerfect = true;
			System.out.println("퍼펙트");
			playerService.getScore().perfect();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (excellentZone()) {
			isExcellent = true;
			System.out.println("엑설런트");
			playerService.getScore().excellent();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (goodZone()) {
			isGood = true;
			System.out.println("굿");
			playerService.getScore().good();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (badZone()) {
			isBad = true;
			System.out.println("배드");
			playerService.getScore().bad();
			isJudged = true;
			drop = false;
			setIcon(null);
		}
	}

	public void addEventListener() {
		playerService.getmContext().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (player == Player.LEFTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_A:
						if (place == LEFT && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_W:
						if (place == UP && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_D:
						if (place == RIGHT && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_S:
						if (place == DOWN && !isJudged) {
							judge();
						}
						break;
					default:
						break;
					}
				} else if (player == Player.RIGHTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if (place == LEFT && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_UP:
						if (place == UP && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_RIGHT:
						if (place == RIGHT && !isJudged) {
							judge();
						}
						break;
					case KeyEvent.VK_DOWN:
						if (place == DOWN && !isJudged) {
							judge();
						}
						break;
					default:
						break;
					}
				}
			}
		});
	}

	public boolean perfectZone() {
		if (y >= 705 && y <= 745) {
			return true;
		}
		return false;
	}

	public boolean excellentZone() {
		if (y >= 680 && y < 705) {
			return true;
		} else if (y > 745 && y < 770) {
			return true;
		}
		return false;
	}

	public boolean goodZone() {
		if (y >= 650 && y < 680) {
			return true;
		} else if (y >= 770 && y < 800) {
			return true;
		}
		return false;
	}

	public boolean badZone() {
		if (y >= 635 && y < 650) {
			return true;
		} else if (y >= 800 && y < 850) {
			return true;
		}
		return false;
	}

	public void drop() {
		if (y <= 850) {
			y += noteSpeed;
			setLocation(x, y);
		} else if (y > 850) {
			setIcon(null);
			isMiss = true;
			drop = false;
			playerService.getScore().bad();
		}
	}

	@Override
	public void run() {
		while (DropNoteFrame.isRunning()) {
			if (drop) {
				drop();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
	}

	public int getY() {
		return y;
	}

	public DropNotePlayerService getDropNotePlayerService() {
		return playerService;
	}

}
