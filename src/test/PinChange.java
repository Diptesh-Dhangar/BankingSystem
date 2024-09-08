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
public class PinChange extends JFrame
{
	JLabel headingJLabel = new JLabel("PIN CHANGE");
	JLabel enterOldPinJLabel = new JLabel("Enter Old Pin:");
	JLabel enterNewPinJLabel = new JLabel("Enter New Pin");
	JLabel reEnterNewPinJLabel = new JLabel("Re-Enter New Pin");
	
	JTextField enterOldPinJTextField = new JTextField();
	JPasswordField enterNewPinJTextField = new JPasswordField();
	JPasswordField reEnterNewPinJTextField = new JPasswordField();
	
	JButton changeJButton = new JButton("CHANGE");
	JButton cancelJButton = new JButton("CANCEL");
		
	public PinChange() 
	{
	  setSize(600, 470);
	  setTitle("PIN CHNAGE");
	  setLayout(null);
	  setLocation(450, 120);
	  
	 add(headingJLabel);
	 headingJLabel.setBounds(215, 25, 170, 27);
	 headingJLabel.setFont(new Font("Arial", Font.BOLD, 25));
	 
	 add(enterOldPinJLabel);
	 enterOldPinJLabel.setBounds(60, 120, 170, 20);
	 enterOldPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	 add(enterOldPinJTextField);
	 enterOldPinJTextField.setBounds(250, 120, 250, 25);
	 enterOldPinJTextField.setFont(new Font("Arial", Font.BOLD, 22));	
	 
	 add(enterNewPinJLabel);
	 enterNewPinJLabel.setBounds(60, 175, 170, 20);
	 enterNewPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	 add(enterNewPinJTextField);
	 enterNewPinJTextField.setBounds(250, 175, 250, 25);
	 enterNewPinJTextField.setFont(new Font("Arial", Font.BOLD, 22));
	 enterNewPinJTextField.setEchoChar('X');
	 
	 add(reEnterNewPinJLabel);
	 reEnterNewPinJLabel.setBounds(60, 230, 170, 20);
	 reEnterNewPinJLabel.setFont(new Font("Arial", Font.BOLD, 20));
	 add(reEnterNewPinJTextField);
	 reEnterNewPinJTextField.setBounds(250, 230, 250, 25);
	 reEnterNewPinJTextField.setFont(new  Font("Arial", Font.BOLD, 22));
	 reEnterNewPinJTextField.setEchoChar('X');
	 
	add(cancelJButton);
	cancelJButton.setBounds(70, 330, 200, 35);
	cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
	cancelJButton.setBackground(Color.BLACK);
	cancelJButton.setForeground(Color.WHITE);
	
	add(changeJButton);
	changeJButton.setBounds(300, 330, 200, 35);
	changeJButton.setFont(new Font("Arial", Font.BOLD, 20));
	changeJButton.setBackground(Color.BLACK);
	changeJButton.setForeground(Color.WHITE);
	
	getContentPane().setBackground(Color.WHITE);
		
		changeJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String oldPinString = enterOldPinJTextField.getText();
				@SuppressWarnings("deprecation")
				String newPinString = enterNewPinJTextField.getText();
				@SuppressWarnings("deprecation")
				String reEnterNewPinString = reEnterNewPinJTextField.getText();
				
					if (oldPinString.length()!=0)
					{
						if (newPinString.equals(reEnterNewPinString)) 
						{
							try {
								long OLDPIN = Long.parseLong(enterOldPinJTextField.getText());
								@SuppressWarnings({ "unused", "deprecation" })
								long NEWPIN= Long.parseLong(enterNewPinJTextField.getText());
								@SuppressWarnings("deprecation")
								long REENTERNEWPIN = Long.parseLong(reEnterNewPinJTextField.getText());
								
								Connection con = DBConnection.getCon();
							    PreparedStatement ps1 = con.prepareStatement("update bank set PINNO=? where PINNO=?");
							    PreparedStatement ps2 = con.prepareStatement("update login set PIN=? where PIN=?");
							    PreparedStatement ps3 = con.prepareStatement("update createaccount3 set PIN=? where PIN=?");
							    
							    ps1.setLong(1, REENTERNEWPIN);
							    ps1.setLong(2, OLDPIN);
							    
							    ps2.setLong(1, REENTERNEWPIN);
							    ps2.setLong(2, OLDPIN);
							    
							    ps3.setLong(1, REENTERNEWPIN);
							    ps3.setLong(2, OLDPIN);
							    
							    int i = ps1.executeUpdate();
							    int j = ps2.executeUpdate();
							    int k = ps3.executeUpdate();
							    
							    if (i==1 && j==1 && k==1) 
							    {
									JOptionPane.showMessageDialog(PinChange.this , "Pin Changed Successfully");
									new ATMLoginSuccess().setVisible(true);
									setVisible(false);
								} else {
									JOptionPane.showMessageDialog(PinChange.this, "Pin Changing Failed");
								} 
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(PinChange.this, "New Pin"+"\n AND"+"\nRe Enter New Pin are Not Matching"+"\nPlease Check It Carefully");                                                                  
						}
					}else {
						JOptionPane.showMessageDialog(PinChange.this, "Old Pin is Mandatory");
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
		PinChange pinchange = new PinChange();
		pinchange.setVisible(true);
		pinchange.setResizable(false);
	}
}
