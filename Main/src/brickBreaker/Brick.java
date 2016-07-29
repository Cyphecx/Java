package brickBreaker;
public class Brick {
	private int width;
	private int height;
	private int x;
	private int y;
	
	public Brick(int x, int y){
		this.x=x;
		this.y=y;
		this.width=100;
		this.height=40;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
