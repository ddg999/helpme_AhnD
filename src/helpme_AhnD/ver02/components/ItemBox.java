package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.components.item.*;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class ItemBox extends JLabel {

	DropNoteFrame mContext;

	private int x;
	private int y;
	private boolean appear;
	private ImageIcon itemBox;
	private int countLeft;
	private int countRight;
	private Items[] items;
	Items currentItem;

	public ItemBox(DropNoteFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();

		new Thread(() -> {
			while (mContext.isRunning()) {
				try {
					currentItem = createItem();
					add(currentItem);
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void initData() {
		itemBox = new ImageIcon("images/item/IMG_ITEMS_ITEMBOX.jpg");
		x = 713;
		y = 20;
		appear = false;
		items = new Items[9];
		items[Define.INT_ITEMS_HP_PLUS] = new HpPlus();
		items[Define.INT_ITEMS_ALLPERFECT] = new AllPerfect();
		items[Define.INT_ITEMS_SCOREDOUBLE] = new ScoreDouble();
		items[Define.INT_ITEMS_SLOW] = new Slow();
		items[Define.INT_ITEMS_HP_MINUS] = new HpMinus();
		items[Define.INT_ITEMS_BOMB] = new Bomb();
		items[Define.INT_ITEMS_REVERSE] = new Reverse();
		items[Define.INT_ITEMS_FAST] = new Fast();
		items[Define.INT_ITEMS_NEVERPERFECT] = new NeverPerfect();
	}

	public void setInitLayout() {
		setIcon(itemBox);
		setSize(159, 160);
		setLocation(x, y);
		mContext.add(this);
	}

	public void addEventListener() {
		mContext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (appear) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						System.out.println("작동");
						countLeft++;
						// todo 회수 고쳐야함
						if (countLeft >= 1) {
							// 왼쪽 플레이어가 아이템 사용
							currentItem.useItems(mContext.getDropNoteLeftPlayerService());
							appear = false;
							System.out.println("아이템 사용");
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
						countRight++;
						// todo 회수 고쳐야함
						if (countRight >= 1) {
							// 오른쪽 플레이어가 아이템 사용
							currentItem.useItems(mContext.getDropNoteRightPlayerService());
							appear = false;
						}
					}
				}
			}
		});
	}

	private Items createItem() {
		appear = true;
		// 임시로 원하는 아이템 바로 쓸수 있게 함
		return items[Define.INT_ITEMS_BOMB];
//		int randomItem = (new Random()).nextInt(9);
//		return items[randomItem];
	}
}
