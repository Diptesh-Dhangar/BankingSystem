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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TransferMoney extends JFrame
{
	JLabel headingJLabel = new JLabel("Money Transfer");
	
	JLabel senderAccountNoJLabel = new JLabel("Sender A/C:");
	JLabel recieverAccountNoJLabel = new JLabel("Reciever A/C:");
	JLabel senderNameJLabel = new JLabel("Sender Name:");
	JLabel recieverNameJLabel = new JLabel("Reciever Name:");
	JLabel senderNameMINIJLabel = new JLabel("Enter name as per passbook");
	JLabel recieverNameMINIJLabel = new JLabel("Enter name as per passbook");
	JLabel AmountJLabel = new JLabel("Amount:");
	JLabel noteJLabel = new JLabel("Sender Name and Reciever Name is Optional");
	
	JTextField senderAccountNoJTextField = new JTextField();
	JTextField recieverAccountNoJTextField = new JTextField();
	JTextField senderNameJTextField = new JTextField();
	JTextField recieverNameJTextField = new JTextField();
	JTextField amountJTextField = new JTextField();
	
	JButton transferJButton = new JButton("TRANSFER");
	JButton cancelJButton = new JButton("CANCEL");
	
	
	public TransferMoney() 
	{
		setSize(700, 580);
		setTitle("Transfer Money");
		setLayout(null);
		setLocation(400, 80);
		
		add(headingJLabel);
		headingJLabel.setBounds(240, 10, 220, 28);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 27));
		
		add(senderAccountNoJLabel);
		senderAccountNoJLabel.setBounds(52, 100, 140, 21);
		senderAccountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(senderAccountNoJTextField);
		senderAccountNoJTextField.setBounds(300, 100, 300, 28);
		senderAccountNoJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(senderNameJLabel);
		senderNameJLabel.setBounds(52, 160, 140, 21);
		senderNameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(senderNameJTextField);
		senderNameJTextField.setBounds(300, 160, 300, 28);
		senderNameJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(senderNameMINIJLabel);
		senderNameMINIJLabel.setBounds(350,187,200,15);
		senderNameMINIJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		add(recieverAccountNoJLabel);
		recieverAccountNoJLabel.setBounds(52, 220, 140, 21);
		recieverAccountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(recieverAccountNoJTextField);
		recieverAccountNoJTextField.setBounds(300, 220, 300, 28);
		recieverAccountNoJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(recieverNameJLabel);
		recieverNameJLabel.setBounds(52, 280, 150, 21);
		recieverNameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(recieverNameJTextField);
		recieverNameJTextField.setBounds(300, 280, 300, 28);
		recieverNameJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(recieverNameMINIJLabel);
		recieverNameMINIJLabel.setBounds(350, 310, 200, 15);
		recieverNameMINIJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		add(AmountJLabel);
		AmountJLabel.setBounds(50, 340, 140, 21);
		AmountJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(amountJTextField);
		amountJTextField.setBounds(300, 340, 300, 28);
		amountJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(cancelJButton);
		cancelJButton.setBounds(80, 450, 200, 35);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(transferJButton);
		transferJButton.setBounds(380, 450, 200, 35);
		transferJButton.setFont(new Font("Arial", Font.BOLD, 20));
		transferJButton.setBackground(Color.BLACK);
		transferJButton.setForeground(Color.WHITE);
		
		add(noteJLabel);
		noteJLabel.setBounds(180, 509, 330, 15);
		noteJLabel.setFont(new Font("Arial", Font.BOLD, 15));
		noteJLabel.setForeground(Color.RED);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		
		cancelJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		transferJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long senderAC = Long.parseLong(senderAccountNoJTextField.getText());
				long recieverAC = Long.parseLong(recieverAccountNoJTextField.getText());
				float amount = Float.parseFloat(amountJTextField.getText());
				
				
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps1 = con.prepareStatement("Select * from BANK WHERE ACCOUNT_NO=? ");
					PreparedStatement ps2 = con.prepareStatement("Update BANK SET BALANCE=BALANCE+? WHERE ACCOUNT_NO=?");
					
					ps1.setLong(1, senderAC);
					ResultSet rs1 = ps1.executeQuery();
					
					if (rs1.next())
					{
						float senderBalance = rs1.getFloat(3);
						ps1.setLong(1, recieverAC);
						ResultSet rs2 = ps1.executeQuery();
						
						if (rs2.next())
						{
							if (amount<=senderBalance) 
							{
								ps2.setFloat(1, -amount);
								ps2.setLong(2, senderAC);
								
								int i = ps2.executeUpdate();
								
								ps2.setFloat(1, amount);
								ps2.setLong(2, recieverAC);
								
								int j = ps2.executeUpdate();
								
								if (i==1 && j==1) 
								{
									JOptionPane.showMessageDialog(TransferMoney.this, "Transaction Successfull");
									    senderAccountNoJTextField.setText("");
									    senderNameJTextField.setText("");
									    recieverAccountNoJTextField.setText("");
									    recieverNameJTextField.setText("");
									    amountJTextField.setText("");
								} else {
									JOptionPane.showMessageDialog(TransferMoney.this, "Sorry!!!"+"\nTransaction Failed");
								}
							} else {
								JOptionPane.showMessageDialog(TransferMoney.this, "Insufficient Balance");
							}
						} else {
							JOptionPane.showMessageDialog(TransferMoney.this, "Invalid Reciever Account Number");
						}	
					} else {
							JOptionPane.showMessageDialog(TransferMoney.this, "Invalid Sender Account Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		
		TransferMoney transferMoney = new TransferMoney();
		transferMoney.setVisible(true);
		transferMoney.setResizable(false);
	}
}
