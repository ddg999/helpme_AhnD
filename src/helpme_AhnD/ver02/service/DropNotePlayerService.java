package helpme_AhnD.ver02.service;

import java.util.Random;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.ScoreBox;
import helpme_AhnD.ver02.state.Player;

public class DropNotePlayerService implements Runnable {

	DropNoteFrame mContext;
	Player player;
	private DropNote note;
	private Score score;
	private int delay;
	private ComboBox comboBox;

	public DropNotePlayerService(DropNoteFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		score = new Score(player);
		comboBox = new ComboBox(this, player);
		new ScoreBox(this, player);
		new HpBox(this, player);
	}

	public void createNote() {
		note = new DropNote(this, player);
		new Thread(note).start();
	}

	@Override
	public void run() {
		while (DropNoteFrame.isRunning()) {
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
	public DropNoteFrame getmContext() {
		return mContext;
	}

	public Score getScore() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}

}
