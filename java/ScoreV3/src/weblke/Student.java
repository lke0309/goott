package weblke;

import java.io.File;

public class Student {
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private float avg;
	private char grade;
	
	
	private  static int totalTot;//전체 총점
	private  static float totalAvg; // 전체 평균
	
	//생성자 : 클래스와 같은 이름으로.
	public Student(String stuNo, String stuName, int kor, int eng, int math) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		

		
		
		setTot(); //총점 구하기
		setAvg(); //평균 구하기
		setGrade();//등급  구하기

//		totalTot += this.tot;

	}
	

	// bin??: 멤버변수 , 생성자 , getter, setter, toString
	
	//getter : source 메뉴에서 제너레이트 getter and  setter 로 생성함.
	public String getStuNo() {
		return stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTot() {
		return tot;
	}

	public float getAvg() {
		return avg;
	}

	public char getGrade() {
		return grade;
	}
	public static int getTotalTot() {
		return totalTot; //같은 클래스니까 클래스 명 생략
	}
	public static float getTotalAvg() {
		return totalAvg;
	}
	
	
	//setter
	//국어 점수 변경 시
	public void setStuName(String stuName ) {
		this.stuName =stuName;
	}
	public void setKor(int kor) {
		if(kor >= 0 && kor <= 100) {
			this.kor = kor;
			
			setTot(); //총점 다시 구하기
			setAvg(); //평균 다시 구하기
			setGrade();//등급 다시 구하기
		}
	}
	//영어 점수 변경 시
	public void setEng(int eng) {
		if(eng >= 0 && eng <= 100) {
			this.eng = eng;
			
			setTot(); //총점 다시 구하기
			setAvg(); //평균 다시 구하기
			setGrade();//등급 다시 구하기
		}
	}
	//수학 점수 변경 시
	public void setMath(int math) {
		if(math >= 0 && math <= 100) {
			this.math = math;
			
			setTot(); //총점 다시 구하기
			setAvg(); //평균 다시 구하기
			setGrade();//등급 다시 구하기
		}
	}
	
//	public static setTotalTot() {
//		//다음에 배우기로~~
//		//전체 학생을 담을 수 있는 공간이 필요하기 때문에 지금은 전체 평균과 전체 총점을 구할 수 없음.
//	}

	public void setTot() {
		this.tot = this.kor + this.eng + this.math;
	}
	
	public void setAvg() {
		this.avg = (float)this.tot /3;
	}
	
	public void setGrade() {
		switch ((int)(Math.floor(this.avg/10d))) { //avg는 실수(float) 10은 정수(int)  사칙연산하면 더 높은 타입을 따라가기 때문에 실수가 됨
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
		default:
			this.grade = 'F';
			break;
		}
	}
	public String toString() {
		return "학번: " +this.stuNo +","
				+ "이름: " + this.stuName + ","
				+ "국어: " + this.kor + ","
				+ "영어: " + this.eng + ","
				+ "수학: " + this.math + ","
				+ "총점: " + this.tot + ","
				+ "평균: " + this.avg + ","
				+ "학점: " + this.grade;
	}
	
	
}
