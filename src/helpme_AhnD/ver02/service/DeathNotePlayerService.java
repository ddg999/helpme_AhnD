package helpme_AhnD.ver02.service;

import java.util.Random;

import helpme_AhnD.ver02.Frame.DeathNoteFrame;
import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.ComboBox2;
import helpme_AhnD.ver02.components.DeathNote;
import helpme_AhnD.ver02.components.DeathNoteDown;
import helpme_AhnD.ver02.components.DeathNoteLeft;
import helpme_AhnD.ver02.components.DeathNoteRight;
import helpme_AhnD.ver02.components.DeathNoteUp;
import helpme_AhnD.ver02.components.DropNote;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.HpBox2;
import helpme_AhnD.ver02.components.ItemBox;
import helpme_AhnD.ver02.components.ScoreBox;
import helpme_AhnD.ver02.components.ScoreBox2;

public class DeathNotePlayerService implements Runnable {

	DeathNoteFrame mContext;
	DeathNoteRight deathNoteRight;
	DeathNoteLeft deathNoteLeft;
	DeathNoteUp deathNoteUp;
	DeathNoteDown deathNoteDown;
	private DeathNote note;
	private Score score;
	private int player;
	private int delay;

	public DeathNotePlayerService(DeathNoteFrame mContext, int player) {
		this.mContext = mContext;
		this.player = player;
		score = new Score(player);
		new HpBox2(this, player);
		new ScoreBox2(this, player);
		new ComboBox2(this, player);
		deathNoteRight = new DeathNoteRight(80, mContext,this);
		deathNoteLeft = new  DeathNoteLeft( 180, mContext,this);
		deathNoteUp = new DeathNoteUp(280, mContext,this);
		deathNoteDown = new  DeathNoteDown( 380 , mContext,this);
		
	}

	private void createNote() {
		
		new Thread(deathNoteRight).start();
		new Thread(deathNoteLeft).start();
		new Thread(deathNoteUp).start();
		new Thread(deathNoteDown).start();
	}

	@Override
	public void run() {
	}

	
	// getter
	public DeathNoteFrame getmContext() {
		return mContext;
	}

	public Score getScore() {
		return score;
	}

}
