package helpme_AhnD.ver01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver01.components.ComboBox;
import helpme_AhnD.ver01.components.HpBox;
import helpme_AhnD.ver01.service.Score;

/*
 * 화면 구성 - 제목, 시작, 종료, 설정
 * 이벤트 - 입력 키(키보드, 마우스) 입력 받기
 * 
 * paint (이미지)
 */

public class AhnteacherFrame2 extends JFrame {
	// 선언
	AhnteacherFrame2 mContext = this;
	private Score score;
	// private 이미지
	private JLabel introImage;

	// 생성자
	public AhnteacherFrame2() {

		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		introImage = new JLabel(new ImageIcon("images/testBackground.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(introImage);
		setSize(1600, 900); // 수정

		score = new Score();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();
	}

	private void setInitLayout() {
		setLocationRelativeTo(null); // 창이 정중앙에 위치
		setResizable(false); // 프레임 크기 조절 불가
		setVisible(true); // 화면 출력
	}

	private void addEventListener() { // 키 이벤트
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					score.excellent();
					break;
				case KeyEvent.VK_UP:
					score.great();
					break;
				case KeyEvent.VK_RIGHT:
					score.good();
					break;
				case KeyEvent.VK_DOWN:
					score.bad();
					break;

				default:
					break;
				}
			}
		});
	}

	public Score getScore() {
		return score;
	}
	// 이미지

	// 코드 테스트
	public static void main(String[] args) {
		new AhnteacherFrame2();
	}

}// end of class
