package helpme_AhnD.ver02.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.PlayerService;

public class Note_jw extends JLabel implements Runnable {

	PlayerService playerService;

	private ImageIcon noteBall;

	private int x;
	private int y;

	private int place; // 4곳 중 노트 나오는 지점
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;
	private int noteSpeed = 2; // 노트 속도
	private boolean drop = true;

	public Note_jw(PlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		noteBall = new ImageIcon("images/noteSample.png");
		Random random = new Random();
		place = random.nextInt(4);
		if (place == LEFT) {
			x = 300;
		} else if (place == UP) {
			x = 400;
		} else if (place == RIGHT) {
			x = 500;
		} else if (place == DOWN) {
			x = 600;
		}
	}

	public void setInitLayout() {
		setSize(100, 100);
		setIcon(noteBall);
		setLocation(x, 0);
		playerService.getmContext().add(this);
	}

	public void addEventListener() {
		playerService.getmContext().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (place == 0 && drop) {
						judge();
					}
					break;
				case KeyEvent.VK_UP:
					if (place == 1 && drop) {
						judge();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (place == 2 && drop) {
						judge();
					}
					break;
				case KeyEvent.VK_DOWN:
					if (place == 3 && drop) {
						judge();
					}
					break;

				default:
					break;
				}
			}
		});
	}

	private void judge() {
		if (y >= 570 && y < 600) {
			setIcon(null);
			System.out.println("BAD");
			playerService.getScore().bad();
			drop = false;
		} else if (y >= 600 && y < 640) {
			setIcon(null);
			System.out.println("GOOD");
			playerService.getScore().good();
			drop = false;
		} else if (y >= 640 && y < 680) {
			setIcon(null);
			System.out.println("EXCELLENT");
			playerService.getScore().excellent();
			drop = false;
		} else if (y >= 680 && y < 720) {
			setIcon(null);
			System.out.println("PERFECT");
			playerService.getScore().perfect();
			drop = false;
		} else if (y >= 720 && y < 760) {
			setIcon(null);
			System.out.println("EXCELLENT");
			playerService.getScore().excellent();
			drop = false;
		} else if (y >= 760 && y < 800) {
			setIcon(null);
			System.out.println("GOOD");
			playerService.getScore().good();
			drop = false;
		} else if (y >= 800 && y < 840) {
			setIcon(null);
			System.out.println("BAD");
			playerService.getScore().bad();
			drop = false;
		}
	}

	public void drop() {
		if (y <= 840) {
			y += noteSpeed;
			setLocation(x, y);
		} else if (y > 840) {
			setIcon(null);
			drop = false;
			System.out.println("BAD");
			playerService.getScore().bad();
		}
	}

	@Override
	public void run() {
		while (drop) {
			drop();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setNoteSpeed(int noteSpeed) {
		this.noteSpeed = noteSpeed;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}
}
