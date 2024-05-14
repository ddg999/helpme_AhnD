package helpme_AhnD.ver02.components.item;

import javax.swing.ImageIcon;

import helpme_AhnD.ver02.interfaces.Useable;

public class NeverPerfect extends Items implements Useable{

	private ImageIcon itemNotPerfect;
	
	public NeverPerfect() {
		initData();
		setInitLayout();
	}

	private void initData() {
		itemNotPerfect = new ImageIcon("images/allperfect.png");
	}
	
	private void setInitLayout() {
		setIcon(itemNotPerfect);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	// todo 전부 퍼펙트 아님
	
}
