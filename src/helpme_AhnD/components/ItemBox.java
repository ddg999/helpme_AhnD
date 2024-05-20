package helpme_AhnD.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.components.item.*;
import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.utils.Define;

public class ItemBox extends JLabel {

	GameSelectFrame mContext;

	private ImageIcon itemBox;
	private int x;
	private int y;
	private boolean appear; // 아이템이 등장 했는지 확인하는 변수

	private Items[] items;
	Items currentItem; // 현재 등장하고 영향을 끼치고 있는 아이템

	// 아이템을 획득하기 위한 버튼 클릭 수 카운트
	private int countLeft;
	private int countRight;

	public ItemBox(GameSelectFrame mContext) {
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
		items[Define.INDEX_ITEMS_HP_PLUS] = new HpPlus();
		items[Define.INDEX_ITEMS_ALLPERFECT] = new AllPerfect();
		items[Define.INDEX_ITEMS_SCOREDOUBLE] = new ScoreDouble();
		items[Define.INDEX_ITEMS_SLOW] = new Slow();
		items[Define.INDEX_ITEMS_HP_MINUS] = new HpMinus();
		items[Define.INDEX_ITEMS_BOMB] = new Bomb();
		items[Define.INDEX_ITEMS_REVERSE] = new Reverse();
		items[Define.INDEX_ITEMS_FAST] = new Fast();
		items[Define.INDEX_ITEMS_NEVERPERFECT] = new NeverPerfect();
	}

	public void setInitLayout() {
		setIcon(itemBox);
		setSize(159, 160);
		setLocation(x, y);
	}

	public void addEventListener() {
		if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_2P) {
			mContext.dropNoteFrame_2P.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (appear) {
						if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							countLeft++;
							if (countLeft >= 10) {
								// 왼쪽 플레이어가 아이템 사용
								if (currentItem.getBuffType() == Items.BUFF) {
									// 버프 아이템일 경우 자신의 서비스 주소 넘김
									currentItem.useItems(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService());
								} else {
									// 디버프 아이템일 경우 상대의 서비스 주소 넘김
									currentItem.useItems(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService());
								}
								appear = false;
								remove(currentItem);
							}
						}
						if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
							countRight++;
							if (countRight >= 10) {
								// 오른쪽 플레이어가 아이템 사용
								if (currentItem.getBuffType() == Items.BUFF) {
									// 버프 아이템일 경우 자신의 서비스 주소 넘김
									currentItem.useItems(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService());
								} else {
									// 디버프 아이템일 경우 상대의 서비스 주소 넘김
									currentItem.useItems(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService());
								}
								appear = false;
								remove(currentItem);
								repaint();
							}
						}
					}
				}
			});
		} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
			mContext.tryCatchFrame_2P.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (appear) {
						if (e.getKeyCode() == KeyEvent.VK_SPACE) {
							countLeft++;
							if (countLeft >= 10) {
								// 왼쪽 플레이어가 아이템 사용
								if (currentItem.getBuffType() == Items.BUFF) {
									// 버프 아이템일 경우 자신의 서비스 주소 넘김
									currentItem.useItems(mContext.tryCatchFrame_2P.getLeftPlayerService());
								} else {
									// 디버프 아이템일 경우 상대의 서비스 주소 넘김
									currentItem.useItems(mContext.tryCatchFrame_2P.getRightPlayerService());
								}
								appear = false;
								remove(currentItem);
							}
						}
						if (e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
							countRight++;
							if (countRight >= 10) {
								// 오른쪽 플레이어가 아이템 사용
								if (currentItem.getBuffType() == Items.BUFF) {
									// 버프 아이템일 경우 자신의 서비스 주소 넘김
									currentItem.useItems(mContext.tryCatchFrame_2P.getRightPlayerService());
								} else {
									// 디버프 아이템일 경우 상대의 서비스 주소 넘김
									currentItem.useItems(mContext.tryCatchFrame_2P.getLeftPlayerService());
								}
								appear = false;
								remove(currentItem);
								repaint();
							}
						}
					}
				}
			});
		}
	}

	private void itemThread() {
		new Thread(() -> {
			while (GameSelectFrame.isGameRunning()) {
				try {
					Thread.sleep(30000); // 30초에 한번씩 아이템 등장
					currentItem = createItem(); // 아이템 생성
					add(currentItem);
					remove(currentItem); // 혹시나 아이템을 획득 하지 않았다면 아이템을 우선 지움
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// 아이템 생성 메소드
	private Items createItem() {
		appear = true;
		if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_DROPNOTE_2P) {
			int randomItem = (new Random()).nextInt(9); // 동일 확률 랜덤 생성
			return items[randomItem];
		} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
			int randomItem = (new Random()).nextInt(9); // 동일 확률 랜덤 생성 3, 7 제외
			while (randomItem == Define.INDEX_ITEMS_SLOW || randomItem == Define.INDEX_ITEMS_FAST) {
				randomItem = (new Random()).nextInt(9);
			}
			return items[randomItem];
		}
		return null;
	}
}
