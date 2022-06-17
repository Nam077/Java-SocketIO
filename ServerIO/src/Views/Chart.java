package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class Chart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart frame = new Chart();
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
	public Chart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1327, 414);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.WHITE, 5));
		panel.setBackground(new Color(253,242,186));
		panel.setBounds(10, 10, 645, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u1ED8NG HO\u00C0 X\u00C3 H\u1ED8I CH\u1EE6 NGH\u0128A VI\u1EC6T NAM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 645, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Socialist Republic of Vietnam");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 31, 645, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblBCngAn = new JLabel("B\u1ED8 C\u00D4NG AN");
		lblBCngAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBCngAn.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblBCngAn.setBounds(0, 60, 645, 38);
		panel.add(lblBCngAn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ministry of Public Security");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(0, 86, 645, 26);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblCcCnhSt = new JLabel("C\u1EE4C C\u1EA2NH S\u00C1T GIAO TH\u00D4NG");
		lblCcCnhSt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCcCnhSt.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCcCnhSt.setBounds(0, 113, 645, 38);
		panel.add(lblCcCnhSt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("The Traffic Police Department");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(0, 144, 645, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblChngNhnng = new JLabel("CH\u1EE8NG NH\u1EACN \u0110\u0102NG K\u00DD");
		lblChngNhnng.setForeground(Color.RED);
		lblChngNhnng.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngNhnng.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblChngNhnng.setBounds(0, 177, 645, 38);
		panel.add(lblChngNhnng);
		
		JLabel lblXeMT = new JLabel("XE M\u00D4 T\u00D4 XE G\u1EAEN M\u00C1Y");
		lblXeMT.setHorizontalAlignment(SwingConstants.CENTER);
		lblXeMT.setForeground(Color.RED);
		lblXeMT.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblXeMT.setBounds(0, 212, 645, 38);
		panel.add(lblXeMT);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Motorbike Registration Certificate");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(0, 246, 645, 26);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("S\u1ED1(Number): ");
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2.setBounds(0, 293, 645, 26);
		panel.add(lblNewLabel_1_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(253, 242, 186));
		panel_1.setBounds(10, 390, 645, 359);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C\u1ED8NG HO\u00C0 X\u00C3 H\u1ED8I CH\u1EE6 NGH\u0128A VI\u1EC6T NAM");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_2.setBounds(0, 0, 645, 38);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Socialist Republic of Vietnam");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(0, 31, 645, 26);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblBCngAn_1 = new JLabel("B\u1ED8 C\u00D4NG AN");
		lblBCngAn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBCngAn_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblBCngAn_1.setBounds(0, 60, 645, 38);
		panel_1.add(lblBCngAn_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ministry of Public Security");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(0, 86, 645, 26);
		panel_1.add(lblNewLabel_1_1_2);
		
		JLabel lblCcCnhSt_1 = new JLabel("C\u1EE4C C\u1EA2NH S\u00C1T GIAO TH\u00D4NG");
		lblCcCnhSt_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCcCnhSt_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCcCnhSt_1.setBounds(0, 113, 645, 38);
		panel_1.add(lblCcCnhSt_1);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("The Traffic Police Department");
		lblNewLabel_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_3.setBounds(0, 144, 645, 26);
		panel_1.add(lblNewLabel_1_1_1_3);
		
		JLabel lblChngNhnng_1 = new JLabel("CH\u1EE8NG NH\u1EACN \u0110\u0102NG K\u00DD");
		lblChngNhnng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblChngNhnng_1.setForeground(Color.RED);
		lblChngNhnng_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblChngNhnng_1.setBounds(0, 177, 645, 38);
		panel_1.add(lblChngNhnng_1);
		
		JLabel lblXeMT_1 = new JLabel("XE M\u00D4 T\u00D4 XE G\u1EAEN M\u00C1Y");
		lblXeMT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblXeMT_1.setForeground(Color.RED);
		lblXeMT_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblXeMT_1.setBounds(0, 212, 645, 38);
		panel_1.add(lblXeMT_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Motorbike Registration Certificate");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(0, 246, 645, 26);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("S\u1ED1(Number): ");
		lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_2_1.setBounds(0, 293, 645, 26);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.WHITE, 5));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(253, 242, 186));
		panel_2.setBounds(665, 10, 645, 359);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("T\u00EAn Ch\u1EE7 Xe (Full Name):");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(24, 24, 191, 26);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("\u0110\u1ECBa Ch\u1EC9(Address): ");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(24, 60, 144, 26);
		panel_2.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Nh\u00E3n hi\u1EC7u(Brand): ");
		lblNewLabel_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1.setBounds(24, 96, 144, 26);
		panel_2.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("S\u1ED1 Khung(Chassic N): ");
		lblNewLabel_1_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_1.setBounds(24, 132, 172, 26);
		panel_2.add(lblNewLabel_1_3_1_1_1);
		
		JLabel lblNewLabel_1_3_1_1_2 = new JLabel("M\u00E0u s\u01A1n (Color):");
		lblNewLabel_1_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_2.setBounds(24, 168, 135, 26);
		panel_2.add(lblNewLabel_1_3_1_1_2);
		
		JLabel lblNewLabel_1_3_1_1_3 = new JLabel("Ho\u1EA1t \u0111\u1ED9ng trong ph\u1EA1m vi:");
		lblNewLabel_1_3_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_3.setBounds(24, 204, 191, 26);
		panel_2.add(lblNewLabel_1_3_1_1_3);
		
		JLabel lblNewLabel_1_3_1_1_3_1 = new JLabel("Bi\u1EC3n s\u1ED1 \u0111\u0103ng k\u00FD");
		lblNewLabel_1_3_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3_1_1_3_1.setBounds(24, 259, 135, 26);
		panel_2.add(lblNewLabel_1_3_1_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1_4 = new JLabel("S\u1ED1 lo\u1EA1i (Model):");
		lblNewLabel_1_3_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_4.setBounds(337, 96, 135, 26);
		panel_2.add(lblNewLabel_1_3_1_1_4);
		
		JLabel lblNewLabel_1_3_1_1_3_2 = new JLabel("\u0110\u00E0 N\u1EB5ng, ng\u00E0y         th\u00E1ng         n\u0103m         ");
		lblNewLabel_1_3_1_1_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_3_2.setBounds(312, 221, 323, 26);
		panel_2.add(lblNewLabel_1_3_1_1_3_2);
		
		JLabel lblNewLabel_1_3_1_1_3_2_1 = new JLabel("C\u1EE5c tr\u01B0\u1EDFng");
		lblNewLabel_1_3_1_1_3_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_3_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_3_2_1.setBounds(396, 259, 91, 26);
		panel_2.add(lblNewLabel_1_3_1_1_3_2_1);
		
		JLabel lblNewLabel_1_3_1_1_3_2_1_1 = new JLabel("Nguy\u1EC5n Blblabalab");
		lblNewLabel_1_3_1_1_3_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1_1_3_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_3_1_1_3_2_1_1.setBounds(365, 295, 152, 26);
		panel_2.add(lblNewLabel_1_3_1_1_3_2_1_1);
	}
}
