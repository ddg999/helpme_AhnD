package helpme_AhnD.ver01.service;

public class ServiceTest_hj {

	public static void main(String[] args) {

		Items items = new Items();
		int hp = 100;
		while (true) {
			hp--;
			if (hp < 50) {
				hp = items.hpPlus(hp);
				break;
			}
		}
		
		System.out.println(hp);
		
		System.out.println("----------------------------------");
		
		// 기존 hp 에서 -10 
		hp = items.hpMinus(hp);
		System.out.println(hp);
		
		System.out.println("----------------------------------");
		
		int score = 150;
		score = items.scoreDouble(score);
		System.out.println(score);
		
	}
	
	
	
	
	
	

}
