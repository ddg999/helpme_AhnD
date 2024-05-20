package helpme_AhnD.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class GameEndFrame extends JFrame {

	private GameSelectFrame mContext;
	private Player loser;
	private JLabel background;
	private ImageIcon leftWin;
	private ImageIcon rightWin;

	private final int SCORE = 0;
	private final int PERFECT = 1;
	private final int EXCELLENT = 2;
	private final int GOOD = 3;
	private final int BAD = 4;
	private final int MISS = 5;
	private final int MAX_COMBO = 6;

	private Font font;
	private JLabel[] leftScore;
	private JLabel[] rightScore;

	public GameEndFrame(GameSelectFrame mContext, Player loser) {
		this.loser = loser;
		this.mContext = mContext;
		initData();
		setInitLayout();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setInitLateLayout();
		addEventListener();
	}

	private void initData() {
		leftWin = new ImageIcon(Define.IMG_GAMEOVER_LEFTWIN);
		rightWin = new ImageIcon(Define.IMG_GAMEOVER_RIGHTWIN);
		setTitle("게임 종료");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);

		if (loser == Player.LEFTPLAYER) {
			background = new JLabel(rightWin);
			setContentPane(background);
		} else if (loser == Player.RIGHTPLAYER) {
			background = new JLabel(leftWin);
			setContentPane(background);
		} else if (loser == Player.SOLO) {
			// todo 게임 오버 이미지
			background = new JLabel(leftWin);
			setContentPane(background);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		font = new Font("휴먼엑스포", Font.ITALIC, 50);
		// 게임 셀렉 프레임의 셀렉넘버에 따라 호출
		switch (mContext.getSelectNumber()) {
		case GameSelectFrame.GAMENAME_DROPNOTE_1P:
			dropNote1pImage();
			break;
		case GameSelectFrame.GAMENAME_DROPNOTE_2P:
			dropNote2pImage();
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_1P:
			tryCatch1pImage();
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_2P:
			tryCatch2pImage();
			break;
		}

	}

	private void setInitLayout() {
		setLayout(null); // 좌표기반 레이아웃
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setVisible(true); // 화면에 보이기
	}

	private void setInitLateLayout() {
		// todo esc 입력시 게임선택화면으로 돌아간다는 표시
		if (loser == Player.LEFTPLAYER) {
			rightWin = new ImageIcon(Define.IMG_GAMEOVER_RIGHTWIN_SCORE);
			background.setIcon(rightWin);
		} else if (loser == Player.RIGHTPLAYER) {
			leftWin = new ImageIcon(Define.IMG_GAMEOVER_LEFTWIN_SCORE);
			background.setIcon(leftWin);
		} else if (loser == Player.SOLO) {
			// todo 게임 오버 이미지
			leftWin = new ImageIcon(Define.IMG_GAMEOVER_LEFTWIN_SCORE);
			background.setIcon(leftWin);
		}

		for (int i = 0; i < leftScore.length; i++) {
			leftScore[i].setFont(font);
			leftScore[i].setForeground(Color.white);
			leftScore[i].setHorizontalAlignment(JLabel.CENTER);
			leftScore[i].setBounds(350, 110 + 100 * i, 200, 50);
			background.add(leftScore[i]);
		}
		for (int i = 0; i < rightScore.length; i++) {
			rightScore[i].setFont(font);
			rightScore[i].setForeground(Color.white);
			rightScore[i].setHorizontalAlignment(JLabel.CENTER);
			rightScore[i].setBounds(1000, 110 + 100 * i, 200, 50);
			background.add(rightScore[i]);
		}
		repaint();
	}

	private void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					passFrame();
				}
			}
		});
	}

	private void passFrame() {
		mContext.setVisible(true);
		setVisible(false);
	}

	private void dropNote2pImage() {
		leftScore = new JLabel[7];
		leftScore[SCORE] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getScore()));
		leftScore[PERFECT] = new JLabel(Integer
				.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getCountPerfect()));
		leftScore[EXCELLENT] = new JLabel(Integer
				.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getCountExcellent()));
		leftScore[GOOD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getCountGood()));
		leftScore[BAD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getCountBad()));
		leftScore[MISS] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getCountMiss()));
		leftScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteLeftPlayerService().getScore().getMaxCombo()));

		rightScore = new JLabel[7];
		rightScore[SCORE] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getScore()));
		rightScore[PERFECT] = new JLabel(Integer
				.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getCountPerfect()));
		rightScore[EXCELLENT] = new JLabel(Integer
				.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getCountExcellent()));
		rightScore[GOOD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getCountGood()));
		rightScore[BAD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getCountBad()));
		rightScore[MISS] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getCountMiss()));
		rightScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_2P.getDropNoteRightPlayerService().getScore().getMaxCombo()));
	}

	private void dropNote1pImage() {
		leftScore = new JLabel[7];
		leftScore[SCORE] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getScore()));
		leftScore[PERFECT] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getCountPerfect()));
		leftScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getCountExcellent()));
		leftScore[GOOD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getCountGood()));
		leftScore[BAD] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getCountBad()));
		leftScore[MISS] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getCountMiss()));
		leftScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.dropNoteFrame_1P.getSoloPlayerService().getScore().getMaxCombo()));

		rightScore = new JLabel[7];
		rightScore[SCORE] = new JLabel(Integer.toString(0));
		rightScore[PERFECT] = new JLabel(Integer.toString(0));
		rightScore[EXCELLENT] = new JLabel(Integer.toString(0));
		rightScore[GOOD] = new JLabel(Integer.toString(0));
		rightScore[BAD] = new JLabel(Integer.toString(0));
		rightScore[MISS] = new JLabel(Integer.toString(0));
		rightScore[MAX_COMBO] = new JLabel(Integer.toString(0));
	}

	private void tryCatch2pImage() {
		leftScore = new JLabel[7];
		leftScore[SCORE] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getScore()));
		leftScore[PERFECT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getCountPerfect()));
		leftScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getCountExcellent()));
		leftScore[GOOD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getCountGood()));
		leftScore[BAD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getCountBad()));
		leftScore[MISS] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getCountMiss()));
		leftScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getLeftPlayerService().getScore().getMaxCombo()));

		rightScore = new JLabel[7];
		rightScore[SCORE] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getScore()));
		rightScore[PERFECT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getCountPerfect()));
		rightScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getCountExcellent()));
		rightScore[GOOD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getCountGood()));
		rightScore[BAD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getCountBad()));
		rightScore[MISS] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getCountMiss()));
		rightScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_2P.getRightPlayerService().getScore().getMaxCombo()));
	}
	private void tryCatch1pImage() {
		leftScore = new JLabel[7];
		leftScore[SCORE] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getScore()));
		leftScore[PERFECT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getCountPerfect()));
		leftScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getCountExcellent()));
		leftScore[GOOD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getCountGood()));
		leftScore[BAD] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getCountBad()));
		leftScore[MISS] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getCountMiss()));
		leftScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.tryCatchFrame_1P.getSoloPlayerService().getScore().getMaxCombo()));

		rightScore = new JLabel[7];
		rightScore[SCORE] = new JLabel(Integer.toString(0));
		rightScore[PERFECT] = new JLabel(Integer.toString(0));
		rightScore[EXCELLENT] = new JLabel(Integer.toString(0));
		rightScore[GOOD] = new JLabel(Integer.toString(0));
		rightScore[BAD] = new JLabel(Integer.toString(0));
		rightScore[MISS] = new JLabel(Integer.toString(0));
		rightScore[MAX_COMBO] = new JLabel(Integer.toString(0));
	}

}
