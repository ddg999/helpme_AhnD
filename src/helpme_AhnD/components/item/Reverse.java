package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.dropnote_2p.DropNote;
import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

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
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
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
