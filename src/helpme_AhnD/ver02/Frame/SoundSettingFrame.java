package helpme_AhnD.ver02.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helpme_AhnD.ver02.utils.Define;

public class SoundSettingFrame extends JFrame{

	private JLabel soundBackground;	// 배경
	private JLabel musicButton;		// 음악 재생 버튼
	private JLabel soundVolume;		// 음향
	private JLabel soundLeft;		// 왼쪽 음악 아이콘
	private JLabel soundRight;		// 오른쪽 음악 아이콘
	
	private ImageIcon musicOnImg;
	private ImageIcon musicOffImg;
	private ImageIcon[] volume;
	
	public SoundSettingFrame() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		
		setTitle("음향 조절");
		setSize(368, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // 화면 중앙에 프레임 위치
		
		soundBackground = new JLabel(new ImageIcon("images/sound/soundSetting.png"));
		soundLeft = new JLabel(new ImageIcon("images/sound/soundLeft.png"));
		soundRight = new JLabel(new ImageIcon("images/sound/soundRight.png"));
		musicButton = new JLabel(new ImageIcon("images/sound/soundOn.png"));
		
		volume = new ImageIcon[5];
		volume[0] = new ImageIcon("images/sound/soundFull.png");
		volume[1] = new ImageIcon("images/sound/sound75.png");
		volume[2] = new ImageIcon("images/sound/sound50.png");
		volume[3] = new ImageIcon("images/sound/sound25.png");
		volume[4] = new ImageIcon("images/sound/sound0.png");
		soundVolume = new JLabel(volume[0]);
		
	}
	
	private void setInitLayout() {

		setResizable(false);
		
		add(soundBackground);
		soundBackground.setSize(351, 173);
		soundBackground.setLocation(0, 0);
		
		soundBackground.add(soundLeft);
		soundLeft.setSize(24, 27);
		soundLeft.setLocation(14, 67);
		
		soundBackground.add(soundVolume);
		soundVolume.setSize(268, 39);
		soundVolume.setLocation(40, 60);
		
		soundBackground.add(soundRight);
		soundRight.setSize(29, 26);
		soundRight.setLocation(310, 67);
		
		soundBackground.add(musicButton);
		musicButton.setSize(35, 35);
		musicButton.setLocation(10, 105);
		
		setLayout(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SoundSettingFrame();
	}
	
}
