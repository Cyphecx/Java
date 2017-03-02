package school;

public class Ostructure {

	public static void main(String[] args) {
		int ctr = 5;
		int ctr2 = 0;
		double currTime = 0;
		while(ctr2 < 240){
			if(System.currentTimeMillis() - currTime >= 250){
				currTime = System.currentTimeMillis();
				for(int x = 0; x < ctr; x++){
					System.out.print("O");
				}
				System.out.println();
				if(ctr == 1){
					ctr++;
				}
				else if(ctr == 10){
					ctr--;
				}
				else{
					int rand = (int) (Math.random()*2);
					if(rand == 0){
						ctr--;
					}
					if(rand == 1){
						ctr++;
					}
				}
				ctr2++;
			}
		}

	}

}
