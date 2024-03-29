package weblke;


//bean: 생성자, 게터, 세터, 투스트링.. 다 있는것

public class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		super(); //부모의 기본 생성자(매개변수가 없는) 호출
		this.x = x;
		this.y = y;
	}
	
	
	Point(Point p){//생성자: 객체를 만들면서 멤버변수를 초기화하는 것
		//p라는 원점을 복사한 것
		this.x = p.getX();
		this.y = p.getY();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override //어노테이션?
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]"; //부모가 오브젝트인데 이렇게 수정했다.
	}
	
	
}
