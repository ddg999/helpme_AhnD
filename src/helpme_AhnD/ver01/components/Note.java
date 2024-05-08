package helpme_AhnD.ver01.components;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Note extends JLabel {
	private ImageIcon noteSample;
	private final int HALF_WIDTH = 800;
	int x;
	int y;
	private static int xindex;
	private static int yindex;
	private int type; // type 0는 왼쪽 1은 오른쪽

	public Note(int type, int x, int y) {
		this.type = type;
		if (type == 0) {
			this.x = 100 + x * 50;
		} else {
			this.x = 100 + x * 50 + 800;
		}
		this.y = 100 + y * 50;
		initData();
		setInitLayout();

		 new Thread( () -> {
		 try {
		 Thread.sleep(2000);
		 } catch (InterruptedException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		 setIcon(null);
		 }).start();
	}

	private void initData() {
		noteSample = new ImageIcon("images/notesample.png");

	}
	private void setInitLayout() {
		setIcon(noteSample);
		setSize(50, 50);
		setLocation(x, y);
	}

}
