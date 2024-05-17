package helpme_AhnD.ver02.Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class GameEndFrame_kh extends JFrame {

	private DeathNoteFrame mContext;
	private Player loser;
	private ImageIcon leftWin;
	private ImageIcon rightWin;

	public GameEndFrame_kh(DeathNoteFrame mContext, Player loser) {
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
