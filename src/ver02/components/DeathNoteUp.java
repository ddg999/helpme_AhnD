package ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ver02.Frame.DeathNoteFrame;
import ver02.service.DeathNoteCircle;
import ver02.service.DeathNotePlayerService;
import ver02.service.DeathNoteService;
import ver02.service.PlayerService_js;
import ver02.state.Player;

public class DeathNoteUp extends DeathNote implements Runnable {
	DeathNoteUp deathNoteUp;
	DeathNotePlayerService playerService;

	protected boolean isJudged = false;

	public DeathNoteUp(DeathNoteFrame mContext, DeathNotePlayerService playerService, Player player) {

		super(mContext, playerService, player);
		deathNoteUp = this;
		initData();
		setInitLayout();
		addEventListener();
		mContext.add(deathNoteUp);
	}

	public void initData() {
		setIcon(note_Up);
	}
	private void setInitLayout() {
		if (player == Player.LEFTPLAYER) {
			location_X = 180;
		} else {
			location_X = 1190;
		}
		setLocation(location_X, NOTE_Y_LOCATION);
	}

	public void addEventListener() {
		mContext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					if (player == Player.RIGHTPLAYER) {
						judge();
					}
					break;
				case KeyEvent.VK_W:
					if (player == Player.LEFTPLAYER) {
						judge();
					}
					break;
				default:
					break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					if (player == Player.RIGHTPLAYER) {
						keyreleased();
					}
					break;
				case KeyEvent.VK_W:
					if (player == Player.LEFTPLAYER) {
						keyreleased();
					}
					break;
				default:
					break;
				}
			}
		});
	}

//	public void run() {
//		gameStart = true;
//		while (gameStart) {
//			try {
//
//				if (keyIsPressed) {
//					keypresed();
//					if (deathNoteCircle.circleExcellentZone()) {
//						playerService.getScoreService_kh().excellent();
//						System.out.println("excellent");
//						isJudged = true;
//						break;
//					} else if (deathNoteCircle.circlePerfecttZone()) {
//						playerService.getScoreService_kh().perfect();
//						isJudged = true;
//						break;
//					} else if (deathNoteCircle.circleGoodZone()) {
//						playerService.getScoreService_kh().good();
//						System.out.println("good");
//						isJudged = true;
//						break;
//					} else if (deathNoteCircle.circleBadZone()) {
//						playerService.getScoreService_kh().bad();
//						System.out.println("bad");
//						isJudged = true;
//						break;
//					}
//
//					break;
//				} // end of if
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//
//		} // end of while
//
//	} // end of run

	@Override
	public void keypresed() {
		setIcon(note_Up_P);
	}

	@Override
	public void keyreleased() {
		setIcon(note_Up);
	}
}
