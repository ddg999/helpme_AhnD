package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ItemScoreDouble extends Items implements Useable{

	private ImageIcon scoreDouble; // 점수 2배

	public ItemScoreDouble() {
		initData();
		setInitLayout();
	}

	private void initData() {
		scoreDouble = new ImageIcon(Define.IMG_ITEMS_SCOREDOUBLE);
	}

	private void setInitLayout() {
		setIcon(scoreDouble);
		setSize(50, 50);
		setLocation(x, y);
	}
	// todo score 클래스에 접근해서 일정시간동안 스코어 2배로 얻음
	
}
