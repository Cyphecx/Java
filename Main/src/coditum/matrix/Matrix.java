package coditum.matrix;

public class Matrix {
	private float m;
	private float n;
	float[][] data;

	public Matrix(int m, int n){
		this.m = m;
		this.n = n;
		data = new float[m][n];
	}

	public void dataSetter(int m, int n, float input){
		data[m][n] = input;
	}

	public float dataGetter(int m, int n){
		return data[m][n];
	}

	public void rowSub(int row1, int row2, float scalar){
		for(int i = 0; i < data[row1].length; i++){
			data[row1][i] = data[row1][i] - (scalar * data[row2][i]);
		}
	}
	public void gaussian(){
		boolean finished = false;
		int currR = 0;
		while(!finished){
			if(currR > data.length - 1){
				System.exit(0);
			}
			float[] temp;
			finished = true;
			for(int i = 0; i < data.length; i++){
				if(data[i][i] != 1){
					finished = false;
				}
			}
			for(int i = currR; i < data.length; i++){
				if(data[i][currR] != 0){
					temp = new float[data[i].length];
					for(int z = 0; z < data[i].length; z++){
						temp[z] = data[i][z];
					}
					for(int z = 0; z < data[i].length; z++){
						data[i][z] = data[currR][z];
					}
					for(int z = 0; z < data[i].length; z++){
						data[currR][z] = temp[z];
					}
					System.out.println("meow");
					printMatrix();
					for(int z = 0; z < data.length; z++){
						if(z != currR){
							rowSub(z,currR,data[z][currR] / data[currR][currR]);
						}
						else if (data[z][currR] != 1){
							rowSub(z, currR, 1 - 1/data[currR][currR]);
						}
					}
					break;
				}
			}
			printMatrix();
			currR++;
		}
	}
	public String size(){
		return "Rows: "+data.length+" Columns: "+data[0].length;
	}
	public void printMatrix(){
		for(int i = 0; i < data.length; i++){
			for(int z = 0; z < data[i].length; z++){
				System.out.print(data[i][z]+",");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}
