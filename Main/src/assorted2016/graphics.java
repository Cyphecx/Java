package assorted2016;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class graphics extends JFrame {
	
	public static void main(String[] args){
		new graphics();
	}
	public graphics(){
		JPanel panel=new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(255,255,255));
				g.fillOval(200,300,150,150);
				g.fillOval(210,230,130,130);
				g.fillOval(220,170,110,110);
				g.setColor(new Color(0,0,0));
				g.fillOval(250,200,15,15);
				g.fillOval(295,200,15,15);
				g.fillOval(243,230,10,10);
				g.fillOval(255,235,10,10);
				g.fillRect(213,180,130,5);
				g.fillRect(233,100,90,80);
				g.setColor(new Color(255, 163, 67));
				g.fillPolygon(new int[]{275,271,302}, new int[]{216,234,231},3);
			}
		};
		setVisible(true);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(panel);
		setTitle("SpoopS");
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("X:"+arg0.getX());
				System.out.println("Y:"+arg0.getY());
				System.out.println("Click!");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
	}

	
}
