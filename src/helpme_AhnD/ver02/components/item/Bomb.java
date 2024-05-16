package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class Bomb extends Items implements Useable {

	private ImageIcon bomb; // 화면 숨김
	private ImageIcon bombImg;
	private JLabel bombImgLabel;
	
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
		setSize(50, 50);
		setLocation(X, Y);
	}
	@Override
	public void useItems(DropNotePlayerService dropNotePlayerService) {
		
		if (dropNotePlayerService.getPlayer() == Player.LEFTPLAYER) {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622,565);
			bombImgLabel.setLocation(900, 200);
		} else {
			bombImgLabel = new JLabel(bombImg);
			bombImgLabel.setSize(622,565);
			bombImgLabel.setLocation(100, 200);
		}
		dropNotePlayerService.getmContext().add(bombImgLabel);
		dropNotePlayerService.getmContext().repaint();
	}
	
}
