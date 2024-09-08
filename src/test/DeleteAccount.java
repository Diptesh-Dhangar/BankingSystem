package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DeleteAccount extends JFrame
{
	JLabel headingJLabel = new JLabel("Delete Account");
	JLabel accountNumberJLabel = new JLabel("Account Number:");
	JLabel accountHolderNameJLabel = new JLabel("Account Holder Name:");
	
	JTextField accountNumberJTextField = new JTextField();
	JTextField accountHolderNameJTextField = new JTextField();
	
	JButton deleteJButton = new JButton("Delete");
	JButton cancelJButton = new JButton("Cancel");
	
	public DeleteAccount()
	{
		setSize(700, 400);
		setTitle("DSD BANK - Delete Account");
		setLayout(null);
		setLocation(430, 200);
		
		add(headingJLabel);
		headingJLabel.setBounds(250, 10, 180, 22);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(accountNumberJLabel);
		accountNumberJLabel.setBounds(50, 100, 230, 20);
		accountNumberJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(accountNumberJTextField);
		accountNumberJTextField.setBounds(330, 100, 300, 25);
		accountNumberJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(accountHolderNameJLabel);
		accountHolderNameJLabel.setBounds(50, 160, 230, 20);
		accountHolderNameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(accountHolderNameJTextField);
		accountHolderNameJTextField.setBounds(330, 160, 300, 25);
		accountHolderNameJTextField.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(cancelJButton);
		cancelJButton.setBounds(70, 260, 200, 35);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(deleteJButton);
		deleteJButton.setBounds(380, 260, 200, 35);
		deleteJButton.setFont(new Font("Arial", Font.BOLD, 20));
		deleteJButton.setBackground(Color.BLACK);
		deleteJButton.setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		cancelJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		deleteJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long accountNumber = Long.parseLong(accountNumberJTextField.getText());
				
				try {
					
					Connection con = DBConnection.getCon();
					PreparedStatement ps1 = con.prepareStatement("Delete from CREATEACCOUNT1 where ACCOUNT_NO=?");
					PreparedStatement ps2 = con.prepareStatement("Delete from CREATEACCOUNT2 where ACCOUNT_NO=?");
					PreparedStatement ps3 = con.prepareStatement("Delete from CREATEACCOUNT3 where ACCOUNT_NO=?");
					PreparedStatement ps4 = con.prepareStatement("Delete from LOGIN where ACCOUNT_NO=?");
					PreparedStatement ps5 = con.prepareStatement("Delete from BANK where ACCOUNT_NO=?");
					
					ps1.setLong(1, accountNumber);
					ps2.setLong(1, accountNumber);
					ps3.setLong(1, accountNumber);
					ps4.setLong(1, accountNumber);
					ps5.setLong(1, accountNumber);
					
					int i = ps1.executeUpdate();
					int j = ps2.executeUpdate();
					int k = ps3.executeUpdate();
					int l = ps4.executeUpdate();
					int m = ps5.executeUpdate();
					
					if (i==1 && j==1 && k==1 && l==1 && m==1)
					{
						JOptionPane.showMessageDialog(DeleteAccount.this, "Account Deleted Successfully");
						deleteJButton.setEnabled(false);
						accountNumberJTextField.setText("");
						accountHolderNameJTextField.setText("");
						
					} else {
						JOptionPane.showMessageDialog(DeleteAccount.this, "Account Deletion Failed");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
	public static void main(String[] args)
	{
		DeleteAccount deleteAccount = new DeleteAccount();
		deleteAccount.setVisible(true);
		deleteAccount.setResizable(false);
	}
	
	
	
}
