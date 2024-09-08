package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Home extends JFrame
{
   JPanel mainJPanel = new JPanel();
	
   JLabel headingJLabel = new JLabel("DSD BANK");
   JLabel lastHeadingJLabel = new JLabel("Created By DSD Group Of Coding Company");
  
   JButton openAccountJButton = new JButton("OPEN ACCOUNT");
   JButton viewAccountJButton = new JButton("VIEW ACCOUNT");
   JButton updateAccountJButton = new JButton("UPDATE ACCOUNT");
   JButton deleteAccountJButton = new JButton("DELETE ACCOUNT");
   JButton transferMoneyJButton= new JButton("TRANSFER MONEY");
   JButton loanJButton = new JButton("Loan Section");
   
   JButton ATMJButton= new JButton("ATM");
   
   ImageIcon ii = new ImageIcon("C:\\Users\\DIPTESH\\Desktop\\Bank Image.png");
   JLabel icon = new JLabel(ii);
   
   JButton usingAccountNumberJButton  = new JButton("Using A/C Number");
   JButton usingAccountHolderNameJButton = new JButton("Using A/C ID");
     
   Object [] options = {usingAccountNumberJButton,usingAccountHolderNameJButton};
     
   public Home() 
   {
	   setSize(1160, 780);
	   setLayout(null);
	   setLocation(200, 35);
	   
	   add(icon);
	   icon.setBounds(2,72, 1142, 599);
	   
	   add(headingJLabel);
	   headingJLabel.setBounds(510, 10, 130, 20);
	   headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
	   
	   add(openAccountJButton);
	   openAccountJButton.setBounds(0, 40, 230, 30);
	   openAccountJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   openAccountJButton.setBackground(Color.BLACK);
	   openAccountJButton.setForeground(Color.WHITE);
	   
	   add(viewAccountJButton);
	   viewAccountJButton.setBounds(230, 40, 230, 30);
	   viewAccountJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   viewAccountJButton.setBackground(Color.BLACK);
	   viewAccountJButton.setForeground(Color.WHITE);
	   
	   add(updateAccountJButton);
	   updateAccountJButton.setBounds(459, 40, 230, 30);
	   updateAccountJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   updateAccountJButton.setBackground(Color.BLACK);
	   updateAccountJButton.setForeground(Color.WHITE);
	   
	   add(deleteAccountJButton);
	   deleteAccountJButton.setBounds(688, 40, 230, 30);
	   deleteAccountJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   deleteAccountJButton.setBackground(Color.BLACK);
	   deleteAccountJButton.setForeground(Color.WHITE);
	   
	   add(transferMoneyJButton);
	   transferMoneyJButton.setBounds(917, 40, 230, 30);
	   transferMoneyJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   transferMoneyJButton.setBackground(Color.BLACK);
	   transferMoneyJButton.setForeground(Color.WHITE);
	   
	   add(ATMJButton);
	   ATMJButton.setBounds(0, 673, 573, 40);
	   ATMJButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
	   ATMJButton.setBackground(Color.BLACK);
	   ATMJButton.setForeground(Color.WHITE);
	   
	   add(loanJButton);
	   loanJButton.setBounds(573, 673, 573, 40);
	   loanJButton.setFont(new Font("Arial", Font.BOLD, 20));
	   loanJButton.setBackground(Color.BLACK);
	   loanJButton.setForeground(Color.WHITE);
	   
	   add(lastHeadingJLabel);
	   lastHeadingJLabel.setBounds(340, 715, 500, 23);
	   lastHeadingJLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
	   lastHeadingJLabel.setForeground(Color.GRAY);
	  
	  getContentPane().setBackground(Color.WHITE);
	  
	  ATMJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			new ATMHome().setVisible(true);
			setVisible(false);
		}
	});
	  
	  openAccountJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new OpenAccountDetails1().setVisible(true);
			setVisible(false);
		}
	});
	  
	  viewAccountJButton.addActionListener(new ActionListener() {
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showOptionDialog(Home.this, "Select the Option on Which you want to view Account", "IMP QUESTION", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);	
		}
	});
	  
	  // Inner JButtons
	  	
	  usingAccountNumberJButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			new ViewAccount().setVisible(true);
			setVisible(false);
		}
	});
	  usingAccountHolderNameJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new ViewAccountBasedOnID().setVisible(true);
			setVisible(false);
		}
	});
	  
	  //Inner JButtons Ends
	  
	  transferMoneyJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new TransferMoney().setVisible(true);
			setVisible(false);
		}
	});
	  
	  updateAccountJButton.addActionListener(new ActionListener() {
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new UpdateAccount().setVisible(true);
			setVisible(false);
		}
	});
	  
	  deleteAccountJButton.addActionListener(new ActionListener() {
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new DeleteAccount().setVisible(true);
			setVisible(false);
		}
	});
	  
	  loanJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			new LoanLogin().setVisible(true);
			setVisible(false);
		}
	});

   }
    public static void main(String[] args) 
      {
    	Home home = new Home();
    	home.setVisible(true);
    	home.setResizable(false);   	
      }
}
