package helpme_AhnD.service;

import helpme_AhnD.components.item.ScoreDouble;
import helpme_AhnD.frame.DropNoteFrame_2P;
import helpme_AhnD.frame.GameEndFrame;
import helpme_AhnD.frame.GameSelectFrame;
import helpme_AhnD.state.Player;
import helpme_AhnD.state.ScoreType;
import helpme_AhnD.utils.Define;

public class Score {

	private GameSelectFrame mContext;
	private Player player;
	// 스코어 서비스에서 관리하는 데이터
	private int hp;
	private int score;
	private int combo;
	// 최종화면에 띄울 통계 수집용 변수
	private int countMaxCombo;
	private int countPerfect;
	private int countExcellent;
	private int countGood;
	private int countBad;
	private int countMiss;

	private static boolean isJudged = false; // 중복 종료 방지용 불리언 변수

	// 아이템 사용 확인용 깃발
	private int doubleScore; // 더블이 활성화되면 스코어를 2배로 얻음
	private boolean isAllPerfect;
	private boolean isNeverPerfect;

	public Score(GameSelectFrame mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		hp = Define.HP_3_0_HEART;
		doubleScore = ScoreDouble.DEFAULT;
	}

	public void combo() {
		combo++;
		// 최대 콤보수 저장
		if (countMaxCombo < combo) {
			countMaxCombo = combo;
		}
	}

	// DropNote에서 판정에 따라 호출할 메소드
	public void judgeScore(ScoreType score) {
		if (isAllPerfect) {
			perfect();
			return;
		}
		switch (score) {
		case PERFECT:
			if (isNeverPerfect) {
				excellent();
				break;
			}
			perfect();
			break;
		case EXCELLENT:
			excellent();
			break;
		case GOOD:
			good();
			break;
		case BAD:
			bad();
			break;
		case MISS:
			miss();
			break;
		default:
			break;
		}
	}

	public void perfect() {
		score += 3 * doubleScore;
		combo();
		recovery();
		countPerfect++;
	}

	public void excellent() {
		score += 2 * doubleScore;
		combo();
		recovery();
		countExcellent++;
	}

	public void good() {
		score += 1 * doubleScore;
		combo();
		recovery();
		countGood++;
	}

	public void bad() {
		// 콤보 초기화
		combo = 0;
		countBad++;
		beAttacked(); // 게임을 종료시키는 메소드이기 때문에 마지막에 수행
	}

	public void miss() {
		// 콤보 초기화
		combo = 0;
		countMiss++;
		beAttacked(); // 게임을 종료시키는 메소드이기 때문에 마지막에 수행
	}

	// 배드 판정시 체력을 깎는 메소드
	// 체력이 0이 되면 게임을 종료 시키는 기능 포함
	public void beAttacked() {
		if (hp >= Define.HP_0_5_HEART) {
			hp -= Define.HP_0_5_HEART;
			if (hp == Define.HP_DEATH) {
				isJudged = true;
				GameSelectFrame.setGameRunning(false);
				switch (mContext.getSelectNumber()) {
				case GameSelectFrame.GAMENAME_DROPNOTE_1P:
					mContext.dropNoteFrame_1P.setVisible(false);
					mContext.dropNoteFrame_1P.getBgm().getClip().close();
					new GameEndFrame(mContext, player);
					break;
				case GameSelectFrame.GAMENAME_DROPNOTE_2P:
					mContext.dropNoteFrame_2P.setVisible(false);
					mContext.dropNoteFrame_2P.getBgm().getClip().close();
					new GameEndFrame(mContext, player);
					break;
				case GameSelectFrame.GAMENAME_TRYCATCH_1P:
					break;
				case GameSelectFrame.GAMENAME_TRYCATCH_2P:
					mContext.tryCatchFrame_2P.setVisible(false);
					mContext.tryCatchFrame_2P.getBgm().getClip().close();
					new GameEndFrame(mContext, player);
					break;
				}
			}
		} else {
			hp = Define.HP_DEATH;
		}
	}

	// 체력 회복 메소드
	public void recovery() {
		// 콤보수가 20의 배수 일때마다 체력 회복
		if (combo % 20 == 0) {
			if (hp == Define.HP_3_0_HEART) {
				return;
			}
			hp += Define.HP_0_5_HEART;
		}
	}

	// getter setter
	public int getHp() {
		return hp;
	}

	public int getScore() {
		return score;
	}

	public int getCombo() {
		return combo;
	}

	public int getMaxCombo() {
		return countMaxCombo;
	}

	public int getCountPerfect() {
		return countPerfect;
	}

	public int getCountExcellent() {
		return countExcellent;
	}

	public int getCountGood() {
		return countGood;
	}

	public int getCountBad() {
		return countBad;
	}

	public int getCountMiss() {
		return countMiss;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDouble(int doubleScore) {
		this.doubleScore = doubleScore;
	}

	public void setAllPerfect(boolean isAllPerfect) {
		this.isAllPerfect = isAllPerfect;
	}

	public void setNeverPerfect(boolean isNeverPerfect) {
		this.isNeverPerfect = isNeverPerfect;
	}

}
