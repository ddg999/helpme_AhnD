package helpme_AhnD.ver02.components;

import javax.swing.JFrame;

import helpme_AhnD.ver02.service.PlayerService_js;

public class TestFrame extends JFrame {
	private static AhnCharacter ahnCharacter;
	
	DeathNoteRight deathNoteRight;
	DeathNoteLeft deathNoteLeft;
	DeathNoteUp deathNoteUp;
	DeathNoteDown deathNoteDown;
	PlayerService_js playerService;
	
	public TestFrame() {
		initData();
		setInitLayout();
	
		ahnCharacter.playerScoreImage();
		
	}
	
	
	private void initData() {

		// todo 배경 이미지 삽입
		
		
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ahnCharacter = new AhnCharacter();
		deathNoteRight = new  DeathNoteRight(80, this);
		deathNoteLeft = new DeathNoteLeft(180, this);
		deathNoteUp = new DeathNoteUp(280, this);
		deathNoteDown = new DeathNoteDown(380, this);
		playerService = new PlayerService_js(this);
		//new DeathNoteCircle();
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(ahnCharacter);
		add(deathNoteRight);
		add(deathNoteLeft);		
		add(deathNoteUp);		
		add(deathNoteDown);		

	}

	
	public static void main(String[] args) {
		new TestFrame();
	}
}
