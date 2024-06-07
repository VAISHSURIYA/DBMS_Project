package com.studyopedia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class ownerlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("USERNAME :");
	private JTextField userss;
	private JPasswordField passs;
	private JPasswordField passwordField_1;
	private Component error;
	private JLabel eror_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownerlogin frame = new ownerlogin();
					frame.setVisible(true);
					frame.setTitle("Owner Sign Up");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ownerlogin() {
		setTitle("Owner signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show Password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					passwordField_1.setEchoChar((char)0);
				}
				else {
					passwordField_1.setEchoChar('*');
				}
			}
		});
		rdbtnNewRadioButton_1.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton_1.setBounds(708, 317, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
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
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setBounds(618, 239, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("* Password must be comination of uppercase, lowercases and numbers !");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setBounds(369, 258, 414, 21);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(144, 151, 166, 31);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(144, 222, 166, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONFIRM PASSWORD:");
		lblNewLabel_1_2.setForeground(SystemColor.desktop);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(144, 300, 295, 42);
		contentPane.add(lblNewLabel_1_2);
		
		userss = new JTextField();
		userss.setBounds(359, 151, 230, 31);
		contentPane.add(userss);
		userss.setColumns(10);
		
		passs = new JPasswordField();
		passs.setBounds(359, 228, 230, 31);
		contentPane.add(passs);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(465, 311, 230, 31);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			
			private JLabel eror;
			public void actionPerformed(ActionEvent e) {
				try {
		            int er = 0;
		            String us = userss.getText();
					String np = passs.getText();

		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent", "root", "Varshini27@");
		            System.out.println("Database connected");

		            String sql2 = "SELECT COUNT(*) AS COUNT FROM houseowner";
		            PreparedStatement ps2 = con.prepareStatement(sql2);
		            ResultSet res2 = ps2.executeQuery();
		            res2.next();
		            int c = res2.getInt(1) + 2;

		            String sql = "SELECT * FROM houseowner";
		            PreparedStatement ps1 = con.prepareStatement(sql);
		            ResultSet res1 = ps1.executeQuery();

		            int uppercount = 0, lowercount = 0, digitcount = 0;
		            for (char ch : np.toCharArray()) {
		                if (Character.isUpperCase(ch)) uppercount++;
		                else if (Character.isLowerCase(ch)) lowercount++;
		                else if (Character.isDigit(ch)) digitcount++;
		            }

		            System.out.println("Uppercase count: " + uppercount);
		            System.out.println("Lowercase count: " + lowercount);
		            System.out.println("Digit count: " + digitcount);
		            System.out.println("Password: " + np);

		            boolean isUsernameUnique = true;
		            while (res1.next()) {
		                String use1 = res1.getString("username");
		                if (us.equals(use1)) {
		                    isUsernameUnique = false;
		                    break;
		                }
		            }

		            if (isUsernameUnique && uppercount >= 1 && lowercount >= 3 && digitcount >= 1) {
		                er = 1;
		                String sql3 = "INSERT INTO houseowner (username, password) VALUES (?, ?)";
		                PreparedStatement pts = con.prepareStatement(sql3);
		                pts.setString(1, us);
		                pts.setString(2, np);
		                pts.executeUpdate();
		                System.out.println("Values inserted");

		                try {
		                    new rent().setVisible(true);
		                    SwingUtilities.windowForComponent(btnNewButton).dispose();
		                    JOptionPane.showMessageDialog(btnNewButton, "Account created");
		                } catch (Exception o) {
		                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                eror_1.setText("Password must contain uppercase, lowercase, number!");
		                if (!isUsernameUnique) {
		                    eror_1.setText("Username already exists!");
		                }
		            }

		            res1.close();
		            ps1.close();
		            res2.close();
		            ps2.close();
		            con.close();
		        } catch (Exception r) {
		            r.printStackTrace();
		        }
	}
		
					
				
			
		});
		btnNewButton.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		btnNewButton.setBounds(341, 407, 113, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new rent().setVisible(true);
					SwingUtilities.windowForComponent(btnBack).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnBack, this, "Error while establishing connection failed",0);
				}
				
			

			}
		});
		btnBack.setFont(new Font("Lucida Handwriting", Font.PLAIN, 17));
		btnBack.setBounds(89, 407, 90, 31);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("SIGN UP PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(279, 61, 175, 31);
		contentPane.add(lblNewLabel);
		
	     eror_1 =  new JLabel("");
	     eror_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eror_1.setForeground(new Color(127, 255, 0));
		eror_1.setBackground(new Color(0, 0, 0));
		eror_1.setBounds(300, 352, 498, 30);
		contentPane.add(eror_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\pic1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 841, 538);
		contentPane.add(lblNewLabel_2);
	}
}