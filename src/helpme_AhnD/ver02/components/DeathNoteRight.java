package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.TestGameFrame_kh;
import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNoteService;
import helpme_AhnD.ver02.service.PlayerService;
import helpme_AhnD.ver02.service.PlayerService_js;

public class DeathNoteRight extends DeathNote implements Runnable {
	DeathNoteRight deathNoteRight;
	PlayerService_js playerService;

	protected boolean keyIsPressed = true;
	protected boolean isJudged = false;
	private int EXCELLENT_CIRCLE;

	public DeathNoteRight(int x, TestFrame testFrame) {
		super(x, testFrame);
		deathNoteRight = this;
		addEventListener();
	}
	
	
	

	public void addEventListener() {
		testFrame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_RIGHT:
					new Thread(deathNoteRight).start();

					break;

				default:

				}
			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				switch (e.getKeyCode()) {

				case KeyEvent.VK_RIGHT:
						setIcon(note_Img);

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
					playerService.getScore().excellent();
					System.out.println("excellent");
					isJudged = true;
				} else if (deathNoteCircle.circlePerfecttZone()) {
					playerService.getScore().perfect();
					System.out.println("perfect");
					isJudged = true;
				} else if (deathNoteCircle.GOOD_CIRCLE == deathNoteCircle.checkNow) {
					playerService.getScore().good();
					System.out.println("good");
					isJudged = true;
				} else {
					playerService.getScore().bad();
					System.out.println("bad");
					isJudged = true;
				}
				break;
			} // end of if
			
		} // end of while

	} // end of run

}
