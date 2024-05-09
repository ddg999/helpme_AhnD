package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver02.service.PlayerService;

public class HpBox extends JLabel implements Runnable {

	PlayerService playerService;

	// TODO 1p 2p 체력바 좌표설정
//	private int x; 
//	private int y;
	private boolean isRun = true; // 게임 실행중
	private ImageIcon hp100;
	private ImageIcon hp80;
	private ImageIcon hp60;
	private ImageIcon hp40;
	private ImageIcon hp20;
	private ImageIcon hp0;

	public HpBox(PlayerService playerService) {
		this.playerService = playerService;
		initData();
		setInitLayout();
	}

	public void initData() {
		// 체력표시 파일
		hp100 = new ImageIcon("images/hp/hp100.png");
		hp80 = new ImageIcon("images/hp/hp80.png");
		hp60 = new ImageIcon("images/hp/hp60.png");
		hp40 = new ImageIcon("images/hp/hp40.png");
		hp20 = new ImageIcon("images/hp/hp20.png");
		hp0 = new ImageIcon("images/hp/hp0.png");
//		x = 100;
//		y = 100;
	}

	public void setInitLayout() {
		setIcon(hp100);
		setSize(100, 60);
		setLocation(100, 100);
		playerService.getmContext().add(this);
	}

	@Override
	public void run() {
		while (isRun) {
			if (playerService.getScore().getHp() >= 100) {
				setIcon(hp100);
			} else if (playerService.getScore().getHp() >= 80) {
				setIcon(hp80);
			} else if (playerService.getScore().getHp() >= 60) {
				setIcon(hp60);
			} else if (playerService.getScore().getHp() >= 40) {
				setIcon(hp40);
			} else if (playerService.getScore().getHp() > 0) {
				setIcon(hp20);
			} else if (playerService.getScore().getHp() <= 0) {
				setIcon(hp0);
			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
