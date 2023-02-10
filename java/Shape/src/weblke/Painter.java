package weblke;

public class Painter {

	private String name;
	

	Painter(String name) {
		super();
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	//화가가 각각의 원, 삼각형, 사각형을 그린다고 표현할 때, 아래의 코드로 구현하면
	//코드의 재 사용성이 떨어진다.
	
//	public void drawTriangle(Triangle t)
//	{
//		System.out.println("이름이 "+  t.getName() + "이고, 색상은 "+ t.getColor() + "이고, 원점: "
//		+ t.getP().getX()+"," 
//		+ t.getP().getY() + ", 밑변" + t.getBase() + "높이" + t.getHeight() + "인 원을 그립니다.");
//		
//	}
//	
//	public void drawTriangle(Rectangle r)
//	{
//		System.out.println("이름이 "+  t.getName() + "이고, 색상은 "+ t.getColor() + "이고, 원점: "
//		+ t.getP().getX()+"," 
//		+ t.getP().getY() + ", 밑변" + t.getBase() + "높이" + t.getHeight() + "인 원을 그립니다.");
//		
//	}
//	
//	
//	public void drawRectangle(Rectangle r) {
//		
//	}
//	
//	public void drawCircle(Circle c) {
//		
//	}
	
	
	//Shape s =c1;
	//다형성 2번째 법칙(? : 이득) : 부모(Shape) 일므으로 모든 자식 객체를 매개변수로 다 받을 수 있다.
	//업캐스팅
	public void drawShape(Shape s) {
//		if(s instanceof Circle) {
//			Circle c = (Circle)s; //다운캐스팅(down Casting): 업캐스팅 된 객체가 자기 자신의 타입으로 되돌아가는것
//			System.out.println(((Circle)s).toString()+ "인 원을 그립니다.");
//		}
//		if(s instanceof Triangle) {
//			System.out.println(((Triangle)s).toString()+ "인 삼각형을 그립니다.");
//		}
//		
//		if(s instanceof Rectangle) {
//			System.out.println(((Rectangle)s).toString()+ "인 사각형을 그립니다.");
//		}
		//다형성 1번째 법칙(?: 개이득): 부모 이름으로 자식이
		System.out.println(s.toString()+"인 원을 그립니다.");
		
//		System.out.println(s.getRadius()); //부모에게 (Shape에) 있는 멤버만 가능
		//부모에게는 draw가 추상메서드였지만, 자식 객체인 Circle에서 구현했으므로
		//부모 (Shape)의 이름으로 자식이 구현된 draw()
		s.draw(); 
	}
}
