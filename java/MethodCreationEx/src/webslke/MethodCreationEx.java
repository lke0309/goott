package webslke;

//다양하게 메서드를 만드는 방법과 호출하는 방법을 연습해보자.
public class MethodCreationEx {

	public static int add(int a, int b) {
		return a + b;
	}
	
	//메서드 오버로딩
	public static int add(int num1, int num2, int num3) { //오버로딩: 메서드명이 같고, 매개변수 갯수가 다름
		return num1 + num2 + num3;
	}
	
	//메서드 오버로딩
	public void add(int n, float m) { //오버로딩 : 메서드 명은 같지만 매개변수 데이터 타입이 다름
		
	}
	
	//메서드 오버로딩
	public void add(float n, int m) {//오버로딩 : 위에꺼랑 매개변수 타입 순서가 다름.
		
	}
	
	
	public static void main(String[] args) {
		//숫자두개를 더해서 결과값을 반환(return)하는 함수
		int result = MethodCreationEx.add(3,5); //스태이틱 메서드 //add라는 함수는 스태이틱 해야함.
		
		//호출하는 곳과 호출되는 클래스가 같다면 메서드 호출시 클래스명 생략가능//원래는 MethodCreationEx.add이렇게 써야함.
		//스태이틱한 메서드, 상수, 변수는 이탤릭체로 바뀜.
		System.out.println(add(300,500));
		
		
		MethodCreationEx mce = new MethodCreationEx();
		float fResult = mce.add(3.14f, 5.65f);// 객체명.메서드 = nonstatic(인스턴스)  // 위에 add 메서드가 따로 있지만 또 선언 =  메서드오버로딩
		
		
		//이름이 outputNTimes 이고, 매개변수를 String 타입 변수 하나와 n(정수)을 받아
		// 그 문자열을 화면에 n번 반복하여 출력하는 메서드(인스턴스 메서드)를 만드시고 호출하세요.
		
		//MethodCreationEx mce2 = new MethodCreationEx(); //다시 만들 필요 없음.
		mce.outputNTimes("안녕하세요.",5);
		
	}

	
	public void outputNTimes(String str, int n) {
		for(int i =0; i < n; i++ ) {
			System.out.println(str);
			// println은 부모요소인 out 이 스태이틱 하기 때문에 out. 이라고 쓴다.
		};
	};
	
	
	//메서드 오버로딩
	public float add(float a, float b) { //위에서 객체명.myFloatAdd(메서드)로 선언해줘서 아래에서는 넌스태이틱(인스턴스)으로 함.
		float result = 0f;
		result = a + b;
		return result;
		
		
		}
	}

