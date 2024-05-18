package ver02.service;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ver02.components.DeathNote;
import ver02.components.DeathNoteLeft;
import ver02.service.*;

public class DeathNoteService extends Thread {
	private static DeathNote deathNote;
	private static DeathNoteCircle deathNoteCircle;
	DeathNoteService deathNoteService;
	PlayerService_js playerService;
	
	private boolean gameStart; // 게임 실행 확인
	private boolean keyIsPressed;
	private boolean isJudged = false;
	
	int pressedScore;
	private int place;

	public DeathNoteService(PlayerService_js playerService) {
		
		this.playerService = playerService;
	}

}