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
public class ATMHome extends JFrame
{
	JLabel headingJLabel  = new JLabel("WELCOME TO ATM");
	JLabel cardNoJLabel = new JLabel("Account No :");
	JLabel pinNoJLabel = new JLabel("Pin :");
	JLabel warningNoteJLabel = new JLabel("If you didn't have an account then only click on OPEN ACCOUNT button.");
	
	JTextField cardNoJTextField = new JTextField();
	JPasswordField pinNoJTextField = new JPasswordField();
	
	JButton clearJButton = new JButton("CLEAR");
	JButton proceedJButton = new JButton("PROCEED");
	JButton openAccountJButton = new JButton("OPEN ACCOUNT");
	JButton backtoHomeJButton  = new JButton("BACK TO HOME PAGE");
	
	public ATMHome() 
	{
		setSize(600, 600);
		setTitle("Automated Teller Machine");
		setLayout(null);
		setLocation(450, 80);
		
		add(headingJLabel);
		headingJLabel.setBounds(150, 40, 300, 25);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		add(cardNoJLabel);
		cardNoJLabel.setBounds(70, 170, 145, 20);
		cardNoJLabel.setFont(new Font("Arial", Font.ITALIC, 25));
		add(cardNoJTextField);
		cardNoJTextField.setBounds(240,170, 270, 30);
		cardNoJTextField.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(pinNoJLabel);
		pinNoJLabel.setBounds(70, 240, 120, 20);
		pinNoJLabel.setFont(new Font("Arial", Font.ITALIC, 25));
		add(pinNoJTextField);
		pinNoJTextField.setBounds(240, 240, 270, 30);
		pinNoJTextField.setFont(new Font("Arial", Font.BOLD, 25));
	   pinNoJTextField.setEchoChar('X');
		
		add(proceedJButton);
		proceedJButton.setBounds(240, 320, 130, 30);
		proceedJButton.setFont(new Font("Arial", Font.BOLD, 17));
		proceedJButton.setBackground(Color.BLACK);
		proceedJButton.setForeground(Color.WHITE);
		
		add(clearJButton);
		clearJButton.setBounds(380, 320, 130, 30);
		clearJButton.setFont(new Font("Arial", Font.BOLD, 17));
		clearJButton.setBackground(Color.BLACK);
		clearJButton.setForeground(Color.WHITE);
		
		add(openAccountJButton);
		openAccountJButton.setBounds(240, 370, 270, 30);
		openAccountJButton.setFont(new Font("Arial", Font.BOLD, 20));
		openAccountJButton.setBackground(Color.BLACK);
		openAccountJButton.setForeground(Color.WHITE);
		
		add(warningNoteJLabel);
		warningNoteJLabel.setBounds(30, 500, 500, 20);
		warningNoteJLabel.setForeground(Color.RED);
		warningNoteJLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		add(backtoHomeJButton);
		backtoHomeJButton.setBounds(0, 522, 585, 40);
		backtoHomeJButton.setBackground(Color.BLACK);
		backtoHomeJButton.setForeground(Color.WHITE);
		
		//Aciton Lestener Registration on all Buttons
		
		openAccountJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  new OpenAccountDetails1().setVisible(true);
			  setVisible(false);	
			}
		});
		
		clearJButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cardNoJTextField.setText("");
				pinNoJTextField.setText("");
			}
		});
		
		proceedJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			   long accountNo = Long.parseLong(cardNoJTextField.getText());
			   @SuppressWarnings("deprecation")
			long pinNo = Long.parseLong(pinNoJTextField.getText());
			   
				try {
					Connection con  = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from LOGIN where ACCOUNT_NO=? and PIN=?");
					
					ps.setLong(1, accountNo);
					ps.setLong(2, pinNo);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next())
					{
						JOptionPane.showMessageDialog(ATMHome.this, "Login Successfull");
						new ATMLoginSuccess().setVisible(true);
						setVisible(false);
						
					} else {
						JOptionPane.showMessageDialog(ATMHome.this, "Incorrect Card and Pin Number");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		
		backtoHomeJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);				
			}
		});
	}
	public static void main(String[] args) 
	{
		ATMHome atmHome = new ATMHome();
		atmHome.setVisible(true);
		atmHome.setResizable(false);
	}
	
}
