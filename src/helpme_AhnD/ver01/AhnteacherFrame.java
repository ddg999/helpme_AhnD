package helpme_AhnD.ver01;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 화면 구성 - 제목, 시작, 종료, 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame extends JFrame {
	// 선언
	private Image screenImage; // 이미지
	// private        이미지 
	private JLabel introImage;
	
	
	// 생성자
	public AhnteacherFrame() {
		
		initData();
		setInitLayout();
		addEventListener();

	
	}
	
	private void initData() {
		setSize(1600, 900); // 수정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		
		introImage = new JLabel(new ImageIcon());
		
	}
	
	private void setInitLayout() {
		setResizable(false); // 프레임 크기 조절 불가
		setVisible(true); // 화면 출력
	}
	
	private void addEventListener() { // 키 이벤트
		
		// 마우스
		
		
		
		
		// 키보드
		
		
		
	}
	
	// 이미지
	
	
	
	
	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame();
	}
	
	

}// end of class
