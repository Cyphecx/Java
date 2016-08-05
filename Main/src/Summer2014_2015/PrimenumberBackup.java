package Summer2014_2015;

	import java.util.ArrayList;
	public class PrimenumberBackup {
		public static void main(String[] args) {
			ArrayList<Long> n = new ArrayList<Long>();
			for(long h=2; h<100000; h++){
				n.add(h);
			}
			for(int check=0; check<n.size(); check++){
				for(int check2=check+1; check2<n.size(); check2++){
					if(n.get(check2)%n.get(check)==0){
						n.remove(check2);check2--;
						
					}
				}
			}
			System.out.println(n);
		}
		/*public static boolean isPrime(long h){
			int checker=3;
			while(checker<=h){
				if(h==checker){
					return true;
				}
				if(h%checker==0){
					return false;
				}
				checker++;
			}
			return false;
		}
		public static boolean isPrime2(long h){
			if(h!=2&&h%2==0)
				return false;
			for(int i=3;i<=Math.sqrt(h);i+=2){
				if(h%i==0)
					return false;
			}
			return true;
		}*/

	
}
