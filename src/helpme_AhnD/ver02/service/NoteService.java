package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;

import helpme_AhnD.ver02.Frame.DropNoteFrame;
import helpme_AhnD.ver02.components.Note;
import helpme_AhnD.ver02.components.NoteCircle;

public class NoteService extends Thread{
	// 박자를 맞추기 위해 Thread.sleep에 입력해줄 값 음표 기준
	private final int HALF_MS = 851;
	private final int HALF_NS = 638;
	private final int QUATER_MS = 425;
	private final int QUATER_NS = 5320;
	private final int EIGHTH_MS = 212;
	private final int EIGHTH_NS = 7659;
	private boolean isRun; // 게임이 실행중인지 확인
	private boolean isUpPressed;
	private boolean isLeftPressed;
	private boolean isRightPressed;
	private boolean isDownPressed;
	private DropNoteFrame mContext;
	public NoteService(DropNoteFrame mContext) {
		this.mContext = mContext;
		isRun = true;
		this.start();
	}
	
	@Override
	public void run() {
		while (isRun) {
			try {
				// Thread.sleep(8000);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(QUATER_MS, QUATER_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(QUATER_MS, QUATER_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(EIGHTH_MS, EIGHTH_NS);
//				createNote();
//				Thread.sleep(HALF_MS, HALF_NS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//break;
		}
	}
	
	private void notePressed(int getCode) {
		switch (getCode) {
		case KeyEvent.VK_UP :
			isUpPressed = true;
			break;
		case KeyEvent.VK_LEFT :
			isLeftPressed = true;
			break;
		case KeyEvent.VK_RIGHT :
			isRightPressed = true;
			break;
		case KeyEvent.VK_DOWN :
			isDownPressed = true;
			break;
		}
	}
	
//	private void createNote() {
//		Note leftNote = new Note(Note.LEFT_PLAYER, mContext);
//		NoteCircle leftCircle = new NoteCircle(leftNote);
//		mContext.add(leftNote);
//		mContext.add(leftCircle);
//		Note rightNote = new Note(Note.RIGHT_PLAYER, mContext);
//		NoteCircle rightCircle = new NoteCircle(rightNote);
//		mContext.add(rightNote);
//		mContext.add(rightCircle);
//		mContext.repaint();
//	}
	
}
