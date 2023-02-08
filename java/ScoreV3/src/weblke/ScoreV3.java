package weblke;

import java.util.Iterator;
import java.util.Scanner;

public class ScoreV3 {
	
//	private StuClass c1 ; //c1을 멤버 변수로 둬서
	
	private static int curSavedStudentCnt = 0; //현재 저장되어 있는 학생 수
	
	//getter: 학생 수를  StuClass.java파일에서 쓸 수 있게 해줌.
	int getCurSavedStudentCnt() {
		return curSavedStudentCnt;
	}

	private static void outputMenu() {
		System.out.println("************************************************");
		System.out.println("**              성적표 V3                     **");
		System.out.println("************************************************");
		System.out.println("** 1. 반 생성                                 **");
		System.out.println("** 2. 생성된 반에 학생 입력(1번 부터 수행)    **");
		System.out.println("** 3. 전체 학생 점수 출력                     **");
		System.out.println("** 4. 반, 학생 자동생성                       **");
		System.out.println("** 5. 학생 성적 출력(by 학생번호)             **");
		System.out.println("** 9. 종료                                    **");
		System.out.println("************************************************");
		System.out.println("메뉴 번호 입력 >>> ");

	}

	// 반 만들기
	private StuClass createClass() {
		Scanner nosc = new Scanner(System.in);
		System.out.print("반 번호 입력>>> ");
		int classNo = nosc.nextInt();
		
		Scanner namesc = new Scanner(System.in);
		System.out.print("과정명 입력>>> ");
		String className = namesc.nextLine();
		
		StuClass c1 = new StuClass(classNo, className);
		System.out.println(c1.toString());
		return c1; // c1이 지역 변수니까 return 해서 밖에서도 사용가능
	}
	
	private void inputStudent(StuClass stuClass) {
		if(stuClass == null) {
			System.out.println("반부터 생성하고 오세요.");
			return; //null을 호출한 곳으로 되돌아가라는 뜻 , 반환 값 없음.
		}else {
			if (curSavedStudentCnt < StuClass.STUDENT_COUNT) {
				Scanner stuNumSC = new Scanner(System.in); //int 타입 받음
				Scanner stuStringSC = new Scanner(System.in); //string 타입 받음.
				System.out.println("학생번호>>> ");
				String stuNo = stuStringSC.nextLine();
				System.out.println("학생이름>>> ");
				String stuName = stuStringSC.nextLine();
				System.out.print("국어>>> ");
				int kor = stuNumSC.nextInt();
				System.out.print("영어>>> ");
				int eng = stuNumSC.nextInt();
				System.out.print("수학>>> ");
				int math = stuNumSC.nextInt();
				
				//System.out.println(stu.toString());
				stuClass.addStudent(new Student(stuNo, stuName, kor, eng, math), curSavedStudentCnt);
				//학생하나를 만들어서 curSavedStudentCnt번째에 집어 넣어라.
				
				curSavedStudentCnt++; //학생 만든 후 몇명인지 알기위해 count + 1씩 증가
			}else {
				System.out.println("학생 수가 초과 됩니다.");
			}
//			return stuClass;   //리턴이 필요없다 stuClass참조 타입이므로 call by reference에 의해 리턴 불필요
		}
	}

	public static void main(String[] args) { //메인 함수 먼저 실행 // 멤버 메서드
		ScoreV3 sc = new ScoreV3();
		StuClass stuClass = null;
		while (true) {
			outputMenu();
			Scanner menuSC = new Scanner(System.in);
			int menu = menuSC.nextInt();

			switch (menu) {
			case 1:
				stuClass = sc.createClass(); // 인스턴스 메서드 만들면 됨.
				
				break;
			case 2:
				sc.inputStudent(stuClass); //call by reference //return 할 필요가 없음.
				break;
			case 3:
				sc.outputEntireStudent(stuClass);
				break;
			case 4:
				stuClass = sc.autoInputStudent(stuClass);
				break;
			case 5:
				sc.findStudentByNo(stuClass);
				break;
			case 9:
				System.exit(0);// 프로그램 종료
				break;

			default:
				break;
			}
		}

	} //main 메서드 끝
	
	//학번으로 해당 학번의 학생 성적 출력하기
	//해당 학번의 학생 정보가 없으면 "학생 정보 없음!" 이라고 출력
	private void findStudentByNo(StuClass stuClass) {
		Scanner stuStringSC = new Scanner(System.in); //string 타입 받음.
		System.out.println("학생번호>>> ");
		String stuNo = stuStringSC.nextLine();
		
		stuClass.findStudentByNo(stuNo);
		
	
		
		
		
	};
	
	private StuClass autoInputStudent(StuClass stuClass) {
		Student[] stuList = {
			new Student("98001", "둘리", 78, 55, 34),	
			new Student("98002", "도우너", 45, 25, 100),	
			new Student("98003", "마이콜", 99, 65, 23)	
		}; //학생 생성
		
		curSavedStudentCnt =3;
		return  new StuClass(6, "K디지털", stuList); //반 생성
	}

	private void outputEntireStudent(StuClass stuClass) {
		System.out.println("==========================================================");
		System.out.println("						성적표");
		System.out.println("==========================================================");
		System.out.println("반 번호: " + stuClass.getNo()+ ", 과정명: "+  stuClass.getClassName());
		System.out.println("----------------------------------------------------------");
		stuClass.outputEntireStudents();
		System.out.println("----------------------------------------------------------");
		System.out.println("전체총점: "+ stuClass.calcTotalTot() +  ", 전체 평균: " +  stuClass.calcTotalAvg());
		

		
		}
	
	
}
