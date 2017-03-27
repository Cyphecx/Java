package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		Matrix m = Matrix.randomMatrix(3,3);
		m.printMatrix();
		System.out.println("---------------------------------------------------------");
		m.subMatrix(1, 0).printMatrix();
	}
}