package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.dropnote_2p.DropNote;
import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.utils.Define;

public class Slow extends Items implements Useable {

	private ImageIcon slow;

	public Slow() {
		initData();
		setInitLayout();
	}

	private void initData() {
		slow = new ImageIcon(Define.IMG_ITEMS_SLOW);
		buffType = Items.BUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(slow);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.setNoteSpeed(DropNote.DEFAULT_SPEED - 1);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.setNoteSpeed(DropNote.DEFAULT_SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
