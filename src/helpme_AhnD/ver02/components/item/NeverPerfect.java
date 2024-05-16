package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

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
	
	public void useItems(DropNotePlayerService dropNotePlayerService) {
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
