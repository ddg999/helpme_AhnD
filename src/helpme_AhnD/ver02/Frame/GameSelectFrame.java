package helpme_AhnD.ver02.Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helpme_AhnD.ver02.AhnteacherFrame_modify;
import helpme_AhnD.ver02.service.BGM;
import helpme_AhnD.ver02.service.BGMService;
import helpme_AhnD.ver02.utils.Define;

public class GameSelectFrame extends JFrame {

	private JLabel backgroundLabel; // backgroundIng
	private JLabel songLabel; // 노래 앨범
	private JLabel songTitle; // 노래 제목
	private AhnteacherFrame_modify mContext;

	private ImageIcon firstSongImg;
	private ImageIcon firstTitleImg;

	private ImageIcon secondSongImg;
	private ImageIcon secondTitleImg;

	private ImageIcon thirdSongImg;
	private ImageIcon thirdTitleImg;

	private ImageIcon fourthSongImg;
	private ImageIcon fourthTitleImg;

	private ImageIcon fifthSongImg;
	private ImageIcon fifthTitleImg;

	private ImageIcon musicStopImg;
	private ImageIcon musicPlayImg;

	// 버튼
	private JLabel leftButton; // 왼쪽 버튼
	private JLabel rightButton; // 오른쪽 버튼
	private JLabel startButton; // 시작 버튼
	private JLabel backButton; // 뒤로가기 버튼
	private JLabel endButton; // 종료 버튼
	private JLabel music; // 음악 재생
	private JLabel stop; // 음악 정지

	private int selectNumber; // 게임 번호 선택

	boolean flag = true;

	// 음악
	private BGM game1BGM;

	// 새로운 게임 화면을 위한 GamePanel 클래스

	public GameSelectFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	public GameSelectFrame(AhnteacherFrame_modify mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setTitle("노래 선택 화면");
		setSize(1600, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jPanel = new JPanel();

		ImageIcon backgroundImage = new ImageIcon(Define.IMG_SELECTFRAME_BG);

		// backgroundImg
		backgroundLabel = new JLabel(backgroundImage);

		// 노래 앨범
		firstSongImg = new ImageIcon(Define.IMG_SELECTFRAME_FIRSTMUSIC);
		secondSongImg = new ImageIcon(Define.IMG_SELECTFRAME_SECONDMUSIC);
		thirdSongImg = new ImageIcon(Define.IMG_SELECTFRAME_THIRDMUSIC);
		fourthSongImg = new ImageIcon(Define.IMG_SELECTFRAME_FOURTHMUSIC);
		fifthSongImg = new ImageIcon(Define.IMG_SELECTFRAME_FIFTHMUSIC);

		songLabel = new JLabel(firstSongImg);
		// songLabel = new JLabel(secondSong);

		// 노래 제목
		firstTitleImg = new ImageIcon(Define.IMG_SELECTFRAME_FIRSTTITLE);
		secondTitleImg = new ImageIcon(Define.IMG_SELECTFRAME_SECONDTITLE);
		thirdTitleImg = new ImageIcon(Define.IMG_SELECTFRAME_THIRDTITLE);
		fourthTitleImg = new ImageIcon(Define.IMG_SELECTFRAME_FOURTHTITLE);
		fifthTitleImg = new ImageIcon(Define.IMG_SELECTFRAME_FIFTHTITLE);

		// songTitle = new JLabel(firstTitle);
		songTitle = new JLabel(firstTitleImg);

		// 왼쪽 버튼
		leftButton = new JLabel(
				new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFT));

		// 오른쪽 버튼
		rightButton = new JLabel(
				new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHT));

		// 음악 재생, 정지
		musicPlayImg = new ImageIcon(Define.IMG_SELECTFRAME_MUSICPLAY);
		music = new JLabel(musicPlayImg);
		musicStopImg = new ImageIcon(Define.IMG_SELECTFRAME_MUSICSTOP);

		// 게임 시작 버튼
		startButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_START));

		// 뒤로 가기 버튼
		backButton = new JLabel(new ImageIcon(Define.IMG_SELECTFRAME_BACK));

		selectNumber = 1;
	}

	private void setInitLayout() {
		setLocationRelativeTo(null);
		setLayout(null);

		add(backgroundLabel);
		backgroundLabel.setSize(1600, 900);
		backgroundLabel.setLocation(0, 0);

		backgroundLabel.add(songLabel);
		songLabel.setSize(500, 500);
		songLabel.setLocation(550, 200);

		backgroundLabel.add(songTitle);
		songTitle.setSize(201, 35);
		songTitle.setLocation(700, 140);
		// songTitle.setSize(354, 35);
		// songTitle.setLocation(620, 140);

		backgroundLabel.add(leftButton);
		leftButton.setSize(71, 78);
		leftButton.setLocation(442, 411);

		backgroundLabel.add(rightButton);
		rightButton.setSize(71, 78);
		rightButton.setLocation(1085, 411);

		backgroundLabel.add(music);
		music.setSize(30, 30);
		music.setLocation(550, 710);

		backgroundLabel.add(startButton);
		startButton.setSize(150, 47);
		startButton.setLocation(720, 760);

		backgroundLabel.add(backButton);
		backButton.setSize(148, 47);
		backButton.setLocation(1420, 30);

		setVisible(true);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT :
						rightButton.setIcon(new ImageIcon(
								Define.IMG_SELECTFRAME_ARROWRIGHTCLICK));
						break;
					case KeyEvent.VK_LEFT :
						leftButton.setIcon(new ImageIcon(
								Define.IMG_SELECTFRAME_ARROWLEFTCLICK));
						break;
					case KeyEvent.VK_SPACE :
						if (flag == true) {
							music.setIcon(musicStopImg);
							game1BGM = mContext.getBgmService().createBGM();
							game1BGM.getClip().start();
							flag = false;
						} else {
							music.setIcon(musicPlayImg);
							game1BGM.getClip().close();
							flag = true;
						}
						break;
					case KeyEvent.VK_BACK_SPACE :
						backButton.setIcon(new ImageIcon(
								Define.IMG_SELECTFRAME_BACKCLICK));
						break;
					// 볼륨 조절 테스트용 코드
					// 추후 설정 화면으로 이관할 예정
					case KeyEvent.VK_DOWN :
						BGMService.volumDown();
						game1BGM.getGainControl()
								.setValue(BGMService.getVolume());
						break;
					case KeyEvent.VK_UP :
						BGMService.volumeUp();
						game1BGM.getGainControl()
								.setValue(BGMService.getVolume());
						break;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT :
						if (selectNumber == 5) {
							selectNumber = 1;
						} else {
							selectNumber++;
						}
						selectGame(selectNumber);
						rightButton.setIcon(new ImageIcon(
								Define.IMG_SELECTFRAME_ARROWRIGHT));
						break;
					case KeyEvent.VK_LEFT :
						if (selectNumber == 1) {
							selectNumber = 5;
						} else {
							selectNumber--;
						}
						selectGame(selectNumber);
						leftButton.setIcon(new ImageIcon(
								Define.IMG_SELECTFRAME_ARROWLEFT));
						break;
					case KeyEvent.VK_BACK_SPACE :
						backButton.setIcon(
								new ImageIcon(Define.IMG_SELECTFRAME_BACK));
						setVisible(false);
						mContext.setVisible(true);
						if (game1BGM != null) {
							game1BGM.getClip().close();
						}
						break;
				}
			}

		});

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("x 좌표 : " + e.getX() + "y 좌표 : " + e.getY());
				if (isLeftButton(e.getX(), e.getY())) {
					leftButton.setIcon(new ImageIcon(
							Define.IMG_SELECTFRAME_ARROWLEFTCLICK));
				}
				if (isRightButton(e.getX(), e.getY())) {
					rightButton.setIcon(new ImageIcon(
							Define.IMG_SELECTFRAME_ARROWRIGHTCLICK));
				}
				if (isPlayButton(e.getX(), e.getY())) {
					if (flag == true) {
						music.setIcon(musicStopImg);
						game1BGM = mContext.getBgmService().createBGM();
						game1BGM.getClip().start();
						flag = false;
					} else {
						music.setIcon(musicPlayImg);
						game1BGM.getClip().close();
						flag = true;
					}
				}
				if (isBackButton(e.getX(), e.getY())) {
					backButton.setIcon(
							new ImageIcon(Define.IMG_SELECTFRAME_BACKCLICK));
				}
				if (isStartButton(e.getX(), e.getY())) {
					// 게임시작 눌렀을 때 사진으로 변경
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (isLeftButton(e.getX(), e.getY())) {
					if (selectNumber == 1) {
						selectNumber = 5;
					} else {
						selectNumber--;
					}
					selectGame(selectNumber);
					leftButton.setIcon(
							new ImageIcon(Define.IMG_SELECTFRAME_ARROWLEFT));
				}
				if (isRightButton(e.getX(), e.getY())) {
					if (selectNumber == 5) {
						selectNumber = 1;
					} else {
						selectNumber++;
					}
					selectGame(selectNumber);
					rightButton.setIcon(
							new ImageIcon(Define.IMG_SELECTFRAME_ARROWRIGHT));
				}
				if (isBackButton(e.getX(), e.getY())) {
					backButton.setIcon(
							new ImageIcon(Define.IMG_SELECTFRAME_BACK));
					setVisible(false);
					mContext.setVisible(true);
					if (game1BGM != null) {
						game1BGM.getClip().close();
					}
				}
				if (isStartButton(e.getX(), e.getY())) {
					// 게임시작 뗏을때 게임화면 띄우기
				}
			}
		});
	}

	private void selectGame(int selectNumber) {
		switch (selectNumber) {
			case 1 :
				songTitle.setIcon(firstTitleImg);
				songTitle.setSize(201, 35);
				songTitle.setLocation(700, 140);
				songLabel.setIcon(firstSongImg);
				break;
			case 2 :
				songTitle.setIcon(secondTitleImg);
				songTitle.setSize(354, 35);
				songTitle.setLocation(620, 140);
				songLabel.setIcon(secondSongImg);
				break;
			case 3 :
				songTitle.setIcon(thirdTitleImg);
				songTitle.setSize(354, 35);
				songTitle.setLocation(620, 140);
				songLabel.setIcon(thirdSongImg);
				break;
			case 4 :
				songTitle.setIcon(fourthTitleImg);
				songTitle.setSize(354, 35);
				songTitle.setLocation(620, 140);
				songLabel.setIcon(fourthSongImg);
				break;
			case 5 :
				songTitle.setIcon(fifthTitleImg);
				songTitle.setSize(354, 35);
				songTitle.setLocation(620, 140);
				songLabel.setIcon(fifthSongImg);
				break;
			default :
				break;
		}
	}

	public boolean isLeftButton(int x, int y) {
		if (442 <= x && x <= 513 && 411 <= y && y <= 489) {
			return true;
		}
		return false;
	}
	public boolean isRightButton(int x, int y) {
		if (1085 <= x && x <= 1156 && 411 <= y && y <= 489) {
			return true;
		}
		return false;
	}
	public boolean isPlayButton(int x, int y) {
		if (550 <= x && x <= 580 && 710 <= y && y <= 740) {
			return true;
		}
		return false;
	}
	public boolean isStartButton(int x, int y) {
		if (720 <= x && x <= 870 && 760 <= y && y <= 807) {
			return true;
		}
		return false;
	}
	public boolean isBackButton(int x, int y) {
		if (1420 <= x && x <= 1568 && 60 <= y && y <= 107) {
			return true;
		}
		return false;
	}

}// end of class