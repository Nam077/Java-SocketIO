package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Client;
import Models.User;
import Views.Login;
import Views.Register;

public class RunClient extends Thread {
	Login login =  new Login();;
	Register register = new Register();;
	Client client;
	public RunClient() {
		register.setVisible(false);
		client  = new Client();
		login.registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login.setVisible(false);
				register.setVisible(true);
				
				
			}
		});
		register.btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				client.SendData("regsiter");
				String email = register.emailRegister.getText();
				String name = register.nameRegister.getText();
				String password = register.passwordRegister.getText();
				System.out.println();
				User userRegister = new User();
				userRegister.setEmail(email);
				userRegister.setName(name);
				userRegister.setPassword(password);
				client.SendObjectUser(userRegister);
				System.out.println(userRegister);
				

			}
		});
		
		login.loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				client.SendData("login");
				String loginEmail = login.loginEmail.getText();
				String loginPassword = login.loginPassword.getText();
				User userLogin = new  User();
				userLogin.setEmail(loginEmail);
				userLogin.setPassword(loginPassword);
				client.SendObjectUser(userLogin);
			}
		});
	}
	
	public void run() {
		while(true) {
			if (client.checkLoginString.length() != 0) {
				
				if (client.checkLoginString.equals("done")) {
					login.notification("Ok");
				} else {
					login.notification("No ok");
				}
				client.checkLoginString = "";
			}
			if (client.checkRegisterString.length() != 0) {
				if (client.checkRegisterString.equals("done")) {
					register.notification("Ok");
					register.setVisible(false);
					login.setVisible(true);
					
				} else {
					register.notification("No ok");
				}
				client.checkRegisterString = "";
			}
			System.out.print("");
			}
	}
	
	public static void main(String[] args) {
		RunClient handleClient = new RunClient();
		handleClient.start();
	}
}
