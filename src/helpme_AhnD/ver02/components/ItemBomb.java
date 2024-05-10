package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class ItemBomb extends Items implements Useable {

	private ImageIcon bomb; // 화면 숨김
	private ImageIcon bombImg;
	
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
		setSize(622, 565);
		setLocation(1200, 200);
	}
	// todo useable 수정
	@Override
	public void useItems() {
		// TODO Auto-generated method stub
		super.useItems();
	}
	
}
