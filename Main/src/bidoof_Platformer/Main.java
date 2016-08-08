package bidoof_Platformer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	ImageIcon img;
	boolean dunworry = false;
	public static void main(String[] args) {
		new Main();

	}
	public Main(){
		// booleans to keep track if a movement button has been press
		right = false;
		jump = false;
		left = false;
		//x and y of current player spawnpoint 
		spawnX = 400;
		spawnY = 910;
		//direction tracking for animations and ctr to make things happen only so often
		direction = "Right";
		int ctr = 0;
		//game icon and imageIcon in which the character pngs are stored
		img  =   new ImageIcon("resources/platformer/Icon.png");
		character = new ImageIcon("resources/platformer/BidoofIdleRight0.png");
		// binary is used in animation to cycle between 0 and 1 
		binary = 0;
		//runs while game is true
		boolean game = true;
		// creates player object
		plr = new Player(400,910,30,45);
		JPanel pane = new JPanel(){
			// paint method
			public void paint(Graphics g){
				// draws background
				g.setColor(new Color(242, 242, 242));
				g.fillRect( 0, 0, 1920, 1000);
				// draws each type of object
					
				for(int i = 0; i<Level.LIST[currentLvl].length; i++){
					//Block
					if(Level.LIST[currentLvl][i].getState()==0){
						g.setColor(new Color(0, 85, 255));
						g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
					}
					//Lava
					if(Level.LIST[currentLvl][i].getState()==1){
						g.setColor(Color.RED);
						g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
					}
					//Checkpoint
					if(Level.LIST[currentLvl][i].getState() == 2){
						g.setColor(Color.GREEN);
						g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
					}
					//Goal
					if(Level.LIST[currentLvl][i].getState() ==3 ){
						g.setColor(Color.CYAN);
						g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
					}
				}
				//draws the character
				character.paintIcon(this, g ,plr.getxPos(), plr.getyPos());
			}
		};
		//uses maximizedBounds and Extended state to fit the window to the screen
		setMaximizedBounds(getMaximizedBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH );
		// sets the Icon
		setIconImage(img.getImage());
		setVisible(true);
		add(pane);
		setDefaultCloseOperation(3);
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
				//Left direction movement
				if(e.getKeyCode() ==  KeyEvent.VK_LEFT||e.getKeyCode() ==  KeyEvent.VK_A){
					left  =   true;
				}
				//Jumping keys
				if(e.getKeyCode() ==  KeyEvent.VK_UP||e.getKeyCode() ==  KeyEvent.VK_SPACE||e.getKeyCode() ==  KeyEvent.VK_W){
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
			else if(plr.getVelX() != 0&&ctr%15 ==  0&&inary ==  1){
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
			if(plr.getVelY()<8&&ctr%2 ==  0){
				plr.setVelY(plr.getVelY()+1);
			}
			plr.setxPos(plr.getxPos()+plr.getVelX());
			if(dunworry){
				plr.setyPos(plr.getyPos()+plr.getVelY());
			}
			//collision for top and bottom sides of blocks called
			collision();
	
			try {
				Thread.sleep(13);
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
		//in majority the if statements are the same its what they run based on the object that differs
				//for loop runs through each object in the constant level list
		for(int i = 0; i<Level.LIST[currentLvl].length; i++){
			//keeps track of current object to make if statements much shorter
			Tile obj = Level.LIST[currentLvl][i];
			//blocks
			if(obj.getState()==0){
				if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
					plr.setyPos(obj.getY()+obj.getHeight());
					plr.setVelY(0);
					//bottom
				}
				if(plr.getyPos() + plr.getVelY() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
					dunworry = false;
					plr.setyPos( obj.getY()-30);
					inary = 1;
					//top
				}
				else{
					dunworry = true;
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
					dunworry = true;
				}
				//checkpoints
				if(obj.getState() == 2){
					if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
						spawnX=(int)((Checkpoint) obj).getSpawnX();
						spawnY=(int)((Checkpoint) obj).getSpawnY();
						//bottom11
					}
					if(plr.getyPos() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 44 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
						spawnX=(int)((Checkpoint) obj).getSpawnX();
						spawnY=(int)((Checkpoint) obj).getSpawnY();
						//top
					}
					else{
						dunworry = true;
					}
				}
			}
		}
	}
	public void collisionLR(){
		//in majority the if statements are the same its what they run based on the object that differs
				//for loop runs through each object in the constant level list
		for(int i = 0; i<Level.LIST[currentLvl].length; i++){
			//keeps track of current object to make if statements much shorter
			Tile obj  =  Level.LIST[currentLvl][i];
			//blocks
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
			
		}
	}
}