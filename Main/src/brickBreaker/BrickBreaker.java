package brickBreaker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BrickBreaker extends JFrame{
	//Creates ball object
	Ball ballota;
	Paddle pee;
	//Life Tracker
	int Balls=3;
	//Used to keep ball stationary for 150 ticks after respawn
	int counter=150;
	//Quantity of broken bricks
	int bB=0;
	int gameState=0;
	//Array for storing Brick information
	Brick[][] Bricks = new Brick[15][5];
	public static void main(String[] args){
		new BrickBreaker();

	}
	public BrickBreaker(){
		//Creates all the Bricks and gives them x and y positions
		for(int i=0; i<15; i++){

			for(int z=0; z<5; z++){
				Bricks[i][z]= new Brick(i*100+((i+3)*10),z*40+((z+2)*15));
			}

		}
		//initializes the ball
		ballota= new Ball(-8,8,840,550);
		pee= new Paddle(785);
		JPanel panel=new JPanel(){
			public void paint(Graphics g){
				//Checks if all Bricks have been destroyed
				if(bB==75){
					//Sets game to won state
					gameState=1;
				}
				if(Balls<0){
					gameState=2;
				}
				
				if(gameState==0){
					//Randomizes ball direction left or right on reset
					checkCollision();
					//If statement randomizes if the ball starts moving left or right on Respawn
					if(counter==150){
						double temp;
						temp=Math.ceil(Math.random()*10);
						if(temp>=6){
							ballota.setVelocityX(-4);
						}
						if(temp<=5){
							ballota.setVelocityX(4);
						}
					}
					setTitle("Balls Left:"+Balls);
					g.setColor(new Color(233,220,50));
					g.fillRect(0, 0, 1720, 905);
					g.setColor(Color.BLACK);
					//For Loops drawing each brick
					for(int i=0; i<15; i++){

						for(int z=0; z<5; z++){
							g.setColor(Color.WHITE);
							g.fillRect(Bricks[i][z].getX(), Bricks[i][z].getY(), Bricks[i][z].getWidth(), Bricks[i][z].getHeight());
							g.setColor(Color.BLACK);
							g.drawRect(Bricks[i][z].getX(), Bricks[i][z].getY(), Bricks[i][z].getWidth(), Bricks[i][z].getHeight());
						}

					}
					//Drawing ball and paddle
					g.setColor(Color.RED);
					g.fillOval(ballota.getX(), ballota.getY(), ballota.getWidth(), ballota.getHeight());
					g.setColor(Color.BLUE);
					g.drawOval(ballota.getX(), ballota.getY(), ballota.getWidth(), ballota.getHeight());
					g.fillRect(pee.getX(), pee.getY(), pee.getWidth(), pee.getHeight());

					//move functions applying velocity to paddle and ball
					if(pee.getVelocity()<0&&pee.getX()>0){
						pee.move();
					}
					else if(pee.getVelocity()>0&&pee.getX()<1570){
						pee.move();
					}
					if(counter<=0){
						ballota.move();
					}
					counter--;
				}
				//Win Screen 
				if(gameState==1){
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 10000, 10000);
					g.setColor(Color.YELLOW);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
					g.drawString("You WIN!", 630, 300);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					g.drawString("Press ESC. to quit or ENTER to Restart", 430, 360);
					
				}
				//Loss Screen
				if(gameState==2){
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 10000, 10000);
					g.setColor(Color.RED);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
					g.drawString("You LOSE!", 630, 300);
					g.setColor(Color.WHITE);
					g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
					g.drawString("Press ESC. to quit or ENTER to Restart", 430, 360);
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}

		};
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);

		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
				//paddle movement
				if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					pee.setVelocity(10);
				}
				if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					pee.setVelocity(-10);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				//paddle movement stop
				if(arg0.getKeyCode()==KeyEvent.VK_RIGHT){
					pee.setVelocity(0);
				}
				if(arg0.getKeyCode()==KeyEvent.VK_LEFT){
					pee.setVelocity(0);
				}
				if(arg0.getKeyCode()==KeyEvent.VK_Z){
					bB=75;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_X){
					Balls=-1;
				}
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					bB=0;
					gameState=0;
					Balls=3;
					ballota.setX(840);
					ballota.setY(550);
					counter=150;
					for(int i=0; i<15; i++){

						for(int z=0; z<5; z++){
							Bricks[i][z]= null;
						}

					}
					for(int i=0; i<15; i++){

						for(int z=0; z<5; z++){
							Bricks[i][z]= new Brick(i*100+((i+3)*10),z*40+((z+2)*15));
						}

					}
					repaint();
				}

			}

			@Override
			public void keyTyped(KeyEvent arg0) {


			}

		});
		setBounds(100,50,0,0);
		panel.setPreferredSize(new Dimension(1720,905));
		pack();
	}
	public void checkCollision(){
		//checks for ball past paddle
		if(ballota.getY()>=884){
			ballota.reset();
			Balls--;
			counter=150;
		}
		//checks collision with paddle
		if(ballota.getX()>pee.getX()&&ballota.getX()<pee.getX()+130&&ballota.getY()>=pee.getY()-20&&ballota.getY()<pee.getY()+5){
			ballota.flipVelocityY();
		}
		//right wall collision check
		if(ballota.getX()>=1700){
			ballota.flipVelocityX();

		}
		if(ballota.getX()<=0){
			ballota.flipVelocityX();
		}
		if(ballota.getY()<=0){
			ballota.flipVelocityY();
		}
		//Brick Collision Check
		for(int i=0; i<15; i++){

			for(int z = 0; z<5; z++){
				//Collision check on the bottom of the paddles
				if(ballota.getX()+10>=Bricks[i][z].getX()&&ballota.getX()<=Bricks[i][z].getX()+90&&ballota.getY()<=Bricks[i][z].getY()+40&&ballota.getY()>Bricks[i][z].getY()+30){
					ballota.flipVelocityY();
					Bricks[i][z].setY(1000000000);
					bB++;
					System.out.println("Bricks broken: "+bB);
				}
				//Collision on the top of the paddles
				if(ballota.getX()+10>=Bricks[i][z].getX()&&ballota.getX()<=Bricks[i][z].getX()+90&&ballota.getY()<=Bricks[i][z].getY()-12&&ballota.getY()>Bricks[i][z].getY()-21){
					ballota.flipVelocityY();
					Bricks[i][z].setY(1000000000);
					bB++;
					System.out.println("Bricks broken: "+bB);
				}
				//Collision check on the left of paddles
				if(ballota.getX()+10>=Bricks[i][z].getX()&&ballota.getX()<=Bricks[i][z].getX()&&ballota.getY()<=Bricks[i][z].getY()+12&&ballota.getY()>Bricks[i][z].getY()-12){
					ballota.flipVelocityX();
					Bricks[i][z].setY(1000000000);
					bB++;
					System.out.println("Bricks broken: "+bB);
				}
				//Collision check on the right of paddles
				if(ballota.getX()<=Bricks[i][z].getX()&&ballota.getX()>=Bricks[i][z].getX()-20&&ballota.getY()<=Bricks[i][z].getY()+12&&ballota.getY()>Bricks[i][z].getY()-12){
					ballota.flipVelocityX();
					Bricks[i][z].setY(1000000000);
					bB++;
					System.out.println("Bricks broken: "+bB);
				}



			}

		}
	}
}
