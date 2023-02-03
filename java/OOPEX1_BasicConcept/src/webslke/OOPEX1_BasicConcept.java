package webslke;

public class OOPEX1_BasicConcept {

	public static void main(String[] args) {
	 // Car 객체 생성
		//기본 생성자: 매개변수가 하나도 없는 생성자(생략가능)
		Car car1 = new Car(); // Car 객체를 새로운 메모리를 할당 하여 만들고, 기본생성자를 호출
		Car car2 = new Car();
		
		
		
		//car2 객체의 속성 값 변경
		//아래 처럼 얼마든지 (접근 제어자가 허용된다면)
		// 객체를 생성 한 이후에 객체의 속성을 변화 시킬 수 있다.
		//하지만, 객체의 속성을 프로그해머가 원하는 대로 생성하려면 아래의 방법보다는
		//생성자를 사용하는 석이 좋다.
		
		
		car2.color = "흰색"; //car2 객체의 color 속성 값 변경
		
//		System.out.println("granduer1 의 모델명:" + granduer1.modelName + ", 가격:"+ granduer1.price + ", 색상:" + granduer1.color );
//		System.out.println("granduer2 의 모델명:" + granduer2.modelName + ", 가격:"+ granduer2.price + ", 색상:" + granduer2.color );
		
		
		//Car 객체의 멤버 메서드 displayCar() 호출
		car1.displayCar();
		car2.displayCar();
	}

}

