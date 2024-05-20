package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.utils.Define;


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

	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScore().setNeverPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getScore().setNeverPerfect(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	@Override
	public void useItems(TryCatch_2P_PlayerService PlayerService) {
		PlayerService.getScore().setNeverPerfect(true);
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				PlayerService.getScore().setNeverPerfect(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
