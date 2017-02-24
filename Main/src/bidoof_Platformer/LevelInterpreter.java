package bidoof_Platformer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LevelInterpreter {
	private BufferedReader read;
	private BufferedWriter write;
	private ArrayList level;
	private String path;
	public LevelInterpreter(String path) throws IOException{
		read = new BufferedReader(new FileReader(path));
		level = new ArrayList();
		String line = "";
		this.path = path;
		int lvlCt = 0;
		while(!((line = read.readLine()) == null)){
			if(line.charAt(0) == '&'){
				level.add(new ArrayList());
			}
		}
		levelRecreator();
	}
	public void levelRecreator() throws IOException{
		read = new BufferedReader(new FileReader(path));
		String line = "";
		int currLvl = 0;
		while(!((line = read.readLine()) == null)){
			ArrayList lvl = (ArrayList) level.get(currLvl);
			int width = 0;
			int height = 0;
			int x = 0;
			int y = 0;
			int x2 = 0;
			int y2 = 0;
			int i;
			int z;
			int a;
			int p;
			int o;
			for(i = 3; i < line.length(); i++){
				if(line.charAt(i) == ','){
					width = Integer.parseInt(line.substring(3, i));
					break;
				}
			}
			for(z = i+2; z < line.length(); z++){
				if(line.charAt(z) == ','){
					height = Integer.parseInt(line.substring(i+2, z));
					break;
				}
			}
			for(a = z+2; a < line.length(); a++){
				if(line.charAt(a) == ','){
					x = Integer.parseInt(line.substring(z+2, a));
					break;
				}	
			}
			for(p = a+2; p < line.length(); p++){
				if(line.charAt(p) == ','){
					y = Integer.parseInt(line.substring(a+2, p));
					break;
				}
			}
			if(line.charAt(0) == 'C'){
				for(o = p+2; o < line.length(); o++){
					if(line.charAt(o) == ','){
						x2 = Integer.parseInt(line.substring(p+2, o));
						break;
					}
				}
				for(int u = o+2; u < line.length(); u++){
					if(line.charAt(u) == ','){
						y2 = Integer.parseInt(line.substring(o+2, u));
						break;
					}
				}
			}
			if(line.charAt(0) == 'B'){
				lvl.add(new Tile(0, width, height, x, y));
			}
			if(line.charAt(0) == 'L'){
				lvl.add(new Tile(1, width, height, x, y));
			}
			if(line.charAt(0) == 'C'){
				lvl.add(new Checkpoint(2, width, height, x, y, x2, y2));
			}
			if(line.charAt(0) == 'G'){
				lvl.add(new Tile(3, width, height, x, y));
			}
			
		}
	}
	public void printLevel(ArrayList lvl){
		for(int i = 0; i < lvl.size(); i++){
			for(int z = 0; z < ((ArrayList) lvl.get(i)).size(); z++){
				Tile temp = (Tile) ((ArrayList) lvl.get(i)).get(z);
				if(temp.getState() == 0){
					System.out.println("Block: "+temp.getWidth()+", "+temp.getHeight()+", "+temp.getX()+", "+temp.getY());
				}
				if(temp.getState() == 1){
					System.out.println("Lava: "+temp.getWidth()+", "+temp.getHeight()+", "+temp.getX()+", "+temp.getY());
				}
				if(temp.getState() == 2){
					System.out.println("Checkpoint: "+temp.getWidth()+", "+temp.getHeight()+", "+temp.getX()+", "+temp.getY()+", "+((Checkpoint)temp).getSpawnX()+", "+((Checkpoint)temp).getSpawnY());
				}
				if(temp.getState() == 3){
					System.out.println("Goal: "+temp.getWidth()+", "+temp.getHeight()+", "+temp.getX()+", "+temp.getY());
				}
			}
		}
	}
	public ArrayList levels(){
		return level;	
	}

}