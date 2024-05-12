package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;

import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.service.*;

public class DeathNoteService extends Thread {
	private static DeathNote deathNote;
	private static Score score;

	private boolean gameStart; // 게임 실행 확인
	private boolean keyIsPressed;
	int pressedScore;

	public DeathNoteService() {
		start();
		score = new Score();
	}

	@Override
	public void run() {
		gameStart = true;
		while (gameStart) {
			if (keyIsPressed) {
				deathNote.keypresed();
				if (pressedScore == 3) { // todo 숫자 3은 추후 변경 예정
					score.excellent();
				} else if (pressedScore == 2) {
					score.great();
				} else if (pressedScore == 1) {
					score.good();
				} else {
					score.bad();
				}
				break;
			} // end of while

		} // end of run

	}
}
