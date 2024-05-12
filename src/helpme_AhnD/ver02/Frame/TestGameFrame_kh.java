package helpme_AhnD.ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.NoteBar_jw;
import helpme_AhnD.ver02.components.NoteBar_kh;
import helpme_AhnD.ver02.service.PlayerService_kh;

public class TestGameFrame_kh extends JFrame{
	
	JLabel introImage;
	PlayerService_kh playerService;
	NoteBar_kh noteBar;
	
	public TestGameFrame_kh() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		introImage = new JLabel(new ImageIcon("images/Frame_background.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(introImage);
		setSize(1600, 900); // 수정

		playerService = new PlayerService_kh(this);
		noteBar = new NoteBar_kh(this);
		new Thread(playerService).start();
	}

	private void setInitLayout() {
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		setResizable(false); // 프레임 크기 조절 불가
		setVisible(true); // 화면 출력
	}

	private void addEventListener() {
		
	}
	
	public static void main(String[] args) {
		new TestGameFrame_kh();
	}
}
