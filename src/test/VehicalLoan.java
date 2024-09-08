package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class VehicalLoan extends JFrame
{
	Random rdm = new Random();
	long first4 = (rdm.nextLong() % 9000L) + 1000L;
	long first = Math.abs(first4);
	
	JLabel applicationidJLabel = new JLabel("Application ID : "+first); 
	
	JLabel headingJLabel = new JLabel("Vehical Loan Application");
	
	//Personal Detials
	JLabel subheading1JLabel = new JLabel("Personal Information");
	JLabel titleJLabel = new JLabel("Title:");
	JLabel accountNoJLabel = new JLabel("Account No:");
    JLabel genderJLabel = new JLabel("Gender:");
    JLabel surnameJLabel = new JLabel("SurName:");
    JLabel firstnameJLabel = new JLabel("First Name:");
    JLabel middlenameJLabel = new JLabel("Middle Name:");
    JLabel DOBJLabel = new JLabel("Date Of Birth:");
    JLabel mobileJLabel = new JLabel("Mobile:");
    JLabel emaiJLabel = new JLabel("Email:");
    JLabel addressJLabel = new JLabel("Address:");
    JLabel cityJLabel = new JLabel("City:");
    JLabel stateJLabel = new JLabel("State:");
    JLabel impNoteJLabel = new JLabel("Remember the Application Number Carefully");
    JLabel enterAmountOfLaonJLabel = new JLabel("Loan Amount You Want:");
    
    
    
    //Official Detials

    String [] title = {"Mr","Mrs","Shri"};
    JComboBox<String> titleJComboBox = new JComboBox<String>(title);
    
    String [] dates = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    JComboBox<String> datesofBithdJComboBox = new JComboBox<String>(dates);
    
    String [] months = {"January","February","March","April","May","Jun","Jully","August","September","Octumber","November","December"};
    JComboBox<String> monthofBirthJComboBox = new JComboBox<String>(months);
    
    String [] year = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021"};
    JComboBox<String> yearofBirthJComboBox = new JComboBox<String>(year);
    
    JTextField surnameJTextField =new JTextField();
    JTextField firstnameJTextField =new JTextField();
    JTextField middleameJTextField =new JTextField();
    JTextField enterLoanAmounJTextField = new JTextField();
    
    ButtonGroup genderButtonGroup = new ButtonGroup();
    JRadioButton maleJRadioButton = new JRadioButton("Male");
    JRadioButton femaleJRadioButton = new JRadioButton("Female");
    JRadioButton otherJRadioButton = new JRadioButton("Other");
    
    JTextField accountNoJTextField = new JTextField();
    JTextField mobileNoJTextField = new JTextField();
    JTextField emailJTextField = new JTextField();    
    JTextField entermobileNoOTPJTextField = new JTextField();
    JTextField enteremailOTPJTextField = new JTextField();
    JTextField addressJTextField = new JTextField();
    JTextField cityJTextField = new JTextField();
    JTextField stateJTextField = new JTextField();
    
    
    JButton verifyMobileNoJButton = new JButton("Verify");
    JButton verifyEmailIdJButton = new JButton("Verify");
    
    
    JButton cancelJButton = new JButton("Cancel");
    JButton nextJButton = new JButton("Next >>");
    
    String filePath;
    
    Blob b1=null;
    Blob b2=null;
    Blob b3=null;
    Blob b4=null;
    Blob b5=null;
    Blob b6=null;
    Blob b7=null;
    Blob b8=null;
    
    public VehicalLoan() 
    {
    	setSize(1150, 640);
		setTitle("DSD BANK - Personal Loan");
		setLayout(null);
		setLocation(200, 100);
		
		add(applicationidJLabel);
		applicationidJLabel.setBounds(30, 10, 200, 25);
		applicationidJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(headingJLabel);
		headingJLabel.setBounds(430, 10, 320, 27);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(subheading1JLabel);
		subheading1JLabel.setBounds(30, 70, 200, 20);
		subheading1JLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(titleJLabel);
		titleJLabel.setBounds(60, 120, 50, 20);
		titleJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(titleJComboBox);
		titleJComboBox.setBounds(110, 120, 100, 25);
		titleJComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		titleJComboBox.setBackground(Color.WHITE);
		
		add(DOBJLabel);
		DOBJLabel.setBounds(550, 120, 130, 20);
		DOBJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(datesofBithdJComboBox);
		datesofBithdJComboBox.setBounds(680	, 120, 60, 25);
		datesofBithdJComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		datesofBithdJComboBox.setBackground(Color.WHITE);
		add(monthofBirthJComboBox);
		monthofBirthJComboBox.setBounds(750, 120, 110, 25);
		monthofBirthJComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		monthofBirthJComboBox.setBackground(Color.WHITE);
		add(yearofBirthJComboBox);
		yearofBirthJComboBox.setBounds(870, 120, 80, 25);
		yearofBirthJComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		yearofBirthJComboBox.setBackground(Color.WHITE);
		
		add(accountNoJLabel);
		accountNoJLabel.setBounds(60, 170, 110, 20);
		accountNoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(accountNoJTextField);
		accountNoJTextField.setBounds(180, 170, 300, 25);
		accountNoJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(surnameJLabel);
		surnameJLabel.setBounds(60, 220, 100, 20);
		surnameJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(surnameJTextField);
		surnameJTextField.setBounds(155, 220, 200, 25);
		surnameJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(firstnameJLabel);
		firstnameJLabel.setBounds(380, 220, 110, 20);
		firstnameJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(firstnameJTextField);
		firstnameJTextField.setBounds(490, 220, 200, 25);
		firstnameJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(middlenameJLabel);
		middlenameJLabel.setBounds(730, 220, 130, 20);
		middlenameJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(middleameJTextField);
		middleameJTextField.setBounds(860, 220, 200, 25);
		middleameJTextField.setFont(new Font("Arial", Font.BOLD, 20));

		genderButtonGroup.add(maleJRadioButton);
		genderButtonGroup.add(femaleJRadioButton);
		genderButtonGroup.add(otherJRadioButton);
		
		add(genderJLabel);
		genderJLabel.setBounds(60, 270, 90, 20);
		genderJLabel.setFont(new Font("Arial",Font.PLAIN, 20));
		
		add(maleJRadioButton);
		maleJRadioButton.setBounds(150, 270, 70, 25);
		maleJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		maleJRadioButton.setBackground(Color.WHITE);
		
		add(femaleJRadioButton);
		femaleJRadioButton.setBounds(300, 270, 100, 25);
		femaleJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		femaleJRadioButton.setBackground(Color.WHITE); 
		 
		add(otherJRadioButton);
		otherJRadioButton.setBounds(470, 270, 100, 25);
		otherJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		otherJRadioButton.setBackground(Color.WHITE);
		
		add(mobileJLabel);
		mobileJLabel.setBounds(60, 320, 80, 20);
		mobileJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(mobileNoJTextField);
		mobileNoJTextField.setBounds(155, 320, 200, 25);
		mobileNoJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(verifyMobileNoJButton);
		verifyMobileNoJButton.setBounds(360, 320, 100, 25);
		
		add(emaiJLabel);
		emaiJLabel.setBounds(600, 320, 70, 20);
		emaiJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(emailJTextField);
		emailJTextField.setBounds(670, 320, 300, 25);
		emailJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(verifyEmailIdJButton);
		verifyEmailIdJButton.setBounds(975, 320, 100, 25);
		
		add(addressJLabel);
		addressJLabel.setBounds(60, 370, 80, 20);
		addressJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(addressJTextField);
		addressJTextField.setBounds(150, 370, 720, 25);
		addressJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(cityJLabel);
		cityJLabel.setBounds(60, 420, 50, 20);
		cityJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(cityJTextField);
		cityJTextField.setBounds(150, 420, 200, 25);
		cityJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(stateJLabel);
		stateJLabel.setBounds(600, 420, 60, 20);
		stateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(stateJTextField);
		stateJTextField.setBounds(670, 420, 200, 25);
		stateJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(enterAmountOfLaonJLabel);
		enterAmountOfLaonJLabel.setBounds(350, 470, 230, 20);
		enterAmountOfLaonJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(enterLoanAmounJTextField);
		enterLoanAmounJTextField.setBounds(590, 470, 250, 25);
		enterLoanAmounJTextField.setFont(new Font("Arial", Font.BOLD, 25));
		
		  add(cancelJButton);
		  cancelJButton.setBounds(30, 550, 200, 35);
		  cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		  cancelJButton.setBackground(Color.BLACK);
		  cancelJButton.setForeground(Color.WHITE);
		  
		  add(nextJButton);
		  nextJButton.setBounds(910, 550, 200, 35);
		  nextJButton.setFont(new Font("Arial", Font.BOLD	, 20));
		  nextJButton.setBackground(Color.BLACK);
		  nextJButton.setForeground(Color.WHITE);
		  
		  add(impNoteJLabel);
		  impNoteJLabel.setBounds(415, 575, 320, 20);
		  impNoteJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		  impNoteJLabel.setForeground(Color.RED);
		  
		  getContentPane().setBackground(Color.WHITE);		  
		  
		  verifyMobileNoJButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					long accountNo = Long.parseLong(accountNoJTextField.getText());
					long mobileNo = Long.parseLong(mobileNoJTextField.getText());
					
					try {
						Connection con = DBConnection.getCon();
						PreparedStatement ps1 = con.prepareStatement("Select * from CREATEACCOUNT1 where ACCOUNT_NO=?");
						ps1.setLong(1, accountNo);
						ResultSet rs1 = ps1.executeQuery();
						
						if (rs1.next())
						{
							long linkedMobileNo = rs1.getLong(9);
							if (mobileNo==linkedMobileNo)
							{
								JOptionPane.showMessageDialog(VehicalLoan.this, "Mobile Number is Verified");
								verifyMobileNoJButton.setText("Verified");
								verifyMobileNoJButton.setBackground(Color.GREEN);
								mobileNoJTextField.setEditable(false);
							} else {
								JOptionPane.showMessageDialog(VehicalLoan.this, "Entered Mobile Number is Not Linked To Your Account");
							}
						} else {
							JOptionPane.showMessageDialog(VehicalLoan.this, "Invalid Account Number");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
		  
		  verifyEmailIdJButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					long accountNo = Long.parseLong(accountNoJTextField.getText());
					String enteredEmail = emailJTextField.getText();
					
					try {
						Connection con = DBConnection.getCon();
						PreparedStatement ps1 = con.prepareStatement("Select * from CREATEACCOUNT1 where ACCOUNT_NO=?");
						ps1.setLong(1,accountNo);
						ResultSet rs = ps1.executeQuery();
						if (rs.next())
						{
							String mailString = rs.getString(10);
							if (enteredEmail.equals(mailString))
							{
								JOptionPane.showMessageDialog(VehicalLoan.this, "Email ID is Verified");
								verifyEmailIdJButton.setBackground(Color.GREEN);
								verifyEmailIdJButton.setText("Verified");
								emailJTextField.setEditable(false);
							} else {
								JOptionPane.showMessageDialog(VehicalLoan.this, "This Email is Not Linked to Your Account");
							}
						} else {
							JOptionPane.showMessageDialog(VehicalLoan.this, "Invalid Account Number");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
		  
		  nextJButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
		 			
					if (verifyEmailIdJButton.getText()=="Verified" && verifyMobileNoJButton.getText()=="Verified")
					{
						  long applicationNo = first; 
						  long accountNo = Long.parseLong(accountNoJTextField.getText()); 
						  String firstName = firstnameJTextField.getText();
						  String middleName  = middleameJTextField.getText(); 
						  String surName = surnameJTextField.getText();
						  String DOB = (String) datesofBithdJComboBox.getSelectedItem(); 
						  String MOB = (String)monthofBirthJComboBox.getSelectedItem();
						  String YOB = (String)yearofBirthJComboBox.getSelectedItem();
						
						  String gender = ""; 
						  if
						  (maleJRadioButton.isSelected())
						  { 
							  gender ="Male";
						  } else if(femaleJRadioButton.isSelected())
						  { 
							  gender = "Female"; 
						  }else{
								gender = "";
						  }
						  
						  long mobile = Long.parseLong(mobileNoJTextField.getText());
						  String email = emailJTextField.getText(); 
						  String address = addressJTextField.getText();
						  String city = cityJTextField.getText();
						  String state = stateJTextField.getText();
						  float loanAmt = Float.parseFloat(enterLoanAmounJTextField.getText());
						  String typeOfLoan = "Vehicle Loan";
						  float loanWithIntrest = loanAmt*7/100;
						
						  try {
							  
							  Connection con = DBConnection.getCon();
							  PreparedStatement ps1 = con.prepareStatement("Select * from CREATEACCOUNT1 where ACCOUNT_NO=?");
							  PreparedStatement ps2 = con.prepareStatement("Insert into LOANINFO values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							  PreparedStatement ps3 = con.prepareStatement("Insert into VEHICALLOANDOCUMENTS values(?,?,?,?,?,?,?,?,?,?)");
							   
							  ps1.setLong(1, accountNo);
							  ResultSet rs1 = ps1.executeQuery();
							  if (rs1.next())
							  {
								String F_name = rs1.getString(4);
								System.out.println(F_name);
								
								if (/* firstName!=null && */ F_name.equals(middleName) /* && surName!=null */)
								{
									ps2.setLong(1, applicationNo);
									ps2.setLong(2, accountNo);
									ps2.setString(3, firstName);
									ps2.setString(4, middleName);
									ps2.setString(5, surName);
									ps2.setString(6, DOB);
									ps2.setString(7, MOB);
									ps2.setString(8, YOB);
									ps2.setString(9, gender);
									ps2.setLong(10, mobile);
									ps2.setString(11, email);
									ps2.setString(12, address);
									ps2.setString(13, city);
									ps2.setString(14, state);
							        ps2.setFloat(15, loanAmt);
							        ps2.setString(16, typeOfLoan);
							        ps2.setFloat(17, loanWithIntrest);
							        
									
									  ps3.setLong(1, applicationNo);
									  ps3.setLong(2, accountNo); 
									  ps3.setBlob(3, b1);
									  ps3.setBlob(4, b2);
									  ps3.setBlob(5, b3);
									  ps3.setBlob(6, b4); 
									  ps3.setBlob(7, b5); 
									  ps3.setBlob(8, b6); 
									  ps3.setBlob(9, b7); 
									  ps3.setBlob(10, b8);
									 
									 int i = ps2.executeUpdate();
							         int k = ps3.executeUpdate(); 
									
									if (i == 1 && k==1) 
									{
										JOptionPane.showMessageDialog(VehicalLoan.this, "Personal Detials for Loan Appliction is Saved Successfully");
										new VehicalLoan2().setVisible(true);
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(VehicalLoan.this, "Unable to save the Data "+"\nPlease check the detials");
									}
								} else {
									JOptionPane.showMessageDialog(VehicalLoan.this, "Enter the Correct NAME as Per PassBook");
								}
							  } else {
								  JOptionPane.showMessageDialog(VehicalLoan.this, "Invalid Account Number");
						      }  
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(VehicalLoan.this, "Verify the"+"\nEmail Address and"+"\nMobile Number");
					}
				}
			});
	
	}
    public static void main(String[] args) 
    {
		VehicalLoan vehicalLoan = new VehicalLoan();
		vehicalLoan.setVisible(true);
		vehicalLoan.setResizable(false);
	}
}
