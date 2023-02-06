package webslke;

public class OOPEX2_Constructor {

	public static void main(String[] args) {
		
		MobilePhone Phone = new MobilePhone();
		System.out.println(Phone.hashCode());
		System.out.println(Phone.toString());
		
		MobilePhone galaxy = new MobilePhone("삼성", "갤러시S22", 256); //ctrl + 스페이스바 눌러서 2번째꺼 쓰기!
		System.out.println(galaxy.toString());
		
		//MobilePhone hwa = new MobilePhone("화웨이", 128); //이렇게 하면 MobilePhone.java에 오버로딩 갯수가 늘어나야하고 중복코드가 생긴다.
		MobilePhone hwa = new MobilePhone("화웨이",null, 128); //이렇게 호출하면 생성자의 오버로딩 갯수가 줄어든다.
		System.out.println(hwa.toString());
		
		MobilePhone Phone2 = new MobilePhone(null, "아이폰14", 512);
		System.out.println(Phone2.toString());
		
		Phone2.setBrandName("apple");
		      System.out.println(Phone2.toString());
		
		      
		      
		if(hwa.setMainMemory(2048)){
			System.out.println("메모리 업그레이드 성공");
					
		}else {
			System.out.println("메모리 업그레이드 실패");
		}
			System.out.println(hwa.toString());
		      
		      
		      
		      
		if(hwa.setMainMemory(1024)){
			System.out.println("메모리 업그레이드 성공");
			
		}else {
			System.out.println("메모리 업그레이드 실패");
		}
		System.out.println(hwa.toString());
		
		//Phone2.brandName = "애플"; //좋은 코드는 아니다. //외부( 다른 클래스에서)에서 멤버 변수의 값을 변경하려고 할 때 (setter 이용)
		//System.out.println(galaxy.brandName); //외부 (다른 클래스에서 멤버 변수의 값을 얻어오려고 할 때 (getter 이용)
		System.out.println(galaxy.getBrandName()); //get 메서드 호출 해서 사용한다.
		System.out.println(hwa.getModelName()); //get 메서드 호출 해서 사용한다.
		System.out.println(Phone2.getMainMemory()); //get 메서드 호출 해서 사용한다.
		
	
		
		System.out.println("😁😁");
	}

}
