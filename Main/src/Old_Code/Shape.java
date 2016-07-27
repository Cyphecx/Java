package Old_Code;

public class Shape {
	private int chordx;
	private int chordy;
	private int length;
	private int width;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getChordx() {
		return chordx;
	}
	public int getChordy() {
		return chordy;
	}
	public Shape(int cx, int cy, int l, int w){
		chordx=cx;
		chordy=cy;
		length=l;
		width=w;
	}
	public void kai(){
		System.out.println("kai");
	}
	public static void main(String[] args) {
		Circle circ = new Circle(100, 100, 50);
		Square squ = new Square(100,100,40);
		p.pl(squ.getArea()+"");
		p.p(circ.getCircumfrence()+"");
		circ.kai();
		squ.kai();
	}
	
}
