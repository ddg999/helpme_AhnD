package helpme_AhnD.service;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import helpme_AhnD.components.ComboBox;
import helpme_AhnD.components.DropNote;
import helpme_AhnD.components.HpBox;
import helpme_AhnD.components.ScoreBox;
import helpme_AhnD.frame.DropNoteFrame_1P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.state.Player;

public class DropNote_1P_PlayerService extends PlayerService implements Runnable {

	GameSelectFrame mContext;
	DropNoteFrame_1P gameFrame;
	Player player;
	private Score score;
	private int delay;
	private int noteSpeed;

	public DropNote_1P_PlayerService(DropNoteFrame_1P gameFrame, Player player) {
		this.gameFrame = gameFrame;
		this.mContext = gameFrame.mContext;
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
	public DropNoteFrame_1P getDropNoteFrame_1P() {
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

}
