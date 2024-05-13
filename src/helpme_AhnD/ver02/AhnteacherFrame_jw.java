package helpme_AhnD.ver02;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.NoteBar_jw;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.service.PlayerService;

/*
 * 화면 구성 - 제목, 시작, 종료, 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame_jw extends JFrame {
	// 선언
	AhnteacherFrame_jw mContext = this;
	private boolean isGame = true; // 게임 실행중
	private PlayerService playerService;
	private NoteBar_jw noteBar;
	// private 이미지
	private JLabel introImage;

	// 생성자
	public AhnteacherFrame_jw() {
		initData();
		setInitLayout();
	}

	private void initData() {
		introImage = new JLabel(new ImageIcon("images/Frame_background.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(introImage);
		setSize(1600, 900); // 수정

		playerService = new PlayerService(this);
		new Thread(playerService).start();
		noteBar = new NoteBar_jw(mContext);
	}

	private void setInitLayout() {
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		setResizable(false); // 프레임 크기 조절 불가
		setVisible(true); // 화면 출력
	}

	// 이미지

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_jw();
	}

}// end of class
