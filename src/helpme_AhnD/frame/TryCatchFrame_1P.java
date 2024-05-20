package helpme_AhnD.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.components.AhnCharacter;
import helpme_AhnD.components.CatchNote;
import helpme_AhnD.service.BGM;
import helpme_AhnD.service.TryCatch_1P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class TryCatchFrame_1P extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	public GameSelectFrame mContext;

	TryCatchFrame_1P tryCatch_1P_Frame;

	JLabel background;
	// 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	TryCatch_1P_PlayerService soloPlayerService;

	// 게임 시작시 띄울 컴포넌트
	CatchNote catchNote;
	public AhnCharacter ahnCharacterSolo;
	// 게임시작시 재생될 bgm
	BGM bgm;

	public TryCatchFrame_1P(GameSelectFrame mContext) {
		this.mContext = mContext;
		tryCatch_1P_Frame = this;
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
				new GameEndFrame(mContext, Player.SOLO); // 솔로

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		setTitle("TryCatch");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		soloPlayerService = new TryCatch_1P_PlayerService(this, Player.SOLO);
		ahnCharacterSolo = new AhnCharacter(mContext, soloPlayerService, Player.SOLO);

		bgm = mContext.getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(ahnCharacterSolo);
	}

	// getter setter

	public BGM getBgm() {
		return bgm;
	}

	public TryCatch_1P_PlayerService getSoloPlayerService() {
		return soloPlayerService;
	}

}
