package coditum.matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
	private int m;
	private int n;
	float[][] data;

	public Matrix(int n, int m){
		this.m = m;
		this.n = n;
		data = new float[n][m];
	}

	public void set(int n, int m, float input){
		data[n][m] = input;
	}

	public float get(int n, int m){
		return data[n][m];
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
			if(currR > this.height() - 1){
				return;
			}
			float[] temp;
			finished = true;
			for(int i = 0; i < this.height(); i++){	
				if(this.get(i,i) != 1){
					finished = false;
				}
			}
			for(int i = currR; i < this.height(); i++){
				if(this.get(i, currR) != 0){
					temp = new float[this.width()];
					for(int z = 0; z < this.width(); z++){
						temp[z] = this.data[i][z];
					}
					for(int z = 0; z < this.data[i].length; z++){
						this.data[i][z] = this.data[currR][z];
					}
					for(int z = 0; z < this.data[i].length; z++){
						this.data[currR][z] = temp[z];
					}
					for(int z = 0; z < this.data.length; z++){
						if(z != currR){
							rowSub(z,currR,this.data[z][currR] / this.data[currR][currR]);
						}
						else if (this.data[z][currR] != 1){
							rowSub(z, currR, 1 - 1/this.data[currR][currR]);
						}
					}
					break;
				}
			}
			currR++;
		}
	}
	public int height(){
		return this.m;
	}
	public int width(){
		return this.n;
	}
	public String size(){
		return "Rows: "+data.length+" Columns: "+data[0].length;
	}
	public static void printMatrix(Matrix in){
		for(int z = 0; z < in.height(); z++){
			for(int i = 0; i < in.width(); i++){
				if(i == in.width()-1){
					if(in.get(i, z) % 1 == 0){
						System.out.print((int)in.get(i, z));
					}
					else{
						System.out.print(in.get(i, z));
					}
				}
				else{
					if(in.get(i, z) % 1 == 0){
						System.out.print((int)in.get(i, z) + ",");
					}
					else{
						System.out.print(in.get(i, z) + ",");
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
	public void getInput() throws MatrixSizeMismatch{
		int m1 = 0;
		int n1 = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an array in the format [data, data, data... ;(New Line) data, data, data...] for an array size: " + n + "x" + m);
		String input = scan.nextLine();
		int start = 1;
		for(int i = 1; i < input.length(); i++){
			if(input.charAt(i) == ','){
				try {
					data[n1][m1] = Float.parseFloat(input.substring(start, i));
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new MatrixSizeMismatch("");
				}
				start = i + 1;
				n1++;
			}
			else if(input.charAt(i) == ';'){
				try {
					data[n1][m1] = Float.parseFloat(input.substring(start, i));
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new MatrixSizeMismatch("");
				}
				start = i + 1;
				m1++;
				n1 = 0;
			}
			else  if(input.charAt(i) == ']'){
				try {
					data[n1][m1] = Float.parseFloat(input.substring(start, i));
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new MatrixSizeMismatch("");
				}
				break;
			}
			
		}
	}
	public boolean equals(Matrix m) throws MatrixSizeMismatch{
		if(this.height() != m.height() || this.width() !=  m.width()){
			throw new MatrixSizeMismatch(this.size() + " != " + m.size());
		}
		for(int i = 0; i < this.height(); i++){
			for(int z = 0; z < this.width(); z++){
				if(this.get(z,1) != m.get(z, i)){
					return false;
				}
			}
		}
		return true;
	}
	static public Matrix randomMatrix(int n, int m){
		Matrix output = new Matrix(n,m);
		int rand = 0;
		if(Math.floor(Math.random()+1) == 0){
			rand = -100;
		}
		else{
			rand = 100;
		}
		for(int i = 0; i < n; i++){
			for(int k = 0; k < m; k++){
				output.set(i, k, (float) Math.floor((float)(Math.random() * rand)));
			} 
		}
		return output;
	}
	static public Matrix identityGen(int n){
		Matrix id = new Matrix(n,n);
		for(int i = 0; i < n; i++){
			id.set(i, i, 1);
		}
		return id;
	}
	public double determinant() throws MatrixSizeMismatch{
		double determ = 0;
		if(this.height() != this.width()){
			throw new MatrixSizeMismatch("Matrix is not Square");
		}
		if(this.height() <=1){
			throw new MatrixSizeMismatch("Matrix too Small");
		}
		if(this.width() == 2){
			determ = this.get(0, 0) * this.get(1, 1) - this.get(0, 1) * this.get(1, 0);
		}
		else{
			for(int i = 0; i < this.width(); i++){
				if((i + 1) % 2 == 0){
					determ = determ - this.get(0, i) * this.subMatrix(0, i).determinant();
				}
				else{
					determ = determ + this.get(0, i) * this.subMatrix(0, i).determinant();
				}
			}
		}
		return determ;
	}
	public double determinant(double determ) throws MatrixSizeMismatch{
		if(this.height() != this.width()){
			throw new MatrixSizeMismatch("Matrix is not Square");
		}
		if(this.width() == 2){
			determ = this.get(0, 0) * this.get(1, 1) - this.get(0, 1) * this.get(1, 0);
		}
		else{
			for(int i = 0; i < this.width(); i++){
				if((i + 1) % 2 == 0){
					determ = determ - this.get(0, i) * this.subMatrix(0, i).determinant();
				}
				else{
					determ = determ + this.get(0, i) * this.subMatrix(0, i).determinant();
				}
			}
		}
		return determ;
	}
	public static Matrix invert(Matrix in){
		Matrix identity = Matrix.identityGen(in.height());
		Matrix working = new Matrix(in.width()*2 , in.height());
		for(int i = 0; i < in.height(); i++){
			for(int z = 0; z < in.width(); z++){
				working.set(i, z, in.get(i, z));
				working.set(i + in.height(), z, identity.get(i, z));
			}
		}
		return working;
	}
	public Matrix subMatrix(int n, int m){
		Matrix out = new Matrix(this.width()-1, this.height()-1);
		ArrayList<Float> nums = new ArrayList<Float>();
		for(int i = 0; i < this.width(); i++){
			for(int k = 0; k < this.height(); k++){
				if(i != n && k != m){
					nums.add(this.get(i, k));
				}
			}
		}
		int ctr = 0;
		for(int i = 0; i < out.width(); i++){
			for(int k = 0; k < out.height(); k++){
				out.set(i, k, nums.get(ctr));
				ctr++;
			}
		}
		return out;
		
	}
}
