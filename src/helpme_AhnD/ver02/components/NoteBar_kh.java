package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.TestGameFrame_kh;

public class NoteBar_kh extends JLabel {

	TestGameFrame_kh mContext;
	private ImageIcon noteBar;

	public NoteBar_kh(TestGameFrame_kh mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public void initData() {
		noteBar = new ImageIcon("images/noteBar_jw.png");
	}

	public void setInitLayout() {
		setIcon(noteBar);
		setSize(400, 100);
		setLocation(295, 700);
		mContext.add(this);
	}

}
