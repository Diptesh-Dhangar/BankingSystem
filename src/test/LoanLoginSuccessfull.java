package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LoanLoginSuccessfull extends JFrame
{
	JLabel headingJLabel = new JLabel("Select Type Of Loan");
	ImageIcon ii1 = new ImageIcon("C:\\Users\\DIPTESH\\Desktop\\bankLoan.png");
	JLabel imageJLabel = new JLabel(ii1);
	
	JButton personalLoanJButton = new JButton("Apply for Personal Loan");
	JButton homeLoanJButton = new JButton("Apply for Home Loan");
	JButton goldLoanJButton = new JButton("Apply for Gold Loan");
	JButton vehicalLoanJButton = new JButton("Apply for Vehical Loan");
	JButton businessLoanJButton = new JButton("Apply for Business Loan");
	JButton educationLoanJButton = new JButton("Apply for Education Loan");
	JButton loanAgainstPropertyJButton = new JButton("Apply Loan Against Property");
	
	JButton takenLoanInformtionJButton = new JButton("Information Abount Taken Loan");
	JButton toPayLoanInstallmentJButton = new JButton("To Pay Loan Installment");
	
	JButton backJButton = new JButton("Cancel");
	
	public LoanLoginSuccessfull() 
	{
		setSize(800,800);
		setTitle("DSD BANK - Loan Section");
		setLayout(null);
		setLocation(370, 10);
		
		add(headingJLabel);
		headingJLabel.setBounds(275, 10, 270, 27);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
		
		add(takenLoanInformtionJButton);
		takenLoanInformtionJButton.setBounds(1, 60, 392, 35);
		takenLoanInformtionJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		takenLoanInformtionJButton.setBackground(Color.BLACK);
		takenLoanInformtionJButton.setForeground(Color.WHITE);
		add(toPayLoanInstallmentJButton);
		toPayLoanInstallmentJButton.setBounds(394, 60, 391, 35);
		toPayLoanInstallmentJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		toPayLoanInstallmentJButton.setBackground(Color.BLACK);
		toPayLoanInstallmentJButton.setForeground(Color.WHITE);
		
		add(imageJLabel);
		imageJLabel.setBounds(220, 110, 440, 330);
		
		add(personalLoanJButton);
		personalLoanJButton.setBounds(50, 480, 300, 35);
		personalLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		personalLoanJButton.setBackground(Color.BLACK);
		personalLoanJButton.setForeground(Color.WHITE);
		
		add(homeLoanJButton);
		homeLoanJButton.setBounds(400, 480, 300, 35);
		homeLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		homeLoanJButton.setBackground(Color.BLACK);
		homeLoanJButton.setForeground(Color.WHITE);
		
		add(goldLoanJButton);
		goldLoanJButton.setBounds(50, 540, 300, 35);
		goldLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		goldLoanJButton.setBackground(Color.BLACK);
		goldLoanJButton.setForeground(Color.WHITE);
		
		add(vehicalLoanJButton);
		vehicalLoanJButton.setBounds(400, 540, 300, 35);
		vehicalLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		vehicalLoanJButton.setBackground(Color.BLACK);
		vehicalLoanJButton.setForeground(Color.WHITE);
		
		add(businessLoanJButton);
		businessLoanJButton.setBounds(50, 600, 300, 35);
		businessLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		businessLoanJButton.setBackground(Color.BLACK);
		businessLoanJButton.setForeground(Color.WHITE);
		
		add(educationLoanJButton);
		educationLoanJButton.setBounds(400, 600, 300, 35);
		educationLoanJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		educationLoanJButton.setBackground(Color.BLACK);
		educationLoanJButton.setForeground(Color.WHITE);
		
		add(loanAgainstPropertyJButton);
		loanAgainstPropertyJButton.setBounds(220, 660, 300, 35);
		loanAgainstPropertyJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		loanAgainstPropertyJButton.setBackground(Color.BLACK);
		loanAgainstPropertyJButton.setForeground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(10, 720, 150, 35);
		backJButton.setFont(new Font("Arial", Font.PLAIN, 19));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);
		
		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		
		personalLoanJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonalLoan().setVisible(true);
				setVisible(false);
			}
		});
		
		homeLoanJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HomeLoan().setVisible(true);
				setVisible(false);
			}
		});
		
		takenLoanInformtionJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TakenLoanInfo().setVisible(true);
				setVisible(false);
			}
		});		
		
		loanAgainstPropertyJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoanAgainstProperty().setVisible(true);
				setVisible(false);
			}
		});
		
		toPayLoanInstallmentJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PayInstallment().setVisible(true);
				setVisible(false);
			}
		});
		
		getContentPane().setBackground(Color.WHITE);
	}
	public static void main(String[] args) 
	{
		LoanLoginSuccessfull loanLoginSuccessfull = new LoanLoginSuccessfull();
		loanLoginSuccessfull.setVisible(true);
		loanLoginSuccessfull.setResizable(false);
	}	
}
