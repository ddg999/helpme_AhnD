package ver02.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ver02.state.Player;
import ver02.utils.Define;

public class GameEndFrame extends JFrame {

	private DropNoteFrame_2P mContext;
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

	public GameEndFrame(DropNoteFrame_2P mContext, Player loser) {
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
		} else {
			background = new JLabel(leftWin);
		}
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		font = new Font("휴먼엑스포", Font.ITALIC, 50);

		leftScore = new JLabel[7];
		leftScore[SCORE] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getScore()));
		leftScore[PERFECT] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getCountPerfect()));
		leftScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getCountExcellent()));
		leftScore[GOOD] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getCountGood()));
		leftScore[BAD] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getCountBad()));
		leftScore[MISS] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getCountMiss()));
		leftScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.getDropNoteLeftPlayerService().getScoreService().getMaxCombo()));

		rightScore = new JLabel[7];
		rightScore[SCORE] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getScore()));
		rightScore[PERFECT] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getCountPerfect()));
		rightScore[EXCELLENT] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getCountExcellent()));
		rightScore[GOOD] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getCountGood()));
		rightScore[BAD] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getCountBad()));
		rightScore[MISS] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getCountMiss()));
		rightScore[MAX_COMBO] = new JLabel(
				Integer.toString(mContext.getDropNoteRightPlayerService().getScoreService().getMaxCombo()));
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
		mContext.gameSelectFrame.setVisible(true);
		setVisible(false);
	}

}
