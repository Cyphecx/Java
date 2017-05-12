package coditum.Networking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Client extends JFrame{
	int mouseX = 0;
	int mouseY = 0;
	public Client() throws InterruptedException{
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = (int)d.getWidth()/2;
		int frameHeight = (int)(d.getHeight()-(d.getHeight()/8)*2);
		Button[][] board = new Button[3][3];
		for(int i = 0; i < 3; i++){
			for(int k = 0; k < 3; k++){
				int size = frameHeight/5;
				board[i][k] = new Button(size,size);
			}
		}
		JPanel panel = new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(200, 200, 200));
				g.fillRect(0, 0, frameWidth, frameHeight);
				g.setColor(Color.MAGENTA);
				int xpos =  frameWidth/5;
				int ypos = frameHeight/7;
				Button currB = null;
				for(int i = 0; i < 3; i++){
					for(int k = 0; k < 3; k++){
						currB = board[i][k];
						if(currB.getState() == 0){
							g.setColor(Color.BLACK);
						}
						else if(currB.getState() == 1){
							g.setColor(Color.CYAN);
						}
						else{
							g.setColor(Color.ORANGE);
						}
						currB.setX(xpos);
						currB.setY(ypos);
						if(currB.collide(mouseX, mouseY)){
							g.setColor(Color.yellow);
						}
						System.out.println("asd");
						g.fillRect(xpos, ypos, currB.getHeight(), currB.getWidth());
						xpos += frameWidth/5;
					}
					xpos = frameWidth/5;
					ypos += currB.getHeight()+frameHeight/75;
				}
			}
		};
		setVisible(true);
		add(panel);
		setBounds((int)(d.getWidth()/4),0,frameWidth, frameHeight);
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {


			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mouseY = MouseInfo.getPointerInfo().getLocation().y;
				mouseX = MouseInfo.getPointerInfo().getLocation().x; 
				// System.out.println("X: " + mouseX + ", Y: " + mouseY);
			}

		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		String hostName = "localhost";
		int portNumber = 8000;
		while(true){
			try(
					Socket echoSocket = new Socket(hostName, portNumber);
					PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
					){
				System.out.println("Connected to a server!");
				String userInput;
				while ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					System.out.println("echo: " + in.readLine());
				}
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host " + hostName);
			} catch (IOException e) {
				
			}
			Thread.sleep(100);
			panel.repaint();
			
		}
	}
	public static void main(String[] args) throws InterruptedException{
		new Client();
	}
}
