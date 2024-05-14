package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.FirstGameFrame;
import helpme_AhnD.ver02.utils.Define;

public class NoteBar extends JLabel {

	FirstGameFrame mContext;
	private ImageIcon noteBar;
	private int player;

	private int x;
	private int y;

	public NoteBar(FirstGameFrame mContext, int player) {
		this.mContext = mContext;
		this.player = player;
		initData();
		setInitLayout();
	}

	public void initData() {
		noteBar = new ImageIcon(Define.IMG_DROPNOTE_NOTEBAR);
	}

	public void setInitLayout() {
		setIcon(noteBar);
		setSize(400, 100);
		if (player == 1) {
			x = 295;
			y = 700;
		} else if (player == 2) {
			x = 1000;
			y = 700;
		}
		setLocation(x, y);
		mContext.add(this);
	}

}
