package helpme_AhnD.ver02.service;

import java.util.Random;

import helpme_AhnD.ver02.Frame.FirstGameFrame;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.ScoreBox;

public class DropNotePlayerService implements Runnable {

	FirstGameFrame mContext;
	private DropNote note;
	private Score score;
	private int player;
	private int delay;

	public DropNotePlayerService(FirstGameFrame mContext, int player) {
		this.mContext = mContext;
		this.player = player;
		score = new Score(player);
		new HpBox(this, player);
		new ScoreBox(this, player);
		new ComboBox(this, player);
		new ItemBox(this);
	}

	private void createNote() {
		note = new DropNote(this, player);
		new Thread(note).start();
	}

	@Override
	public void run() {
		while (true) {
			createNote();
			Random random = new Random();
			delay = random.nextInt(800) + 400;

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public FirstGameFrame getmContext() {
		return mContext;
	}

	public Score getScore() {
		return score;
	}

}
