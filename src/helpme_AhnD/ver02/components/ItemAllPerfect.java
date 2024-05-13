package helpme_AhnD.ver02.components;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class ItemAllPerfect extends Items implements Useable {

	private ImageIcon itemAllPerfect;
	
	public ItemAllPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemAllPerfect = new ImageIcon("images/allperfect.png");
	}
	
	private void setInitLayout() {
		setIcon(itemAllPerfect);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 전부  퍼펙트

}
