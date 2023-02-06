package weblke;

public class ScoreV2 {

	public static void main(String[] args) {
		Student s1 = new Student("9900001",	"홍길동", 98, 75, 34);
		Student s2 = new Student("9900002",	"둘리", 45, 33, 76);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		
	
		
		System.out.println(s1.getGrade()); //s1의 등급만 출력
		s1.setKor(120);// 국어점수 100점이 넘어가서 못고침
		System.out.println(s1.toString());
		s1.setKor(0);//국어점수 고침
		System.out.println(s1.toString());

	}

}
