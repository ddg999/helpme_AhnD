package ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ver02.state.Player;

public class CatchNote extends JLabel {

	private Player player;
	// 일반 노트 이미지
	private ImageIcon right;
	private ImageIcon left;
	private ImageIcon up;
	private ImageIcon down;

	// 눌렸을때 이미지
	private ImageIcon right_Push;
	private ImageIcon left_Push;
	private ImageIcon up_Push;
	private ImageIcon down_Push;

 

	// 좌표
	private int x;
	private final int Y = 230; // 고정값

	// 점수 판정에 대한 논리값

	public CatchNote(int x, ImageIcon button) {
		initData();
		setInitLayout();
		this.x = x;
		setIcon(button);
		setLocation(x, Y);
	}

	private void initData() {
		right = new ImageIcon("images/right.png");
		left = new ImageIcon("images/left.png");
		up = new ImageIcon("images/up.png");
		down = new ImageIcon("images/down.png");

		right_Push = new ImageIcon("images/rightp.png");
		left_Push = new ImageIcon("images/leftp.png");
		up_Push = new ImageIcon("images/upp.png");
		down_Push = new ImageIcon("images/downp.png");

	}

	private void setInitLayout() {
		setSize(85, 85);

	}
	private void pushbutton(ImageIcon buttonPush) {
		setIcon(buttonPush);
	}

}
