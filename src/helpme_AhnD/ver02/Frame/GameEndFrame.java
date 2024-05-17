package helpme_AhnD.ver02.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class GameEndFrame extends JFrame {

	private DropNoteFrame mContext;
	private Player loser;
	private ImageIcon leftWin;
	private ImageIcon rightWin;

	private int SCORE = 0;
	private int PERFECT = 1;
	private int EXCELLENT = 2;
	private int GOOD = 3;
	private int BAD = 4;
	private int MISS = 5;
	private int MAX_COMBO = 6;

	public GameEndFrame(DropNoteFrame mContext, Player loser) {
		this.loser = loser;
		this.mContext = mContext;
		initData();
		setInitLayout();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addEventListener();
	}

	private void initData() {
		leftWin = new ImageIcon(Define.IMG_GAMEOVER_LEFTWIN);
		rightWin = new ImageIcon(Define.IMG_GAMEOVER_RIGHTWIN);
		setTitle("게임 종료");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);

		if (loser == Player.LEFTPLAYER) {
			setContentPane(new JLabel(rightWin));
		} else {
			setContentPane(new JLabel(leftWin));
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("휴먼엑스포", Font.ITALIC, 50);

		JLabel[] leftScore = new JLabel[7];
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
		for (int i = 0; i < leftScore.length; i++) {
			leftScore[i].setFont(font);
			leftScore[i].setForeground(Color.white);
			leftScore[i].setHorizontalAlignment(JLabel.CENTER);
			leftScore[i].setBounds(350, 110 + 100 * i, 200, 50);
			add(leftScore[i]);
		}

		JLabel[] rightScore = new JLabel[7];
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
		for (int i = 0; i < rightScore.length; i++) {
			rightScore[i].setFont(font);
			rightScore[i].setForeground(Color.white);
			rightScore[i].setHorizontalAlignment(JLabel.CENTER);
			rightScore[i].setBounds(1000, 110 + 100 * i, 200, 50);
			add(rightScore[i]);
		}
	}

	private void setInitLayout() {
		setLayout(null); // 좌표기반 레이아웃
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setVisible(true); // 화면에 보이기
	}

	private void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				passFrame();
			}
		});
	}

	private void passFrame() {
		mContext.gameSelectFrame.setVisible(true);
		setVisible(false);
	}

}
