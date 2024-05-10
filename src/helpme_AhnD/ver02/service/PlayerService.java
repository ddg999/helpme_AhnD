package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.components.ScoreBox;
import helpme_AhnD.ver02.AhnteacherFrame_jw;

public class PlayerService implements Runnable {

	AhnteacherFrame_jw mContext;
	private AhnCharacter player;
	private Note_jw note;
	private Score score;

	public PlayerService(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ScoreBox(this)).start();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();
	}

	@Override
	public void run() {
		while (true) {
			note = new Note_jw(this);
			new Thread(note).start();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public AhnCharacter getPlayer() {
		return player;
	}

	public void setPlayer(AhnCharacter player) {
		this.player = player;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public AhnteacherFrame_jw getmContext() {
		return mContext;
	}

	public void setmContext(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
	}

	public Note_jw getNote() {
		return note;
	}

	public void setNote(Note_jw note) {
		this.note = note;
	}

}
