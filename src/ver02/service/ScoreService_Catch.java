package ver02.service;

import ver02.Frame.DropNoteFrame_2P;
import ver02.Frame.GameEndFrame;
import ver02.state.Player;
import ver02.utils.Define;

public class ScoreService_Catch {

	private DropNoteFrame_2P mContext;
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

	private static boolean isJudged = false; // 중복 종료 방지용 불리언 변수

	// 아이템 사용 확인용 깃발
	private boolean isDouble;
	private boolean isAllPerfect;
	private boolean isNeverPerfect;

	public ScoreService_Catch(DropNoteFrame_2P mContext, Player player) {
		this.mContext = mContext;
		this.player = player;
		hp = Define.HP_3_0_HEART;
	}
	
	// DropNote에서 판정에 따라 호출할 메소드
	public void perfect() {
		if (isDouble) {
			score += 6;
		} else {
			score += 3;
		}
		if (isNeverPerfect) {
			score -= 1;
		}
		combo++;
		// 콤보수가 10의 배수 일때마다 체력 회복
		if (combo % 10 == 0) {
			recovery();
		}
		countPerfect++;
	}

	public void excellent() {
		if (isDouble) {
			score += 4;
		} else {
			score += 2;
		}
		if (isAllPerfect) {
			score += 1;
		}
		combo++;
		// 콤보수가 10의 배수 일때마다 체력 회복
		if (combo % 10 == 0) {
			recovery();
		}
		countExcellent++;
	}

	public void good() {
		if (isDouble) {
			score += 2;
		} else {
			score += 1;
		}
		if (isAllPerfect) {
			score += 2;
		}
		combo++;
		// 콤보수가 10의 배수 일때마다 체력 회복
		if (combo % 10 == 0) {
			recovery();
		}
		countGood++;
	}

	public void bad() {
		// 최대 콤보수 저장
		if (countMaxCombo < combo) {
			countMaxCombo = combo;
		}
		// 콤보 초기화
		combo = 0;
		countBad++;
		beAttacked(); // 게임을 종료시키는 메소드이기 때문에 마지막에 수행
	}

	// 배드 판정시 체력을 깎는 메소드
	// 체력이 0이 되면 게임을 종료 시키는 기능 포함
	public void beAttacked() {
		if (hp >= Define.HP_0_5_HEART) {
			hp -= Define.HP_0_5_HEART;
			if (hp == Define.HP_DEATH) {
				isJudged = true;
				mContext.setVisible(false);
				mContext.setRunning(false);
				mContext.getBgm().getClip().close();
				new GameEndFrame(mContext, player);
			}
		} else {
			hp = Define.HP_DEATH;
		}
	}

	// 체력 회복 메소드
	public void recovery() {
		hp += Define.HP_0_5_HEART;
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
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	public void setAllPerfect(boolean isAllPerfect) {
		this.isAllPerfect = isAllPerfect;
	}

	public void setNeverPerfect(boolean isNeverPerfect) {
		this.isNeverPerfect = isNeverPerfect;
	}

}
