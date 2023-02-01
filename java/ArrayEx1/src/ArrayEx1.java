
public class ArrayEx1 {

	public static void main(String[] args) {
		int a;
	//	System.out.println(a); //지역변수는 초기화를 하지 않으면 사용하지 못함
		int[] scores = new int [3]; //객체는 자동 초기화 된다. [0, 0, 0]
		System.out.println(scores);
		
		String[] names = new String[5];
		System.out.println(names); //String 타입의 기본값은 null
		
		boolean isOk[] =new boolean[2];
		System.out.println(isOk);
	}

}
