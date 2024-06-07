package com.studyopedia;
import com.studyopedia.ownersignup;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class image extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					image frame = new image();
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
	public image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1384, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOUSE DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(300, 50, 173, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(189, 118, 101, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PHONE NO :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(189, 170, 148, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AREA :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(189, 222, 101, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("CITY :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1_2.setBounds(189, 274, 148, 42);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("RENT RANGE :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(189, 326, 187, 34);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(359, 397, 114, 34);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(359, 124, 267, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(359, 173, 267, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(359, 222, 267, 24);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(359, 289, 267, 24);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(359, 339, 267, 24);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Show detail");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
				Statement st=con.createStatement();
				
				String sql = "select * from ownerdetail natural join book where name ='"+ownersignup.name+"'";
				PreparedStatement pts=con.prepareStatement(sql);
				ResultSet rs= pts.executeQuery();
				//DefaultTableModel dt=(DefaultTableModel)table_3.getModel();
				//dt.setRowCount(0);
				while(rs.next()) {
					
				
					String f=rs.getString("name");
					String v=rs.getString("phoneno");
					String s=rs.getString("area");
					String t=rs.getString("city");
					String u=rs.getString("rentrange");
					textField.setText(f);
					textField_1.setText(v);
					textField_2.setText(s);
					textField_3.setText(t);
					textField_4.setText(u);
					
					
					
			   
				
				}
		}
			catch(Exception ec) {
				JOptionPane.showMessageDialog(null,"it has not been registered");
				ec.printStackTrace();
			}
			}
		});
		btnNewButton_1.setBounds(57, 28, 101, 34);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
	
		textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		textArea.setBorder(new LineBorder(new Color(0,0,0),4));
		textArea.setBounds(740, 10, 620, 633);
		contentPane.add(textArea);
		
		JButton btnNewButton_2 = new JButton("Add Records");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("\n\n\n"+
						"\t\t HomeHub Rental Application\n\n"+
						
						"\t\t     BILL SUMMARY\n\n"+
						"Reference NO:478405" +
						"\n=======================================================\n\n"+
						"Owner Name:\t\t\t"+textField.getText()+"\n"+
						"-------------------------------------------------------\n"+
						
						"Phone no:\t\t\t"+textField_1.getText()+"\n"+
						"-------------------------------------------------------\n"+
						"Area:\t\t\t\t"+textField_2.getText()+"\n"+
						"-------------------------------------------------------\n\n"+
						"City:\t\t\t\t"+textField_3.getText()+"\n"+
						"-------------------------------------------------------\n\n"+
						"Rent Range:\t\t\t"+textField_4.getText()+"\n"+
						"-------------------------------------------------------\n\n"+
						
						"=========================================================\n\n\n\n\n"+
						"This Residential Lease Agreement (\"Agreement\") is made\n"
						+ " and entered into on [Date] by and between:\r\n"
						+ "\r\n"
						+ "Landlord:\r\n"
						+ "Name: [Landlord's Full Name]\r\n"
						
						+ "Phone: [Landlord's Phone Number]\r\n"
						
						+ "\r\n"
						+ "Tenant:\r\n"
						+ "Name: [Tenant's Full Name]\r\n"
						+ "Address: [Tenant's Current Address]\r\n"
						+ "Phone: [Tenant's Phone Number]\r\n"
						+ "Email: [Tenant's Email Address]\r\n"
						+ "\r\n"
						+ "Property:\r\n"
						+ "Address: [Rental Property Address]\r\n"
						+ "\r\n"
						+ "Term of Lease:\r\n"
						+ "\r\n"
						+ "The term of this lease shall commence on [Start Date]\n"
						+ " and shall continue until [End Date].\r\n"
						+ "Rent:\r\n"
						+ "2. The total rent for the term of this lease is \n"
						+"$[Total Rent Amount],payable in monthly installments\n"
						+ " of $[Monthly Rent Amount] due on the [Due Day] day \n"
						+"of each month.\r\n"
					
						+ "Security Deposit:\r\n"
						+ "3. The Tenant shall pay a security deposit of \n "
						+"$[Security Deposit Amount]\n"
						+ " upon signing this Agreement. The security deposit\n"
						+ " will be held by the Landlord\n"
						+ " as security for the performance of the Tenant's \n"
						+ "obligations and will be\n"
						+ " refunded within [Number] days after the end of the\n "
						+ "\nlease term, subject  to any deductions for damages\n"
						+ " or unpaid rent.\r\n"
						
						+ "Utilities:\r\n"
						+ "4. The Tenant shall be responsible for payment of\n"
						+ " all utilities and services,except for [Specify any\n"
						+ " utilities or services the Landlord will pay for],\n"
						+ " which will be provided by the Landlord.\r\n"
						+ "\r\n"
						+ "Use of Property:\r\n"
						+ "5. The Property shall be used solely as a private\n"
						+ " residence by the Tenant and shall not be used for \n"
						+ "any commercial purposes.\r\n"
						+ "\r\n"
						+ "Maintenance and Repairs:\r\n"
						+ "6. The Tenant shall keep the Property in a clean\n"
						+ " and sanitary condition and shall be responsible for \n"
						+ "any damage caused by the Tenant or the Tenant's guests.\n"
						+ " The Landlord shall be responsible for all major\n"
						+ " repairs not caused by the Tenant's negligence.\r\n"
						+ "\r\n"
						+ "Pets:\r\n"
						+ "7. Pets [are/are not] allowed on the Property.\n "
						+ "[If pets are allowed, include any specific conditions\n"
						+ " or additional deposits required.]\r\n"
						+ "\r\n"
						+ "Smoking:\r\n"
						+ "8. Smoking [is/is not] permitted inside the Property.\r\n"
						+ "\r\n"
						+ "Termination:\r\n"
						+ "9. Either party may terminate this Agreement by \n"
						+ "providing"
						+ " [Number] days' written notice to the other party.\n"
						+ " Early termination by the Tenant will result in a\n"
						+ " penalty of $[Penalty Amount] unless otherwise \n"
						+ "agreed upon in writing.\n"
						+ "\r\n"
						+ "Entry and Inspection:\r\n"
						+ "10. The Landlord may enter the Property at reasonable\n"
						+ " times and with reasonable notice to inspect the Property\n"
						+ " or make necessary repairs, except inemergencies where"
						+ " no "
						+ "notice is required.\r\n"
						+ "\r\n"
						+ "Insurance:\r\n"
						+ "11. The Tenant is advised to obtain renter's insurance \n"
						+ "to cover personal belongings and liability.\r\n"
						+ "\r\n"
						+ "Default:\r\n"
						+ "12. If the Tenant fails to pay rent when due or breaches\n"
						+ " any other term of this Agreement, the Landlord may \n"
						+ "terminate this Agreement\n in accordance\n"
						+ " with state law and seek any other legal remedies.\r\n"
						+ "\r\n"
						+ "Governing Law:\r\n"
						+ "13. This Agreement shall be governed by and construed in\n"
						+ "accordance with the laws of the state of [State].\r\n"
						+ "\r\n"
						+ "Entire Agreement:\r\n"
						+ "14. This Agreement constitutes the entire agreement\n"
						+ " between the parties and supersedes all prior agreements\n"
						+ " and "
						+ "understandings\n"
						+ "Any modifications to this \n"
						+ "Agreement must be made in writing and signed by both \n"
						+ "parties.\r\n"
						
						+ "Severability:\r\n"
						+ "15. If any provision of this Agreement is found to be \n"
						+ "invalid or unenforceable,the remaining provisions shall"
						+ " remain in full force and effect.\r\n"
						
						+ "Notices:\r\n"
						+ "16. Any notices required under this Agreement shall be \n"
						+ "in writing and delivered to the addresses provided above.\n"
						+ "\r\n"
						+ "Signatures:\r\n"
						+ "\r\n"
						+ "Landlord's Signature\r\n"
						+ "Date: _______\r\n"
						+ "\r\n"
						+ "Tenant's Signature\r\n"
						+ "Date: _______\r\n"
						+ "\r\n"
						+ "By signing this Agreement, the Tenant acknowledges \n"
						+ "having read and understood all the terms and \n"
						+ "conditions contained \n"
						+ "herein.\r\n"
						+ "\r\n"
						+ "Witness (if required):\r\n"
						+ "\r\n"
						+ "Witness's Signature\r\n"
						+ "Date: _______\n"+
						"\t\tTHANK YOU FOR BOOKING HOUSE:))\n"+
						"   \n\n\n         "
						+" Stay connected with us to enjoy your livings\n"
						
						
						
						);

			}
		});
		btnNewButton_2.setBounds(81, 507, 114, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Print");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setBounds(252, 509, 85, 31);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Clear");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
			}
		});
		btnNewButton_2_2.setBounds(405, 507, 85, 34);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Exit");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			private JFrame frame;

			public void actionPerformed(ActionEvent e) {
				frame=new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "confirm want to exit","Print System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnNewButton_2_3.setBounds(560, 507, 85, 34);
		contentPane.add(btnNewButton_2_3);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\mod.jpg"));

		lblNewLabel_3.setBounds(12, 8, 718, 635);
		getContentPane().add(lblNewLabel_3);

	}
}