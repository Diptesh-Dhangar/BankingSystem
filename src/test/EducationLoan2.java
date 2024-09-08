package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("serial")
public class EducationLoan2 extends JFrame 
{
	JLabel headingJLabel = new JLabel("Official Detials");
    JLabel subHeadingJLabel = new JLabel("Uploading Documents");
    JLabel photoJLabel = new JLabel("Photo:");
    JLabel photoselectionstatusJLabel = new JLabel("No file slected");
    JLabel signJLabel = new JLabel("Sign:");
    JLabel signselectionstatusJLabel = new JLabel("No file slected");
    JLabel adharCardJLabel = new JLabel("Adhar Card:");
    JLabel adharselectionstatusJLabel = new JLabel("No file slected");
    JLabel panCardJLabel  = new JLabel("Pan Card:");
    JLabel panselectionstatusJLabel = new JLabel("No file slected");
    JLabel incomeCertificateJLabel = new JLabel("Income Certificate:");
    JLabel incomeCertificateselectionstatusJLabel = new JLabel("No file slected");
    JLabel bankStatementJLabel = new JLabel("6 Month's Bank Statement:");
    JLabel bankStatementselectionstatusJLabel = new JLabel("No file slected");
    JLabel schoolCollegeLetterJLabel = new JLabel("School/College Letter:");
    JLabel schoolCollegeLetterselectionstatusJLabel = new JLabel("No file slected");
    JLabel schoolCollegeLCJLabel = new JLabel("School/College LC:");
    JLabel schoolCollegeLCselectionstatusJLabel = new JLabel("No file slected");
    
    JLabel applicationIdJLabel = new JLabel("Application ID:");
    JTextField applicationIdJTextField = new JTextField();
    
    JButton photosChooseJButton = new JButton("Choose File");
	JButton singChooseJButton = new JButton("Choose File");
	JButton adharCardChooseJButton = new JButton("Choose File");
	JButton panCardChooseJButton  = new JButton("Choose File");
	JButton incomeCertificateChooseJButton = new JButton("Choose File");
	JButton bankStatementChooseJButton = new JButton("Choose File");
	JButton scLetterChooseJButton = new JButton("Choose File");
	JButton scLeavingChooseJButton = new JButton("Choose File");
	
	ButtonGroup incomeCertificateButtonGroup = new ButtonGroup();
	JRadioButton yesincomeCertificateJRadioButton = new JRadioButton("Yes");
	JRadioButton noincomeCertificateJRadioButton = new JRadioButton("No");

	ButtonGroup bankStatementButtonGroup = new  ButtonGroup();
	JRadioButton yesBankStatementJRadioButton = new JRadioButton("Yes");
	JRadioButton noBankStatementJRadioButton = new JRadioButton("No");

	ButtonGroup scLetterButtonGroup = new  ButtonGroup();
	JRadioButton yesScLetterJRadioButton = new JRadioButton("Yes");
	JRadioButton noScLetterJRadioButton = new JRadioButton("No");
	
	ButtonGroup scLeavingButtonGroup = new  ButtonGroup();
	JRadioButton yesScLeavingJRadioButton = new JRadioButton("Yes");
	JRadioButton noScLeavingJRadioButton   = new JRadioButton("No");
	
	JButton photouploadJButton = new JButton("Upload");
	JButton signuploadJButton = new JButton("Upload");
	JButton adharuploadJButton = new JButton("Upload");
	JButton panuploadJButton = new JButton("Upload");
	JButton incomeuploadJButton = new JButton("Upload");
	JButton statementuploadJButton = new JButton("Upload");
	JButton scLetteruploadJButton = new JButton("Upload");
	JButton scLeavinguploadJButton = new JButton("Upload");
	
	JButton cancelJButton = new JButton("Cancel");
	JButton submitJButton = new JButton("Submit");

	String photofilePath;
	String signfilePath;
	String adharCardFilePath;
	String panCardFilePath;
	String incomeFilePath;
	String bankStatementFilePath;
	String scLetterFilePath;
	String scLeavingFilePath;

	public EducationLoan2() 
	{
		setSize(1000, 780);
		setTitle("DSD - Upoald Documents for Personal Loan");
		setLayout(null);
		setLocation(270, 30);
		
		add(headingJLabel);
		headingJLabel.setBounds(400, 10, 200, 25);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		add(subHeadingJLabel);
		subHeadingJLabel.setBounds(375, 50, 250, 23);
		subHeadingJLabel.setFont(new Font("Arial", Font.TRUETYPE_FONT, 21));
		
		add(applicationIdJLabel);
		applicationIdJLabel.setBounds(750, 12, 150, 20);
		applicationIdJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(applicationIdJTextField);
		applicationIdJTextField.setBounds(900, 10, 70, 25);
		applicationIdJTextField.setFont(new Font("Arial", Font.BOLD, 23));
		
		add(photoJLabel);
		photoJLabel.setBounds(40, 120, 70, 20);
		photoJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(photosChooseJButton);
		photosChooseJButton.setBounds(150, 120, 150, 25);
		add(photoselectionstatusJLabel);
		photoselectionstatusJLabel.setBounds(150, 150, 260, 15);
		add(photouploadJButton);
		photouploadJButton.setBounds(310, 120, 100, 25);
		photouploadJButton.setBackground(Color.BLACK);
		photouploadJButton.setForeground(Color.WHITE);
		
		add(signJLabel);
		signJLabel.setBounds(550, 120, 50, 22);
		signJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(singChooseJButton);
		singChooseJButton.setBounds(670, 120, 150, 25);
		add(signselectionstatusJLabel);
		signselectionstatusJLabel.setBounds(670, 150, 260, 15);
		add(signuploadJButton);
		signuploadJButton.setBounds(830, 120, 100, 25);
		signuploadJButton.setBackground(Color.BLACK);
		signuploadJButton.setForeground(Color.WHITE);
		
		add(adharCardJLabel);
		adharCardJLabel.setBounds(40, 265, 110, 22);
		adharCardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(adharCardChooseJButton);
		adharCardChooseJButton.setBounds(150, 265, 150, 25);
		add(adharselectionstatusJLabel);
		adharselectionstatusJLabel.setBounds(150, 295, 260, 15);
		add(adharuploadJButton);
		adharuploadJButton.setBounds(310, 265, 100, 25);
		adharuploadJButton.setBackground(Color.BLACK);
		adharuploadJButton.setForeground(Color.WHITE);
		
		add(panCardJLabel);
		panCardJLabel.setBounds(550, 265, 110, 20);
		panCardJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(panCardChooseJButton);
		panCardChooseJButton.setBounds(670, 265, 150, 25);
		add(panselectionstatusJLabel);
		panselectionstatusJLabel.setBounds(670, 295, 260, 15);
		add(panuploadJButton);
		panuploadJButton.setBounds(830, 265, 100, 25);
		panuploadJButton.setBackground(Color.BLACK);
		panuploadJButton.setForeground(Color.WHITE);
		
		incomeCertificateButtonGroup.add(yesincomeCertificateJRadioButton);
		incomeCertificateButtonGroup.add(noincomeCertificateJRadioButton);
		
		add(incomeCertificateJLabel);
		incomeCertificateJLabel.setBounds(40, 380, 170, 20);
		incomeCertificateJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yesincomeCertificateJRadioButton);
		yesincomeCertificateJRadioButton.setBounds(230, 380, 70, 20);
		yesincomeCertificateJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yesincomeCertificateJRadioButton.setBackground(Color.WHITE);
		add(noincomeCertificateJRadioButton);
		noincomeCertificateJRadioButton.setBounds(310, 380, 70, 20);
		noincomeCertificateJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		noincomeCertificateJRadioButton.setBackground(Color.WHITE);
		add(incomeCertificateChooseJButton);
		incomeCertificateChooseJButton.setBounds(150, 420, 150, 25);
		incomeCertificateChooseJButton.setEnabled(false);
		add(incomeuploadJButton);
		incomeuploadJButton.setBounds(310, 420, 100, 25);
		incomeuploadJButton.setBackground(Color.BLACK);
		incomeuploadJButton.setForeground(Color.WHITE);
		incomeuploadJButton.setEnabled(false);
		add(incomeCertificateselectionstatusJLabel);
		incomeCertificateselectionstatusJLabel.setBounds(150, 450, 260, 15);
		incomeCertificateselectionstatusJLabel.setEnabled(false);
		
		bankStatementButtonGroup.add(yesBankStatementJRadioButton);
		bankStatementButtonGroup.add(noBankStatementJRadioButton);
		
		add(bankStatementJLabel);
		bankStatementJLabel.setBounds(550, 380, 250, 20);
		bankStatementJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yesBankStatementJRadioButton);
		yesBankStatementJRadioButton.setBounds(810, 380, 70, 20);
		yesBankStatementJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yesBankStatementJRadioButton.setBackground(Color.WHITE);
		add(noBankStatementJRadioButton);
		noBankStatementJRadioButton.setBounds(880, 380, 70, 20);
		noBankStatementJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		noBankStatementJRadioButton.setBackground(Color.WHITE);
		add(bankStatementChooseJButton);
		bankStatementChooseJButton.setBounds(670, 420, 150, 25);
		bankStatementChooseJButton.setEnabled(false);
		add(statementuploadJButton);
		statementuploadJButton.setBounds(830, 420, 100, 25);
		statementuploadJButton.setBackground(Color.BLACK);
		statementuploadJButton.setForeground(Color.WHITE);
		statementuploadJButton.setEnabled(false);
		add(bankStatementselectionstatusJLabel);
		bankStatementselectionstatusJLabel.setBounds(670, 450, 260, 15);
		bankStatementselectionstatusJLabel.setEnabled(false);
		
		scLetterButtonGroup.add(yesScLetterJRadioButton);
		scLetterButtonGroup.add(noScLetterJRadioButton);
		
		add(schoolCollegeLetterJLabel);
		schoolCollegeLetterJLabel.setBounds(40, 535, 200, 23);
		schoolCollegeLetterJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yesScLetterJRadioButton);
		yesScLetterJRadioButton.setBounds(245, 535, 70, 20);
		yesScLetterJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yesScLetterJRadioButton.setBackground(Color.WHITE);
		add(noScLetterJRadioButton);
		noScLetterJRadioButton.setBounds(325, 535, 70, 20);
		noScLetterJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		noScLetterJRadioButton.setBackground(Color.WHITE);
		add(scLetterChooseJButton);
		scLetterChooseJButton.setBounds(150, 575, 150, 25);
		scLetterChooseJButton.setEnabled(false);
		add(scLetteruploadJButton);
		scLetteruploadJButton.setBounds(310, 575, 100, 25);
		scLetteruploadJButton.setBackground(Color.BLACK);
		scLetteruploadJButton.setForeground(Color.WHITE);
		scLetteruploadJButton.setEnabled(false);
		add(schoolCollegeLetterselectionstatusJLabel);
		schoolCollegeLetterselectionstatusJLabel.setBounds(150, 605, 260, 15);
		schoolCollegeLetterselectionstatusJLabel.setEnabled(false);
		
		scLeavingButtonGroup.add(yesScLeavingJRadioButton);
		scLeavingButtonGroup.add(noScLeavingJRadioButton);
		
		add(schoolCollegeLCJLabel);
		schoolCollegeLCJLabel.setBounds(550, 535, 210, 23);
		schoolCollegeLCJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yesScLeavingJRadioButton);
		yesScLeavingJRadioButton.setBounds(740, 535, 70, 20);
		yesScLeavingJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yesScLeavingJRadioButton.setBackground(Color.WHITE);
		add(noScLeavingJRadioButton);
		noScLeavingJRadioButton.setBounds(820, 535, 70, 20);
		noScLeavingJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		noScLeavingJRadioButton.setBackground(Color.WHITE);
		add(scLeavingChooseJButton);
		scLeavingChooseJButton.setBounds(670, 575, 150, 25);
		scLeavingChooseJButton.setEnabled(false);
		add(scLeavinguploadJButton);
		scLeavinguploadJButton.setBounds(830, 575, 100, 25);
		scLeavinguploadJButton.setBackground(Color.BLACK);
		scLeavinguploadJButton.setForeground(Color.WHITE);
		scLeavinguploadJButton.setEnabled(false);
		add(schoolCollegeLCselectionstatusJLabel);
		schoolCollegeLCselectionstatusJLabel.setBounds(670, 605, 260, 15);
		schoolCollegeLCselectionstatusJLabel.setEnabled(false);
		
		add(cancelJButton);
		cancelJButton.setBounds(30, 690, 200, 35);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(submitJButton);
		submitJButton.setBounds(750, 690, 200, 35);
		submitJButton.setFont( new Font("Arial", Font.BOLD, 20));
		submitJButton.setBackground(Color.BLACK);
		submitJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(Color.WHITE);
		
		yesScLetterJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scLetterChooseJButton.setEnabled(true);
				schoolCollegeLetterselectionstatusJLabel.setEnabled(true);
				scLetteruploadJButton.setEnabled(true);
			}
		});
		
		noScLetterJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scLetterChooseJButton.setEnabled(false);
				schoolCollegeLetterselectionstatusJLabel.setEnabled(false);
				scLetteruploadJButton.setEnabled(false);
			}
		});
		
		yesScLeavingJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scLeavingChooseJButton.setEnabled(true);
				schoolCollegeLCselectionstatusJLabel.setEnabled(true);
				scLeavinguploadJButton.setEnabled(true);
			}
		} );
		noScLeavingJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scLeavingChooseJButton.setEnabled(false);
				schoolCollegeLCselectionstatusJLabel.setEnabled(false);
				scLeavinguploadJButton.setEnabled(false);
			}
		});
		
		yesBankStatementJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankStatementChooseJButton.setEnabled(true);
				bankStatementselectionstatusJLabel.setEnabled(true);
				statementuploadJButton.setEnabled(true);
			}
		});
		noBankStatementJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bankStatementChooseJButton.setEnabled(false);
				bankStatementselectionstatusJLabel.setEnabled(false);
				statementuploadJButton.setEnabled(false);
			}
		});
		
		yesincomeCertificateJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incomeCertificateChooseJButton.setEnabled(true);
				incomeCertificateselectionstatusJLabel.setEnabled(true);
				incomeuploadJButton.setEnabled(true);
			}
		});
		noincomeCertificateJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incomeCertificateChooseJButton.setEnabled(false);
				incomeCertificateselectionstatusJLabel.setEnabled(false);
				incomeuploadJButton.setEnabled(false);
			}
		});
		
		photosChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser photoFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				 photoFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				 
				 int r = photoFileChooser.showSaveDialog(null);
				 
				 if (r == JFileChooser.APPROVE_OPTION) 
				 {
					 photofilePath = photoFileChooser.getSelectedFile().getAbsolutePath();
					 String photofileName = photoFileChooser.getSelectedFile().getName();
		             photoselectionstatusJLabel.setText(photofileName);
		         }
			}        
		});
		
		singChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser signFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				signFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = signFileChooser.showSaveDialog(null);
				
				if (r == JFileChooser.APPROVE_OPTION)
				{
				    signfilePath = signFileChooser.getSelectedFile().getAbsolutePath();
					String signfileName = signFileChooser.getSelectedFile().getName();
					signselectionstatusJLabel.setText(signfileName);
				}
			}
		});
		
	    adharCardChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser adharCardFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				adharCardFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = adharCardFileChooser.showSaveDialog(null);
				if (r== JFileChooser.APPROVE_OPTION) 
				{
				    adharCardFilePath = adharCardFileChooser.getSelectedFile().getAbsolutePath();
					String adharCardFileName = adharCardFileChooser.getSelectedFile().getName();
					adharselectionstatusJLabel.setText(adharCardFileName);
				}
			}
		});
	    
	    panCardChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser panCardFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				panCardFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = panCardFileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) 
				{
				    panCardFilePath = panCardFileChooser.getSelectedFile().getAbsolutePath();
					String panCardFileName = panCardFileChooser.getSelectedFile().getName();
					panselectionstatusJLabel.setText(panCardFileName);
				}
			}
		});
	    
	    incomeCertificateChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser incomeFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				incomeFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = incomeFileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					incomeFilePath = incomeFileChooser.getSelectedFile().getAbsolutePath();
					String incomeFileName = incomeFileChooser.getSelectedFile().getName();
					incomeCertificateselectionstatusJLabel.setText(incomeFileName);
				}
			}
		});
	    
	    bankStatementChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser bankStatementFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				bankStatementFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);;
				
				int r = bankStatementFileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{ 
					bankStatementFilePath = bankStatementFileChooser.getSelectedFile().getAbsolutePath();
					String bankStatementFileName = bankStatementFileChooser.getSelectedFile().getName();
					bankStatementselectionstatusJLabel.setText(bankStatementFileName);
				}
			}
		});
	    
	    scLetterChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser scLetterFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				scLetterFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = scLetterFileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					scLetterFilePath = scLetterFileChooser.getSelectedFile().getAbsolutePath();
					String scLetterFileName = scLetterFileChooser.getSelectedFile().getName();
					schoolCollegeLetterselectionstatusJLabel.setText(scLetterFileName);
				}
			}
		});
	    
	    scLeavingChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser scLeavingFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory())	;
				scLeavingFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = scLeavingFileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					scLeavingFilePath = scLeavingFileChooser.getSelectedFile().getAbsolutePath();
					String scLeavingFileName = scLeavingFileChooser.getSelectedFile().getName();
					schoolCollegeLCselectionstatusJLabel.setText(scLeavingFileName);
				}
			}
		});
	    
	    photouploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream photoInputStream = new FileInputStream(photofilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET PHOTO_IMAGE=? WHERE ID=?");
					
					ps1.setBlob(1, photoInputStream);
					ps1.setLong(2, applictionNo);
				
					int i = ps1.executeUpdate();
					if (i==1)
					{
						JOptionPane.showMessageDialog(EducationLoan2.this, "Photo Uploaded Successfully");
						photouploadJButton.setText("Uploaded");
					} else {
						JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Upload Photo");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}	
			}
		});
	    
	    signuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream signInputStream = new FileInputStream(signfilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET SIGN_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, signInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Sign Uploaded Successfully");
								signuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Sign");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});	
	    

		
	    adharuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream adharInputStream = new FileInputStream(adharCardFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET ADHAR_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, adharInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Adhar Card Uploaded Successfully");
								adharuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Upload Adhar Card");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    panuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream panInputStream = new FileInputStream(panCardFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET PAN_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, panInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Pan Card Uploaded Successfully");
								panuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Pan Card");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    
	    incomeuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream incomInputStream = new FileInputStream(incomeFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET INCOME_IMAGE=? WHERE ID=?");

							ps1.setBlob(1, incomInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Income Certificate Uploaded Successfully");
								incomeuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Income Certificate");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    
	    statementuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream bankStatementInputStream = new FileInputStream(bankStatementFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET STATEMENT_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, bankStatementInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Bank Statement Uploaded Successfully");
								statementuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Bank Statement");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	    scLetteruploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream scLetterInputStream = new FileInputStream(scLetterFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET SCLETTER_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, scLetterInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Bank Statement Uploaded Successfully");
								statementuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Bank Statement");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
	    
	    scLeavinguploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream scLeavingInputStream = new FileInputStream(scLeavingFilePath);
					PreparedStatement ps1 = con.prepareStatement("UPDATE EDUCATIONLOANDOCUMENTS SET SCLEAVING_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, scLeavingInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Bank Statement Uploaded Successfully");
								statementuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(EducationLoan2.this, "Unable to Uploaded Bank Statement");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
	    
	    submitJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (photouploadJButton.getText().equals("Uploaded") && signuploadJButton.getText().equals("Uploaded") && adharuploadJButton.getText().equals("Uploaded") && panuploadJButton.getText().equals("Uploaded") && incomeuploadJButton.getText().equals("Uploaded") && statementuploadJButton.getText().equals("Uploaded") && scLetteruploadJButton.getText().equals("Uploaded") && scLeavinguploadJButton.getText().equals("Uploaded"))
				{
					JOptionPane.showMessageDialog(EducationLoan2.this, "Education Loan Application Submitted Successfully");
				}
				else {
					JOptionPane.showMessageDialog(EducationLoan2.this, "Upload all the documents !!");
				}
			}
		});
	
	}
	public static void main(String[] args) 
	{
		EducationLoan2 educationLoan2 = new EducationLoan2();
		educationLoan2.setVisible(true);
		educationLoan2.setResizable(false);
	}
}
