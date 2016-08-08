package summer2014_2015;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File Thing = new File("Thing.txt");
		File Thing2 = new File("Thing2.txt");
		BufferedReader reader = new BufferedReader(new FileReader(Thing));
		BufferedWriter writer2 = new BufferedWriter(new FileWriter(Thing2));
		String r=reader.readLine();
		while(r != null){
			if(r.length()>4){
				writer2.write(r);
				writer2.newLine();
			}
			r=reader.readLine();
		}
		writer2.write("\n");
		writer2.close();
	}

}
