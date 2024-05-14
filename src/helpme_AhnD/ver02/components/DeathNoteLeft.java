package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNoteService;
import helpme_AhnD.ver02.service.PlayerService_js;

public class DeathNoteLeft extends DeathNote implements Runnable {
	DeathNoteLeft deathNoteLeft;
	PlayerService_js playerService;

	protected boolean keyIsPressed = true;
	protected boolean isJudged = false;
	private int EXCELLENT_CIRCLE;

	public DeathNoteLeft(int x, TestFrame testFrame) {
		super(x, testFrame);
		deathNoteLeft = this;
		addEventListener();
		
	}
	
	
	

	public void addEventListener() {
		testFrame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					new Thread(deathNoteLeft).start();

					break;

				default:

				}
			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					keyreleased();

					break;

				default:

				}
			}
		});
	}
	
	public void run() {
		gameStart = true;
		while (gameStart) {
			if (keyIsPressed) {
				keypresed();
				if (deathNoteCircle.circleExcellentZone()) { 
					//playerService.getScore().excellent();
					System.out.println("excellent");
					isJudged = true;
					break;
				} else if (deathNoteCircle.circlePerfecttZone()) {
					//playerService.getScore().perfect();
					System.out.println("perfect");
					isJudged = true;
					break;
				} else if (deathNoteCircle.circleGoodZone()) {
					//playerService.getScore().good();
					System.out.println("good");
					isJudged = true;
					break;
				} else if(deathNoteCircle.circleBadZone()) {
					//playerService.getScore().bad();
					System.out.println("bad");
					isJudged = true;
					break;
				}
			
				break;
			} // end of if
			
		} // end of while

	} // end of run
	
	@Override
	public void keypresed() {
		setIcon(note_Left_P);
	}
	@Override
	public void keyreleased() {
		setIcon(note_Left);
	}
}
