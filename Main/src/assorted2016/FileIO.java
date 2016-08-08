package assorted2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File("resources/fileIO/Dictionary.txt")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("resources/fileIO/Pallendromes.wyatt")));
		String str="";
		ArrayList<String> pallendromes = new ArrayList<String>();
		while(!((str=reader.readLine()) == null)){
			if(isPallendrome(str.toCharArray())){
				pallendromes.add(str);
			}	
		}
		for(int i = 0; i < pallendromes.size(); i++){
			writer.write(pallendromes.get(i));
			writer.newLine();
			writer.flush();
			System.out.println(pallendromes.get(i));
		}
		writer.close();
	}
	
	public static boolean isPallendrome(char[] letters){
		boolean pallendrome=true;
		for(int i = 0; i < letters.length/2; i++){
			if(!(letters[i] == letters[(letters.length - 1) - i])){
			//	System.out.println(i+", "+((letters.length - 1) - i));
				return false;
			}
		}
		return true;
		
	}
}
