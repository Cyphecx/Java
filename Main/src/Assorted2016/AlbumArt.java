import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlbumArt extends JFrame{

	public static void main(String[] args) {
		new AlbumArt();

	}
	public AlbumArt(){
		JPanel pane=new JPanel(){
			public void paint(Graphics g){
				draw(g,2);
				g.drawPolygon(new int[]{401,101,701} ,new int[]{175,625,625}, 3);
			}
		};
		add(pane);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(560,140,800,800 );
		pane.setPreferredSize(new Dimension(801,800));
		pack();
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
			public void mousePressed(MouseEvent e) {
				System.out.println("X: "+e.getX()+" Y: "+e.getY());
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		
		
	}
	public void draw(Graphics g, int ct){
		g.drawPolygon(new int[]{401,101,701} ,new int[]{175,(625+175)/ct,(625+175)/ct}, 3);
		g.drawPolygon(new int[]{401,101,701} ,new int[]{175,(625+175)*ct,(625+175)*ct}, 3);
		
		if(ct<5000){
			ct++;
			draw(g,ct);
			
		}
	}

}
