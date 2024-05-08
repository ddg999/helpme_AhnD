package helpme_AhnD.ver01;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 화면 구성 - 제목, (버튼(시작, 종료)), 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame extends JFrame implements ActionListener{
	// 선언
	private Image screenImage; // 이미지
	// private        이미지 
	private JLabel introImage;
	//JFrame frm = new JFrame("리듬게임"); // 프레임 생성
	
	
	//버튼
	private JButton startButton = new JButton("게임시작"); // 수정 필요
	private JButton endButton = new JButton("게임종료");
	
	public static final int SC_WIDTH = 1600;
	public static final int SC_HEIGHT = 900; // 보류
	
	// 생성자
	public AhnteacherFrame() {
		
		initData();
		setInitLayout();
		addEventListener();

	
	}
	
	private void initData() {
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 게임 창을 종료 시 프로그램 전체 종료
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		
		
		introImage = new JLabel(new ImageIcon()); 
		setContentPane(introImage); // add 처리
		
	}
	
	private void setInitLayout() {
		setResizable(false); // 프레임 크기 조절 불가
		//setLayout(new ()); 라벨로 수정
		
		add(startButton,BorderLayout.NORTH);
		
		
		setVisible(true); // 화면 출력
	}
	
	private void addEventListener() { // 키 이벤트
		startButton.addActionListener(this);
		
	
		
		setContentPane(startButton); // add 처리
		
		
		// 마우스
		
		
		
		
		// 키보드
		
		
		
	}
	
	// 이미지
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		JButton selectedButton = (JButton)e.getSource();
		if(selectedButton == this.startButton) {
			System.out.println("게임시작");
		}else {
			System.out.println("게임종료");
		}
		
	}
	


	// 코드 테스트
		public static void main(String[] args) {
			new AhnteacherFrame();
		}
	
	

}// end of class
