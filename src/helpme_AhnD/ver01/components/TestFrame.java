package helpme_AhnD.ver01.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class TestFrame extends JFrame {
	private static AhnCharacter ahnCharacter;

	public TestFrame() {
		initData();
		setInitLayout();
		addEventListener();
		ahnCharacter.playerScoreImage();
	}
	
	
	private void initData() {

		// todo 배경 이미지 삽입
		
		
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ahnCharacter = new AhnCharacter();
		
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(ahnCharacter);

	}
	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_3 : 
					ahnCharacter.playerScore = 3;
					System.out.println("3");
					break;
				
				case KeyEvent.VK_2: 
					ahnCharacter.playerScore = 2;
					System.out.println("2");
					break;
				
				case KeyEvent.VK_1: 
					ahnCharacter.playerScore = 1;
					break;
				
				default:
				}
			}
		});
	}
	public static void main(String[] args) {
		new TestFrame();
	}
}
