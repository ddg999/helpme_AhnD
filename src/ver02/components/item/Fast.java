package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.components.DropNote;
import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

public class Fast extends Items implements Useable{

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
	
	// todo 스피드 빠르게
	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.setNoteSpeed(DropNote.DEFAULT_SPEED + 1);
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
