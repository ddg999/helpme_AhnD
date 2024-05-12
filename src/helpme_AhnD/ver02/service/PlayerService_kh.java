package helpme_AhnD.ver02.service;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import helpme_AhnD.ver02.AhnteacherFrame_jw;
import helpme_AhnD.ver02.Frame.TestGameFrame_kh;
import helpme_AhnD.ver02.components.AhnCharacter;
import helpme_AhnD.ver02.components.ComboBox_kh;
import helpme_AhnD.ver02.components.HpBox_kh;
import helpme_AhnD.ver02.components.Note_jw;
import helpme_AhnD.ver02.components.Note_kh;
import helpme_AhnD.ver02.components.ScoreBox_kh;

public class PlayerService_kh implements Runnable {

	TestGameFrame_kh mContext;
	private Note_kh note;
	private AhnCharacter player;
	private Score score;

	public PlayerService_kh(TestGameFrame_kh mContext) {
		this.mContext = mContext;
		player = new AhnCharacter();
		score = new Score();
		new Thread(new ScoreBox_kh(this)).start();
		new Thread(new ComboBox_kh(this)).start();
		new Thread(new HpBox_kh(this)).start();

	}

	private void createNote() {
		note = new Note_kh(this);
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

	public TestGameFrame_kh getmContext() {
		return mContext;
	}

	public Score getScore() {
		return score;
	}
	
	
}
