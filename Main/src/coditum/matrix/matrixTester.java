package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		Matrix m1 = new Matrix(3,3);
		m1.set(0, 0, 1);
		m1.set(0, 1, 2);
		m1.set(0, 2, 0);
		m1.set(1, 0, 0);
		m1.set(1, 1, 1);
		m1.set(1, 2, 0);
		m1.set(2, 0, 0);
		m1.set(2, 1, 0);
		m1.set(2, 2, 1);
		Matrix m2 = new Matrix(3,3);
		m2.set(0, 0, 5);
		m2.set(0, 1, 6);
		m2.set(0, 2, 2);
		m2.set(1, 0, 4);
		m2.set(1, 1, 6);
		m2.set(1, 2, 1);
		m2.set(2, 0, 7);
		m2.set(2, 1, 7);
		m2.set(2, 2, 7);
		Matrix ans = m1.matrixMulti(m1, m2);
		ans.printMatrix();
	}
}