
public class Rectangle {
	private int length;
	private int width;
	public Rectangle(int length,int width){
		this.length=length;
		this.width=width;
	}
	public Rectangle(){
		this.length=5;
		this.width=3;
	}
	public int getLength(){
		return this.length;
	}
	public int getWidth(){
		return this.width;
	}
	public int getPerimeter(){
		return (2*this.width)+(2*this.length);
	}
	public int getArea(){
		return this.length*this.width;
	}
	public void setLength(int length){
		this.length=length;
	}
	public void setWidth(int width){
		this.width=width;
	}
}
