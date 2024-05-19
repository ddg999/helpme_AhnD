package helpme_AhnD.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.PlayerService;
import helpme_AhnD.state.*;
import helpme_AhnD.utils.Define;

public class DropNote extends JLabel implements Runnable {

	GameSelectFrame mContext;
	PlayerService playerService;
	private Player player;

	private ImageIcon noteBall;

	private int x;
	private int y;
	private int noteSpeed;
	public static final int DEFAULT_SPEED = 2;

	private int place;
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;

	private boolean isPerfect;
	private boolean isExcellent;
	private boolean isGood;
	private boolean isBad;
	private boolean isMiss;

	private boolean drop = true; // 노트 드랍 깃발
	private boolean isJudged = false; // 판정 관련 깃발

	// 키 반전 아이템을 위한 깃발
	private static boolean leftReverse;
	private static boolean rightReverse;

	public DropNote(PlayerService playerService, Player player, int speed) {
		this.playerService = playerService;
		mContext = playerService.getmContext();
		this.player = player;
		this.noteSpeed = speed;
		initData();
		setInitLayout();
		addEventListener();
		new Thread(new JudgeImage(player)).start();
	}

	public void initData() {
		noteBall = new ImageIcon(Define.IMG_DROPNOTE_NOTE);
		place = (new Random()).nextInt(4); // 4방향 랜덤 생성
		switch (player) {
		case LEFTPLAYER:
			if (place == LEFT) {
				x = 150;
			} else if (place == UP) {
				x = 250;
			} else if (place == DOWN) {
				x = 350;
			} else if (place == RIGHT) {
				x = 450;
			}
			break;
		case RIGHTPLAYER:
			if (place == LEFT) {
				x = 1080;
			} else if (place == UP) {
				x = 1180;
			} else if (place == DOWN) {
				x = 1280;
			} else if (place == RIGHT) {
				x = 1380;
			}
			break;
		case SOLO:
			if (place == LEFT) {
				x = 615;
			} else if (place == UP) {
				x = 715;
			} else if (place == DOWN) {
				x = 815;
			} else if (place == RIGHT) {
				x = 915;
			}
			break;
		default:
			break;
		}
	}

	public void setInitLayout() {
		setSize(50, 50);
		setIcon(noteBall);
		setLocation(x, 0);
		if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_2P) {
			playerService.getDropNoteFrame_2P().add(this);
		} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_1P) {
			playerService.getDropNoteFrame_1P().add(this);
		}
	}

	public void addEventListener() {
		// 키 입력 이벤트를 발생 시킬 위치 때문에 if else if가 필요함
		if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_2P) {
			playerService.getDropNoteFrame_2P().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int getKeyCode = e.getKeyCode();

					// 키 반전 상태일경우 반전
					if (leftReverse || rightReverse) {
						getKeyCode = reverse(getKeyCode);
					}
					if (player == Player.LEFTPLAYER) {
						switch (getKeyCode) {
						case KeyEvent.VK_A:
							if (place == LEFT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_W:
							if (place == UP && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_D:
							if (place == RIGHT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_S:
							if (place == DOWN && !isJudged) {
								judge();
							}
							break;
						default:
							break;
						}
					} else if (player == Player.RIGHTPLAYER) {
						switch (getKeyCode) {
						case KeyEvent.VK_LEFT:
							if (place == LEFT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_UP:
							if (place == UP && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_RIGHT:
							if (place == RIGHT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_DOWN:
							if (place == DOWN && !isJudged) {
								judge();
							}
							break;
						default:
							break;
						}
					}
				}
			});
		} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_1P) {
			playerService.getDropNoteFrame_1P().addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (player == Player.SOLO) {
						switch (e.getKeyCode()) {
						case KeyEvent.VK_A:
							if (place == LEFT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_W:
							if (place == UP && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_D:
							if (place == RIGHT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_S:
							if (place == DOWN && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_LEFT:
							if (place == LEFT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_UP:
							if (place == UP && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_RIGHT:
							if (place == RIGHT && !isJudged) {
								judge();
							}
							break;
						case KeyEvent.VK_DOWN:
							if (place == DOWN && !isJudged) {
								judge();
							}
							break;
						default:
							break;
						}
					}
				}
			});
		}
	}

	// 판정 메소드
	public void judge() {
		// 일정 높이 이상에서는 판정 하지 않음
		if (y < 650) {
			return;
		}
		if (perfectZone()) {
			isPerfect = true;
			System.out.println("퍼펙트");
			playerService.getScore().judgeScore(ScoreType.PERFECT);
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (excellentZone()) {
			isExcellent = true;
			System.out.println("엑설런트");
			playerService.getScore().judgeScore(ScoreType.EXCELLENT);
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (goodZone()) {
			isGood = true;
			System.out.println("굿");
			playerService.getScore().judgeScore(ScoreType.GOOD);
			isJudged = true;
			drop = false;
			setIcon(null);
		} else if (badZone()) {
			isBad = true;
			System.out.println("배드");
			playerService.getScore().judgeScore(ScoreType.BAD);
			isJudged = true;
			drop = false;
			setIcon(null);
		}
	}

	// 노트 움직임
	public void drop() {
		if (y <= 850) {
			y += noteSpeed;
			setLocation(x, y);
		} else if (y > 850) {
			setIcon(null);
			isMiss = true;
			drop = false;
			playerService.getScore().miss();
		}
	}

	@Override
	public void run() {
		while (GameSelectFrame.isGameRunning()) {
			if (drop) {
				drop();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
		}
	}

	// 판정 결과 이미지 출력용 내부 클래스
	class JudgeImage extends JLabel implements Runnable {

		private ImageIcon perfect;
		private ImageIcon excellent;
		private ImageIcon good;
		private ImageIcon bad;
		private ImageIcon miss;
		private Player player;

		private int x;
		private int y = 415;

		public JudgeImage(Player player) {
			this.player = player;
			initData();
			setInitLayout();
		}

		public void initData() {
			if (player == Player.LEFTPLAYER) {
				x = 260;
			} else if (player == Player.RIGHTPLAYER) {
				x = 1185;
			} else if (player == Player.SOLO) {
				x = 723;
			}
			perfect = new ImageIcon(Define.IMG_COMBO_PERFECT);
			excellent = new ImageIcon(Define.IMG_COMBO_EXCELLENT);
			good = new ImageIcon(Define.IMG_COMBO_GOOD);
			bad = new ImageIcon(Define.IMG_COMBO_BAD);
			miss = new ImageIcon(Define.IMG_COMBO_MISS);
		}

		public void setInitLayout() {
			setIcon(null);
			setLocation(x, y);
			setSize(132, 36);
			if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_2P) {
				playerService.getDropNoteFrame_2P().add(this, 0);
			} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_1P) {
				playerService.getDropNoteFrame_1P().add(this, 0);
			}
		}

		@Override
		public void run() {
			while (GameSelectFrame.isGameRunning()) {
				if (isPerfect) {
					if (player == Player.LEFTPLAYER) {
						setLocation(260, y);
					} else if (player == Player.RIGHTPLAYER) {
						setLocation(1185, y);
					} else if (player == Player.SOLO) {
						setLocation(723, y);
					}
					setIcon(perfect);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isPerfect = false;
					setIcon(null);
				} else if (isExcellent) {
					if (player == Player.LEFTPLAYER) {
						setLocation(260, y);
					} else if (player == Player.RIGHTPLAYER) {
						setLocation(1185, y);
					} else if (player == Player.SOLO) {
						setLocation(723, y);
					}
					setIcon(excellent);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isExcellent = false;
					setIcon(null);
				} else if (isGood) {
					if (player == Player.LEFTPLAYER) {
						setLocation(290, y);
					} else if (player == Player.RIGHTPLAYER) {
						setLocation(1215, y);
					} else if (player == Player.SOLO) {
						setLocation(753, y);
					}
					setIcon(good);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isGood = false;
					setIcon(null);
				} else if (isBad) {
					if (player == Player.LEFTPLAYER) {
						setLocation(300, y);
					} else if (player == Player.RIGHTPLAYER) {
						setLocation(1225, y);
					} else if (player == Player.SOLO) {
						setLocation(763, y);
					}
					setIcon(bad);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isBad = false;
					setIcon(null);
				} else if (isMiss) {
					if (player == Player.LEFTPLAYER) {
						setLocation(293, y);
					} else if (player == Player.RIGHTPLAYER) {
						setLocation(1218, y);
					} else if (player == Player.SOLO) {
						setLocation(756, y);
					}
					setIcon(miss);
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isMiss = false;
					setIcon(null);
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 판정 범위 확인용 메소드
	public boolean perfectZone() {
		if (y >= 705 && y <= 745) {
			return true;
		}
		return false;
	}

	public boolean excellentZone() {
		if (y >= 680 && y < 705) {
			return true;
		} else if (y > 745 && y < 770) {
			return true;
		}
		return false;
	}

	public boolean goodZone() {
		if (y >= 650 && y < 680) {
			return true;
		} else if (y >= 770 && y < 800) {
			return true;
		}
		return false;
	}

	public boolean badZone() {
		if (y >= 635 && y < 650) {
			return true;
		} else if (y >= 800 && y < 850) {
			return true;
		}
		return false;
	}

	// 키반전 메소드
	private int reverse(int keyCode) {
		if (leftReverse) {
			switch (keyCode) {
			case KeyEvent.VK_W:
				return KeyEvent.VK_S;
			case KeyEvent.VK_S:
				return KeyEvent.VK_W;
			case KeyEvent.VK_A:
				return KeyEvent.VK_D;
			case KeyEvent.VK_D:
				return KeyEvent.VK_A;
			default:
				return keyCode;
			}
		} else {
			switch (keyCode) {
			case KeyEvent.VK_UP:
				return KeyEvent.VK_DOWN;
			case KeyEvent.VK_DOWN:
				return KeyEvent.VK_UP;
			case KeyEvent.VK_LEFT:
				return KeyEvent.VK_RIGHT;
			case KeyEvent.VK_RIGHT:
				return KeyEvent.VK_LEFT;
			default:
				return keyCode;
			}
		}
	}

	// setter
	public static void setLeftReverse(boolean input) {
		leftReverse = input;
	}

	public static void setRightReverse(boolean input) {
		rightReverse = input;
	}

}
