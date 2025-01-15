package rect;

public class Rectangle {

	private int width ,height;
	
	public Rectangle(int width, int height) {
		super();
		this.width = Math.max(1,width);
		this.height = Math.max(1, height);
	
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int getArea() {
		return width * height ; 
	}
	

	
}
