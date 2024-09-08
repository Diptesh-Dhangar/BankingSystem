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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MiniStatement extends JFrame
{
	JLabel headingJLabel = new JLabel("Mini Statement");
	JLabel enterAccountNoJLabel = new JLabel("A/C No:");
	String ColumnNames [] = {"Date&Time","ID","AccountNO","Debited","Credited","Balance"};
	JTextField enterAcountNoJTextField = new JTextField();
	
	JButton statementJButton  = new JButton("View Statement");
	JButton backJButton = new JButton("Back");
	JButton printJButton = new JButton("Print");
	
	String dateandtimeString = "";
	long idString  = 0;
	long accountNo = 0;
	float debited  = 0;
	float credited = 0;
	float balance  = 0;
	
	public MiniStatement() 
	{
		setSize(1000,750);
		setTitle("DSD BANK - Mini Statement");
		setLayout(null);
		
		add(headingJLabel);
		headingJLabel.setBounds(200, 10, 270, 27);
		headingJLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		add(enterAccountNoJLabel);
		enterAccountNoJLabel.setBounds(710, 10, 80, 25);
		enterAccountNoJLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(enterAcountNoJTextField);
		enterAcountNoJTextField.setBounds(790, 10, 180, 25);
		enterAcountNoJTextField.setFont(new Font("Arial", Font.BOLD, 25));

		add(statementJButton);
		statementJButton.setBounds(790, 45, 180, 30);
		statementJButton.setFont(new Font("Arial", Font.BOLD, 14));
		statementJButton.setBackground(Color.BLACK);
		statementJButton.setForeground(Color.WHITE);
		
		add(backJButton);
		backJButton.setBounds(5, 673, 200, 35);
		backJButton.setFont(new Font("Arial", Font.BOLD, 20));
		backJButton.setBackground(Color.BLACK);
		backJButton.setForeground(Color.WHITE);
		
		add(printJButton);
		printJButton.setBounds(782, 673, 200, 35);
		printJButton.setFont(new Font("Arial", Font.BOLD, 20));
		printJButton.setBackground(Color.BLACK);
		printJButton.setForeground(Color.WHITE);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(ColumnNames);
		JTable table = new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setFont(new Font("Arial", Font.BOLD, 15));
		table.setFillsViewportHeight(true);
	    JScrollPane scrollPane = new JScrollPane(table);
	    add(scrollPane);
	    scrollPane.setBounds(4,80, 980, 590);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		statementJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long acNo = Long.parseLong(enterAcountNoJTextField.getText());
					Connection con = DBConnection.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from ESTATEMENT where ACCOUNT_NO=?");
					
					ps.setLong(1, acNo);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next())
					{
						dateandtimeString = rs.getString(1);
						idString = rs.getLong(2);
						accountNo = rs.getLong(3);
						debited = rs.getFloat(4);
						credited = rs.getFloat(5);
						balance = rs.getFloat(6);
						
						Object rows [] =  {dateandtimeString,idString,accountNo,debited,credited,balance};
						dtm.addRow(rows);	
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		backJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ATMLoginSuccess().setVisible(true);
				setVisible(false);
			}
		});
	}
	public static void main(String[] args) 
	{
		MiniStatement miniStatement = new MiniStatement();
		miniStatement.setVisible(true);
		miniStatement.setResizable(false);
	}
}
