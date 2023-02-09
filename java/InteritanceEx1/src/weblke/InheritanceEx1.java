package weblke;

import java.awt.Frame;
import java.awt.Window;

public class InheritanceEx1 extends Frame { //extends 키워드 + 부모

	
	//생성자
   public InheritanceEx1(String title) {
      super(title);
   }
   
   public static void main(String[] args) {
      InheritanceEx1 myWindow = new InheritanceEx1("나의 윈도우"); //InheritanceEx1에게 title를 넣어서 호출
      System.out.println(myWindow.toString());

      
//      Window myWin =new Window(myWindow);
//      myWin.setVisible(false);
      myWindow.setVisible(true);
   }

}