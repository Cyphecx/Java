package bidoof_Platformer;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	ImageIcon character;
	String direction;
	int binary;
	int rawr;
	int inary;
	boolean jump;
	boolean right;
	boolean left;
	Player plr;
	int currentLvl = 0;
	Color rand;
	static int spawnX;
	static int spawnY;
	ImageIcon icon;
	ArrayList<ArrayList> level;
	boolean move = false;
	public Main() throws IOException{
		// booleans to keep track if a movement button has been press
		right = false;
		jump = false;
		left = false;
		//retrieves level data from level files and assigns that to an ArrayList
		LevelInterpreter interp = new LevelInterpreter("resources/platformer/level.lvl");
		level = interp.levels();
		//x and y of current player spawnpoint 
		spawnX = 400;
		spawnY = 910;
		//direction tracking for animations and ctr to make animations and other time dependant things happen only so often
		direction = "Right";
		int ctr = 0;
		//game icon and imageIcon in which the character pngs are stored
		icon  =   new ImageIcon("resources/platformer/Icon.png");
		character = new ImageIcon("resources/platformer/BidoofIdleRight0.png");
		// binary is used in animations to cycle between 2 different case scenarios
		binary = 0;
		//runs while game is true
		boolean game = true;
		// creates player object
		plr = new Player(400,910,30,45);
		//Creates JPanel
		JPanel panel = new JPanel(){
			// paint method
			public void paint(Graphics g){
				// draws background
				g.setColor(new Color(242, 242, 242));
				g.fillRect( 0, 0, 1920, 1000);
				// Draws all objects
					
				for(int i = 0; i < level.get(currentLvl).size(); i++){
					//Block
					Tile currTile = (Tile) level.get(currentLvl).get(i);
					if(((Tile) currTile).getState()== 0){
						g.setColor(new Color(0, 85, 255));
						g.fillRect( currTile.getX(), currTile.getY(), currTile.getWidth(), currTile.getHeight());
					}
					//Lava
					if(currTile.getState()== 1){
						g.setColor(Color.RED);
						g.fillRect( currTile.getX(), currTile.getY(), currTile.getWidth(), currTile.getHeight());
					}
					//Checkpoint
					if(currTile.getState() == 2){
						g.setColor(Color.GREEN);
						g.fillRect( currTile.getX(), currTile.getY(), currTile.getWidth(), currTile.getHeight());
					}
					//Goal
					if(currTile.getState() == 3 ){
						g.setColor(Color.CYAN);
						g.fillRect( currTile.getX(), currTile.getY(), currTile.getWidth(), currTile.getHeight());
					}
				}
				//draws the character
				character.paintIcon(this, g ,plr.getxPos(), plr.getyPos());
			}
		};
		//uses maximizedBounds and Extended state to fit the window to the screen
		setMaximizedBounds(getMaximizedBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH );
		// sets the Icon for the top left and the task bar
		setIconImage(icon.getImage());
		setVisible(true);
		add(panel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				// allows the game to close
				if(e.getKeyCode() ==  KeyEvent.VK_ESCAPE){
					System.exit(1);
				}
				//Right directional movement keys
				if(e.getKeyCode() ==  KeyEvent.VK_RIGHT||e.getKeyCode() ==  KeyEvent.VK_D){
					right = true;
				}
				if(e.getKeyCode() ==  KeyEvent.VK_W){
					plr.setyPos(200);
				}
				//Left direction movement
				if(e.getKeyCode() ==  KeyEvent.VK_LEFT||e.getKeyCode() ==  KeyEvent.VK_A){
					left  =   true;
				}
				//Jumping keys
				if(e.getKeyCode() ==  KeyEvent.VK_UP||e.getKeyCode() ==  KeyEvent.VK_SPACE){
					jump = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//Stops right directional movement
				if(e.getKeyCode() ==  KeyEvent.VK_RIGHT||e.getKeyCode() ==  KeyEvent.VK_D){
					right = false;
				}
				//Stops left direction movement
				if(e.getKeyCode() ==  KeyEvent.VK_LEFT||e.getKeyCode() ==  KeyEvent.VK_A){
					left = false;
				}
				//Stops jumping
				if(e.getKeyCode() ==  KeyEvent.VK_UP||e.getKeyCode() ==  KeyEvent.VK_SPACE||e.getKeyCode() ==  KeyEvent.VK_W){
					jump = false;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		while(game){
			//jumping velocity set here
			if(jump&&inary>0){
				plr.setVelY(-12);
				inary--;
			}
			//sets animation to right running and velocityX to right
			if(right){
				direction = "Right";
				character = new ImageIcon("resources/platformer/BidoofIdleRight"+binary+".png");	
				plr.setVelX(4);
			}
			//sets animation to left running and velocityX to left
			if(left){
				direction = "Left";
				character = new ImageIcon("resources/platformer/BidoofIdleLeft"+binary+".png");	
				plr.setVelX(-4);
			}
			//Makes sure velocityX is stopped when keys are released
			else if(!left&&!right){
				character = new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
				plr.setVelX(0);
			}
			//idle animations happening
			if(plr.getVelX() ==  0&&ctr%25 ==  0&&inary ==  1){
				//binary var is flip-flopped
				if(binary ==  0){
					binary = 1;
				}
				else{
					binary = 0;
				}
				// character is updated to new image 
				character = new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
			}
			// running animations
			else if(plr.getVelX() != 0&&ctr%20 ==  0&&inary ==  1){
				//flip flops binary
				if(binary ==  0){
					binary = 1;
				}
				else{
					binary = 0;
				}
				//charater is updated to new image
				character = new ImageIcon("resources/platformer/Bidoof"+direction+binary+".png");
			}
			//collision for left and right sides of blocks called
			collisionLR();
			//velocities added to x and y values
			if(plr.getVelY() < 8 && ctr % 2 ==  0){
				plr.setVelY(plr.getVelY()+1);
			}
			plr.setxPos(plr.getxPos()+plr.getVelX());
			if(move){
				plr.setyPos(plr.getyPos()+plr.getVelY());
			}
			//collision for top and bottom sides of blocks called
			collision();
	
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ctr++;
			//System.out.println(ctr);
			repaint();
		}
	}
	public void collision(){
		//Checks for collision with various tile types and runs certain commands
				//for loop runs through each object in the constant level list
		for(int i = 0; i < level.get(currentLvl).size(); i++){
			//keeps track of current object to make if statements much shorter
			Tile obj = (Tile) level.get(currentLvl).get(i);
			//blocks
			if(obj.getState()==0){
				
				if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
					plr.setyPos(obj.getY()+obj.getHeight());
					plr.setVelY(0);
					//bottom
				}
				if(plr.getyPos() + plr.getVelY() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
					move = false;
					plr.setyPos( obj.getY()-30);
					inary = 1;
					//top
				}
				else{
					move = true;
				}
			}
			//lava
			if(obj.getState() == 1){
				if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
					plr.setxPos(spawnX);
					plr.setyPos(spawnY);
					plr.setVelY(0);
					plr.setVelX(0);
					//bottom11
				}
				if(plr.getyPos() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
					plr.setxPos(spawnX);
					plr.setyPos(spawnY);
					plr.setVelY(0);
					plr.setVelX(0);
					//top
				}
				else{
					move = true;
				}
			}
			//checkpoints
			if(obj.getState() == 2){
				if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
					spawnX=(int)((Checkpoint) obj).getSpawnX();
					spawnY=(int)((Checkpoint) obj).getSpawnY();
					//bottom
				}
				if(plr.getyPos() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
					spawnX=(int)((Checkpoint) obj).getSpawnX();
					spawnY=(int)((Checkpoint) obj).getSpawnY();
					//top
				}
				else{
					move = true;
				}
			}
	
			//checkpoints
			if(obj.getState() == 3){
				System.out.println(plr.getyPos() < obj.getY() + obj.getHeight());
				System.out.println(plr.getyPos() > obj.getY() + obj.getHeight() - 9);
				System.out.println(plr.getxPos() < obj.getX() + obj.getWidth());
				System.out.println(plr.getxPos() + 45 > obj.getX() );
				if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
					currentLvl++;
					//bottom
				}
				if(plr.getyPos() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
					currentLvl++;
					//top
				}
			}
		}
	}
	public void collisionLR(){
		for(int i = 0; i < level.get(currentLvl).size(); i++){
			//keeps track of current object to make if statements much shorter
			Tile obj  =  (Tile) level.get(currentLvl).get(i); 
			if(obj.getState() == 0){
				if(plr.getxPos()+plr.getVelX() + 44 > obj.getX() && plr.getxPos()+plr.getVelX() + 44 < obj.getX() + 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos () < obj.getY() + obj.getHeight() ){
					plr.setxPos(plr.getxPos() - 4);
					//left
				}
				if(plr.getxPos()+plr.getVelX() < obj.getX() + obj.getWidth() && plr.getxPos()+plr.getVelX() > obj.getX() + obj.getWidth() - 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos() < obj.getY() + obj.getHeight() ){
					plr.setxPos(plr.getxPos() + 4);
					//right
				}
			}
			//lava
			if(obj.getState() == 1){
				if(plr.getxPos() + 44 > obj.getX() && plr.getxPos() + 44 < obj.getX() + 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos () < obj.getY() + obj.getHeight() ){
					plr.setxPos(spawnX);
					plr.setyPos(spawnY);
					plr.setVelY(0);
					plr.setVelX(0);
					//left 
				}
				if(plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() > obj.getX() + obj.getWidth() - 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos() < obj.getY() + obj.getHeight() ){
					plr.setxPos(spawnX);
					plr.setyPos(spawnY);
					plr.setVelY(0);
					plr.setVelX(0);
					//right
				}
			}
			//checkpoint
			if(obj.getState() == 2){
				if(plr.getxPos() + 44 > obj.getX() && plr.getxPos() + 44 < obj.getX() + 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos () < obj.getY() + obj.getHeight() ){
					spawnX=(int)((Checkpoint) obj).getSpawnX();
					spawnY=(int)((Checkpoint) obj).getSpawnY();
					//left 
				}
				if(plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() > obj.getX() + obj.getWidth() - 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos() < obj.getY() + obj.getHeight() ){
					spawnX=(int)((Checkpoint) obj).getSpawnX();
					spawnY=(int)((Checkpoint) obj).getSpawnY();
					//right
				}
			}
			if(obj.getState() == 3){
				if(plr.getxPos() + 44 > obj.getX() && plr.getxPos() + 44 < obj.getX() + 6 && plr.getxPos() + 44 < obj.getX() + 6&& plr.getyPos() < obj.getY() + obj.getHeight() ){
					currentLvl++;
					//left 
				}
				if(plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() > obj.getX() + obj.getWidth() - 6 && plr.getyPos() + 30 > obj.getY() && plr.getyPos() < obj.getY() + obj.getHeight() ){
					currentLvl++;
					//right
				}
			}
		}
	}
}