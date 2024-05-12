package helpme_AhnD.ver02.Frame;

import javax.swing.JFrame;

public class FirstGameFrame extends JFrame{
	
	public FirstGameFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		// todo 각종 라벨 추가 예정
		
		setTitle("첫번째 게임");
		setSize(1600, 900);
		setContentPane(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setInitLayout() {
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		setVisible(true);
		
		// todo 각종 컴포넌트 add
	}
	private void addEventListener() {
		
	}
}
