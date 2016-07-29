package brickBreaker;

public class Paddle {
	private int x;
	private int y;
	private int height;
	private int width;
	private int velocity;
	public Paddle(int x){
		this.x=x;
		this.y=860;
		this.height=25;
		this.width=150;
		this.velocity=0;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	public void move(){
		this.setX(this.getX()+this.getVelocity());
	}
}
