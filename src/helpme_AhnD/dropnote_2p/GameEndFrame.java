package helpme_AhnD.dropnote_2p;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.frame.MainFrame;
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
		} else if (loser == Player.RIGHTPLAYER) {
			background = new JLabel(leftWin);
		}
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		font = new Font("휴먼엑스포", Font.ITALIC, 50);
		// 게임 셀렉 프레임의 셀렉넘버에 따라 호출
		switch (mContext.getSelectNumber()) {
		case GameSelectFrame.GAMENAME_DROPNOTE_1P:
			break;
		case GameSelectFrame.GAMENAME_DROPNOTE_2P:
			dropNote2pImage();
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_1P:
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_2P:
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
		if (loser == Player.LEFTPLAYER) {
			rightWin = new ImageIcon(Define.IMG_GAMEOVER_RIGHTWIN_SCORE);
			background.setIcon(rightWin);
		} else {
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
		switch (mContext.getSelectNumber()) {
		case GameSelectFrame.GAMENAME_DROPNOTE_1P:
			break;
		case GameSelectFrame.GAMENAME_DROPNOTE_2P:
			mContext.dropNoteFrame_2P.setVisible(true);
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_1P:
			break;
		case GameSelectFrame.GAMENAME_TRYCATCH_2P:
			break;
		}
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

}
