package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.FirstGameFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class DropNote extends JLabel implements Runnable {

	FirstGameFrame mContext;
	DropNotePlayerService playerService;

	private ImageIcon noteBall;

	private int x;
	private int y;

	private int place;
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;

	private boolean drop = true;
	private boolean isJudged = false;

	public DropNote(DropNotePlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		noteBall = new ImageIcon(Define.IMG_DROPNOTE_NOTE);
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
		setSize(50, 50);
		setIcon(noteBall);
		setLocation(x, 0);
		playerService.getmContext().add(this);
	}

	public void addEventListener() {
		playerService.getmContext().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT :
						if (place == LEFT && !isJudged) {
							if (y < 600) {
								break;
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
							} else {
								System.out.println("배드");
								playerService.getScore().bad();
								isJudged = true;
								drop = false;
								setIcon(null);
							}
						}
						break;
					case KeyEvent.VK_UP :
						if (place == UP && !isJudged) {
							if (y < 600) {
								break;
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
							} else {
								System.out.println("배드");
								playerService.getScore().bad();
								isJudged = true;
								drop = false;
								setIcon(null);
							}
						}
						break;
					case KeyEvent.VK_RIGHT :
						if (place == RIGHT && !isJudged) {
							if (y < 600) {
								break;
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
							} else {
								System.out.println("배드");
								playerService.getScore().bad();
								isJudged = true;
								drop = false;
								setIcon(null);
							}
						}
						break;
					case KeyEvent.VK_DOWN :
						if (place == DOWN && !isJudged) {
							if (y < 600) {
								break;
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
							} else {
								System.out.println("배드");
								playerService.getScore().bad();
								isJudged = true;
								drop = false;
								setIcon(null);
							}
						}
						break;
					default :
						break;
				}
			}
		});
	}

	public boolean perfectZone() {
		if (y <= 705 && y > 680) {
			return true;
		}
		return false;
	}

	public boolean excellentZone() {
		if (y <= 680 && y > 655) {
			return true;
		}
		return false;
	}

	public boolean goodZone() {
		if (y <= 655 && y > 630) {
			return true;
		}
		return false;
	}

	public void drop() {
		if (y <= 710) {
			y++;
			setLocation(x, y);
		} else {
			drop = false;
			playerService.getScore().bad();
		}
		if (y >= 700) {
			setIcon(null);
		}
	}

	@Override
	public void run() {
		while (true) {
			drop();
			if (drop) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
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
