package weblke;

public class Triangle extends Shape {
	
	private int height;
	private int base;
	
	//부모객체인 Shape에 기본 생성자가 없기때문에 부모객체를 만들지 못해서 에러가 날 수 있다.
	//해결 방법: 1) 부모 객체에 기본 생성자를 만들어준다.
	//			 2) 부모 객체가 가지고 있는 오버로딩된 생성자를 이용하여 부모객체를 만들도록 해야한다.
	
	
	
	Triangle (String name, String color, Point p, int base, int height) {
		//부모 객체가 만들어지려면 String name, String color, Point p 매개 변수가 필요하다.
		//그래서 현재 객체인 Triangle에도 String name, String color, Point p매개변수로 받는 생성자를 
		//만들어 주고, 부모 생성자를 호출하여 부모 객체가 생성이 되도록 해야한다.
		
		//String name, String color, Point p 를 초기화 하는 부분은 부모 생성자에 있으므로 재 사용
		super(name, color, p); 
		// 부모에게 없는 멤버변수인 base와  height는 현재 객체의 생성자에서 초기화 한다.
		this.base = base;
		this.height = height;
	}
	
	
	
	
	
	public int getHeight() {
		return height;
	}





	public void setHeight(int height) {
		this.height = height;
	}





	public int getBase() {
		return base;
	}





	public void setBase(int base) {
		this.base = base;
	}





	@Override
	public void draw() {
		
	}
	
	
//	@Override
//	public void draw() {
//		//내가 (triangle) 가지고 있는 toString() 호출
//		System.out.prinln(this.toString()+ "인 삼각형이 그려집니다.");
//	}
//	
	
	@Override
	public String toString() {
		//부모(Shape)가 물려준  toString()을 이용해서 수정
		return super.toString() + 
				",base =" + this.base + ",height =" + this.height + "]";
		
	}
	
	
	// 부모가 물려준 집의 화장실 자체를 뜯어고침
	@Override //아래의 메서드가 오버라이딩 됨을 컴파일에게 명
	public String toString() {
		//부모가 (Shape)가 물려준 toString()을 이용하지 않고 override
		return "Triangle[height =" + super.getName() + ",color=" + super.getColor +
				"point= (" + super.getP().getX() + ", " + super.getP().getY() + ")"+
				",base =" + this.base + ",height =" + this.height + "]";
		
	}

}
