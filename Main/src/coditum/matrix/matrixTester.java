package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		//Matrix m = Matrix.randomMatrix(3,3);
		Matrix m = new Matrix(3,3);
		m.getInput();
		Matrix.printMatrix(m);
		System.out.println("---------------------------------------------------------");
		Matrix worker = Matrix.invert(m);
		Matrix.printMatrix(worker);
		worker.gaussian();
		System.out.println("---------------------------------------------------------");
		Matrix.printMatrix(worker);
	}
}