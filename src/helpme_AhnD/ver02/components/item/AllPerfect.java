package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;
import helpme_AhnD.ver02.utils.Define;

public class AllPerfect extends Items implements Useable {

	private ImageIcon itemAllPerfect;
	
	public AllPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemAllPerfect = new ImageIcon(Define.IMG_ITEMS_ALLPERFECT);
	}
	
	private void setInitLayout() {
		setIcon(itemAllPerfect);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 전부  퍼펙트

}
