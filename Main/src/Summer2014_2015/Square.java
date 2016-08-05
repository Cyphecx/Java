package Summer2014_2015;
public class Square extends Shape{

	public Square(int cx, int cy, int l, int w) {
		super(cx, cy, l, w);
	}
	public Square(int cx, int cy, int l){
		this(cx,cy,l,l);
	}
	public int getArea(){
		return (getLength()*getLength());
	}
	public int getPerimeter(){
		return(getLength()*4);
	}
	public void kai(){
		super.kai();
		p.pl("jlhfhaiuoafu;3i;wfihho'hfahfoihhowafhiwfowfho'/fa;awugfwagulfawg");
	}

}
