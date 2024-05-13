package helpme_AhnD.ver02.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.DeathNoteCircle;



public class TestFrame extends JFrame {
	private static AhnCharacter ahnCharacter;
	static DeathNote deathNote;
	static DeathNote deathNote2;
	static DeathNote deathNote3;
	static DeathNote deathNote4;
	

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
		deathNote = new DeathNote(null, 80, this);
		deathNote2 = new DeathNote(null, 180, this);
		deathNote3 = new DeathNote(null, 280, this);
		deathNote4 = new DeathNote(null, 380, this);
		//new DeathNoteCircle();
	}
	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 여러분 모니터 가운데 자동 배치
		setVisible(true);

		add(ahnCharacter);
		add(deathNote);
		add(deathNote2);
		add(deathNote3);
		add(deathNote4);

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
				
				case KeyEvent.VK_UP: 
					ahnCharacter.playerScore = 1;
					break;
				case KeyEvent.VK_LEFT: 
					ahnCharacter.playerScore = 1;
					break;
				case KeyEvent.VK_DOWN: 
					ahnCharacter.playerScore = 1;
					break;
				case KeyEvent.VK_RIGHT: 
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
