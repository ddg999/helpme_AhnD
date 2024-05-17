package helpme_AhnD.ver02.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.CatchNote;
import helpme_AhnD.ver02.state.Player;

public class CatchNoteCircle extends JLabel implements Runnable {
	
	CatchNotePlayerService catchNotePlayerService;
	CatchNote catchNote;
	private Player player;
	private ImageIcon miss_Up;
	private ImageIcon bad_Up;
	private ImageIcon good_Up;
	private ImageIcon excellent_Up;
	private ImageIcon pefect_Up;
	
	private ImageIcon miss_Left;
	private ImageIcon bad_Left;
	private ImageIcon good_Left;
	private ImageIcon excellent_Left;
	private ImageIcon pefect_Left;
	
	private ImageIcon miss_Right;
	private ImageIcon bad_Right;
	private ImageIcon good_Right;
	private ImageIcon excellent_Right;
	private ImageIcon pefect_Right;
	
	private ImageIcon miss_Down;
	private ImageIcon bad_Down;
	private ImageIcon good_Down;
	private ImageIcon excellent_Down;
	private ImageIcon pefect_Down;
	
	private int x;
	private int y;
	
	private boolean isPerfect;
	private boolean isExcellent;
	private boolean isGood;
	private boolean isBad;
	private boolean isMiss;
	
	private boolean isJudged = false;
	
	
	public CatchNoteCircle() {
		
		
	}
	
	
	private void initData() {

		miss_Up = new ImageIcon("images/0.png");
		bad_Up = new ImageIcon("images/73.png");
		good_Up = new ImageIcon("images/83.png");
		excellent_Up = new ImageIcon("images/93.png");
		pefect_Up = new ImageIcon("images/103.png");
		
		miss_Left = new ImageIcon("images/0L.png");
		bad_Left = new ImageIcon("images/73L.png");
		good_Left = new ImageIcon("images/83L.png");
		excellent_Left = new ImageIcon("images/93L.png");
		pefect_Left = new ImageIcon("images/103L.png");
		
		miss_Right = new ImageIcon("images/0R.png");
		bad_Right = new ImageIcon("images/73R.png");
		good_Right = new ImageIcon("images/83R.png");
		excellent_Right = new ImageIcon("images/93R.png");
		pefect_Right = new ImageIcon("images/103R.png");
		
		miss_Down = new ImageIcon("images/0D.png");
		bad_Down = new ImageIcon("images/73D.png");
		good_Down = new ImageIcon("images/83D.png");
		excellent_Down = new ImageIcon("images/93D.png");
		pefect_Down = new ImageIcon("images/103D.png");
		
	}
	
	private void setInitLayout() {

	}
	
	private void growLess() {
		
		
		
	}
	@Override
	public void run() {
		
	}
	
	
	
	
	
}
