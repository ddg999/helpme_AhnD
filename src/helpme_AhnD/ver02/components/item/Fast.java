package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

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
	public void useItems(DropNotePlayerService dropNotePlayerService) {
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
