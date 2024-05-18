package ver02;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * 화면 구성 - 제목, (버튼(시작, 종료)), 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * 제목 타이틀 이미지 나중에 해결하기 지금은 배경 이미지 
 * 버튼 라벨로 나중에 수정하기 
 * 인터페이스 파일... 
 */
public class AhnteacherFrame extends JFrame {

	// 컨텍스트를 생성하는 방법 (셀프 참조)
	AhnteacherFrame mContext = this; // 대기

	// 버튼
	private JButton startButton;
	private JButton endButton;

	private JLabel backgroundLabel;
	private JPanel titleLabel;

	public AhnteacherFrame() {

		setTitle("리듬 게임 시작 화면");
		setSize(1600, 900); // 화면 사이즈
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 게임 창을 종료 시 프로그램 전체 종료
		setLayout(null);
		initComponents();

		JPanel jPanel = new JPanel();
	}

	private void initComponents() {
		// 배경 이미지 설정
		ImageIcon backgroundImage = new ImageIcon("images/Frame_background.jpg"); // 배경 이미지(임시) 수정 필요!!!!!!
		backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setSize(1600, 900);
		add(backgroundLabel);

		// 제목 이미지를 위한 JLabel 생성
//	       ImageIcon titleIcon = new ImageIcon("img/Titleloge.png");
//	        JLabel titleLabel = new JLabel(titleIcon);
		// 제목 이미지 나중에 하기

		// 시작 버튼 설정
		startButton = new JButton("시작하기");
		startButton.setBounds(700, 500, 200, 50);
		backgroundLabel.add(startButton);

		// 버튼에 액션 추가해서 다음 화면으로 넘어갈 수 있도록 설계
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 메인 게임 화면으로 전환하는 코드 작성
				System.out.println("게임 시작!");

				// 게임 화면으로 전환 (다른 배경)
				GamePanel gamepanel = new GamePanel();
				// 현재 시작 화면 숨기기 -> 다른 화면 띄우기
				setVisible(false);
				dispose();// 시작 화면 자원 해제
			}
		});

		// 종료 버튼 설정
		endButton = new JButton("종료하기");
		endButton.setBounds(700, 600, 200, 50);
		backgroundLabel.add(endButton);
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 설정 버튼 생성 및 위치 설정
		JButton settingsButton = new JButton("설정");
		settingsButton.setBounds(1450, 20, 100, 30); // 위치와 크기 지정
		backgroundLabel.add(settingsButton); // 화면 출력

		// 설정 버튼 이벤트 리스너 추가
		settingsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 설정 창 생성
				createSettingsWindow();
			}

		});
		// 프레임을 화면 중앙에 배치
		setLocationRelativeTo(null);
		setVisible(true);

	}// end

	// 설정 창 메소드
	private void createSettingsWindow() {
		// 설정 창 프레임 생성
		JFrame settingsFrame = new JFrame("설정");
		settingsFrame.setSize(300, 200); //
		settingsFrame.setLayout(new FlowLayout());
		settingsFrame.setLocationRelativeTo(null);

		// 소리 조절을 위한 슬라이더 생성
		JSlider volumeSlider = new JSlider(0, 100, 50);
		volumeSlider.setMajorTickSpacing(10);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(true);

		// 슬라이더 이벤트 리스너 추가
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// 소리 조절 로직
				setVolume(volumeSlider.getValue());
			}
		});

		// 설정 창에 슬라이더 추가
		settingsFrame.add(volumeSlider);
		settingsFrame.setVisible(true);
	}

	// 소리 조절을 위한 메소드
	private void setVolume(int volume) {

		// 실제 오디오 시스템과 연동 시키기 (수정)
	}

	// 코드 테스트
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new AhnteacherFrame().setVisible(true);
			}
		});
	}

}