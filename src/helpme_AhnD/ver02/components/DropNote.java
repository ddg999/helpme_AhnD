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

	private boolean drop = true;
	private boolean isJudged = false;

	public DropNote(DropNotePlayerService playerService, Player player) {
		this.playerService = playerService;
		this.player = player;
		initData();
		setInitLayout();
		addEventListener();
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

	public void judge() {
		if (y < 570) {
			return;
		}
		if (perfectZone()) {
			System.out.println("퍼펙트");
			playerService.getScore().perfect();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (excellentZone()) {
			System.out.println("엑설런트");
			playerService.getScore().excellent();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (goodZone()) {
			System.out.println("굿");
			playerService.getScore().good();
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (badZone()) {
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
		if (y >= 700 && y <= 750) {
			return true;
		}
		return false;
	}

	public boolean excellentZone() {
		if (y >= 680 && y < 700) {
			return true;
		} else if (y > 750 && y < 770) {
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
		if (y >= 640 && y < 650) {
			return true;
		} else if (y >= 800 && y < 840) {
			return true;
		}
		return false;
	}

	public void drop() {
		if (y <= 840) {
			y += noteSpeed;
			setLocation(x, y);
		} else if (y > 840) {
			setIcon(null);
			drop = false;
			playerService.getScore().bad();
		}
	}

	@Override
	public void run() {
		while (true) {
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
}
