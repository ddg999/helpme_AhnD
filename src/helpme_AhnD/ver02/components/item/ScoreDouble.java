package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ScoreDouble extends Items implements Useable{

	private ImageIcon scoreDouble; // 점수 2배

	public ScoreDouble() {
		initData();
		setInitLayout();
	}

	private void initData() {
		scoreDouble = new ImageIcon(Define.IMG_ITEMS_SCOREDOUBLE);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(scoreDouble);
		setSize(50, 50);
		setLocation(X, Y);
	}
	// todo score 클래스에 접근해서 일정시간동안 스코어 2배로 얻음
	
}
