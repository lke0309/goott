import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		
		 int[] scores = new int[5];
		 int tmp =0;
		 
//		 for(int i =0; i <scores.length; i++) {
//			
//				tmp = ((int)(Math.floor(Math.random()*30d)+1));
//				
//		 }
		 
		 
		  for (int score : scores) {
			  tmp = ((int)(Math.floor(Math.random()*30d)+1));
//			  scores[i++] = tmp;
		      }
		 
	      System.out.println("배열 : " + Arrays.toString(scores));
		 
		 System.out.println("번호는 : " + scores );
	
		 
		
	}

}
