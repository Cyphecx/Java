package Summer2014_2015;

public class Circle extends Shape{
private int radius;
	private Circle(int cx, int cy, int l, int w) {
		super(cx, cy, l, w);

	}
	public int getRadius() {
		return radius;
	}
	public Circle(int cx, int cy, int r){
		this(cx,cy,r*2, r*2);
		radius=r;
	}
	public double getArea(){
		return (Math.pow(radius,2)*Math.PI);
	}
	public double getCircumfrence(){
		return ((radius*2)*Math.PI);
	}

}
