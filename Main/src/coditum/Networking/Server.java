package coditum.Networking;
import java.net.*;
import java.io.*;

public class Server extends Thread {

	public static void main(String [] args) throws IOException {
		int port = 8000;
		ServerSocket serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(1000000000);
		while(true) {
			try {
				System.out.println("Looking for a client...");
				Working w = new Working(serverSocket.accept());
				Thread t = w;
				t.start();

			}catch(SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			}catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}