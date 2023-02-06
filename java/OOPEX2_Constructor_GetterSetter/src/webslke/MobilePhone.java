package webslke;

public class MobilePhone {
	//속성(멤버 변수는 초기화를 안하면 자동 초기화 된다 String은 null로 , int는 0으로)
	private String brandName;
	private String modelName;
	private int mainMemory;
	
	//생성자와 메서드 차이 알기 ! 비슷하게 생김.
	
	
	//생성자 : 반환값을 못씀 // 메서드 오버로딩처럼 생성자도 오버로딩됨.
	public MobilePhone() {
		System.out.println("고객님 폰이 개통되었습니다.");
	}
	
	
	public MobilePhone(String brandName, int mainMemory) {
		
//		this();
//		this.brandName = brandName;
//		this.mainMemory = mainMemory;
		//코드의 중복을 막기위해 아래처럼 쓴다.
		
		this(brandName, null, mainMemory);//생성자 재 활용(아래에 코드에 값을 보내줌)		
	}
	
	//생성자 오버로딩: 조건 -> 같은 클래스 , 같은 이름
	public MobilePhone(String brandName, String modelName, int mainMemory) {
		//생성자에서 다른 생성자를 호출할 때는 반드시 생성자의 첫문장에 써야함 // 딱 한번만 호출 가능
		this(); //현재 객체의 생성자 호출 여기에서는 매개변수가 없는 기본 생성자를 호출함.//무조건 첫문장에만 사용가능//위에 고객님 메세지 출력 함.
		
		//속성에 초기값 할당(넘겨받은 지역변수의 값을 멤버변수에 할당)
		//지역변수와 멤버변수의 이름이 같기 때문에 애매모호한 것을 방지하기 위해
		//멤버변수에 현재객체라는 의미를 가지고 있는 키워드 this를 붙인다.
		//멤버변수 = 지역변수;
		
		this.brandName = brandName;
		this.modelName = modelName;
		this.mainMemory = mainMemory;
	}

	
	
	//메서드
	
	//getter
	String getBrandName() {// 카멜기법 사용!
		return this.brandName; //다른 곳에서 호출 할 수 있도록 brandName값 반환
	}
	String getModelName() {
		return this.modelName; //다른 곳에서 호출 할 수 있도록 brandName값 반환
	}
//	int getMainMemory() {
//		return this.mainMemory ;
//	}
//	
	String getMainMemory() {
		return this.mainMemory + "Gigabyte";
	}
	
	
	//setter : 값변경
	void setBrandName(String brandName) {
		//멤버변수 = 지역변수;
		this.brandName = brandName;
	}
	void setModelName(String modelName) {
		//멤버변수 = 지역변수;
		this.modelName = modelName;
	}
	
//	void setMainMemory(String mainMemory) {
//		//멤버변수 = 지역변수;
//		this.mainMemory = mainMemory;
//	}
	
	boolean setMainMemory(int mainMemory) {
		//메인 메모리의 용량을 1tb까지만 허용한다면 이렇게 setter를 구현 할 수 도 있다.
		boolean result = false;
		if (mainMemory <= 1024) {
			//멤버변수 = 지역변수;
			this.mainMemory = mainMemory;
			result = true;
		}
		return  result;
	
	}

	
	
	public String toString() {
		//getClass() : 현재객체(클래스)를 가져와라
		//getName(): 이름을 가져와라
		return "[" + this.getClass().getName()+ ":"+ this.hashCode() + "] = brandName: " + this.brandName  + ", modelName: " + this.modelName +
			",mainMemory: " + this.mainMemory;

	}
}
