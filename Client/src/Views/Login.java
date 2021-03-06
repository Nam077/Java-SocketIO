package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	public JTextField loginPassword;
	public JTextField loginEmail;
	public JButton loginBtn,registerBtn;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
//					frame.TT("sss");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginPassword = new JTextField();
		loginPassword.setBounds(115, 147, 347, 44);
		contentPane.add(loginPassword);
		loginPassword.setColumns(10);
		
		loginEmail = new JTextField();
		loginEmail.setColumns(10);
		loginEmail.setBounds(115, 76, 347, 44);
		contentPane.add(loginEmail);
		
		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		loginBtn.setBounds(115, 216, 158, 50);
		contentPane.add(loginBtn);
		
		registerBtn = new JButton("Login");
		registerBtn.setBounds(304, 216, 158, 50);
		contentPane.add(registerBtn);
		setVisible(true);
	}
	
	public void notification(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
