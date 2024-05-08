package helpme_AhnD.ver01.service;

public class Score {

	private int score;
	private int combo;
	private int countExcellent;
	private int countGreat;
	private int countGood;
	private int countBad;

	public Score() {
		score = 0;
		combo = 0;
		countExcellent = 0;
		countGreat = 0;
		countGood = 0;
		countBad = 0;
	}

	public void excellent() {
		score += 3;
		combo++;
		countExcellent++;
	}

	public void great() {
		score += 2;
		combo++;
		countGreat++;
	}

	public void good() {
		score += 1;
		combo++;
		countGood++;
	}

	public void bad() {
		countBad++;
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

	public int getCountExcellent() {
		return countExcellent;
	}

	public void setCountExcellent(int countExcellent) {
		this.countExcellent = countExcellent;
	}

	public int getCountGreat() {
		return countGreat;
	}

	public void setCountGreat(int countGreat) {
		this.countGreat = countGreat;
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
