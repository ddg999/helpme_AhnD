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
	
	
	protected ImageIcon note_Right;
	protected ImageIcon note_Left;
	protected ImageIcon note_Up;
	protected ImageIcon note_Down;
	protected ImageIcon note_Up_P;
	protected ImageIcon note_Left_P;
	protected ImageIcon note_Right_P;
	protected ImageIcon note_Down_P;
	protected final int NOTE_WIDTH = 85;
	protected final int NOTE_HIGHT = 85;
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
			 
				int redIsGood = (new Random()).nextInt(4);
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (redIsGood == 0) {
						deathNoteCircle = new DeathNoteCircle(this, testFrame);
						testFrame.add(deathNoteCircle);
					
				} else {
				}
			}
		}).start();
		
			
	}
	
	private void initData() {
		note_Right = new ImageIcon("images/right.png"); // 샘플 이미지 변경
		note_Left = new ImageIcon("images/left.png"); // 샘플 이미지 변경
		note_Up = new ImageIcon("images/up.png"); // 샘플 이미지 변경
		note_Down = new ImageIcon("images/down.png"); // 샘플 이미지 변경
		note_Up_P = new ImageIcon("images/upp.png");
		note_Left_P = new ImageIcon("images/leftp.png");
		note_Right_P = new ImageIcon("images/rightp.png");
		note_Down_P = new ImageIcon("images/downp.png");
	}

	private void setInitLayout() {
		
		setSize(NOTE_WIDTH, NOTE_HIGHT);
		setLocation(location_X, NOTE_Y_LOCATION);

	}
	
	
	public void keypresed() {
		
	}
	public void keyreleased() {
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public int getLocation_X() {
		return location_X;
	}

	public void setLocation_X(int location_X) {
		this.location_X = location_X;
	}

	public int getNOTE_Y_LOCATION() {
		return NOTE_Y_LOCATION;
	}



	
	

	
	
	

	
}
