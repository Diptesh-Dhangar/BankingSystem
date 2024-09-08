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

@SuppressWarnings("serial")
public class ATMLoginSuccess extends JFrame
{
  JLabel headingJLabel = new JLabel("Please Select Your Transaction");
  
  JButton depositeJButton = new JButton("DEPOSIT");
  JButton cashwithdrawlJButton = new JButton("CASH WITHDRAWL");
  JButton fastcashJButton = new JButton("FAST CASH");
  JButton ministatementJButton = new JButton("MINI STATEMENT");
  JButton pinchangeJButton = new JButton("PIN CHANGE");
  JButton balanceEnquiryJButton = new JButton("BALANCE ENQUIRY");
  JButton exitJButton = new JButton("EXIT");
  
  public ATMLoginSuccess() 
  {
	setSize(750, 650);
	setTitle("TRANSACTION");
	setLayout(null);
	setLocation(400, 80);
	
	add(headingJLabel);
	headingJLabel.setBounds(140, 50, 470, 25);
	headingJLabel.setFont(new Font("Arial", Font.BOLD, 30));
	
	add(depositeJButton);
	depositeJButton.setBounds(40, 150, 270, 40);
	depositeJButton.setFont(new Font("Arial", Font.BOLD, 20));
	depositeJButton.setBackground(Color.BLACK);
	depositeJButton.setForeground(Color.WHITE);
	
	add(cashwithdrawlJButton);
	cashwithdrawlJButton.setBounds(420, 150, 270, 40);
	cashwithdrawlJButton.setFont(new Font("Arial", Font.BOLD, 20));
	cashwithdrawlJButton.setBackground(Color.BLACK);
	cashwithdrawlJButton.setForeground(Color.WHITE);
	
	add(fastcashJButton);
	fastcashJButton.setBounds(40, 270, 270, 40);
	fastcashJButton.setFont(new Font("Arial", Font.BOLD, 20));
	fastcashJButton.setBackground(Color.BLACK);
	fastcashJButton.setForeground(Color.WHITE);
	
	add(ministatementJButton);
	ministatementJButton.setBounds(420, 270, 270, 40);
	ministatementJButton.setFont(new Font("Arial", Font.BOLD, 20));
	ministatementJButton.setBackground(Color.BLACK);
	ministatementJButton.setForeground(Color.WHITE);
	
	add(pinchangeJButton);
	pinchangeJButton.setBounds(40, 390, 270, 40);
	pinchangeJButton.setFont(new Font("Arial",Font.BOLD, 20));
	pinchangeJButton.setBackground(Color.BLACK);
	pinchangeJButton.setForeground(Color.WHITE);
	
	add(balanceEnquiryJButton);
	balanceEnquiryJButton.setBounds(420, 390, 270, 40);
	balanceEnquiryJButton.setFont(new Font("Arial", Font.BOLD, 20));
	balanceEnquiryJButton.setBackground(Color.BLACK);
	balanceEnquiryJButton.setForeground(Color.WHITE);
	
	
	add(exitJButton);
	exitJButton.setBounds(230, 510, 270, 40);
	exitJButton.setFont(new Font("Arial", Font.BOLD, 20));
	exitJButton.setBackground(Color.BLACK);
	exitJButton.setForeground(Color.WHITE);
	
	getContentPane().setBackground(Color.WHITE);
	
	
	depositeJButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Deposit().setVisible(true);
			setVisible(false);			
		}
	});
	
	cashwithdrawlJButton.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			new Withdraw().setVisible(true);
			setVisible(false);
		}
	});
	
	fastcashJButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new FastCash().setVisible(true);
			setVisible(false);
			
		}
	});
	exitJButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Home().setVisible(true);
			setVisible(false);
		}
	});
	
	pinchangeJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new PinChange().setVisible(true);
			setVisible(false);
		}
	});
	
	balanceEnquiryJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			long pin = Long.parseLong(JOptionPane.showInputDialog("Enter Pin No :"));
			
			try {
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Select * from bank where PINNO=?");
				
				ps.setLong(1, pin);
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) 
				{
					float balance = rs.getFloat(3);
					JOptionPane.showMessageDialog(ATMLoginSuccess.this, "Your Account Balance is  "+balance);
					
				} else {
					JOptionPane.showMessageDialog(ATMLoginSuccess.this, "Invalid Pin Number");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	});
	ministatementJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new MiniStatement().setVisible(true);
			setVisible(false);
		}
	});
  }
  public static void main(String[] args)
  {
	ATMLoginSuccess atmLoginSuccess = new ATMLoginSuccess();
	atmLoginSuccess.setVisible(true);
	atmLoginSuccess.setResizable(false);
  }
}
