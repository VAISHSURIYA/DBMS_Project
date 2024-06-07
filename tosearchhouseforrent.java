package com.studyopedia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import java.awt.Color;

public class agentlogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JTextField textField;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1_2;
	private JComboBox comboBox_1_1_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JTextField textField_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agentlogin frame = new agentlogin();
					frame.setVisible(true);
					frame.setTitle("Agent Login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public agentlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1373, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No. of BHK");
		lblNewLabel.setBounds(149, 114, 89, 22);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Area");
		lblNewLabel_2.setBounds(149, 180, 37, 22);
	
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setBounds(149, 246, 55, 27);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(187, 406, 137, 39);
		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
					Statement st=con.createStatement();
					String sql="select * from available where bhk=? and city=? and rentrange=?";
					
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1,(String)comboBox.getSelectedItem());
					System.out.println((String)comboBox.getSelectedItem());				
							pts.setString(2,(String)comboBox_1.getSelectedItem());
							System.out.println((String)comboBox_1.getSelectedItem());	
					pts.setString(3,(String)comboBox_1_1.getSelectedItem());
					System.out.println((String)comboBox_1_1.getSelectedItem());	
					ResultSet rs= pts.executeQuery();
					    DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("name"),rs.getString("bhk"),rs.getString("carparking"),rs.getString("area"),rs.getString("city"),rs.getString("rentrange")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"No house found");
					ec.printStackTrace();
				}
			
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Requirements");
		lblNewLabel_4.setBounds(326, 15, 193, 49);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel_4);
		
		 comboBox = new JComboBox();
		 comboBox.setBounds(350, 109, 72, 27);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		contentPane.add(comboBox);
		
		JLabel lblRent = new JLabel("Rent  Range");
		lblRent.setBounds(149, 316, 120, 27);
		lblRent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblRent);
		
		 comboBox_1_1 = new JComboBox();
		 comboBox_1_1.setBounds(350, 317, 169, 27);
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "5k - 10k", "10k - 15k", "15k - 20k", "20k - 25k"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(comboBox_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 183, 169, 27);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setBounds(350, 246, 169, 33);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Ariyalur", "Chengalpattu", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode", "Kallakurichi", "Kanchipuram", "Kanniyakumari", "Karur", "Krishnagiri", "Madurai", "Mayiladuthurai", "Nagapattinam", "Namakkal", "Nilgiris", "Perambalur", "Pudukkottai", "Ramanathapuram", "Salem", "Theni"}));
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 535, 1053, 154);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Name", "bhkno", "carparking", "area", "city", "rentrange"
			}
		));
		
		JLabel lblNewLabel_5 = new JLabel("No. of BHK");
		lblNewLabel_5.setBounds(874, 124, 99, 27);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_5);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setBounds(1098, 120, 72, 27);
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_1 = new JLabel("Car Parking");
		lblNewLabel_1.setBounds(874, 193, 126, 27);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setBounds(1098, 197, 72, 21);
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Yes", "No"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Area");
		lblNewLabel_2_1.setBounds(874, 246, 71, 27);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(1098, 246, 169, 27);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3_1 = new JLabel("City");
		lblNewLabel_3_1.setBounds(874, 306, 30, 22);
		
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3_1);
		
		 comboBox_1_2 = new JComboBox();
		 comboBox_1_2.setBounds(1098, 305, 159, 26);
		 
		 comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"", "Ariyalur", "Chengalpattu", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode", "Kallakurichi", "Kanchipuram", "Kanniyakumari", "Karur", "Krishnagiri", "Madurai", "Mayiladuthurai", "Nagapattinam", "Namakkal", "Nilgiris", "Perambalur", "Pudukkottai", "Ramanathapuram", "Salem", "Theni"}));
		comboBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(comboBox_1_2);
		
		JLabel lblRent_1 = new JLabel("Rent  Range");
		lblRent_1.setBounds(874, 365, 100, 22);
		
		lblRent_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblRent_1);
		
		 comboBox_1_1_1 = new JComboBox();
		 comboBox_1_1_1.setBounds(1098, 365, 93, 25);
		
		 comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"", "5k - 10k", "10k - 15k", "15k - 20k", "20k - 25k"}));
		comboBox_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(comboBox_1_1_1);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.setBounds(974, 430, 137, 39);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textField_2.getText();
				String bhkno=(String)comboBox_3.getSelectedItem();
				String carparking=(String)comboBox_2.getSelectedItem();
			   String area=textField.getText();
			   String city=(String)comboBox_1_2.getSelectedItem();
			   String rentrange=(String)comboBox_1_1_1.getSelectedItem();
			
				try {
					
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent","root","Varshini27@");
				    String query = "INSERT INTO book VALUES (?,?, ?, ?, ?,?)";
				    PreparedStatement pst = con.prepareStatement(query);
				    pst.setString(1, name);
				    pst.setString(2, bhkno);
				    pst.setString(3, carparking);
				    pst.setString(4,area);
				    pst.setString(5, city);
				    pst.setString(6,rentrange);
				    
				    String sql="delete from available WHERE carparking='"+carparking+"' ";
				    PreparedStatement pts=con.prepareStatement(sql);
				    pts.executeUpdate();
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "House Booked Successfully");
				        setVisible(false);
				        new image().setVisible(true);
				    } else {
				        JOptionPane.showMessageDialog(null, "Failed to Book");
				    }
				    
				    pst.close();
				    con.close();
				} catch (SQLException e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}
				
					
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnBook);
		
		JLabel lblNewLabel_5_1 = new JLabel("Username");
		lblNewLabel_5_1.setBounds(874, 64, 81, 22);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_5_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1098, 67, 96, 19);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JButton btnShowAll = new JButton("SHOW ALL");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new tabledisplay().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed",0);
				}
			}
		});
		btnShowAll.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnShowAll.setBounds(54, 472, 137, 39);
		contentPane.add(btnShowAll);
		
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(10, 15, 72, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
		        
		        comboBox.setSelectedIndex(-1);
		        comboBox_1.setSelectedIndex(-1);
		        comboBox_1_1.setSelectedIndex(-1);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBounds(398, 406, 137, 39);
		contentPane.add(btnCancel);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_2.setText("");
		        comboBox_2.setSelectedIndex(-1);
		        comboBox_3.setSelectedIndex(-1);
		        comboBox_1_2.setSelectedIndex(-1);
		        comboBox_1_1_1.setSelectedIndex(-1);
			}
		});
		btnCancel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel_1.setBounds(1191, 436, 112, 27);
		contentPane.add(btnCancel_1);
	}
}