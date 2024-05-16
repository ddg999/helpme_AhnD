package helpme_AhnD.ver02.service;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class BGM {
	// 음악 재생에 대한 이해도가 높지 않아서 새로 재생 될때마다 새로운 객체를 생성 시키는 방법 사용
	private int index; // 생성된 객체를 구분 하기위한 정수값으로 index 사용
	private Clip clip; // 시작 정지 종료용 변수
	/**
	 *  시작 : clip.start();
	 *  정지 : clip.stop(); 다시 start();하면 정지된 위치에서 재생됨
	 *  종료 : clip.close();
	 */
	private FloatControl gainControl; // 볼륨 조절용 변수
	public static final int END_TIME = 172000; // 2분 52초

	public BGM(int index) {
		try {
			this.index = index;
			AudioInputStream ais = AudioSystem
					.getAudioInputStream(new File("sound/slamdunk.wav"));
			clip = AudioSystem.getClip();
			clip.open(ais);

			// 소리 설정
			gainControl = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);

			// 볼륨 조정
			gainControl.setValue(BGMService.getVolume(BGMService.VOLUME_DEFAULT));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// getter
	public int getNumber() {
		return index;
	}

	public Clip getClip() {
		return clip;
	}

	public FloatControl getGainControl() {
		return gainControl;
	}
}
