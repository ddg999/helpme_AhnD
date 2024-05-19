package helpme_AhnD.service;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import helpme_AhnD.components.ComboBox;
import helpme_AhnD.components.DropNote;
import helpme_AhnD.components.HpBox;
import helpme_AhnD.components.ScoreBox;
import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.state.Player;


public class DropNote_2P_PlayerService extends PlayerService implements Runnable {

	DropNoteFrame_2P gameFrame;
	GameSelectFrame mContext;
	Player player;
	private Score score;
	private int delay; // 노트 생성 시간 간격
	private int noteSpeed; // 노트의 속도

	public DropNote_2P_PlayerService(DropNoteFrame_2P gameFrame, Player player) {
		this.gameFrame = gameFrame;
		mContext = gameFrame.mContext;
		this.player = player;
		noteSpeed = DropNote.DEFAULT_SPEED;
		score = new Score(mContext, player);
		new ComboBox(this, player);
		new ScoreBox(this, player);
		new HpBox(this, player);
	}

	public void createNote() {
		new Thread(new DropNote(this, player, noteSpeed)).start();
	}

	@Override
	public void run() {
		Timer start = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				while (GameSelectFrame.isGameRunning()) {
					createNote();
					Random random = new Random();
					// 노트 빈도 조절 코드
					delay = random.nextInt(700) + 200;

					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		start.schedule(task, 7000);
	}

	// getter
	
	public DropNoteFrame_2P getDropNoteFrame_2P() {
		return gameFrame;
	}
	@Override
	public GameSelectFrame getmContext() {
		return mContext;
	}
	@Override
	public Score getScore() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setNoteSpeed(int noteSpeed) {
		this.noteSpeed = noteSpeed;
	}

}
