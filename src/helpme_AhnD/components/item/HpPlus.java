package helpme_AhnD.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.utils.Define;

public class HpPlus extends Items implements Useable {

	private ImageIcon hpPlus; // 체력 +20

	public HpPlus() {
		initData();
		setInitLayout();
	}

	private void initData() {
		hpPlus = new ImageIcon(Define.IMG_ITEMS_HP_PLUS);
		buffType = Items.BUFF;
		durationType = Items.IMMEDIATE;
	}

	private void setInitLayout() {
		setIcon(hpPlus);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}

	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		dropNotePlayerService.getScore().setHp(dropNotePlayerService.getScore().getHp() + 20);
	}

}
