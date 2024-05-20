package ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ver02.Frame.DeathNoteFrame;
import ver02.Frame.DropNoteFrame_2P;
import ver02.components.item.AllPerfect;
import ver02.components.item.Bomb;
import ver02.components.item.Fast;
import ver02.components.item.HpMinus;
import ver02.components.item.HpPlus;
import ver02.components.item.Items;
import ver02.components.item.NeverPerfect;
import ver02.components.item.Reverse;
import ver02.components.item.ScoreDouble;
import ver02.components.item.Slow;
import ver02.service.DeathNotePlayerService;
import ver02.service.DropNote_2P_PlayerService;
import ver02.utils.Define;

public class ItemBox extends JLabel {

	DropNoteFrame_2P mContext;

	private ImageIcon itemBox;
	private int x;
	private int y;
	private boolean appear; // 아이템이 등장 했는지 확인하는 변수
	
	private Items[] items;
	Items currentItem; // 현재 등장하고 영향을 끼치고 있는 아이템
	
	// 아이템을 획득하기 위한 버튼 클릭 수 카운트
	private int countLeft;
	private int countRight;

	public ItemBox(DropNoteFrame_2P mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
		itemThread();
	}

	public void initData() {
		itemBox = new ImageIcon(Define.IMG_ITEMS_ITEMBOX);
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
						countLeft++;
						if (countLeft >= 30) {
							// 왼쪽 플레이어가 아이템 사용
							if (currentItem.getBuffType() == Items.BUFF) {
								// 버프 아이템일 경우 자신의 서비스 주소 넘김
								currentItem.useItems(mContext.getDropNoteLeftPlayerService());
							} else {
								// 디버프 아이템일 경우 상대의 서비스 주소 넘김
								currentItem.useItems(mContext.getDropNoteRightPlayerService());
							}
							appear = false;
							remove(currentItem);
						}
					}
					if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
						countRight++;
						if (countRight >= 30) {
							// 오른쪽 플레이어가 아이템 사용
							if (currentItem.getBuffType() == Items.BUFF) {
								// 버프 아이템일 경우 자신의 서비스 주소 넘김
								currentItem.useItems(mContext.getDropNoteRightPlayerService());
							} else {
								// 디버프 아이템일 경우 상대의 서비스 주소 넘김
								currentItem.useItems(mContext.getDropNoteLeftPlayerService());
							}
							appear = false;
							remove(currentItem);
						}
					}
				}
			}
		});
	}
	private void itemThread() {
		new Thread(() -> {
			while (mContext.isRunning()) {
				try {
					Thread.sleep(30000); // 30초에 한번씩 아이템 등장
					remove(currentItem); // 혹시나 아이템을 획득 하지 않았다면 아이템을 우선 지움
					currentItem = createItem(); // 아이템 생성
					add(currentItem);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
	// 아이템 생성 메소드
	private Items createItem() {
		appear = true;
		int randomItem = (new Random()).nextInt(9); // 동일 확률 랜덤 생성
		return items[randomItem];
	}
}
