package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TakenLoanInfo extends JFrame
{
	JLabel headingJLabel = new JLabel("Laon Information Page");
	JLabel applicationJLabel = new JLabel("Application ID:");
	JLabel accountNoJLabel = new JLabel("Account No:");
	
	JTextField applicationIdJTextField = new JTextField();
	JTextField accountNoJTextField = new JTextField();
	
	//LoanInfo
	JLabel fnameJLabel = new JLabel("First Name:");
	JLabel mnameJLabel = new JLabel("Middle Name:");
	JLabel snameJLabel = new JLabel("Sur Name:");
	JLabel dateOfBirthJLabel = new JLabel("Date Of Birth:");
	JLabel genderJLabel = new JLabel("Gender:");
	JLabel mobileJLabel = new JLabel("Mobile:");
	JLabel emailJLabel = new JLabel("Email:");
	JLabel addressJLabel = new JLabel("Address:");
	JLabel cityJLabel = new JLabel("City:");
	JLabel stateJLabel = new JLabel("State:");
	JLabel loanAmtJLabel = new JLabel("Loan Amt:");
	JLabel typeOfLoanJLabel  = new JLabel("Type Of Loan:");
	JLabel loanINR = new JLabel("Loan Interest:");

	//Documents
	JLabel uploadedDocumentsJLabel = new JLabel("UPLOADED DOCUMENTS :-");
	JLabel photoJLabel = new JLabel("Photo");
	JLabel singJLabel = new JLabel("Signature");
	JLabel adharcardJLabel = new JLabel("Adhar Card");
	JLabel pancardJLabel = new JLabel("Pan Card");
	JLabel incomeCertificateJLabel = new JLabel("Income Certificate");
	JLabel bankStatementJLabel = new JLabel("6 Months Bank Statement");
	JLabel homePlanJLabel = new JLabel("Home Plan");
	JLabel permissionforHomeJLabel = new JLabel("Permission Reciept ");
	JLabel vehicallicenceJLabel = new JLabel("Vehicle Licence");
	JLabel vehicalInsurienceJLabel = new JLabel("Vehicle Insurence");
	JLabel scletterJLabel = new JLabel("Letter From School/College");
	JLabel scLeavingJLabel = new JLabel("Leaving Certificate of School/College");
	
	//View Documents Buttons
	JButton photoJButton = new JButton("View");
	JButton signJButton = new JButton("View");
	JButton adharcardJButton = new JButton("View");
	JButton pancardJButton = new JButton("View");
	JButton incomeCertificateJButton = new JButton("View");
	JButton bankStatementJButton = new JButton("View");
	JButton homePlanJButton = new JButton("View");
	JButton perimissonforHomeJButton = new JButton("View");
	JButton vehicallicenceJButton = new JButton("View");
	JButton vehicalInsurienceJButton = new JButton("View");
	JButton scLetterJButton = new JButton("View");
	JButton scLeavingJButton = new JButton("View");
	
	JTextField fnameJTextField = new JTextField();
	JTextField mnameJTextField = new JTextField();
	JTextField snameJTextField = new JTextField();
	JTextField dateofBirthJTextField = new JTextField();
	JTextField monthOfBirthJTextField = new JTextField();
	JTextField yearOfBirthJTextField = new JTextField();
	JTextField genderJTextField = new JTextField();
	JTextField mobileNoJTextField = new JTextField();
	JTextField emailJTextField = new JTextField();
	JTextField addressJTextField = new JTextField();
	JTextField cityJTextField = new JTextField();
	JTextField stateJTextField = new JTextField();
	JTextField laonAmtJTextField = new JTextField();
	JTextField typeOfLoanJTextField = new JTextField();
	JTextField loanINRJTextField = new JTextField();
	
	JButton viewLoanDetialsJButton = new JButton("View Laon Detials");
	JButton backJButton = new JButton("Back");
	
	public TakenLoanInfo() 
	{
		setSize(1200, 820);
		setTitle("DSD BANK - Laon Information");
		setLayout(null);
		setLocation(170, 1);
		
		add(headingJLabel);
		headingJLabel.setBounds(450, 10, 300, 28);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 26));
		
		add(accountNoJLabel);
		accountNoJLabel.setBounds(50, 80, 120, 20);
		accountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(accountNoJTextField);
		accountNoJTextField.setBounds(180, 80, 250, 25);
		accountNoJTextField.setFont(new Font("Arial", Font.BOLD, 23));
		
		add(applicationJLabel);
		applicationJLabel.setBounds(480, 80, 150, 22);
		applicationJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(applicationIdJTextField);
		applicationIdJTextField.setBounds(630, 80, 250, 25);
		applicationIdJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(viewLoanDetialsJButton);
		viewLoanDetialsJButton.setBounds(910, 75, 250, 35);
		viewLoanDetialsJButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewLoanDetialsJButton.setBackground(Color.BLACK);
		viewLoanDetialsJButton.setForeground(Color.WHITE);
		
		add(fnameJLabel);
		fnameJLabel.setBounds(30, 140, 100, 20);
		fnameJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(fnameJTextField);
		fnameJTextField.setBounds(140, 140, 200, 23);
		fnameJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		fnameJTextField.setEditable(false);
		
		add(mnameJLabel);
		mnameJLabel.setBounds(370, 140, 130, 20);
		mnameJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(mnameJTextField);
		mnameJTextField.setBounds(500, 140, 200, 23);
		mnameJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		mnameJTextField.setEditable(false);
		
		add(snameJLabel);
		snameJLabel.setBounds(730, 140, 100, 20);
		snameJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(snameJTextField);
		snameJTextField.setBounds(840, 140, 200, 23);
		snameJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		snameJTextField.setEditable(false);
		
		add(dateOfBirthJLabel);
		dateOfBirthJLabel.setBounds(30, 190, 120, 20);
		dateOfBirthJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(dateofBirthJTextField);
		dateofBirthJTextField.setBounds(160, 190, 40, 23);
		dateofBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		dateofBirthJTextField.setEditable(false);
		add(monthOfBirthJTextField);
		monthOfBirthJTextField.setBounds(210, 190, 115, 23);
		monthOfBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		monthOfBirthJTextField.setEditable(false);
		add(yearOfBirthJTextField);
		yearOfBirthJTextField.setBounds(335, 190, 70, 23);
		yearOfBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		yearOfBirthJTextField.setEditable(false);
		
		add(genderJLabel);
		genderJLabel.setBounds(520, 190, 70, 20);
		genderJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(genderJTextField);
		genderJTextField.setBounds(600, 190, 100, 23);
		genderJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		genderJTextField.setEditable(false);
		
		add(mobileJLabel);
		mobileJLabel.setBounds(820, 190, 70, 20);
		mobileJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(mobileNoJTextField);
		mobileNoJTextField.setBounds(890, 190, 150, 23);
		mobileNoJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		mobileNoJTextField.setEditable(false);
		
		add(emailJLabel);
		emailJLabel.setBounds(30, 240, 60, 20);
		emailJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(emailJTextField);
		emailJTextField.setBounds(100, 240, 300, 23);
		emailJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		emailJTextField.setEditable(false);
		
		add(addressJLabel);
		addressJLabel.setBounds(480, 240, 90, 20);
		addressJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(addressJTextField);
		addressJTextField.setBounds(570, 240, 300, 23);
		addressJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		addressJTextField.setEditable(false);
		
		add(cityJLabel);
		cityJLabel.setBounds(30, 290, 60, 20);
		cityJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(cityJTextField);
		cityJTextField.setBounds(100, 290, 250, 23);
		cityJTextField.setFont(new Font("Arial", Font.PLAIN, 19));
		cityJTextField.setEditable(false);
		
		add(stateJLabel);
		stateJLabel.setBounds(530, 290, 60, 20);
		stateJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(stateJTextField);
		stateJTextField.setBounds(620, 290, 250, 23);
		stateJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		stateJTextField.setEditable(false);
		
		add(loanAmtJLabel);
		loanAmtJLabel.setBounds(30, 340, 100, 20);
		loanAmtJLabel.setFont(new Font("Arail", Font.PLAIN, 19));
		add(laonAmtJTextField);
		laonAmtJTextField.setBounds(130, 340, 200, 23);
		laonAmtJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		laonAmtJTextField.setEditable(false);
		
		add(loanINR);
		loanINR.setBounds(360, 340, 130, 20);
		loanINR.setFont(new Font("Arial", Font.PLAIN, 19));
		add(loanINRJTextField);
		loanINRJTextField.setBounds(490, 340, 200, 23);
		loanINRJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		loanINRJTextField.setEditable(false);
		
		add(typeOfLoanJLabel);
		typeOfLoanJLabel.setBounds(710, 340, 140, 20);
		typeOfLoanJLabel.setFont(new Font("Arial", Font.PLAIN, 19));
		add(typeOfLoanJTextField);
		typeOfLoanJTextField.setBounds(860, 340, 200, 23);
		typeOfLoanJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		typeOfLoanJTextField.setEditable(false);
		
		add(backJButton);
		backJButton.setBounds(30, 730, 200, 35);
		backJButton.setFont(new Font("Arial", Font.BOLD, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(Color.WHITE);
		
		viewLoanDetialsJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long accountNo = Long.parseLong(accountNoJTextField.getText());
					long applicationId = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("SELECT * FROM LOANINFO WHERE ACCOUNT_NO=? AND ID=?");
					ps.setLong(1, accountNo);
					ps.setLong(2, applicationId);
					
					ResultSet rs = ps.executeQuery();
					if (rs.next())
					{
					   String fname = rs.getString(3);
					   String mname = rs.getString(4);
					   String sname = rs.getString(5);
					   String dob = rs.getString(6);
					   String mob = rs.getString(7);
					   String yob = rs.getString(8);
					   String gender = rs.getString(9);
					   String mobile = (String)rs.getString(10);
					   String email = rs.getString(11);
					   String address = rs.getString(12);
					   String city = rs.getString(13);
					   String state = rs.getString(14);
					   String laonAMT = (String)rs.getString(15);
					   String typeOfLoan = rs.getString(16);
					   String loanINR = (String)rs.getString(17);
					   
					   fnameJTextField.setText(fname);
					   mnameJTextField.setText(mname);
					   snameJTextField.setText(sname);
					   dateofBirthJTextField.setText(dob);
					   monthOfBirthJTextField.setText(mob);
					   yearOfBirthJTextField.setText(yob);
					   genderJTextField.setText(gender);
					   mobileNoJTextField.setText(mobile);
					   emailJTextField.setText(email);
					   addressJTextField.setText(address);
					   cityJTextField.setText(city);
					   stateJTextField.setText(state);
					   laonAmtJTextField.setText(laonAMT);
					   typeOfLoanJTextField.setText(typeOfLoan);
					   loanINRJTextField.setText(loanINR);
					  
					   if (typeOfLoanJTextField.getText().equals("Personal Laon")) 
					   {
						   add(uploadedDocumentsJLabel);
						   uploadedDocumentsJLabel.setBounds(30, 420, 280, 23);
						   uploadedDocumentsJLabel.setFont(new Font("Arial", Font.BOLD, 20));
						    
						   add(photoJLabel);
						   photoJLabel.setBounds(400, 450, 250, 20);
						   photoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(photoJButton);
						   photoJButton.setBounds(900, 450, 150, 20);
						   photoJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						    
						   add(singJLabel);
						   singJLabel.setBounds(400, 490, 250, 20);
						   singJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(signJButton);
						   signJButton.setBounds(900, 490, 150, 20);
						   signJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   
						   add(adharcardJLabel);
						   adharcardJLabel.setBounds(400, 530, 250, 20);
						   adharcardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(adharcardJButton);
						   adharcardJButton.setBounds(900, 530, 150, 20);
						   adharcardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   
						   add(pancardJLabel);
						   pancardJLabel.setBounds(400, 570, 250, 20);
						   pancardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(pancardJButton);
						   pancardJButton.setBounds(900, 570, 150, 20);
						   pancardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   
						   add(incomeCertificateJLabel);
						   incomeCertificateJLabel.setBounds(400, 610, 250, 20);
						   incomeCertificateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(incomeCertificateJButton);
						   incomeCertificateJButton.setBounds(900, 610, 150, 20);
						   incomeCertificateJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   
						   add(bankStatementJLabel);
						   bankStatementJLabel.setBounds(400, 650, 250, 20);
						   bankStatementJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   add(bankStatementJButton);
						   bankStatementJButton.setBounds(900, 650, 150, 20);
						   bankStatementJButton.setFont(new Font("Arial", Font.PLAIN, 20));	 
						   
						   
						   photoJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame photoJFrame = new JFrame();
									JLabel displayImageJLabel = new JLabel();
									photoJFrame.setVisible(true);
									photoJFrame.setSize(900, 750);
									//photoJFrame.setLayout(null);
									photoJFrame.setTitle("Uploaded Photo");
									photoJFrame.setLocation(350,20);
									photoJFrame.add(displayImageJLabel);
									photoJFrame.getContentPane().setBackground(Color.WHITE);
									
									try {
										long id = applicationId;
										Connection photoCon = DBConnection.getCon();
										PreparedStatement photops = photoCon.prepareStatement("Select PHOTO_IMAGE from PERSONALLOANDOCUMENTS where ID =?");
										photops.setLong(1,id);
										ResultSet photors = photops.executeQuery();
										if (photors.next())
										{
											Blob photoFile = photors.getBlob("PHOTO_IMAGE");
											byte barr[] = photoFile.getBytes(1, (int)photoFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											displayImageJLabel.setIcon(new ImageIcon(image));	
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Image is unable to dislay");
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							});
							
							signJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame signJFrame = new JFrame();
									JLabel displaySignJLabel = new JLabel();
									signJFrame.setVisible(true);
									signJFrame.setSize(900, 750);
									signJFrame.setTitle("Uploaded Signature");
									signJFrame.setLocation(350,20);
									signJFrame.add(displaySignJLabel);
									signJFrame.setBackground(Color.WHITE);
									
									try {
										long id = applicationId;
										Connection signConn = DBConnection.getCon();
										PreparedStatement signps = signConn.prepareStatement("Select SIGN_IMAGE from PERSONALLOANDOCUMENTS where ID=?");
										signps.setLong(1,id);
										ResultSet signrs = signps.executeQuery();
										if (signrs.next())
										{
											Blob signFile = signrs.getBlob("SIGN_IMAGE");
											byte barr[] = signFile.getBytes(1, (int)signFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											displaySignJLabel.setIcon(new ImageIcon(image));
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong!!!"+"\n Image is unable to dislay");
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							});
							
							adharcardJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame adharCardJFrame = new JFrame();
									JLabel adharCardJLabel = new JLabel();
									adharCardJFrame.setVisible(true);
									adharCardJFrame.setSize(900, 750);
									adharCardJFrame.setTitle("Uploaded Adhar Card");
									adharCardJFrame.setLocation(350,20);
									adharCardJFrame.add(adharCardJLabel);
									adharCardJFrame.setBackground(Color.WHITE);
									
									try {
										long id = applicationId;
										Connection adharCardConn = DBConnection.getCon();
										PreparedStatement adharCardps = adharCardConn.prepareStatement("Select ADHAR_IMAGE from PERSONALLOANDOCUMENTS where ID=?");
										adharCardps.setLong(1,id);
										ResultSet adharCardrs = adharCardps.executeQuery();
										
										if (adharCardrs.next())
										{
											Blob adharFile = adharCardrs.getBlob("ADHAR_IMAGE");
											System.out.println("Adhar Card retrieved Successfully");
											byte barr[] = adharFile.getBytes(1, (int)adharFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											adharCardJLabel.setIcon(new ImageIcon(image));	
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong !!! "+"\n Image is unable to display");			
										}
										
									} catch (Exception e2) {
										e2.printStackTrace();
									}	
								}
							});
							
							pancardJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame panCardJFrame = new JFrame();
									JLabel panCardJLabel = new JLabel();
									panCardJFrame.setVisible(true);
									panCardJFrame.setSize(900, 750);
									panCardJFrame.setTitle("Uploaded Pan Card");
									panCardJFrame.setLocation(350,20);
									panCardJFrame.add(panCardJLabel);
									panCardJFrame.setBackground(Color.WHITE);
									
									try {
										long id = applicationId;
										Connection panCardConn = DBConnection.getCon();
										PreparedStatement panCardps = panCardConn.prepareStatement("Select PAN_IMAGE from PERSONALLOANDOCUMENTS where ID=?");
										panCardps.setLong(1,id);
										ResultSet panCardrs = panCardps.executeQuery();
										if (panCardrs.next())
										{
											Blob panFile = panCardrs.getBlob("PAN_IMAGE");
											byte barr[] = panFile.getBytes(1, (int)panFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											panCardJLabel.setIcon(new ImageIcon(image));
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went Wrong !!!"+"\n Image is unable to display");
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							});
							
							incomeCertificateJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame incomeJFrame = new JFrame();
									JLabel incomeJLabel = new JLabel();
								    incomeJFrame.setVisible(true);
								    incomeJFrame.setSize(900, 750);
								    incomeJFrame.setTitle("Uploaded Income Certificate");
								    incomeJFrame.setLocation(350,20);
								    incomeJFrame.add(incomeJLabel);
								    incomeJFrame.setBackground(Color.WHITE);
								    
								    try {
								    	long id = applicationId;
										Connection incomeConn = DBConnection.getCon();
										PreparedStatement incomeps = incomeConn.prepareStatement("Select INCOOME_IMAGE from PERSONALLOANDOCUMENTS where ID=?");
										incomeps.setLong(1,id);
										ResultSet incomers = incomeps.executeQuery();
										if (incomers.next())
										{
											Blob incomeFile = incomers.getBlob("INCOOME_IMAGE");
											byte barr[] = incomeFile.getBytes(1, (int)incomeFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											incomeJLabel.setIcon(new ImageIcon(image));
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							});
							bankStatementJButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									JFrame bankStatementJFrame = new JFrame();
									JLabel bankStatmentJLabel = new JLabel();
									bankStatementJFrame.setVisible(true);
									bankStatementJFrame.setSize(900, 750);
									bankStatementJFrame.setTitle("Uploaded 6 Months Bank Statements");
									bankStatementJFrame.setLocation(350,20);
									bankStatementJFrame.add(bankStatmentJLabel);
									
									try {
										long id = applicationId;
										Connection bankStatementConn = DBConnection.getCon();
										PreparedStatement bankStatementps = bankStatementConn.prepareStatement("Select STATEMENT_IMAGE from PERSONALLOANDOCUMENTS where ID=?");
										bankStatementps.setLong(1,id);
										ResultSet bankStatementrs = bankStatementps.executeQuery();
										
										if (bankStatementrs.next())
										{
											Blob bankStatmentFile = bankStatementrs.getBlob("STATEMENT_IMAGE");
											byte barr[] = bankStatmentFile.getBytes(1, (int)bankStatmentFile.length());
											BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
											bankStatmentJLabel.setIcon(new ImageIcon(image));
										} else {
											JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to diplay");
										}
									} catch (Exception e2) {
										e2.printStackTrace();
									}
								}
							});
						
					   }
				    else if (typeOfLoanJTextField.getText().equals("Home Loan"))
							{
				    			add(uploadedDocumentsJLabel);
				    			uploadedDocumentsJLabel.setBounds(30, 420, 280, 23);
				    			uploadedDocumentsJLabel.setFont(new Font("Arial", Font.BOLD, 20));
						    
				    			add(photoJLabel);
				    			photoJLabel.setBounds(400, 450, 250, 20);
				    			photoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
				    			add(photoJButton);
								photoJButton.setBounds(900, 450, 150, 20);
								photoJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
				    			add(singJLabel);
				    			singJLabel.setBounds(400, 490, 250, 20);
				    			singJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
				    			add(signJButton);
								signJButton.setBounds(900, 490, 150, 20);
								signJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
				    			add(adharcardJLabel);
						   		adharcardJLabel.setBounds(400, 530, 250, 20);
						   		adharcardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(adharcardJButton);
								adharcardJButton.setBounds(900, 530, 150, 20);
								adharcardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
						   		add(pancardJLabel);
						   		pancardJLabel.setBounds(400, 570, 250, 20);
						   		pancardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(pancardJButton);
								pancardJButton.setBounds(900, 570, 150, 20);
								pancardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
						   		add(incomeCertificateJLabel);
						   		incomeCertificateJLabel.setBounds(400, 610, 250, 20);
						   		incomeCertificateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(incomeCertificateJButton);
								incomeCertificateJButton.setBounds(900, 610, 150, 20);
								incomeCertificateJButton.setFont(new Font("Arial", Font.PLAIN, 18));
							
						   		add(bankStatementJLabel);
						   		bankStatementJLabel.setBounds(400, 650, 250, 20);
						   		bankStatementJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(bankStatementJButton);
								bankStatementJButton.setBounds(900, 650, 150, 20);
								bankStatementJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
						   		add(homePlanJLabel);
						   		homePlanJLabel.setBounds(400, 690, 250, 20);
						   		homePlanJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(homePlanJButton);
						   		homePlanJButton.setBounds(900, 690, 150, 20);
						   		homePlanJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   		
						   		add(permissionforHomeJLabel);
						   		permissionforHomeJLabel.setBounds(400, 730, 250, 20);
						   		permissionforHomeJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
						   		add(perimissonforHomeJButton);
						   		perimissonforHomeJButton.setBounds(900, 730, 150, 20);
						   		perimissonforHomeJButton.setFont(new Font("Arial", Font.PLAIN, 18));
						   		
						   		
						   	 photoJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame photoJFrame = new JFrame();
										JLabel displayImageJLabel = new JLabel();
										photoJFrame.setVisible(true);
										photoJFrame.setSize(900, 750);
										//photoJFrame.setLayout(null);
										photoJFrame.setTitle("Uploaded Photo");
										photoJFrame.setLocation(350,20);
										photoJFrame.add(displayImageJLabel);
										photoJFrame.getContentPane().setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection photoCon = DBConnection.getCon();
											PreparedStatement photops = photoCon.prepareStatement("Select PHOTO_IMAGE from HOMELOANDOCUMENTS where ID=?");
											
											photops.setLong(1,id);
											
											ResultSet photors = photops.executeQuery();
											if (photors.next())
											{
												Blob photoFile = photors.getBlob("PHOTO_IMAGE");
												byte barr[] = photoFile.getBytes(1, (int)photoFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												displayImageJLabel.setIcon(new ImageIcon(image));	
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Image is unable to dislay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								signJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame signJFrame = new JFrame();
										JLabel displaySignJLabel = new JLabel();
										signJFrame.setVisible(true);
										signJFrame.setSize(900, 750);
										signJFrame.setTitle("Uploaded Signature");
										signJFrame.setLocation(350,20);
										signJFrame.add(displaySignJLabel);
										signJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection signConn = DBConnection.getCon();
											PreparedStatement signps = signConn.prepareStatement("Select SIGN_IMAGE from HOMELOANDOCUMENTS where ID=?");
										    signps.setLong(1,id);
											ResultSet signrs = signps.executeQuery();
											if (signrs.next())
											{
												Blob signFile = signrs.getBlob("SIGN_IMAGE");
												byte barr[] = signFile.getBytes(1, (int)signFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												displaySignJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong!!!"+"\n Image is unable to dislay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								adharcardJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame adharCardJFrame = new JFrame();
										JLabel adharCardJLabel = new JLabel();
										adharCardJFrame.setVisible(true);
										adharCardJFrame.setSize(900, 750);
										adharCardJFrame.setTitle("Uploaded Adhar Card");
										adharCardJFrame.setLocation(350,20);
										adharCardJFrame.add(adharCardJLabel);
										adharCardJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection adharCardConn = DBConnection.getCon();
											PreparedStatement adharCardps = adharCardConn.prepareStatement("Select ADHAR_IMAGE from HOMELOANDOCUMENTS where ID=?");
											adharCardps.setLong(1,id);
											ResultSet adharCardrs = adharCardps.executeQuery();
											if (adharCardrs.next())
											{
												Blob adharFile = adharCardrs.getBlob("ADHAR_IMAGE");
												byte barr[] = adharFile.getBytes(1, (int)adharFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												adharCardJLabel.setIcon(new ImageIcon(image));	
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong !!! "+"\n Image is unable to display");			
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}	
									}
								});
								
								pancardJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame panCardJFrame = new JFrame();
										JLabel panCardJLabel = new JLabel();
										panCardJFrame.setVisible(true);
										panCardJFrame.setSize(900, 750);
										panCardJFrame.setTitle("Uploaded Pan Card");
										panCardJFrame.setLocation(350,20);
										panCardJFrame.add(panCardJLabel);
										panCardJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection panCardConn = DBConnection.getCon();
											PreparedStatement panCardps = panCardConn.prepareStatement("Select PAN_IMAGE from HOMELAONDOCUMENTS where ID=?");
											panCardps.setLong(1,id);
											ResultSet panCardrs = panCardps.executeQuery();
											if (panCardrs.next())
											{
												Blob panFile = panCardrs.getBlob("PAN_IMAGE");
												byte barr[] = panFile.getBytes(1, (int)panFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												panCardJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went Wrong !!!"+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								incomeCertificateJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame incomeJFrame = new JFrame();
										JLabel incomeJLabel = new JLabel();
									    incomeJFrame.setVisible(true);
									    incomeJFrame.setSize(900, 750);
									    incomeJFrame.setTitle("Uploaded Income Certificate");
									    incomeJFrame.setLocation(350,20);
									    incomeJFrame.add(incomeJLabel);
									    incomeJFrame.setBackground(Color.WHITE);
									    
									    try {
									    	long id = applicationId;
											Connection incomeConn = DBConnection.getCon();
											PreparedStatement incomeps = incomeConn.prepareStatement("Select INCOME_IMAGE from HOMELOANDOCUMENTS where ID=?");
											incomeps.setLong(1,id);
											ResultSet incomers = incomeps.executeQuery();
											if (incomers.next())
											{
												Blob incomeFile = incomers.getBlob("INCOOME_IMAGE");
												byte barr[] = incomeFile.getBytes(1, (int)incomeFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												incomeJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								bankStatementJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame bankStatementJFrame = new JFrame();
										JLabel bankStatmentJLabel = new JLabel();
										bankStatementJFrame.setVisible(true);
										bankStatementJFrame.setSize(900, 750);
										bankStatementJFrame.setTitle("Uploaded 6 Months Bank Statements");
										bankStatementJFrame.setLocation(350,20);
										bankStatementJFrame.add(bankStatmentJLabel);
										
										try {
											long id = applicationId;
											Connection bankStatementConn = DBConnection.getCon();
											PreparedStatement bankStatementps = bankStatementConn.prepareStatement("Select STATEMENT_IMAGE from HOMELOANDOCUMENTS where ID=?");
											bankStatementps.setLong(1,id);
											ResultSet bankStatementrs = bankStatementps.executeQuery();
											
											if (bankStatementrs.next())
											{
												Blob bankStatmentFile = bankStatementrs.getBlob("STATEMENT_IMAGE");
												byte barr[] = bankStatmentFile.getBytes(1, (int)bankStatmentFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												bankStatmentJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to diplay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								homePlanJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame homePlanJFrame = new JFrame();
										JLabel homePlanJLabel = new JLabel();
										homePlanJFrame.setVisible(true);
										homePlanJFrame.setSize(900, 750);
										homePlanJFrame.setTitle("Uploaded Home Plan");
										homePlanJFrame.setLocation(350, 20);
										homePlanJFrame.add(homePlanJLabel);
										
										try {
											long id = applicationId;
											Connection homeplanConn = DBConnection.getCon();
											PreparedStatement homePlanps = homeplanConn.prepareStatement("Select HPLAN_IMAGE from HOMELOANDOCUMENTS where ID=?");
											homePlanps.setLong(1,id);
											ResultSet homePlanrs = homePlanps.executeQuery();
											
											if (homePlanrs.next())
											{
												Blob homePlanFile = homePlanrs.getBlob("HPLAN_IMAGE");
												byte barr[] = homePlanFile.getBytes(1, (int)homePlanFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												homePlanJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Imange is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								perimissonforHomeJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame permissinJFrame = new JFrame();
										JLabel permissionJLabel = new JLabel();
										permissinJFrame.setVisible(true);
										permissinJFrame.setSize(900, 750);
										permissinJFrame.setTitle("Uploaded Home's Permission Reciept");
										permissinJFrame.setLocation(350,20);
										permissinJFrame.add(permissionJLabel);
										
										try {
											long id = applicationId;
											Connection permissionConn = DBConnection.getCon();
											PreparedStatement permissionps = permissionConn.prepareStatement("Select PERMISSION_IMAGE from HOMELOANDOCUMENTS where ID=?");
											permissionps.setLong(1,id);
											ResultSet permissionrs = permissionps.executeQuery();
											
											if (permissionrs.next())
											{
												Blob permissionFile = permissionrs.getBlob("PERMISSION_IMAGE");
												byte barr[] = permissionFile.getBytes(1, (int)permissionFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												permissionJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
										
									}
								});
							
							} 
					else if(typeOfLoanJTextField.getText().equals("Vehicle Loan")) 
							{
								add(uploadedDocumentsJLabel);
								uploadedDocumentsJLabel.setBounds(30, 420, 280, 23);
								uploadedDocumentsJLabel.setFont(new Font("Arial", Font.BOLD, 20));
				    
								add(photoJLabel);
								photoJLabel.setBounds(400, 450, 250, 20);
								photoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(photoJButton);
								photoJButton.setBounds(900, 450, 150, 20);
								photoJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(singJLabel);
								singJLabel.setBounds(400, 490, 250, 20);
								singJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(signJButton);
								signJButton.setBounds(900, 490, 150, 20);
								signJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								   
								add(adharcardJLabel);
								adharcardJLabel.setBounds(400, 530, 250, 20);	
								adharcardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(adharcardJButton);
								adharcardJButton.setBounds(900, 530, 150, 20);
								adharcardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(pancardJLabel);
								pancardJLabel.setBounds(400, 570, 250, 20);
								pancardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(pancardJButton);
								pancardJButton.setBounds(900, 570, 150, 20);
								pancardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(incomeCertificateJLabel);
								incomeCertificateJLabel.setBounds(400, 610, 250, 20);
								incomeCertificateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(incomeCertificateJButton);
								incomeCertificateJButton.setBounds(900, 610, 150, 20);
								incomeCertificateJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(bankStatementJLabel);
								bankStatementJLabel.setBounds(400, 650, 250, 20);
								bankStatementJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(bankStatementJButton);
								bankStatementJButton.setBounds(900, 650, 150, 20);
								bankStatementJButton.setFont(new Font("Arial", Font.PLAIN, 20));
								
								add(vehicallicenceJLabel);
								vehicallicenceJLabel.setBounds(400, 690, 250, 20);
								vehicallicenceJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(vehicallicenceJButton);
								vehicallicenceJButton.setBounds(900, 690, 150, 20);
								vehicallicenceJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(vehicalInsurienceJLabel);
								vehicalInsurienceJLabel.setBounds(400, 730, 250, 20);
								vehicalInsurienceJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(vehicalInsurienceJButton);
								vehicalInsurienceJButton.setBounds(900, 730, 150, 20);
								vehicalInsurienceJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								
								 photoJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame photoJFrame = new JFrame();
											JLabel displayImageJLabel = new JLabel();
											photoJFrame.setVisible(true);
											photoJFrame.setSize(900, 750);
											//photoJFrame.setLayout(null);
											photoJFrame.setTitle("Uploaded Photo");
											photoJFrame.setLocation(350,20);
											photoJFrame.add(displayImageJLabel);
											photoJFrame.getContentPane().setBackground(Color.WHITE);
											
											try {
												long id = applicationId;
												Connection photoCon = DBConnection.getCon();
												PreparedStatement photops = photoCon.prepareStatement("Select PHOTO_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												photops.setLong(1,id);
												ResultSet photors = photops.executeQuery();
												if (photors.next())
												{
													Blob photoFile = photors.getBlob("PHOTO_IMAGE");
													byte barr[] = photoFile.getBytes(1, (int)photoFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													displayImageJLabel.setIcon(new ImageIcon(image));	
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Image is unable to dislay");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
									
									signJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame signJFrame = new JFrame();
											JLabel displaySignJLabel = new JLabel();
											signJFrame.setVisible(true);
											signJFrame.setSize(900, 750);
											signJFrame.setTitle("Uploaded Signature");
											signJFrame.setLocation(350,20);
											signJFrame.add(displaySignJLabel);
											signJFrame.setBackground(Color.WHITE);
											
											try {
												long id = applicationId;
												Connection signConn = DBConnection.getCon();
												PreparedStatement signps = signConn.prepareStatement("Select SIGN_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												signps.setLong(1,id);
												ResultSet signrs = signps.executeQuery();
												if (signrs.next())
												{
													Blob signFile = signrs.getBlob("SIGN_IMAGE");
													byte barr[] = signFile.getBytes(1, (int)signFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													displaySignJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong!!!"+"\n Image is unable to dislay");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
									
									adharcardJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame adharCardJFrame = new JFrame();
											JLabel adharCardJLabel = new JLabel();
											adharCardJFrame.setVisible(true);
											adharCardJFrame.setSize(900, 750);
											adharCardJFrame.setTitle("Uploaded Adhar Card");
											adharCardJFrame.setLocation(350,20);
											adharCardJFrame.add(adharCardJLabel);
											adharCardJFrame.setBackground(Color.WHITE);
											
											try {
												long id = applicationId;
												Connection adharCardConn = DBConnection.getCon();
												PreparedStatement adharCardps = adharCardConn.prepareStatement("Select ADHAR_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												adharCardps.setLong(1,id);
												ResultSet adharCardrs = adharCardps.executeQuery();
												if (adharCardrs.next())
												{
													Blob adharFile = adharCardrs.getBlob("ADHAR_IMAGE");
													byte barr[] = adharFile.getBytes(1, (int)adharFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													adharCardJLabel.setIcon(new ImageIcon(image));	
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong !!! "+"\n Image is unable to display");			
												}
												
											} catch (Exception e2) {
												e2.printStackTrace();
											}	
										}
									});
									
									pancardJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame panCardJFrame = new JFrame();
											JLabel panCardJLabel = new JLabel();
											panCardJFrame.setVisible(true);
											panCardJFrame.setSize(900, 750);
											panCardJFrame.setTitle("Uploaded Pan Card");
											panCardJFrame.setLocation(350,20);
											panCardJFrame.add(panCardJLabel);
											panCardJFrame.setBackground(Color.WHITE);
											
											try {
												long id = applicationId;
												Connection panCardConn = DBConnection.getCon();
												PreparedStatement panCardps = panCardConn.prepareStatement("Select PAN_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												panCardps.setLong(1,id);
												ResultSet panCardrs = panCardps.executeQuery();
												if (panCardrs.next())
												{
													Blob panFile = panCardrs.getBlob("PAN_IMAGE");
													byte barr[] = panFile.getBytes(1, (int)panFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													panCardJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went Wrong !!!"+"\n Image is unable to display");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
									
									incomeCertificateJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame incomeJFrame = new JFrame();
											JLabel incomeJLabel = new JLabel();
										    incomeJFrame.setVisible(true);
										    incomeJFrame.setSize(900, 750);
										    incomeJFrame.setTitle("Uploaded Income Certificate");
										    incomeJFrame.setLocation(350,20);
										    incomeJFrame.add(incomeJLabel);
										    incomeJFrame.setBackground(Color.WHITE);
										    
										    try {
										    	long id = applicationId;
												Connection incomeConn = DBConnection.getCon();
												PreparedStatement incomeps = incomeConn.prepareStatement("Select INCOME_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												incomeps.setLong(1,id);
												ResultSet incomers = incomeps.executeQuery();
												if (incomers.next())
												{
													Blob incomeFile = incomers.getBlob("INCOOME_IMAGE");
													byte barr[] = incomeFile.getBytes(1, (int)incomeFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													incomeJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
									bankStatementJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame bankStatementJFrame = new JFrame();
											JLabel bankStatmentJLabel = new JLabel();
											bankStatementJFrame.setVisible(true);
											bankStatementJFrame.setSize(900, 750);
											bankStatementJFrame.setTitle("Uploaded 6 Months Bank Statements");
											bankStatementJFrame.setLocation(350,20);
											bankStatementJFrame.add(bankStatmentJLabel);
											
											try {
												long id = applicationId;
												Connection bankStatementConn = DBConnection.getCon();
												PreparedStatement bankStatementps = bankStatementConn.prepareStatement("Select STATEMENT_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												bankStatementps.setLong(1,id);
												ResultSet bankStatementrs = bankStatementps.executeQuery();
												
												if (bankStatementrs.next())
												{
													Blob bankStatmentFile = bankStatementrs.getBlob("STATEMENT_IMAGE");
													byte barr[] = bankStatmentFile.getBytes(1, (int)bankStatmentFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													bankStatmentJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to diplay");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
									
									vehicallicenceJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame licenceJFrame = new JFrame();
											JLabel licenceJLabel = new JLabel();
											licenceJFrame.setVisible(true);
											licenceJFrame.setSize(900, 750);
											licenceJFrame.setTitle("Uploaded Vehicle Licence");
											licenceJFrame.setLocation(350, 20);
											licenceJFrame.add(licenceJLabel);
											
											try {
												long id = applicationId;
												Connection licenceConn = DBConnection.getCon();
												PreparedStatement licenceps = licenceConn.prepareStatement("Select LICENCE_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												licenceps.setLong(1,id);
												ResultSet licencers = licenceps.executeQuery();
												
												if (licencers.next())
												{
													Blob licenceFile = licencers.getBlob("LICENCE_IMAGE");
													byte barr[] = licenceFile.getBytes(1, (int)licenceFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													licenceJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went Wrong"+"\n Image is unable to display");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}	
										}
									});
									
									vehicalInsurienceJButton.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											JFrame insurenceJFrame = new JFrame();
											JLabel insurenceJLabel = new JLabel();
											insurenceJFrame.setVisible(true);
											insurenceJFrame.setSize(900, 750);
											insurenceJFrame.setTitle("Uploaded Vehicle Insurence Reciept");
											insurenceJFrame.setLocation(350, 20);
											insurenceJFrame.add(insurenceJLabel);
											
											try {
												long id = applicationId;
												Connection insurenceConn = DBConnection.getCon();
												PreparedStatement insurenceps = insurenceConn.prepareStatement("Select VENSURENCE_IMAGE from VECHICALLOANDOCUMENTS where ID=?");
												insurenceps.setLong(1,id);
												ResultSet insurencers = insurenceps.executeQuery();
												if (insurencers.next()) 
												{
													Blob insurenceFile = insurencers.getBlob("VENSURENCE_IMAGE");
													byte barr[] = insurenceFile.getBytes(1, (int)insurenceFile.length());
													BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
													insurenceJLabel.setIcon(new ImageIcon(image));
												} else {
													JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
												}
											} catch (Exception e2) {
												e2.printStackTrace();
											}
										}
									});
								
							}
					else if(typeOfLoanJTextField.getText().equals("Education Loan")) 
							{
								add(uploadedDocumentsJLabel);
								uploadedDocumentsJLabel.setBounds(30, 420, 280, 23);
								uploadedDocumentsJLabel.setFont(new Font("Arial", Font.BOLD, 20));
				    
								add(photoJLabel);
		    					photoJLabel.setBounds(400, 450, 250, 20);
		    					photoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(photoJButton);
								photoJButton.setBounds(900, 450, 150, 20);
								photoJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
		    					add(singJLabel);
		    					singJLabel.setBounds(400, 490, 250, 20);
		    					singJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(signJButton);
								signJButton.setBounds(900, 490, 150, 20);
								signJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
		    					add(adharcardJLabel);
		    					adharcardJLabel.setBounds(400, 530, 250, 20);
		    					adharcardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(adharcardJButton);
								adharcardJButton.setBounds(900, 530, 150, 20);
								adharcardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
		    					add(pancardJLabel);
		    					pancardJLabel.setBounds(400, 570, 250, 20);
		    					pancardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(pancardJButton);
								pancardJButton.setBounds(900, 570, 150, 20);
								pancardJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
		    					add(incomeCertificateJLabel);
		    					incomeCertificateJLabel.setBounds(400, 610, 250, 20);
		    					incomeCertificateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(incomeCertificateJButton);
								incomeCertificateJButton.setBounds(900, 610, 150, 20);
								incomeCertificateJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
		    					add(bankStatementJLabel);
		    					bankStatementJLabel.setBounds(400, 650, 250, 20);
		    					bankStatementJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		    					add(bankStatementJButton);
								bankStatementJButton.setBounds(900, 650, 150, 20);
								bankStatementJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								add(scletterJLabel);
								scletterJLabel.setBounds(400, 690, 250, 20);
								scletterJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
								add(scLetterJButton);
								scLetterJButton.setBounds(900, 690, 150, 20);
								scLetterJButton.setFont(new Font("Arial", Font.PLAIN, 18));
								
								photoJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame photoJFrame = new JFrame();
										JLabel displayImageJLabel = new JLabel();
										photoJFrame.setVisible(true);
										photoJFrame.setSize(900, 750);
										//photoJFrame.setLayout(null);
										photoJFrame.setTitle("Uploaded Photo");
										photoJFrame.setLocation(350,20);
										photoJFrame.add(displayImageJLabel);
										photoJFrame.getContentPane().setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection photoCon = DBConnection.getCon();
											PreparedStatement photops = photoCon.prepareStatement("Select PHOTO_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											photops.setLong(1,id);
											ResultSet photors = photops.executeQuery();
											if (photors.next())
											{
												Blob photoFile = photors.getBlob("PHOTO_IMAGE");
												byte barr[] = photoFile.getBytes(1, (int)photoFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												displayImageJLabel.setIcon(new ImageIcon(image));	
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Image is unable to dislay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								signJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame signJFrame = new JFrame();
										JLabel displaySignJLabel = new JLabel();
										signJFrame.setVisible(true);
										signJFrame.setSize(900, 750);
										signJFrame.setTitle("Uploaded Signature");
										signJFrame.setLocation(350,20);
										signJFrame.add(displaySignJLabel);
										signJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection signConn = DBConnection.getCon();
											PreparedStatement signps = signConn.prepareStatement("Select SIGN_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											signps.setLong(1,id);
											ResultSet signrs = signps.executeQuery();
											if (signrs.next())
											{
												Blob signFile = signrs.getBlob("SIGN_IMAGE");
												byte barr[] = signFile.getBytes(1, (int)signFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												displaySignJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong!!!"+"\n Image is unable to dislay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								adharcardJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame adharCardJFrame = new JFrame();
										JLabel adharCardJLabel = new JLabel();
										adharCardJFrame.setVisible(true);
										adharCardJFrame.setSize(900, 750);
										adharCardJFrame.setTitle("Uploaded Adhar Card");
										adharCardJFrame.setLocation(350,20);
										adharCardJFrame.add(adharCardJLabel);
										adharCardJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection adharCardConn = DBConnection.getCon();
											PreparedStatement adharCardps = adharCardConn.prepareStatement("Select ADHAR_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											adharCardps.setLong(1,id);
											ResultSet adharCardrs = adharCardps.executeQuery();
											if (adharCardrs.next())
											{
												Blob adharFile = adharCardrs.getBlob("ADHAR_IMAGE");
												byte barr[] = adharFile.getBytes(1, (int)adharFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												adharCardJLabel.setIcon(new ImageIcon(image));	
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong !!! "+"\n Image is unable to display");			
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}	
									}
								});
								
								pancardJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame panCardJFrame = new JFrame();
										JLabel panCardJLabel = new JLabel();
										panCardJFrame.setVisible(true);
										panCardJFrame.setSize(900, 750);
										panCardJFrame.setTitle("Uploaded Pan Card");
										panCardJFrame.setLocation(350,20);
										panCardJFrame.add(panCardJLabel);
										panCardJFrame.setBackground(Color.WHITE);
										
										try {
											long id = applicationId;
											Connection panCardConn = DBConnection.getCon();
											PreparedStatement panCardps = panCardConn.prepareStatement("Select PAN_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											panCardps.setLong(1,id);
											ResultSet panCardrs = panCardps.executeQuery();
											if (panCardrs.next())
											{
												Blob panFile = panCardrs.getBlob("PAN_IMAGE");
												byte barr[] = panFile.getBytes(1, (int)panFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												panCardJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went Wrong !!!"+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								incomeCertificateJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame incomeJFrame = new JFrame();
										JLabel incomeJLabel = new JLabel();
									    incomeJFrame.setVisible(true);
									    incomeJFrame.setSize(900, 750);
									    incomeJFrame.setTitle("Uploaded Income Certificate");
									    incomeJFrame.setLocation(350,20);
									    incomeJFrame.add(incomeJLabel);
									    incomeJFrame.setBackground(Color.WHITE);
									    
									    try {
									    	long id = applicationId;
											Connection incomeConn = DBConnection.getCon();
											PreparedStatement incomeps = incomeConn.prepareStatement("Select INCOME_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											incomeps.setLong(1,id);
											ResultSet incomers = incomeps.executeQuery();
											if (incomers.next())
											{
												Blob incomeFile = incomers.getBlob("INCOOME_IMAGE");
												byte barr[] = incomeFile.getBytes(1, (int)incomeFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												incomeJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								bankStatementJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame bankStatementJFrame = new JFrame();
										JLabel bankStatmentJLabel = new JLabel();
										bankStatementJFrame.setVisible(true);
										bankStatementJFrame.setSize(900, 750);
										bankStatementJFrame.setTitle("Uploaded 6 Months Bank Statements");
										bankStatementJFrame.setLocation(350,20);
										bankStatementJFrame.add(bankStatmentJLabel);
										
										try {
											long id = applicationId;
											Connection bankStatementConn = DBConnection.getCon();
											PreparedStatement bankStatementps = bankStatementConn.prepareStatement("Select STATEMENT_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											bankStatementps.setLong(1,id);
											ResultSet bankStatementrs = bankStatementps.executeQuery();
											
											if (bankStatementrs.next())
											{
												Blob bankStatmentFile = bankStatementrs.getBlob("STATEMENT_IMAGE");
												byte barr[] = bankStatmentFile.getBytes(1, (int)bankStatmentFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												bankStatmentJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to diplay");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
								
								scLetterJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame scLetterJFrame = new JFrame();
										JLabel scLetterJLabel = new JLabel();
										scLetterJFrame.setVisible(true);
										scLetterJFrame.setSize(900, 750);
										scLetterJFrame.setLocation(350, 20);
										scLetterJFrame.setTitle("Uploaded Letter for Education loan");
										scLetterJFrame.add(scLetterJLabel);
										
										try {
											long id = applicationId;
											Connection scLetterConn = DBConnection.getCon();
											PreparedStatement scLetterps = scLetterConn.prepareStatement("Select  SCLETTER_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											scLetterps.setLong(1,id);
											ResultSet scLetterrs = scLetterps.executeQuery();
											if (scLetterrs.next())
											{
												Blob scLetterFile = scLetterrs.getBlob("SCLETTER_IMAGE");
												byte barr[] = scLetterFile.getBytes(1, (int)scLetterFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												scLetterJLabel.setIcon(new ImageIcon(image));
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n IMage is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});	
								
								scLeavingJButton.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
										JFrame scLeavingJFrame = new JFrame();
										JLabel scLeavingJLabel = new JLabel();
										scLeavingJFrame.setVisible(true);
										scLeavingJFrame.setSize(900, 750);
										scLeavingJFrame.setTitle("Uploaded Leaving Certificate");
										scLeavingJFrame.setLocation(350, 20);
										scLeavingJFrame.add(scLeavingJLabel);
										
										try {
											long id = applicationId;
											Connection scLeavingCon = DBConnection.getCon();
											PreparedStatement scLeavingps = scLeavingCon.prepareStatement("Select  SCLEAVING_IMAGE from EDUCATIONLOANDOCUMENTS where ID=?");
											scLeavingps.setLong(1,id);
											ResultSet scLeavingrs = scLeavingps.executeQuery();
											
											if (scLeavingrs.next()) 
											{
												Blob scLeavingFile = scLeavingrs.getBlob("SCLEAVING_IMAGE");
												byte barr[] = scLeavingFile.getBytes(1, (int)scLeavingFile.length());
												BufferedImage image = ImageIO.read(new ByteArrayInputStream(barr));
												scLeavingJLabel.setIcon(new ImageIcon(image));	
											} else {
												JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong"+"\n Image is unable to display");
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									}
								});
							}
					else  
					  {
						JOptionPane.showMessageDialog(TakenLoanInfo.this, "Something went wrong "+"\n Please Try Again");
					  }  
					} else {
						JOptionPane.showMessageDialog(TakenLoanInfo.this, "Invalid Account Number And Application ID");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoanLoginSuccessfull().setVisible(true);
				setVisible(false);
			}
		});
			
	}
	public static void main(String[] args)
	{
		TakenLoanInfo takenLoanInfo = new TakenLoanInfo();
		takenLoanInfo.setVisible(true);
		takenLoanInfo.setResizable(false);
	}
}
