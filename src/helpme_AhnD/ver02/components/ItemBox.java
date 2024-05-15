package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.service.DropNotePlayerService;

public class ItemBox extends JLabel {

	DropNoteFrame mContext;

	private int x;
	private int y;
	private boolean appear;
	private ImageIcon itemBox;
	private int countLeft;
	private int countRight;
	

	public ItemBox(DropNoteFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
		
		new Thread(() -> {
			while (mContext.isRunning()) {
				try {
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
	}

	public void setInitLayout() {
		setIcon(itemBox);
		setSize(159, 160);
		setLocation(x, y);
		mContext.add(this);
	}
	
	public void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (appear) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						countLeft++;
						if (countLeft >= 30) {
							// 왼쪽 플레이어가 아이템 사용
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
						countRight++;
						if (countLeft >= 30) {
							// 오른쪽 플레이어가 아이템 사용
						}
					}
				}
			}
		});
	}
}
