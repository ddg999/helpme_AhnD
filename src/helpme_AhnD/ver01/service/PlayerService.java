package helpme_AhnD.ver01.service;

import helpme_AhnD.ver01.components.AhnCharacter;

public class PlayerService implements Runnable {

	private AhnCharacter player;
	private Score score;

	public PlayerService(AhnCharacter player) {
		this.player = player;
		score = new Score();

	}

	@Override
	public void run() {
		while (true) {
			if (true) {
				score.excellent();
			}
			if (true) {
				score.great();
			}
			if (true) {
				score.good();
			}
			if (true) {
				score.bad();
			}

		}
	}

}
