package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OpenAccountDetails2 extends JFrame
{
	JLabel applicationNoJLabel = new JLabel("Form No:");
	JTextField applicationFormNoJTextField = new JTextField();
	
	JLabel headingJLabel  = new JLabel("Page 2: Additional Details");
	JLabel religionJLabel  = new JLabel("Religion:");
	JLabel categoryJLabel = new JLabel("Category:");
	JLabel incomeJLabel = new JLabel("Income:");
	JLabel qualificationJLabel = new JLabel("Qualification:");
	JLabel occupationJLabel = new JLabel("Occupation:");
	JLabel pannumberJLabel = new JLabel("Pan Number:");   
	JLabel adharnumberJLabel = new JLabel("Adhar Number");
	JLabel seniorcitizenJLabel = new JLabel("Senior Citizen:");
	JLabel exitstingaccountJLabel = new JLabel("Existing Account:");
	
	String [] religion = {"","Hindu","Hinduism","Islam","hristianity","Sikhism","Buddhism","Jainism ","Judaism","Other religions"};
	JComboBox<String> religionJComboBox = new JComboBox<String>(religion);
	
	String [] category = {"","OPEN","OBC","NT","SC","ST","OTHER"};
	JComboBox<String> categoryJComboBox = new JComboBox<String>(category);
	
	String [] income = {"","0","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
	JComboBox<String> incomeJComboBox = new JComboBox<String>(income);
	
	String [] qualifaction = {"","10th Pass","12th Pass","Under Graduate","Post Graduate","PHD"};
	JComboBox<String> qualifactioinJComboBox = new JComboBox<String>(qualifaction);
	
	String [] occupation = {"","Salaried","Unsalaried"};
	JComboBox<String> occupationJComboBox = new JComboBox<String>(occupation);
		
	JTextField pannumberJTextField = new JTextField();
	JTextField adharnumberJTextField = new JTextField();
	
    ButtonGroup seniorCitizenButtonGroup = new ButtonGroup();
	JRadioButton scYesJRadioButton = new JRadioButton("Yes");
	JRadioButton scNoJRadioButton = new JRadioButton("No");
	
	ButtonGroup existingAccountButtonGroup = new ButtonGroup();
	JRadioButton eaYesJRadioButton = new JRadioButton("Yes");
	JRadioButton eaNoJRadioButton = new JRadioButton("No");
	
	JButton nextJButton = new JButton("NEXT>>");
    JButton cancelJButton = new JButton("CANCEL");
	
	public OpenAccountDetails2()
	{
		setSize(750, 750);
		setTitle("ACCOUNT APPLICATION FORM - PAGE 2");
		setLayout(null);
		setLocation(400, 40);
		
		add(applicationNoJLabel);
		applicationNoJLabel.setBounds(570, 10, 75, 20);
		applicationNoJLabel.setFont(new Font("Arial", Font.BOLD, 17));
		add(applicationFormNoJTextField);
		applicationFormNoJTextField.setBounds(650, 10, 55, 25);
		applicationFormNoJTextField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(headingJLabel);
		headingJLabel.setBounds(230, 60, 290, 25);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 23));
		
		add(religionJLabel);
		religionJLabel.setBounds(80, 140, 200, 25);
		religionJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(religionJComboBox);
		religionJComboBox.setBounds(350, 140, 300, 25);
		religionJComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		religionJComboBox.setBackground(Color.WHITE);
		
		add(categoryJLabel);
		categoryJLabel.setBounds(80, 190, 200, 25);
		categoryJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(categoryJComboBox);
		categoryJComboBox.setBounds(350, 190, 300, 25);
		categoryJComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		categoryJComboBox.setBackground(Color.WHITE);
		
		add(incomeJLabel);
		incomeJLabel.setBounds(80, 240, 240, 25);
		incomeJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(incomeJComboBox);
		incomeJComboBox.setBounds(350, 240, 300, 25);
		incomeJComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		incomeJComboBox.setBackground(Color.WHITE);
		
		add(qualificationJLabel);
		qualificationJLabel.setBounds(80, 290, 200, 25);
		qualificationJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(qualifactioinJComboBox);
		qualifactioinJComboBox.setBounds(350, 290, 300, 25);
		qualifactioinJComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		qualifactioinJComboBox.setBackground(Color.WHITE);
		
		add(occupationJLabel);
		occupationJLabel.setBounds(80, 340, 200, 25);
		occupationJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(occupationJComboBox);
		occupationJComboBox.setBounds(350, 340, 300, 25);
		occupationJComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		occupationJComboBox.setBackground(Color.WHITE);
		
		add(pannumberJLabel);
		pannumberJLabel.setBounds(80, 390, 200, 25);
		pannumberJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(pannumberJTextField);
		pannumberJTextField.setBounds(350, 390, 300, 25);
		pannumberJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		add(adharnumberJLabel);
		adharnumberJLabel.setBounds(80, 440, 200, 25);
		adharnumberJLabel.setFont(new Font("Arail", Font.BOLD, 20));
		add(adharnumberJTextField);
		adharnumberJTextField.setBounds(350, 440, 300, 25);
		adharnumberJTextField.setFont(new Font("Arial", Font.PLAIN, 22));
		
		seniorCitizenButtonGroup.add(scYesJRadioButton);
		seniorCitizenButtonGroup.add(scNoJRadioButton);
		
		add(seniorcitizenJLabel);
		seniorcitizenJLabel.setBounds(80, 490, 200, 25);
		seniorcitizenJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(scYesJRadioButton);
		scYesJRadioButton.setBounds(350, 490, 100, 25);
		scYesJRadioButton.setFont(new Font("Arial", Font.PLAIN,20));
		scYesJRadioButton.setBackground(Color.WHITE);
		add(scNoJRadioButton);
		scNoJRadioButton.setBounds(450, 490, 100, 25);
		scNoJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		scNoJRadioButton.setBackground(Color.WHITE);
		
		existingAccountButtonGroup.add(eaYesJRadioButton);
		existingAccountButtonGroup.add(eaNoJRadioButton);
		
		add(exitstingaccountJLabel);
		exitstingaccountJLabel.setBounds(80, 540, 200, 25);
		exitstingaccountJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(eaYesJRadioButton);
		eaYesJRadioButton.setBounds(350, 540, 100, 25);
		eaYesJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		eaYesJRadioButton.setBackground(Color.WHITE);
		add(eaNoJRadioButton);
		eaNoJRadioButton.setBounds(450, 540, 100, 25);
		eaNoJRadioButton.setFont(new Font("Arial", Font.PLAIN, 20));
		eaNoJRadioButton.setBackground(Color.WHITE);
		
		add(cancelJButton);
		cancelJButton.setBounds(100, 640, 200, 40);
		cancelJButton.setFont(new Font("Arial", Font.BOLD, 20));
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setForeground(Color.WHITE);
		
		add(nextJButton);
		nextJButton.setBounds(400, 640, 200, 40);
		nextJButton.setFont(new  Font("Arial", Font.CENTER_BASELINE, 22));
		nextJButton.setBackground(Color.BLACK);
		nextJButton.setForeground(Color.WHITE);
		
		getContentPane().setBackground(Color.WHITE);
		
		nextJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				long applicationformno = Long.parseLong(applicationFormNoJTextField.getText());
				String religion = (String) religionJComboBox.getSelectedItem();
				String category = (String) categoryJComboBox.getSelectedItem();
				String income = (String) incomeJComboBox.getSelectedItem();
				String qualification = (String) qualifactioinJComboBox.getSelectedItem();
				String occupation = (String) occupationJComboBox.getSelectedItem();
				String panNo = pannumberJTextField.getText();
				String adharNo = adharnumberJTextField.getText();
				
				String seniorCitizen = "";
				if (scYesJRadioButton.isSelected())
				{
					seniorCitizen = "Yes";
				} else if (scNoJRadioButton.isSelected()) {
					seniorCitizen = "No";
				} else {
					seniorCitizen = "";
				}
				
				String existingAC = "";
				if (eaYesJRadioButton.isSelected()) {
					existingAC = "Yes";
				} else if(eaNoJRadioButton.isSelected()) {
					existingAC = "No";
				}
				
				try {
					long accountNumber = 0;
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("INsert into CREATEACCOUNT2 values(?,?,?,?,?,?,?,?,?,?,?)");
					
					ps.setLong(1, applicationformno);
					ps.setLong(2,accountNumber);
					ps.setString(3, religion);
					ps.setString(4, category);
					ps.setString(5,income);
					ps.setString(6, qualification);
					ps.setString(7, occupation);
					ps.setString(8, panNo);
					ps.setString(9, adharNo);
					ps.setString(10, seniorCitizen);
					ps.setString(11, existingAC);
					
					int i = ps.executeUpdate();
					
					if (i==1)
					{
						JOptionPane.showMessageDialog(OpenAccountDetails2.this, "Additional Detials Saved Successfully");
						new OpenAccountDetails3().setVisible(true);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(OpenAccountDetails2.this, "Unable to Save the Detials");
					}	
				} catch (Exception e2) {
					e2.printStackTrace();
				}		
			}
		});
	}
	public static void main(String[] args) 
	{
		OpenAccountDetails2 openAccountDetails2 = new OpenAccountDetails2();
		openAccountDetails2.setVisible(true);
		openAccountDetails2.setResizable(false);
		openAccountDetails2.setResizable(false);
	}
}
