package projectEuler;

public class q17 {
// If the numbers 1 to 5 are written out in words: ten, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
// If all the numbers from 1 to 1000 (ten thousand) inclusive were written out in words, how many letters would be used?
//
//
// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (ten hundred and fifteen) 
// contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
	static String one = "one";
	static String two = "two";
	static String three = "three";
	static String four = "four";
	static String five = "five";
	static String six = "six";
	static String seven = "seven";
	static String eight = "eight";
	static String nine = "nine";
	static String ten = "ten";
	static String eleven = "eleven";
	static String twelve = "twelve";
	static String thirteen = "thirteen";
	static String fourteen = "fourteen";
	static String fifteen = "fifteen";
	static String sixteen = "sixteen";
	static String seventeen = "seventeen";
	static String eightteen = "eightteen";
	static String nineteen = "nineteen";
	static String twenty = "twenty";
	static String thirty = "thirty";
	static String fourty = "fourty";
	static String fifty = "fifty";
	static String sixty = "sixty";
	static String seventy = "seventy";
	static String eighty = "eighty";
	static String ninety = "ninety";
	
	
	
	public static void main(String[] args) {
		String total = "";
		total = total + ", " + one + ", " + two + ", " + three + ", " + four + ", " + five + ", " + six + ", " + seven + ", " + eight + ", " + nine + ", " + ten + ", " + eleven + ", " + twelve + ", " + thirteen + ", " + fourteen + ", " + fifteen + ", " + sixteen + ", " + seventeen + ", " + eightteen + ", " + nineteen + ", " +twenty;
		for(int i = 21; i < 1000; i++){
			System.out.println(total);
		}

	}

}
