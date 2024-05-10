package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;

import helpme_AhnD.ver02.components.Note_jw;

public class NoteService_jw extends Thread {

	Note_jw note;

	public NoteService_jw(Note_jw note) {
		this.note = note;
		this.start();
	}

	public void checkLeft() {
		if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 0) {
			System.out.println("왼쪽");
		}
	}

	public void checkUp() {
		if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 1) {
			System.out.println("위");
		}
	}

	public void checkRight() {
		if (note.getY() <= 700 && note.getY() >= 650 && note.getPlace() == 2) {
			System.out.println("오른쪽");
		}
	}

	public void checkDown() {
			System.out.println("아래");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
