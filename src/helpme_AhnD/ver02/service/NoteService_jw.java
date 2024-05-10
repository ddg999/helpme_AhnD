package helpme_AhnD.ver02.service;

import helpme_AhnD.ver02.components.Note_jw;

public class NoteService_jw implements Runnable {

	Note_jw note;

	public NoteService_jw(Note_jw note) {
		this.note = note;
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
