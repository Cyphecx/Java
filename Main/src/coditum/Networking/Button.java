package coditum.Networking;

public class Button {
private int state;
private int x;
private int y;
private int width;
private int height;
	public Button(int w, int h){
		this.width = w;
		this.height = h;
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
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public boolean collide(int xx, int yy){
		if(xx > this.getX() && xx < this.getX()+this.getWidth() && yy > this.getY() && yy < this.getY() + this.getHeight()){
			return true;
		}
		return false;
	}
}
