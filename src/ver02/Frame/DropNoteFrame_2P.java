package ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ver02.components.ItemBox;
import ver02.components.NoteBar;
import ver02.service.BGM;
import ver02.service.DropNote_2P_PlayerService;
import ver02.state.Player;
import ver02.utils.Define;

public class DropNoteFrame_2P extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	GameSelectFrame gameSelectFrame;

	DropNoteFrame_2P dropNoteFrame;

	JLabel background;
	ImageIcon dunk;

	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	DropNote_2P_PlayerService leftPlayerService;
	DropNote_2P_PlayerService rightPlayerService;
	// 게임 시작시 띄울 컴포넌트
	NoteBar noteBarLeft;
	NoteBar noteBarRight;
	ItemBox itembox;
	// 게임시작시 재생될 bgm
	BGM bgm;

	private static boolean Running;

	public DropNoteFrame_2P(GameSelectFrame gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		dropNoteFrame = this;
		initData();
		setInitLayout();
		new Thread(() -> {
			try {
				Thread.sleep(BGM.END_TIME); // 일정 시간 이후 종료
				Running = false;
				setVisible(false);
				bgm.getClip().close();
				if (leftPlayerService.getScoreService().getScore() > rightPlayerService.getScoreService().getScore()) {
					new GameEndFrame(dropNoteFrame, Player.RIGHTPLAYER); // 진쪽을 넘겨줌
				} else {
					new GameEndFrame(dropNoteFrame, Player.LEFTPLAYER);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		Running = true;
		setTitle("DropNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		noteBarLeft = new NoteBar(this, Player.LEFTPLAYER);
		leftPlayerService = new DropNote_2P_PlayerService(this, Player.LEFTPLAYER);
		new Thread(leftPlayerService).start();

		noteBarRight = new NoteBar(this, Player.RIGHTPLAYER);
		rightPlayerService = new DropNote_2P_PlayerService(this, Player.RIGHTPLAYER);
		new Thread(rightPlayerService).start();

		itembox = new ItemBox(this);
		bgm = gameSelectFrame.getmContext().getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);
	}

	// getter setter
	public static boolean isRunning() {
		return Running;
	}

	public static void setRunning(boolean running) {
		Running = running;
	}

	public DropNote_2P_PlayerService getDropNoteLeftPlayerService() {
		return leftPlayerService;
	}

	public DropNote_2P_PlayerService getDropNoteRightPlayerService() {
		return rightPlayerService;
	}

	public JLabel getBackgroundLabel() {
		return background;
	}

	public BGM getBgm() {
		return bgm;
	}

}
