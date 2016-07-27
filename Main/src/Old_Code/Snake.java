package Old_Code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Snake {
	static int oldDirection;
	static int m=1;
	static int for1;
	static int for2;
	static int points;
	static JFrame frame;
	static JPanel panel;
	static boolean W=false;
	static boolean S=false;
	static boolean D=false;
	static boolean A=false;
	static int R;
	static int direction = 0;
	static Random rand = new Random();
	static int x = (int)(Math.random()*69);
	static int y = (int)(Math.random()*39);
	static int size=1;
	static int[] cord;
	static int mousex;
	static int mousey;
	static boolean END;
	public static void main(String[] args) {
		ArrayList<int[]> snake = new ArrayList<int[]>();
		snake.add(new int[] {700,380});
		panel = new JPanel(){
			public void paint(Graphics g){
				g.fillRect(0,0,1440,820);
				g.setColor(Color.YELLOW);
				g.setFont(new Font(null,Font.PLAIN,25));
				if(END){
					g.drawString("What a twist!",609,391);
					g.drawString("Game Over", 609, 366);
					g.drawString("You scored: "+points, 600, 415);
					return;
				}
				for(int counter=snake.size() -1;counter>=0;counter--){
					cord = snake.get(counter);

					g.fillRect(cord[0],cord[1],20,20);
					g.setColor(Color.WHITE);
					g.drawString("Score", 656, 55);
					g.drawString(""+points,681,30);
				}
				g.fillRect(x*20,y*20,20,20);

			}
		};
		frame = new JFrame();
		frame.addKeyListener(new KeyListener(){


			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_H){
					END = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_O){
					System.out.println("");
					System.out.print(mousex+", "+mousey);
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					if(oldDirection!=2){
						direction=0;
						
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					if(oldDirection!=0){
						direction=2;
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					if(oldDirection!=1){
						direction=3;
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					if(oldDirection!=3){
						direction=1;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1440, 820);
		frame.setContentPane(panel);
		//0 is up 1 is right 2 is down 3 is left
		while(true){
			if(snake.get(snake.size()-1)[0]== 1420||snake.get(snake.size()-1)[1]== 800||snake.get(snake.size()-1)[1]== -20||snake.get(snake.size()-1)[0]== -20){
				END = true;
			}
			// PELLETS!
			if(snake.get(snake.size()-1)[0]== x*20&&snake.get(snake.size()-1)[1]== y*20){
				points++;
				x = (int)(Math.random()*69);
				y = (int)(Math.random()*39);
				if(direction==0){
					int[] last = snake.get(snake.size()-1).clone();
					last[1]=last[1]-20;
					snake.add(last);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}

				if(direction==2){
					int[] last = snake.get(snake.size()-1).clone();
					last[1]=last[1]+20;
					snake.add(last);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}		
				if(direction==1){
					int[] last = snake.get(snake.size()-1).clone();
					last[0]=last[0]+20;
					snake.add(last);
				}		
				if(direction==3){
					int[] last = snake.get(snake.size()-1).clone();
					last[0]=last[0]-20;
					snake.add(last);
				}		
				frame.repaint();
			}
			if(direction==0){
				int[] last = snake.get(snake.size()-1).clone();
				last[1]=last[1]-20;
				snake.add(last);
				snake.remove(0);
			}		
			else if(direction==2){
				int[] last = snake.get(snake.size()-1).clone();
				last[1]=last[1]+20;
				snake.add(last);
				snake.remove(0);
			}		
			else if(direction==1){
				int[] last = snake.get(snake.size()-1).clone();
				last[0]=last[0]+20;
				snake.add(last);
				snake.remove(0);
			}		
			else if(direction==3){
				int[] last = snake.get(snake.size()-1).clone();
				last[0]=last[0]-20;
				snake.add(last);
				snake.remove(0);
			}	
			oldDirection = direction;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.repaint();
			mousex = MouseInfo.getPointerInfo().getLocation().x;
			mousey = MouseInfo.getPointerInfo().getLocation().y;
			for(int X = snake.size()-2; 0 <= X; X--){
				int[] fenila = snake.get(X);
				if(snake.get(snake.size()-1)[0]== fenila[0]&&snake.get(snake.size()-1)[1]== fenila[1]){
					frame.repaint();
					END =true;
				}
			}
			if(END){
				return;
			}
			frame.repaint();
		}
	}

}