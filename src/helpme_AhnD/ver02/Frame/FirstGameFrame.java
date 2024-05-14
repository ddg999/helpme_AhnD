package helpme_AhnD.ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.components.NoteBar;
import helpme_AhnD.ver02.service.DropNotePlayerService;
import helpme_AhnD.ver02.utils.Define;

public class FirstGameFrame extends JFrame {

	JLabel background;
	DropNotePlayerService dropNotePlayerService1;
	DropNotePlayerService dropNotePlayerService2;
	NoteBar noteBar;

	public FirstGameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		// todo 각종 라벨 추가 예정
		background = new JLabel(new ImageIcon(Define.IMG_FIRSTGAME_BG));

		setTitle("첫번째 게임");
		setSize(1600, 900);
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		noteBar = new NoteBar(this, 1);
		noteBar = new NoteBar(this, 2);
		dropNotePlayerService1 = new DropNotePlayerService(this, 1);
		dropNotePlayerService2 = new DropNotePlayerService(this, 2);
		new Thread(dropNotePlayerService1).start();
		new Thread(dropNotePlayerService2).start();
	}

	private void setInitLayout() {
		setLayout(null);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setResizable(false);
		setVisible(true);

		// todo 각종 컴포넌트 add
	}

	private void addEventListener() {

	}

	// 코드 테스트 ( 최종은 지워야함 )
	public static void main(String[] args) {
		new FirstGameFrame();
	}
}
