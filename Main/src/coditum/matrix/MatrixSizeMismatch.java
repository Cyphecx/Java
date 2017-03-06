package coditum.matrix;

public class MatrixSizeMismatch extends Throwable{
	String excep;
	public MatrixSizeMismatch(String excep){
		this.excep = excep;
	}
	public String toString(){
		return "MatrixSizeMisMatch: " + excep;
	}
}
