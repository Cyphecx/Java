package Old_Code;
import java.util.Random;
public class Connect4withAI{
	public static void main(String[] args) {
		int z = 5;
		int turn = 1;
		int k = 0;
		int C[][] = new int[6][7];
		for (k = 0; k < 6; k ++){
			Random rand = new Random();
			int r = rand.nextInt(7);
			for (int e = 0; e < 7; e ++){
				C[k][e] = 0;

			} 

		}
		String cpu = st.Prompt.getString("Do you want to play against the computer? Yes||No ");
		for (k = 0; k < 6; k ++){
			System.out.println("");
			for (int e = 0; e < 7; e ++){
				if (C[k][e] == 0){
					System.out.print("- ");
				}
				if (C[k][e] == 1){
					System.out.print("O ");
				}
				if (C[k][e] == 2){
					System.out.print("0 ");
				}

			} 

		}
		System.out.println("");
		System.out.print("= = = = = = =");
		System.out.println("");
		System.out.print("1 2 3 4 5 6 7");
		System.out.println("");
		System.out.print("= = = = = = =");
		while(cpu.equals("No")){
			while(turn == 1){
				int chord1 = st.Prompt.getInt("Make your move Player"+ turn);
				while(chord1 > 7){
					chord1 = st.Prompt.getInt("Column doesn't exist, try again");
				}
				while(C[z][chord1-1] != 0){
					z--;
					while(z < 0){
						chord1 = st.Prompt.getInt("Column full, try again");
						z = 5;
					}
				}

				C[z][chord1 - 1] = 1;
				for (k = 0; k < 6; k ++){
					System.out.println("");
					for (int e = 0; e < 7; e ++){
						if (C[k][e] == 0){
							System.out.print("- ");
						}
						if (C[k][e] == 1){
							System.out.print("O ");
						}
						if (C[k][e] == 2){
							System.out.print("0 ");
						}
					} 
				}	
				z = 5;
				System.out.println("");
				System.out.print("= = = = = = =");
				System.out.println("");
				System.out.print("1 2 3 4 5 6 7");
				System.out.println("");
				System.out.print("= = = = = = =");
				turn = 2;

				for (k = 0; k < 2; k ++){

					for (int e = 0; e < 6; e ++){
						if(C[e][k] == 1&& C[e][k+1] ==1 &&C[e][k+2] == 1 && C[e][k+3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k] ==1 &&C[e+2][k] == 1 && C[e+3][k] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 4; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k+1] ==1 &&C[e+2][k+2] == 1 && C[e+3][k+3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k-1] ==1 &&C[e+2][k-2] == 1 && C[e+3][k-3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
			}
			while(turn == 2){

				int chord1 = st.Prompt.getInt("Make your move Player"+ turn);
				while(chord1 > 7){
					chord1 = st.Prompt.getInt("Column doesn't exist, try again");
				}
				while(C[z][chord1-1] != 0){
					z--;
					while(z < 0){
						chord1 = st.Prompt.getInt("Column full, try again");
						z = 5;
					}
				}

				C[z][chord1 - 1] = 2;
				for (k = 0; k < 6; k ++){
					System.out.println("");
					for (int e = 0; e < 7; e ++){
						if (C[k][e] == 0){
							System.out.print("- ");
						}
						if (C[k][e] == 1){
							System.out.print("O ");
						}
						if (C[k][e] == 2){
							System.out.print("0 ");
						}
					} 
				}	
				z = 5;
				System.out.println("");
				System.out.print("= = = = = = =");
				System.out.println("");
				System.out.print("1 2 3 4 5 6 7");
				System.out.println("");
				System.out.print("= = = = = = =");
				for (k = 0; k < 2; k ++){

					for (int e = 0; e < 6; e ++){
						if(C[e][k] == 2&& C[e][k+1] == 2 &&C[e][k+2] == 2 && C[e][k+3] == 2){
							System.out.println("");
							System.out.print("Player2 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k] == 2 &&C[e+2][k] == 2 && C[e+3][k] == 2){
							System.out.println("");
							System.out.print("Player2 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 4; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k+1] == 2 &&C[e+2][k+2] == 2 && C[e+3][k+3] == 2){
							System.out.println("");
							System.out.print("Player2 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k-1] == 2 &&C[e+2][k-2] == 2 && C[e+3][k-3] == 2){
							System.out.println("");
							System.out.print("Player2 wins!");
							return;
						}
					}
				}
				turn = 1;
			}



		}
		while(cpu.equals("Yes")){
			while(turn == 1){
				int chord1 = st.Prompt.getInt("Make your move Player");
				while(chord1 > 7){
					chord1 = st.Prompt.getInt("Column doesn't exist, try again");
				}
				while(C[z][chord1-1] != 0){
					z--;
					while(z < 0){
						chord1 = st.Prompt.getInt("Column full, try again");
						z = 5;
					}
				}

				C[z][chord1 - 1] = 1;
				for (k = 0; k < 6; k ++){
					System.out.println("");
					for (int e = 0; e < 7; e ++){
						if (C[k][e] == 0){
							System.out.print("- ");
						}
						if (C[k][e] == 1){
							System.out.print("O ");
						}
						if (C[k][e] == 2){
							System.out.print("0 ");
						}
					} 
				}	
				z = 5;
				System.out.println("");
				System.out.print("= = = = = = =");
				System.out.println("");
				System.out.print("1 2 3 4 5 6 7");
				System.out.println("");
				System.out.print("= = = = = = =");
				turn = 2;

				for (k = 0; k < 2; k ++){

					for (int e = 0; e < 6; e ++){
						if(C[e][k] == 1&& C[e][k+1] ==1 &&C[e][k+2] == 1 && C[e][k+3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k] ==1 &&C[e+2][k] == 1 && C[e+3][k] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 4; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k+1] ==1 &&C[e+2][k+2] == 1 && C[e+3][k+3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 1&& C[e+1][k-1] ==1 &&C[e+2][k-2] == 1 && C[e+3][k-3] == 1){
							System.out.println("");
							System.out.print("Player1 wins!");
							return;
						}
					}
				}
			}
			// AI control
			while(turn == 2){
				Random rand = new Random();

				int chord1 = rand.nextInt(7);
				while(C[z][chord1-1] != 0){
					z--;
					while(z < 0){
						chord1 = rand.nextInt(7);
						z = 5;
					}
				}

				C[z][chord1 - 1] = 2;
				for (k = 0; k < 6; k ++){
					System.out.println("");
					for (int e = 0; e < 7; e ++){
						if (C[k][e] == 0){
							System.out.print("- ");
						}
						if (C[k][e] == 1){
							System.out.print("O ");
						}
						if (C[k][e] == 2){
							System.out.print("0 ");
						}
					} 
				}	
				z = 5;
				System.out.println("");
				System.out.print("= = = = = = =");
				System.out.println("");
				System.out.print("1 2 3 4 5 6 7");
				System.out.println("");
				System.out.print("= = = = = = =");
				for (k = 0; k < 2; k ++){

					for (int e = 0; e < 6; e ++){
						if(C[e][k] == 2&& C[e][k+1] == 2 &&C[e][k+2] == 2 && C[e][k+3] == 2){
							System.out.println("");
							System.out.print("CPU wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k] == 2 &&C[e+2][k] == 2 && C[e+3][k] == 2){
							System.out.println("");
							System.out.print("CPU wins!");
							return;
						}
					}
				}
				for (k = 0; k < 4; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k+1] == 2 &&C[e+2][k+2] == 2 && C[e+3][k+3] == 2){
							System.out.println("");
							System.out.print("CPU wins!");
							return;
						}
					}
				}
				for (k = 0; k < 7; k ++){

					for (int e = 0; e < 3; e ++){
						if(C[e][k] == 2&& C[e+1][k-1] == 2 &&C[e+2][k-2] == 2 && C[e+3][k-3] == 2){
							System.out.println("");
							System.out.print("CPU wins!");
							return;
						}
					}
				}
				turn = 1;
			}



		}
	}
}
