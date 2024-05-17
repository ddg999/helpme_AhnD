package helpme_AhnD.ver02.Frame;

import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver01.service.BGM;
import helpme_AhnD.ver01.service.PlayerService;
import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.components.DeathNoteDown;
import helpme_AhnD.ver02.components.DeathNoteLeft;
import helpme_AhnD.ver02.components.DeathNoteRight;
import helpme_AhnD.ver02.components.DeathNoteUp;
import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.ItemBox2;
import helpme_AhnD.ver02.service.BGMService;
import helpme_AhnD.ver02.service.DeathNotePlayerService;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.service.PlayerService_js;
import helpme_AhnD.ver02.state.Player;
import helpme_AhnD.ver02.utils.Define;

public class DeathNoteFrame extends JFrame {

	GameSelectFrame gameSelectFrame;

	JLabel background;
	DeathNotePlayerService notePlayerService1;
	DeathNotePlayerService notePlayerService2;
	DeathNote deathNote;
//	DeathNoteLeft deathNoteLeft;
//	DeathNoteRight deathNoteRight;
//	DeathNoteUp deathNoteUp;
//	DeathNoteDown deathNoteDown;
	PlayerService playerService;
	helpme_AhnD.ver02.service.BGM bgm;
	AhnCharacter ahnCharacter;

	ItemBox2 itemBox;
	private static boolean Running;

	public DeathNoteFrame(GameSelectFrame gameSelectFrame) {
		this.gameSelectFrame = gameSelectFrame;
		initData();
		setInitLayout();
	}

	private void initData() {
		background = new JLabel(new ImageIcon(Define.IMG_DROPNOTE_BG));

		Running = true;
		setTitle("DeathNote");
		setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		deathNoteRight = new DeathNoteRight(80, this);
//		deathNoteLeft = new DeathNoteLeft(180, this);
//		deathNoteUp = new DeathNoteUp(280, this);
//		deathNoteDown = new DeathNoteDown(380, this);
		notePlayerService1 = new DeathNotePlayerService(this, 1, Player.LEFTPLAYER);
		notePlayerService2 = new DeathNotePlayerService(this, 2, Player.RIGHTPLAYER);
		new Thread(notePlayerService1).start();
		new Thread(notePlayerService2).start();
		itemBox = new ItemBox2(this);
		ahnCharacter = new AhnCharacter(this, notePlayerService1, Player.LEFTPLAYER);
		ahnCharacter = new AhnCharacter(this, notePlayerService2, Player.RIGHTPLAYER);
		bgm = gameSelectFrame.getmContext().getBgmService().createBGM();
		bgm.getClip().start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	private void addEventListener() {

	}

	public boolean isRunning() {
		return Running;
	}

	public static void setRunning(boolean running) {
		Running = running;
	}

}
