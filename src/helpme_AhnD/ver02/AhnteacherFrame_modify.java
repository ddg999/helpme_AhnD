package helpme_AhnD.ver02;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.Frame.GameSelectPanel;

public class AhnteacherFrame_modify extends JFrame {

	// 컴포넌트
	private JLabel startButton;
	private JLabel exitButton;
	private JLabel setting;
	
	private JLabel backgroundLabel;

	public AhnteacherFrame_modify() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundLabel = new JLabel(new ImageIcon("images/mainFrame/bg.jpg"));
		startButton = new JLabel(new ImageIcon("images/mainFrame/buttonStart.png"));
		exitButton = new JLabel(new ImageIcon("images/mainFrame/buttonExit.png"));
		setting = new JLabel(new ImageIcon("images/mainFrame/set1.png"));
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
				switch(e.getKeyCode()) {
					case KeyEvent.VK_F1 :
						startButton.setIcon(new ImageIcon("images/mainFrame/started3.png"));
						break;
					case KeyEvent.VK_F2 :
						exitButton.setIcon(new ImageIcon("images/mainFrame/exited3.png"));
						break;
					case KeyEvent.VK_ESCAPE :
						break;
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_F1 :
						setVisible(false);
						new GameSelectPanel();
						break;
					case KeyEvent.VK_F2 :
						setVisible(false);
						break;
				}
			}
		});
	}
	
	
	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_modify();
	}

}