package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class NeverPerfect extends Items implements Useable{

	private ImageIcon neverPerfect;
	
	public NeverPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		neverPerfect = new ImageIcon(Define.IMG_ITEMS_NEVERPERFECT);
	}
	
	private void setInitLayout() {
		setIcon(neverPerfect);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 퍼펙트 불가
	
}
