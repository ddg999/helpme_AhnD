package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.Frame.FirstGameFrame;
import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.ScoreBox;

public class DropNotePlayerService implements Runnable {

	FirstGameFrame mContext;
	private DropNote note;
	private AhnCharacter player;
	private Score score;
	private int testCount = 0;

	public DropNotePlayerService(FirstGameFrame mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ScoreBox(this)).start();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();

	}

	private void createNote() {
		note = new DropNote(this);
		new Thread(note).start();

	}

	@Override
	public void run() {
		while (true) {
			createNote();
			testCount++;
			if (testCount == 50) {
				break;
			}
			try {
				Thread.sleep(500);
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
