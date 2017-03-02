package school;

public class RandomNumbers {

	public static void main(String[] args) {
		for(int i =  0; i < (int)(Math.random()*41); i++){
			System.out.print("Line "+(i+1)+": ");
			for(int x = 0; x < Math.random()*51; x++){
				System.out.print((int)(Math.random()*10));
			}
			System.out.println();
		}

	}

}
