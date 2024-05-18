package ver02.Frame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ver02.service.BGMService;
import ver02.utils.Define;

public class MainFrame_hj extends JFrame {

	// 셀프 참조
	MainFrame_hj mContext; // 다른 화면에서 호출 setVisiable()을 호출 시키기 위함

	// 컴포넌트
	private JLabel startButton;
	private JLabel exitButton;
	private JLabel setting;
	private final int BUTTON_WIDTH = 357;
	private final int BUTTON_HEIGHT = 113;
	
	// 백그라운드 이미지
	private JLabel background;
	public static final int FRAME_WIDTH = 1600;
	public static final int FRAME_HEIGHT = 900;
	
	// 서비스 클래스
	private BGMService bgmService; // bgm을 관리하는 클래스
	
	// 소리 설정 창
	private SoundSettingFrame soundSettingFrame;
	private boolean isSoundSettingFrameOpen;

	public MainFrame_hj() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		// 라벨 생성과 동시에 이미지 삽입
		background = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_BG));
		startButton = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_START));
		exitButton = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_EXIT));
		setting = new JLabel(new ImageIcon(Define.IMG_MAINFRAME_SET));
		// 셀프 참조
		mContext = this;
		// bgm 관리
		bgmService = new BGMService();
		// 사운드 설정 창 생성
		// soundSettingFrame = new SoundSettingFrame(mContext);
		setTitle("도와줘요 안선생님!!");
		setSize(FRAME_WIDTH, FRAME_HEIGHT); // 화면 사이즈
		setContentPane(background);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창을 종료 시 프로그램 전체 종료
	}
	private void setInitLayout() {
		setLayout(null); // 좌표기반 레이아웃
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setVisible(true); // 화면에 보이기
		
		// 컴포넌트 add
		add(startButton);
		startButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		startButton.setLocation(616, 500);

		add(exitButton);
		exitButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		exitButton.setLocation(616, 650);

		add(setting);
		setting.setSize(50, 50);
		setting.setLocation(1500, 800);
		
	}
	
	// 상호작용 종류
	// 1. 게임시작 2. 게임 종료 3. 설정 창 띄우기
	private void addEventListener() {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_S :
						// 눌렀을 때는 이미지 변경만
						startButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_STARTED));
						break;
					case KeyEvent.VK_ESCAPE :
						// 눌렀을 때는 이미지 변경만
						exitButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_EXITED));
						break;
					case KeyEvent.VK_CONTROL :
						if(!isSoundSettingFrameOpen) {
							add(soundSettingFrame);
							soundSettingFrame.setSize(351, 173);
							soundSettingFrame.setLocation(1200, 620);
							soundSettingFrame.setVisible(true);
							isSoundSettingFrameOpen = true;
						} else {
							soundSettingFrame.setVisible(false);
							isSoundSettingFrameOpen = false;
						}
						break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_S :
						startButton.setIcon(
								new ImageIcon(Define.IMG_MAINFRAME_START));
						setVisible(false); // 현재 화면 안보이게
						new GameSelectFrame_hj(mContext); // 게임 선택화면 호출
						break;
					case KeyEvent.VK_ESCAPE :
						setVisible(false); // 종료
						break;
				}
			}
		});
		// 키보드와 내용 동일
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (isStartButton(e.getX(), e.getY())) {
					// 눌렀을 때는 이미지 변경만
					startButton.setIcon(
							new ImageIcon(Define.IMG_MAINFRAME_STARTED));
				} else if (isExitButton(e.getX(), e.getY())) {
					// 눌렀을 때는 이미지 변경만
					exitButton.setIcon(
							new ImageIcon(Define.IMG_MAINFRAME_EXITED));
				} else if (isSettingButton(e.getX(), e.getY())) {
					
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (isStartButton(e.getX(), e.getY())) {
					startButton
							.setIcon(new ImageIcon(Define.IMG_MAINFRAME_START));
					setVisible(false); // 현재 화면 안보이게
					new GameSelectFrame_hj(mContext); // 게임 선택화면 호출
				} else if (isExitButton(e.getX(), e.getY())) {
					setVisible(false); // 종료
				}
			}
		});
	}
	// 마우스 입력 위치가 버튼과 맞는지 확인
	public boolean isStartButton(int x, int y) {
		if (625 <= x && x <= 625 + BUTTON_WIDTH && 530 <= y && y <= 530 + BUTTON_HEIGHT) {
			return true;
		}
		return false;
	}

	public boolean isExitButton(int x, int y) {
		if (625 <= x && x <= 625 + BUTTON_WIDTH && 685 <= y && y <= 685 + BUTTON_HEIGHT) {
			return true;
		}
		return false;
	}
	public boolean isSettingButton(int x, int y) {
		if (1510 <= x && x <= 1510 + 50 && 835 <= y && y <= 835 + 50) {
			return true;
		}
		return false;
	}
	
	// getter
	public BGMService getBgmService() {
		return bgmService;
	}
	
	public static void main(String[] args) {
		
		new MainFrame_hj();
		
	}// end of main
}