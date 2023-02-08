package weblke;

/**
 * @Class Name : Card
 * @author goott
 * @date : 2023. 2. 8.
 * @packages: weblke
 * @Description: 포커카드 각각에 대한 객체
 */
public class Card {
	//카드 각각의 무늬와 숫자는 달라진다. 그래서 instance멤버 변수로 만든다.
	private int kind; //카드무늬 //랜덤함수에서 숫자가 나오기 때문에 String이 아니고 정수인 int를 한다.// 예를들어 1은 하트 이런식으로 숫자화 한다.
	private int number; //카드 숫자

	//모든 카드 52장은 width와 height가 동일한 값을 가지고 있다. 모든 카드 객체가 공유하는  static 변수로 만든다.
	private static int width = 100; //카드의 가로 길이 //이미지 픽셀 단위가 정수 값이라서 int로 잡는다.
	private static int height = 200; //카드의 세로 길이
	
	//상수처리 : 상수는 무조건 대문자.// final: 값수정 불가
	private static final int HEAERT =1; //HEAERT라는 문자열 상수를 1로 동일하게 취급하겠다.
	private static final int SPADE =2; 
	private static final int CLOVER =3;
	private static final int DIAMOND =4; 
	
	static final int KIND_MAX =4; //카드 종류의 수
	static final int NUMBER_MAX =13; // 카드 숫자의 수
	
	//카드 이미지 구현은 나중에
	
	//생성자: 멤버변수를 초기화하는 역할을 함. 초기화 된 것들은 넣지 말기
	public Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	
	
	public String toString() { //	toString() : 문자로 표현하겠다는 뜻
		String kind = "";
		String number = "";
		
		switch (this.number) {
		case 1:
			number = "A";
			break;
			
		case 11:
			number = "J";
			break;

		case 12:
			number = "Q";
			break;
			
		case 13:
			number = "K";
			break;
			
		default:
			number = this.number + ""; // int 타입을 가장 빠르게 문자형으러 바꾸는법은 문자열을 더하면 됨.
			
		}
		
		
		switch (this.kind) {
		case HEAERT:
			kind = "♥";
			break;
			
		case SPADE:
			kind = "♠";
			break;
			
		case CLOVER:
			kind = "♣";
			break;
			
		case DIAMOND:
			kind = "◆";
			break;

		}
		return  kind + number;
				
	}
	
	
}
