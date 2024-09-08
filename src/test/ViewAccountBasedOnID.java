package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ViewAccountBasedOnID extends JFrame
{
	JLabel headingJLabel  = new JLabel("View Account");
	JLabel enterAccountIDJLabel = new JLabel("A/C ID:");
	
	//first Block 
	JLabel subHeading1JLabel = new JLabel("Personal Information");
	JLabel idJLabel = new JLabel("ID:");
	JLabel nameJLabel = new JLabel("Name:");
	JLabel fathernameJLabel = new JLabel("Father's Name:");
	JLabel dOBJLabel = new JLabel("DOB:");
	JLabel genderJLabel = new JLabel("Gender:");
	JLabel maiJLabel = new JLabel("E-Mail:");
	JLabel maritalStatusJLabel = new JLabel("Marital Status:");
	JLabel addressJLabel = new JLabel("Address:");
	JLabel cityJLabel = new JLabel("City:");
	JLabel pinCodeJLabel = new JLabel("Pin Code:");
	JLabel stateJLabel = new JLabel("State:");
	JLabel mobileNoJLabel = new JLabel("Mobile:");
	
	//Second Block 
	JLabel subHeading2JLabel = new JLabel("Additional Information");
	JLabel religionJLabel = new JLabel("Religion");
	JLabel categoryJLabel = new JLabel("Category");
	JLabel incomeJLabel = new JLabel("Income");
	JLabel educationJLabel = new JLabel("Education");
	JLabel occupationJLabel = new JLabel("Occupation");
	JLabel panNoJLabel = new JLabel("Pan No");
	JLabel adharNoJLabel = new JLabel("Adhar No");
	JLabel seniorCitizenJLabel  = new JLabel("Senior Citizen");
	
	//Third Block
	JLabel subHeading3JLabel = new JLabel("Account Detials");
	JLabel accountTypeJLabel = new JLabel("Account Type");
	JLabel accountNoJLabel = new JLabel("Account Number");
	JLabel servicesJLabel = new JLabel("Services");
	JLabel pinNoJLabel = new JLabel("Pin No");
	JLabel accountBalanceJLabel = new JLabel("Account Balance");
	JLabel enterPinJLabel = new JLabel("Pin No:");
	
	//TextFields
	JTextField enterAccountIDJTextField   = new JTextField();
	
	//TextFields for First Block 
	JTextField idJTextField = new JTextField();
	JTextField nameJTextField = new JTextField();
	JTextField fathernameJTextField = new JTextField();
	JTextField dateOfBirthJTextField = new JTextField();
	JTextField monthOfBirthJTextField  = new JTextField();
	JTextField yearOfBirthJTextField = new JTextField();
	JTextField genderJTextField = new JTextField();
	JTextField mailJTextField = new JTextField();
	JTextField maritalStatusJTextField = new JTextField();
	JTextField addressJTextField = new JTextField();
	JTextField cityJTextField = new JTextField();
	JTextField pinCodeJTextField = new JTextField();
	JTextField stateJTextField = new JTextField();
	JTextField mobileNoJTextField = new JTextField();
	
	//TextFields for Second Block
	JTextField religionJTextField = new JTextField();
	JTextField categoryJTextField = new JTextField();
	JTextField incomeJTextField = new JTextField();
	JTextField educationJTextField = new JTextField();
	JTextField occupationJTextField = new JTextField();
	JTextField panNoJTextField = new JTextField();
	JTextField adharNoJTextField = new JTextField();
	JTextField seniorCitizenJTextField = new JTextField();

	//TextFields for Third Block
	JTextField accountTypeJTextField = new JTextField();
	JTextField accountNoJTextField = new JTextField();
	JTextField servicesJTextField = new JTextField();
	JTextField pinNoJTextField = new JTextField();
	JTextField accountBalanceJTextField = new JTextField();
	JPasswordField enterPinNoJTextField = new JPasswordField();
	
	
	JButton viewDetialsJButton = new JButton("View");	
	JButton backJButton = new JButton("Back");
	JButton viewBalanceJButton = new JButton("View Balance");

	public ViewAccountBasedOnID() 
	{
		setSize(1200, 730);
		setTitle("View Account");
		setLayout(null);
		setLocation(170, 50);
		
		add(headingJLabel);
		headingJLabel.setBounds(515, 10, 170, 20);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(enterAccountIDJLabel);
		enterAccountIDJLabel.setBounds(900, 12, 170, 20);
		enterAccountIDJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(enterAccountIDJTextField);
		enterAccountIDJTextField.setBounds(970, 10, 190, 25);
		enterAccountIDJTextField.setFont(new Font("Arial", Font.BOLD, 25));
		add(viewDetialsJButton);
		viewDetialsJButton.setBounds(970, 40, 190, 30);
		viewDetialsJButton.setFont(new Font("Arial", Font.BOLD, 20));
		viewDetialsJButton.setBackground(Color.BLACK);
		viewDetialsJButton.setForeground(Color.WHITE);
		
		add(idJLabel);
		idJLabel.setBounds(30, 12, 30, 20);
		idJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(idJTextField);
		idJTextField.setBounds(60, 10, 100, 25);
		idJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		idJTextField.setEditable(false);
		idJTextField.setBackground(Color.WHITE);
		
		add(subHeading1JLabel);
		subHeading1JLabel.setBounds(30, 60, 200, 21);
		subHeading1JLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(nameJLabel);
		nameJLabel.setBounds(50, 95, 60, 15);
		nameJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(nameJTextField);
		nameJTextField.setBounds(110, 95, 200, 21);
		nameJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		nameJTextField.setEditable(false);
		nameJTextField.setBackground(Color.WHITE);
		
		add(fathernameJLabel);
		fathernameJLabel.setBounds(420, 95, 120, 15);
		fathernameJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(fathernameJTextField);
		fathernameJTextField.setBounds(540, 95, 200, 21);
		fathernameJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		fathernameJTextField.setEditable(false);
		fathernameJTextField.setBackground(Color.WHITE);
		
		add(dOBJLabel);
		dOBJLabel.setBounds(835, 95, 50, 15);
		dOBJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(dateOfBirthJTextField);
		dateOfBirthJTextField.setBounds(890, 95, 50, 21);
		dateOfBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		dateOfBirthJTextField.setEditable(false);
		dateOfBirthJTextField.setBackground(Color.WHITE);
		add(monthOfBirthJTextField);
		monthOfBirthJTextField.setBounds(945, 95, 100, 21);
		monthOfBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 17) );
		monthOfBirthJTextField.setEditable(false);
		monthOfBirthJTextField.setBackground(Color.WHITE);
		add(yearOfBirthJTextField);
		yearOfBirthJTextField.setBounds(1050, 95, 70, 21);
		yearOfBirthJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		yearOfBirthJTextField.setEditable(false);
		yearOfBirthJTextField.setBackground(Color.WHITE);
		
		add(genderJLabel);
		genderJLabel.setBounds(50, 130, 60, 15);
		genderJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(genderJTextField);
		genderJTextField.setBounds(115, 130, 200, 21);
		genderJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		genderJTextField.setEditable(false);
		genderJTextField.setBackground(Color.WHITE);
		
		add(maiJLabel);
		maiJLabel.setBounds(420, 130, 60, 15);
		maiJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(mailJTextField);
		mailJTextField.setBounds(485, 130, 200, 21);
		mailJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		mailJTextField.setEditable(false);
		mailJTextField.setBackground(Color.WHITE);
		
		add(maritalStatusJLabel);
		maritalStatusJLabel.setBounds(790, 130, 120, 15);
		maritalStatusJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(maritalStatusJTextField);
		maritalStatusJTextField.setBounds(915, 130, 200, 21);
		maritalStatusJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		maritalStatusJTextField.setEditable(false);
		maritalStatusJTextField.setBackground(Color.WHITE);
		
		add(addressJLabel);
		addressJLabel.setBounds(50, 165, 70, 15);
		addressJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(addressJTextField);
		addressJTextField.setBounds(125, 165, 200, 21);
		addressJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		addressJTextField.setEditable(false);
		addressJTextField.setBackground(Color.WHITE);
		
		add(cityJLabel);
		cityJLabel.setBounds(420, 165, 50, 15);
		cityJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(cityJTextField);
		cityJTextField.setBounds(475, 165, 200, 21);
		cityJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		cityJTextField.setEditable(false);
		cityJTextField.setBackground(Color.WHITE);
		
		add(pinCodeJLabel);
		pinCodeJLabel.setBounds(790, 165, 80, 15);
		pinCodeJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(pinCodeJTextField);
		pinCodeJTextField.setBounds(875, 165, 200, 21);
		pinCodeJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		pinCodeJTextField.setEditable(false);
		pinCodeJTextField.setBackground(Color.WHITE);
		
		add(stateJLabel);
		stateJLabel.setBounds(50, 200, 60, 15);
		stateJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(stateJTextField);
		stateJTextField.setBounds(115, 200, 200, 21);
		stateJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		stateJTextField.setEditable(false);
		stateJTextField.setBackground(Color.WHITE);
		
		add(mobileNoJLabel);
		mobileNoJLabel.setBounds(420, 200, 60, 17);
		mobileNoJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(mobileNoJTextField);
		mobileNoJTextField.setBounds(490, 200, 200, 21);
		mobileNoJTextField.setFont( new Font("Arial", Font.PLAIN, 17));
		mobileNoJTextField.setEditable(false);
		mobileNoJTextField.setBackground(Color.WHITE);
		
		add(subHeading2JLabel);
		subHeading2JLabel.setBounds(30, 240, 220, 20);
		subHeading2JLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(religionJLabel);
		religionJLabel.setBounds(50, 275, 70, 17);
		religionJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(religionJTextField);
		religionJTextField.setBounds(125, 275, 200, 21);
		religionJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		religionJTextField.setEditable(false);
		religionJTextField.setBackground(Color.WHITE);
		
		add(categoryJLabel);
		categoryJLabel.setBounds(420, 275, 70, 17);
		categoryJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(categoryJTextField);
		categoryJTextField.setBounds(500, 275, 200, 21);
		categoryJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		categoryJTextField.setEditable(false);
		categoryJTextField.setBackground(Color.WHITE);
		
		add(incomeJLabel);
		incomeJLabel.setBounds(790, 275, 60, 17);
		incomeJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(incomeJTextField);
		incomeJTextField.setBounds(855, 275, 200, 21);
		incomeJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		incomeJTextField.setEditable(false);
		incomeJTextField.setBackground(Color.WHITE);
		
		add(educationJLabel);
		educationJLabel.setBounds(50, 310, 80, 17);
		educationJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(educationJTextField);
		educationJTextField.setBounds(135, 310, 200, 21);
		educationJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		educationJTextField.setEditable(false);
		educationJTextField.setBackground(Color.WHITE);
		
		add(occupationJLabel);
		occupationJLabel.setBounds(420, 310, 90, 17);
		occupationJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(occupationJTextField);
		occupationJTextField.setBounds(515, 310, 200, 21);
		occupationJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		occupationJTextField.setEditable(false);
		occupationJTextField.setBackground(Color.WHITE);
		
		add(panNoJLabel);
		panNoJLabel.setBounds(790, 310, 70, 17);
		panNoJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(panNoJTextField);
		panNoJTextField.setBounds(855, 310, 200, 21);
		panNoJTextField.setFont(new  Font("Arial", Font.PLAIN, 17));
		panNoJTextField.setEditable(false);
		panNoJTextField.setBackground(Color.WHITE);
		
		add(adharNoJLabel);
		adharNoJLabel.setBounds(50, 345, 70, 17);
		adharNoJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(adharNoJTextField);
		adharNoJTextField.setBounds(130, 345, 200, 21);
		adharNoJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		adharNoJTextField.setEditable(false);
		adharNoJTextField.setBackground(Color.WHITE);
		
		add(seniorCitizenJLabel);
		seniorCitizenJLabel.setBounds(420, 345, 110, 17);
		seniorCitizenJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(seniorCitizenJTextField);
		seniorCitizenJTextField.setBounds(540, 345, 200, 21);
		seniorCitizenJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		seniorCitizenJTextField.setEditable(false);
		seniorCitizenJTextField.setBackground(Color.WHITE);
		
		add(subHeading3JLabel);
		subHeading3JLabel.setBounds(30, 385, 220, 20);
		subHeading3JLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(accountTypeJLabel);
		accountTypeJLabel.setBounds(50, 420, 110, 17);
		accountTypeJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(accountTypeJTextField);
		accountTypeJTextField.setBounds(170, 420, 200, 21);
		accountTypeJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		accountTypeJTextField.setEditable(false);
		accountTypeJTextField.setBackground(Color.WHITE);
		
		add(servicesJLabel);
		servicesJLabel.setBounds(500, 420, 80, 21);
		servicesJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(servicesJTextField);
		servicesJTextField.setBounds(580, 420, 450, 21);
		servicesJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		servicesJTextField.setEditable(false);
		servicesJTextField.setBackground(Color.WHITE);
		
		add(accountNoJLabel);
		accountNoJLabel.setBounds(50, 455, 140, 17);
		accountNoJLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(accountNoJTextField);
		accountNoJTextField.setBounds(190, 455, 200, 21);
		accountNoJTextField.setFont(new Font("Arial", Font.PLAIN, 17));
		accountNoJTextField.setEditable(false);
		accountNoJTextField.setBackground(Color.WHITE);
	
	    add(pinNoJLabel); 
	    pinNoJLabel.setBounds(580, 455, 60, 17);
		pinNoJLabel.setFont(new Font("Arial", Font.PLAIN, 17)); 
		add(pinNoJTextField);
		pinNoJTextField.setBounds(650, 455, 200, 21); 
		pinNoJTextField.setFont(new Font("Arial", Font.PLAIN, 17)); 
		pinNoJTextField.setEditable(false);
		pinNoJTextField.setBackground(Color.WHITE);
		
		add(enterPinJLabel);
		enterPinJLabel.setBounds(30, 500, 70, 20);
		enterPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(enterPinNoJTextField);
		enterPinNoJTextField.setBounds(105, 500, 80, 25);
		enterPinNoJTextField.setFont(new Font("Arial", Font.BOLD, 25));
		enterPinNoJTextField.setEchoChar('X');
		add(viewBalanceJButton);
		viewBalanceJButton.setBounds(190, 500, 150, 25);
		viewBalanceJButton.setFont(new Font("Arial", Font.PLAIN, 17));
		viewBalanceJButton.setBackground(Color.BLACK);
		viewBalanceJButton.setForeground(Color.WHITE);
		
		add(accountBalanceJLabel);
		accountBalanceJLabel.setBounds(790, 570, 180, 20);
		accountBalanceJLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		add(accountBalanceJTextField);
		accountBalanceJTextField.setBounds(750, 600, 250, 30);
		accountBalanceJTextField.setFont(new Font("Arial", Font.PLAIN, 27));
		accountBalanceJTextField.setEditable(false);
		accountBalanceJTextField.setBackground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(30, 640, 200, 35);
		backJButton.setFont(new Font("Arial", Font.PLAIN, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(new Color(200,240,250));

		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		viewDetialsJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				long accountID = Long.parseLong(enterAccountIDJTextField.getText());
				
					try {	
						Connection con = DBConnection.getCon();
						PreparedStatement ps1 = con.prepareStatement("SELECT * FROM CREATEACCOUNT1 WHERE ID=?");
						PreparedStatement ps2 = con.prepareStatement("SELECT * FROM CREATEACCOUNT2 WHERE ID=?");
						PreparedStatement ps3 = con.prepareStatement("SELECT * FROM CREATEACCOUNT3 WHERE ID=?");
				
						ps1.setLong(1, accountID);
						ResultSet rs1 = ps1.executeQuery();
						
						ps2.setLong(1, accountID);
						ResultSet rs2 = ps2.executeQuery();
						
						ps3.setLong(1, accountID);
						ResultSet rs3 = ps3.executeQuery();
						
						if (rs1.next() && rs2.next() && rs3.next())
						{
							idJTextField.setText((String)rs1.getString(1));
							nameJTextField.setText(rs1.getString(3));
							fathernameJTextField.setText(rs1.getString(4));
							dateOfBirthJTextField.setText(rs1.getString(5));
							monthOfBirthJTextField.setText(rs1.getString(6));
							yearOfBirthJTextField.setText(rs1.getString(7));
							genderJTextField.setText(rs1.getString(8));
							mobileNoJTextField.setText((String)rs1.getString(9));
							mailJTextField.setText(rs1.getString(10));
							maritalStatusJTextField.setText(rs1.getString(11));
							addressJTextField.setText(rs1.getString(12));
							cityJTextField.setText(rs1.getString(13));
							pinCodeJTextField.setText(rs1.getString(14));
							stateJTextField.setText(rs1.getString(15));
							
							religionJTextField.setText(rs2.getString(3));
						    categoryJTextField.setText(rs2.getString(4));
						    incomeJTextField.setText(rs2.getString(5));
						    educationJTextField.setText(rs2.getString(6));
						    occupationJTextField.setText(rs2.getString(7));
						    panNoJTextField.setText(rs2.getString(8));
						    adharNoJTextField.setText(rs2.getString(9));
						    seniorCitizenJTextField.setText(rs2.getString(10));
						    
						    servicesJTextField.setText(rs3.getString(5));
						    accountNoJTextField.setText((String)rs3.getString(2));
						    accountTypeJTextField.setText(rs3.getString(4));
						    pinNoJTextField.setText((String)rs3.getString(3));
						    
						}else {
							JOptionPane.showMessageDialog(ViewAccountBasedOnID.this, "Invalid Account Number"+"\n Please check the account number and re-enter it");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		
		viewBalanceJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				long pinnumber = Long.parseLong(enterPinNoJTextField.getText());
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from BANK where PINNO=?");
					ps.setLong(1, pinnumber);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next())
					{
						accountBalanceJTextField.setText((String)rs.getString(3)+"-/ RS");
					} else {
						JOptionPane.showMessageDialog(ViewAccountBasedOnID.this, "Invalid Pin Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) 
	{
		ViewAccountBasedOnID viewAccountBasedOnName = new ViewAccountBasedOnID();
		viewAccountBasedOnName.setVisible(true);
		viewAccountBasedOnName.setResizable(false);
	}
}
