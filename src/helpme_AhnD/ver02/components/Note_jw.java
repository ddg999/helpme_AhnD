package helpme_AhnD.ver02.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.service.NoteService_jw;
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

	private boolean drop = true;

	public Note_jw(PlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
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

//		new NoteService_jw(this);
	}

	public void setInitLayout() {
		setSize(100, 100);
		setIcon(noteBall);
		setLocation(x, 0);
		playerService.getmContext().add(this);
	}

	public void drop() {
		if (y <= 701) {
			y++;
			setLocation(x, y);
		} else {
			drop = false;
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

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

}
