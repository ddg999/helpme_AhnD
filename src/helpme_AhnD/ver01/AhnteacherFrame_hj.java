package helpme_AhnD.ver01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

<<<<<<< HEAD:src/helpme_AhnD/ver01/AhnteacherFrame_hj.java
import helpme_AhnD.ver01.components.HpPlus;
import helpme_AhnD.ver01.components.Items;
import helpme_AhnD.ver01.components.ScreenHide;
=======
import helpme_AhnD.ver01.components.ComboBox;
import helpme_AhnD.ver01.components.HpBox;
import helpme_AhnD.ver01.service.PlayerService;
import helpme_AhnD.ver01.service.Score;
>>>>>>> f0eff67907d5cec174004b051e958feb51b40536:src/helpme_AhnD/ver01/AhnteacherFrame2.java

/*
 * 화면 구성 - 제목, 시작, 종료, 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame_hj extends JFrame {
	// 선언
	AhnteacherFrame2 mContext = this;
	private boolean isRun = true; // 게임 실행중
	private PlayerService playerService;
	// private 이미지
	private JLabel introImage;

	// 생성자
<<<<<<< HEAD:src/helpme_AhnD/ver01/AhnteacherFrame_hj.java
	public AhnteacherFrame_hj() {
		
=======
	public AhnteacherFrame2() {
>>>>>>> f0eff67907d5cec174004b051e958feb51b40536:src/helpme_AhnD/ver01/AhnteacherFrame2.java
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		introImage = new JLabel(new ImageIcon("images/Frame_background.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD:src/helpme_AhnD/ver01/AhnteacherFrame_hj.java
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		introImage = new JLabel(new ImageIcon());
=======
		setContentPane(introImage);
		setSize(1600, 900); // 수정

		playerService = new PlayerService(this);
		new Thread(playerService).start();
>>>>>>> f0eff67907d5cec174004b051e958feb51b40536:src/helpme_AhnD/ver01/AhnteacherFrame2.java
	}

	private void setInitLayout() {
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		setResizable(false); // 프레임 크기 조절 불가
<<<<<<< HEAD:src/helpme_AhnD/ver01/AhnteacherFrame_hj.java
		add(new ScreenHide());
=======
>>>>>>> f0eff67907d5cec174004b051e958feb51b40536:src/helpme_AhnD/ver01/AhnteacherFrame2.java
		setVisible(true); // 화면 출력
	}

	private void addEventListener() { // 키 이벤트
<<<<<<< HEAD:src/helpme_AhnD/ver01/AhnteacherFrame_hj.java
		
		// 마우스
		
		
		
		
		// 키보드
		
		
	
		
		
=======
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (isRun) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						playerService.getScore().excellent();
						break;
					case KeyEvent.VK_UP:
						playerService.getScore().great();
						break;
					case KeyEvent.VK_RIGHT:
						playerService.getScore().good();
						break;
					case KeyEvent.VK_DOWN:
						playerService.getScore().bad();
						break;

					default:
						break;
					}
				}
			}
		});
>>>>>>> f0eff67907d5cec174004b051e958feb51b40536:src/helpme_AhnD/ver01/AhnteacherFrame2.java
	}

	// 이미지

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame_hj();
	}

}// end of class
