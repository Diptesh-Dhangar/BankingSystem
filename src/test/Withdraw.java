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
public class Withdraw extends JFrame
{
	 JLabel headingJLabel = new JLabel("WITHDRAW MONEY");
	   JLabel enterPinJLabel = new JLabel("Pin No:");
	   JLabel enterAmountJLabel = new JLabel("Amount");
	   JPasswordField  enterpinJPasswordField = new JPasswordField();
	   JTextField enterAmountJTextField  = new JTextField();
	   
	   JButton withdrawJButton = new JButton("WITHDRAW");
	   JButton cancelJButton = new JButton("CANCEL");
	   
  	 public Withdraw() 
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
			 headingJLabel.setBounds(160, 70, 270, 30);
			 headingJLabel.setFont(new Font("Arial", Font.BOLD, 27));
			 
			 add(enterAmountJLabel);
			 enterAmountJLabel.setBounds(250, 140, 100, 25);
			 enterAmountJLabel.setFont(new Font("Arial", Font.BOLD, 25));
			 
			 add(enterAmountJTextField);
			 enterAmountJTextField.setBounds(175, 180, 250, 27);
			 enterAmountJTextField.setFont(new Font("Arial", Font.BOLD, 22));
			 
			 add(withdrawJButton);
			 withdrawJButton.setBounds(320, 280, 200, 35);
			 withdrawJButton.setFont(new Font("Arial", Font.BOLD, 20));
			 withdrawJButton.setBackground(Color.BLACK);
			 withdrawJButton.setForeground(Color.WHITE);
			 
			 add(cancelJButton);
			 cancelJButton.setBounds(60, 280, 200, 35);
			 cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
			 cancelJButton.setBackground(Color.BLACK);
			 cancelJButton.setForeground(Color.WHITE);
			  
			 getContentPane().setBackground(Color.WHITE);
			 
			 withdrawJButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					@SuppressWarnings("deprecation")
					long pinNo = Long.parseLong(enterpinJPasswordField.getText());
					float amount = Float.parseFloat(enterAmountJTextField.getText());
					
					try {
						Connection con = DBConnection.getCon();
						PreparedStatement ps1 = con.prepareStatement("Select * from bank where PINNO=?");
						PreparedStatement ps2 = con.prepareStatement("Update bank set BALANCE=BALANCE-? where PINNO=?");
						
						ps1.setLong(1, pinNo);
						
						ResultSet rs = ps1.executeQuery();
						
						if (rs.next())
						{
							float currentAmount = rs.getFloat(3);
							if (amount<currentAmount) 
							{
								if (amount<10001)
								{
									ps2.setFloat(1, amount);
									ps2.setLong(2, pinNo);
									
									int i = ps2.executeUpdate();
									
									if (i==1)
									{
										JOptionPane.showMessageDialog(Withdraw.this,amount+" Rs Debited Successfully");
										enterAmountJTextField.setText("");
										enterpinJPasswordField.setText("");
										
										 Date date = new Date();
										 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss"); 
								    	 String datAndTimeString = simpleDateFormat.format(date);
										
										try {
											float creditedAmmount = 0;
											Connection con1 = DBConnection.getCon();
											PreparedStatement psLogin = con1.prepareStatement("Select * from LOGIN where PIN=?");
											PreparedStatement psBank = con1.prepareStatement("Select * from BANK where PINNO=?");
											PreparedStatement ps3 = con1.prepareStatement("Insert into ESTATEMENT values(?,?,?,?,?,?)"); 
											
											psLogin.setLong(1, pinNo);
											ResultSet rsLogin = psLogin.executeQuery();
											
											if (rsLogin.next())
											{
												long Id = rsLogin.getLong(1);
												long acNo = rsLogin.getLong(2);
												
												psBank.setLong(1, pinNo);
												ResultSet rsBank = psBank.executeQuery();
					
												if (rsBank.next())
												{
													float updatedBalance = rsBank.getFloat(3);
													
													ps3.setString(1, datAndTimeString);
													ps3.setLong(2, Id);
													ps3.setLong(3, acNo);
													ps3.setFloat(4, amount);
													ps3.setFloat(5, creditedAmmount);
													ps3.setFloat(6, updatedBalance);
													
													int k = ps3.executeUpdate();
													
													if (k==1)
													{
														System.out.println("Data Inserted Successfully Into Estatement");
													}
												}
											}
										} catch (Exception e2) {
											e2.printStackTrace();
										}
										
										new ATMLoginSuccess().setVisible(true);
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(Withdraw.this,"OOPS!!!"+"\n Transaction Failed");
									}
								} else {
									JOptionPane.showMessageDialog(Withdraw.this, "One Time limit is up to 10,000 Only");
								}
							} else {
								JOptionPane.showMessageDialog(Withdraw.this, "Insufficient Balance");
							}
						}
						else {
							JOptionPane.showMessageDialog(Withdraw.this, "Invalid Pin Number"+"\nRe-Enter Pin Number");
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
		   Withdraw withdraw = new Withdraw();
		   withdraw.setVisible(true);
		   withdraw.setResizable(false);
	   }
}
