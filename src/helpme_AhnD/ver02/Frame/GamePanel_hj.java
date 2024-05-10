package helpme_AhnD.ver02.Frame;

/*
 * 작은 화면 -> 노래 선택 버튼 좌, 우
 * 뒤로 가기
 * 소리 듣기 (끄고 , 킬 수 있게)
 * 
 * 창 -> 프레임으로 말고 게임 실행을 누르면 바로 노래 선택하는 게 뜬다고 가정을 하면
 * 바로 노래 이미지와 노래 선택 버튼이 뜨도록 설계 버튼과 라벨을 설정해보기
 * 
 */
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel_hj extends JFrame {

	private JLabel backgroundLabel; // backgroundIng
	private JLabel songLabel; // 노래 앨범
	private JLabel songTitle; // 노래 제목

	private ImageIcon firstSongImg;
	private ImageIcon firstTitleImg;

	private ImageIcon secondSongImg;
	private ImageIcon secondTitleImg;
	
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

	boolean flag = true;

	// 새로운 게임 화면을 위한 GamePanel 클래스

	public GamePanel_hj() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setTitle("노래 선택 화면");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel jPanel = new JPanel();

		ImageIcon backgroundImage = new ImageIcon("images/hj_soundbg.jpg");

		// backgroundImg
		backgroundLabel = new JLabel(backgroundImage);

		// 노래 앨범
		firstSongImg = new ImageIcon("images/hj_music.jpg");
		secondSongImg = new ImageIcon("images/hj_music2.jpg");

		songLabel = new JLabel(firstSongImg);
		// songLabel = new JLabel(secondSong);

		// 노래 제목
		firstTitleImg = new ImageIcon("images/song1_title.png");
		secondTitleImg = new ImageIcon("images/song2_title.png");

		// songTitle = new JLabel(firstTitle);
		songTitle = new JLabel(firstTitleImg);

		// 왼쪽 버튼
		leftButton = new JLabel(new ImageIcon("images/hj_arrowleft.png"));

		// 오른쪽 버튼
		rightButton = new JLabel(new ImageIcon("images/hj_arrowright.png"));

		// 음악 재생, 정지
		musicPlayImg = new ImageIcon("images/play.png");
		music = new JLabel(musicPlayImg);
		musicStopImg = new ImageIcon("images/play_stop.png");

		// 게임 시작 버튼
		startButton = new JLabel(new ImageIcon("images/hj_button1_small.png"));

		// 뒤로 가기 버튼
		backButton = new JLabel(new ImageIcon("images/back.png"));
	}

	private void setInitLayout() {
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
				case KeyEvent.VK_RIGHT:
					songTitle.setIcon(secondTitleImg);
					songTitle.setSize(354, 35);
					songTitle.setLocation(620, 140);
					songLabel.setIcon(secondSongImg);
					rightButton.setIcon(new ImageIcon("images/hj_arrowright_click.png"));
					break;
				case KeyEvent.VK_LEFT:
					songTitle.setIcon(firstTitleImg);
					songTitle.setSize(201, 35);
					songTitle.setLocation(700, 140);
					songLabel.setIcon(firstSongImg);
					leftButton.setIcon(new ImageIcon("images/hj_arrowleft_click.png"));
					break;
				case KeyEvent.VK_SPACE:
					if(flag == true) {
						music.setIcon(musicStopImg);
						flag = false;
					}else {
						music.setIcon(musicPlayImg);
						flag= true;
					}
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					songTitle.setIcon(secondTitleImg);
					songTitle.setSize(354, 35);
					songTitle.setLocation(620, 140);
					songLabel.setIcon(secondSongImg);
					rightButton.setIcon(new ImageIcon("images/hj_arrowright.png"));
					break;
				case KeyEvent.VK_LEFT:
					songTitle.setIcon(firstTitleImg);
					songTitle.setSize(201, 35);
					songTitle.setLocation(700, 140);
					songLabel.setIcon(firstSongImg);
					leftButton.setIcon(new ImageIcon("images/hj_arrowleft.png"));
					break;
				}
			}

		});
	}

	public static void main(String[] args) {
		new GamePanel_hj();
	}// end of main

}// end of class
