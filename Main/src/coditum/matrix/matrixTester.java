package coditum.matrix;
public class matrixTester{
	public static void main(String[] args) {
		Matrix m = new Matrix(3,4);
		float[][] input = new float[3][4];
		input[0][0] = 1;
		input[0][1] = 1;
		input[0][2] = 1;
		input[0][3] = 0;
		input[1][0] = 2;
		input[1][1] = 2;
		input[1][2] = 0;
		input[1][3] = 15;
		input[2][0] = 0;
		input[2][1] = 1;
		input[2][2] = 1;
		input[2][3] = -3;
		for(int i = 0; i < 3; i++){
			for(int z = 0; z < 4; z++){
				m.dataSetter(i, z, input[i][z]);
			}
		}
		System.out.println(m.size());
		m.printMatrix();
		m.gaussian();
		for(int i = 0; i < input[0].length; i++){
			for(int z = 0; z < 3; z++){
				System.out.println(m.dataGetter(i, z));
			}
		}
	}
}