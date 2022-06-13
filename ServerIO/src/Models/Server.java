package Models;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	public static ServerSocket serverSocket = null;
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    public void run() {
        try {
        	serverSocket = new ServerSocket(8080);
            InetAddress ip = serverSocket.getInetAddress();
            int port = serverSocket.getLocalPort();
            System.out.println("IP: " + ip + " Port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}