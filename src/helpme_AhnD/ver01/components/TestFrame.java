package helpme_AhnD.ver01.components;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class TestFrame extends JFrame {

	private AhnCharacter ahnCharacter;

	public TestFrame() {
		initData();
		setInitLayout();
	}
	
	
	private void initData() {

		// todo 배경 이미지 삽입
		
		
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ahnCharacter = new AhnCharacter();
		
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(ahnCharacter);

	}
	public static void main(String[] args) {
		new TestFrame();
	}
}
