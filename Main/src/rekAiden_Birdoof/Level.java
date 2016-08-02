


package rekAiden_Birdoof;

import java.util.ArrayList;

public class Level {

	static Tile[][] LIST=new Tile[][]{
		new Tile[]{
				new Block(20,10000,0,0),
				new Block(10000,20,0,0),
				new Block(20,1000,1900,0),
				new Block(2000,40,0,980),
				//Borders
				new Block(200,40,400,940),
				//Spawn Platform
				new Block(150,20,20,620),
				new Block(20,520,170,120),
				
				//End Cage
				new Block(115,15,750,820),
				new Block(100,15,1025,700),
				new Block(100,15,1025,500),
				new Lava(100,15,1025,515),
				new Block(100,15,1400,800),
				new Lava(15,65,1500,750),
				new Lava(15,65,1500,580),
				new Block(100,15,1515,800),
				new Lava(1300,30,600,950),
				
		}
	};
}
