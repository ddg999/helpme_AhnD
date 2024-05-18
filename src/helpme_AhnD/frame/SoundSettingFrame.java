package helpme_AhnD.frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helpme_AhnD.service.*;
import helpme_AhnD.utils.Define;

public class SoundSettingFrame extends JPanel {

	private MainFrame mContext;

	private JLabel soundBackground; // 배경
	private JLabel musicButton; // 음악 재생 버튼
	private JLabel soundLow; // 왼쪽 음악 아이콘
	private JLabel soundHigh; // 오른쪽 음악 아이콘
	private JLabel soundVolume; // 음향

	private ImageIcon[] volume;

	private BGM bgm;
	private boolean isPlay;

	public SoundSettingFrame(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {

		setSize(351, 173);

		soundBackground = new JLabel(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_BG));
		soundLow = new JLabel(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_LOW));
		soundHigh = new JLabel(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_HIGH));
		musicButton = new JLabel(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_MUSICON));

		volume = new ImageIcon[5];
		volume[BGMService.VOLUME_FULL] = new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_VOLUME_FULL);
		volume[BGMService.VOLUME_75] = new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_VOLUME_75);
		volume[BGMService.VOLUME_DEFAULT] = new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_VOLUME_DEFAULT);
		volume[BGMService.VOLUME_25] = new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_VOLUME_25);
		volume[BGMService.VOLUME_NULL] = new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_VOLUME_NULL);
		soundVolume = new JLabel(volume[BGMService.VOLUME_DEFAULT]);

	}

	private void setInitLayout() {

		add(soundBackground);
		soundBackground.setSize(351, 173);
		soundBackground.setLocation(0, 0);

		soundBackground.add(soundLow);
		soundLow.setSize(24, 27);
		soundLow.setLocation(14, 67);

		soundBackground.add(soundVolume);
		soundVolume.setSize(268, 39);
		soundVolume.setLocation(40, 60);

		soundBackground.add(soundHigh);
		soundHigh.setSize(29, 26);
		soundHigh.setLocation(310, 67);

		soundBackground.add(musicButton);
		musicButton.setSize(35, 35);
		musicButton.setLocation(10, 105);

		setLayout(null);
		setVisible(true);
	}

	private void addEventListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 볼륨 조절 창 좌표 확인
				if (70 <= e.getY() && e.getY() <= 90) {
					if (60 <= e.getX() && e.getX() < 95) {
						// 이미지 변경, 소리값 변경
						soundVolume.setIcon(volume[BGMService.VOLUME_NULL]);
						BGMService.setVolumeLevel(BGMService.VOLUME_NULL);
						// 이미 음악이 나오고 있다면 실시간 변경
						if (bgm != null) {
							bgm.getGainControl().setValue(BGMService.getVolume(BGMService.VOLUME_NULL));
						}
					}
					if (95 <= e.getX() && e.getX() < 145) {
						// 이미지 변경, 소리값 변경
						soundVolume.setIcon(volume[BGMService.VOLUME_25]);
						BGMService.setVolumeLevel(BGMService.VOLUME_25);
						// 이미 음악이 나오고 있다면 실시간 변경
						if (bgm != null) {
							bgm.getGainControl().setValue(BGMService.getVolume(BGMService.VOLUME_25));
						}
					}
					if (145 <= e.getX() && e.getX() < 195) {
						// 이미지 변경, 소리값 변경
						soundVolume.setIcon(volume[BGMService.VOLUME_DEFAULT]);
						BGMService.setVolumeLevel(BGMService.VOLUME_DEFAULT);
						// 이미 음악이 나오고 있다면 실시간 변경
						if (bgm != null) {
							bgm.getGainControl().setValue(BGMService.getVolume(BGMService.VOLUME_DEFAULT));
						}
					}
					if (195 <= e.getX() && e.getX() < 245) {
						// 이미지 변경, 소리값 변경
						soundVolume.setIcon(volume[BGMService.VOLUME_75]);
						BGMService.setVolumeLevel(BGMService.VOLUME_75);
						// 이미 음악이 나오고 있다면 실시간 변경
						if (bgm != null) {
							bgm.getGainControl().setValue(BGMService.getVolume(BGMService.VOLUME_75));
						}
					}
					if (245 <= e.getX() && e.getX() < 290) {
						// 이미지 변경, 소리값 변경
						soundVolume.setIcon(volume[BGMService.VOLUME_FULL]);
						BGMService.setVolumeLevel(BGMService.VOLUME_FULL);
						// 이미 음악이 나오고 있다면 실시간 변경
						if (bgm != null) {
							bgm.getGainControl().setValue(BGMService.getVolume(BGMService.VOLUME_FULL));
						}
					}
				}
				// 버튼 누르면 음악 재생, 중지 반복
				if (isMusicButton(e.getX(), e.getY())) {
					if (!isPlay) {
						bgm = mContext.getBgmService().createBGM();
						bgm.getClip().start();
						musicButton.setIcon(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_MUSICOFF));
						isPlay = true;
					} else {
						bgm.getClip().close();
						musicButton.setIcon(new ImageIcon(Define.IMG_SOUNDSETTINGFRAME_MUSICON));
						isPlay = false;
					}
				}
			}
		});
	}

	private boolean isMusicButton(int x, int y) {
		if (15 <= x && x <= 15 + 35 && 110 <= y && y <= 145) {
			return true;
		}
		return false;
	}

	// getter
	public BGM getBgm() {
		return bgm;
	}

}
