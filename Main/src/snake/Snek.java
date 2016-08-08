package snake;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snek extends JFrame {
	//initializes the objects for the title page image and body image
	ImageIcon titl=new ImageIcon("resources/snek/TitlePageForSnek.png");
	ImageIcon head=new ImageIcon("resources/snek/SnekHeadOG.png");
	//Controls the snake's movement
	int velX=0;
	int velY=0;
	int score;
	int gameState=0;
	int turned=0;
	//Keeps track of the previous direction to avoid the snake turning back into itself
	String lastDir="";
	Pellet tellep=new Pellet((int)Math.ceil(Math.random()*85)*20,(int)Math.ceil(Math.random()*45)*20);
	LinkedList<BodySeg> body=new LinkedList<BodySeg>();
	public static void main(String[] args) {
		new Snek();
	}

	public Snek(){
		//adds starting body pieces
		body.add(new BodySeg(500,500));
		body.add(new BodySeg(480,500));
		body.add(new BodySeg(460,500));
		body.add(new BodySeg(440,500));
		JPanel pane = new JPanel(){
			public void paint(Graphics g){
				turned=0;
				System.out.println(turned);
				if(gameState==0){

					titl.paintIcon(this, g, 0, 0);

				}


				if(gameState==2){
					g.fillRect(0, 0, 10000, 10000);
					g.setColor(Color.RED);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
					g.drawString("You LOSE!", 630, 300);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					g.drawString("Press ESC. to quit or ENTER to Restart", 430, 360);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
					g.drawString("Your Score Was: "+ score, 700, 440);
				}
				//In game code
				if(gameState==1){
					g.setColor(Color.GREEN);
					g.fillRect(0, 0,230890, 7421);
					for(int i=0; i<body.size(); i++){
						head.paintIcon(this, g, body.get(i).getX(),body.get(i).getY());
					}
					g.setColor(Color.YELLOW.darker());
					g.drawRect(body.get(0).getX(), body.get(0).getY(), 20, 20);
					g.setColor(new Color(226,104,237));
					g.fillOval(tellep.getX(), tellep.getY(), tellep.getWidth(), tellep.getHeight());
					g.setColor(new Color(46, 184, 46));
					g.drawOval(tellep.getX(), tellep.getY(), tellep.getWidth(), tellep.getHeight());





					if(velX>0){
						lastDir="right";

					}
					if(velX<0){
						lastDir="left";

					}
					if(velY<0){
						lastDir="up";

					}
					if(velY>0){
						lastDir="down";
					}
					for(int i=0; i<body.size(); i++){
						if(i>0&&(velX!=0||velY!=0)){
							body.get(i).setpX(body.get(i).getX());
							body.get(i).setpY(body.get(i).getY());
							body.get(i).setX(body.get(i-1).getpX());
							body.get(i).setY(body.get(i-1).getpY());
						}
						else{

							body.get(i).move(velX,velY);

						}
					}
					
					checkCollision();
					setTitle("SpoopS: Snek2000 :SpoopS| Score: "+score);
				}






				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			
			}
		};
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(pane);
		setBounds(100,50,0,0);
		pane.setPreferredSize(new Dimension(1720,920));
		pack();
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER&&gameState==0){
					gameState=1;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER&&gameState==2){
					gameState=1;
					score=0;
					for(int i=body.size(); i>0; i--){
						body.removeLast();
					}
					velX=0;
					velY=0;
					body.add(new BodySeg(500,500));
					body.add(new BodySeg(480,500));
					body.add(new BodySeg(460,500));
					body.add(new BodySeg(440,500));
				}
				if(gameState==1){
					if(arg0.getKeyCode()==KeyEvent.VK_RIGHT&&!lastDir.equals("left")&&turned==0){
						velX=20;
						velY=0;
						lastDir="right";
						turned=1;
					}
					if(arg0.getKeyCode()==KeyEvent.VK_LEFT&&!lastDir.equals("right")&&turned==0){
						velX=-20;
						velY=0;
						lastDir="left";
						turned=1;
					}
					if(arg0.getKeyCode()==KeyEvent.VK_UP&&!lastDir.equals("down")&&turned==0){
						velY=-20;
						velX=0;
						lastDir="up";
						turned=1;
					}
					if(arg0.getKeyCode()==KeyEvent.VK_DOWN&&!lastDir.equals("up")&&turned==0){
						velY=20;
						velX=0;
						lastDir="down";
						turned=1;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}




		});

	}
	public void checkCollision(){
		for(int i=body.size()-1; i>0; i--){
			if(body.get(0).getX()==body.get(i).getpX()&&body.get(0).getY()==body.get(i).getY()){
				gameState=2;
			}
		}
		if(body.get(0).getX()<0||body.get(0).getY()<0||body.get(0).getX()>1720||body.get(0).getY()>920){
			gameState=2;
		}
			
		if(body.get(0).getX()==tellep.getX()&&body.get(0).getY()==tellep.getY()){
			tellep.spawnPellet();
			for(int i=0; i<body.size(); i++){
				while(tellep.getX()==body.get(i).getX()||tellep.getY()==body.get(i).getY()){
					tellep.spawnPellet();
					System.out.println("It actually happened");
				}
			}
			body.add(new BodySeg(body.get(body.size()-1).getX()-velX, body.get(body.size()-1).getY()-velY));
			body.add(new BodySeg(body.get(body.size()-1).getX()-velX, body.get(body.size()-1).getY()-velY));
			score=score+2;
		}



	}
}
