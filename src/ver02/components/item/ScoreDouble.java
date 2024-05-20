package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

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
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScoreService().setDouble(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScoreService().setDouble(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
