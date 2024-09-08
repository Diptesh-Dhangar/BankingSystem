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
public class LoanLogin extends JFrame
{
	JLabel headingJLabel = new JLabel("Loan Section");
	JLabel accountNoJLabel = new JLabel("Account No:");
	JLabel AccountHolderJLabel = new JLabel("Account Holder:");
	JLabel pinNoJLabel = new JLabel("Pin No:");
	
	JTextField accountNumberJTextField = new JTextField();
	JTextField accountHolderJTextField = new JTextField();
	JPasswordField pinNoJPasswordField = new JPasswordField();
	
	JButton verifynameJButton = new JButton("Verify");
	JButton verifyPinNoJButton = new JButton("Verify");
	JButton loginJButton = new JButton("Login");
	JButton cancelJButton = new JButton("Cancel");
	
	public LoanLogin() 
	{
		setSize(800, 500);
		setTitle("DSD Bank - Loan Section");
		setLayout(null);
		setLocation(400, 100);
		
		add(headingJLabel);
		headingJLabel.setBounds(320, 10, 160, 20);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(accountNoJLabel);
		accountNoJLabel.setBounds(70, 100, 200, 20);
		accountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(accountNumberJTextField);
		accountNumberJTextField.setBounds(300, 100, 300, 25);
		accountNumberJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(AccountHolderJLabel);
		AccountHolderJLabel.setBounds(70, 150, 200, 20);
		AccountHolderJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(accountHolderJTextField);
		accountHolderJTextField.setBounds(300, 150, 300, 25);
		accountHolderJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(pinNoJLabel);
		pinNoJLabel.setBounds(70, 200, 200, 20);
		pinNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(pinNoJPasswordField);
		pinNoJPasswordField.setBounds(300, 200, 300, 25);
		pinNoJPasswordField.setFont(new Font("Arial", Font.BOLD, 24));
		pinNoJPasswordField.setEchoChar('X');
		
		add(verifynameJButton);
		verifynameJButton.setBounds(630, 150, 130, 25);
		verifynameJButton.setFont(new Font("Arial", Font.PLAIN, 16));
		verifynameJButton.setBackground(Color.BLACK);
		verifynameJButton.setForeground(Color.WHITE);
		
		add(verifyPinNoJButton);
		verifyPinNoJButton.setBounds(630, 200, 130, 25);
		verifyPinNoJButton.setFont(new Font("Arial", Font.PLAIN, 16));
		verifyPinNoJButton.setBackground(Color.BLACK);
		verifyPinNoJButton.setForeground(Color.WHITE);
		
		add(cancelJButton);
		cancelJButton.setBounds(100, 300, 200, 35);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(loginJButton);
		loginJButton.setBounds(500, 300, 200, 35);
		loginJButton.setFont(new Font("Arial", Font.BOLD, 20));
		loginJButton.setBackground(Color.BLACK);
		loginJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(Color.WHITE);
		
		verifynameJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					long acNO = Long.parseLong(accountNumberJTextField.getText());
					String holder = accountHolderJTextField.getText();
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from CREATEACCOUNT1 where ACCOUNT_NO=?");
					ps.setLong(1, acNO);
					
					ResultSet rs = ps.executeQuery();
					if (rs.next())
					{
						String acHolder = rs.getString(3);
						if (holder.equals(acHolder))
						{
							verifynameJButton.setText("Verified");
							verifynameJButton.setEnabled(false);
						    verifynameJButton.setBackground(Color.GREEN);
						    verifynameJButton.setForeground(Color.WHITE);
							accountHolderJTextField.setEditable(false);	
						} else {
							JOptionPane.showMessageDialog(LoanLogin.this, "Please Correct Account Holder Name");	
						}
					} else {
						JOptionPane.showMessageDialog(LoanLogin.this, "Invalid Acccount Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		verifyPinNoJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					long acNO = Long.parseLong(accountNumberJTextField.getText());
					long  pinNo = Long.parseLong(pinNoJPasswordField.getText());
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from CREATEACCOUNT3 where ACCOUNT_NO=?");
					ps.setLong(1, acNO);
					
					ResultSet rs = ps.executeQuery();
					if (rs.next())
					{
						long pinNOO = rs.getLong(3);
						if (pinNo==pinNOO)
						{
							verifyPinNoJButton.setText("Verified");
							verifyPinNoJButton.setBackground(Color.GREEN);
							verifyPinNoJButton.setForeground(Color.BLACK);
							verifyPinNoJButton.setEnabled(false);
							pinNoJPasswordField.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(LoanLogin.this, "Enter the Correct Pin");
						}
					} else 
					{
						JOptionPane.showMessageDialog(LoanLogin.this, "Invalid Acccount Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		loginJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
						String verifyName	= verifynameJButton.getText();
						String verifyPin = verifyPinNoJButton.getText();
					if (verifyName.equals("Verified") && verifyPin.equals("Verified"))
					{
						JOptionPane.showMessageDialog(LoanLogin.this, "Login Successfull");
						new LoanLoginSuccessfull().setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(LoanLogin.this, "Login Failed");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		cancelJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);				
			}
		});
		
	}
	public static void main(String[] args)
	{
		LoanLogin loanLogin = new LoanLogin();
		loanLogin.setVisible(true);
		loanLogin.setResizable(false);
	}
}
