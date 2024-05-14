package helpme_AhnD.ver02.components;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import helpme_AhnD.ver01.components.ComboBox;

public class ComboEvent extends JLabel{

	ComboBox comboBox; 
	ImageIcon eventImage;
	
	
	
	public ComboEvent() {
		initLayout();
		setInitLayout();
	}

	public void initLayout() {
		
		eventImage = new ImageIcon(""); 
	}
	
	public void setInitLayout() {
	setLocation(200,0);
	setSize(null);
	
	
	}
	
	public void comboIsReady() {
		
	}
	
	
}
