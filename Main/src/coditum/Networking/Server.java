package coditum.Networking;
import java.net.*;
import java.io.*;

public class Server extends Thread {

	public static void main(String [] args) throws IOException {
		int port = 8000;
		Button board[][] = new Button[3][3];
		ServerSocket serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(1000000000);
		Working Client1 = null;
		Working Client2 = null;
		boolean game = true;
		while(Client2 == null) {
			try {
				System.out.println("Looking for clients...");
				if(Client1 == null){
					Client1 = new Working(serverSocket.accept());
				}
				else{
					Client2 = new Working(serverSocket.accept());
				}

			}catch(SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			}catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("Connected!");
		while(game){
			int[] meow = Client1.retrieveMove();
			System.out.println(meow[1]);
		}
	}
}