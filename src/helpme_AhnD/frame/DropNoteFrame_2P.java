package helpme_AhnD.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.components.*;
import helpme_AhnD.service.*;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class DropNoteFrame_2P extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	public GameSelectFrame mContext;

	DropNoteFrame_2P dropNoteFrame;

	JLabel background;

	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	DropNote_2P_PlayerService leftPlayerService;
	DropNote_2P_PlayerService rightPlayerService;
	// 게임 시작시 띄울 컴포넌트
	NoteBar noteBarLeft;
	NoteBar noteBarRight;
	ItemBox itembox;
	// 게임시작시 재생될 bgm
	BGM bgm;

	public DropNoteFrame_2P(GameSelectFrame mContext) {
		this.mContext = mContext;
		dropNoteFrame = this;
		initData();
		setInitLayout();
		new Thread(() -> {
			try {
				Thread.sleep(BGM.END_TIME); // 일정 시간 이후 종료
				GameSelectFrame.setNoteRunning(false);
				Thread.sleep(1500);
				setVisible(false);
				bgm.getClip().close();
				GameSelectFrame.setGameRunning(false);
				if (leftPlayerService.getScore().getScore() > rightPlayerService.getScore().getScore()) {
					new GameEndFrame(mContext, Player.RIGHTPLAYER); // 진쪽을 넘겨줌
				} else {
					new GameEndFrame(mContext, Player.LEFTPLAYER);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		setTitle("DropNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		noteBarLeft = new NoteBar(mContext, Player.LEFTPLAYER);
		leftPlayerService = new DropNote_2P_PlayerService(this, Player.LEFTPLAYER);
		new Thread(leftPlayerService).start();

		noteBarRight = new NoteBar(mContext, Player.RIGHTPLAYER);
		rightPlayerService = new DropNote_2P_PlayerService(this, Player.RIGHTPLAYER);
		new Thread(rightPlayerService).start();

		itembox = new ItemBox(this);
		bgm = mContext.getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);
		add(noteBarLeft);
		add(noteBarRight);
		add(itembox);
	}

	// getter setter
	public DropNote_2P_PlayerService getDropNoteLeftPlayerService() {
		return leftPlayerService;
	}

	public DropNote_2P_PlayerService getDropNoteRightPlayerService() {
		return rightPlayerService;
	}

	public BGM getBgm() {
		return bgm;
	}

}
