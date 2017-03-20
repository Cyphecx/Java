package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		Matrix m1 = new Matrix(3,3);
		m1.getInput();
		m1.subMatrix(0,0).printMatrix();
	}
}