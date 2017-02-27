package coditum.BinarySearchTree;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Tester <T>{
	static boolean running;
	static Integer[] data = new Integer[]{50,12,75,6,25,63,90};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		running = true;
		BalancedBinarySearchTree<Integer> tree = new BalancedBinarySearchTree<Integer>();
		for(int i = 0; i < data.length; i++){
			tree.insert(data[i]);
		}
		while(running){
			String temp;
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			tree.treePrint();
			temp = scan.next();
			if(temp.equals("stop")){
				running = false;
			}
			else{
				tree.insert(Integer.parseInt(temp));
			}
			
		}
		
	}
}
