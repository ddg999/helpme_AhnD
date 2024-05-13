package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.TestGameFrame_kh;
import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNoteService;
import helpme_AhnD.ver02.service.PlayerService_js;

public class DeathNoteLeft extends de implements Runnable {
	DeathNoteCircle deathNoteCircle;
	PlayerService_js playerService;
	DeathNoteLeft deathNote;
	TestFrame testFrame;

	private ImageIcon note_Img;
	private ImageIcon note_Img_P;
	private final int NOTE_WIDTH = 80;
	private final int NOTE_HIGHT = 70;
	private final int NOTE_Y_LOCATION = 200;
	private int location_X;
	private int place;
	private final int LEFT = 0;
	private final int UP = 1;
	private final int RIGHT = 2;
	private final int DOWN = 3;
	
	private boolean gameStart; // 게임 실행 확인
	private boolean keyIsPressed =true;
	private boolean isJudged = false;

	public DeathNoteLeft(DeathNoteService deathNoteService, int location_X,TestFrame testFrame,int Key ) {
		this.location_X = location_X; // Y값은 변경 가능
		this.testFrame = testFrame;
		deathNote = this;
		initData();
		setInitLayout();
		addEventListener();
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

	public int getNOTE_Y_LOCATION() {
		return NOTE_Y_LOCATION;
	}

	public int getLocation_X() {
		return location_X;
	}

	public TestFrame getTestFrame() {
		return testFrame;
	}
	@Override
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
	
	public void addEventListener() {
		getTestFrame().addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT: 
					if(place==LEFT && !isJudged) {
						new Thread(deathNote).start();
					break;
					}
				case KeyEvent.VK_RIGHT: 
					if (place == RIGHT && !isJudged) {
					
					break;
					}
				case KeyEvent.VK_DOWN: 
					if (place == DOWN && !isJudged) {
				
					break;
					}
				case KeyEvent.VK_UP: 
					if (place == UP && !isJudged) {
					
					break;
					}
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + e.getKeyCode());
				}
			}
		});
	}
	
	
	
}

