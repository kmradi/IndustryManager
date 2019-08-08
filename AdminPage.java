package cdac;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	

@SuppressWarnings("serial")
public class AdminPage extends JFrame
{
	public AdminPage() 
	{
		JTabbedPane tp = new JTabbedPane();
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		tp.addTab("Order Details",new OdrDetails());
		tp.addTab("Stock",new Stock());
		tp.addTab("Customer Information",new Customer());
		tp.addTab("Supplier Information",new Supplier());
		
		add(tp);
		setDefaultCloseOperation(2);
		setTitle("Admin");
		
		setVisible(true);
		setSize(1000,800);

	}
	
}
