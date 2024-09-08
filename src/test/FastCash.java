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

@SuppressWarnings("serial")
public class FastCash extends JFrame
{
	JLabel headingJLabel = new JLabel("Please Select Your Amount");
	
	JLabel enterPinJLabel = new JLabel("Enter Pin:"); 
	JPasswordField enterPinJPasswordField = new JPasswordField();
	
	  JButton hundredRSJButton = new JButton("100");
	  JButton twoHundredRSlJButton = new JButton("200");
	  JButton fiveHundredRSJButton = new JButton("500");
	  JButton thousandRSJButton = new JButton("1,000");
	  JButton threeThousandRSJButton = new JButton("3,000");
	  JButton fiveThousandJButton = new JButton("5,000");
	  JButton tenThousandButton = new JButton("10,000");
	  JButton fifteenThounsadJButton = new JButton("15,000");
	  
	  JButton cancelJButton = new JButton("CANCEL");

	public FastCash() 
	{
		setSize(750, 680);
		setTitle("TRANSACTION");
		setLayout(null);
		setLocation(400, 80);
		
		add(enterPinJLabel);
		enterPinJLabel.setBounds(530, 10, 100, 20);
		enterPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(enterPinJPasswordField);
		enterPinJPasswordField.setBounds(630, 10, 75, 25);
		enterPinJPasswordField.setFont(new Font("Arial", Font.BOLD, 25));
		enterPinJPasswordField.setEchoChar('X');
		
		add(headingJLabel);
		headingJLabel.setBounds(170, 60, 470, 25);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		add(hundredRSJButton);
		hundredRSJButton.setBounds(40, 150, 270, 40);
		hundredRSJButton.setFont(new Font("Arial", Font.BOLD, 20));
		hundredRSJButton.setBackground(Color.BLACK);
		hundredRSJButton.setForeground(Color.WHITE);
		
		add(twoHundredRSlJButton);
		twoHundredRSlJButton.setBounds(420, 150, 270, 40);
		twoHundredRSlJButton.setFont(new Font("Arial", Font.BOLD, 20));
		twoHundredRSlJButton.setBackground(Color.BLACK);
		twoHundredRSlJButton.setForeground(Color.WHITE);
		
		add(fiveHundredRSJButton);
		fiveHundredRSJButton.setBounds(40, 250, 270, 40);
		fiveHundredRSJButton.setFont(new Font("Arial", Font.BOLD, 20));
		fiveHundredRSJButton.setBackground(Color.BLACK);
		fiveHundredRSJButton.setForeground(Color.WHITE);
		
		add(thousandRSJButton);
		thousandRSJButton.setBounds(420, 250, 270, 40);
		thousandRSJButton.setFont(new Font("Arial", Font.BOLD, 20));
		thousandRSJButton.setBackground(Color.BLACK);
		thousandRSJButton.setForeground(Color.WHITE);
		
		add(threeThousandRSJButton);
		threeThousandRSJButton.setBounds(40, 350, 270, 40);
		threeThousandRSJButton.setFont(new Font("Arial",Font.BOLD, 20));
		threeThousandRSJButton.setBackground(Color.BLACK);
		threeThousandRSJButton.setForeground(Color.WHITE);
		
		add(fiveThousandJButton);
		fiveThousandJButton.setBounds(420, 350, 270, 40);
		fiveThousandJButton.setFont(new Font("Arial", Font.BOLD, 20));
		fiveThousandJButton.setBackground(Color.BLACK);
		fiveThousandJButton.setForeground(Color.WHITE);		
		
		add(tenThousandButton);
		tenThousandButton.setBounds(40, 450, 270, 40);
		tenThousandButton.setFont(new Font("Arial", Font.BOLD, 20));
		tenThousandButton.setBackground(Color.BLACK);
		tenThousandButton.setForeground(Color.WHITE);
		
		add(fifteenThounsadJButton);
		fifteenThounsadJButton.setBounds(420, 450, 270, 40);
		fifteenThounsadJButton.setFont(new Font("Arial", Font.BOLD, 20));
		fifteenThounsadJButton.setBackground(Color.BLACK);
		fifteenThounsadJButton.setForeground(Color.WHITE);
		
		add(cancelJButton);
		cancelJButton.setBounds(230, 560, 270, 40);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(Color.WHITE);
		
		cancelJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ATMLoginSuccess().setVisible(true);
				setVisible(false);
			}
		});
		
		
		hundredRSJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{ 
				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				try {
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from BANK where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-100 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						
						if (amount>100) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1) 
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n100-/ Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		twoHundredRSlJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
		
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from BANK where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-200 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					
					if (rs1.next()) 
					{
						float amount = rs1.getFloat(3);
						if (amount>200)
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n 200-/Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		fiveHundredRSJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				try {
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-500 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						if (amount>500) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n500-/Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		thousandRSJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				

				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
					
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-1000 where PINNO=?");
						
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						if (amount>1000) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n1000-/Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}	
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		threeThousandRSJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				

				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
					
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-3000 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next()) 
					{
						float amount = rs1.getFloat(3);
						if (amount>3000) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n3000-/Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}	
			}
		});
		
		fiveThousandJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				

				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
					
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-5000 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						if (amount>5000) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n5000-/ Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
						
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		tenThousandButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				

				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
					
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-10000 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						if (amount>10000) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n10000-/ Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		fifteenThounsadJButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				

				long pinNo = Long.parseLong(enterPinJPasswordField.getText());
				
				try {
					
					Connection con1 = DBConnection.getCon();
					PreparedStatement ps1 = con1.prepareStatement("Select * from bank where PINNO=?");
					PreparedStatement ps2 = con1.prepareStatement("Update bank set BALANCE=BALANCE-15000 where PINNO=?");
					
					ps1.setLong(1, pinNo);
					ResultSet rs1 = ps1.executeQuery();
					if (rs1.next())
					{
						float amount = rs1.getFloat(3);
						if (amount>15000) 
						{
							ps2.setLong(1, pinNo);
							int i = ps2.executeUpdate();
							
							if (i==1)
							{
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Successfull"+"\n15000-/ Rs Debited Successfully");
							} else {
								JOptionPane.showMessageDialog(FastCash.this, "Transaction Failed");
							}
						} else {
							JOptionPane.showMessageDialog(FastCash.this, "Insufficient Balance");
						}
					} else {
						JOptionPane.showMessageDialog(FastCash.this, "Invalid Pin Number");
					}
						
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
	public static void main(String[] args) 
	{
		FastCash fasrCash = new FastCash();
		fasrCash.setVisible(true);
		fasrCash.setResizable(false);
	}
}
