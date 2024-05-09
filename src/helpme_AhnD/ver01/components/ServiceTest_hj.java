package helpme_AhnD.ver01.components;

public class ServiceTest_hj {

	public static void main(String[] args) {
		
		Items[] items;
		items = new Items[5];
		
		final int HP_PLUS = 0;
		final int HP_MINUS = 1;
		final int SCREEN_HIDE = 2;
		final int SCORE = 3;
		final int REVERSE = 4;
		
		
		items[HP_PLUS] = new HpPlus();
		items[HP_MINUS] = new HpMinus();
		items[SCREEN_HIDE] = new ScreenHide();
		items[SCORE] = new Score();
		items[REVERSE] = new Reverse();
		
//		HpPlus hpPlus = new HpPlus();
//		HpMinus hpMinus = new HpMinus();
//		ScreenHide screenHide = new ScreenHide();
//		Score score = new Score();
		
		int hp = 100;
		while (true) {
			hp--;
			if (hp < 50) {
				hp = items[HP_PLUS].useItems(hp);
				break;
			}
		}
		System.out.println(hp);
		
		System.out.println("-------------");
		
		hp = items[HP_MINUS].useItems(hp);
		System.out.println(hp);
		
		System.out.println("-------------");
		
		hp = items[SCORE].useItems(hp);
		System.out.println(hp);

	}// end of main
	
	
	
	
	
	

}
