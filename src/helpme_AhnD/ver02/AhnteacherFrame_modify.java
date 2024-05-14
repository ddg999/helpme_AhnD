package helpme_AhnD.ver02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.utils.Define;
import helpme_AhnD.ver02.Frame.GameSelectFrame;
import helpme_AhnD.ver02.service.BGMService;

public class AhnteacherFrame_modify extends JFrame {

	// 셀프 참조
	AhnteacherFrame_modify mContext;

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

	public AhnteacherFrame_modify() {
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (isStartButton(e.getX(), e.getY())) {
					startButton.setIcon(
							new ImageIcon(Define.IMG_MAINFRAME_STARTED));
				} else if (isExitButton(e.getX(), e.getY())) {
					exitButton.setIcon(
							new ImageIcon(Define.IMG_MAINFRAME_EXITED));
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (isStartButton(e.getX(), e.getY())) {
					startButton
							.setIcon(new ImageIcon(Define.IMG_MAINFRAME_START));
					setVisible(false);
					new GameSelectFrame(mContext);
				} else if (isExitButton(e.getX(), e.getY())) {
					setVisible(false);
				}
			}
		});

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_S :
						startButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_STARTED));
						break;
					case KeyEvent.VK_ESCAPE :
						exitButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_EXITED));
						break;
					case KeyEvent.VK_CONTROL :
						break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_S :
						startButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_START));
						setVisible(false);
						new GameSelectFrame(mContext);
						break;
					case KeyEvent.VK_ESCAPE :
						setVisible(false);
						break;
				}
			}
		});
	}

	public boolean isStartButton(int x, int y) {
		if (616 <= x && x <= 984 && 500 <= y && y <= 624) {
			return true;
		}
		return false;
	}

	public boolean isExitButton(int x, int y) {
		if (616 <= x && x <= 984 && 650 <= y && y <= 774) {
			return true;
		}
		return false;
	}

	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_modify();
	}

}