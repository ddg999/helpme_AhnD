package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class ItemBomb extends Items implements Useable {

	private ImageIcon bomb; // 화면 숨김
	private ImageIcon bombImg;
	private JLabel bombImgLabel;
	
	public ItemBomb() {
		initData();
		setInitLayout();
	}

	private void initData() {
		bomb = new ImageIcon(Define.IMG_ITEMS_BOMB);
		bombImg = new ImageIcon(Define.IMG_ITEMS_BOMB_IMG);
		
	}

	private void setInitLayout() {
		setIcon(bomb);
		setSize(50, 50);
		setLocation(x, y);
	}
	@Override
	public JLabel useItems(Player place) {
		
		if (place == Player.LEFT) {
			bombImgLabel = new JLabel(bombImg);
			setSize(622,565);
			setLocation(900, 100);
		} else {
			bombImgLabel = new JLabel(bombImg);
			setSize(622,565);
			setLocation(100, 100);
		}
		return bombImgLabel;
	}
	
}
