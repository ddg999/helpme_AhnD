package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.AhnteacherFrame2;

public class PlayerService implements Runnable {

	AhnteacherFrame2 mContext;

	private AhnCharacter player;
	private Score score;

	public PlayerService(AhnteacherFrame2 mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();
	}

	@Override
	public void run() {
		while (true) {
//			if (true) {
//				score.excellent();
//			}
//			if (true) {
//				score.great();
//			}
//			if (true) {
//				score.good();
//			}
//			if (true) {
//				score.bad();
//			}

			try {
				Thread.sleep(1);
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

	public AhnteacherFrame2 getmContext() {
		return mContext;
	}

	public void setmContext(AhnteacherFrame2 mContext) {
		this.mContext = mContext;
	}

}
