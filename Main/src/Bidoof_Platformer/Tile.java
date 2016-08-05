package Bidoof_Platformer;

public class Tile {
	//all environment objects extend Tile or are Tiles
	private int width;
	protected int height;
	private int x;
	private int y;
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Tile(int state, int w, int h,int x,int y){
		this.width=w;
		this.state=state;
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

