package helpme_AhnD.ver02.service;

import java.util.ArrayList;

public class BGMService {
	private ArrayList<BGM> BGMList;
	private int index;
	private static float volume;
	
	public BGMService() {
		BGMList = new ArrayList<>();
		index = 0;
		volume = -30.0f;
	}
	
	public ArrayList<BGM> getBGMList() {
		return BGMList;
	}
	public static float getVolume() {
		return volume;
	}
	public static void volumeUp() {
		volume++;
	}
	public static void volumDown() {
		volume--;
	}

	public BGM createBGM() {
		BGM temp = new BGM(index);
		BGMList.add(temp);
		index++;
		return temp;
	}
	
}
