package ver02.service;

import java.util.Random;

import ver02.Frame.DropNoteFrame_hj;
import ver02.components.ComboBox_hj;
import ver02.components.DropNote_hj;
import ver02.components.HpBox_hj;
import ver02.components.ScoreBox_hj;
import ver02.state.Player;

public class DropNotePlayerService_hj implements Runnable {

	DropNoteFrame_hj mContext;
	Player player;
	private DropNote_hj note;
	private ScoreService_hj score;
	private int delay;
	private ComboBox_hj comboBox;
	private int noteSpeed;

	public DropNotePlayerService_hj(DropNoteFrame_hj mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		noteSpeed = DropNote_hj.DEFAULT_SPEED;
		score = new ScoreService_hj(mContext, player);
		comboBox = new ComboBox_hj(this, player);
		new ScoreBox_hj(this, player);
		new HpBox_hj(this, player);
	}

	public void createNote() {
		note = new DropNote_hj(this, player, noteSpeed);
		new Thread(note).start();
	}

	@Override
	public void run() {
		while (DropNoteFrame_hj.isRunning()) {
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

	// getter
	public DropNoteFrame_hj getmContext() {
		return mContext;
	}

	public ScoreService_hj getScoreService() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setNoteSpeed(int noteSpeed) {
		this.noteSpeed = noteSpeed;
	}

}
