package summer2014_2015;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class Collectibles extends Rectangle{
	static ImageIcon coin = new ImageIcon("DMANCOINBISH.png");
	public static void Spawn(Component c, Graphics g){
		Random rand = new Random();
		int x=rand.nextInt(100)+10;
		for(int hj=0; hj<x; hj++){
			coin.paintIcon(c, g, rand.nextInt(14000)+10,rand.nextInt(800)+700);
		}
	}
}
