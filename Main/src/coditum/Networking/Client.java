package coditum.Networking;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
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
	public Client(){
		Dimension d = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = (int)d.getWidth()/2;
		int frameHeight = (int)(d.getHeight()-(d.getHeight()/8)*2);
		JPanel panel = new JPanel(){
			public void paint(Graphics g){
				g.setColor(new Color(200, 200, 200));
				g.fillRect(0, 0, frameWidth, frameHeight);
			}
		};
		setVisible(true);
		add(panel);
		setBounds((int)(d.getWidth()/4),0,frameWidth, frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println(d.getWidth() + "x" +d.getHeight());
	}
	public static void main(String[] args){
		new Client();
		String hostName = "localhost";
		int portNumber = 8000;
		while(true){
			try(
					Socket echoSocket = new Socket(hostName, portNumber);
					PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
					BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
					BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
					){
				String userInput;
				while ((userInput = stdIn.readLine()) != null) {
					out.println(userInput);
					System.out.println("echo: " + in.readLine());
				}
				Thread.sleep(100);
			} catch (UnknownHostException e) {
				System.err.println("Don't know about host " + hostName);
			} catch (IOException e) {
				//System.err.println("Couldn't get I/O for the connection to " + hostName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
}
