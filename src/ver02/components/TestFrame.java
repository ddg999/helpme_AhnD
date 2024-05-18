package ver02.components;

import javax.swing.JFrame;

import ver02.service.PlayerService_js;
import ver02.state.Player;

public class TestFrame extends JFrame {
	private static AhnCharacter ahnCharacter;
	Player player = Player.LEFTPLAYER;

	
	public TestFrame() {
		initData();
		setInitLayout();
		add(new CatchNote());
		
		
	}
	
	
	private void initData() {

		// todo 배경 이미지 삽입
		
		
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//new DeathNoteCircle();
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);


	}

	
	public static void main(String[] args) {
		new TestFrame();
	}
}
