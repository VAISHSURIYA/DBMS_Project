package com.studyopedia;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ownersignup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JComboBox comboBox_1;
    private JComboBox comboBox_2;
    public static String name;
    public static String phoneno;
    private JLabel eror_1;
    private JTextField textField_11;
	protected JComboBox comboBox_5;
	protected JComboBox comboBox_1_1_1;
	protected JComboBox comboBox_1_1;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ownersignup frame = new ownersignup();
                    frame.setVisible(true);
                    frame.setTitle("Owner Login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ownersignup() {
        setForeground(Color.BLACK);
        setFont(new Font("Dialog", Font.BOLD, 12));
        setTitle("House Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 805, 574);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Name    :");
        lblNewLabel.setBounds(20, 53, 82, 25);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("House Owner Details");
        lblNewLabel_1.setBounds(39, 10, 182, 25);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Phone no :");
        lblNewLabel_2.setBounds(20, 88, 82, 25);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBounds(102, 58, 119, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField(20);
        textField_1.setBounds(101, 93, 120, 19);
        eror_1 = new JLabel();
        eror_1.setBounds(232, 96, 145, 17);
        eror_1.setForeground(Color.RED);
        contentPane.add(eror_1);

        textField_1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validatePhoneNumber();
            }
            public void removeUpdate(DocumentEvent e) {
                validatePhoneNumber();
            }
            public void changedUpdate(DocumentEvent e) {
                validatePhoneNumber();
            }
        });
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("House Details");
        lblNewLabel_3.setBounds(37, 141, 158, 25);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Street ");
        lblNewLabel_4.setBounds(20, 211, 82, 25);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("House Name");
        lblNewLabel_5.setBounds(20, 188, 99, 13);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Area");
        lblNewLabel_6.setBounds(20, 246, 45, 13);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("City");
        lblNewLabel_7.setBounds(20, 275, 45, 19);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Pincode");
        lblNewLabel_8.setBounds(20, 312, 71, 13);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_8);
        
        textField_2 = new JTextField();
        textField_2.setBounds(125, 187, 128, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(125, 216, 128, 19);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setBounds(125, 245, 128, 19);
        contentPane.add(textField_4);
        textField_4.setColumns(10);
        
        textField_5 = new JTextField();
        textField_5.setBounds(125, 216, 128, 19);
        contentPane.add(textField_5);
        textField_5.setColumns(10);
        
        textField_6 = new JTextField();
        textField_6.setBounds(125, 311, 128, 19);
        contentPane.add(textField_6);
        textField_6.setColumns(10);
        
        JLabel lblNewLabel_9 = new JLabel("House Information");
        lblNewLabel_9.setBounds(494, 10, 158, 25);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("No of BHK");
        lblNewLabel_10.setBounds(432, 59, 99, 13);
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("Total Square Feet");
        lblNewLabel_11.setBounds(432, 88, 145, 25);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_11);
        
        JLabel lblNewLabel_12 = new JLabel("Parking");
        lblNewLabel_12.setBounds(432, 124, 99, 19);
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("Rent Range");
        lblNewLabel_13.setBounds(432, 153, 99, 19);
        lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_13);
        
        JLabel lblNewLabel_14 = new JLabel("Water Facility");
        lblNewLabel_14.setBounds(432, 185, 99, 19);
        lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_14);
        
        JLabel lblNewLabel_15 = new JLabel("Facing ");
        lblNewLabel_15.setBounds(432, 215, 99, 19);
        lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_15);
        
        textField_7 = new JTextField();
        textField_7.setBounds(582, 60, 120, 19);
        contentPane.add(textField_7);
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setBounds(582, 93, 120, 19);
        contentPane.add(textField_8);
        textField_8.setColumns(10);
        
        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(582, 124, 120, 19);
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
        contentPane.add(comboBox_1);
        
        comboBox_2 = new JComboBox();
        comboBox_2.setBounds(582, 154, 120, 19);
        comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"5k - 10k", "10k - 15k", "15k - 20k"}));
        contentPane.add(comboBox_2);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Corporation");
        rdbtnNewRadioButton.setBounds(576, 186, 103, 21);
        contentPane.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Borewell");
        rdbtnNewRadioButton_1.setBounds(681, 186, 103, 21);
        contentPane.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("East");
        rdbtnNewRadioButton_2.setBounds(576, 216, 103, 21);
        contentPane.add(rdbtnNewRadioButton_2);
        
        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("West");
        rdbtnNewRadioButton_3.setBounds(681, 216, 103, 21);
        contentPane.add(rdbtnNewRadioButton_3);
        
        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("North");
        rdbtnNewRadioButton_4.setBounds(576, 239, 103, 21);
        contentPane.add(rdbtnNewRadioButton_4);
        
        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("South");
        rdbtnNewRadioButton_5.setBounds(681, 239, 103, 21);
        contentPane.add(rdbtnNewRadioButton_5);
        
        JLabel lblNewLabel_18 = new JLabel("Additional Information");
        lblNewLabel_18.setBounds(39, 357, 212, 25);
        lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblNewLabel_18);
        
        JLabel lblNewLabel_19 = new JLabel("Resale");
        lblNewLabel_19.setBounds(20, 392, 99, 19);
        lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_19);
        
        JLabel lblNewLabel_20 = new JLabel("Ready to occupy");
        lblNewLabel_20.setBounds(20, 421, 119, 25);
        lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
        contentPane.add(lblNewLabel_20);
        
        textField_9 = new JTextField();
        textField_9.setBounds(140, 394, 114, 19);
        contentPane.add(textField_9);
        textField_9.setColumns(10);
        
        textField_10 = new JTextField();
        textField_10.setBounds(140, 426, 114, 19);
        contentPane.add(textField_10);
        textField_10.setColumns(10);
        
        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(544, 425, 85, 21);
        btnNewButton.addActionListener(new ActionListener() {
            
			

			private JFrame frame;

			public void actionPerformed(ActionEvent e) {
                name = textField.getText();
                phoneno = textField_1.getText();
                String housename = textField_2.getText();
                String street = textField_3.getText();
                String area = textField_4.getText();
                String city = textField_11.getText();
                String pincode = textField_6.getText();
                String bhk = textField_7.getText();
                String sqft = textField_8.getText();
                String carparking = comboBox_1.getSelectedItem().toString();
                
                String resale = textField_9.getText();
                String ready = textField_10.getText();
                
                String rentrange = comboBox_2.getSelectedItem().toString();
                // Database code to save the data
                try {
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/houserent", "root", "Varshini27@");
                    String query = "INSERT INTO available (name, bhk, carparking, area, city, rentrange) VALUES (?, ?, ?, ?, ?, ?)";
                    String query1="INSERT INTO ownerdetail VALUES (?, ?)";

                    PreparedStatement pst = con.prepareStatement(query);
                    PreparedStatement pst1 = con.prepareStatement(query1);

                    pst.setString(1, name);
                    pst.setString(2, bhk);
                    pst.setString(3, carparking);
                    pst.setString(4, area);
                    pst.setString(5, city);
                    pst.setString(6, rentrange);
                    pst1.setString(1, name);
                    pst1.setString(2, phoneno);

                    int rowsAffected1 = pst1.executeUpdate();
                    if (rowsAffected1 > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
                        setVisible(false);
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Insert in login details");
                    }
                    
                    
                       
            				frame=new JFrame();
            				if(JOptionPane.showConfirmDialog(frame, "confirm want to exit","Print System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            					System.exit(0);
            				}
            			
                        
                     else {
                        JOptionPane.showMessageDialog(null, "Failed to Insert house details");
                    }

                    pst.close();
                    con.close();

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            

            }
        });
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					new rent().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
        	}
        });
        btnNewButton_1.setBounds(682, 425, 85, 21);
        contentPane.add(btnNewButton_1);
        
        textField_11 = new JTextField();
        textField_11.setColumns(10);
        textField_11.setBounds(125, 277, 128, 19);
        contentPane.add(textField_11);
    }

    private void validatePhoneNumber() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String phoneNumber = textField_1.getText();
                Pattern pattern = Pattern.compile("^\\d{10}$");
                if (pattern.matcher(phoneNumber).matches()) {
                    eror_1.setText("Valid phone number");
                    eror_1.setForeground(Color.GREEN);
                } else {
                    eror_1.setText("Invalid phone number");
                    eror_1.setForeground(Color.RED);
                }
            }
        });
    }
}