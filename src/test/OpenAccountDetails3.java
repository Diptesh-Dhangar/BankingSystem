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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OpenAccountDetails3 extends JFrame
{	
	Random rdm = new Random();
	long first8 = (rdm.nextLong() % 9000000L) + 772100000000L;
	long bigPin = Math.abs(first8);

	long first4 = (rdm.nextLong() % 9000L) + 1000L;
	long smallPin = Math.abs(first4);
	
	long visibleNumber = 7721;
	
	JLabel applicatinFormNoJLabel = new JLabel("Form No:");
	JTextField applicatioiJTextField = new JTextField();
	
	JLabel headingJLabel = new JLabel("Page 3: Account Details");
	
	JLabel accountTypeJLabel = new JLabel("Account Type:");
	JLabel accountNumberJLabel = new JLabel("Account Number:");
	JLabel pinJLabel = new JLabel("PIN:");
	JLabel servicesRequiredJLabel = new JLabel("Services Required:");
	
	JLabel accountNumberSubJLabel  = new JLabel("(Your 16 digit Cand Number)");
	JLabel pinsubJLabel = new JLabel("(4-digit password)");
	
	JLabel accountnumberJLabel2  = new JLabel(visibleNumber+"-XXXX-XXXX-XXXX");
	JLabel accountnumberSubJLabel2 = new JLabel("(It would apper on ATM Card Cheque Book and Statements)");
	
	JLabel pinJLabel2 = new JLabel("XXXX");
	
	ButtonGroup redioButtonGroup = new ButtonGroup();
	JRadioButton savingAccountJRadioButton = new JRadioButton("Saving Account");
	JRadioButton currentAccountJRadioButton = new JRadioButton("Current Account");
	JRadioButton fixedDepositeAccountJRadioButton = new JRadioButton("Fixed Deposite Account");
	JRadioButton recurringDepositeJRadioButton = new JRadioButton("Recurring Deposite Account");
	
	JCheckBox atmcardCheckBox = new JCheckBox("ATM CARD");
	JCheckBox mobileBankingCheckBox = new JCheckBox("Mobile Banking");
	JCheckBox chequeBookCheckBox = new JCheckBox("Cheque Book");
	JCheckBox internetBankingCheckBox = new JCheckBox("Internet Banking");
	JCheckBox emailAlertCheckBox = new JCheckBox("EMAIL Alerts");
	JCheckBox estatementCheckBox = new JCheckBox("E-Statement");
	JCheckBox lastCheckBox  = new JCheckBox("I hereby declares that above entered details to the best of my knowledge");
	
	JButton submitJButton = new JButton("SUBMIT");
    JButton cancelButton = new JButton("CANCEL");
	
	public OpenAccountDetails3() 
	{
		setSize(700, 780);
		setTitle("NEW ACCOUNT APPLICTION FORM - PAGE 3");
		setLayout(null);
		setLocation(400, 20);
		
		add(applicatinFormNoJLabel);
		applicatinFormNoJLabel.setBounds(530, 10, 77, 20);
		applicatinFormNoJLabel.setFont(new Font("Arial", Font.BOLD, 17));
		add(applicatioiJTextField);
		applicatioiJTextField.setBounds(610, 10, 55, 25);
		applicatioiJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(headingJLabel);
		headingJLabel.setBounds(210, 40, 280, 25);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 23));
		
		add(accountTypeJLabel);
		accountTypeJLabel.setBounds(80, 100, 200, 25);
		accountTypeJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		redioButtonGroup.add(savingAccountJRadioButton);
		redioButtonGroup.add(currentAccountJRadioButton);
		redioButtonGroup.add(fixedDepositeAccountJRadioButton);
		redioButtonGroup.add(recurringDepositeJRadioButton);
		
		add(savingAccountJRadioButton);
		savingAccountJRadioButton.setBounds(80, 140, 200, 20);
		savingAccountJRadioButton.setFont(new Font("Arial", Font.PLAIN, 17));
		savingAccountJRadioButton.setBackground(Color.WHITE);
		add(fixedDepositeAccountJRadioButton);
		fixedDepositeAccountJRadioButton.setBounds(330, 140, 250, 20);
		fixedDepositeAccountJRadioButton.setFont(new Font("Arial", Font.PLAIN, 17));
		fixedDepositeAccountJRadioButton.setBackground(Color.WHITE);
		add(currentAccountJRadioButton);
		currentAccountJRadioButton.setBounds(80, 180, 200, 20);
		currentAccountJRadioButton.setFont(new Font("Arial", Font.PLAIN, 17));
		currentAccountJRadioButton.setBackground(Color.WHITE);
		add(recurringDepositeJRadioButton);
		recurringDepositeJRadioButton.setBounds(330, 180, 250, 20);
		recurringDepositeJRadioButton.setFont(new Font("Arial", Font.PLAIN, 17));
		recurringDepositeJRadioButton.setBackground(Color.WHITE);
		
		add(accountNumberJLabel);
		accountNumberJLabel.setBounds(80, 250, 200, 25);
		accountNumberJLabel.setFont(new Font("Arail", Font.BOLD, 20));
		add(accountNumberSubJLabel);
		accountNumberSubJLabel.setBounds(80, 278, 250, 13);
		accountNumberSubJLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		add(accountnumberJLabel2);
		accountnumberJLabel2.setBounds(310, 250, 320, 27);
		accountnumberJLabel2.setFont(new Font("Arail", Font.BOLD, 27));
		add(accountnumberSubJLabel2);
		accountnumberSubJLabel2.setBounds(310, 278, 400, 13);
		accountnumberSubJLabel2.setFont(new Font("Arail", Font.PLAIN, 13));
		
		add(pinJLabel);
		pinJLabel.setBounds(80, 330, 200, 25);
		pinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(pinsubJLabel);
		pinsubJLabel.setBounds(80, 358, 200, 15);
		pinsubJLabel.setFont(new Font("Arail", Font.PLAIN, 13));
		add(pinJLabel2);
		pinJLabel2.setBounds(310, 330, 300, 27);
		pinJLabel2.setFont(new Font("Arial", Font.BOLD, 27));
		
		add(servicesRequiredJLabel);
		servicesRequiredJLabel.setBounds(80, 410, 200, 25);
		servicesRequiredJLabel.setFont(new Font("Arail", Font.BOLD, 20));
		
		add(atmcardCheckBox);
		atmcardCheckBox.setBounds(80, 460, 200, 20);
		atmcardCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		atmcardCheckBox.setBackground(Color.WHITE);
		add(internetBankingCheckBox);
		internetBankingCheckBox.setBounds(310, 460, 200, 20);
		internetBankingCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		internetBankingCheckBox.setBackground(Color.WHITE);
		add(mobileBankingCheckBox);
		mobileBankingCheckBox.setBounds(80, 500, 200, 20);
		mobileBankingCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		mobileBankingCheckBox.setBackground(Color.WHITE);
		add(emailAlertCheckBox);
		emailAlertCheckBox.setBounds(310, 500, 200, 20);
		emailAlertCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		emailAlertCheckBox.setBackground(Color.WHITE);
		add(chequeBookCheckBox);
		chequeBookCheckBox.setBounds(80, 540, 200, 20);
		chequeBookCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		chequeBookCheckBox.setBackground(Color.WHITE);
		add(estatementCheckBox);
		estatementCheckBox.setBounds(310, 540, 200, 30);
		estatementCheckBox.setFont(new Font("Arial", Font.PLAIN, 17));
		estatementCheckBox.setBackground(Color.WHITE);
		
		add(lastCheckBox);
		lastCheckBox.setBounds(50, 610, 560, 20);
		lastCheckBox.setFont(new Font("Arial", Font.BOLD, 15));
		lastCheckBox.setBackground(Color.WHITE);
		
		add(cancelButton);
		cancelButton.setBounds(100, 660, 200, 40);
		cancelButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		
		add(submitJButton);
		submitJButton.setBounds(380, 660, 200, 40);
		submitJButton.setFont(new Font("Arial", Font.BOLD, 20));
		submitJButton.setBackground(Color.BLACK);
		submitJButton.setForeground(Color.WHITE);
	
		getContentPane().setBackground(Color.WHITE);
		
		submitJButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				long Id = Long.parseLong(applicatioiJTextField.getText());
			    
				String accountType = "";
			    
			    if (savingAccountJRadioButton.isSelected())
			    {
					accountType = "Saving Account";
				} else if (fixedDepositeAccountJRadioButton.isSelected())
				{
					accountType = "Fixed Deposite Account";
				} else if (currentAccountJRadioButton.isSelected())
				{
					accountType = "Current Account";
				} else if (recurringDepositeJRadioButton.isSelected())
				{
					accountType = "Recurring Deposite Account";
				} else {
					accountType = "";
				}
			    
			    long accountNumber = bigPin;
			    long pinNo = smallPin;
			    
			    String b = "";
			    if (atmcardCheckBox.isSelected())
			    {
					b = b+"ATM CARD";
				} 
			    if (internetBankingCheckBox.isSelected())
				{
					b = b+"-Internet Banking";
				} 
			    if (mobileBankingCheckBox.isSelected()) 
				{
					b = b+"-Mobile Banking";
				}
			    if (emailAlertCheckBox.isSelected())
				{
					b = b+"-Email Alerts";
				}
			    if (chequeBookCheckBox.isSelected())
				{
					b = b+"-Cheque Book";
				} 
			    if (estatementCheckBox.isSelected()) 
				{
					b = b+"-E-Statement";
				} 
					
			    float balance = 0;
			    
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps1 = con.prepareStatement("Insert into CREATEACCOUNT3 values(?,?,?,?,?)");
					PreparedStatement ps2 = con.prepareStatement("Update CREATEACCOUNT1 set ACCOUNT_NO=? where ID=?");
					PreparedStatement ps3 = con.prepareStatement("Update CREATEACCOUNT2 set ACCOUNT_NO=? where ID=?");
					PreparedStatement ps4 = con.prepareStatement("Insert into LOGIN values(?,?,?)");
					PreparedStatement ps5 = con.prepareStatement("Insert into BANK values(?,?,?)");
					
					ps1.setLong(1, Id);
					ps1.setLong(2, accountNumber);
					ps1.setLong(3, pinNo);
					ps1.setString(4,accountType);
					ps1.setString(5, b);
					
					ps2.setLong(1,accountNumber);
					ps2.setLong(2,Id);
					
					ps3.setLong(1,accountNumber);
					ps3.setLong(2,Id);
					
					ps4.setLong(1, Id);
					ps4.setLong(2, accountNumber);
					ps4.setLong(3, pinNo);
					
					ps5.setLong(1, accountNumber);
					ps5.setLong(2, pinNo);
					ps5.setFloat(3, balance);
					
					
					int i = ps1.executeUpdate();
					int j = ps2.executeUpdate();
					int k = ps3.executeUpdate();
					int a = ps4.executeUpdate();
					int c = ps5.executeUpdate();
				
					if (i==1 && j==1 && k==1 && a==1 && c==1 )
					{
						JOptionPane.showMessageDialog(OpenAccountDetails3.this, "Account Opened Successfully"+"\n\n Account No:"+bigPin+"\n Pin No:"+smallPin);
						new FirstDeposit().setVisible(true);
						setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(OpenAccountDetails3.this, "Unable to OPen the Account"+"\nPlease check the detials on this page");
					}
					
				} catch (Exception e2)
				{
					e2.printStackTrace();
				}
			}
		});
		
		System.out.println(first8);
		
	
	 	
	}
	public static void main(String[] args) 
	{
		OpenAccountDetails3 openAccountDetails3 = new OpenAccountDetails3();
		openAccountDetails3.setVisible(true);
		openAccountDetails3.setResizable(false);
		
	}
}
