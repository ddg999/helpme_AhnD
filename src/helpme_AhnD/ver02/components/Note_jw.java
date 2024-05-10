package helpme_AhnD.ver02.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.service.PlayerService;

public class Note_jw extends JLabel implements Runnable {

	AhnteacherFrame_jw mContext;
	PlayerService playerService;

	private ImageIcon noteBall;

	private int x;
	private int y;

	private int place;
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;

	private boolean goDown = true; // 내려가는동작

	public Note_jw(PlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
	}

	public void initData() {
		noteBall = new ImageIcon("images/noteSample.png");
		Random random = new Random();
		place = random.nextInt(4);
//		new Thread(new NoteService_jw(this)).start();
	}

	public void setInitLayout() {
		setSize(100, 100);
		if (place == LEFT) {
			x = 300;
		} else if (place == UP) {
			x = 400;
		} else if (place == RIGHT) {
			x = 500;
		} else if (place == DOWN) {
			x = 600;
		}
		setIcon(noteBall);
		setLocation(x, 0);
		playerService.getmContext().add(this);
	}

	public void check() {
		if (getY() >= 500 && getY() <= 750 && place == LEFT) {
			System.out.println("왼쪽방향");
		} else if (getY() >= 500 && getY() <= 750 && place == UP) {
			System.out.println("위방향");
		} else if (getY() >= 500 && getY() <= 750 && place == RIGHT) {
			System.out.println("오른쪽방향");
		} else if (getY() >= 500 && getY() <= 750 && place == DOWN) {
			System.out.println("아래방향");
		}
	}

	@Override
	public void run() {
		while (goDown && y <= 850) {
			y++;
			setLocation(x, y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setIcon(null);
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public AhnteacherFrame_jw getmContext() {
		return mContext;
	}

	public void setmContext(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
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

	public boolean isGoDown() {
		return goDown;
	}

	public void setGoDown(boolean goDown) {
		this.goDown = goDown;
	}

}
