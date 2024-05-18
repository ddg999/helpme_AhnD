package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.utils.Define;

public class NeverPerfect extends Items implements Useable {

	private ImageIcon neverPerfect;

	public NeverPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		neverPerfect = new ImageIcon(Define.IMG_ITEMS_NEVERPERFECT);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(neverPerfect);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScore().setAllPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScore().setAllPerfect(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
