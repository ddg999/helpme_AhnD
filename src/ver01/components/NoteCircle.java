package ver01.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NoteCircle extends JLabel{
	
	private ImageIcon[] image;
	public final static int BAD_OVER_CIRCLE = 0;
	public final static int GOOD_CIRCLE = 1;
	public final static int EXCELLENT_CIRCLE = 2;
	public final static int PERFECT_CIRCLE = 3;
	public final static int BAD_LATE_CIRCLE = 4;
	
	private int x;
	private int y;
	
	public NoteCircle(Note note) {
		this.x = note.getX() - 16;
		this.y = note.getY() - 14;
		initData();
		setInitLayout();
		
		new Thread(() -> {
			try {
				for (int i = BAD_OVER_CIRCLE; i <= BAD_LATE_CIRCLE; i++) {
					setIcon(image[i]);
					setLocation(x + i * 5, y);
					this.repaint();
					Thread.sleep(300);
				}
				setIcon(null);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
	
	private void initData() {
		image = new ImageIcon[5];
		image[BAD_OVER_CIRCLE] = new ImageIcon("images/circle/badOverCircle.png");
		image[GOOD_CIRCLE] = new ImageIcon("images/circle/goodCircle.png");
		image[EXCELLENT_CIRCLE] = new ImageIcon("images/circle/excellentCircle.png");
		image[PERFECT_CIRCLE] = new ImageIcon("images/circle/perfectCircle.png");
		image[BAD_LATE_CIRCLE] = new ImageIcon("images/circle/badLateCircle.png");
	}
	private void setInitLayout() {
		setSize(90,90);
		setIcon(image[BAD_OVER_CIRCLE]);
		setLocation(x - 10, y - 10);
	}
}
