package helpme_AhnD.ver02.service;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class BGM {
	private Clip clip; // 시작 정지 종료용 변수
	private int number;
	private FloatControl gainControl; // 볼륨 조절용 변수
	
	public int getNumber() {
		return number;
	}

	public Clip getClip() {
		return clip;
	}
	
	public FloatControl getGainControl() {
		return gainControl;
	}


	public BGM(int number) {
		try {
			this.number = number;
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound/slamdunk.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
			
			// 소리 설정
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			// 볼륨 조정
			gainControl.setValue(BGMService.getVolume());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
