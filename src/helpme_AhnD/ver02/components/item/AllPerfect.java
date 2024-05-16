package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class AllPerfect extends Items implements Useable {
	
	
	private ImageIcon itemAllPerfect;
	
	public AllPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemAllPerfect = new ImageIcon(Define.IMG_ITEMS_ALLPERFECT);
		buffType = Items.BUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(itemAllPerfect);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	// todo 전부 퍼펙트
	@Override
	public void useItems(DropNotePlayerService dropNotePlayerService) {
		dropNotePlayerService.getScoreService().setNeverPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScoreService().setNeverPerfect(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
}
