package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox;
import helpme_AhnD.ver02.components.HpBox;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.components.ScoreBox;

public class PlayerService implements Runnable {

	AhnteacherFrame_jw mContext;
	private Note_jw note;
	private AhnCharacter player;
	private Score score;

	public PlayerService(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ScoreBox(this)).start();
		new Thread(new ComboBox(this)).start();
		new Thread(new HpBox(this)).start();

//		Iterator<Note_jw> iter = noteList.iterator();
//		while (iter.hasNext()) {
//			System.out.println("ID : " + iter.next());
//		}

//		System.out.println(noteList.get(0).getY());

	}

	private void createNote() {
		note = new Note_jw(this);
		new Thread(note).start();

		mContext.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 0) {
						System.out.println("왼쪽");
					}
					break;
				case KeyEvent.VK_UP:
					if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 1) {
						System.out.println("위");
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 2) {
						System.out.println("오른쪽");
					}
					break;
				case KeyEvent.VK_DOWN:
					if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 3) {
						System.out.println("아래");
					}
					break;
				default:
					break;
				}
			}
		});
	}

	@Override
	public void run() {
		while (true) {
			createNote();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public AhnCharacter getPlayer() {
		return player;
	}

	public void setPlayer(AhnCharacter player) {
		this.player = player;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public AhnteacherFrame_jw getmContext() {
		return mContext;
	}

	public void setmContext(AhnteacherFrame_jw mContext) {
		this.mContext = mContext;
	}

	public Note_jw getNote() {
		return note;
	}

	public void setNote(Note_jw note) {
		this.note = note;
	}

}
