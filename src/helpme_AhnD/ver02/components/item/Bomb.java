package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

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
	public void useItems(DropNotePlayerService dropNotePlayerService) {
		// 디버프는 상대 주소를 받아옴
		if (dropNotePlayerService.getPlayer() == Player.LEFTPLAYER) {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622,565);
			bombImgLabel.setLocation(100, 200);
		} else {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622,565);
			bombImgLabel.setLocation(900, 200);
		}
		dropNotePlayerService.getmContext().add(bombImgLabel);
		dropNotePlayerService.getmContext().repaint();
		new Thread(() -> {
			try {
				// 지속시간 이후 제거
				Thread.sleep(Items.DURATION_TIME);
				dropNotePlayerService.getmContext().remove(bombImgLabel);
				dropNotePlayerService.getmContext().repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}
	
}
