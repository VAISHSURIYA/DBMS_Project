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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class agentsignup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField users;
	private JLabel eror_1;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	private JTextField textField;
	private JPasswordField passs;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agentsignup frame = new agentsignup();
					frame.setVisible(true);
					frame.setTitle("Agent SignUp");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public agentsignup() {
		setTitle("Agent SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show");
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
		
		JLabel lblNewLabel_2 = new JLabel("* Password mus be combination of uppercase,lowercases and numbers !");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(403, 366, 400, 21);
		contentPane.add(lblNewLabel_2);
		rdbtnNewRadioButton_1.setBounds(699, 331, 62, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					passs.setEchoChar((char)0);
				}
				else {
				passs.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton.setBounds(699, 245, 62, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(403, 322, 280, 34);
		contentPane.add(confirmpass);
		
		passs = new JPasswordField();
		passs.setBounds(403, 239, 280, 34);
		contentPane.add(passs);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblConfirmPassword.setBounds(176, 315, 204, 41);
		contentPane.add(lblConfirmPassword);
		
		eror_1 = new JLabel("");
		eror_1.setForeground(new Color(255, 0, 0));
		eror_1.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		eror_1.setBounds(253, 290, 567, 34);
		contentPane.add(eror_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(176, 141, 204, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(176, 239, 204, 41);
		contentPane.add(lblPassword);
		
		users = new JTextField();
		users.setBounds(403, 151, 280, 34);
		contentPane.add(users);
		users.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel eror;

			public void actionPerformed(ActionEvent e) {
				try{
				int er=0;	
				String us = users.getText();
				String np = passs.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
				System.out.println("1");
				Statement st = con.createStatement();
				String sql2 = "select count(*) as COUNT from access";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet res2 = ps2.executeQuery();
				String sql = "SELECT * FROM access";
				ResultSet res1 = st.executeQuery(sql);
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
				int c = 0;
				while(res2.next()) {
					c = res2.getInt(1);
					
				}
				c=c+2;
				while(res1.next()) {
					String use1 = res1.getString("username");
					if(us!=use1 && uppercount>=1 && lowercount>=3 && digitcount>=1) {
						er=1;
						String sql3 = "insert into access values('"+us+"','"+np+"')";
						PreparedStatement pts = con.prepareStatement(sql3);
						pts.executeUpdate(sql3);
						try {
							new DBMSProject().setVisible(true);
							SwingUtilities.windowForComponent(btnNewButton).dispose();
							JOptionPane.showMessageDialog(btnNewButton,"Account created");
						}
						catch(Exception o) {
							JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
						}
						break;
					
					}
				}
				if(er==0) {
					
					eror_1.setText("Password must contain uppercase,lowercase,number !");
				}
				}
				catch(Exception r) {
				r.printStackTrace();       }
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(365, 391, 121, 41);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new signup().setVisible(true);
					SwingUtilities.windowForComponent(btnBack).dispose();
					
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnBack,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBounds(153, 391, 121, 41);
		contentPane.add(btnBack);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\mod.jpg"));
		lblNewLabel_1.setBounds(0, -4, 830, 538);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(403, 322, 280, 34);
		contentPane.add(textField);
	}
}