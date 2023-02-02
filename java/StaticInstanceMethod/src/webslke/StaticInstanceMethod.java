package webslke;

import java.util.Scanner;
//import java.lang.Math; //java.lang은 기본 패키지라서 import 생략가능

public class StaticInstanceMethod {

	//Static과 non-static 메서드의 메서드 호출방법
	public static void main(String[] args) {
		//1)static 키워드가 있는 멤버의 호출방법:  클래스명. 멤버명()으로 호출
		System.out.println(Math.abs(-3));
		
		//초록공
		// s f: static, final(내가 수정 못함)  //static은 쓰기 좋지만 메모리에 한번 올라가면 프로그램 종료까지내려오지 않아서 관리가 어렵다
		
		//2)non-static(instatnce):  static키워드가 없는 멤버. 그 멤버를 가지고 있는 클래스로 부터 객체를 만들고, 객체명. 멤버명()으로 호출,
		//static보다 메모리 관리가 용이함.
		Scanner sc = new Scanner(System.in);//객체 생성. 객체명: sc
		System.out.print("num>>>");
		int num1 =  sc.nextInt(); //-인스턴스??
		System.out.println(num1);
		
		sc.close();
		sc = null;
		

		System.gc(); // 안쓰는 메모리 수거(가비지 콜렉터), 동작하는건 os마다 다르거나 때에 따라 다르다.
		System.out.print("num>>>");
		int num = sc.nextInt();
		System.out.println(num);
		

	}

}
