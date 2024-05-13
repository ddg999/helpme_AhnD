package helpme_AhnD.ver02.service;

import java.util.Random;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.components.ScoreBox;

public class PlayerService implements Runnable {

	AhnteacherFrame_jw mContext;
	private Note_jw note;
	private AhnCharacter player;
	private Score score;

	public PlayerService(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ScoreBox(this)).start();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();

	}

	private void createNote() {
		note = new Note_jw(this);
		new Thread(note).start();
	}

	@Override
	public void run() {
		while (true) {
			Random random = new Random();
			int delay = random.nextInt(1000) + 300;
			createNote();
			try {
				Thread.sleep(delay);
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
