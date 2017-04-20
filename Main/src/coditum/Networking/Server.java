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
             System.out.println("Waiting for client on port " + 
                serverSocket.getLocalPort() + "...");
             Socket server = serverSocket.accept();
             
             System.out.println("Just connected to " + server.getRemoteSocketAddress());
             DataInputStream in = new DataInputStream(server.getInputStream());
             System.out.println(in.read());
             DataOutputStream out = new DataOutputStream(server.getOutputStream());
             out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
             server.close();
             
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