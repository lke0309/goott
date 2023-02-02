package webslke;

public class OOPEX1_BasicConcept {

	public static void main(String[] args) {
	 // Car 객체 생성
		Car car1 = new Car();
		Car car2 = new Car();
		
		car2.color = "흰색"; //car2 객체의 color 속성 값 변경
		
//		System.out.println("granduer1 의 모델명:" + granduer1.modelName + ", 가격:"+ granduer1.price + ", 색상:" + granduer1.color );
//		System.out.println("granduer2 의 모델명:" + granduer2.modelName + ", 가격:"+ granduer2.price + ", 색상:" + granduer2.color );
		
		
		//Car 객체의 멤버 메서드 displayCar() 호출
		car1.displayCar();
		car2.displayCar();
	}

}

