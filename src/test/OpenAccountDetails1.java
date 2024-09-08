package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OpenAccountDetails1 extends JFrame
{
	Random rdm = new Random();
	long first4 = (rdm.nextLong() % 9000L) + 1000L;
	long first = Math.abs(first4);
	
	JLabel warningNoteJLabel = new JLabel("Remember the Application form number carefully note down it");
	
    JLabel applicationFormNoJLabel = new JLabel("APPLICATION FORM NO. :"+"  "+first);
    JLabel subheadingJLabel = new JLabel("Page 1: Personal Details");
    JLabel fullNameJLabel = new JLabel("Full Name :");
    JLabel fatherNameJLabel = new JLabel("Father's Name :");
    JLabel dateofbirthJLabel = new JLabel("Date Of Bith :");
    JLabel genderJLabel = new JLabel("Gender :");
    JLabel emailaddressJLabel = new JLabel("Email Address :");
    JLabel maritalstatusJLabel = new JLabel("Marital Status :");
    JLabel mobileNoJLabel = new JLabel("Mobile No :"); 
    JLabel addressJLabel = new JLabel("Address :");
    JLabel cityJLabel = new JLabel("City :");
    JLabel pincodeJLabel = new JLabel("Pin Code :");
    JLabel stateJLabel = new JLabel("State :");
    JLabel dateJLabel = new JLabel("Date");
    JLabel monthJLabel = new JLabel("Month");
    JLabel yearJLabel = new JLabel("Year");
    
    JTextField fullnameJTextField = new JTextField();
    JTextField fathernameJTextField = new JTextField();
    JTextField mobileNoJTextField = new JTextField(); 
    JTextField emailaddressJTextField  = new JTextField();
    JTextField addressJTextField = new JTextField();
    JTextField cityJTextField = new JTextField();
    JTextField pincodeJTextField = new JTextField();
    JTextField stateJTextField = new JTextField();
    
    ButtonGroup group = new ButtonGroup();
    JRadioButton maleJRadioButton = new JRadioButton("Male");
    JRadioButton femaleJRadioButton = new JRadioButton("Female");
    JRadioButton otherJRadioButton = new JRadioButton("Other");
    
    ButtonGroup groupformaritailStatus = new ButtonGroup();
    JRadioButton marriedJRadioButton = new JRadioButton("Married");
    JRadioButton unmarriedJRadioButton = new JRadioButton("Unmarried");
    
    String [] Dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    JComboBox<String> datesJComboBox = new JComboBox<String>(Dates);
    
    String [] Months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    JComboBox<String> monthsJComboBox = new JComboBox<String>(Months);
    
    String [] Years = {"1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"};
    
    JComboBox<String> yearsJComboBox = new JComboBox<String>(Years);
    
    JButton nextJButton = new JButton("NEXT >>");
    JButton cancelJButton = new JButton("CANCEL");
     
    public OpenAccountDetails1() 
    {
		setSize(750, 800);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAAGE 1");
		setLayout(null);
		setLocation(400, 5);

		add(applicationFormNoJLabel);
		applicationFormNoJLabel.setBounds(160, 10, 380, 30);
		applicationFormNoJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(subheadingJLabel);
		subheadingJLabel.setBounds(225, 50, 250, 22);
		subheadingJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(fullNameJLabel);
		fullNameJLabel.setBounds(70, 120, 200, 20);
		fullNameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(fullnameJTextField);
		fullnameJTextField.setBounds(290, 120, 350, 25);
		fullnameJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(fatherNameJLabel);
		fatherNameJLabel.setBounds(70, 170, 200, 20);
		fatherNameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(fathernameJTextField);
		fathernameJTextField.setBounds(290, 170, 350, 25);
		fathernameJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(dateofbirthJLabel);
		dateofbirthJLabel.setBounds(70, 220, 200, 20);
		dateofbirthJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	
		add(dateJLabel);
		dateJLabel.setBounds(290, 222, 40, 20);
		dateJLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		add(datesJComboBox);
		datesJComboBox.setBounds(335, 221, 45, 25);
		datesJComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		datesJComboBox.setBackground(Color.WHITE);
		
		add(monthJLabel);
		monthJLabel.setBounds(390, 222, 60, 20);
		monthJLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		add(monthsJComboBox);
		monthsJComboBox.setBounds(450, 221, 100, 25);
		monthsJComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		monthsJComboBox.setBackground(Color.WHITE);
		
		add(yearJLabel);
		yearJLabel.setBounds(565, 222, 45, 20);
		yearJLabel.setFont(new Font("Aria", Font.PLAIN, 18));
		add(yearsJComboBox);
		yearsJComboBox.setBounds(610, 221, 70, 25);
		yearsJComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		yearsJComboBox.setBackground(Color.WHITE);
		
		add(genderJLabel);
		genderJLabel.setBounds(70, 270, 200, 20);
		genderJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		group.add(maleJRadioButton);
		group.add(femaleJRadioButton);
		group.add(otherJRadioButton);
		add(maleJRadioButton);
		maleJRadioButton.setBounds(300, 270, 100, 20);
		maleJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		maleJRadioButton.setBackground(Color.WHITE);
		add(femaleJRadioButton);
		femaleJRadioButton.setBounds(410, 270, 100, 20);
		femaleJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		femaleJRadioButton.setBackground(Color.WHITE);
		add(otherJRadioButton);
		otherJRadioButton.setBounds(540, 270, 100, 20);
		otherJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		otherJRadioButton.setBackground(Color.WHITE);
		
		add(mobileNoJLabel);
		mobileNoJLabel.setBounds(70, 320, 200, 20);
		mobileNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(mobileNoJTextField);
		mobileNoJTextField.setBounds(290, 320, 350, 25);
		mobileNoJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(emailaddressJLabel);
		emailaddressJLabel.setBounds(70, 370, 200, 20);
		emailaddressJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(emailaddressJTextField);
		emailaddressJTextField.setBounds(290, 370, 350, 25);
		emailaddressJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(maritalstatusJLabel);
		maritalstatusJLabel.setBounds(70, 420, 200, 20);
		maritalstatusJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		groupformaritailStatus.add(marriedJRadioButton);
		groupformaritailStatus.add(unmarriedJRadioButton);
		
		add(marriedJRadioButton);
		marriedJRadioButton.setBounds(290, 420, 100, 21);
		marriedJRadioButton.setFont(new Font("Arail", Font.PLAIN, 20) );
		marriedJRadioButton.setBackground(Color.WHITE);
		add(unmarriedJRadioButton);
		unmarriedJRadioButton.setBounds(440, 420, 120, 21);
		unmarriedJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		unmarriedJRadioButton.setBackground(Color.WHITE);
		
		add(addressJLabel);
		addressJLabel.setBounds(70, 470, 200, 20);
		addressJLabel.setFont(new Font("Arail", Font.BOLD, 20));
		add(addressJTextField);
		addressJTextField.setBounds(290, 470, 350, 25);
		addressJTextField.setFont(new Font("Arail", Font.PLAIN, 22));
		
		add(cityJLabel);
		cityJLabel.setBounds(70, 520, 200, 20);
		cityJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(cityJTextField);
		cityJTextField.setBounds(290, 520, 350, 25);
		cityJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(pincodeJLabel);
		pincodeJLabel.setBounds(70, 570, 200, 20);
		pincodeJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(pincodeJTextField);
		pincodeJTextField.setBounds(290, 570, 350, 25);
		pincodeJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(stateJLabel);
		stateJLabel.setBounds(70, 620, 350, 20);
		stateJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(stateJTextField);
		stateJTextField.setBounds(290, 620, 350, 25);
		stateJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(cancelJButton);
		cancelJButton.setBounds(100, 690, 200, 40);
		cancelJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 22));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(nextJButton);
		nextJButton.setBounds(430, 690, 200, 40);
		nextJButton.setFont(new  Font("Arial", Font.CENTER_BASELINE, 22));
		nextJButton.setBackground(Color.BLACK);
		nextJButton.setForeground(Color.WHITE);
		
		add(warningNoteJLabel);
		warningNoteJLabel.setBounds(165, 740, 420, 20);
		warningNoteJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		warningNoteJLabel.setForeground(Color.RED);
		
		getContentPane().setBackground(Color.WHITE);
		
		cancelJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
	nextJButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			long  id = first;
			String fullName = fullnameJTextField.getText();
			String fatherName = fathernameJTextField.getText();
			String b_Date = (String) datesJComboBox.getSelectedItem();
			String b_Month = (String) monthsJComboBox.getSelectedItem();
			String b_Year = (String) yearsJComboBox.getSelectedItem();
			
			String gender = "";
			if (maleJRadioButton.isSelected())
			{
				gender = "Male";
			}else if (femaleJRadioButton.isSelected())
			        {
						gender = "Female";
		        	}
					else if (otherJRadioButton.isSelected()) 
		        			{
								gender = "Other";
		        			}
		        			else 
		        			{
								gender = "";
							}
			long  mobileNo = Long.parseLong(mobileNoJTextField.getText());
			String email = emailaddressJTextField.getText();
			
			String maritalStatus = "";
			if (marriedJRadioButton.isSelected())
			{
				maritalStatus = "Married";
			}
			else if (unmarriedJRadioButton.isSelected())
					{	
						maritalStatus = "Unmarried";
					}
					else
					{
						maritalStatus = "";
					}
			
			String address = addressJTextField.getText();
			String city = cityJTextField.getText();
			long pincode = Long.parseLong(pincodeJTextField.getText());
			String state = stateJTextField.getText();
			
			try {
			    long accountNumber = 0;
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Insert into CREATEACCOUNT1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				ps.setLong(1,id);
				ps.setLong(2,accountNumber);
				ps.setString(3, fullName);
				ps.setString(4, fatherName);
				ps.setString(5, b_Date);
				ps.setString(6, b_Month);
				ps.setString(7, b_Year);
				ps.setString(8, gender);
				ps.setLong(9,mobileNo);
				ps.setString(10, email);
				ps.setString(11, maritalStatus);
				ps.setString(12, address);
				ps.setString(13, city);
				ps.setLong(14, pincode);
				ps.setString(15, state);
				
				int i = ps.executeUpdate();
				
				if (i>0) 
				{
					JOptionPane.showMessageDialog(OpenAccountDetails1.this,"Personal Details Saved Sucessfully");
						new OpenAccountDetails2().setVisible(true);
						setVisible(false);
				} else {
					JOptionPane.showMessageDialog(OpenAccountDetails1.this,"Unable to Save the Detials");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(OpenAccountDetails1.this, "Cant Save The Details Please Check the details");
			}
		}
	});
	}
    public static void main(String[] args) 
    {
		OpenAccountDetails1 openAccountDetails1 = new OpenAccountDetails1();
		openAccountDetails1.setVisible(true);
		openAccountDetails1.setResizable(false);
	}
}
