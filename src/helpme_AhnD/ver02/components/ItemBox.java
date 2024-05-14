package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DropNotePlayerService;

public class ItemBox extends JLabel {

	DropNotePlayerService playerService;

	private int x;
	private int y;
	private boolean isRun = true; // 게임 실행중
	private ImageIcon itemBox;

	public ItemBox(DropNotePlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
	}

	public void initData() {
		itemBox = new ImageIcon("images/item/IMG_ITEMS_ITEMBOX.jpg");
		x = 713;
		y = 20;
	}

	public void setInitLayout() {
		setIcon(itemBox);
		setSize(159, 160);
		setLocation(x, y);
		playerService.getmContext().add(this);
	}
}
