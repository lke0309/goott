package weblke;

public class FishBread {
	
	private String fishInner;
	private int fishLength;
	

	//생성자: 객체가 생성될때 할일	
	public FishBread(String fishInner, int fishLength ) {
		this.fishInner = fishInner;
		this.fishLength = fishLength;
	}
	
	//생성자를 이용한 깊은 복사
	public FishBread(FishBread originFishBread) {
		this.fishInner = originFishBread.fishInner;
		this.fishLength =  originFishBread.fishLength;
	}
	
	
	
	//getter
	public String getFishInner() {
		return fishInner;
	}
	public int getFishLength() {
		return fishLength;
	}
	
	
	//setter
	public void setFishInner(String fishInner) {
		this.fishInner = fishInner;
	}
	public void setFishLength(int fishLength) {
		this.fishLength = fishLength;
	}
	
	
	
	public String toString() {
		return "이 붕어빵은 속에 " +this.fishInner 
				+ "이(가) 들어갔고 길이는 " + this.fishLength + "cm 입니다." ;
	}
	
}
