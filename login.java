package com.studyopedia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMSProject extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField user;
    private JPasswordField pass;
    private JTextField captchaInput;
    private JLabel error;
    private JLabel captchaImage;
    private String captchaText;
	private Component btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DBMSProject frame = new DBMSProject();
                    frame.setVisible(true);
                    frame.setTitle("Login Page");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DBMSProject() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton_2 = new JButton("BACK");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ourservice().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton_2).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton_2, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(110, 468, 85, 31);
        contentPane.add(btnNewButton_2);

        error = new JLabel("");
        error.setBackground(Color.RED);
        error.setForeground(Color.RED);
        error.setFont(new Font("Times New Roman", Font.BOLD, 20));
        error.setBounds(226, 101, 341, 72);
        contentPane.add(error);

        JLabel lblNewLabel = new JLabel("LOGIN PAGE");
        lblNewLabel.setForeground(new Color(128, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblNewLabel.setBounds(290, 36, 258, 55);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("USERNAME :");
        lblNewLabel_1.setForeground(new Color(248, 248, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_1.setBounds(196, 184, 166, 42);
        contentPane.add(lblNewLabel_1);

        user = new JTextField();
        user.setBounds(379, 180, 200, 35);
        contentPane.add(user);
        user.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD :");
        lblNewLabel_2.setForeground(new Color(240, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(196, 253, 166, 42);
        contentPane.add(lblNewLabel_2);

        pass = new JPasswordField();
        pass.setBounds(379, 263, 200, 35);
        contentPane.add(pass);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(379, 315, 123, 19);
        contentPane.add(rdbtnNewRadioButton);

        captchaImage = new JLabel();
        captchaImage.setBounds(379, 350, 200, 50);
        contentPane.add(captchaImage);
        refreshCaptcha();

        captchaInput = new JTextField();
        captchaInput.setBounds(379, 410, 200, 35);
        contentPane.add(captchaInput);

        JButton refreshCaptchaButton = new JButton("Refresh CAPTCHA");
        refreshCaptchaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshCaptcha();
            }
        });
        refreshCaptchaButton.setBounds(589, 410, 150, 35);
        contentPane.add(refreshCaptchaButton);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setForeground(new Color(210, 105, 30));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBackground(new Color(139, 0, 139));
        btnNewButton.setBounds(325, 468, 111, 35);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Sign Up");
        btnNewButton_1.setForeground(new Color(139, 69, 19));
        btnNewButton_1.setBackground(new Color(221, 160, 221));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new signup().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton_1).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton_1, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_1.setBounds(564, 468, 103, 35);
        contentPane.add(btnNewButton_1);

        JButton btnForgetPassword = new JButton("Forget Password");
        btnForgetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new forget().setVisible(true);
                    SwingUtilities.windowForComponent(btnForgetPassword).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnForgetPassword, "Error while establishing connection failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnForgetPassword.setForeground(new Color(128, 64, 64));
        btnForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnForgetPassword.setBackground(new Color(123, 104, 238));
        btnForgetPassword.setBounds(536, 308, 188, 31);
        contentPane.add(btnForgetPassword);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBackground(new Color(192, 192, 192));
        lblNewLabel_3.setIcon(new ImageIcon("E:\\pic1.jpg"));
        lblNewLabel_3.setBounds(10, 10, 866, 543);
        contentPane.add(lblNewLabel_3);
    }

    private void refreshCaptcha() {
        captchaText = generateCaptchaText();
        BufferedImage captcha = generateCaptchaImage(captchaText);
        ImageIcon icon = new ImageIcon(captcha);
        captchaImage.setIcon(icon);
    }

    private String generateCaptchaText() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    private BufferedImage generateCaptchaImage(String text) {
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.setColor(Color.BLACK);
        g.drawString(text, 20, 40);
        g.dispose();
        return image;
    }

    private void loginAction() {
        try {
            String us = user.getText();
            String ps = new String(pass.getPassword());
            String inputCaptcha = captchaInput.getText();

            if (!inputCaptcha.equals(captchaText)) {
                error.setText("Incorrect CAPTCHA");
                error.setVisible(true);
                refreshCaptcha();
                return;
            }
            int er=0;
			 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(ps);
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
			System.out.println("1");
			Statement st = con.createStatement();
			System.out.println("1");
			String sql = "Select * from access";
			System.out.println("1");
			ResultSet rs = st.executeQuery(sql);
			System.out.println("1");
			while(rs.next()){
			String username = rs.getString("username");
			System.out.println("1-");
			String password = rs.getString("password");
			System.out.println("1-");

			if(us.equals(username) && ps.equals(password)){
			new works().setVisible(true);
			System.out.println("true");
			SwingUtilities.windowForComponent(btnNewButton).dispose();
			er=0;
			}
			else{
				user.setText("");
				pass.setText("");
				System.out.println("false");
				er=1;
				continue;
				}

		}
			if(er==1) {
				error.setVisible(true);
				error.setText("incorrect password or username");
				}
			}
		catch(Exception o) {
			JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
		}

            
    }

}