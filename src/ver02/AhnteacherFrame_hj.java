package ver02;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ver02.components.item.Bomb;
import ver02.components.item.HpPlus;
import ver02.components.item.Items;

/*
 * 화면 구성 - 제목, 시작, 종료, 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame_hj extends JFrame {
	// 선언
	AhnteacherFrame_hj mContext = this;
	private boolean isRun = true; // 게임 실행중
	// private 이미지
	private JLabel introImage;

	// 생성자
	public AhnteacherFrame_hj() {
		
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		introImage = new JLabel(new ImageIcon("images/Frame_background.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		introImage = new JLabel(new ImageIcon());
	}

	private void setInitLayout() {
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		setResizable(false); // 프레임 크기 조절 불가
		add(new Bomb());
		setVisible(true); // 화면 출력
	}

	private void addEventListener() { // 키 이벤트
		
		// 마우스
		
		
		
		
		// 키보드
		
		
	
		
		
	}

	// 이미지


	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_hj();
	}

}// end of class
