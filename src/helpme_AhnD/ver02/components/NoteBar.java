package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class NoteBar extends JLabel {

	DropNoteFrame mContext;
	Player player;
	private ImageIcon noteBar;

	private int x;
	private int y;

	public NoteBar(DropNoteFrame mContext, Player player) {
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
		if (player == Player.LEFTPLAYER) {
			x = 295;
			y = 700;
		} else if (player == Player.RIGHTPLAYER) {
			x = 1000;
			y = 700;
		}
		setLocation(x, y);
		mContext.add(this);
	}

}
