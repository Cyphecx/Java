package summer2014_2015;
import java.util.Random;
public class Arrays {

	public static void main(String[] args) {

		Random random = new Random();
		
		int h = random.nextInt(10);
		int k = random.nextInt(10);
		int d = random.nextInt(10);
		int v = random.nextInt(10);
		int f = random.nextInt(10);
		
		int x = 0;
		int F[] = new int[5];
		F[0]=h;	
		F[1]=k;
		F[2]=d;
		F[3]=v;
		F[4]=f;
		while(x<5){
			System.out.println(F[x]);
			x++;
		}

	}
}
                            