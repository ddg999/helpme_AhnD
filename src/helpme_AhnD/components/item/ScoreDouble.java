package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.utils.Define;

public class ScoreDouble extends Items implements Useable{

	private ImageIcon scoreDouble; // 점수 2배
	public static final int DEFAULT = 1;
	public static final int DOUBLE = 2;

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
		dropNotePlayerService.getScore().setDouble(DOUBLE);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScore().setDouble(DEFAULT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	@Override
	public void useItems(TryCatch_2P_PlayerService PlayerService) {
		PlayerService.getScore().setDouble(DOUBLE);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				PlayerService.getScore().setDouble(DEFAULT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
