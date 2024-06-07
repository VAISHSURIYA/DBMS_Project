package com.studyopedia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;

public class forget extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userf;
	private JPasswordField newpass1;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forget frame = new forget();
					frame.setVisible(true);
					frame.setTitle("Forget Password");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public forget() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("* Password must be combination of uppercase,lowercases and number !");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(399, 328, 408, 32);
		contentPane.add(lblNewLabel_3);
		
		newpass1 = new JPasswordField();
		newpass1.setBounds(399, 221, 185, 32);
		contentPane.add(newpass1);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(399, 286, 185, 32);
		contentPane.add(confirmpass);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					confirmpass.setEchoChar((char)0);
				}
				else {
				confirmpass.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(635, 297, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					newpass1.setEchoChar((char)0);
				}
				else {
					newpass1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(636, 233, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Forget Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(327, 46, 216, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(208, 159, 112, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(208, 221, 158, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(208, 285, 158, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		userf = new JTextField();
		userf.setBounds(397, 168, 187, 27);
		contentPane.add(userf);
		userf.setColumns(10);
		
		JButton btnNewButton = new JButton("Update Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = userf.getText();
					String np = newpass1.getText();	
					String cp = confirmpass.getText();
					if (!np.equals(cp)) {
                        JOptionPane.showMessageDialog(btnNewButton, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					String input = np;
					int inputLen = input.length();
					int uppercount=0;
					int lowercount=0;
		        	int digitcount=0;
					for(int j =0; j < inputLen ; j++)
					{
						char ch = input.charAt(j);
						if (Character.isUpperCase(ch))
							uppercount++;
						else if (Character.isLowerCase(ch))
							lowercount++;
						else if (Character.isDigit(ch))
							digitcount++;
					}
					System.out.print(uppercount);
					System.out.print(lowercount);
					System.out.print(digitcount);
					System.out.print(np);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)&& uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
							String sql2 = "update access set password = '"+np+"' where username = '"+use1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton, " Password changed successfully", "updated", -1);
							
						}
						else {
						     userf.setText("");
						     newpass1.setText("");
						     confirmpass.setText("");
						}
						i++;
					}
					}
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
				try {
					new DBMSProject().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
				}
			}
		});
		btnNewButton.setBackground(new Color(219, 112, 147));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(318, 398, 225, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\bg2.jpg"));
		lblNewLabel_2.setBounds(10, 0, 820, 548);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(635, 233, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}