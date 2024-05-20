package helpme_AhnD.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.service.PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class AhnCharacter extends JLabel {

	GameSelectFrame mContext;
	PlayerService playerService;

	private ImageIcon basic_Character;
	private ImageIcon threePoint_DanceR;
	private ImageIcon threePoint_DanceL;
	private ImageIcon twoPoint_DanceR;
	private ImageIcon twoPoint_DanceL;
	private ImageIcon onePoint_DanceL;
	private ImageIcon onePoint_DanceR;
	// 이미지 추가
	private int x; // 위치 값
	private int y; // 위치 값
	public int playerScore; 
	public static final int PERFECT = 3;
	public static final int EXCELLENT = 2;
	public static final int BAD = 1;
	private boolean perfect = true;

	public AhnCharacter(GameSelectFrame mContext, PlayerService playerService, Player player) {
		this.playerService = playerService;
		this.mContext = mContext;
		switch (player) {
		case LEFTPLAYER:
			x = 190;
			break;
		case RIGHTPLAYER:
			x = 1120;
			break;
		case SOLO:
			x = 665;

		}

		initData();
		setInitLayout();
		playerScoreImage();
	}

	private void initData() {
		basic_Character = new ImageIcon(Define.IMG_BASIC_CHARCTER);
		onePoint_DanceL = new ImageIcon(Define.IMG_ONE_POINT_RIGHT);
		onePoint_DanceR = new ImageIcon(Define.IMG_ONE_POINT_LEFT);
		twoPoint_DanceL = new ImageIcon(Define.IMG_TWO_POINT_LEFT);
		twoPoint_DanceR = new ImageIcon(Define.IMG_TWO_POINT_RIGHT);
		threePoint_DanceL = new ImageIcon(Define.IMG_THREE_POINT_LEFT);
		threePoint_DanceR = new ImageIcon(Define.IMG_THREE_POINT_RIGHT);

		y = 300;

	}

	private void setInitLayout() {
		setIcon(basic_Character);
		setSize(261, 500);
		setLocation(x, y);
	}

	public void playerScoreImage() {

		new Thread(() -> {
			while (GameSelectFrame.isGameRunning()) {
				if (playerScore == 3) {
					for (int i = 0; i < 3; i++) {
						if (perfect) {
							setIcon(threePoint_DanceL);

						} else {

							setIcon(threePoint_DanceR);

						}
						perfect = !perfect;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} else if (playerScore == 2) {
					for (int i = 0; i < 3; i++) {
						if (perfect) {
							setIcon(twoPoint_DanceL);
							repaint();
						} else {

							setIcon(twoPoint_DanceR);
							repaint();
						}
						perfect = !perfect;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} else if (playerScore == 1) {
					for (int i = 0; i < 3; i++) {
						if (perfect) {
							setIcon(onePoint_DanceL);

						} else {

							setIcon(onePoint_DanceR);

						}
						perfect = !perfect;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				} else if (playerScore == 0) {
					for (int i = 0; i < 3; i++) {
						if (perfect) {
							setIcon(basic_Character);

						}

						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}

		}).start();

	}

} // end of class
