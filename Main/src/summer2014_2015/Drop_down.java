package summer2014_2015;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Drop_down extends JFrame{
	static int mousex;
	static int mousey;
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,600,600);
		g.setColor(Color.CYAN);
		g.fillRect(275,275,50,50);
		 if(mousex<326&&mousex>274&&mousey<274&&mousey>326){
			g.fillRect(275,275,60,60); 
		 }
	}
	public static void main(String[] args) {
		new Drop_down();
	}
	public Drop_down(){
		setTitle("SPOOPS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(600, 600);
		}
	public void mouseMoved(MouseEvent e) {
		//if(drawn){
		mousex=e.getPoint().x;
		mousey=e.getPoint().y;
		repaint();
		System.out.println(mousex+", "+mousey);
	}
}
