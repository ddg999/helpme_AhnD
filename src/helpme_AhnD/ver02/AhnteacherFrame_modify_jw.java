package helpme_AhnD.ver02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.utils.Define;
import helpme_AhnD.ver02.Frame.GameSelectFrame;
import helpme_AhnD.ver02.Frame.GameSelectFrame_jw;
import helpme_AhnD.ver02.service.BGMService;

public class AhnteacherFrame_modify_jw extends JFrame {

	// 셀프 참조
	AhnteacherFrame_modify_jw mContext;

	// 컴포넌트
	private JLabel startButton;
	private JLabel exitButton;
	private JLabel setting;

	private JLabel backgroundLabel;

	// 서비스 클래스
	private BGMService bgmService;

	public BGMService getBgmService() {
		return bgmService;
	}

	public AhnteacherFrame_modify_jw() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		backgroundLabel = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_BG));
		startButton = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_START));
		exitButton = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_EXIT));
		setting = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_SET));
		mContext = this;
		bgmService = new BGMService();
		setTitle("리듬 게임 시작 화면");
		setSize(1600, 900); // 화면 사이즈
		setContentPane(backgroundLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창을 종료 시 프로그램 전체 종료
	}

	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setVisible(true);

		add(startButton);
		startButton.setSize(368, 124);
		startButton.setLocation(616, 500);

		add(exitButton);
		exitButton.setSize(368, 124);
		exitButton.setLocation(616, 650);

		add(setting);
		setting.setSize(50, 50);
		setting.setLocation(1500, 800);
	}

	private void addEventListener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_F1:
					startButton.setIcon(new ImageIcon(Define.IMG_MAINFRAME_STARTED));
					break;
				case KeyEvent.VK_F2:
					exitButton.setIcon(new ImageIcon(Define.IMG_MAINFRAME_EXITED));
					break;
				case KeyEvent.VK_ESCAPE:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_F1:
					startButton.setIcon(new ImageIcon(Define.IMG_MAINFRAME_START));
					setVisible(false);
					new GameSelectFrame_jw(mContext);
					break;
				case KeyEvent.VK_F2:
					setVisible(false);
					break;
				}
			}
		});
	}

	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_modify_jw();
	}

}