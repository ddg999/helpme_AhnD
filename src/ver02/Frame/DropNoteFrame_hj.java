package ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ver02.components.ItemBox;
import ver02.components.NoteBar_hj;
import ver02.service.BGM;
import ver02.service.DropNotePlayerService_hj;
import ver02.state.Player;
import ver02.utils.Define;

public class DropNoteFrame_hj extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	GameSelectFrame_hj gameSelectFrame;
	
	DropNoteFrame_hj dropNoteFrame_hj;
	
	JLabel background;

	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	DropNotePlayerService_hj LeftPlayerService;
	// DropNotePlayerService_hj RightPlayerService;
	// 게임 시작시 띄울 컴포넌트
	NoteBar_hj noteBarLeft;
	// NoteBar_hj noteBarRight;
	ItemBox itembox;
	// 게임시작시 재생될 bgm
	BGM bgm;

	private static boolean Running;

	public DropNoteFrame_hj(GameSelectFrame_hj gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		dropNoteFrame_hj = this;
		initData();
		setInitLayout();
		addEventListener();
		new Thread(() -> {
			try {
				Thread.sleep(BGM.END_TIME); // 일정 시간 이후 종료
				Running = false;
				setVisible(false);
				bgm.getClip().close();
//				if (LeftPlayerService.getScoreService().getScore() > RightPlayerService.getScoreService().getScore()) {
//					new GameEndFrame_hj(dropNoteFrame_hj, Player.RIGHTPLAYER); // 진쪽을 넘겨줌
//				} else {
//					new GameEndFrame_hj(dropNoteFrame_hj, Player.LEFTPLAYER);
//				}

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

		noteBarLeft = new NoteBar_hj(this, Player.LEFTPLAYER);
		LeftPlayerService = new DropNotePlayerService_hj(this, Player.LEFTPLAYER);
		new Thread(LeftPlayerService).start();

//		noteBarRight = new NoteBar_hj(this, Player.RIGHTPLAYER);
//		RightPlayerService = new DropNotePlayerService_hj(this, Player.RIGHTPLAYER);
//		new Thread(RightPlayerService).start();

		
		// 아이템박스 주석
		// itembox = new ItemBox(this);
		bgm = gameSelectFrame.getmContext().getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);

	}

	private void addEventListener() {
	}

	// getter setter
	public static boolean isRunning() {
		return Running;
	}

	public static void setRunning(boolean running) {
		Running = running;
	}

	public DropNotePlayerService_hj getDropNoteLeftPlayerService() {
		return LeftPlayerService;
	}

//	public DropNotePlayerService_hj getDropNoteRightPlayerService() {
//		return RightPlayerService;
//	}

	public JLabel getBackgroundLabel() {
		return background;
	}

	public BGM getBgm() {
		return bgm;
	}
	

}
