package weblke;

import java.util.Arrays;

/**
 * @Class Name : Dealer
 * @author goott
 * @date : 2023. 2. 8.
 * @packages: weblke
 * @Description: 딜러
 */
public class Dealer {
	public final static int CARD_NUM = 52; //고정배열// 배열의 길이 52로 고정
	private Card[] cardDeck = new Card[CARD_NUM]; //여기서 빈 배열이 만들어짐. //cardDeck: 카드 담는 통? //52개의 null이 든 방이 만들어짐.
	
	
	private static int curCardCount = 0; //현재 저장된 카드 갯수
	
	public Dealer() { // cardDeck에 값을 넣어줌.
		curCardCount = CARD_NUM;
		int cardIndex = 0;
		for (int cardKind = 1; cardKind <= Card.KIND_MAX; cardKind++) {
			for (int cardNum = 1; cardNum <= Card.NUMBER_MAX; cardNum++) {
				this.cardDeck[cardIndex++] = new Card(cardKind, cardNum);
			}
		}
	}
	
	
//	public Card pickSpcifiiyCard(int kind, int number) {
//		
//	}
	
	/**
	 * @Method Name : shuffleCard,
	 * @작성일: 2023. 2. 8.,
	 * @작성자: goott,
	 * @param : 없음,
	 * @반환값 : void
	 * @Description: 카드를 섞는다
	 */
	public void shuffleCard() { //카드 섞기
		for(int i =0; i <1000; i++) {
			int index = (int)(Math.random() * curCardCount);
			Card temp = this.cardDeck[0]; //임시Card(데이터 타입) temp에 넣어준다.
			this.cardDeck[0] = this.cardDeck[index]; 
			this.cardDeck[index] = temp;
		}
	}
	
	//카드 한장 뽑기
	/**
	 * @Method Name : pickCard,
	 * @작성일: 2023. 2. 8.,
	 * @작성자: goott,
	 * @param : ,
	 * @반환값 : Card
	 * @Description: 카드를 한장 뽑아 반환, (뽑은 카드는  null처리)
	 */
	public Card pickCard() {
		int index=0;
		Card returnCard=null;
		do {
			index = (int) (Math.random() * CARD_NUM);
			returnCard = this.cardDeck[index];
		} while (returnCard == null); //returnCard가 null이면 위에 반복
		
		this.cardDeck[index] = null;
		curCardCount--;
		return returnCard;
		
		

	}
	
	
	public Card pickCardAndRemoveArray() {
		int index = 0; //뽑은 카드의 인덱스 변수
		Card returnCard=null; //뽑힌 카드
		index = (int) (Math.random() * curCardCount); //
		
		returnCard = this.cardDeck[index];
		
		Card[] newCardDeck = new Card[curCardCount-1]; // 새로운 빈 배열
		for (int from = 0; from < index; from++) { //뽑은 카드 전에 있는 카드들을 새로운 빈 배열에 옮기기
			newCardDeck[from] = this.cardDeck[from];
			
		}
		for(int from = index+1; from < curCardCount; from++) {//뽑은 카드 뒤에 있는 카드들을 새로운 빈 배열에 옮기기
			newCardDeck[from -1] = this.cardDeck[from];
		}
		
		System.out.println("뽑은 카드: " + returnCard.toString() + ", 전체카드 갯수: " + newCardDeck.length +  ", [Cards]: " + Arrays.toString(newCardDeck));
		
		this.cardDeck = newCardDeck; //원본이 바뀜.
		
		curCardCount--;
		return returnCard;
	}
	

	/**
	 * @Method Name : displayCard,
	 * @작성일: 2023. 2. 8.,
	 * @작성자: goott,
	 * @param : 없음,
	 * @반환값 : String
	 * @Description: 전체 카드를 문자열로 반환
	 */
	public String displayCard() { //나중에는 출력을 view 단에서 할거기 때문에 여기서 말고 cardDealerTest에 출력해서 연습할거임.//getter나 마찬가지
		return "전체카드 갯수: " + this.cardDeck.length +  ", [Cards]: " + Arrays.toString(this.cardDeck);
	}
	
	
	
	
}
