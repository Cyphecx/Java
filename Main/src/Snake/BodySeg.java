package Snake;

public class BodySeg {
	private int width;
	private int height;
	private int x;
	private int y;
	private int pX;
	private int pY;
	public BodySeg(int x, int y){
		this.x=x;
		this.y=y;
		this.width=20;
		this.height=20;	
	}
	public int getpX() {
		return pX;
	}
	public void setpX(int pX) {
		this.pX = pX;
	}
	public int getpY() {
		return pY;
	}
	public void setpY(int pY) {
		this.pY = pY;
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
	
	
	
	public void move(int t, int i){
		this.setpX(this.getX());
		this.setpY(this.getY());
		this.setX(this.getX()+t);
		this.setY(this.getY()+i);
	}
}
