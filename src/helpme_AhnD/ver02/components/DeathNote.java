package helpme_AhnD.ver02.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNoteService;
import helpme_AhnD.ver02.service.PlayerService_js;

public class DeathNote extends JLabel implements Runnable {
	DeathNoteCircle deathNoteCircle;
	PlayerService_js playerService;
	DeathNote deathNote;
	TestFrame testFrame;
	
	protected ImageIcon note_Img;
	protected ImageIcon note_Img_P;
	protected final int NOTE_WIDTH = 80;
	protected final int NOTE_HIGHT = 70;
	protected  final int NOTE_Y_LOCATION = 200;
	protected  int location_X;
	
	
	protected  boolean gameStart; // 게임 실행 확인
	protected  boolean keyIsPressed =true;
	protected  boolean isJudged = false;
	
	
	
	public DeathNote( int location_X, TestFrame testFrame ) {
		this.location_X = location_X; // Y값은 변경 가능
		this.testFrame = testFrame;
		playerService = testFrame.playerService;
		initData();
		setInitLayout();
		new Thread(() -> {
			while (true) {
			 
				int redIsGood = (new Random()).nextInt(5);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (redIsGood == 0) {
					
						testFrame.add(new DeathNoteCircle(this, testFrame));
					
				} else {
				}
			}
		}).start();
		
			
	}
	
	private void initData() {
		note_Img = new ImageIcon("images/DeathNote.png"); // 샘플 이미지 변경
		note_Img_P = new ImageIcon("images/DeathNoteP.png");
	}

	private void setInitLayout() {
		setIcon(note_Img);
		setSize(NOTE_WIDTH, NOTE_HIGHT);
		setLocation(location_X, NOTE_Y_LOCATION);

	}
	
	public void keypresed() {
		setIcon(note_Img_P);
	}
	public TestFrame getTestFrame() {
		return testFrame;
	}
	
	public int getNOTE_Y_LOCATION() {
		return NOTE_Y_LOCATION;
	}

	public int getLocation_X() {
		return location_X;
	}

	
	public void run() {
		gameStart = true;
		while (gameStart) {
			if (keyIsPressed) {
				keypresed();
				if (deathNoteCircle.circleExcellentZone()) { 
					playerService.getScore().perfect();
					System.out.println("excellent");
					isJudged = true;
				} else if (deathNoteCircle.circlePerfecttZone()) {
					playerService.getScore().perfect();
					System.out.println("perfect");
					isJudged = true;
				} else if (deathNoteCircle.circleGoodZone()) {
					playerService.getScore().perfect();
					System.out.println("good");
					isJudged = true;
				} else {
					playerService.getScore().perfect();
					System.out.println("bad");
					isJudged = true;
				}
				break;
			} // end of if

		} // end of while

	} // end of run

	
	
	

	
}