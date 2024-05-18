package ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ver02.Frame.DeathNoteFrame;
import ver02.Frame.DropNoteFrame_2P;
import ver02.Frame.GameSelectFrame;
import ver02.service.DeathNoteCircle;
import ver02.service.DeathNotePlayerService;
import ver02.state.KeyType;
import ver02.state.Player;

public class DeathNote extends JLabel implements Runnable {
	DeathNoteCircle deathNoteCircle;
	DeathNotePlayerService playerService;
	DeathNote deathNote;
	DeathNoteFrame mContext;

	protected ImageIcon note_Right;
	protected ImageIcon note_Left;
	protected ImageIcon note_Up;
	protected ImageIcon note_Down;
	protected ImageIcon note_Up_P;
	protected ImageIcon note_Left_P;
	protected ImageIcon note_Right_P;
	protected ImageIcon note_Down_P;
	protected final int NOTE_WIDTH = 85;
	protected final int NOTE_HIGHT = 85;
	protected final int NOTE_Y_LOCATION = 230;
	protected int location_X;
	protected Player player;
	private KeyType key;
	private int delay;

	protected boolean isJudged = false;

	public DeathNote(DeathNotePlayerService playerService, Player player, KeyType key) {
		mContext = playerService.getmContext();
		this.playerService = playerService;
		deathNote = this;
		this.player = player;
		this.key = key;
		initData();
		setInitLayout();
		addEventListener();
		new Thread(this).start();
		mContext.add(this);
	}

	private void initData() {
		note_Right = new ImageIcon("images/right.png"); // 샘플 이미지 변경
		note_Left = new ImageIcon("images/left.png"); // 샘플 이미지 변경
		note_Up = new ImageIcon("images/up.png"); // 샘플 이미지 변경
		note_Down = new ImageIcon("images/down.png"); // 샘플 이미지 변경
		note_Up_P = new ImageIcon("images/upp.png");
		note_Left_P = new ImageIcon("images/leftp.png");
		note_Right_P = new ImageIcon("images/rightp.png");
		note_Down_P = new ImageIcon("images/downp.png");
	}

	private void setInitLayout() {

		setSize(NOTE_WIDTH, NOTE_HIGHT);
		setX();
		setLocation(location_X, NOTE_Y_LOCATION);
		setIcon();
	}

	private void addEventListener() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (player == Player.LEFTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_A:
						if (key == KeyType.LEFT) {
							setIcon(note_Left_P);
							judge();
						}
						break;
					case KeyEvent.VK_W:
						if (key == KeyType.UP) {
							setIcon(note_Up_P);
							judge();
						}
						break;
					case KeyEvent.VK_S:
						if (key == KeyType.DOWN) {
							setIcon(note_Down_P);
							judge();
						}
						break;
					case KeyEvent.VK_D:
						if (key == KeyType.RIGHT) {
							setIcon(note_Right_P);
							judge();
						}
						break;
					}
				} else if (player == Player.RIGHTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if (key == KeyType.LEFT) {
							setIcon(note_Left_P);
							judge();
						}
						break;
					case KeyEvent.VK_UP:
						if (key == KeyType.UP) {
							setIcon(note_Up_P);
							judge();
						}
						break;
					case KeyEvent.VK_DOWN:
						if (key == KeyType.DOWN) {
							setIcon(note_Down_P);
							judge();
						}
						break;
					case KeyEvent.VK_RIGHT:
						if (key == KeyType.RIGHT) {
							setIcon(note_Right_P);
							judge();
						}
						break;
					}
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (player == Player.LEFTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_A:
						if (key == KeyType.LEFT) {
							setIcon(note_Left);
							judge();
						}
						break;
					case KeyEvent.VK_W:
						if (key == KeyType.UP) {
							setIcon(note_Up);
							judge();
						}
						break;
					case KeyEvent.VK_S:
						if (key == KeyType.DOWN) {
							setIcon(note_Down);
							judge();
						}
						break;
					case KeyEvent.VK_D:
						if (key == KeyType.RIGHT) {
							setIcon(note_Right);
							judge();
						}
						break;
					}
				} else if (player == Player.RIGHTPLAYER) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						if (key == KeyType.LEFT) {
							setIcon(note_Left);
							judge();
						}
						break;
					case KeyEvent.VK_UP:
						if (key == KeyType.UP) {
							setIcon(note_Up);
							judge();
						}
						break;
					case KeyEvent.VK_DOWN:
						if (key == KeyType.DOWN) {
							setIcon(note_Down);
							judge();
						}
						break;
					case KeyEvent.VK_RIGHT:
						if (key == KeyType.RIGHT) {
							setIcon(note_Right);
							judge();
						}
						break;
					}
				}

			}
		});
	}

	@Override
	public void run() {
		Timer start = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				while (GameSelectFrame.isGameRunning()) {
					deathNoteCircle = new DeathNoteCircle(deathNote, mContext, key);
					mContext.add(deathNoteCircle);
					Random random = new Random();
					delay = random.nextInt(3000) + 500;

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		start.schedule(task, 7000);
//		while (GameSelectFrame.isGameRunning()) {
//			
//			// 25% 확률로 생성됨
//			int create = (new Random()).nextInt(4);
//			try {
//				Thread.sleep(900);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (create == 0) {
//				deathNoteCircle = new DeathNoteCircle(this, mContext);
//				mContext.add(deathNoteCircle);
//
//			}
//		}
	}

	private void setX() {
		switch (key) {
		case LEFT:
			if (player == Player.LEFTPLAYER) {
				location_X = 80;
			} else {
				location_X = 1090;
			}
			break;
		case UP:
			if (player == Player.LEFTPLAYER) {
				location_X = 180;
			} else {
				location_X = 1190;
			}
			break;
		case DOWN:
			if (player == Player.LEFTPLAYER) {
				location_X = 280;
			} else {
				location_X = 1290;
			}
			break;
		case RIGHT:
			if (player == Player.LEFTPLAYER) {
				location_X = 380;
			} else {
				location_X = 1390;
			}
			break;
		}
	}

	public void setIcon() {
		switch (key) {
		case LEFT:
			setIcon(note_Left);
			break;
		case UP:
			setIcon(note_Up);
			break;
		case DOWN:
			setIcon(note_Down);
			break;
		case RIGHT:
			setIcon(note_Right);
			break;
		}
	}

	protected void judge() {
		if (deathNoteCircle == null) {
			return;
		}
		if (deathNoteCircle.circlePerfectZone()) {
			playerService.getScoreService_kh().perfect();
			System.out.println("perfect");
			isJudged = true;
		} else if (deathNoteCircle.circleExcellentZone()) {
			playerService.getScoreService_kh().excellent();
			System.out.println("excellent");
			isJudged = true;
		} else if (deathNoteCircle.circleGoodZone()) {
			playerService.getScoreService_kh().good();
			System.out.println("good");
			isJudged = true;
		} else if (deathNoteCircle.circleBadZone()) {
			playerService.getScoreService_kh().bad();
			System.out.println("bad");
			isJudged = true;
		}
	}

	public int getLocation_X() {
		return location_X;
	}

	public void setLocation_X(int location_X) {
		this.location_X = location_X;
	}

	public int getNOTE_Y_LOCATION() {
		return NOTE_Y_LOCATION;
	}

}
