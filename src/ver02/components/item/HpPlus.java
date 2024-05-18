package ver02.components.item;

import javax.swing.ImageIcon;

import ver02.interfaces.Useable;
import ver02.service.DropNote_2P_PlayerService;
import ver02.service.Score;
import ver02.utils.Define;

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
		dropNotePlayerService.getScoreService().setHp(dropNotePlayerService.getScoreService().getHp() + 20);
	}
	



}
