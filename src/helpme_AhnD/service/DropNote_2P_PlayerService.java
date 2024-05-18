package helpme_AhnD.service;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import helpme_AhnD.dropnote_2p.*;
import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.state.Player;


public class DropNote_2P_PlayerService implements Runnable {

	DropNoteFrame_2P mContext;
	Player player;
	private DropNote note;
	private Score score;
	private int delay; // 노트 생성 시간 간격
	private int noteSpeed; // 노트의 속도

	public DropNote_2P_PlayerService(DropNoteFrame_2P mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		noteSpeed = DropNote.DEFAULT_SPEED;
		score = new Score(mContext, player);
		new ComboBox(this, player);
		new ScoreBox(this, player);
		new HpBox(this, player);
	}

	public void createNote() {
		note = new DropNote(this, player, noteSpeed);
		new Thread(note).start();
	}

	@Override
	public void run() {
		Timer start = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				while (DropNoteFrame_2P.isRunning()) {
					createNote();
					Random random = new Random();
					delay = random.nextInt(1000) + 500;

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
	public DropNoteFrame_2P getmContext() {
		return mContext;
	}

	public Score getScoreService() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setNoteSpeed(int noteSpeed) {
		this.noteSpeed = noteSpeed;
	}

}
