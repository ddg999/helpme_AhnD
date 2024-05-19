package helpme_AhnD.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.components.NoteBar;
import helpme_AhnD.service.*;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;


public class DropNoteFrame_1P extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	public GameSelectFrame mContext;
	
	DropNoteFrame_1P dropNoteFrame;
	
	JLabel background;

	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	DropNote_1P_PlayerService soloPlayerService;
	// 게임 시작시 띄울 컴포넌트
	NoteBar noteBarSolo;
	// NoteBar_hj noteBarRight;
	// 게임시작시 재생될 bgm
	BGM bgm;

	public DropNoteFrame_1P(GameSelectFrame mContext) {
		this.mContext = mContext;
		dropNoteFrame = this;
		initData();
		setInitLayout();
		addEventListener();
		new Thread(() -> {
			try {
				Thread.sleep(BGM.END_TIME); // 일정 시간 이후 종료
				GameSelectFrame.setGameRunning(false);
				setVisible(false);
				bgm.getClip().close();
				new GameEndFrame(mContext, Player.SOLO);

			} catch (Exception e) {
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

		noteBarSolo = new NoteBar(mContext, Player.SOLO);
		soloPlayerService = new DropNote_1P_PlayerService(this, Player.SOLO);
		new Thread(soloPlayerService).start();

		bgm = mContext.getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);
		add(noteBarSolo);
	}

	private void addEventListener() {
	}

	// getter setter
	public DropNote_1P_PlayerService getSoloPlayerService() {
		return soloPlayerService;
	}
	
	public BGM getBgm() {
		return bgm;
	}
	

}
