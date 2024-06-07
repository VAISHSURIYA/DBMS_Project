package com.studyopedia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;
    private JTextField captchaInput;
    private JLabel captchaLabel;
    private JLabel error;
    private JButton btnNewButton_1;
    private JButton btnBack;
    private JLabel lblNewLabel_1;
    public static String us;
    private String captchaString;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    rent frame = new rent();
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
    public rent() {
        setTitle("Owner login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 915, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblNewLabel.setBounds(193, 117, 165, 45);
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblPassword.setBounds(193, 209, 153, 34);
        contentPane.add(lblPassword);

        user = new JTextField();
        user.setBounds(406, 130, 197, 34);
        contentPane.add(user);
        user.setColumns(10);

        pass = new JPasswordField();
        pass.setBounds(406, 209, 197, 34);
        contentPane.add(pass);

        JLabel captchaLabelTitle = new JLabel("Captcha");
        captchaLabelTitle.setFont(new Font("Tahoma", Font.BOLD, 27));
        captchaLabelTitle.setBounds(193, 301, 153, 34);
        contentPane.add(captchaLabelTitle);

        captchaInput = new JTextField();
        captchaInput.setBounds(565, 324, 197, 34);
        contentPane.add(captchaInput);
        captchaInput.setColumns(10);

        captchaLabel = new JLabel();
        captchaLabel.setBounds(385, 318, 160, 40);
        contentPane.add(captchaLabel);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setFont(new Font("MV Boli", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int er = 0;
                    us = user.getText();
                    String ps = new String(pass.getPassword());
                    String captchaInputText = captchaInput.getText();

                    // CAPTCHA validation
                    if (!captchaInputText.equals(captchaString)) {
                        error.setText("Incorrect CAPTCHA");
                        error.setVisible(true);
                        resetCaptcha();
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent", "root", "Varshini27@");
                    Statement st = con.createStatement();
                    String sql = "Select * from houseowner";
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        String username = rs.getString("username");
                        String password = rs.getString("password");

                        if (us.equals(username) && ps.equals(password)) {
                            new ownersignup().setVisible(true);
                            SwingUtilities.windowForComponent(btnNewButton).dispose();
                            return; // Successful login, exit the method
                        }
                    }
                    // If we reach here, login failed
                    user.setText("");
                    pass.setText("");
                    error.setText("Incorrect username or password");
                    error.setVisible(true);
                    resetCaptcha();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(333, 399, 102, 45);
        contentPane.add(btnNewButton);

        error = new JLabel("");
        error.setBackground(new Color(0, 0, 0));
        error.setForeground(new Color(255, 0, 0));
        error.setBounds(222, 73, 503, 34);
        contentPane.add(error);

        btnNewButton_1 = new JButton("Sign Up");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ownerlogin().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton_1).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton_1, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton_1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        btnNewButton_1.setBounds(531, 399, 119, 45);
        contentPane.add(btnNewButton_1);

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
        rdbtnNewRadioButton.setBounds(406, 261, 123, 19);
        contentPane.add(rdbtnNewRadioButton);

        JButton btnForgetPassword = new JButton("Forget Password");
        btnForgetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ownerforget().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnForgetPassword.setForeground(new Color(128, 64, 64));
        btnForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnForgetPassword.setBackground(new Color(123, 104, 238));
        btnForgetPassword.setBounds(458, 283, 179, 25);
        contentPane.add(btnForgetPassword);

        btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ourservice().setVisible(true);
                    SwingUtilities.windowForComponent(btnNewButton).dispose();
                } catch (Exception o) {
                    JOptionPane.showMessageDialog(btnNewButton, "Error while establishing connection", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBack.setFont(new Font("MV Boli", Font.PLAIN, 20));
        btnBack.setBounds(125, 399, 102, 45);
        contentPane.add(btnBack);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("E:\\Image for Dbms.jpg"));
        lblNewLabel_1.setBounds(0, 0, 901, 523);
        contentPane.add(lblNewLabel_1);

        generateCaptcha();
        displayCaptcha();
    }

    // Generate a random CAPTCHA string with uppercase, lowercase letters, and numbers
    private void generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder captcha = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            captcha.append(chars.charAt(rand.nextInt(chars.length())));
        }
        captchaString = captcha.toString();
    }

    // Create CAPTCHA image from the CAPTCHA string
    private BufferedImage createCaptchaImage(String captchaText) {
        int width = 160;
        int height = 40;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        g.drawString(captchaText, 10, 30);
        g.dispose();
        return bufferedImage;
    }

    // Display CAPTCHA image in the label
    private void displayCaptcha() {
        BufferedImage captchaImage = createCaptchaImage(captchaString);
        captchaLabel.setIcon(new ImageIcon(captchaImage));
    }

    // Reset CAPTCHA after incorrect login attempt
    private void resetCaptcha() {
        captchaInput.setText("");
        generateCaptcha();
        displayCaptcha();
    }
}