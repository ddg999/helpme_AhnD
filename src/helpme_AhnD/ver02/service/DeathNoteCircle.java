package helpme_AhnD.ver02.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.DeathNoteFrame;
import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.state.KeyType;
import helpme_AhnD.ver02.utils.Define;

public class DeathNoteCircle extends JLabel {
	DeathNote deathNote;
	DeathNoteFrame deathNoteFrame;
	public int checkNow;
	boolean flag;
	private ImageIcon[] image;
	private int index;
	private int startIndex;
	private int endIndex;
	private int x;
	private int y;
	KeyType key;

	public DeathNoteCircle(DeathNote deathNote, DeathNoteFrame deathNoteFrame, KeyType key) {
		x = deathNote.getLocation_X() - 30;
		y = deathNote.getNOTE_Y_LOCATION() - 5;
		this.deathNoteFrame = deathNoteFrame;
		this.key = key;

		initData();
		setInitLayout();
		new Thread(() -> {
			// while(true) {

			try {
				for (index = startIndex; index <= endIndex; index++) {
					setIcon(image[index]);
					setLocation(x + index * 5, y);
					checkNow = index;
					this.repaint();
					Thread.sleep(200);
				}
				setIcon(null);
				deathNoteFrame.remove(this);
				this.repaint();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}).start();
	}
//		
//	}

	private void initData() {
		image = new ImageIcon[20];
		image[Define.INDEX_ARROW_BAD_OVER_LEFT] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_LEFT);
		image[Define.INDEX_ARROW_GOOD_LEFT] = new ImageIcon(Define.IMG_ARROW_GOOD_LEFT);
		image[Define.INDEX_ARROW_EXCELLENT_LEFT] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_LEFT);
		image[Define.INDEX_ARROW_PERFECT_LEFT] = new ImageIcon(Define.IMG_ARROW_PERFECT_LEFT);
		image[Define.INDEX_ARROW_BAD_LATE_LEFT] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_LEFT);
		image[Define.INDEX_ARROW_BAD_OVER_UP] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_UP);
		image[Define.INDEX_ARROW_GOOD_UP] = new ImageIcon(Define.IMG_ARROW_GOOD_UP);
		image[Define.INDEX_ARROW_EXCELLENT_UP] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_UP);
		image[Define.INDEX_ARROW_PERFECT_UP] = new ImageIcon(Define.IMG_ARROW_PERFECT_UP);
		image[Define.INDEX_ARROW_BAD_LATE_UP] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_UP);
		image[Define.INDEX_ARROW_BAD_OVER_DOWN] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_DOWN);
		image[Define.INDEX_ARROW_GOOD_DOWN] = new ImageIcon(Define.IMG_ARROW_GOOD_DOWN);
		image[Define.INDEX_ARROW_EXCELLENT_DOWN] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_DOWN);
		image[Define.INDEX_ARROW_PERFECT_DOWN] = new ImageIcon(Define.IMG_ARROW_PERFECT_DOWN);
		image[Define.INDEX_ARROW_BAD_LATE_DOWN] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_DOWN);
		image[Define.INDEX_ARROW_BAD_OVER_RIGHT] = new ImageIcon(Define.IMG_ARROW_BAD_OVER_RIGHT);
		image[Define.INDEX_ARROW_GOOD_RIGHT] = new ImageIcon(Define.IMG_ARROW_GOOD_RIGHT);
		image[Define.INDEX_ARROW_EXCELLENT_RIGHT] = new ImageIcon(Define.IMG_ARROW_EXCELLENT_RIGHT);
		image[Define.INDEX_ARROW_PERFECT_RIGHT] = new ImageIcon(Define.IMG_ARROW_PERFECT_RIGHT);
		image[Define.INDEX_ARROW_BAD_LATE_RIGHT] = new ImageIcon(Define.IMG_ARROW_BAD_LATE_RIGHT);

		switch (key) {
		case LEFT:
			startIndex = Define.INDEX_ARROW_BAD_OVER_LEFT;
			endIndex = Define.INDEX_ARROW_BAD_LATE_LEFT;
			break;
		case UP:
			startIndex = Define.INDEX_ARROW_BAD_OVER_UP;
			endIndex = Define.INDEX_ARROW_BAD_LATE_UP;
			break;
		case DOWN:
			startIndex = Define.INDEX_ARROW_BAD_OVER_DOWN;
			endIndex = Define.INDEX_ARROW_BAD_LATE_DOWN;
			break;
		case RIGHT:
			startIndex = Define.INDEX_ARROW_BAD_OVER_RIGHT;
			endIndex = Define.INDEX_ARROW_BAD_LATE_RIGHT;
			break;
		}
	}

	private void setInitLayout() {
		setSize(100, 100);
		setIcon();
		setLocation(x, y);

	}

	private void setIcon() {
		switch (key) {
		case LEFT:
			setIcon(image[Define.INDEX_ARROW_BAD_OVER_LEFT]);
			break;
		case UP:
			setIcon(image[Define.INDEX_ARROW_BAD_OVER_UP]);
			break;
		case DOWN:
			setIcon(image[Define.INDEX_ARROW_BAD_OVER_DOWN]);
			break;
		case RIGHT:
			setIcon(image[Define.INDEX_ARROW_BAD_OVER_RIGHT]);
			break;
		}
	}

	public ImageIcon[] getImage() {
		return image;
	}

	public boolean circlePerfectZone() {
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

	public boolean circleExcellentZone() {
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

	public boolean circleGoodZone() {
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

	public boolean circleBadZone() {
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

}
