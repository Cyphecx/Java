package Assorted2016;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hydra extends JFrame{

	public static void main(String[] args) {
		new Hydra();
	}
	public Hydra(){
		JButton jb=new JButton("Opens Minecraft. Gets a Hydra");
		setVisible(true);
		add(jb);
		addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				for(int i=0; i<11; i++){
					new Hydra();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		jb.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<11; i++){
					new Hydra();
				}
				
			}
			
		});
		setBounds((int) Math.ceil(Math.random()*1920),(int)Math.ceil(Math.random()*920),(int) Math.ceil(Math.random()*1000),(int) Math.ceil(Math.random()*900));
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {

				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				for(int i=0; i<11; i++){
					new Hydra();
				}
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
			
			
			
		});
	}

}
