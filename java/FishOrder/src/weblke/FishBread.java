package weblke;

public class FishBread {

	private String fishInner;
	private int fishLength;
	private int fishPrice;
	
	
	
	//생성자
	public FishBread( String fishInner, int fishLength, int fishPrice ) {
		this.fishInner = fishInner;
		this.fishLength = fishLength;
		this.fishPrice = fishPrice;
	};
	
	
	//getter
	public String getFishInner(){
		return fishInner;
	}
	public int getFishLength() {
		return fishLength;
	}
	public int getFishPrice() {
		return fishPrice;
	}
	
	
}
