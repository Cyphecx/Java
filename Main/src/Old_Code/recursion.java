package Old_Code;

public class recursion {

	public static void main(String[] args) {
		System.out.println(exp(10,11));
	}
	public static int exp(int a,int b){
		if(b==0){
			return 1;
		}
		return a*exp(a,b-1);
	}
	public static int fact(int a){
		if(a==0){
			return 1;
		}
		
	 return a*fact(a-1);
	}
}
