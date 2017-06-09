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
	static String hostName = "localhost";
	static int portNumber = 8000;
	static boolean connected = false;
	boolean game = true;
	PrintWriter out;
	BufferedReader in;
	BufferedReader stdIn;
	public static void main(String[] args) throws InterruptedException{
		new Client();
	}
	public Client() throws InterruptedException{
		while(!connected){
			try(
				Socket echoSocket = new Socket(hostName, portNumber);
				
			){
				out = new PrintWriter(echoSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				stdIn = new BufferedReader(new InputStreamReader(System.in));
				connected = true;
				System.out.println("Connected to a server!");
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host " + hostName);
			} catch (IOException e) {}
			Thread.sleep(10);	
		}
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
				int xpos =  (int) (frameWidth/4.5);
				int ypos = frameHeight/7;
				Button currB = null;
				for(int i = 0; i < 3; i++){
					for(int k = 0; k < 3; k++){
						currB = board[i][k];
						g.setColor(Color.BLACK);
						if(currB.collide(mouseX, mouseY)){
							g.setColor(Color.GRAY);
						}
						if(currB.getState() == 0){
							
						}
						else if(currB.getState() == 1){
							g.drawLine(xpos+frameHeight/25, ypos+frameHeight/25, xpos+currB.getWidth()-frameHeight/25, ypos+currB.getHeight()-frameHeight/25);
							g.drawLine(xpos+currB.getWidth()-frameHeight/25, ypos+frameHeight/25, xpos+frameHeight/25, ypos+currB.getHeight()-frameHeight/25);
						}
						else if(currB.getState() == 2){
							g.drawOval(xpos+frameHeight/50, ypos+frameHeight/50, currB.getWidth()-frameHeight/25, currB.getHeight()-frameHeight/25);
						}
						currB.setX(xpos);
						currB.setY(ypos);
						g.drawRect(xpos, ypos, currB.getHeight(), currB.getWidth());
						xpos += frameWidth/5.5;
					}
					xpos = (int) (frameWidth/4.5);
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
				for(int i = 0; i < 3; i++){
					for(int k = 0; k < 3; k++){
						if(board[i][k].collide(mouseX, mouseY)){
							board[i][k].setState(2);
							out.write(i+","+k);
						}
					}
				}
				
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
				mouseY = MouseInfo.getPointerInfo().getLocation().y-38;
				mouseX = MouseInfo.getPointerInfo().getLocation().x - (int)(d.getWidth()/4); 
				//System.out.println("X: " + mouseX + ", Y: " + mouseY);
			}

		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		while(game){
			repaint();
		}
	}
}
