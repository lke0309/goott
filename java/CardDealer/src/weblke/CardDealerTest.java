package weblke;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CardDealerTest extends JFrame{
	
	public CardDealerTest(String title) {
		super(title); //부모가 알아서 윈도우를 만들고 타이틀을 제목 표시줄 자리에 찍어줌.
		
		this.setVisible(true);
		this.setSize(new Dimension(640, 480));
	}

	public static void main(String[] args) {
		Dealer 주윤발 = new Dealer();
		System.out.println( 주윤발.displayCard());

		
		주윤발.shuffleCard();
		System.out.println( "섞은 후 카드 " + 주윤발.displayCard());
		
		
		
		
		
//		for (int i =0; i< Dealer.CARD_NUM; i ++) {
//			Card c = 주윤발.pickCard();
//			System.out.println((i+1) + "번째 뽑힌 카드: " + c.toString());
//		}
		
		
		for (int i =0; i< Dealer.CARD_NUM; i ++) {
			주윤발.pickCardAndRemoveArray();

		}


		System.out.println( 주윤발.displayCard());
		
		CardDealerTest win =new CardDealerTest("포커");
				
	}

	@Override //anotation : 컴파일러에게 아래의 메서드가 오버라이딩 되었음을 알려주는것. //메서드 위에 있고 @로 시작하면 어노텐션임
	public void paint(Graphics g) {//부모에게 물려받을걸 수정하는 것 //윈도우가 그려질 때 자동으로 호출되는 일종의 콜백메서드
		
		super.paint(g); // 부모가 가지고 있는 페인트를 호출함 g를 주면서. g는 그래픽스
		
//		System.out.println("!");
		
		String imagePath = "D:\\lecture\\java\\AH.png"; // 역슬러쉬가 두개인 이유: \\중에 앞에 \는(이스케이프 시퀀스) 뒤에 \하나를 출력하라는 의미
		
//		g.drawOval(100, 100, 50, 50); //동그라미 출력
		URL imageUrl = null;
		try {
			imageUrl = new URL("http://t0.gstatic.com/licensed-image?q=tbn:ANd9GcQkrjYxSfSHeCEA7hkPy8e2JphDsfFHZVKqx-3t37E4XKr-AT7DML8IwtwY0TnZsUcQ");
		} catch (MalformedURLException e) {
			// 위의코드가 잘못되면 아래 코드 실행
			e.printStackTrace();
			System.out.println("잘못된 URL주소입니다.");
			System.exit(0);//프로그램 종료
		}
		
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(imageUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("이미지를 읽어오지 못했습니다. 인터넷이 불량합니다.");
			System.exit(0);//프로그램 종료
			
		}
		
		
//		g.drawImage(img, 200, 200, null); //강아지 출력(Url 주소로 가져와서)
		
		File fPath = new File(imagePath);
		try {
			
			g.drawImage(ImageIO.read(fPath), 200, 200, null); //트럼프카드 출력(내가 가지고 있는 파일을 불러와서)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
