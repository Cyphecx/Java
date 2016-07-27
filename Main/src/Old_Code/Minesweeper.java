package Old_Code;
import java.util.Random;
import java.util.Scanner;


public class Minesweeper {
	static int board[][] = new int[8][8];
	static Scanner scan = new Scanner(System.in);
	static boolean win=true;
	static int pos1;
	static int pos2;
	static Random rand = new Random();
	public static void main(String[] args) {
		for (int k = 0; k < 8; k ++){

			for (int e = 0; e < 8; e ++){
				board[k][e] = 9;

			} 

		}
		System.out.println();
		bl();
		pos1 = scan.nextInt();
		pos2 = scan.nextInt();
		board[pos1][pos2]=0;
		GEN();
		while(win){
			bl();
			pos1 = scan.nextInt();
			pos2 = scan.nextInt();
			System.out.println("");
		}
		System.exit(0);
	}
	public static void num(){

	}
	public static void GEN(){
		boolean gen = false;
		int orange = 0;
		int orang = 0;
		for(int x=0; x<10; x++){
			int c1 = rand.nextInt(7)+1;
			int c2 = rand.nextInt(7)+1;	
			int p1= pos1-1;
			int p2=pos2-2;

			for(int o = -1; o<2; o++){

				for(int k =-1; k<2; k++){
					if(o+pos1==c1&k+pos2==c2){
						orange++;	
					}
				}
			}
			if(orange<0){
				gen=false;
			}
			else{
				gen=true;
			}
			if(gen){
				board[c1][c2]=10;
			}
			else{
				x--;
			}

		}
		try{
		for(int o = -1; o<7; o++){
			for(int k =-1; k<7; k++){
				int h=0;
				if(board[o+pos1][k+pos2]!=10){
				for(int oo = -1; oo<7; oo++){
					for(int kk =-1; kk<7; kk++){
						if(oo+o+pos1==10&kk+k+pos2==10){
							h++;	
						}
					}
				}
				}
				board[o+pos1][k+pos2]=h;
			}
		}}catch(Exception or){}

	}
	public static void bl(){
		for (int k = 0; k < 8; k ++){
			System.out.println();
			for (int e = 0; e < 8; e ++){
				//System.out.print(board[k][e]+" ");
				if(board[k][e]==10&board[k][e]!=0){
					System.out.print("9 ");
				}
				else{
					System.out.print(board[k][e]+" ");
				}
			} 

		}
	}
}
