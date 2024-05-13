package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.Frame.TestGameFrame_kh;
import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox_kh;
import helpme_AhnD.ver02.components.HpBox_kh;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.components.Note_kh;
import helpme_AhnD.ver02.components.ScoreBox_kh;
import helpme_AhnD.ver02.components.TestFrame;

public class PlayerService_js implements Runnable {

	TestFrame mContext;
	private Note_kh note;
	private AhnCharacter player;
	private Score score;

	public PlayerService_js(TestFrame testFrame) {
		this.mContext = testFrame;
		player = new AhnCharacter();
		score = new Score();
	
	}

	

	public TestFrame getmContext() {
		return mContext;
	}

	public Score getScore() {
		return score;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}