package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.Frame.GameEndFrame;
import helpme_AhnD.ver02.state.Player;

public class ScoreService {
	
	private DropNoteFrame mContext;
	private Player player;
	private int hp;
	private int score;
	private int combo;
	private int countPerfect;
	private int countExcellent;
	private int countGood;
	private int countBad;
	private static boolean isJudged = false;
	private boolean isDouble;
	private boolean isAllPerfect;
	private boolean isNeverPerfect;

	public ScoreService(DropNoteFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		hp = 60;
		score = 0;
		combo = 0;
		countPerfect = 0;
		countExcellent = 0;
		countGood = 0;
		countBad = 0;
	}

	public void beAttacked() {
		if (hp >= 10) {
			hp -= 10;
			if (hp == 0) {
				isJudged = true;
				mContext.setVisible(false);
				mContext.setRunning(false);
				new GameEndFrame(mContext, player);
			}
		} else {
			hp = 0;
		}
	}

	public void perfect() {
		if (isDouble) {
			score += 6;
		} else {
			score += 3;
		}
		if (isNeverPerfect) {
			score -= 1;
		}
		combo++;
		countPerfect++;
	}

	public void excellent() {
		if (isDouble) {
			score += 4;
		} else {
			score += 2;
		}
		if (isAllPerfect) {
			score += 1;
		}
		combo++;
		countExcellent++;
	}

	public void good() {
		if (isDouble) {
			score += 2;
		} else {
			score += 1;
		}
		if (isAllPerfect) {
			score += 2;
		}
		combo++;
		countGood++;
	}

	public void bad() {
		beAttacked();
		combo = 0;
		countBad++;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getCountPerfect() {
		return countPerfect;
	}

	public void setCountPerfect(int countPerfect) {
		this.countPerfect = countPerfect;
	}

	public int getCountExcellent() {
		return countExcellent;
	}

	public void setCountExcellent(int countExcellent) {
		this.countExcellent = countExcellent;
	}

	public int getCountGood() {
		return countGood;
	}

	public void setCountGood(int countGood) {
		this.countGood = countGood;
	}

	public int getCountBad() {
		return countBad;
	}

	public void setCountBad(int countBad) {
		this.countBad = countBad;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public void setAllPerfect(boolean isAllPerfect) {
		this.isAllPerfect = isAllPerfect;
	}

	public void setNeverPerfect(boolean isNeverPerfect) {
		this.isNeverPerfect = isNeverPerfect;
	}
	

}
