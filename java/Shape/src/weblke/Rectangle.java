package weblke;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	Rectangle(String name, String color, Point p, int height){
		super(name)
	}
	
			   public int getWidth() {
			      return width;
			   }

			   public void setWidth(int width) {
			      this.width = width;
			   }

			   public int getHeight() {
			      return height;
			   }

			   public void setHeight(int height) {
			      this.height = height;
			   }

			   @Override
			   public String toString() {
			      return  super.toString() + "[넓이 " + width + ", 높이 " + height + "]";
			   }
			   
}
