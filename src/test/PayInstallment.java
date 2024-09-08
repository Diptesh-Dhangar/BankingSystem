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
public class PayInstallment extends JFrame
{
	JLabel headingJLabel = new JLabel("Installment Payment");
	JLabel accountNoJLabel = new JLabel("Account No :");
	JLabel nameJLabel = new JLabel("Name :");
	JLabel typeofLoanJLabel = new JLabel("Type Of Loan");
	JLabel amtToDepositeJLabel = new JLabel("Amt To Deposit");
	
	JTextField accountNoJTextField = new JTextField();
	JTextField nameJTextField = new JTextField();
	JTextField typeOfLoanJTextField = new JTextField();
	JTextField amtToDepositJTextField = new JTextField();
	
   	JButton searchJButton = new JButton("Search");
   	JButton depositJButton = new JButton("Deposit");
    JButton cancelJButton = new JButton("Cancel");
	
   public PayInstallment()
   {
	   setSize(800, 580);
	   setTitle("DSD BANK - Pay Installment Page");
	   setLayout(null);
	   
	   add(headingJLabel);
	   headingJLabel.setBounds(275, 10, 250, 27);
	   headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
	   
	   add(accountNoJLabel);
	   accountNoJLabel.setBounds(100, 100, 130, 20);
	   accountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	   add(accountNoJTextField);
	   accountNoJTextField.setBounds(300, 100, 250, 25);
	   accountNoJTextField.setFont(new Font("Arial", Font.BOLD, 23));
	   
	   add(nameJLabel);
	   nameJLabel.setBounds(100, 150, 120, 22);
	   nameJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	   add(nameJTextField);
	   nameJTextField.setBounds(300, 150, 250, 25);
	   nameJTextField.setFont(new Font("Arial", Font.BOLD, 22));
	   
	   add(typeofLoanJLabel);
	   typeofLoanJLabel.setBounds(100, 200, 140, 23);
	   typeofLoanJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	   add(typeOfLoanJTextField);
	   typeOfLoanJTextField.setBounds(300, 200, 250, 25);
	   typeOfLoanJTextField.setFont(new Font("Arial", Font.BOLD, 21));
	   typeOfLoanJTextField.setEditable(false);
	   
	   add(searchJButton);
	   searchJButton.setBounds(300, 250, 250, 35);
	   searchJButton.setFont(new Font("Arial", Font.BOLD, 20));
	   searchJButton.setBackground(Color.BLACK);
	   searchJButton.setForeground(Color.WHITE);
	   
	   add(amtToDepositeJLabel);
	   amtToDepositeJLabel.setBounds(100, 350, 150, 20);
	   amtToDepositeJLabel.setFont(new Font("Arial",Font.BOLD, 20));
	   amtToDepositeJLabel.setEnabled(false);
	   add(amtToDepositJTextField);
	   amtToDepositJTextField.setBounds(300, 350, 250, 25);
	   amtToDepositJTextField.setFont(new Font("Arial", Font.BOLD, 23));
	   amtToDepositJTextField.setEditable(false);
	   
	   add(depositJButton);
	   depositJButton.setBounds(300, 400, 250, 35);
	   depositJButton.setFont(new  Font("Arial", Font.BOLD, 20));
	   depositJButton.setBackground(Color.BLACK);
	   depositJButton.setForeground(Color.WHITE);
	   depositJButton.setEnabled(false);
	   
	   add(cancelJButton);
	   cancelJButton.setBounds(10, 500, 150, 35);
	   cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
	   cancelJButton.setBackground(Color.BLACK);
	   cancelJButton.setForeground(Color.WHITE);
	   
	   cancelJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new LoanLoginSuccessfull().setVisible(true);
			setVisible(false);
		}
	});
	   
	   searchJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				long acNo = Long.parseLong(accountNoJTextField.getText());
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Select * from LOANINFO where ACCOUNT_NO=?");
				ps.setLong(1, acNo);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next())
				{
					String typeOfLoan = rs.getString(16);
					typeOfLoanJTextField.setText(typeOfLoan);
					
					amtToDepositeJLabel.setEnabled(true);
					amtToDepositJTextField.setEditable(true);
					depositJButton.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(PayInstallment.this, "Invalid account number");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	});
	   
	   depositJButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				long acNo = Long.parseLong(accountNoJTextField.getText());
				float amtToDeposit = Float.parseFloat(amtToDepositJTextField.getText());
				float interest = amtToDeposit*7/100;
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Update LOANINFO set LOAN_AMT=LOAN_AMT+? , LOAN_W_INR=LOAN_W_INR+? where ACCOUNT_NO=?");
				ps.setFloat(1, -amtToDeposit);
				ps.setFloat(2, -interest);
				ps.setLong(3, acNo);
				
				int i = ps.executeUpdate();
				
				if (i==1) 
				{
					JOptionPane.showMessageDialog(PayInstallment.this, "Installment Deposited Successfully");
				} else {
					JOptionPane.showMessageDialog(PayInstallment.this, "Failed to Deposite the Installment");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	});
	   
   }
   
   public static void main(String[] args) 
   {
	   PayInstallment payInstallment = new PayInstallment();
	   payInstallment.setVisible(true);
	   payInstallment.setResizable(false);
   }
}
