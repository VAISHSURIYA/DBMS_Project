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

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ourservice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ourservice frame = new ourservice();
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
	public ourservice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1478, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("protects your investment.");
		lblNewLabel_2_1_3.setBounds(925, 431, 367, 34);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("smooth rental experience and");
		lblNewLabel_2_1_2.setBounds(919, 381, 367, 34);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Proper management ensures a ");
		lblNewLabel_2_2.setBounds(919, 326, 343, 34);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("    for both owners and tenants.");
		lblNewLabel_2_1_1_1.setBounds(124, 476, 396, 34);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("profitable, providing a positive experience");
		lblNewLabel_2_1_1.setBounds(147, 431, 396, 34);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Effective rental management ensures ");
		lblNewLabel_2.setBounds(149, 337, 343, 34);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" properties are well-maintained and ");
		lblNewLabel_2_1.setBounds(137, 381, 367, 34);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Custom Property Management");
		lblNewLabel_1_2.setBounds(919, 264, 343, 34);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("Rental Management");
		lblNewLabel_1.setBounds(209, 264, 212, 34);
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Our Service includes");
		lblNewLabel.setBounds(498, 66, 423, 79);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(834, 239, 458, 342);
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\bluebg1.jpg"));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(88, 239, 458, 342);
		lblNewLabel_1_1_1.setIcon(new ImageIcon("E:\\bluebg1.jpg"));
		lblNewLabel_1_1_1.setBackground(new Color(135, 206, 250));
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Tenant Login");
		btnNewButton.setBounds(214, 611, 149, 34);
		btnNewButton.setBackground(new Color(219, 112, 147));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DBMSProject().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed",0);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnOwnerLogin = new JButton("Owner Login");
		btnOwnerLogin.setBounds(1007, 611, 140, 31);
		btnOwnerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new rent().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed",0);
				}
			}
		});
		btnOwnerLogin.setBackground(new Color(218, 112, 214));
		btnOwnerLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnOwnerLogin);
	}
}