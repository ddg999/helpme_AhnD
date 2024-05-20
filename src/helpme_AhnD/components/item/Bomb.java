package helpme_AhnD.components.item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class Bomb extends Items implements Useable {

	private ImageIcon bomb; // 화면 숨김
	private JLabel bombImgLabel;
	private ImageIcon bombImg;

	public Bomb() {
		initData();
		setInitLayout();
	}

	private void initData() {
		bomb = new ImageIcon(Define.IMG_ITEMS_BOMB);
		bombImg = new ImageIcon(Define.IMG_ITEMS_BOMB_IMG);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(bomb);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		// 디버프는 상대 주소를 받아옴
		if (dropNotePlayerService.getPlayer() == Player.LEFTPLAYER) {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622, 565);
			bombImgLabel.setLocation(34, 200);
		} else {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622, 565);
			bombImgLabel.setLocation(964, 200);
		}
		dropNotePlayerService.getmContext().dropNoteFrame_2P.add(bombImgLabel);
		dropNotePlayerService.getmContext().repaint();
		new Thread(() -> {
			try {
				// 지속시간 이후 제거
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getmContext().dropNoteFrame_2P.remove(bombImgLabel);
				dropNotePlayerService.getmContext().repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	@Override
	public void useItems(TryCatch_2P_PlayerService PlayerService) {
		// 디버프는 상대 주소를 받아옴
		if (PlayerService.getPlayer() == Player.LEFTPLAYER) {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622, 565);
			bombImgLabel.setLocation(34, 200);
		} else {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622, 565);
			bombImgLabel.setLocation(964, 200);
		}
		PlayerService.getmContext().tryCatchFrame_2P.add(bombImgLabel);
		PlayerService.getmContext().repaint();
		new Thread(() -> {
			try {
				// 지속시간 이후 제거
				Thread.sleep(Items.DURATION_TIME);
				PlayerService.getmContext().tryCatchFrame_2P.remove(bombImgLabel);
				PlayerService.getmContext().repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
