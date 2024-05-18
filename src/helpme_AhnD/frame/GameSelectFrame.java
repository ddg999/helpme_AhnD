package helpme_AhnD.frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.service.BGM;
import helpme_AhnD.utils.Define;
import ver02.Frame.DeathNoteFrame;

public class GameSelectFrame extends JFrame {

	// 메인 프레임 참조
	private MainFrame mContext;
	// 셀프 참조
	private GameSelectFrame thisFrame;

	// 라벨
	private JLabel background; // background
	private JLabel gameLabel; // 노래 앨범
	private JLabel gameTitle; // 노래 제목
	private final int TITLE_WIDTH = 241;
	private final int TITLE_HEIGHT = 31;
	private final int TITLE_X = 680;
	private final int TITLE_Y = 141;

	// 이미지
	private ImageIcon[] gameLabelImg;
	private ImageIcon[] gameTitleImg;
	private final int GAMENAME_DROPNOTE_2P = 0;
	private final int GAMENAME_DROPNOTE_1P = 1;
	private final int GAMENAME_TRYCATCH_2P = 2;
	private final int GAMENAME_TRYCATCH_1P = 3;
	// private final int GAMENAME_FIFTHGAME = 4;
	private int selectNumber; // 게임 번호 선택

	private ImageIcon musicStopImg;
	private ImageIcon musicPlayImg;

	// 버튼
	private JLabel leftButton; // 왼쪽 버튼
	private JLabel rightButton; // 오른쪽 버튼
	private JLabel startButton; // 시작 버튼
	private JLabel backButton; // 뒤로가기 버튼
	private JLabel musicButton; // 음악 재생

	// 게임 실행 확인용 깃발
	private static boolean gameRunning;
	
	// 음악
	private BGM bgm;
	boolean isMusicPlay;

	public GameSelectFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public GameSelectFrame(MainFrame mContext) {
		this.mContext = mContext;
		thisFrame = this;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setTitle("게임 선택 화면");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 배경
		background = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_BG));

		// 노래 앨범
		gameLabelImg = new ImageIcon[5];
		gameLabelImg[GAMENAME_DROPNOTE_2P] = new ImageIcon(Define.IMG_SELECTFRAME_FIRSTGAME);
		gameLabelImg[GAMENAME_DROPNOTE_1P] = new ImageIcon(Define.IMG_SELECTFRAME_SECONDGAME);
		gameLabelImg[GAMENAME_TRYCATCH_2P] = new ImageIcon(Define.IMG_SELECTFRAME_THIRDGAME);
		gameLabelImg[GAMENAME_TRYCATCH_1P] = new ImageIcon(Define.IMG_SELECTFRAME_FOURTHGAME);
		//gameLabelImg[GAMENAME_FIFTHGAME] = new ImageIcon(Define.IMG_SELECTFRAME_FIFTHGAME);
		gameLabel = new JLabel(gameLabelImg[GAMENAME_DROPNOTE_2P]);

		// 노래 제목
		gameTitleImg = new ImageIcon[5];
		gameTitleImg[GAMENAME_DROPNOTE_2P] = new ImageIcon(Define.IMG_SELECTFRAME_FIRSTTITLE);
		gameTitleImg[GAMENAME_DROPNOTE_1P] = new ImageIcon(Define.IMG_SELECTFRAME_SECONDTITLE);
		gameTitleImg[GAMENAME_TRYCATCH_2P] = new ImageIcon(Define.IMG_SELECTFRAME_THIRDTITLE);
		gameTitleImg[GAMENAME_TRYCATCH_1P] = new ImageIcon(Define.IMG_SELECTFRAME_FOURTHTITLE);
		//gameTitleImg[GAMENAME_FIFTHGAME] = new ImageIcon(Define.IMG_SELECTFRAME_FIFTHTITLE);
		gameTitle = new JLabel(gameTitleImg[GAMENAME_DROPNOTE_2P]);

		// 왼쪽 버튼
		leftButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFT));

		// 오른쪽 버튼
		rightButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHT));

		// 음악 재생, 정지
		musicPlayImg = new ImageIcon(Define.IMG_SELECTFRAME_MUSICPLAY);
		musicStopImg = new ImageIcon(Define.IMG_SELECTFRAME_MUSICSTOP);
		musicButton = new JLabel(musicPlayImg);

		// 게임 시작 버튼
		startButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_START));

		// 뒤로 가기 버튼
		backButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_BACK));

		selectNumber = GAMENAME_DROPNOTE_2P;
	}

	private void setInitLayout() {
		setLocationRelativeTo(null);
		setLayout(null);

		add(background);
		background.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		background.setLocation(0, 0);

		background.add(gameLabel);
		gameLabel.setSize(500, 500);
		gameLabel.setLocation(550, 200);

		background.add(gameTitle);
		gameTitle.setSize(TITLE_WIDTH, TITLE_HEIGHT);
		gameTitle.setLocation(TITLE_X, TITLE_Y);
		// songTitle.setSize(354, 35);
		// songTitle.setLocation(620, 140);

		background.add(leftButton);
		leftButton.setSize(71, 78);
		leftButton.setLocation(442, 411);

		background.add(rightButton);
		rightButton.setSize(71, 78);
		rightButton.setLocation(1085, 411);

		background.add(musicButton);
		musicButton.setSize(30, 30);
		musicButton.setLocation(550, 710);

		background.add(startButton);
		startButton.setSize(150, 47);
		startButton.setLocation(720, 760);

		background.add(backButton);
		backButton.setSize(150, 47);
		backButton.setLocation(1420, 30);

		setVisible(true);
	}

	// 상호 작용 종류
	// 1. 좌우 게임 변경 2. 게임 시작 3. 음악 재생 4. 뒤로가기
	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 눌렀을 땐 이미지만 변경
					leftButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFTCLICK));
					break;
				case KeyEvent.VK_RIGHT:
					// 눌렀을 땐 이미지만 변경
					rightButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHTCLICK));
					break;
				case KeyEvent.VK_S:
					// 눌렀을 땐 이미지만 변경
					startButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_STARTCLICK));
					break;
				case KeyEvent.VK_BACK_SPACE:
					// 눌렀을 땐 이미지만 변경
					backButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_BACKCLICK));
					break;
				case KeyEvent.VK_SPACE:
					// 스페이스 버튼 하나로 음악 재생 정지 둘다
					if (!isMusicPlay) {
						musicButton.setIcon(musicStopImg);
						bgm = mContext.getBgmService().createBGM(); // bgm 객체 생성
						bgm.getClip().start(); // 생성된 음악 재생
						isMusicPlay = true;
					} else {
						musicButton.setIcon(musicPlayImg);
						bgm.getClip().close(); // 음악 닫기
						isMusicPlay = false;
					}
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 배열 인덱스 번호 --
					// 최소값일 경우 제일 마지막으로
					if (selectNumber == GAMENAME_DROPNOTE_2P) {
						selectNumber = GAMENAME_TRYCATCH_1P;
					} else {
						selectNumber--;
					}
					selectGame(selectNumber);
					leftButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFT));
					break;
				case KeyEvent.VK_RIGHT:
					// 배열 인덱스 번호 ++
					// 최대값일 경우 제일 처음으로
					if (selectNumber == GAMENAME_TRYCATCH_1P) {
						selectNumber = GAMENAME_DROPNOTE_2P;
					} else {
						selectNumber++;
					}
					selectGame(selectNumber);
					rightButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHT));
					break;
				case KeyEvent.VK_S:
					startButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_START));
					if (bgm != null) {
						// 혹시 음악이 틀어져 있다면 끔
						bgm.getClip().close();
					}
					gameRunning = true;
					switch (selectNumber) {
					case GAMENAME_DROPNOTE_2P :
						new DropNoteFrame_2P(thisFrame);
						setVisible(false);
						break;
					case GAMENAME_DROPNOTE_1P :
						new DeathNoteFrame(thisFrame);
						setVisible(false);
						break;
					}
					break;
				case KeyEvent.VK_BACK_SPACE:
					backButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_BACK));
					setVisible(false); // 현재 프레임 안보이게
					mContext.setVisible(true); // 메인 프레임 보이게
					if (bgm != null) {
						// 혹시 음악이 틀어져 있다면 끔
						bgm.getClip().close();
					}
					break;
				}
			}

		});

		// 키입력 과 모든 작용이 똑같음
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("x 좌표 : " + e.getX() + "y 좌표 : " + e.getY());
				// 왼쪽 버튼
				if (isLeftButton(e.getX(), e.getY())) {
					leftButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFTCLICK));
				}
				// 오른쪽 버튼
				if (isRightButton(e.getX(), e.getY())) {
					rightButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHTCLICK));
				}
				// 뒤로가기
				if (isBackButton(e.getX(), e.getY())) {
					backButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_BACKCLICK));
				}
				// 게임 시작
				if (isStartButton(e.getX(), e.getY())) {
					startButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_STARTCLICK));
				}
				// 음악 재생
				if (isPlayButton(e.getX(), e.getY())) {
					if (!isMusicPlay) {
						musicButton.setIcon(musicStopImg);
						bgm = mContext.getBgmService().createBGM(); // bgm 객체 생성
						bgm.getClip().start(); // 생성된 음악 재생
						isMusicPlay = true;
					} else {
						musicButton.setIcon(musicPlayImg);
						bgm.getClip().close(); // 음악 닫기
						isMusicPlay = false;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// 게임 선택 왼쪽
				if (isLeftButton(e.getX(), e.getY())) {
					if (selectNumber == GAMENAME_DROPNOTE_2P) {
						selectNumber = GAMENAME_TRYCATCH_1P;
					} else {
						selectNumber--;
					}
					selectGame(selectNumber);
					leftButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFT));
				}
				// 게임 선택 오른쪽
				if (isRightButton(e.getX(), e.getY())) {
					if (selectNumber == GAMENAME_TRYCATCH_1P) {
						selectNumber = GAMENAME_DROPNOTE_2P;
					} else {
						selectNumber++;
					}
					selectGame(selectNumber);
					rightButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHT));
				}
				// 게임 시작
				if (isStartButton(e.getX(), e.getY())) {
					startButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_START));
					if (bgm != null) {
						// 혹시 음악이 틀어져 있다면 끔
						bgm.getClip().close();
					}
					gameRunning = true;
					// 게임시작 뗏을때 게임화면 띄우기
					switch (selectNumber) {
					case GAMENAME_DROPNOTE_2P :
						new DropNoteFrame_2P(thisFrame);
						setVisible(false);
						break;
					case GAMENAME_DROPNOTE_1P :
						new DeathNoteFrame(thisFrame);
						setVisible(false);
						break;
					}
				}
				// 뒤로가기
				if (isBackButton(e.getX(), e.getY())) {
					backButton.setIcon(new ImageIcon(Define.IMG_SELECTFRAME_BACK));
					setVisible(false);
					mContext.setVisible(true);
					if (bgm != null) {
						bgm.getClip().close();
					}
				}

			}
		});
	}

	private void selectGame(int selectNumber) {
		switch (selectNumber) {
		case GAMENAME_DROPNOTE_2P:
			gameTitle.setIcon(gameTitleImg[GAMENAME_DROPNOTE_2P]);
			gameLabel.setIcon(gameLabelImg[GAMENAME_DROPNOTE_2P]);
			break;
		case GAMENAME_DROPNOTE_1P:
			gameTitle.setIcon(gameTitleImg[GAMENAME_DROPNOTE_1P]);
			gameLabel.setIcon(gameLabelImg[GAMENAME_DROPNOTE_1P]);
			break;
		case GAMENAME_TRYCATCH_2P:
			gameTitle.setIcon(gameTitleImg[GAMENAME_TRYCATCH_2P]);
			gameLabel.setIcon(gameLabelImg[GAMENAME_TRYCATCH_2P]);
			break;
		case GAMENAME_TRYCATCH_1P:
			gameTitle.setIcon(gameTitleImg[GAMENAME_TRYCATCH_1P]);
			gameLabel.setIcon(gameLabelImg[GAMENAME_TRYCATCH_1P]);
			break;
			// 5번째 게임 삭제
//		case GAMENAME_FIFTHGAME:
//			gameTitle.setIcon(gameTitleImg[GAMENAME_FIFTHGAME]);
//			gameLabel.setIcon(gameLabelImg[GAMENAME_FIFTHGAME]);
//			break;
		}
	}
	// 마우스 입력 위치가 버튼과 맞는지 확인
	public boolean isLeftButton(int x, int y) {
		if (450 <= x && x <= 450 + 71 && 440 <= y && y <= 440 + 78) {
			return true;
		}
		return false;
	}

	public boolean isRightButton(int x, int y) {
		if (1090 <= x && x <= 1090 + 71 && 440 <= y && y <= 440 + 78) {
			return true;
		}
		return false;
	}

	public boolean isPlayButton(int x, int y) {
		if (560 <= x && x <= 560 + 30 && 740 <= y && y <= 740 + 30) {
			return true;
		}
		return false;
	}

	public boolean isStartButton(int x, int y) {
		if (730 <= x && x <= 730 + 150 && 790 <= y && y <= 790 + 47) {
			return true;
		}
		return false;
	}

	public boolean isBackButton(int x, int y) {
		if (1420 <= x && x <= 1420 + 150 && 60 <= y && y <= 60 + 47) {
			return true;
		}
		return false;
	}

	
	// getter
	public MainFrame getmContext() {
		return mContext;
	}

	public static boolean isGameRunning() {
		return gameRunning;
	}

	public static void setGameRunning(boolean running) {
		gameRunning = running;
	}

}// end of class
