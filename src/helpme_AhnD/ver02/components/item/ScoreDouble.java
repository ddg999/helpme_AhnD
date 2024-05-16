package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class ScoreDouble extends Items implements Useable{

	private ImageIcon scoreDouble; // 점수 2배

	public ScoreDouble() {
		initData();
		setInitLayout();
	}

	private void initData() {
		scoreDouble = new ImageIcon(Define.IMG_ITEMS_SCOREDOUBLE);
		buffType = Items.BUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(scoreDouble);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}
	public void useItems(DropNotePlayerService dropNotePlayerService) {
		dropNotePlayerService.getScore().setDouble(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScore().setDouble(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
