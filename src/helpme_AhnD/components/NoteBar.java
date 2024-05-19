package helpme_AhnD.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class NoteBar extends JLabel {
	// 단순 이미지용 클래스
	
	GameSelectFrame mContext;
	Player player;
	private ImageIcon noteBar;

	private int x;
	private int y;

	public NoteBar(GameSelectFrame mContext, Player player) {
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
			x = 145;
			y = 700;
		} else if (player == Player.RIGHTPLAYER) {
			x = 1075;
			y = 700;
		} else if (player == Player.SOLO) {
			x = 610;
			y = 700;
		}
		setLocation(x, y);
	}
}
