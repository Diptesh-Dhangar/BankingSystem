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
public class LoanAgainstProperty2  extends JFrame
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
    JLabel extract712JLabel = new JLabel("7/12 Extract:");
    JLabel extract712selectionstatusJLabel = new JLabel("No file slected");
    JLabel propertyDocumentsJLabel = new JLabel("Property Document:");
    JLabel propertyDocumentsselectionstatusJLabel = new JLabel("No file slected");
    
    JLabel applicationIdJLabel = new JLabel("Application ID:");
    JTextField applicationIdJTextField = new JTextField();
    
    JButton photosChooseJButton = new JButton("Choose File");
	JButton singChooseJButton = new JButton("Choose File");
	JButton adharCardChooseJButton = new JButton("Choose File");
	JButton panCardChooseJButton  = new JButton("Choose File");
	JButton incomeCertificateChooseJButton = new JButton("Choose File");
	JButton bankStatementChooseJButton = new JButton("Choose File");
	JButton extract712ChooseJButton = new JButton("Choose File");
	JButton propertyDocumentChooseJButton = new JButton("Choose File");
	
	ButtonGroup incomeCertificateButtonGroup = new ButtonGroup();
	JRadioButton yesincomeCertificateJRadioButton = new JRadioButton("Yes");
	JRadioButton noincomeCertificateJRadioButton = new JRadioButton("No");

	ButtonGroup bankStatementButtonGroup = new  ButtonGroup();
	JRadioButton yesBankStatementJRadioButton = new JRadioButton("Yes");
	JRadioButton noBankStatementJRadioButton = new JRadioButton("No");

	ButtonGroup extract712ButtonGroup = new  ButtonGroup();
	JRadioButton yesextract712JRadioButton = new JRadioButton("Yes");
	JRadioButton noextract712JRadioButton = new JRadioButton("No");
	
	ButtonGroup propertyDocumentsButtonGroup = new  ButtonGroup();
	JRadioButton yespropertyDocumentsJRadioButton = new JRadioButton("Yes");
	JRadioButton nopropertyDocumentsJRadioButton   = new JRadioButton("No");
	
	JButton photouploadJButton = new JButton("Upload");
	JButton signuploadJButton = new JButton("Upload");
	JButton adharuploadJButton = new JButton("Upload");
	JButton panuploadJButton = new JButton("Upload");
	JButton incomeuploadJButton = new JButton("Upload");
	JButton statementuploadJButton = new JButton("Upload");
	JButton extract712uploadJButton = new JButton("Upload");
	JButton propertyDocumentsuploadJButton = new JButton("Upload");
	
	JButton cancelJButton = new JButton("Cancel");
	JButton submitJButton = new JButton("Submit");

	String photofilePath;
	String signfilePath;
	String adharCardFilePath;
	String panCardFilePath;
	String incomeFilePath;
	String bankStatementFilePath;
	String extract712FilePath;
	String propertyDocumentsFilePath;

	public LoanAgainstProperty2()
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
		
		extract712ButtonGroup.add(yesextract712JRadioButton);
		extract712ButtonGroup.add(noextract712JRadioButton);
		
		add(extract712JLabel);
		extract712JLabel.setBounds(40, 535, 160, 20);
		extract712JLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yesextract712JRadioButton);
		yesextract712JRadioButton.setBounds(205, 535, 70, 20);
		yesextract712JRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yesextract712JRadioButton.setBackground(Color.WHITE);
		add(noextract712JRadioButton);
		noextract712JRadioButton.setBounds(295, 535, 70, 20);
		noextract712JRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		noextract712JRadioButton.setBackground(Color.WHITE);
		add(extract712ChooseJButton);
		extract712ChooseJButton.setBounds(150, 575, 150, 25);
		extract712ChooseJButton.setEnabled(false);
		add(extract712uploadJButton);
		extract712uploadJButton.setBounds(310, 575, 100, 25);
		extract712uploadJButton.setBackground(Color.BLACK);
		extract712uploadJButton.setForeground(Color.WHITE);
		extract712uploadJButton.setEnabled(false);
		add(extract712selectionstatusJLabel);
		extract712selectionstatusJLabel.setBounds(150, 605, 260, 15);
		extract712selectionstatusJLabel.setEnabled(false);
		
		propertyDocumentsButtonGroup.add(yespropertyDocumentsJRadioButton);
		propertyDocumentsButtonGroup.add(nopropertyDocumentsJRadioButton);
		
		add(propertyDocumentsJLabel);
		propertyDocumentsJLabel.setBounds(550, 535, 210, 20);
		propertyDocumentsJLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(yespropertyDocumentsJRadioButton);
		yespropertyDocumentsJRadioButton.setBounds(740, 535, 70, 20);
		yespropertyDocumentsJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		yespropertyDocumentsJRadioButton.setBackground(Color.WHITE);
		add(nopropertyDocumentsJRadioButton);
		nopropertyDocumentsJRadioButton.setBounds(820, 535, 70, 20);
		nopropertyDocumentsJRadioButton.setFont(new Font("Arial", Font.BOLD, 20));
		nopropertyDocumentsJRadioButton.setBackground(Color.WHITE);
		add(propertyDocumentChooseJButton);
		propertyDocumentChooseJButton.setBounds(670, 575, 150, 25);
		propertyDocumentChooseJButton.setEnabled(false);
		add(propertyDocumentsuploadJButton);
		propertyDocumentsuploadJButton.setBounds(830, 575, 100, 25);
		propertyDocumentsuploadJButton.setBackground(Color.BLACK);
		propertyDocumentsuploadJButton.setForeground(Color.WHITE);
		propertyDocumentsuploadJButton.setEnabled(false);
		add(propertyDocumentsselectionstatusJLabel);
		propertyDocumentsselectionstatusJLabel.setBounds(670, 605, 260, 15);
		propertyDocumentsselectionstatusJLabel.setEnabled(false);
		
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
		
		yesextract712JRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				extract712ChooseJButton.setEnabled(true);
				extract712selectionstatusJLabel.setEnabled(true);
				extract712uploadJButton.setEnabled(true);
			}
		});
		noextract712JRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				extract712ChooseJButton.setEnabled(false);
				extract712selectionstatusJLabel.setEnabled(false);
				extract712uploadJButton.setEnabled(false);
			}
		});
		
		yespropertyDocumentsJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				propertyDocumentChooseJButton.setEnabled(true);
				propertyDocumentsselectionstatusJLabel.setEnabled(true);
				propertyDocumentsuploadJButton.setEnabled(true);
			}
		});
		nopropertyDocumentsJRadioButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				propertyDocumentChooseJButton.setEnabled(false);
				propertyDocumentsselectionstatusJLabel.setEnabled(false);
				propertyDocumentsuploadJButton.setEnabled(false);
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
	    
	    extract712ChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser extract712FileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				extract712FileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = extract712FileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					extract712FilePath = extract712FileChooser.getSelectedFile().getAbsolutePath();
					String extract712FileName = extract712FileChooser.getSelectedFile().getName();
					extract712selectionstatusJLabel.setText(extract712FileName);
				}
			}
		});
		
	    propertyDocumentChooseJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser propertyDocumentsFileChooser = new JFileChooser();
				propertyDocumentsFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				int r = propertyDocumentsFileChooser.showSaveDialog(null);
				
				if (r == JFileChooser.APPROVE_OPTION)
				{
					propertyDocumentsFilePath = propertyDocumentsFileChooser.getSelectedFile().getAbsolutePath();
					String propertyDocumentFileName = propertyDocumentsFileChooser.getSelectedFile().getName();
					propertyDocumentsselectionstatusJLabel.setText(propertyDocumentFileName);
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET PHOTO_IMAGE=? WHERE ID=?");
					
					ps1.setBlob(1, photoInputStream);
					ps1.setLong(2, applictionNo);
				
					int i = ps1.executeUpdate();
					if (i==1)
					{
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Photo Uploaded Successfully");
						photouploadJButton.setText("Uploaded");
					} else {
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Upload Photo");
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET SIGN_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, signInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Sign Uploaded Successfully");
								signuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Uploaded Sign");
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET ADHAR_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, adharInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Adhar Card Uploaded Successfully");
								adharuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Upload Adhar Card");
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET PAN_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, panInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Pan Card Uploaded Successfully");
								panuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Uploaded Pan Card");
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET INCOME_IMAGE=? WHERE ID=?");

							ps1.setBlob(1, incomInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Income Certificate Uploaded Successfully");
								incomeuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Uploaded Income Certificate");
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
					PreparedStatement ps1 = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET STATEMENT_IMAGE=? WHERE ID=?");
							
							ps1.setBlob(1, bankStatementInputStream);
							ps1.setLong(2, applictionNo);
							
							int i = ps1.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Bank Statement Uploaded Successfully");
								statementuploadJButton.setText("Uploaded");
							} else 
							{
								JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Uploaded Bank Statement");
							}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    
	    extract712uploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream extract712InputStream = new FileInputStream(extract712FilePath);
					PreparedStatement ps = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET SATRECIEPT_IAMGE=? WHERE ID=?");
					ps.setBlob(1, extract712InputStream);
					ps.setLong(2, applictionNo);
					
					int i = ps.executeUpdate();
					if (i==1)
					{
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "7/12 Extract Uploaded Successfully");
						extract712uploadJButton.setText("Uploaded");
					} else {
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Unable to Upload 7/12 Extract");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    
	    propertyDocumentsuploadJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long applictionNo = Long.parseLong(applicationIdJTextField.getText());
					
					Connection con = DBConnection.getCon();
					InputStream propertyDocumentInputStream = new FileInputStream(propertyDocumentsFilePath);
					PreparedStatement ps = con.prepareStatement("UPDATE LOANAPROPERTYDOCUMENTS SET PROPERTYD_IMAGE=? WHERE ID=?");
					
					ps.setBlob(1,propertyDocumentInputStream);
					ps.setLong(2, applictionNo);
					
					int i = ps.executeUpdate();
					if (i == 1) 
					{
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Property Document Uploaded  Successfully");
						propertyDocumentsuploadJButton.setText("Uploaded");
					}
					else {
						JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Uable to Upload the Property Document");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	    
	    submitJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (photouploadJButton.getText().equals("Uploaded") && signuploadJButton.getText().equals("Uploaded") && adharuploadJButton.getText().equals("Uploaded") && panuploadJButton.getText().equals("Uploaded") && incomeuploadJButton.getText().equals("Uploaded") && statementuploadJButton.getText().equals("Uploaded") && extract712uploadJButton.getText().equals("Uploaded") && propertyDocumentsuploadJButton.getText().equals("Uploaded"))
				{
					JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Loan Application Submitted Successfully");
				} else {
					JOptionPane.showMessageDialog(LoanAgainstProperty2.this, "Upload all the documents first");
				}	
			}
		});
		
		getContentPane().setBackground(Color.WHITE);
		
	}
	public static void main(String[] args)
	{
		LoanAgainstProperty2 loaAgainstProperty2 = new LoanAgainstProperty2();
		loaAgainstProperty2.setVisible(true);
		loaAgainstProperty2.setResizable(false);
	}
}
