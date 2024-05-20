//package ver02.components;
//
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import ver02.Frame.DeathNoteFrame;
//import ver02.service.DeathNotePlayerService;
//import ver02.state.Player;
//
//public class DeathNoteRight extends DeathNote implements Runnable {
//	DeathNoteRight deathNoteRight;
//	DeathNotePlayerService playerService;
//
//	protected boolean isJudged = false;
//
//	public DeathNoteRight(DeathNoteFrame mContext, DeathNotePlayerService playerService, Player player) {
//
//		super(mContext, playerService, player);
//		deathNoteRight = this;
//		initData();
//		setInitLayout();
//		addEventListener();
//		mContext.add(deathNoteRight);
//	}
//
//	public void initData() {
//		setIcon(note_Right);
//	}
//	private void setInitLayout() {
//		if (player == Player.LEFTPLAYER) {
//			location_X = 380;
//		} else {
//			location_X = 1390;
//		}
//		setLocation(location_X, NOTE_Y_LOCATION);
//	}
//
//	public void addEventListener() {
//		mContext.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_RIGHT:
//					if (player == Player.RIGHTPLAYER) {
//						judge();
//					}
//					break;
//				case KeyEvent.VK_D:
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
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_RIGHT:
//					if (player == Player.RIGHTPLAYER) {
//						keyreleased();
//					}
//					break;
//				case KeyEvent.VK_D:
//					if (player == Player.LEFTPLAYER) {
//						keyreleased();
//					}
//					break;
//				default:
//					break;
//				}
//			}
//		});
//	}
//
////	public void run() {
////
////		gameStart = true;
////		while (gameStart) {
////
////			try {
////
////				if (keyIsPressed) {
////					keypresed();
////					if (deathNoteCircle.circleExcellentZone()) {
////						playerService.getScoreService_kh().excellent();
////						System.out.println("excellent");
////						isJudged = true;
////						break;
////					} else if (deathNoteCircle.circlePerfectZone()) {
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
////				} // end of if
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////
////		} // end of while
////
////	} // end of run
//
//	@Override
//	public void keypresed() {
//		setIcon(note_Right_P);
//	}
//
//	@Override
//	public void keyreleased() {
//		setIcon(note_Right);
//	}
//}
