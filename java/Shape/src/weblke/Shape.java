package weblke;

import java.awt.Graphics;

public abstract class Shape { //하나라도 추상메서드가 있으면 추상클래스가 됨 //!!추상클래스는 객체로 만들 수가 없다.!!!
	
	// 추상클래스가 되는 조건
	// 1) class 키워드 앞에 abstract 키워드를 붙인다. (추상 메서드가 없어도 추상 클래스로 만들어짐)
	// 2) 클래스의 멤버 메서드 중 하나라도 추상 메서드가 있다면 자동으로 추상 클래스가 되어야 한다.
	
	//객체가 아닌 클래스가 왜 필요한가?? 설계 할 때 필요하다.
	private String name;
	private String color;
	private Point p;
	
	Shape(String name, String color, Point p) {
		super();
		this.name = name;
		this.color = color;
		this.p = p; //주소값 넘겨준다는 말
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

//	public void draw() {//바디 있음.
//		//상위 클래스인 Shape에서는 draw메서드를 구현하지 못한다.
//	   //왜? 어떤 도형을 어떻게 그려야 할지 모르기(추상적) 때문이다.
//	   //-> 추상메서드로 만든다.
//	}

	//추상 메서드: 바디가 없는 메서드
	//언젠가는 구현이 되어야 함.(자식 클래스에서 명확해지면 구현을 해야함!)
	//void draw (매개변수 없는 상태) - 이렇게 만들어야 모든 사람이 각자의 스타일로 만들어도 받아 올 수 있다.??
	public abstract void draw(Graphics g); //바디가 없다. //규칙! 추상메서드는 꼭! 추상 클래스 안에 있어야 한다.
}
