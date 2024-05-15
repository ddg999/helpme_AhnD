package helpme_AhnD.ver02.service;

import java.util.ArrayList;

public class BGMService {
	private ArrayList<BGM> BGMList; // BGM이 얼마나 생성될지 모르기 때문에 ArrayList에 담음
	private int index; // BGM count 정수
	// 소리 조절 옵션
	public static final int VOLUME_FULL = 4;// -10.0f;
	public static final int VOLUME_75 = 3;// -20.0f;
	public static final int VOLUME_DEFAULT = 2;// -30.0f;
	public static final int VOLUME_25 = 1;// -40.0f;
	public static final int VOLUME_NULL = 0;// -80.0f;
	private static int volumeLevel = VOLUME_DEFAULT;
	// 외부에서 볼륨을 조정하기 위해 static 으로 선언
	private static float[] volume = { -80.0f, -40.0f, -30.0f, -20.0f, -10.0f };
	
	
	public BGMService() {
		BGMList = new ArrayList<>();
		index = 0;
	}

	// BGM 생성 후 접근할 수 있는 주소 반환
	public BGM createBGM() {
		BGM newBGM = new BGM(index++);
		BGMList.add(newBGM);
		return newBGM;
	}


	public static void volumeUp() {
		if (volumeLevel == VOLUME_FULL) {
			return;
		}
		volumeLevel++;
	}

	public static void volumDown() {
		if (volumeLevel == VOLUME_NULL) {
			return;
		}
		volumeLevel--;
	}
	// getter setter
	public ArrayList<BGM> getBGMList() {
		return BGMList;
	}
	
	public static float getVolume(int volumLevel) {
		return volume[volumeLevel];
	}

	public static void setVolumeLevel(int volumeLevel) {
		BGMService.volumeLevel = volumeLevel;
	}
	

}
