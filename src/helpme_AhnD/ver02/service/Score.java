package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.state.Player;

public class Score {

	private int hp;
	private int score;
	private int combo;
	private int countPerfect;
	private int countExcellent;
	private int countGood;
	private int countBad;

	public Score(Player player) {
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
		} else {
			hp = 0;
		}
	}

	public void perfect() {
		score += 3;
		combo++;
		countPerfect++;
	}

	public void excellent() {
		score += 2;
		combo++;
		countExcellent++;
	}

	public void good() {
		score += 1;
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

}
