package summer2014_2015;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class cPong extends JFrame implements KeyListener{
	int p1y=400;
	int p2y=400;
	boolean up1=false;
	boolean up2=false;
	boolean down1=false;
	boolean down2=false;
	int ballx=720;
	int bally=425;
	int bxm=-5;
	int bym=5;
	int p1s;
	int p2s;
	ImageIcon ball = new ImageIcon("resources/cPong/ball.png");
	public static void main(String[] args){
		new cPong(); 
	}

		JPanel panel;
		public cPong(){
			setTitle("Paint:Spoops");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setSize(1440, 900);
			addKeyListener(this);
			setResizable(true);
			panel = new JPanel(){
				public void paint(Graphics g){
					g.setColor(new Color(0,0,25));
					g.fillRect(0,0,1440,900); 
					g.setColor(new Color(255,255,255));
					g.fillRect(30,p1y, 15, 100);
					g.fillRect(1390,p2y, 15, 100);
					g.setColor(Color.GREEN);
					g.fillOval( ballx, bally, 25 ,25);
					g.drawString(p1s+" || "+p2s, 680, 30);
					if(up1&&p1y>15){
						p1y-=10;
					}
					if(up2&&p2y>15){
						p2y-=10;
					}
					if(down1&&p1y<750){
						p1y+=10;
					}
					if(down2&&p2y<750){
						p2y+=10;
					}
					
					
					if(bally<1){
						bym+=bym*-2;
					}
					if(bally>825){
						bym-=bym*2;
					}
					if(ballx<46&&ballx>30&&p1y<bally&&bally<p1y+100){
						bxm=(int) (Math.random()*6)+4;
					}
					if(ballx+25>1390&&ballx+25<1405&&p2y<bally&&bally<p2y+100){
						bxm=(int) (Math.random()*-6)-4;
					}
					if(ballx<0&&(p1y+100<=bally||bally-12<=p1y)){
						bxm=0;
						bym=0;
						p2s++;
						ballx=720;
						bally=425;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						bxm=5;
						bym=-5;
					}
					if(ballx+25>1420&&(p2y+100<=bally||bally-12<=p2y)){
						bxm=0;
						bym=0;
						p1s++;
						ballx=720;
						bally=425;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						bxm=-5;
						bym=5;
					}
					bally+=bym;
					ballx+=bxm;
					repaint();
					try {
						Thread.sleep(15 );
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				}
			};
			add(panel);
			panel.setPreferredSize(new Dimension(1440,900));	
		}
		
	


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			System.exit(0);
		}	
		if(e.getKeyCode()==KeyEvent.VK_W){
			up1=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			down1=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			up2=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down2=true;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {	
		if(e.getKeyCode()==KeyEvent.VK_W){
			up1=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			down1=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			up2=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			down2=false;
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
