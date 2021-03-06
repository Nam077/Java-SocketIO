package Models;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client extends Thread {
	public String checkLoginString = "";
	public String checkRegisterString = "";
	public Socket clientSocket;

    public  Client () {
    	String serverName = "localhost";
        try {
			clientSocket = new Socket(serverName, 8080);
			System.out.println("Client is connected to server");
	    	this.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    @Override
    public void run() {
        super.run();
        try {
        	while(true) {
        		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
				String data = in.readUTF();
				if(data.equals("login successfuly")) {
					checkLoginString = "done";
				}
				else if(data.equals("login fail")) {
					checkLoginString = "fail";
				}
				else if(data.equals("register successfuly")) {
					checkRegisterString = "done";
				}
				else if(data.equals("register fail")) {
					checkRegisterString = "fail";
				}
				System.out.println("Login: " + checkLoginString);
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SendData(String message) {
		try {
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeUTF(message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
    public void SendObjectUser(User user) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			out.writeObject(user);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
}