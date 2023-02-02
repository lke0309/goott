import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ArraySearchEx {

	public static void main(String[] args) {
	
		int[] ar = new int [20];
		
		for(int i =0; i< ar.length; i++) {
			ar[i] =(int)(Math.random() * 100 +1);
		}
		
		System.out.println(Arrays.toString(ar));
		
		Scanner sc = new Scanner(System.in); //in: 컴퓨터에 있는 입력장치(마우스, 키보드...)를 가르킴
		System.out.print("찾을 숫자>>>");
		int findNum = sc.nextInt(); //nextInt(): 엔터를 칠때까지 나오는 모든 정수를 입력 받겠다.
				
		int i =0;
		boolean isFind =false;
		for(int num : ar) {
			if(num == findNum) { //찾았다 //둘다 값타입이라 비교가능 // array는 참조타입이라 비교하면 주소 나옴.
				isFind =true;
				System.out.println("찾는 값" + findNum + "은" +  i + "번째에 있습니다.");
			}
			i++;
		}
		if(!isFind) {
			System.out.println(findNum + "을 찾을 수 없습니다.");
		}
				
	}
}
//데이터 정렬도 해보기
