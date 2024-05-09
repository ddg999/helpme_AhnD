package helpme_AhnD.ver01.components;

import javax.swing.JLabel;

import helpme_AhnD.ver01.service.PlayerService;

public class ComboBox extends JLabel implements Runnable {

	PlayerService playerService;

	// TODO 1p 2p 콤보박스 좌표설정
//	private int x; 
//	private int y;
	private boolean isRun = true; // 게임 실행중

	public ComboBox(PlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
	}

	public void initData() {
//		x = 100;
//		y = 200;
	}

	public void setInitLayout() {
		setSize(200, 200);
		setLocation(100, 200);
		playerService.getmContext().add(this);
	}

	@Override
	public void run() {
		while (isRun) {
			setText("<html><body text='white'><h2>" + playerService.getScore().getCombo()
					+ " combo</h2></body></html>");
//			// 테스트
//			System.out.print("3점 : " + playerService.getScore().getCountExcellent() + ", ");
//			System.out.print("2점 : " + playerService.getScore().getCountGreat() + ", ");
//			System.out.print("1점 : " + playerService.getScore().getCountGood() + ", ");
//			System.out.print("0점 : " + playerService.getScore().getCountBad() + ", ");
//			System.out.println();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
