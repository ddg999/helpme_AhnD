package helpme_AhnD.ver02.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.NoteBar;
import helpme_AhnD.ver02.service.BGM;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class DropNoteFrame extends JFrame {

	// 게임 종료시 최종적으로 게임선택화면으로 돌아가기 위해 필요함
	GameSelectFrame gameSelectFrame;

	JLabel background;
	
	// DropNote 게임을 관리하는 서비스 클래스 (플레이어 위치로 나눔) 
	DropNotePlayerService dropNoteLeftPlayerService;
	DropNotePlayerService dropNoteRightPlayerService;
	// 게임 시작시 띄울 컴포넌트
	NoteBar noteBarLeft;
	NoteBar noteBarRight;
	ItemBox itembox;
	// 게임시작시 재생될 bgm
	BGM bgm;

	private static boolean Running;

	public DropNoteFrame(GameSelectFrame gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		Running = true;
		setTitle("DropNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		noteBarLeft = new NoteBar(this, Player.LEFTPLAYER);
		dropNoteLeftPlayerService = new DropNotePlayerService(this, Player.LEFTPLAYER);
		new Thread(dropNoteLeftPlayerService).start();

		noteBarRight = new NoteBar(this, Player.RIGHTPLAYER);
		dropNoteRightPlayerService = new DropNotePlayerService(this, Player.RIGHTPLAYER);
		new Thread(dropNoteRightPlayerService).start();

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

	private void addEventListener() {
	}

	// getter setter
	public static boolean isRunning() {
		return Running;
	}

	public static void setRunning(boolean running) {
		Running = running;
	}

	public DropNotePlayerService getDropNoteLeftPlayerService() {
		return dropNoteLeftPlayerService;
	}

	public DropNotePlayerService getDropNoteRightPlayerService() {
		return dropNoteRightPlayerService;
	}

	public JLabel getBackgroundLabel() {
		return background;
	}

	public BGM getBgm() {
		return bgm;
	}
	

}
