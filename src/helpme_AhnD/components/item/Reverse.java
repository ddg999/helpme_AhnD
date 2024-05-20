package helpme_AhnD.components.item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.components.DropNote;
import helpme_AhnD.interfaces.Useable;
import helpme_AhnD.service.DropNote_2P_PlayerService;
import helpme_AhnD.service.TryCatch_2P_PlayerService;
import helpme_AhnD.state.Player;
import helpme_AhnD.utils.Define;

public class Reverse extends Items implements Useable {

	private ImageIcon reverse; // 키 반전
	// 키 반전 자체가 영향이 커서 반전 상황을 알려주는 이미지 띄움
	private JLabel reverseImgLabel;  
	private ImageIcon reverseImg;

	public Reverse() {
		initData();
		setInitLayout();
	}

	private void initData() {
		reverse = new ImageIcon(Define.IMG_ITEMS_REVERSE);
		reverseImg = new ImageIcon(Define.IMG_ITEMS_REVERSE_IMG);
		buffType = Items.DEBUFF;
		durationType = Items.DURATION;
	}

	private void setInitLayout() {
		setIcon(reverse);
		setSize(WIDTH, HEIGHT);
		setLocation(X, Y);
	}
	
	@Override
	public void useItems(DropNote_2P_PlayerService dropNotePlayerService) {
		// 디버프 아이템일 경우 상대의 서비스 주소 받아옴
		if (dropNotePlayerService.getPlayer() == Player.LEFTPLAYER) {
			DropNote.setLeftReverse(true);
			reverseImgLabel = new JLabel(reverseImg);
			reverseImgLabel.setSize(220, 198);
			reverseImgLabel.setLocation(220, 500);
		} else {
			DropNote.setRightReverse(true);
			reverseImgLabel = new JLabel(reverseImg);
			reverseImgLabel.setSize(220, 198);
			reverseImgLabel.setLocation(1150, 500);
		}
		dropNotePlayerService.getmContext().add(reverseImgLabel);
		dropNotePlayerService.getmContext().repaint();
		// 지속 시간 이후 효과 제거
		new Thread(() -> {
			try {
				Thread.sleep(Items.DURATION_TIME);
				DropNote.setLeftReverse(false);
				DropNote.setRightReverse(false);
				dropNotePlayerService.getmContext().remove(reverseImgLabel);
				dropNotePlayerService.getmContext().repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	@Override
	public void useItems(TryCatch_2P_PlayerService PlayerService) {
		// 디버프 아이템일 경우 상대의 서비스 주소 받아옴
				if (PlayerService.getPlayer() == Player.LEFTPLAYER) {
					DropNote.setLeftReverse(true);
					reverseImgLabel = new JLabel(reverseImg);
					reverseImgLabel.setSize(220, 198);
					reverseImgLabel.setLocation(220, 500);
				} else {
					DropNote.setRightReverse(true);
					reverseImgLabel = new JLabel(reverseImg);
					reverseImgLabel.setSize(220, 198);
					reverseImgLabel.setLocation(1150, 500);
				}
				PlayerService.getmContext().add(reverseImgLabel);
				PlayerService.getmContext().repaint();
				// 지속 시간 이후 효과 제거
				new Thread(() -> {
					try {
						Thread.sleep(Items.DURATION_TIME);
						DropNote.setLeftReverse(false);
						DropNote.setRightReverse(false);
						PlayerService.getmContext().remove(reverseImgLabel);
						PlayerService.getmContext().repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}).start();
	}
	

}
