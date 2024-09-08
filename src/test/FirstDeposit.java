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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class FirstDeposit extends JFrame 
{
   JLabel headingJLabel = new JLabel("DEPOSIT MONEY");
   JLabel subHeadingJLabel = new JLabel("you should deposite RS above 100");
   JLabel enterPinJLabel = new JLabel("Pin No:");
   JLabel enterDepositAmountJLabel = new JLabel("Amount");
   
   JPasswordField  enterpinJPasswordField = new JPasswordField();
   JTextField enterAmountJTextField  = new JTextField();
   
   JButton depositeJButton = new JButton("DEPOSIT");

   
   public FirstDeposit() 
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
	 headingJLabel.setBounds(205, 70, 190, 25);
	 headingJLabel.setFont(new Font("Arial", Font.BOLD, 22));
	 
	 add(subHeadingJLabel);
	 subHeadingJLabel.setBounds(150, 100, 330, 20);
	 subHeadingJLabel.setFont(new Font("Arial", Font.BOLD, 17));
	 subHeadingJLabel.setForeground(Color.RED);
	 
	 add(enterDepositAmountJLabel);
	 enterDepositAmountJLabel.setBounds(250, 180, 100, 25);
	 enterDepositAmountJLabel.setFont(new Font("Arial", Font.BOLD, 25));
	 
	 add(enterAmountJTextField);
	 enterAmountJTextField.setBounds(175, 215, 250, 27);
	 enterAmountJTextField.setFont(new Font("Arial", Font.BOLD, 22));
	 
	 add(depositeJButton);
	 depositeJButton.setBounds(200, 280, 200, 35);
	 depositeJButton.setFont(new Font("Arial", Font.BOLD, 20));
	 depositeJButton.setBackground(Color.BLACK);
	 depositeJButton.setForeground(Color.WHITE);
	 
	 getContentPane().setBackground(Color.WHITE);
	 
	 
	 depositeJButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			@SuppressWarnings("deprecation")
			long pinNo = Long.parseLong(enterpinJPasswordField.getText());
			float amount = Float.parseFloat(enterAmountJTextField.getText());
			
				try {
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Update Bank set BALANCE= BALANCE+? where PINNO=?");
					
					ps.setFloat(1, amount);
					ps.setLong(2, pinNo);
					
					int i = ps.executeUpdate();
					
					if (i==1) 
					{
						JOptionPane.showMessageDialog(FirstDeposit.this, "Amount Deposited Successfully"+"\n"+amount+"-/ Deposited Successfully");
						enterpinJPasswordField.setText("");
						new Home().setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(FirstDeposit.this, "Amount Deposited Fail");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		}
	});
   }
   public static void main(String[] args)
   {
	   FirstDeposit fDeposit = new FirstDeposit();
	   fDeposit.setVisible(true);
	   fDeposit.setResizable(false);
   }
}
