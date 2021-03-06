package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Models.User;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;


public class UserTable extends JFrame {

	private JPanel contentPane;
	public JTable tableAccount;
	public JScrollPane PanelAccount;
	public JPanel panelActionAccount;
	public JPanel PanelInfoAccount;
	public JTextField TFAccountID;
	public JTextField TFAccountName;
	public JTextField TFAccountEmail;
	public JTextField TFAccountAddress;
	public JTextField TFAccountDate;
	public JTextField TFAccountPass;
	public JTextField TFAccountPhone;
	public JComboBox CBAccountRule;
	public String colAccount[] = { "ID", "Tên", "Email", "Mật khẩu", "Vai Trò", "Địa Chỉ","SĐT", "SĐT", "CMND" };
	public JLabel lblVaiTr;
	public ArrayList<User> listUser = new ArrayList<User>();
//	private List<Book> listBook;
//	private List<Category> listCategory;
	public DefaultTableModel modelBook, modelCategory;
	public static DefaultTableModel modelAccount;
//	private Connect connect = new Connect();
//	private String[] Category;
//	private List<Account> listAccount;
	public DefaultComboBoxModel<String> modelCombobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		getView();
	}
	public static void getView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserTable frame = new UserTable();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void UpdateTable() {
		

	}

	public UserTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		modelAccount = new DefaultTableModel(colAccount, 0);
		setBounds(100, 100, 944, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelAccount = new JScrollPane();
		PanelAccount.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PanelAccount.setBounds(11, 25, 905, 303);
		contentPane.add(PanelAccount);
		tableAccount = new JTable(modelAccount);
		PanelAccount.setViewportView(tableAccount);
		
		panelActionAccount = new JPanel();
		panelActionAccount.setLayout(null);
		panelActionAccount.setBounds(247, 350, 669, 70);
		contentPane.add(panelActionAccount);

		JButton BTaddAccount = new JButton("Th\u00EAm T\u00E0i Kho\u1EA3n");

		BTaddAccount.setBounds(23, 11, 138, 48);
		panelActionAccount.add(BTaddAccount);

		JButton btnXemTiKhon = new JButton("Xem T\u00E0i Kho\u1EA3n");
		btnXemTiKhon.setBounds(184, 11, 138, 48);
		panelActionAccount.add(btnXemTiKhon);

		JButton BTeditAccount = new JButton("S\u1EEDa T\u00E0i Kho\u1EA3n");
		BTeditAccount.setEnabled(false);
		
		BTeditAccount.setBounds(345, 11, 138, 48);
		panelActionAccount.add(BTeditAccount);

		JButton BTdeleteAccount = new JButton("Xóa Tài Khoản");
		BTdeleteAccount.setEnabled(false);
		BTdeleteAccount.setBounds(506, 11, 138, 48);
		panelActionAccount.add(BTdeleteAccount);

		PanelInfoAccount = new JPanel();
		PanelInfoAccount.setBounds(11, 431, 907, 173);
		contentPane.add(PanelInfoAccount);
		PanelInfoAccount.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(11, 11, 46, 14);
		PanelInfoAccount.add(lblNewLabel_3);

		TFAccountID = new JTextField();
		TFAccountID.setEditable(false);
		TFAccountID.setColumns(10);
		TFAccountID.setBounds(10, 30, 216, 42);
		PanelInfoAccount.add(TFAccountID);

		JLabel lblTn_2 = new JLabel("Tên");
		lblTn_2.setBounds(235, 11, 46, 14);
		PanelInfoAccount.add(lblTn_2);

		TFAccountName = new JTextField();
		TFAccountName.setColumns(10);
		TFAccountName.setBounds(234, 31, 216, 41);
		PanelInfoAccount.add(TFAccountName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(458, 11, 46, 14);
		PanelInfoAccount.add(lblEmail);

		TFAccountEmail = new JTextField();
		TFAccountEmail.setColumns(10);
		TFAccountEmail.setBounds(458, 31, 216, 41);
		PanelInfoAccount.add(TFAccountEmail);

		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(682, 11, 46, 14);
		PanelInfoAccount.add(lblaCh);

		TFAccountAddress = new JTextField();
		TFAccountAddress.setColumns(10);
		TFAccountAddress.setBounds(682, 31, 216, 41);
		PanelInfoAccount.add(TFAccountAddress);

		TFAccountDate = new JTextField();
		TFAccountDate.setColumns(10);
		TFAccountDate.setBounds(10, 103, 216, 42);
		PanelInfoAccount.add(TFAccountDate);

		JLabel lblNewLabel_7_1 = new JLabel("Ngày sinh");
		lblNewLabel_7_1.setBounds(11, 83, 97, 14);
		PanelInfoAccount.add(lblNewLabel_7_1);

		JLabel lblNewLabel_6_1 = new JLabel("mật khẩu");
		lblNewLabel_6_1.setBounds(235, 83, 111, 14);
		PanelInfoAccount.add(lblNewLabel_6_1);

		TFAccountPass = new JTextField();
		TFAccountPass.setColumns(10);
		TFAccountPass.setBounds(234, 104, 216, 41);
		PanelInfoAccount.add(TFAccountPass);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setBounds(458, 83, 104, 14);
		PanelInfoAccount.add(lblSinThoi);

		TFAccountPhone = new JTextField();
		TFAccountPhone.setColumns(10);
		TFAccountPhone.setBounds(458, 104, 216, 41);
		PanelInfoAccount.add(TFAccountPhone);
		String ruleAccount[] = { "admin", "guest" };
		CBAccountRule = new JComboBox(ruleAccount);
		CBAccountRule.setBounds(684, 103, 212, 40);
		PanelInfoAccount.add(CBAccountRule);

		lblVaiTr = new JLabel("Vai trò");
		lblVaiTr.setBounds(684, 84, 104, 14);
		PanelInfoAccount.add(lblVaiTr);
		
	}

	

	
}
