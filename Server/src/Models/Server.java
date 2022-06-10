package Models;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import Services.AccountService;

//Server class using thread to listen to port 8080 ip localhost and accept client connection from Client.java
public class Server extends Thread {
	public Socket clientSocket;
	public ServerSocket serverSocket;

	public Server() {
		
		try {
			serverSocket = new ServerSocket(8080);
			System.out.println("IP: " + serverSocket.getInetAddress().getHostAddress());
	        System.out.println("Port: " + serverSocket.getLocalPort());
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
            while (true) {
                //handle client Socket class HandleClient.java
                Socket clientSocket = serverSocket.accept();
                WorkThread workThread = new WorkThread(clientSocket);
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
}

class WorkThread extends Thread{
	Socket socket;
	public AccountService accountService = new AccountService();
	public WorkThread(Socket socket) {
		this.socket = socket;
		this.start();
	}
	 public void SendData(String message) {
			try {
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(message);   	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       
	}
	 
	public boolean checkLogin(User user) {
		AccountService accountService = new AccountService();
		User checkUser = accountService.checkLogin(user);
		return (checkUser.getEmail() != null);
	}
	public void sendArrayListUser(ArrayList<User> list) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(list);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	public void run() {
		while(true) {
			DataInputStream in;
			try {
				in = new DataInputStream(socket.getInputStream());
				String data = in.readUTF();
				System.out.println(data);
				if(data.equals("login")) {
					try {
						ObjectInputStream objectUser = new ObjectInputStream(socket.getInputStream());
		                User user = (User) objectUser.readObject();
		                if(checkLogin(user)) {
		                	SendData("login successfuly");
		                }
		                else{
		                	SendData("login fail");
		                }
					} catch (Exception e) {
						// TODO: handle exception
					}	
				}
				else if(data.equals("regsiter")) {
					System.out.println();
					try {
						ObjectInputStream objectUser = new ObjectInputStream(socket.getInputStream());
		                User user = (User) objectUser.readObject();
		                Boolean result = accountService.insertUser(user);
		                System.out.println(user);
		                if(result == true) {
		                	SendData("register successfuly");
		                }
		                else{
		                	SendData("register fail");
		                }
		                
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if(data.equals("send list user")) {
					try {
						SendData("send list user");
						ArrayList<User> listUser = accountService.getListUser();
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			            out.writeObject(listUser);
						for(User user: listUser) {
								System.out.println(user);
						}
						sendArrayListUser(listUser);
						System.out.println("send oke");
					} catch (Exception e) {
						// TODO: handle exception
					}
				
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
             //get data from client using ObjectInputStream
            
		}
	}
}