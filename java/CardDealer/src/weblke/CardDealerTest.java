package weblke;

public class CardDealerTest {

	public static void main(String[] args) {
		Dealer 주윤발 = new Dealer();
		System.out.println( 주윤발.displayCard());

		
		주윤발.shuffleCard();
		System.out.println( "섞은 후 카드 " + 주윤발.displayCard());
		
		
		
		
		
//		for (int i =0; i< Dealer.CARD_NUM; i ++) {
//			Card c = 주윤발.pickCard();
//			System.out.println((i+1) + "번째 뽑힌 카드: " + c.toString());
//		}
		
		
		for (int i =0; i< Dealer.CARD_NUM; i ++) {
			주윤발.pickCardAndRemoveArray();

		}


		System.out.println( 주윤발.displayCard());
	}

}
