package helpme_AhnD.frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.components.AhnCharacter;
import helpme_AhnD.components.CatchNote;
import helpme_AhnD.components.ItemBox;
import helpme_AhnD.service.BGM;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class TryCatchFrame_2P extends JFrame {
	
	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	public GameSelectFrame mContext;
	
	TryCatchFrame_2P tryCatch_2P_Frame;
	
	JLabel background;
	// 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔)
	TryCatch_2P_PlayerService leftPlayerService;
	TryCatch_2P_PlayerService rightPlayerService;
	
	// 게임 시작시 띄울 컴포넌트
	CatchNote catchNote;
	ItemBox itemBox;
	public AhnCharacter ahnCharacterLeft;
	public AhnCharacter ahnCharacterRight;
	// 게임시작시 재생될 bgm
	BGM bgm;

	public TryCatchFrame_2P(GameSelectFrame mContext) {
		this.mContext = mContext;
		tryCatch_2P_Frame = this;
		initData();
		setInitLayout();
		new Thread(() -> {
			try {
				Thread.sleep(BGM.END_TIME); // 일정 시간 이후 종료
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

		setTitle("TryCatch");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		leftPlayerService = new TryCatch_2P_PlayerService(this, Player.LEFTPLAYER);
		ahnCharacterLeft = new AhnCharacter(mContext, leftPlayerService, Player.LEFTPLAYER);
		
		rightPlayerService = new TryCatch_2P_PlayerService(this, Player.RIGHTPLAYER);
		ahnCharacterRight = new AhnCharacter(mContext, rightPlayerService, Player.RIGHTPLAYER);
		
		itemBox = new ItemBox(mContext);
		bgm = mContext.getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		add(itemBox);
		add(ahnCharacterLeft);
		add(ahnCharacterRight);
	}
	
	// getter setter

	public BGM getBgm() {
		return bgm;
	}

	public TryCatch_2P_PlayerService getLeftPlayerService() {
		return leftPlayerService;
	}

	public TryCatch_2P_PlayerService getRightPlayerService() {
		return rightPlayerService;
	}
	
}
