package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

public class NeverPerfect extends Items implements Useable{

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
		dropNotePlayerService.getScoreService().setAllPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScoreService().setAllPerfect(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
