package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.FirstGameFrame;
import helpme_AhnD.ver02.utils.Define;

public class NoteBar extends JLabel {

	FirstGameFrame mContext;
	private ImageIcon noteBar;

	public NoteBar(FirstGameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public void initData() {
		noteBar = new ImageIcon(Define.IMG_DROPNOTE_NOTEBAR);
	}

	public void setInitLayout() {
		setIcon(noteBar);
		setSize(400, 100);
		setLocation(295, 700);
		mContext.add(this);
	}

}
