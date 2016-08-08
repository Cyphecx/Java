package bidoof_Platformer;

public class Player {
	//basic player object with x y and velocity tracking
	private int xPos=0;
	private int yPos=0;
	private int velX=0;
	private int width=45;
	private int height=30;
	private int velY=0;
	public Player(int i, int b, int r, int aidensuckz){
		this.xPos=i;
		this.yPos=b;
		this.width=r;
		this.height=aidensuckz;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getVelX() {
		return velX;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setVelX(int vel) {
		this.velX = vel;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int d) {
		this.velY = d;
	}

}
