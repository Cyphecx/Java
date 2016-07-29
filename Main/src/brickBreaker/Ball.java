package brickBreaker;

public class Ball {

	private int velocityX;
	private int velocityY;
	private int height;
	private int width;
	private int x;
	private int y;

	public Ball(int velocityX, int velocityY, int x, int y){
		this.velocityX=velocityX;
		this.velocityY=velocityY;
		this.height=20;	
		this.width=20;
		this.x=x;
		this.y=y;
	}

	public int getVelocityX(){
		return velocityX;

	}
	public int getHeight(){
		return height;

	}
	public int getWidth(){
		return width;

	}
	public int getX(){
		return x;

	}
	public int getY(){
		return y;	
	}
	public void setVelocityX(int b){
		this.velocityX=b;
	
	}
	public void setX(int b){
		this.x=b;

	}
	public int getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	public void setY(int b){
		this.y=b;	
	}
	public void move(){
		this.setX(this.getX()+this.getVelocityX());
		this.setY(this.getY()+this.getVelocityY());
	}
	public void reset(){
		this.setX(840);
		this.setY(550);
	}
	public void flipVelocityX(){
			this.setVelocityX(-this.getVelocityX());
	}
	public void flipVelocityY(){
			this.setVelocityY(-this.getVelocityY());
	}
}
