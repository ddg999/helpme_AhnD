package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DeathNoteFrame;
import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DeathNoteService;
import helpme_AhnD.ver02.service.PlayerService_js;

public class DeathNoteDown extends DeathNote implements Runnable {
	DeathNoteDown deathNoteDown;
	DeathNotePlayerService playerService;
	
	protected boolean keyIsPressed = true;
	protected boolean isJudged = false;
	private int EXCELLENT_CIRCLE;

	public DeathNoteDown(int x, DeathNoteFrame mContext,DeathNotePlayerService playerService) {
		super(x, mContext,playerService);
		deathNoteDown = this;
		addEventListener();
		initData();
		mContext.add(deathNoteDown);
	}
	public void initData(){
		setIcon(note_Down);
		}
	
	

	public void addEventListener() {
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_DOWN:
					new Thread(deathNoteDown).start();

					break;

				default:

				}
			}
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				switch (e.getKeyCode()) {

				case KeyEvent.VK_DOWN:
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
			try {
			if (keyIsPressed) {
				keypresed();
				if (deathNoteCircle.circleExcellentZone()) { 
					playerService.getScore().excellent();
					System.out.println("excellent");
					isJudged = true;
					break;
				} else if (deathNoteCircle.circlePerfecttZone()) {
					playerService.getScore().perfect();
					System.out.println("perfect");
					isJudged = true;
					break;
				} else if (deathNoteCircle.circleGoodZone()) {
					playerService.getScore().good();
					System.out.println("good");
					isJudged = true;
					break;
				} else if(deathNoteCircle.circleBadZone()) {
					playerService.getScore().bad();
					System.out.println("bad");
					isJudged = true;
					break;
				}
			
				break;
			} // end of if
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} // end of while

	} // end of run
	
	@Override
	public void keypresed() {
		setIcon(note_Down_P);
	}
	@Override
	public void keyreleased() {
		setIcon(note_Down);
	}
}
