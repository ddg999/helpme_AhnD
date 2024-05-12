package helpme_AhnD.ver02.service;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.components.TestFrame;

public class DeathNoteCircle extends JLabel{
	private ImageIcon[] image;
	public final static int BAD_OVER_CIRCLE = 0;
	public final static int GOOD_CIRCLE = 1;
	public final static int EXCELLENT_CIRCLE = 2;
	public final static int PERFECT_CIRCLE = 3;
	public final static int BAD_LATE_CIRCLE = 4;
	ImageIcon booly;
	DeathNote deathNote;
	TestFrame testFrame;
	boolean flag ;
	
	
	private int x;
	private int y;
	
	public DeathNoteCircle(DeathNote deathNote, TestFrame testFrame) {
		x = deathNote.getLocation_X() + 5;
		y = deathNote.getNOTE_Y_LOCATION() - 10;
		this.testFrame = testFrame;
		
		
			
		initData();
		setInitLayout();
		new Thread(() -> {
			//while(true) {
				
			try {
				for (int i = BAD_OVER_CIRCLE; i <= BAD_LATE_CIRCLE; i++) {
					setIcon(image[i]);
					setLocation(x + i * 5, y);
					this.repaint();
					Thread.sleep(300);
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
		setSize(90,90);
		setIcon(image[BAD_OVER_CIRCLE]);
		setLocation(x , y );


	}
	
	private  void falseG() {
		if(image.equals(booly)) {
		
		}
		flag =true;
	}
}
