package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) throws MatrixSizeMismatch{
		Matrix m1 = new Matrix(3,3);
		m1.set(0, 0, 1);
		m1.set(0, 1, 0);
		m1.set(0, 2, 0);
		m1.set(1, 0, 0);
		m1.set(1, 1, 1);
		m1.set(1, 2, 0);
		m1.set(2, 0, 0);
		m1.set(2, 1, 0);
		m1.set(2, 2, 1);
		m1.getInput();
		Matrix m2 = new Matrix(3,3);
		for(int i = 0; i < 3; i++){
			for(int z = 0; z < 3; z++){
				m2.set(i, z, (int)(Math.random()*100+1));
			}
		}
		m2.printMatrix();
		Matrix ans = m1.matrixMulti(m1, m2);
		ans.printMatrix();
	}
}