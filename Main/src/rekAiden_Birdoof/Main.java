package rekAiden_Birdoof;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	ImageIcon character;
	String direction;
	int binary;
	int inary;
	boolean jump;
	boolean right;
	boolean left;
	Player plr;
	int currentLvl=0;
	public static void main(String[] args) {
		new Main();

	}
	public Main(){
		right=false;
		jump=false;
		left=false;
		direction="Right";
		int ctr=0;
		character=new ImageIcon("resources/platformer/BidoofIdleRight0.png");
		binary=0;
		boolean game=true;
		plr=new Player(100,900,20,40);
		JPanel pane=new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(242, 242, 242));
				g.fillRect(-10, -10, 10000, 10000);

				character.paintIcon(this, g ,plr.getxPos(), plr.getyPos());
				g.setColor(new Color(142, 206, 94));
				for(int i=0; i<Level.LIST[currentLvl].length; i++){
					g.fillRect( Level.LIST[currentLvl][i].getX(),  Level.LIST[currentLvl][i].getY(),  Level.LIST[currentLvl][i].getWidth(), Level.LIST[currentLvl][i].getHeight());
				}
			}
		};
		setVisible(true);
		pane.setPreferredSize(new Dimension(1900,1000));
		setBounds(0,0,1920,1000);
		add(pane);
		pack();
		
		setDefaultCloseOperation(3);
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

			}

			@Override
			public void keyTyped(KeyEvent e) {


			}

		});

		while(game){
			if(jump&&inary>0){
				plr.setVelY(-10);
				inary--;
			}
			if(right){
				direction="Right";
				character=new ImageIcon("resources/platformer/BidoofIdleRight"+binary+".png");	
				plr.setVelX(3);
			}
			else if(!right){
				character=new ImageIcon("resources/platformer/BidoofIdle"+direction+binary+".png");	
				plr.setVelX(0);
			}
			if(left){
		 		direction="Left";
				character=new ImageIcon("resources/platformer/BidoofIdleLeft"+binary+".png");	
				plr.setVelX(-3);
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
			collision();
			if(plr.getVelY()<5&&ctr%3==0){
				plr.setVelY(plr.getVelY()+1);
			}
			plr.setxPos(plr.getxPos()+plr.getVelX());
			plr.setyPos(plr.getyPos()+plr.getVelY());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ctr++;
			System.out.println(ctr);
			repaint();

		}
	}
	public void collision(){
		for(int i=0; i<Level.LIST[currentLvl].length; i++){
			if(plr.getxPos()>Level.LIST[currentLvl][i].getX()-44&&plr.getVelX()<Level.LIST[currentLvl][i].getX()+Level.LIST[currentLvl][i].getWidth()&&plr.getyPos()+30>Level.LIST[currentLvl][i].getY()&&plr.getyPos()+30<Level.LIST[currentLvl][i].getY()+1){
				plr.setyPos(plr.getyPos()-5);
				inary=1;
			}
			else if(plr.getxPos()>Level.LIST[currentLvl][i].getX()-44&&plr.getVelX()<Level.LIST[currentLvl][i].getX()+Level.LIST[currentLvl][i].getWidth()&&plr.getyPos()+30>Level.LIST[currentLvl][i].getY()&&plr.getyPos()+30<Level.LIST[currentLvl][i].getY()+6){
				plr.setyPos(plr.getyPos()-5); 
				inary=1;
			}
			if(plr.getxPos()+45>Level.LIST[currentLvl][i].getX()&&plr.getxPos()+45<Level.LIST[currentLvl][i].getX()+4){
				plr.setxPos(plr.getxPos()-3);
			}
		}
		
	}

}
