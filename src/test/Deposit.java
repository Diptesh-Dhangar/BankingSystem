package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Deposit  extends JFrame
{
	   JLabel headingJLabel = new JLabel("DEPOSIT MONEY");
	   JLabel enterPinJLabel = new JLabel("Pin No:");
	   JLabel enterDepositAmountJLabel = new JLabel("Amount");
	   
	   JPasswordField  enterpinJPasswordField = new JPasswordField();
	   JTextField enterAmountJTextField  = new JTextField();
	   
	   JButton depositeJButton = new JButton("DEPOSIT");
	   JButton cancelJButton = new JButton("CANCEL"); 
	   
	public Deposit() 
	{
		 setSize(600, 400);
		 setTitle("Deposite Money");
		 setLayout(null);
		 setLocation(450, 150);
		
		 add(enterPinJLabel);
		 enterPinJLabel.setBounds(425, 20, 70, 20);
		 enterPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		 
		 add(enterpinJPasswordField);
		 enterpinJPasswordField.setBounds(500, 20, 70, 25);
		 enterpinJPasswordField.setFont(new Font("Arial", Font.BOLD,22));
		 enterpinJPasswordField.setEchoChar('X');
		 
		 add(headingJLabel);
		 headingJLabel.setBounds(190, 70, 250, 30);
		 headingJLabel.setFont(new Font("Arial", Font.BOLD, 27));
		 
		 add(enterDepositAmountJLabel);
		 enterDepositAmountJLabel.setBounds(250, 140, 100, 25);
		 enterDepositAmountJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		 
		 add(enterAmountJTextField);
		 enterAmountJTextField.setBounds(175, 180, 250, 27);
		 enterAmountJTextField.setFont(new Font("Arial", Font.BOLD, 22));
		 
		 add(depositeJButton);
		 depositeJButton.setBounds(320, 280, 200, 35);
		 depositeJButton.setFont(new Font("Arial", Font.BOLD, 20));
		 depositeJButton.setBackground(Color.BLACK);
		 depositeJButton.setForeground(Color.WHITE);
		 
		 add(cancelJButton);
		 cancelJButton.setBounds(60, 280, 200, 35);
		 cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		 cancelJButton.setBackground(Color.BLACK);
		 cancelJButton.setForeground(Color.WHITE);
		  
		 getContentPane().setBackground(Color.WHITE);
		
		 System.out.println();
		 depositeJButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("deprecation")
					long pinNo = Long.parseLong(enterpinJPasswordField.getText());
					float amount = Float.parseFloat(enterAmountJTextField.getText());
					
					try {
						Connection con = DBConnection.getCon();
						PreparedStatement ps = con.prepareStatement("Update Bank set BALANCE=BALANCE+? where PINNO=?");
						
						ps.setFloat(1, amount);
						ps.setLong(2, pinNo);
						
						int i = ps.executeUpdate();
						
						if (i==1) 
						{
							JOptionPane.showMessageDialog(Deposit.this, "Amount Deposited Successfully"+"\n"+amount+"-/ Deposited Successfully");
							enterpinJPasswordField.setText("");
					
						       Date date = new Date(); 
							   SimpleDateFormat Formatter =new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						  	   String datAndTimeString = Formatter.format(date);
						  	   
							 System.out.println(datAndTimeString);
							try {
								float debitedAmt = 0;
								Connection con1 = DBConnection.getCon();
								PreparedStatement psLogin = con1.prepareStatement("Select * from LOGIN where PIN=?");
								PreparedStatement psBank = con1.prepareStatement("Select * from BANK where PINNO=?");
								PreparedStatement ps1 = con1.prepareStatement("Insert into ESTATEMENT values(?,?,?,?,?,?)");
								
								psLogin.setLong(1, pinNo);
								
								ResultSet rs1 = psLogin.executeQuery();
								
								if (rs1.next()) {
									long IdNo = rs1.getLong(1);
									long acNo = rs1.getLong(2);
									
									psBank.setLong(1, pinNo);
									
									ResultSet rs2 =psBank.executeQuery();
									
									if (rs2.next())
									{
										float amt = rs2.getFloat(3);
										
										ps1.setString(1, datAndTimeString);
										ps1.setLong(2, IdNo);
										ps1.setLong(3, acNo);
										ps1.setFloat(4, debitedAmt);
										ps1.setFloat(5, amount);
										ps1.setFloat(6, amt);
										
										int k = ps1.executeUpdate();
										
										if (k==1)
										{
											System.out.println("Data Inserted Successfully");
										}	
									}
								}	
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							
							new ATMLoginSuccess().setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(Deposit.this, "Amount Deposited Fail");
						}	
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}); 
		 
		 cancelJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ATMLoginSuccess().setVisible(true);
				setVisible(false);
			}
		});
		
	}
	public static void main(String[] args) 
	{
		Deposit deposit = new Deposit();
		deposit.setVisible(true);
		deposit.setResizable(false);
	}
}
