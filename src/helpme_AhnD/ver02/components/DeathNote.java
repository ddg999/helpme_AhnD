package helpme_AhnD.ver02.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DeathNoteCircle;
import helpme_AhnD.ver02.service.DeathNoteService;

public class DeathNote extends JLabel {
	DeathNoteService deathNoteService;
	DeathNoteCircle deathNoteCircle;
	TestFrame testFrame;

	private ImageIcon note_Img;
	private ImageIcon note_Img_P;
	private final int NOTE_WIDTH = 80;
	private final int NOTE_HIGHT = 70;
	private final int NOTE_Y_LOCATION = 200;
	private int location_X;

	public DeathNote(DeathNoteService deathNoteService, int location_X, TestFrame testFrame) {
		this.location_X = location_X; // Y값은 변경 가능
		this.testFrame = testFrame;
		initData();
		setInitLayout();
		new DeathNoteService();
		this.deathNoteService = deathNoteService;
		new Thread(() -> {
			while (true) {
			 
				int redIsGood = (new Random()).nextInt(20);
				try {
					Thread.sleep(500);
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

}
