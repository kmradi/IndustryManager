package cdac;

import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
public class dep3 extends JFrame implements ActionListener
{
	JLabel l1,l2, l3, l4,l5,l6,l7,l8;
	JButton b1, b2;
	JTextField t1, t2, t3, t4,t5,t6;
	int id;
	int q,cost, cust;
	String dt, pr, mo;
	static Statement stm;
	dep3(Statement st, int i)
	{
		setTitle ("Department 3");
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		setLayout(null);
		id =i;
		stm = st;
		l1 =new JLabel("<html>");
		l2 = new JLabel ("Current Step");
		l3 = new JLabel ("____________________________________________________________________________");
		l4 = new JLabel ("Raw Materials Required");
		l5 = new JLabel ("Material 2");
		l6 = new JLabel ("Material 3");
		l8 = new JLabel ("Material 4");
		l7 = new JLabel ("Expected Step");
		b1 = new JButton ("Update Step");
		b2 = new JButton ("Update Material");
		t1 = new JTextField(2);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);
		t6 = new JTextField(10);
	    
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		b1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		b2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l7.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l8.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        l1.setBorder(border);
		
        try 
		{
        	ResultSet rs = stm.executeQuery("SELECT * FROM order_details where orderid = "+id+"");
        	while (rs.next())
        	{
        		q= rs.getInt("quantity");
        		cost = rs.getInt("total_cost");
        		mo = rs.getString("modelno");
        		pr = rs.getString("product");
        		cust = rs.getInt("custid");
        		dt = rs.getString("date");
        	}
        	l1.setText("<html>Order ID &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp : "+id+"<br>Customer ID&nbsp&nbsp&nbsp: "+cust+"<br>Quantity &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp : "+q+"<br>Product name: "+pr+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Model Number: "+mo+"<br>Cost: "+cost+"</html>");
        	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
        l1.setBounds(200,50,600,200);
        
        l2.setBounds(300,300,150,30);
        t1.setBounds(500,300,100,30);
		l7.setBounds(300,350,150,30);
		t5.setBounds(500,350,100,30);
        
		b1.setBounds(650,325,150,30);
		
		l3.setBounds(120,400,800,30);
		l4.setBounds(350,430, 600,30);
		
		l5.setBounds(300,480,150,30);
        t2.setBounds(500,480,100,30);
		l6.setBounds(300,530,150,30);
		t3.setBounds(500,530,100,30);
		l8.setBounds(300,580,150,30);
		t4.setBounds(500,580,100,30);
       
		b2.setBounds(650, 530, 180, 30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		add (l1);
		add(l2);
		add(t1);
		add(l7);
		add(t5);
		add(b1);
		add(l3);
		add(l4);
		
		add(l5); add(t2); add(l6); add(t3); add(l8); add(t4);
		
		add(b2);add(lbkg);
		
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
		String s= ae.getActionCommand();
		try
		{
		if  (s.equals("Update Step"))
		{
			int cs = Integer.parseInt(t1.getText());
			int es = Integer.parseInt(t5.getText());
			stm.executeUpdate("update dep_1 set curr_step = "+cs+", expect_step = "+es+" where order_id = "+id+"");
		}
		else if (s.equals("Update Material"))
		{
			int m4 = Integer.parseInt(t4.getText());
			int m2 = Integer.parseInt(t2.getText());
			int m3 = Integer.parseInt(t3.getText());
			stm.executeUpdate("update stock set qty_needed = qty_needed+"+m2+" where type = 2");
			stm.executeUpdate("update stock set qty_needed = qty_needed+"+m3+" where type = 3");
			stm.executeUpdate("update stock set qty_needed = qty_needed+"+m4+" where type = 4");
		}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
