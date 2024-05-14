package helpme_AhnD.ver02.components;

import helpme_AhnD.ver02.components.item.Bomb;
import helpme_AhnD.ver02.components.item.HpMinus;
import helpme_AhnD.ver02.components.item.HpPlus;
import helpme_AhnD.ver02.components.item.Reverse;
import helpme_AhnD.ver02.components.item.ScoreDouble;
import helpme_AhnD.ver02.components.item.Items;

public class ServiceTest_hj {

	public static void main(String[] args) {
		
		Items[] items;
		items = new Items[5];
		
		final int HP_PLUS = 0;
		final int HP_MINUS = 1;
		final int SCREEN_HIDE = 2;
		final int SCOREDOUBLE = 3;
		final int REVERSE = 4;
		
		
		items[HP_PLUS] = new HpPlus();
		items[HP_MINUS] = new HpMinus();
		items[SCREEN_HIDE] = new Bomb();
		items[SCOREDOUBLE] = new ScoreDouble();
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
		
		hp = items[SCOREDOUBLE].useItems(hp);
		System.out.println(hp);

	}// end of main
	
	
	
	
	
	

}
