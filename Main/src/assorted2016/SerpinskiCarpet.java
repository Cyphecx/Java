package assorted2016;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SerpinskiCarpet extends JFrame{

	public static void main(String[] args) {
		new SerpinskiCarpet();

	}
	public SerpinskiCarpet(){
		JPanel pane=new JPanel(){
			public void paint(Graphics G){
			
			}
		};
		add(pane);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(560,140,800,800 );
		pane.setPreferredSize(new Dimension(800,800));
		pack();
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

}
