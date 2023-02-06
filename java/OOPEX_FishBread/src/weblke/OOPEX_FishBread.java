package weblke;

public class OOPEX_FishBread {

	public static void main(String[] args) {
		
		FishBread F1 = new FishBread("팥", 10);
		System.out.println(F1.toString());
		
		FishBread F2 = new FishBread("파전", 20);
		System.out.println(F2.toString());
		System.out.println(F2.getFishInner()); //속만 출력
		
		F2.setFishInner("초콜렛"); //속 변경
		F2.setFishLength(12);//길이 변경
		System.out.println(F2.toString());
		
		//깊은 복사
		FishBread deepCopyF2 = new FishBread(F2);
		System.out.println(F2.hashCode());
		System.out.println(deepCopyF2.hashCode());
		System.out.println(deepCopyF2.toString()); //복사한 초콜릿 붕어빵 출력
		
		

	}

	
	
	
	
}
