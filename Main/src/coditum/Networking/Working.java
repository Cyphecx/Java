package coditum.Networking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Working extends Thread{
	private Socket sock;
	private BufferedReader in;
	private PrintWriter out;
	public Working(Socket d) throws IOException{
		System.out.println("Connected to the a Client!");
		this.sock = d;
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true);
		echo();

	}
	public void echo() throws IOException{
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new PrintWriter(sock.getOutputStream(), true);
		while(true){
			String line;
			System.out.println(line = in.readLine());
			out.println(line);	
		}
	}
}
