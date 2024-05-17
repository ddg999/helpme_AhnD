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
import helpme_AhnD.ver02.state.Player;

public class DeathNotePlayerService implements Runnable {

	DeathNoteFrame mContext;
	DeathNoteRight deathNoteRight;
	DeathNoteLeft deathNoteLeft;
	DeathNoteUp deathNoteUp;
	DeathNoteDown deathNoteDown;
	private DeathNote note;
	private ScoreService score;
	private int player;
	private int delay;

	public DeathNotePlayerService(DeathNoteFrame mContext, int player, Player player2) {
		this.mContext = mContext;
		this.player = player;

		score = new Score(Player.LEFTPLAYER);
	
		new HpBox2(this, player);
		new ScoreBox2(this, player);
		new ComboBox2(this, player);
		switch (player2) {
		case LEFTPLAYER: 
			deathNoteRight = new DeathNoteRight(80, mContext,this);
			deathNoteLeft = new  DeathNoteLeft( 180, mContext,this);
			deathNoteUp = new DeathNoteUp(280, mContext,this);
			deathNoteDown = new  DeathNoteDown( 380 , mContext,this);
			break;
		case RIGHTPLAYER:
			deathNoteRight = new DeathNoteRight(1090, mContext,this);
			deathNoteLeft = new  DeathNoteLeft( 1190, mContext,this);
			deathNoteUp = new DeathNoteUp(1290, mContext,this);
			deathNoteDown = new  DeathNoteDown( 1390 , mContext,this);
		
		default:
			break;
		}
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

	public ScoreService getScore() {
		return score;
	}

}
