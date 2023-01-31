
public class DataTypeCasting {
	public static void main (String[] args) {
		byte b = 123;
		System.out.println(b);
		//System.out.println("b의 데이터 타입:"+ b.getClass().getName());
		
		//묵시적 형 변환(casting) :프로그래머가 형 변환 연산자를 쓰지 않더라도 자동으로 되는 형변환.
		//보통 .작은 타입에서 큰타입으로 변할 때 묵시적 형 변환이 일어난다.
		int i = b;
		System.out.println("i : " + i );
		
		// 명시적 형변환: 프로그래머가 형 변환을 하라고 명시해 놓는것. (큰탕비 -> 작은 타입 변환)//억지로 넣는것
		//(형변환할 데이터 타입)캐스팅할 변수
		double pi = 3.141592;
		//float fPi = pi; //에러: 큰 타입에서 작은 타입으로 데이터 형변환을 묵시적으로 하지 못한다.
		float fPi = (float)pi;
		System.out.println(fPi);
		
		
		//명시적 형변환시에 형변환되는 변수와 형변황 하려고 하는 변수가 같은 범위에 있는 것이 좋다. 
		int i2 = 2147483647; //32767 값은 int 값도 되지만 short 타입의 범위에 있다.
		short s = (short)i2; //명시적 형변환 해도 underflow가 발생하지 않는다.
		System.out.println(s);
		
		
		//문자는 내부적으로 아스키 코드 값이 있기 때문에 아래와 같은 코딩이 가능
		char c ='a';
		System.out.println(c);// 'a'
		System.out.println((int)c); //문자는 내부적으로 아스키 코드값이 있고, 그 값의 정수값으로 바뀜.
		System.out.println((char)98);//'b'
		
		
		//boolean은 논리형이고, float는 4byte실수이지만 . 아예 다른 타입이기 때문에 형변환이 불가
		//boolean b =true;
		//float f2 = (float)bool; //타입이 달라서 변환 안됨.
		
		
	}
}
