


package rekAiden_Birdoof;

import java.util.ArrayList;

public class Level {

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
				new Tile( 0,  150, 20, 20, 620), 
				new Tile( 0,  20, 520, 170, 120), 
				new Tile( 1, 150, 20, 20, 600), 
				new Tile( 0,  75, 20, 57, 580), 
				//First Section
				new Tile( 0,  115, 15, 750, 820), 
				new Tile( 0,  100, 15, 1025, 700), 
				new Tile( 0,  100, 15, 1025, 500), 
				new Tile( 1, 100, 15, 1025, 515), 
				new Tile( 0,  115, 15, 1400, 800), 
				new Tile( 1, 15, 65, 1500, 735), 
				new Tile( 1, 15, 65, 1500, 550), 
				new Tile( 0,  250, 15, 1515, 800), 
				
				new Tile( 0,  50, 15, 1850, 675), 
				new Tile( 0,  50, 15, 1850, 540), 
				new Tile( 0,  450, 15, 1300, 540), 
				new Tile( 1, 1300, 30, 600, 950), 
				
		}
	};
}
