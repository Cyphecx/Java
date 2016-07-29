package Snake;

public class Pellet {

	private int x;
	private int y;
	private int height;
	private int width;
	public Pellet(int x, int y){
		this.x=x;
		this.y=y;
		this.height=20;
		this.width=20;
	}
	
	
	public void spawnPellet(){
		this.setX((int)Math.ceil(Math.random()*85)*20);
		this.setY((int)Math.ceil(Math.random()*45)*20);
		
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


	public int getHeight() {
		return height;
	}


	public int getWidth() {
		return width;
	}

}
