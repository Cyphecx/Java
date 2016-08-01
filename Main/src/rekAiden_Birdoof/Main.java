package rekAiden_Birdoof;

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
	int currentLvl=0;
	Color rand;
	ImageIcon img;
	boolean dunworry=false;
	public static void main(String[] args) {
		new Main();

	}
	public Main(){
		rawr=300;
		rand=new Color(142, 206, 94);
		right=false;
		jump=false;
		left=false;
		direction="Right";
		int ctr=0;
		img = new ImageIcon("resources/platformer/Icon.png");
		character=new ImageIcon("resources/platformer/BidoofIdleRight0.png");
		binary=0;
		boolean game=true;
		plr=new Player(600,920,20,40);
		JPanel pane=new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(242, 242, 242));
				g.fillRect(-10, -10, 10000, 10000);

				character.paintIcon(this, g ,plr.getxPos(), plr.getyPos());
				g.setColor(Color.BLACK);
				g.drawRect(plr.getxPos(), plr.getyPos(),45,30);
				g.setColor(rand);
				for(int i=0; i<Level.LIST[currentLvl].length; i++){
					g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
				}
			}
		};
		setMaximizedBounds(getMaximizedBounds());
		setExtendedState(JFrame.MAXIMIZED_BOTH );
		setIconImage(img.getImage());
		setVisible(true);
		add(pane);
		
		setDefaultCloseOperation(3);
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(arg0.getX()+", "+arg0.getY());
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		addKeyListener(new KeyListener(){
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(1);
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
					right=true;
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
					left = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_SPACE||e.getKeyCode()==KeyEvent.VK_W){
					jump=true;
				}
				if(e.getKeyCode()==KeyEvent.VK_O){
					rawr=1;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D){
					right=false;
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A){
					left=false;
				}
				if(e.getKeyCode()==KeyEvent.VK_UP||e.getKeyCode()==KeyEvent.VK_SPACE||e.getKeyCode()==KeyEvent.VK_W){
					jump=false;
				}
				if(e.getKeyCode()==KeyEvent.VK_O){
					rawr=300;
				}

			}

			@Override
			public void keyTyped(KeyEvent e) {


			}

		});

		while(game){
			if(jump&&inary>0){
				plr.setVelY(0);
				plr.setVelY(-12);
				inary--;
			}
			if(right){
				direction="Right";
				character=new ImageIcon("resources/platformer/BidoofIdleRight"+binary+".png");	
				plr.setVelX(4);
			}
			else if(!right){
				character=new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
				plr.setVelX(0);
			}
			if(left){
				direction="Left";
				character=new ImageIcon("resources/platformer/BidoofIdleLeft"+binary+".png");	
				plr.setVelX(-4);
			}
			else if(!left&&!right){
				character=new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
				plr.setVelX(0);
			}
			if((plr.getVelX()==0||plr.getVelY()<0)&&ctr%25==0&&inary==1){
				if(binary==0){
					binary=1;
				}
				else{
					binary=0;
				}
				character=new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
			}
			else if(plr.getVelX()!=0&&ctr%15==0&&inary==1){
				if(binary==0){
					binary=1;
				}
				else{
					binary=0;
				}
				character=new ImageIcon("resources/platformer/Bidoof"+direction+binary+".png");
			}
			
			if(plr.getVelY()<8&&ctr%2==0){
				plr.setVelY(plr.getVelY()+1);
			}
			plr.setxPos(plr.getxPos()+plr.getVelX());
			if(dunworry){
				plr.setyPos(plr.getyPos()+plr.getVelY());
			}
			if(ctr%rawr==0){
				rand=new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
			}
			collision();

			try {
				Thread.sleep(12);
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
		
		for(int i=0; i<Level.LIST[currentLvl].length; i++){
			Tile obj=Level.LIST[currentLvl][i];
			if(plr.getxPos() + 44 > obj.getX() && plr.getxPos() + 44 < obj.getX() + 6 && plr.getyPos () + 30 > obj.getY() && plr.getyPos () < obj.getY() + obj.getHeight() ){
				plr.setxPos(plr.getxPos()-4);
				//left wall

			}
			if(plr.getxPos() < obj.getX() + obj.getWidth()&& plr.getxPos() > obj.getX() + obj.getWidth() - 5 && plr.getyPos() + 29 > obj.getY() && plr.getyPos() + 29 < obj.getY() + obj.getHeight() ){
				plr.setxPos(plr.getxPos()+4);
				//right
			}
			if(plr.getyPos() < obj.getY() + obj.getHeight() && plr.getyPos() > obj.getY() + obj.getHeight() - 9 && plr.getxPos() < obj.getX() + obj.getWidth() && plr.getxPos() + 45 > obj.getX() ){
				plr.setyPos(obj.getY()+obj.getHeight());
				plr.setVelY(0);
				//bottom
			}
			if(plr.getyPos() + plr.getVelY() + 30 > obj.getY()&&plr.getyPos() + plr.getVelY() < obj.getY() && plr.getxPos() + 45 > obj.getX() && plr.getxPos() < obj.getX() + obj.getWidth()){
				dunworry=false;
				plr.setyPos( obj.getY()-30);
				inary=1;
				//top
			}
			else{
				dunworry=true;
			}
			



		}

	}

}
