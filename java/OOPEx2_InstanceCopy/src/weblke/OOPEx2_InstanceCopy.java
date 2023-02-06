package weblke;
//깊은 복사 vs 얕은 복사

public class OOPEx2_InstanceCopy {

	public static void main(String[] args) {
		Student s1 = new Student("980011", "둘리", 56,23,33);
		System.out.println(s1.toString());
		
		//얕은 복사
		Student s2 = s1;
		s2.setKor(0); //원본을 수정하면
		System.out.println(s1.toString());//복사본도 영향을 받는다.
		System.out.println(s2.toString());


		
		//깊은 복사( 생성자를 통해), 주소값 다름
		Student s3 = new Student("980015", "도우너", 100,100,0);
		Student deepCopyS3 = new Student(s3);
		System.out.println(s3.hashCode());
		System.out.println(deepCopyS3.hashCode());
		
		System.out.println(s3.toString());
		System.out.println(deepCopyS3.toString());
		
		s3.setStuName("도우나");
		System.out.println(s3.toString());
		System.out.println(deepCopyS3.toString());
	}

}
