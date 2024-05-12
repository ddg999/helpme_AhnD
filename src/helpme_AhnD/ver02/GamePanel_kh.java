package helpme_AhnD.ver02;

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
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel_kh extends JFrame {

	private JLabel backgroundLabel;
	private JLabel songLabel; // 노래 리스트

	// 버튼
	private JLabel leftButton; // 왼쪽 버튼
	private JLabel rightButton; // 오른쪽 버튼
	private JButton StartButton; // 시작 버튼
	private JButton BackButton; // 뒤로가기 버튼
	private JButton endButton; // 종료 버튼

	// 새로운 게임 화면을 위한 GamePanel 클래스

	public GamePanel_kh() {
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

		ImageIcon backgroundImage = new ImageIcon("images/hj_soundbg.jpg"); // 배경 사진 수정!!!!!!
		
		// backgroundImg
		backgroundLabel = new JLabel(backgroundImage);

		// 노래 이미지, 버튼
		songLabel = new JLabel(new ImageIcon("images/hj_music.jpg"));

		// 왼쪽 버튼 설정
		leftButton = new JLabel(new ImageIcon("images/hj_arrowleft.png"));
		
		// 오른쪽 버튼 설정
		rightButton = new JLabel(new ImageIcon("images/hj_arrowright.png"));

	}

	private void setInitLayout() {
		add(backgroundLabel);
		backgroundLabel.setSize(1600, 900);
		backgroundLabel.setLocation(0, 0);
		
		backgroundLabel.add(songLabel);
		songLabel.setSize(500, 500);
		songLabel.setLocation(550, 200);
		
		backgroundLabel.add(leftButton);
		leftButton.setSize(71, 78);
		leftButton.setLocation(1085, 411);
		
		backgroundLabel.add(rightButton);
		rightButton.setSize(71, 78);
		rightButton.setLocation(442, 411);
		
		setVisible(true);
	}

	private void addEventListener() {

	}


}// end of class
