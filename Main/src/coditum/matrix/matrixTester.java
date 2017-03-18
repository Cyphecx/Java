package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		Matrix m1 = new Matrix(3,3);
		Matrix m2 = new Matrix(3,3);
		System.out.println(m1.equals(m2));
	}
}