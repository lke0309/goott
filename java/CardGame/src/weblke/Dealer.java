package weblke;

public class Dealer {
	private int dealerNum;
	private Card[] cardList; //카드 목록
	
	
	
	public static final int CARD_COUNT = 13;
	
	
	//생성자
	public Dealer(int dealerNum) {
		this.dealerNum = dealerNum;
		this.cardList= new Card[CARD_COUNT];
	}
	

	
	//System.out.println(dealerNum);
	
	
	// shuffle()//카드를 랜덤하게 섞어서 출력
	
	// pickCard()//플레이어에게 카드를 1장 지급하는 것
}