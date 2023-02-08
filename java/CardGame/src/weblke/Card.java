package weblke;

public class Card {
	private String cardSuits; //카드 문양
	private int cardNum; //카드 넘버
	
	
	
	
	//생성자
	public Card(String cardSuits, int cardNum) {
		this.cardSuits = cardSuits;
		this.cardNum = cardNum;
	}
	
	
	
	//getter
	public String getCardSuits() {
		return cardSuits;
	}
	
	public int getCardNum() {
		return cardNum;
	}
	
}



