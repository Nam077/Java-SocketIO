package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Client;
import Models.User;
import Services.SecurityRSA;
import Views.*;
import Views.Register;
import Views.UserTable;

public class RunClient extends Thread {
	LoginUI loginUI =  new LoginUI();;
	SecurityRSA securityRSA = new SecurityRSA();
	UserTable userTable = new UserTable();;

	RegisterUI registerUI = new RegisterUI();
	Client client;
	public RunClient() {
		registerUI.setVisible(false);
		client  = new Client();
		loginUI.reg_btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginUI.setVisible(false);
				registerUI.setVisible(true);
				
				
			}
		});
		registerUI.submit_btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				client.SendData("regsiter");
				String email = registerUI.emailRegister.getText();
				String name = registerUI.nameRegister.getText();
				String password = registerUI.passwordRegister.getText();
				password = securityRSA.encrypt(password);
				User userRegister = new User();
				userRegister.setEmail(email);
				userRegister.setName(name);
				userRegister.setPassword(password);
				client.SendObjectUser(userRegister);
				System.out.println(userRegister);
				
			}
		});
		
		loginUI.submit_btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				client.SendData("login");
				String loginEmail = loginUI.emailLogin.getText();
				String loginPassword = loginUI.passwordLogin.getText();
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
					loginUI.notification("Ok");
					client.SendData("send list user");
					loginUI.setVisible(false);
					userTable.setVisible(true);
				} else {
					loginUI.notification("No ok");
				}
				client.checkLoginString = "";
			}
			if (client.checkRegisterString.length() != 0) {
				if (client.checkRegisterString.equals("done")) {
					registerUI.notification("Ok");
					registerUI.setVisible(false);
					loginUI.setVisible(true);
					
				} else {
					registerUI.notification("No ok");
				}
				client.checkRegisterString = "";
			}
			if (client.listUser!= null) {
					
					
					userTable.listUser = client.listUser;
					for( User user : userTable.listUser){
				        Object[] row = {user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getAddress(), user.getPhone(), user.getCode()};
				        userTable.modelAccount.addRow(row);
				        System.out.println(user);
				    }
					userTable.tableAccount.setModel(UserTable.modelAccount);
				client.listUser = null;
			}
			System.out.print("");
			}
	}
	
	public static void main(String[] args) {
		RunClient handleClient = new RunClient();
		handleClient.start();
	}
}
