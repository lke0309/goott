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
		
		
		System.out.println("😁😁");
	}

}
