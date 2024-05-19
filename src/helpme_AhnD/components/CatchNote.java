package helpme_AhnD.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.service.PlayerService;
import helpme_AhnD.state.KeyType;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class CatchNote extends JLabel implements Runnable {
	GameSelectFrame mContext;
	PlayerService playerService;
	CatchNote catchNote;
	private CatchNoteArrow catchNoteArrow; // 노트에 서클이 중복되지 않기 위해 하나만을 가짐

	private ImageIcon note_Right;
	private ImageIcon note_Left;
	private ImageIcon note_Up;
	private ImageIcon note_Down;
	private ImageIcon note_Up_P;
	private ImageIcon note_Left_P;
	private ImageIcon note_Right_P;
	private ImageIcon note_Down_P;
	private final int NOTE_WIDTH = 85;
	private final int NOTE_HIGHT = 85;
	public final int NOTE_Y_LOCATION = 230;
	private int location_X;
	private Player player;
	private KeyType key;
	private int delay; // 노트 생성 시간 간격

	private boolean isCreated = false;

	public CatchNote(PlayerService playerService, Player player, KeyType key) {
		mContext = playerService.getmContext();
		this.playerService = playerService;
		catchNote = this;
		this.player = player;
		this.key = key;
		initData();
		setInitLayout();
		addEventListener();

		new Thread(this).start();
	}

	private void initData() {
		note_Left = new ImageIcon(Define.IMG_CATCHNOTE_LEFT);
		note_Up = new ImageIcon(Define.IMG_CATCHNOTE_UP);
		note_Down = new ImageIcon(Define.IMG_CATCHNOTE_DOWN);
		note_Right = new ImageIcon(Define.IMG_CATCHNOTE_RIGHT);
		note_Left_P = new ImageIcon(Define.IMG_CATCHNOTE_LEFT_PRESS);
		note_Up_P = new ImageIcon(Define.IMG_CATCHNOTE_UP_PRESS);
		note_Down_P = new ImageIcon(Define.IMG_CATCHNOTE_DOWN_PRESS);
		note_Right_P = new ImageIcon(Define.IMG_CATCHNOTE_RIGHT_PRESS);
	}

	private void setInitLayout() {

		setSize(NOTE_WIDTH, NOTE_HIGHT);
		setX();
		setLocation(location_X, NOTE_Y_LOCATION);
		setIcon();
		playerService.getTryCatchFrame_2P().add(this);
	}

	private void addEventListener() {
		// 키 입력 이벤트를 발생 시킬 위치 때문에 if else if가 필요함
		if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
			playerService.getTryCatchFrame_2P().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (player == Player.LEFTPLAYER) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_A:
							if (key == KeyType.LEFT) {
								setIcon(note_Left_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_W:
							if (key == KeyType.UP) {
								setIcon(note_Up_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_S:
							if (key == KeyType.DOWN) {
								setIcon(note_Down_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_D:
							if (key == KeyType.RIGHT) {
								setIcon(note_Right_P);
								catchNote.repaint();
								judge();
							}
							break;
						}
					} else if (player == Player.RIGHTPLAYER) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_LEFT:
							if (key == KeyType.LEFT) {
								setIcon(note_Left_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_UP:
							if (key == KeyType.UP) {
								setIcon(note_Up_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_DOWN:
							if (key == KeyType.DOWN) {
								setIcon(note_Down_P);
								catchNote.repaint();
								judge();
							}
							break;
						case KeyEvent.VK_RIGHT:
							if (key == KeyType.RIGHT) {
								setIcon(note_Right_P);
								catchNote.repaint();
								judge();
							}
							break;
						}
					}

				}

				@Override
				public void keyReleased(KeyEvent e) {
					if (player == Player.LEFTPLAYER) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_A:
							if (key == KeyType.LEFT) {
								setIcon(note_Left);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_W:
							if (key == KeyType.UP) {
								setIcon(note_Up);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_S:
							if (key == KeyType.DOWN) {
								setIcon(note_Down);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_D:
							if (key == KeyType.RIGHT) {
								setIcon(note_Right);
								catchNote.repaint();
							}
							break;
						}
					} else if (player == Player.RIGHTPLAYER) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_LEFT:
							if (key == KeyType.LEFT) {
								setIcon(note_Left);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_UP:
							if (key == KeyType.UP) {
								setIcon(note_Up);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_DOWN:
							if (key == KeyType.DOWN) {
								setIcon(note_Down);
								catchNote.repaint();
							}
							break;
						case KeyEvent.VK_RIGHT:
							if (key == KeyType.RIGHT) {
								setIcon(note_Right);
								catchNote.repaint();
							}
							break;
						}
					}

				}
			});
		}
	}

	@Override
	public void run() {
		Timer start = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				while (GameSelectFrame.isGameRunning()) {
					try {
						delay = (new Random()).nextInt(3000) + 900;
						Thread.sleep(delay);
						catchNoteArrow = new CatchNoteArrow(mContext, catchNote, key);
						if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
							playerService.getTryCatchFrame_2P().add(catchNoteArrow);
						} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_1P) {
						}
						synchronized (catchNoteArrow) {
							catchNoteArrow.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// todo 딜레이 늘려야함
		start.schedule(task, 1000);
	}

	private void setX() {
		switch (key) {
		case LEFT:
			if (player == Player.LEFTPLAYER) {
				location_X = 80;
			} else {
				location_X = 1090;
			}
			break;
		case UP:
			if (player == Player.LEFTPLAYER) {
				location_X = 180;
			} else {
				location_X = 1190;
			}
			break;
		case DOWN:
			if (player == Player.LEFTPLAYER) {
				location_X = 280;
			} else {
				location_X = 1290;
			}
			break;
		case RIGHT:
			if (player == Player.LEFTPLAYER) {
				location_X = 380;
			} else {
				location_X = 1390;
			}
			break;
		}
	}

	public void setIcon() {
		switch (key) {
		case LEFT:
			setIcon(note_Left);
			break;
		case UP:
			setIcon(note_Up);
			break;
		case DOWN:
			setIcon(note_Down);
			break;
		case RIGHT:
			setIcon(note_Right);
			break;
		}
	}

	protected void judge() {
		if (catchNoteArrow == null) {
			return;
		}
		if (catchNoteArrow.arrowPerfectZone()) {
			playerService.getScore().perfect();
			System.out.println("perfect");
			catchNoteArrow.setIcon(null);
			catchNoteArrow.setJudged(true);
			if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
				mContext.tryCatchFrame_2P.remove(catchNoteArrow);
				if (player == Player.LEFTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterLeft.playerScore = AhnCharacter.PERFECT;
				} else if (player == Player.RIGHTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterRight.playerScore = AhnCharacter.PERFECT;
				}
			} else {
				// todo 솔로 모드일때
			}
			catchNoteArrow.repaint();
		} else if (catchNoteArrow.arrowExcellentZone()) {
			playerService.getScore().excellent();
			System.out.println("excellent");
			catchNoteArrow.setIcon(null);
			catchNoteArrow.setJudged(true);
			if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
				mContext.tryCatchFrame_2P.remove(catchNoteArrow);
				if (player == Player.LEFTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterLeft.playerScore = AhnCharacter.EXCELLENT;
				} else if (player == Player.RIGHTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterRight.playerScore = AhnCharacter.EXCELLENT;
				}
			} else {
				// todo 솔로 모드일때
			}
			catchNoteArrow.repaint();
		} else if (catchNoteArrow.arrowGoodZone()) {
			playerService.getScore().good();
			System.out.println("good");
			catchNoteArrow.setIcon(null);
			catchNoteArrow.setJudged(true);
			if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
				mContext.tryCatchFrame_2P.remove(catchNoteArrow);
				if (player == Player.LEFTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterLeft.playerScore = AhnCharacter.EXCELLENT;
				} else if (player == Player.RIGHTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterRight.playerScore = AhnCharacter.EXCELLENT;
				}
			} else {
				// todo 솔로 모드일때
			}
			catchNoteArrow.repaint();
		} else if (catchNoteArrow.arrowBadZone()) {
			playerService.getScore().bad();
			System.out.println("bad");
			catchNoteArrow.setIcon(null);
			catchNoteArrow.setJudged(true);
			if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
				mContext.tryCatchFrame_2P.remove(catchNoteArrow);
				if (player == Player.LEFTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterLeft.playerScore = AhnCharacter.BAD;
				} else if (player == Player.RIGHTPLAYER) {
					mContext.tryCatchFrame_2P.ahnCharacterRight.playerScore = AhnCharacter.BAD;
				}
			} else {
				// todo 솔로 모드일때
			}
			catchNoteArrow.repaint();
		}
	}

	// getter setter
	public int getLocation_X() {
		return location_X;
	}

	public void setCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public CatchNoteArrow getCatchNoteArrow() {
		return catchNoteArrow;
	}

}
