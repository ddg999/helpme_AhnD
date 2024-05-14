package helpme_AhnD.ver02.service;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.components.TestFrame;

public class DeathNoteCircle extends JLabel {
	private ImageIcon[] image;
	public final static int BAD_OVER_CIRCLE = 0;
	public final static int GOOD_CIRCLE = 1;
	public final static int EXCELLENT_CIRCLE = 2;
	public final static int PERFECT_CIRCLE = 3;
	public final static int BAD_LATE_CIRCLE = 4;
	int i;
	ImageIcon booly;
	DeathNote deathNote;
	TestFrame testFrame;
	public int checkNow;
	boolean flag;

	private int x;
	private int y;

	public DeathNoteCircle(DeathNote deathNote, TestFrame testFrame) {
		x = deathNote.getLocation_X() + 5;
		y = deathNote.getNOTE_Y_LOCATION() - 5;
		this.testFrame = testFrame;

		initData();
		setInitLayout();
		new Thread(() -> {
			// while(true) {

			try {
				for (i = BAD_OVER_CIRCLE; i <= BAD_LATE_CIRCLE; i++) {
					setIcon(image[i]);
					setLocation(x + i * 5, y);
					checkNow = i;
					this.repaint();
					Thread.sleep(100);
				}
				setIcon(booly);
				testFrame.remove(this);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}).start();
	}
//		
//	}

	private void initData() {
		image = new ImageIcon[5];
		image[BAD_OVER_CIRCLE] = new ImageIcon("images/circle/badOverCircle.png");
		image[GOOD_CIRCLE] = new ImageIcon("images/circle/goodCircle.png");
		image[EXCELLENT_CIRCLE] = new ImageIcon("images/circle/excellentCircle.png");
		image[PERFECT_CIRCLE] = new ImageIcon("images/circle/perfectCircle.png");
		image[BAD_LATE_CIRCLE] = new ImageIcon("images/circle/badLateCircle.png");
		booly = new ImageIcon("");
	}

	private void setInitLayout() {
		setSize(90, 90);
		setIcon(image[BAD_OVER_CIRCLE]);
		setLocation(x, y);

	}

	public ImageIcon[] getImage() {
		return image;
	}

	private void falseG() {
		if (image.equals(booly)) {

		}
		flag = true;
	}

	public boolean circleExcellentZone() {
		try {
			if (i == EXCELLENT_CIRCLE) {
				
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("예외3");
		}
		return false;
	}

	public boolean circlePerfecttZone() {
	
		try {
			if (i== PERFECT_CIRCLE) {

				return true;
			}
			
		} catch (Exception e) {
			System.out.println("예외2");
		}
		
		return false;
	}

	public boolean circleGoodZone() {
		
		try {
			if (i== GOOD_CIRCLE) {

				return true;
			}
			
		} catch (Exception e) {
			System.out.println("예외1");
		}
		return false;
	}

	public boolean circleBadLateZone() {
		if (i == BAD_LATE_CIRCLE) {

			return true;
		}
		return false;
	}

	public boolean circleBadZone() {
		if (image == null) {

			return true;
		}
		return false;
	}

}
