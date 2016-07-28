package rekAiden_Birdoof;

public class Tile {
	private int width;
	protected int height;
	private int x;
	private int y;
	public Tile(int w, int h,int x,int y){
		this.width=w;
		this.height=h;
		this.x=x;
		this.y=y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
