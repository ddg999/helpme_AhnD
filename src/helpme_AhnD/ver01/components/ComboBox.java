package helpme_AhnD.ver01.components;

import javax.swing.JLabel;

import helpme_AhnD.ver01.AhnteacherFrame2;

public class ComboBox extends JLabel implements Runnable {

	AhnteacherFrame2 mContext;
	
	// TODO 1p 2p 콤보박스 좌표설정
//	private int x; 
//	private int y;
	private boolean isRun = true; // 게임 실행중

	public ComboBox(AhnteacherFrame2 mContext) {
		this.mContext = mContext;
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
		mContext.add(this);
	}

	@Override
	public void run() {
		while (isRun) {
			setText("<html><body text='white'><h2>" + mContext.getScore().getCombo() + " combo</h2></body></html>");
			// 테스트
			System.out.print("3점 : " + mContext.getScore().getCountExcellent() + ", ");
			System.out.print("2점 : " + mContext.getScore().getCountGreat() + ", ");
			System.out.print("1점 : " + mContext.getScore().getCountGood() + ", ");
			System.out.print("0점 : " + mContext.getScore().getCountBad() + ", ");
			System.out.println();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
