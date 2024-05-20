package helpme_AhnD.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.state.KeyType;
import helpme_AhnD.utils.Define;

public class CatchNoteArrow extends JLabel {

	GameSelectFrame mContext;
	CatchNote catchNote;
	private ImageIcon[] arrows;
	private int index;
	private int startIndex;
	private int endIndex;
	private int x;
	private int y;
	KeyType key;
	private boolean isJudged = false;

	public CatchNoteArrow(GameSelectFrame mContext, CatchNote catchNote, KeyType key) {
		x = catchNote.getLocation_X();
		y = catchNote.NOTE_Y_LOCATION - 9;
		this.mContext = mContext;
		this.key = key;

		initData();
		setInitLayout();
		new Thread(() -> {
			try {
				// 판정 이미지가 점점 좁혀 오는 형태
				for (index = startIndex; index <= endIndex; index++) {
					if (isJudged) {
						break;
					}
					setIcon(arrows[index]);
					setLocation(x, y);
					this.repaint();
					Thread.sleep(300);
				}
				synchronized (catchNote.getCatchNoteArrow()) {
					catchNote.getCatchNoteArrow().notify();
				}
				// 판정이 되지 않았을때만 판정하고 제거 작업함
				if (!isJudged) {
					setIcon(null);
					catchNote.getPlayerService().getScore().miss();
					if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_2P) {
						mContext.tryCatchFrame_2P.remove(this);
					} else if (mContext.getSelectNumber() == GameSelectFrame.GAMENAME_TRYCATCH_1P) {
					}
					this.repaint();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}).start();
	}

	private void initData() {
		arrows = new ImageIcon[20];
		arrows[Define.INDEX_ARROW_BAD_OVER_LEFT] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_LEFT);
		arrows[Define.INDEX_ARROW_BAD_LATE_LEFT] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_LEFT);
		arrows[Define.INDEX_ARROW_GOOD_LEFT] = new ImageIcon(Define.IMG_ARROW_GOOD_LEFT);
		arrows[Define.INDEX_ARROW_EXCELLENT_LEFT] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_LEFT);
		arrows[Define.INDEX_ARROW_PERFECT_LEFT] = new ImageIcon(Define.IMG_ARROW_PERFECT_LEFT);
		arrows[Define.INDEX_ARROW_BAD_OVER_UP] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_UP);
		arrows[Define.INDEX_ARROW_BAD_LATE_UP] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_UP);
		arrows[Define.INDEX_ARROW_GOOD_UP] = new ImageIcon(Define.IMG_ARROW_GOOD_UP);
		arrows[Define.INDEX_ARROW_EXCELLENT_UP] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_UP);
		arrows[Define.INDEX_ARROW_PERFECT_UP] = new ImageIcon(Define.IMG_ARROW_PERFECT_UP);
		arrows[Define.INDEX_ARROW_BAD_OVER_DOWN] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_DOWN);
		arrows[Define.INDEX_ARROW_BAD_LATE_DOWN] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_DOWN);
		arrows[Define.INDEX_ARROW_GOOD_DOWN] = new ImageIcon(Define.IMG_ARROW_GOOD_DOWN);
		arrows[Define.INDEX_ARROW_EXCELLENT_DOWN] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_DOWN);
		arrows[Define.INDEX_ARROW_PERFECT_DOWN] = new ImageIcon(Define.IMG_ARROW_PERFECT_DOWN);
		arrows[Define.INDEX_ARROW_BAD_OVER_RIGHT] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_RIGHT);
		arrows[Define.INDEX_ARROW_BAD_LATE_RIGHT] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_RIGHT);
		arrows[Define.INDEX_ARROW_GOOD_RIGHT] = new ImageIcon(Define.IMG_ARROW_GOOD_RIGHT);
		arrows[Define.INDEX_ARROW_EXCELLENT_RIGHT] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_RIGHT);
		arrows[Define.INDEX_ARROW_PERFECT_RIGHT] = new ImageIcon(Define.IMG_ARROW_PERFECT_RIGHT);

		switch (key) {
		case LEFT:
			startIndex = Define.INDEX_ARROW_BAD_OVER_LEFT;
			endIndex = Define.INDEX_ARROW_PERFECT_LEFT;
			break;
		case UP:
			startIndex = Define.INDEX_ARROW_BAD_OVER_UP;
			endIndex = Define.INDEX_ARROW_PERFECT_UP;
			break;
		case DOWN:
			startIndex = Define.INDEX_ARROW_BAD_OVER_DOWN;
			endIndex = Define.INDEX_ARROW_PERFECT_DOWN;
			break;
		case RIGHT:
			startIndex = Define.INDEX_ARROW_BAD_OVER_RIGHT;
			endIndex = Define.INDEX_ARROW_PERFECT_RIGHT;
			break;
		}
	}

	private void setInitLayout() {
		setSize(103, 103);
		setIcon();
		setLocation(x, y);

	}

	private void setIcon() {
		switch (key) {
		case LEFT:
			setIcon(arrows[Define.INDEX_ARROW_BAD_OVER_LEFT]);
			break;
		case UP:
			setIcon(arrows[Define.INDEX_ARROW_BAD_OVER_UP]);
			break;
		case DOWN:
			setIcon(arrows[Define.INDEX_ARROW_BAD_OVER_DOWN]);
			break;
		case RIGHT:
			setIcon(arrows[Define.INDEX_ARROW_BAD_OVER_RIGHT]);
			break;
		}
	}

	public ImageIcon[] getImage() {
		return arrows;
	}

	public boolean arrowPerfectZone() {
		switch (key) {
		case LEFT:
			if (index == Define.INDEX_ARROW_PERFECT_LEFT) {
				return true;
			}
			return false;
		case UP:
			if (index == Define.INDEX_ARROW_PERFECT_UP) {
				return true;
			}
			return false;
		case DOWN:
			if (index == Define.INDEX_ARROW_PERFECT_DOWN) {
				return true;
			}
			return false;
		case RIGHT:
			if (index == Define.INDEX_ARROW_PERFECT_RIGHT) {
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public boolean arrowExcellentZone() {
		switch (key) {
		case LEFT:
			if (index == Define.INDEX_ARROW_EXCELLENT_LEFT) {
				return true;
			}
			return false;
		case UP:
			if (index == Define.INDEX_ARROW_EXCELLENT_UP) {
				return true;
			}
			return false;
		case DOWN:
			if (index == Define.INDEX_ARROW_EXCELLENT_DOWN) {
				return true;
			}
			return false;
		case RIGHT:
			if (index == Define.INDEX_ARROW_EXCELLENT_RIGHT) {
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public boolean arrowGoodZone() {
		switch (key) {
		case LEFT:
			if (index == Define.INDEX_ARROW_GOOD_LEFT) {
				return true;
			}
			return false;
		case UP:
			if (index == Define.INDEX_ARROW_GOOD_UP) {
				return true;
			}
			return false;
		case DOWN:
			if (index == Define.INDEX_ARROW_GOOD_DOWN) {
				return true;
			}
			return false;
		case RIGHT:
			if (index == Define.INDEX_ARROW_GOOD_RIGHT) {
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	public boolean arrowBadZone() {
		switch (key) {
		case LEFT:
			if (index == Define.INDEX_ARROW_BAD_OVER_LEFT || index == Define.INDEX_ARROW_BAD_LATE_LEFT) {
				return true;
			}
			return false;
		case UP:
			if (index == Define.INDEX_ARROW_BAD_OVER_UP || index == Define.INDEX_ARROW_BAD_LATE_UP) {
				return true;
			}
			return false;
		case DOWN:
			if (index == Define.INDEX_ARROW_BAD_OVER_DOWN || index == Define.INDEX_ARROW_BAD_LATE_DOWN) {
				return true;
			}
			return false;
		case RIGHT:
			if (index == Define.INDEX_ARROW_BAD_OVER_RIGHT || index == Define.INDEX_ARROW_BAD_LATE_RIGHT) {
				return true;
			}
			return false;
		default:
			return false;
		}
	}

	// getter setter
	public void setJudged(boolean isJudged) {
		this.isJudged = isJudged;
	}

}
