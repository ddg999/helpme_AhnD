//package ver02.components;
//
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.util.Random;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//
//import ver02.Frame.DeathNoteFrame;
//import ver02.service.DeathNoteCircle;
//import ver02.service.DeathNotePlayerService;
//import ver02.service.DeathNoteService;
//import ver02.service.PlayerService_js;
//import ver02.state.Player;
//
//public class DeathNoteLeft extends DeathNote implements Runnable {
//	DeathNoteLeft deathNoteLeft;
//	DeathNotePlayerService playerService;
//
//	protected boolean isJudged = false;
//
//	public DeathNoteLeft(DeathNoteFrame mContext, DeathNotePlayerService playerService, Player player) {
//
//		super(mContext, playerService, player);
//		deathNoteLeft = this;
//		initData();
//		setInitLayout();
//		addEventListener();
//		mContext.add(deathNoteLeft);
//	}
//
//	public void initData() {
//		setIcon(note_Left);
//	}
//
//	private void setInitLayout() {
//		if (player == Player.LEFTPLAYER) {
//			location_X = 80;
//		} else {
//			location_X = 1090;
//		}
//		setLocation(location_X, NOTE_Y_LOCATION);
//	}
//
//	public void addEventListener() {
//		mContext.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_LEFT:
//					if (player == Player.RIGHTPLAYER) {
//						judge();
//					}
//					break;
//				case KeyEvent.VK_A:
//					if (player == Player.LEFTPLAYER) {
//						judge();
//					}
//					break;
//				default:
//					break;
//				}
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_LEFT:
//					if (player == Player.RIGHTPLAYER) {
//						keyreleased();
//					}
//					break;
//				case KeyEvent.VK_A:
//					if (player == Player.LEFTPLAYER) {
//						keyreleased();
//					}
//					break;
//				default:
//					break;
//				}
//
//			}
//
//		});
//	}
//
////	public void run() {
////		gameStart = true;
////		while (gameStart) {
////			if (keyIsPressed) {
////				keypresed();
////				try {
////
////					if (deathNoteCircle.circleExcellentZone()) {
////						playerService.getScoreService_kh().excellent();
////						System.out.println("excellent");
////						isJudged = true;
////						break;
////					} else if (deathNoteCircle.circlePerfecttZone()) {
////						playerService.getScoreService_kh().perfect();
////						System.out.println("perfect");
////						isJudged = true;
////						break;
////					} else if (deathNoteCircle.circleGoodZone()) {
////						playerService.getScoreService_kh().good();
////						System.out.println("good");
////						isJudged = true;
////						break;
////					} else if (deathNoteCircle.circleBadZone()) {
////						playerService.getScoreService_kh().bad();
////						System.out.println("bad");
////						isJudged = true;
////						break;
////					}
////
////					break;
////				} catch (Exception e) {
////					// TODO: handle exception
////				}
////			} // end of if
////		} // end of while
////	} // end of run
//
//	@Override
//	public void keypresed() {
//		setIcon(note_Left_P);
//	}
//
//	@Override
//	public void keyreleased() {
//		setIcon(note_Left);
//	}
//}
