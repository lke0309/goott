package weblke;

public class StaticVsInstance {
	static int sInt; // static 멤버 변수 //프로그램 종료될 때까지 남아있음.
	int iInt;//instance 멤버 변수 //객체가 부여되야 메모리가 부여됨.
	
	
	
	{
		//instance 멤버들을 초기화 할 수 있는 블럭 //잘안씀
		iInt =5;
	}
	static {
		//static 멤버들을 초기화할 수 있는 블럭 //잘안씀
		sInt =100;
	}
	
	public void acc() {
		StaticVsInstance.sInt++;
		this.iInt++;
		
		System.out.println("no: "+ this.hashCode() + ", sInt: "
		+ StaticVsInstance.sInt + ", iInt: "+ this.iInt);
		
		//StaticVsInstance.sInt  : 클래스명으로 접근
		//this.iInt : this로 접근
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i <10; i++) {
			StaticVsInstance svi = new StaticVsInstance();
			svi.acc();
		}
	}

}
