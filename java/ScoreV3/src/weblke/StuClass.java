package weblke;

public class StuClass {
	private int no; // 반 번호
	private String className; // 과정명
	private Student[] stuList; //학생 목록( 포함관계) //배열 선언만함 아직 초기값 안준 상태
	private int totalTot; // 학생 전체 총점 // 반마다 총점이 다르게 때문에 Static으로 만들지 않는다.//만약 static으로 만들면 모든 반이 총점을 공유하게 된다.
	private float totalAvg; //학생 전체 평균
	
	//상수처리 : 상수는 무조건 대문자.// final: 값수정 불가
	public static final int STUDENT_COUNT = 3; // 학생을 담는 배열의 길이 (상수) //보통 상수는 public static final 로 선언한다.
	
	//생성자: 객체가 생성될 때 멤버변수 초기화
	public StuClass(int no, String className) {
		this.no = no;
		this.className = className;
		this.stuList = new Student[STUDENT_COUNT]; //배열은 생기면 자동 초기화된다. //여기서 Student의 명 수를 알려면 
		//명 수가 먼저 선언되어야 하기 때문에 위에서 STUDENT_COUNT를 상수처리 해준 것이다.( 실행 시 가장 먼저 초기화 )
	}
	
	public StuClass(int no, String className, Student[] stuList) {
		this.no =no;
		this.className =className;
		this.stuList = stuList;
	}
	
	//getter
	public int getNo() {
		return this.no;
		
	}
	public String getClassName() {
		return this.className;
	}
	
	
	public Student[] getStuList() {
		return this.stuList;
	}
	
	
	
	//setter
	public void setClassName(String className) {
		this.className = className;
	}
	
	//학생을 반에 배정 // 학생 한명을 받아 stuList 배열의 no번째 배열에 추가
	public void addStudent(Student student, int no) {
		this.stuList[no] = student;
	}
	
	public void outputEntireStudents() {
		ScoreV3 sc = new ScoreV3();
		for(int i= 0; i < sc.getCurSavedStudentCnt(); i++) {
			System.out.println(this.stuList[i].toString());
		}
	}
	
	//학생들의 전체 총점
	public int calcTotalTot() {
		this.totalTot = 0;
		ScoreV3 sc = new ScoreV3();
		for(int i = 0; i < sc.getCurSavedStudentCnt(); i++) {
			this.totalTot += this.stuList[i].getTot();
					//this.stuList[i].getTot() : 힉생 한명이 가지고 있는 총점을 누적 시킨다.
		}
		return this.totalTot;
				
	}
	
	//평균
	public float calcTotalAvg() {
		ScoreV3 sc = new ScoreV3();
		this.totalAvg = this.totalTot / 3/(float)(sc.getCurSavedStudentCnt());
		this.totalAvg = Math.round(totalAvg * 100)/100;
		return this.totalAvg;
	}
	
	

	//학번으로 해당 학번의 학생 성적 //default
	void findStudentByNo(String stuNo) {
		boolean isFind = false;
//		stuNo학번을 가진 학생을 this.stuList(배열)에서 검색
		for(Student s : this.stuList) { //배열 for문 돌림.
			if(stuNo.equals(s.getStuNo())) { //stuNo == getStuNo() 이렇게 하면 주소끼리 비교하는거기 때문에 equals를 쓴다.
				System.out.println("*********검색된 학생 정보 **************");
				System.out.println(s.toString());
				isFind = true;
			}
		}
		if(!isFind) {
			System.out.println("*********검색된 학생 정보 없습니다!! **************");
		}
	}
	
	
	//반 기본 정보 넘겨줌
	public String toString() {
		return "반 번호: " + this.no + ","
				+ "과정명: "+ this.className;
	}
	
	
}
