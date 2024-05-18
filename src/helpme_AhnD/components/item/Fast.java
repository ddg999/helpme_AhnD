package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.dropnote_2p.DropNote;
import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.utils.Define;

public class Fast extends Items implements Useable {

	private ImageIcon itemSpeedFast;

	public Fast() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemSpeedFast = new ImageIcon(Define.IMG_ITEMS_FAST);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(itemSpeedFast);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.setNoteSpeed(DropNote.DEFAULT_SPEED + 1);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.setNoteSpeed(DropNote.DEFAULT_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
