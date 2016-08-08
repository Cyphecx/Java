package summer2014_2015;
import java.util.ArrayList;


public class Primenumber {
	public static void main(String[] args) {
		int print = 1;
		ArrayList<Long> n = new ArrayList<Long>();
		for(long h=2; h<200000; h++){
			n.add(h);
		}
		for(int check=0; check<n.size(); check++){
			for(int check2=check+1; check2<n.size(); check2++){
				if(n.get(check2)%n.get(check)==0){
					n.remove(check2);check2--;
				}
			}
		}
		for(int h=1; h<n.size(); h++){
			System.out.println(n.get(h));
		}
	}
}