package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.components.DropNote;
import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

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
