package coditum.matrix;

import java.util.Scanner;

public class Matrix {
	private float m;
	private float n;
	private int m1;
	private int n1;
	float[][] data;

	public Matrix(int m, int n){
		this.m = m;
		this.n = n;
		data = new float[m][n];
	}

	public void set(int m, int n, float input){
		data[m][n] = input;
	}

	public float get(int m, int n){
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
			currR++;
		}
	}
	public int height(){
		return data[0].length;
	}
	public int width(){
		return data.length;
	}
	public String size(){
		return "Rows: "+data.length+" Columns: "+data[0].length;
	}
	public void printMatrix(){
		for(int i = 0; i < data.length; i++){
			for(int z = 0; z < data[i].length; z++){
				if(z == data[i].length-1){
					if(data[i][z] % 1 == 0){
						System.out.print((int)data[i][z]);
					}
					else{
						System.out.print(data[i][z]);
					}
				}
				else{
					if(data[i][z] % 1 == 0){
						System.out.print((int)data[i][z] + ",");
					}
					else{
						System.out.print(data[i][z]+",");
					}
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public Matrix matrixMulti(Matrix inMa1, Matrix inMa2) throws MatrixSizeMismatch{
		Matrix matrix = new Matrix(inMa1.height(), inMa2.width());
		for(int i = 0; i < inMa2.height(); i++){
			for(int z = 0; z < inMa1.width(); z++){
				float num = 0;
				for(int x = 0; x < inMa1.width(); x++){
					num = num + inMa1.get(i, x) * inMa2.get(x, z);
				}
				matrix.set(i, z, num);
			}
		}
		if(inMa1.width() != inMa2.height()){
			throw new MatrixSizeMismatch("2==2");
		}
		//return this;
		return matrix;
	}
	public void getInput(){
		m1 = 0;
		n1 = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an array in the format [data, data, data... ;(New Line) data, data, data...] for an array size: " + n + "x" + m);
		String input = scan.nextLine();
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '['){
				int end = i;
				while(input.charAt(end) != ','){
					end++;
				}
				
			}
		
		}
	}
	public void iterator(){
		if(n1 == this.n1){
			
		}
	}
}
