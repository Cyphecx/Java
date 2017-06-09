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
	BufferedReader in = null;
	PrintWriter out = null;
	public Working(Socket d) throws IOException{
		this.sock = d;
	}
	
	public void run(){
		System.out.println("asdasda");
		try {
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			String line;
			try {
				System.out.println(in.read());
				while((line = in.readLine()) != null){
					out.println(line);	
					System.out.println(line);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	public int[] retrieveMove() throws IOException{
		String str = null;
		try {
			while(!((str = in.readLine()).equals(null))){}
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		int[] o = new int[2];
		o[0] = Integer.parseInt(str.substring(0, 1));
		o[1] = Integer.parseInt(str.substring(2));
		return o;
	}
}
