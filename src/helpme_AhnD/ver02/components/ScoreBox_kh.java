package helpme_AhnD.ver02.components;

import javax.swing.JLabel;

import helpme_AhnD.ver02.service.PlayerService_kh;

public class ScoreBox_kh extends JLabel implements Runnable {

	PlayerService_kh playerService;

	// TODO 1p 2p 콤보박스 좌표설정
//	private int x;
//	private int y;
	private boolean isRun = true; // 게임 실행중

	public ScoreBox_kh(PlayerService_kh playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
	}

	public void initData() {
//		x = 100;
//		y = 200;
	}

	public void setInitLayout() {
		setSize(100, 100);
		setLocation(100, 250);
		playerService.getmContext().add(this);
	}

	@Override
	public void run() {
		while (isRun) {
			setText("<html><body text='white'><h2>" + playerService.getScore().getScore() + " 점</h2></body></html>");
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
