package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class Reverse extends Items implements Useable {

	private ImageIcon reverse; // 키 반전

	public Reverse() {
		initData();
		setInitLayout();
	}

	private void initData() {
		reverse = new ImageIcon(Define.IMG_ITEMS_REVERSE);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(reverse);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}
	
	@Override
	public void useItems(DropNotePlayerService dropNotePlayerService) {
		// 디버프 아이템일 경우 상대의 서비스 주소 받아옴
		if (dropNotePlayerService.getPlayer() == Player.LEFTPLAYER) {
			DropNote.setLeftReverse(true);
		} else {
			DropNote.setRightReverse(true);
		}
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME );
				DropNote.setLeftReverse(false);
				DropNote.setRightReverse(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
	

}
