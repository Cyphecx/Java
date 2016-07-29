
public class Square extends Rectangle{
	
	public Square(int width){
		super(width,width);
	}
	public void setLength(int x){
		super.setWidth(x);
		super.setLength(x);
	}
	public void setWidth(int x){
		super.setWidth(x);
		super.setLength(x);
	}
}
