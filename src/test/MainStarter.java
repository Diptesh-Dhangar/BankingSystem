package test;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainStarter extends JFrame
{
	static int x;
	JLabel textJLabel = new JLabel("DSD");
	
	public MainStarter() 
	{
		setSize(500, 300);
		setLocation(530, 250);
		setLayout(null);
		
		add(textJLabel);
		textJLabel.setBounds(100, 50, 250, 80);
		textJLabel.setOpaque(true);
		textJLabel.setBackground(Color.LIGHT_GRAY);
		textJLabel.setFont(new Font("Monosapced", Font.BOLD, 30));

	}
	public static void main(String[] args) 
	{
		MainStarter mainStarter = new MainStarter();
		mainStarter.setVisible(true);
		
		  try { for(x=0;x<=20;x++) {
		  
		  Thread.sleep(20);
		  
		  if (x==20) { JOptionPane.showMessageDialog(mainStarter, "Time Done"); } } }
		  catch (Exception e) { e.printStackTrace(); }
		  
	}
}
