package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Manage extends JFrame {

	private JPanel contentPane;
	private JTable tableUser;
	private JTextField textField_1;
	private JTextField idUser;
	private JTextField emailUser;
	private JTextField nameUser;
	private JTextField passwordUser;
	private JTextField addressUser;
	private JTextField phoneUser;
	private JTextField codeUser;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;
	private JTextField textField_9;
	private JTextField idManage;
	private JTextField nameManage;
	private JTextField dateManage;
	private JTextField plateManage;
	private JTable table_1;
	/**
	 * @wbp.nonvisual location=1003,724
	 */
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage frame = new Manage();
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
	public Manage() {
		Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
		insets.top = -1;
		UIManager.put("TabbedPane.contentBorderInsets", insets);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 725);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 194, 203));
		panel.setBounds(10, 10, 282, 688);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel HomePanel = new JPanel();
		
		HomePanel.setBackground(new Color(0, 155, 245));
		HomePanel.setBounds(10, 195, 262, 56);
		panel.add(HomePanel);
		HomePanel.setLayout(null);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(255, 0, 7, 56);
		HomePanel.add(panel_2_2);
		
		JLabel lblNewLabel = new JLabel("Trang Ch\u1EE7");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 16, 96, 24);
		HomePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(28, 0, 36, 56);
		HomePanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("G:\\Java\\Java-SocketIO\\ServerIO\\Imgs\\house-solid (1).png"));
		
		JPanel UserPanel = new JPanel();
		UserPanel.setLayout(null);
		UserPanel.setBackground(new Color(0, 155, 245));
		UserPanel.setBounds(10, 259, 262, 56);
		panel.add(UserPanel);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(255, 0, 7, 56);
		UserPanel.add(panel_2_2_1);
		
		JLabel lblNgiDng = new JLabel("Ng\u01B0\u1EDDi D\u00F9ng");
		lblNgiDng.setForeground(Color.WHITE);
		lblNgiDng.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNgiDng.setBounds(80, 16, 120, 24);
		UserPanel.add(lblNgiDng);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("G:\\Java\\Java-SocketIO\\ServerIO\\Imgs\\user-solid.png"));
		lblNewLabel_1_1.setBounds(28, 0, 36, 56);
		UserPanel.add(lblNewLabel_1_1);
		
		JPanel VehiclePanel = new JPanel();
		VehiclePanel.setLayout(null);
		VehiclePanel.setBackground(new Color(0, 155, 245));
		VehiclePanel.setBounds(10, 325, 262, 56);
		panel.add(VehiclePanel);
		
		JPanel panel_2_2_1_1 = new JPanel();
		panel_2_2_1_1.setLayout(null);
		panel_2_2_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1.setBounds(255, 0, 7, 56);
		VehiclePanel.add(panel_2_2_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ph\u01B0\u01A1ng Ti\u1EC7n");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(80, 16, 131, 24);
		VehiclePanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("G:\\Java\\Java-SocketIO\\ServerIO\\Imgs\\bicycle-solid.png"));
		lblNewLabel_1_1_1.setBounds(28, 0, 36, 56);
		VehiclePanel.add(lblNewLabel_1_1_1);
		
		JPanel ManagePanel = new JPanel();
		ManagePanel.setLayout(null);
		ManagePanel.setBackground(new Color(0, 155, 245));
		ManagePanel.setBounds(10, 391, 262, 56);
		panel.add(ManagePanel);
		
		JPanel panel_2_2_1_1_1 = new JPanel();
		panel_2_2_1_1_1.setLayout(null);
		panel_2_2_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1.setBounds(255, 0, 7, 56);
		ManagePanel.add(panel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u0110\u0103ng K\u00FD");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(80, 16, 96, 24);
		ManagePanel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("G:\\Java\\Java-SocketIO\\ServerIO\\Imgs\\bars-progress-solid.png"));
		lblNewLabel_1_1_1_1.setBounds(28, 0, 36, 56);
		ManagePanel.add(lblNewLabel_1_1_1_1);
		
		JPanel ChartPanel = new JPanel();
		ChartPanel.setLayout(null);
		ChartPanel.setBackground(new Color(0, 155, 245));
		ChartPanel.setBounds(10, 457, 262, 56);
		panel.add(ChartPanel);
		
		JPanel panel_2_2_1_1_1_1 = new JPanel();
		panel_2_2_1_1_1_1.setLayout(null);
		panel_2_2_1_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1_1.setBounds(255, 0, 7, 56);
		ChartPanel.add(panel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Bi\u1EC3u \u0110\u1ED3");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_2_1_1_1.setBounds(80, 16, 96, 24);
		ChartPanel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon("F:\\Download\\chart-area-solid.png"));
		lblNewLabel_1_1_1_1_1.setBounds(28, 0, 36, 56);
		ChartPanel.add(lblNewLabel_1_1_1_1_1);
		
		JPanel LogoutPanel = new JPanel();
		LogoutPanel.setLayout(null);
		LogoutPanel.setBackground(new Color(0, 155, 245));
		LogoutPanel.setBounds(10, 523, 262, 56);
		panel.add(LogoutPanel);
		
		JPanel panel_2_2_1_1_1_1_1 = new JPanel();
		panel_2_2_1_1_1_1_1.setLayout(null);
		panel_2_2_1_1_1_1_1.setBackground(Color.WHITE);
		panel_2_2_1_1_1_1_1.setBounds(255, 0, 7, 56);
		LogoutPanel.add(panel_2_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("\u0110\u0103ng Xu\u1EA5t");
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_2_1_1_1_1.setBounds(80, 16, 96, 24);
		LogoutPanel.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1_1.setIcon(new ImageIcon("G:\\Java\\Java-SocketIO\\ServerIO\\Imgs\\arrow-right-from-bracket-solid.png"));
		lblNewLabel_1_1_1_1_1_1.setBounds(28, 0, 36, 56);
		LogoutPanel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel avatar = new JLabel("");
		avatar.setIcon(new ImageIcon("F:\\Download\\kindpng_1636340 (1).png"));
		avatar.setBounds(87, 36, 100, 100);
		panel.add(avatar);
		
		JLabel lblNewLabel_2 = new JLabel("Nguyễn Blbla");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_2.setBounds(75, 146, 158, 33);
		panel.add(lblNewLabel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(302, 10, 882, 666);
		contentPane.add(tabbedPane);
		
		JPanel Home = new JPanel();
		tabbedPane.addTab("Trang Chủ", null, Home, null);
		
		JPanel panelUser = new JPanel();
		panelUser.setBorder(null);
		panelUser.setBackground(Color.WHITE);
		tabbedPane.addTab("Người Dùng", null, panelUser, null);
		panelUser.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 852, 282);
		panelUser.add(scrollPane);
		
		tableUser = new JTable();
		scrollPane.setViewportView(tableUser);
		
		JButton deleteUser = new JButton("Delete");
		deleteUser.setForeground(Color.WHITE);
		deleteUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		deleteUser.setFocusPainted(false);
		deleteUser.setBorderPainted(false);
		deleteUser.setBackground(new Color(220,53,69));
		deleteUser.setBounds(772, 312, 90, 40);
		panelUser.add(deleteUser);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("User Password");
		textField_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(246, 246, 246));
		textField_1.setBounds(10, 312, 348, 40);
		panelUser.add(textField_1);
		
		JButton updateUser = new JButton("Update");
		updateUser.setForeground(Color.WHITE);
		updateUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		updateUser.setFocusPainted(false);
		updateUser.setBorderPainted(false);
		updateUser.setBackground(new Color(255,193,7));
		updateUser.setBounds(672, 312, 90, 40);
		panelUser.add(updateUser);
		
		JButton addUser = new JButton("Add");
		addUser.setForeground(Color.WHITE);
		addUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		addUser.setFocusPainted(false);
		addUser.setBorderPainted(false);
		addUser.setBackground(new Color(25,135,84));
		addUser.setBounds(572, 312, 90, 40);
		panelUser.add(addUser);
		
		JButton viewUser = new JButton("View");
		viewUser.setForeground(Color.WHITE);
		viewUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		viewUser.setFocusPainted(false);
		viewUser.setBorderPainted(false);
		viewUser.setBackground(new Color(65, 194, 203));
		viewUser.setBounds(472, 312, 90, 40);
		panelUser.add(viewUser);
		
		JButton searchUser = new JButton("Search");
		searchUser.setForeground(Color.WHITE);
		searchUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		searchUser.setFocusPainted(false);
		searchUser.setBorderPainted(false);
		searchUser.setBackground(new Color(13,202,240));
		searchUser.setBounds(368, 312, 90, 40);
		panelUser.add(searchUser);
		
		idUser = new JTextField();
		idUser.setToolTipText("User Password");
		idUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		idUser.setColumns(10);
		idUser.setBorder(null);
		idUser.setBackground(new Color(246, 246, 246));
		idUser.setBounds(10, 382, 419, 40);
		panelUser.add(idUser);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId.setBounds(10, 362, 80, 13);
		panelUser.add(lblId);
		
		emailUser = new JTextField();
		emailUser.setToolTipText("User Password");
		emailUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		emailUser.setColumns(10);
		emailUser.setBorder(null);
		emailUser.setBackground(new Color(246, 246, 246));
		emailUser.setBounds(443, 382, 419, 40);
		panelUser.add(emailUser);
		
		JLabel lblId_1 = new JLabel("Email");
		lblId_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1.setBounds(443, 362, 80, 13);
		panelUser.add(lblId_1);
		
		nameUser = new JTextField();
		nameUser.setToolTipText("User Password");
		nameUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		nameUser.setColumns(10);
		nameUser.setBorder(null);
		nameUser.setBackground(new Color(246, 246, 246));
		nameUser.setBounds(10, 452, 419, 40);
		panelUser.add(nameUser);
		
		JLabel lblId_2 = new JLabel("Name");
		lblId_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_2.setBounds(10, 432, 80, 13);
		panelUser.add(lblId_2);
		
		passwordUser = new JTextField();
		passwordUser.setToolTipText("User Password");
		passwordUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		passwordUser.setColumns(10);
		passwordUser.setBorder(null);
		passwordUser.setBackground(new Color(246, 246, 246));
		passwordUser.setBounds(443, 452, 419, 40);
		panelUser.add(passwordUser);
		
		JLabel lblId_1_1 = new JLabel("Password");
		lblId_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_1.setBounds(443, 432, 80, 13);
		panelUser.add(lblId_1_1);
		
		addressUser = new JTextField();
		addressUser.setToolTipText("User Password");
		addressUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		addressUser.setColumns(10);
		addressUser.setBorder(null);
		addressUser.setBackground(new Color(246, 246, 246));
		addressUser.setBounds(10, 522, 419, 40);
		panelUser.add(addressUser);
		
		JLabel lblId_3 = new JLabel("Address");
		lblId_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_3.setBounds(10, 502, 80, 13);
		panelUser.add(lblId_3);
		
		phoneUser = new JTextField();
		phoneUser.setToolTipText("User Password");
		phoneUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		phoneUser.setColumns(10);
		phoneUser.setBorder(null);
		phoneUser.setBackground(new Color(246, 246, 246));
		phoneUser.setBounds(443, 522, 419, 40);
		panelUser.add(phoneUser);
		
		JLabel lblId_1_2 = new JLabel("Phone");
		lblId_1_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_2.setBounds(443, 502, 80, 13);
		panelUser.add(lblId_1_2);
		
		codeUser = new JTextField();
		codeUser.setToolTipText("User Password");
		codeUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		codeUser.setColumns(10);
		codeUser.setBorder(null);
		codeUser.setBackground(new Color(246, 246, 246));
		codeUser.setBounds(10, 592, 419, 40);
		panelUser.add(codeUser);
		
		JLabel lblId_3_1 = new JLabel("Code");
		lblId_3_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_3_1.setBounds(10, 572, 80, 13);
		panelUser.add(lblId_3_1);
		
		JLabel lblId_1_2_1 = new JLabel("Role");
		lblId_1_2_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_2_1.setBounds(443, 572, 80, 13);
		panelUser.add(lblId_1_2_1);
		
		JComboBox roleUser = new JComboBox();
		roleUser.setBorder(null);
		roleUser.setBackground(new Color(246, 246, 246));
		roleUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		roleUser.setBounds(443, 592, 419, 40);
		panelUser.add(roleUser);
		
		JPanel panelVehicle = new JPanel();
		panelVehicle.setBorder(null);
		panelVehicle.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý xe", null, panelVehicle, null);
		panelVehicle.setLayout(null);
		
		JButton deleteUser_1 = new JButton("Delete");
		deleteUser_1.setForeground(Color.WHITE);
		deleteUser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		deleteUser_1.setFocusPainted(false);
		deleteUser_1.setBorderPainted(false);
		deleteUser_1.setBackground(new Color(220, 53, 69));
		deleteUser_1.setBounds(772, 312, 90, 40);
		panelVehicle.add(deleteUser_1);
		
		textField = new JTextField();
		textField.setToolTipText("User Password");
		textField.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(246, 246, 246));
		textField.setBounds(10, 312, 348, 40);
		panelVehicle.add(textField);
		
		JButton updateUser_1 = new JButton("Update");
		updateUser_1.setForeground(Color.WHITE);
		updateUser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		updateUser_1.setFocusPainted(false);
		updateUser_1.setBorderPainted(false);
		updateUser_1.setBackground(new Color(255, 193, 7));
		updateUser_1.setBounds(672, 312, 90, 40);
		panelVehicle.add(updateUser_1);
		
		JButton addUser_1 = new JButton("Add");
		addUser_1.setForeground(Color.WHITE);
		addUser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		addUser_1.setFocusPainted(false);
		addUser_1.setBorderPainted(false);
		addUser_1.setBackground(new Color(25, 135, 84));
		addUser_1.setBounds(572, 312, 90, 40);
		panelVehicle.add(addUser_1);
		
		JButton viewUser_1 = new JButton("View");
		viewUser_1.setForeground(Color.WHITE);
		viewUser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		viewUser_1.setFocusPainted(false);
		viewUser_1.setBorderPainted(false);
		viewUser_1.setBackground(new Color(65, 194, 203));
		viewUser_1.setBounds(472, 312, 90, 40);
		panelVehicle.add(viewUser_1);
		
		JButton searchUser_1 = new JButton("Search");
		searchUser_1.setForeground(Color.WHITE);
		searchUser_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		searchUser_1.setFocusPainted(false);
		searchUser_1.setBorderPainted(false);
		searchUser_1.setBackground(new Color(13, 202, 240));
		searchUser_1.setBounds(368, 312, 90, 40);
		panelVehicle.add(searchUser_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("User Password");
		textField_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(246, 246, 246));
		textField_2.setBounds(10, 382, 419, 40);
		panelVehicle.add(textField_2);
		
		JLabel lblId_4 = new JLabel("Id");
		lblId_4.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_4.setBounds(10, 362, 80, 13);
		panelVehicle.add(lblId_4);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("User Password");
		textField_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(246, 246, 246));
		textField_3.setBounds(443, 382, 419, 40);
		panelVehicle.add(textField_3);
		
		JLabel lblId_1_3 = new JLabel("Name");
		lblId_1_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_3.setBounds(443, 362, 80, 13);
		panelVehicle.add(lblId_1_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("User Password");
		textField_4.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(246, 246, 246));
		textField_4.setBounds(10, 452, 419, 40);
		panelVehicle.add(textField_4);
		
		JLabel lblId_2_1 = new JLabel("Color");
		lblId_2_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_2_1.setBounds(10, 432, 80, 13);
		panelVehicle.add(lblId_2_1);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("User Password");
		textField_5.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(246, 246, 246));
		textField_5.setBounds(443, 452, 419, 40);
		panelVehicle.add(textField_5);
		
		JLabel lblId_1_1_1 = new JLabel("Type");
		lblId_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_1_1.setBounds(443, 432, 80, 13);
		panelVehicle.add(lblId_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("User Password");
		textField_6.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(246, 246, 246));
		textField_6.setBounds(10, 522, 419, 40);
		panelVehicle.add(textField_6);
		
		JLabel lblId_3_2 = new JLabel("Date");
		lblId_3_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_3_2.setBounds(10, 502, 80, 13);
		panelVehicle.add(lblId_3_2);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("User Password");
		textField_7.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(new Color(246, 246, 246));
		textField_7.setBounds(443, 522, 419, 40);
		panelVehicle.add(textField_7);
		
		JLabel lblId_1_2_2 = new JLabel("Seat Capacity");
		lblId_1_2_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_2_2.setBounds(443, 502, 119, 13);
		panelVehicle.add(lblId_1_2_2);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("User Password");
		textField_8.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(new Color(246, 246, 246));
		textField_8.setBounds(10, 592, 852, 40);
		panelVehicle.add(textField_8);
		
		JLabel lblId_3_1_1 = new JLabel("Brand");
		lblId_3_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_3_1_1.setBounds(10, 572, 80, 13);
		panelVehicle.add(lblId_3_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 852, 292);
		panelVehicle.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel panelManage = new JPanel();
		panelManage.setBorder(null);
		panelManage.setBackground(Color.WHITE);
		tabbedPane.addTab("Quản lý đăng ký", null, panelManage, null);
		panelManage.setLayout(null);
		
		JButton deleteUser_1_1 = new JButton("Delete");
		deleteUser_1_1.setForeground(Color.WHITE);
		deleteUser_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		deleteUser_1_1.setFocusPainted(false);
		deleteUser_1_1.setBorderPainted(false);
		deleteUser_1_1.setBackground(new Color(220, 53, 69));
		deleteUser_1_1.setBounds(772, 312, 90, 40);
		panelManage.add(deleteUser_1_1);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("User Password");
		textField_9.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(new Color(246, 246, 246));
		textField_9.setBounds(10, 312, 348, 40);
		panelManage.add(textField_9);
		
		JButton updateUser_1_1 = new JButton("Update");
		updateUser_1_1.setForeground(Color.WHITE);
		updateUser_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		updateUser_1_1.setFocusPainted(false);
		updateUser_1_1.setBorderPainted(false);
		updateUser_1_1.setBackground(new Color(255, 193, 7));
		updateUser_1_1.setBounds(672, 312, 90, 40);
		panelManage.add(updateUser_1_1);
		
		JButton addUser_1_1 = new JButton("Add");
		addUser_1_1.setForeground(Color.WHITE);
		addUser_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		addUser_1_1.setFocusPainted(false);
		addUser_1_1.setBorderPainted(false);
		addUser_1_1.setBackground(new Color(25, 135, 84));
		addUser_1_1.setBounds(572, 312, 90, 40);
		panelManage.add(addUser_1_1);
		
		JButton viewUser_1_1 = new JButton("View");
		viewUser_1_1.setForeground(Color.WHITE);
		viewUser_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		viewUser_1_1.setFocusPainted(false);
		viewUser_1_1.setBorderPainted(false);
		viewUser_1_1.setBackground(new Color(65, 194, 203));
		viewUser_1_1.setBounds(472, 312, 90, 40);
		panelManage.add(viewUser_1_1);
		
		JButton searchUser_1_1 = new JButton("Search");
		searchUser_1_1.setForeground(Color.WHITE);
		searchUser_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		searchUser_1_1.setFocusPainted(false);
		searchUser_1_1.setBorderPainted(false);
		searchUser_1_1.setBackground(new Color(13, 202, 240));
		searchUser_1_1.setBounds(368, 312, 90, 40);
		panelManage.add(searchUser_1_1);
		
		idManage = new JTextField();
		idManage.setToolTipText("User Password");
		idManage.setFont(new Font("Roboto", Font.PLAIN, 15));
		idManage.setColumns(10);
		idManage.setBorder(null);
		idManage.setBackground(new Color(246, 246, 246));
		idManage.setBounds(10, 382, 419, 40);
		panelManage.add(idManage);
		
		JLabel lblId_4_1 = new JLabel("Id");
		lblId_4_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_4_1.setBounds(10, 362, 80, 13);
		panelManage.add(lblId_4_1);
		
		JLabel lblId_1_3_1 = new JLabel("Name User");
		lblId_1_3_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_3_1.setBounds(443, 362, 80, 13);
		panelManage.add(lblId_1_3_1);
		
		nameManage = new JTextField();
		nameManage.setToolTipText("User Password");
		nameManage.setFont(new Font("Roboto", Font.PLAIN, 15));
		nameManage.setColumns(10);
		nameManage.setBorder(null);
		nameManage.setBackground(new Color(246, 246, 246));
		nameManage.setBounds(10, 452, 419, 40);
		panelManage.add(nameManage);
		
		JLabel lblId_2_1_1 = new JLabel("Name");
		lblId_2_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_2_1_1.setBounds(10, 432, 80, 13);
		panelManage.add(lblId_2_1_1);
		
		JLabel lblId_1_1_1_1 = new JLabel("Name Vehicle");
		lblId_1_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_1_1_1.setBounds(443, 432, 100, 13);
		panelManage.add(lblId_1_1_1_1);
		
		dateManage = new JTextField();
		dateManage.setToolTipText("User Password");
		dateManage.setFont(new Font("Roboto", Font.PLAIN, 15));
		dateManage.setColumns(10);
		dateManage.setBorder(null);
		dateManage.setBackground(new Color(246, 246, 246));
		dateManage.setBounds(10, 522, 419, 40);
		panelManage.add(dateManage);
		
		JLabel lblId_3_2_1 = new JLabel("Date");
		lblId_3_2_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_3_2_1.setBounds(10, 502, 80, 13);
		panelManage.add(lblId_3_2_1);
		
		plateManage = new JTextField();
		plateManage.setToolTipText("User Password");
		plateManage.setFont(new Font("Roboto", Font.PLAIN, 15));
		plateManage.setColumns(10);
		plateManage.setBorder(null);
		plateManage.setBackground(new Color(246, 246, 246));
		plateManage.setBounds(443, 522, 419, 40);
		panelManage.add(plateManage);
		
		JLabel lblId_1_2_2_1 = new JLabel("Plate");
		lblId_1_2_2_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblId_1_2_2_1.setBounds(443, 502, 119, 13);
		panelManage.add(lblId_1_2_2_1);
		
		JComboBox NameUser = new JComboBox();
		NameUser.setFont(new Font("Roboto", Font.PLAIN, 15));
		NameUser.setBorder(null);
		NameUser.setBackground(new Color(246, 246, 246));
		NameUser.setBounds(439, 382, 419, 40);
		panelManage.add(NameUser);
		
		JComboBox nameVehicle = new JComboBox();
		nameVehicle.setFont(new Font("Roboto", Font.PLAIN, 15));
		nameVehicle.setBorder(null);
		nameVehicle.setBackground(new Color(246, 246, 246));
		nameVehicle.setBounds(439, 452, 419, 40);
		panelManage.add(nameVehicle);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 852, 291);
		panelManage.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		JPanel panelChart = new JPanel();
		panelChart.setBorder(null);
		panelChart.setBackground(Color.WHITE);
		tabbedPane.addTab("Biểu đố", null, panelChart, null);
		setLocationRelativeTo(null);
		HomePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		UserPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		VehiclePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		ManagePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		ChartPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index = tabbedPane.getSelectedIndex();
				if(index == 0) {
					HomePanel.setBackground(new Color(0, 100, 250));
					UserPanel.setBackground(new Color(0, 155, 245));
					VehiclePanel.setBackground(new Color(0, 155, 245));
					ManagePanel.setBackground(new Color(0, 155, 245));
					ChartPanel.setBackground(new Color(0, 155, 245));
				}
				if(index == 1) {
					UserPanel.setBackground(new Color(0, 100, 250));
					HomePanel.setBackground(new Color(0, 155, 245));
					VehiclePanel.setBackground(new Color(0, 155, 245));
					ManagePanel.setBackground(new Color(0, 155, 245));
					ChartPanel.setBackground(new Color(0, 155, 245));
				}
				else if(index == 2) {
					VehiclePanel.setBackground(new Color(0, 100, 250));
					HomePanel.setBackground(new Color(0, 155, 245));
					UserPanel.setBackground(new Color(0, 155, 245));
					ManagePanel.setBackground(new Color(0, 155, 245));
					ChartPanel.setBackground(new Color(0, 155, 245));
				}
				else if(index == 3) {
					ManagePanel.setBackground(new Color(0, 100, 250));
					HomePanel.setBackground(new Color(0, 155, 245));
					VehiclePanel.setBackground(new Color(0, 155, 245));
					UserPanel.setBackground(new Color(0, 155, 245));
					ChartPanel.setBackground(new Color(0, 155, 245));
				}
				else if(index == 4) {
					ChartPanel.setBackground(new Color(0, 100, 250));
					HomePanel.setBackground(new Color(0, 155, 245));
					ManagePanel.setBackground(new Color(0, 155, 245));
					VehiclePanel.setBackground(new Color(0, 155, 245));
					UserPanel.setBackground(new Color(0, 155, 245));
				}
			}
		});
	}
}
