package helpme_AhnD.ver01.service;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class BGM {
	Clip clip;
	FloatControl gainControl;
	public BGM() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound/slamdunk.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);
			
			// 소리 설정
			gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			
			// 볼륨 조정
			gainControl.setValue(-30.0f);
			System.out.println(clip.getFrameLength());
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
