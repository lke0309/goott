package weblke;

import java.awt.Graphics;

public class ShapeTest {

	
	public static void main(String[] args) {
		
		//Shape 클래스가 추상 클래스이기 때문에 객체를 만드려면 추상메서드를 오버라이딩 해야 만들어진다.
		//추상 메서드를 overriding한다는 의미는 객체가 분명해졌다. -> 그 객체는 더이상 Shape 가 아님. (추상적이지 않다)
		//위와 같은 논리적 모순이 생기기에 아래와 같이 쓰진 않는다.
		
//		Shape s = new Shape("도형", "black", new Point(50, 50)) {
//			
//			@Override
//			public void draw(Graphics g) {
//				// TODO Auto-generated method stub
//				
//				
//			}
//		};
//		
//		System.out.println(s.toString());
		
		
		Triangle t1 = new Triangle("삼각형1", "red", new Point(100,100),5,10);
		System.out.println(t1.toString());
		
		Triangle r1 = new Triangle("사각형1", "blue", new Point(100,100),5,10);
		System.out.println(t1.toString());
		
		Triangle c1 = new Triangle("원1", "yello", new Point(100,100),5,10);
		System.out.println(c1.toString());
		System.out.println("==========================================");

		
		
//		t1.draw();
		
		
		//다형성
		//c1은 Circle의 객체(하위객체) 이고, sCircle은 Shape의 객체(상위객체)이다.
		//아래의 연산이 수행되면, 업캐스팅(upCasting)이 발생하며 수행 되게 된다.
		Shape sCircle = c1; 
		
		Painter 피카소 = new Painter("피카소");
		피카소.drawShape(c1);
		피카소.drawShape(t1);
//		피카소.drawShape(r1);
	}
}
