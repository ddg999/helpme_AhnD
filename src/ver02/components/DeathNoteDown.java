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
//import ver02.state.KeyType;
//import ver02.state.Player;
//
//public class DeathNoteDown extends DeathNote implements Runnable {
//	DeathNoteDown deathNoteDown;
//	DeathNotePlayerService playerService;
//
//	protected boolean keyIsPressed = true;
//	protected boolean isJudged = false;
//	private int EXCELLENT_CIRCLE;
//
//	public DeathNoteDown(DeathNotePlayerService playerService, Player player, KeyType key) {
//		super(playerService, player, key);
//		deathNoteDown = this;
//		initData();
//		setInitLayout();
//		addEventListener();
//		mContext.add(deathNoteDown);
//	}
//
//	public void initData() {
//		setIcon(note_Down);
//		
//	}
//	private void setInitLayout() {
//		if (player == Player.LEFTPLAYER) {
//			location_X = 280;
//		} else {
//			location_X = 1290;
//		}
//		setLocation(location_X, NOTE_Y_LOCATION);
//	}
//
//	public void addEventListener() {
//		mContext.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				switch (e.getKeyCode()) {
//				case KeyEvent.VK_DOWN:
//					if (player == Player.RIGHTPLAYER) {
//						judge();
//					}
//					break;
//				case KeyEvent.VK_S:
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
//				case KeyEvent.VK_DOWN:
//					if (player == Player.RIGHTPLAYER) {
//						keyreleased();
//					}
//					break;
//				case KeyEvent.VK_S:
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
////			try {
////				if (keyIsPressed) {
////					keypresed();
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
////				} // end of if
////			} catch (Exception e) {
////				// TODO: handle exception
////			}
////
////		} // end of while
////
////	} // end of run
//
////	@Override
////	public void keypresed() {
////		setIcon(note_Down_P);
////	}
////
////	@Override
////	public void keyreleased() {
////		setIcon(note_Down);
////	}
//}
