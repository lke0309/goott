package weblke;


class ParentA{
	private int a = 100;
	
	public int getA() {
		return this.a;
	}
}


class ParentD{
	
}

//자바에서는 다중상속을 표현하는 문법 자체가 없다. syntax error = 문법에러
//class ETC extends ParentA, ParentD {
//	
//}

public class InheritanceEx2Test extends ParentA {

	public static void main(String[] args) {
		System.out.println(new ParentA().getA()); //자기 자신의 멤버를 사용

		System.out.println(new Child().getA()); //Child 객체의 멤버는 아니지만 상속을 받은 멤버이기에 사용가능
		
		System.out.println(new InheritanceEx2Test().getA()); //Child 객체의 멤버는 아니지만 상속을 받은 멤버이기에 사용가능
		
		ParentA objA = new ParentA();
		
		Child objChild = new Child();
		
		if(objChild instanceof Child) { //objChild 가 Child 의 객체이냐? //네
			System.out.println("네"); 
			
		}else {
			System.out.println("아니오");
		}
		
		if(objChild instanceof ParentA) { //objChild 가 ParentA 의 객체이냐? //네 - Child의 부모가 ParentA이기 때문에
			System.out.println("네");
			
		}else {
			System.out.println("아니오");
		}
		
//		if(objChild instanceof ParentD) { //objChild 가 D 의 객체이냐? //아니오 - 대상자체가 비교할 수 없음 상속 관계가 아니끼 때문에.
//			System.out.println("네");
//			
//		}else {
//			System.out.println("아니오");
//		}
		
	}

}

class Child extends ParentA{
	
}