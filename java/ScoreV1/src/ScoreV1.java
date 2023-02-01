
public class ScoreV1 {

	public static void main(String[] args) {
		String name = "둘리";
		int kor = 98, eng = 34, math =56;
		int tot =kor + eng + math;
		float avg = tot/3f; //tot가 int  이기 때문에  연산 후 int가 된다 그래서 float타입으로 바꿔줌.
		char grade = ' ';
		
		switch ((int)(Math.floor(avg/10d))) { //avg는 실수(float) 10은 정수(int)  사칙연산하면 더 높은 타입을 따라가기 때문에 실수가 됨
		case 10:
		case 9:
			grade = 'A';
			
			break;
		case 8:
			grade = 'B';
			
			break;
		case 7:
			grade = 'C';
			
			break;
		case 6:
			grade = 'D';
			
			break;

		default:
			grade = 'F';
			break;
		}
	
		System.out.println("성적표");
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균 \t 학점 \t");
		System.out.println("=============================================================================");
		System.out.println(name +" \t" + kor +" \t"+ eng + " \t"+ math +" \t"+tot + " \t" + avg + " \t"+ grade +" \t");
		
		
	}//main 메서드의 끝

}
