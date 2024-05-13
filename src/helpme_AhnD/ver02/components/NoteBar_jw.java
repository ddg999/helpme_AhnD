package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.AhnteacherFrame_jw;

public class NoteBar_jw extends JLabel {

	AhnteacherFrame_jw mContext;
	private ImageIcon noteBar;

	public NoteBar_jw(AhnteacherFrame_jw mContext) {
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
