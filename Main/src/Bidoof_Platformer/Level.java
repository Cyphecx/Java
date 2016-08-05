
package Bidoof_Platformer;

import java.util.ArrayList;

public class Level {
	//Class for storing level data
	static Tile[][] LIST=new Tile[][]{
		new Tile[]{
				//Borders
				new Tile( 0,  20, 10000, 0, 0), 
				new Tile( 0,  10000, 20, 0, 0), 
				new Tile( 0,  20, 1000, 1900, 0), 
				new Tile( 0,  2000, 40, 0, 980), 
				//Spawn Platform
				new Tile( 0,  200, 40, 400, 940), 
				//End Cage
				new Tile(3, 40,40, 87, 550),
				new Tile( 0,  175, 20, 20, 620), 
				new Tile( 0,  20, 350, 195, 20), 
				new Tile( 0,  20, 170, 195, 470),
				new Tile( 1, 175, 20, 20, 600), 
				new Tile( 0,  75, 20, 70, 580), 
				//First Section
				new Tile( 0,  115, 15, 750, 820), 
				new Tile( 0,  100, 15, 1025, 700), 
				new Tile( 0,  100, 15, 1025, 500), 
				new Tile( 1, 100, 15, 1025, 515), 
				new Tile( 0,  115, 15, 1400, 800), 
				new Tile( 1, 15, 65, 1500, 735), 
				new Tile( 1, 15, 65, 1500, 550), 
				new Tile( 0,  250, 15, 1515, 800), 
				new Checkpoint(2,100,100,1400,440,1422,509),
				//Second Section
				
				new Tile( 0,  100, 15, 1025, 220),
				new Tile( 1, 815, 15, 215, 485), 
				new Tile( 0,  100, 15, 925, 220),
				new Tile( 0,  100, 15, 550, 320),
				new Tile( 0,  100, 15, 215, 470),
				new Tile( 0,  100, 15, 1225, 360),
				new Tile( 0,  900, 15, 215, 500),
				new Tile( 0,  20, 400, 1025, 100),
				new Tile( 0,  50, 15, 1850, 675), 
				new Tile( 0,  50, 15, 1850, 540), 
				new Tile( 0,  450, 15, 1300, 540), 
				new Tile( 1, 1300, 30, 600, 950), 
				
		}
	};
}
