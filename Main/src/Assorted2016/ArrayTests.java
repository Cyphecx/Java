package Assorted2016;

public class ArrayTests {

		public static void main(String[] args){
			
			int[][]array;
			array = new int[10][10];
			
			for(int i = 0; i<10; i++){
				for(int z = 0; z<2; z++){
					array[i][z]=(int) Math.ceil(Math.random()*1002);
				}
			}
			int x = 0;
			for(int i = 0; i<10; i++){
				for(int z = 0; z<2; z++){
					x++;
					System.out.print(x);
					System.out.print("["+i+"]["+z+"]");
					System.out.print(": ");
					System.out.println(array[i][z]);
				}
			}
		}
}
