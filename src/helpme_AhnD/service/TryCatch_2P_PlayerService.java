package helpme_AhnD.service;

import helpme_AhnD.components.CatchNote;
import helpme_AhnD.components.ComboBox;
import helpme_AhnD.components.HpBox;
import helpme_AhnD.components.ScoreBox;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.frame.TryCatchFrame_2P;
import helpme_AhnD.state.KeyType;
import helpme_AhnD.state.Player;

public class TryCatch_2P_PlayerService extends PlayerService {

	GameSelectFrame mContext;
	TryCatchFrame_2P gameFrame;
	Player player;

	private Score score;

	public TryCatch_2P_PlayerService(TryCatchFrame_2P gameFrame, Player player) {
		this.gameFrame = gameFrame;
		mContext = gameFrame.mContext;
		this.player = player;

		score = new Score(mContext, player);

		new ComboBox(this, player);
		new ScoreBox(this, player);
		new HpBox(this, player);

		switch (player) {
		case LEFTPLAYER:
			new CatchNote(this, Player.LEFTPLAYER, KeyType.LEFT);
			new CatchNote(this, Player.LEFTPLAYER, KeyType.UP);
			new CatchNote(this, Player.LEFTPLAYER, KeyType.DOWN);
			new CatchNote(this, Player.LEFTPLAYER, KeyType.RIGHT);
			break;
		case RIGHTPLAYER:
			new CatchNote(this, Player.RIGHTPLAYER, KeyType.LEFT);
			new CatchNote(this, Player.RIGHTPLAYER, KeyType.UP);
			new CatchNote(this, Player.RIGHTPLAYER, KeyType.DOWN);
			new CatchNote(this, Player.RIGHTPLAYER, KeyType.RIGHT);
			break;
		default:
			break;
		}
	}

	// getter
	@Override
	public TryCatchFrame_2P getTryCatchFrame_2P() {
		return gameFrame;
	}
	@Override
	public GameSelectFrame getmContext() {
		return mContext;
	}

	@Override
	public Score getScore() {
		return score;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

}
