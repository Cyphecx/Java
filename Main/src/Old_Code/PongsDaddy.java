package Old_Code;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class PongsDaddy{
	static JFrame frame;
	static JPanel panel;
	static int S = 1;
	static int x = 5;
	static int y = 10;
	static int D = S;
	static int X = S;
	static int f = 150;
	static int c = 150;
	static boolean H= false;
	static boolean W= false;
	static boolean V= false;
	static boolean R= false;
	static int mousex;
	static int mousey;
	static int L;
	static int P;
	static int O = st.Prompt.getInt("What do you want to play to?");
	static boolean end;
	public static void main(String[] args) {
		panel = new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color (0,0,0));
				g.fillRect(0,0,400,400);
				g.setColor(new Color (255,255,255));
				g.fillRect(5, c, 10, 100);
				g.fillRect(385, f, 10, 100);
				g.setColor(new Color (0,255,0));
				g.fillOval(x= x+S,y=y+D, 25, 25);
				g.setColor(new Color(0,0,0));
				g.setFont(new Font(null,Font.PLAIN,25));
				g.setColor(new Color(230,255,0));
				g.fillRect(0 ,400, 400, 100);
				g.setColor(new Color(0,0,0));
				g.drawString(""+L,15,436);
				g.drawString(""+P,370,436);
				g.drawString("Score", 163, 442);
				g.drawString("First to "+O+" wins!",111,467);
				g.setColor(new Color(0,0,255));
				if(P == O){
					g.drawString("Right side player wins!",75,20);				
					end = true;
				}
				if(L == O){
					g.drawString("Left side player wins!",75,20);
					end = true;
				}
			}
		};
		frame = new JFrame();
		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_O){
					System.out.println("");
					System.out.print(mousex+", "+mousey);
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					R = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					V = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_W){
					W = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_S){
					H = true;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_W){
					W = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_S){
					H = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_UP){
					R = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					V = false;
				}
			}

		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 500);
		frame.setContentPane(panel);
		while(true){
			if(end==true){
				return;
			}
			if(x <=0){
				P++;
				frame.repaint();
				x = 185;
				y = 185;
				c = 150;
				f = 150;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(x >= 375){
				L++;
				frame.repaint();
				x = 185;
				y = 185;
				c = 150;
				f = 150;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(x == 360 && y < f+100 && y > f){
				S = -X;
			}
			if(x == 15 && y < c+100 && y>c){
				S = X;
			}
			if(x >= 375){
				S = -X;
			}
			if(y >= 375){
				D = -X;
			}
			if(x <= 0){
				S = X;
			}
			if(y <= 0){
				D = X;
			}
			frame.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(c < 1){
				W=false;
			}
			if(c > 299){
				H=false;
			}
			if(f < 1){
				R=false;
			}
			if(f > 299){
				V=false;
			}

			if(H){
				c=c+2;
			}
			if(W){
				c=c-2;
			}
			if(V){
				f=f+2;
			}
			if(R){
				f=f-2;
			}
			mousex = MouseInfo.getPointerInfo().getLocation().x;
			mousey = MouseInfo.getPointerInfo().getLocation().y;
		}
		
	}

}