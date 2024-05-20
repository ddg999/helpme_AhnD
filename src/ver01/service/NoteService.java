package ver01.service;

import java.awt.event.KeyEvent;

import ver01.TestFramekh;
import ver01.components.Note;
import ver01.components.NoteCircle;

public class NoteService extends Thread {
	// 박자를 맞추기 위해 Thread.sleep에 입력해줄 값 음표 기준
	private final int HALF_MS = 851; // 2분음표
	private final int HALF_NS = 638; // 나노초
	private final int QUATER_MS = 425; // 4분음표
	private final int QUATER_NS = 5320; // 나노초
	private final int EIGHTH_MS = 212; // 8분음표
	private final int EIGHTH_NS = 7659; // 나노초
	private boolean isRun; // 게임이 실행중인지 확인
	private boolean isUpPressed;
	private boolean isLeftPressed;
	private boolean isRightPressed;
	private boolean isDownPressed;
	private TestFramekh mContext;

	public NoteService(TestFramekh mContext) {
		this.mContext = mContext;
		isRun = true;
		this.start();
	}

	@Override
	public void run() {
		while (isRun) {
			try {
				// Thread.sleep(8000);
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote(); 
				Thread.sleep(QUATER_MS, QUATER_NS); // 4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS); // 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분 // 1소절 끝
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분 // 2소절 끝
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분 // 3소절 끝
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분 
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분 
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분 // 4소절
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(HALF_MS, HALF_NS); // 2분 // 5소절 
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(QUATER_MS, QUATER_NS); //4분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				createNote();
				Thread.sleep(EIGHTH_MS, EIGHTH_NS);// 8분
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// break;
		}
	}

	private void notePressed(int getCode) {
		switch (getCode) {
		case KeyEvent.VK_UP:
			isUpPressed = true;
			break;
		case KeyEvent.VK_LEFT:
			isLeftPressed = true;
			break;
		case KeyEvent.VK_RIGHT:
			isRightPressed = true;
			break;
		case KeyEvent.VK_DOWN:
			isDownPressed = true;
			break;
		}
	}

	private void createNote() {
		Note leftNote = new Note(Note.LEFT_PLAYER, mContext);
		NoteCircle leftCircle = new NoteCircle(leftNote);
		mContext.add(leftNote);
		mContext.add(leftCircle);
		Note rightNote = new Note(Note.RIGHT_PLAYER, mContext);
		NoteCircle rightCircle = new NoteCircle(rightNote);
		mContext.add(rightNote);
		mContext.add(rightCircle);
		mContext.repaint();
	}

}
