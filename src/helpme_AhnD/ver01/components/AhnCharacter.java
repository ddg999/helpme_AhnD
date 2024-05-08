package helpme_AhnD.ver01.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AhnCharacter extends JLabel {
	
	//  todo Score int  값 땡겨오기

	private ImageIcon basicCharacter, highScore_Left, highScore_Right;
	// 이미지 추가
	private int x; // 위치 값
	private int y; // 위치 값
	private int playerScore; // 점수 todo 점수 연결 
	private boolean gameStart ;
	private boolean perfect = true ;
	
	// todo score 불러 오기

	public AhnCharacter() {
		initData();
		setInitLayout();

	}

	private void initData() {
		basicCharacter = new ImageIcon("images/basicCharacter.png");
		x = 308;
		y = 300;
	}

	private void setInitLayout() {
		setIcon(basicCharacter);
		setSize(261,500 );
		setLocation(x, y);
	}
	
	// 점수에 따라 이미지 변경 todo 이미지 추가 하기
	private void playerScoreImage (int playerScore) {
		
		new Thread(() -> {
		while(gameStart) {
			switch (playerScore) {
			case 3: {
				while(true) {
					if(playerScore == 3) {
						if(perfect) {
							
						}else {
							
						}
						perfect = ! perfect;
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					break;
				}
			}
			case 2: {
				while(true) {
					if(playerScore == 3) {
						if(perfect) {
							
						}else {
							
						}
						perfect = ! perfect;
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					break;
				}
			}
			case 1: {
				while(true) {
					if(playerScore == 3) {
						if(perfect) {
							
						}else {
							
						}
						perfect = ! perfect;
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					break;
				}
			}
			
			default:
				
				while(true) {
					if(playerScore == 3) {
						if(perfect) {
							
						}else {
							
						}
						perfect = ! perfect;
						try {
							Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
					break;
				}
				
			}
		
			
		}
		}).start();
		
	}

} // end of class
