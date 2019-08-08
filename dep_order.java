package cdac;

import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class dep_order extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField t1;
	JButton b1;
	static Statement stm;
	static int depno;
	dep_order(Statement st, String dep)
	{
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		stm= st;
		if(dep.equals("dep1"))
			depno= 1;
		else if (dep.equals("dep2"))
		    depno =2;
		else if (dep.equals("dep3"))
			depno =3;
		else
		{
			//System.out.println("Does not belong to any department");
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(this,"Does not belong to any department");
		}
		setTitle("Department");
		setLayout(null);
		l1= new JLabel("Enter OrderId");
		t1 = new JTextField (10);
		b1 = new JButton("ENTER");
		
		l1.setBounds(440, 100, 150, 30);
		t1.setBounds(400,150, 200, 30);
		b1.setBounds(450,200, 100, 30);
		
		b1.addActionListener(this);
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		b1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		add(l1);
		add(t1);
		add(b1);
		add(lbkg);
		setSize(1000,800);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		int i = Integer.parseInt(t1.getText());
		try 
		{
			int id=-1;
			ResultSet rs = stm.executeQuery("Select * from order_details");
			while(rs.next())
			{
				id = rs.getInt("orderid");
				
				if(i == id)
					break;
			}
			//System.out.println(id);
			if(i == id)
			{
		      if (depno == 1)
		      {
		    	  dep1 d1 = new dep1(stm, i);
		    	  setVisible(false);
		    	 // System.out.println(i);
		    	  
		      }
		      else if(depno == 2)
		      {
		    	  dep2 d2 = new dep2(stm,i);
		    	  setVisible(false);
		      }
		      else if(depno == 3)
		      {
		    	  dep3 d3 = new dep3(stm,i);
		    	  setVisible(false);
		      }
			}
			else
				{
				//System.out.println("not okay");
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(this,"Does not belong to any orderid\nPlease enter the corret order id");
				t1.setText("");
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		
		try 
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","mysql");
		  stm = con.createStatement();
		} 
		catch (Exception e) 
		{
		 System.out.println(e);
		}		
		dep_order dp1 = new dep_order(stm, "dep1");
	}
	
	
}
