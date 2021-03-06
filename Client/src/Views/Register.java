package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	public JTextField emailRegister;
	public JTextField nameRegister;
	public JTextField passwordRegister;
	public JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emailRegister = new JTextField();
		emailRegister.setColumns(10);
		emailRegister.setBounds(156, 53, 395, 41);
		contentPane.add(emailRegister);
		
		nameRegister = new JTextField();
		nameRegister.setColumns(10);
		nameRegister.setBounds(156, 120, 395, 41);
		contentPane.add(nameRegister);
		
		passwordRegister = new JTextField();
		passwordRegister.setColumns(10);
		passwordRegister.setBounds(156, 182, 395, 41);
		contentPane.add(passwordRegister);
		
		btnRegister = new JButton("\u0110\u0103ng k\u00FD");
		btnRegister.setBounds(156, 244, 395, 41);
		contentPane.add(btnRegister);
	}
	public void notification(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
