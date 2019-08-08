package cdac;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.time.*;

public class login extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l55;
	JButton b1,b2;
	JTextField t1;
	JRadioButton r1,r2,r3,r4;
	JPasswordField p1;
	static Statement stm;
	int id1;
	String p="",c="",chota="";
	login(Statement stm)
	{
		this.stm=stm;
		setTitle("Welcome");
		
		setLayout(null);
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		
		l1 = new JLabel("UserID");
		l2 = new JLabel("Password");
		l3 = new JLabel("Create new customer account");
		l4 = new JLabel("Incorrect Password or User id. Try again");
		l55 = new JLabel("enter the category, userid and password");
		p1 = new JPasswordField(10);
		
		b1 = new JButton("Login");
		b2 = new JButton("Sign Up");
		
		t1 = new JTextField(50);
				
		r1 = new JRadioButton("Admin",false);
		r2 = new JRadioButton("Department Head",false);
		r3 = new JRadioButton("Customer",false);
		r4 = new JRadioButton("Supplier",false);
		
		ButtonGroup bg = new ButtonGroup();
		
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l55.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
	    t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		b1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		b2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		r1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		r2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		r3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		r4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		bg.add(r4);

		
		r1.setBounds(255,255,80,30);
		r2.setBounds(345,255,170,30);
		r3.setBounds(525,255,110,30);
		r4.setBounds(645,255,100,30);
				
		l1.setBounds(380,305,80,30);
		t1.setBounds(480,305,140,30);
		l2.setBounds(380,355,80,30);
		p1.setBounds(480,355,140,30);
		
		b1.setBounds(460,415,80,30);
		l3.setBounds(380,465,240,30);
		b2.setBounds(450,515,100,30);
		l4.setBounds(370,565,350,30);
		l55.setBounds(370,565,350,30);			
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		t1.addActionListener(this);
		
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		
		add(l1);add(l2);add(l3);
		add(r1);add(r2);add(r3);add(r4);
		add(b1);add(b2);
		add(t1);add(p1);	
	    
		setSize(1000,800);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
		add(l4);
		add(l55);
		add(lbkg);
		l4.setVisible(false);
		l55.setVisible(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		  String s = ae.getActionCommand();			 
		 if(ae.getSource()==b1)
		 {
		  String id = t1.getText();
		  if(id.equals(""))
			  l55.setVisible(true);
		  else {
			  id1 = Integer.parseInt(id);
			  String pass = String.copyValueOf(p1.getPassword());
			  ResultSet rs = stm.executeQuery("select * from login where userid = '"+id1+"'");
			  
			  while(rs.next())
			  {
				  p = rs.getString("password");
				  c = rs.getString("category");
			  }
			  if(p.equals("")||chota.equals("")||id.equals(""))
			  {
				  l55.setVisible(true);
			  }
			  else if(p.equals(pass) && chota.equals(c) && c.equals("Admin"))
			  {
			      new AdminPage();
			  }
			  else if(p.equals(pass) && chota.equals("Department Head") && (c.equals("dep1")))
			  {
				 new dep_order(stm, c);
			  }
			  else if(p.equals(pass) && chota.equals("Department Head") && c.equals("dep2"))
			  {
					new dep_order(stm, c);
			  }
			  else if(p.equals(pass) && chota.equals("Department Head") && c.equals("dep3"))
			  {
					 new dep_order(stm, c);
			  }
			  else if(p.equals(pass) && chota.equals(c) && c.equals("Customer"))
			  {
				  new Framecustomer(stm,id1);
			  }
			  else if(p.equals(pass) && chota.equals(c) && c.equals("Supplier"))
			  {
	              new supply(stm);		  
			  }
			 
			 
			  else
			  {
				  l55.setVisible(false);
				  l4.setVisible(true);
			  }
		  }

		 }
		 else if(ae.getSource()==b2)
		 {
			 new signup(stm);
		 }
		 else
			 chota = s;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) 
	{
		try 
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
		  stm = con.createStatement();
		} 
		catch (Exception e) 
		{
		 System.out.println(e);
		}
        login l = new login(stm);
	}
};

class Framecustomer extends JFrame
{	
	JTabbedPane tp;
	static Statement stm;
	int id;
	Framecustomer(Statement stm,int id) 
	{
		try
		{
			ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
			JLabel lbkg = new JLabel(imgi);
			lbkg.setBounds(0,0,1000,800);
		 this.stm = stm;
		 this.id = id;
	     setTitle("Customer");
		 Container con = getContentPane();		
		 tp = new JTabbedPane();		
		 tp.addTab("New Order", new norder(stm,id));
		 tp.addTab("Previous Order", new porder(stm,id));	
		 tp.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		 con.add(tp);
		//add(lbkg);
		 setSize(1000,800);
		 addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		 });
		 setVisible(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
};

class norder extends JPanel implements ActionListener
{
	JComboBox cb1,cb2;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1;
    JButton b1;
    Statement stm;
    String p="",m="",q="",total_cost="";
    int id,cost,qty,total=0;
    
    norder(Statement stm,int id)
	{
		this.stm = stm;
		this.id=id;
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		l1 = new JLabel("Select Product");
		l2 = new JLabel("Select Model");
		l3 = new JLabel("Quantity");
		l4 = new JLabel("Amount to be Paid");
		l5 = new JLabel("");		
		
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		
		t1 = new JTextField(50);
				
		b1 = new JButton("Place Order");
	
		cb1.addItem("-Select-");
		cb1.addItem("Product 1");
		cb1.addItem("Product 2");
		cb1.addItem("Product 3");
		
		cb2.addItem("-Select-");
		cb2.addItem("Model 1");
		cb2.addItem("Model 2");
		cb2.addItem("Model 3");
		
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		cb1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		cb2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		b1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		setLayout(null);
		
		l1.setBounds(365,255,150,30);
		cb1.setBounds(525,255,110,30); 
		l2.setBounds(365,305,150,30);  
		cb2.setBounds(525,305,110,30); 
		
		l3.setBounds(365,355,150,30); 
		t1.setBounds(525,355,110,30);
		l4.setBounds(365,405,150,30);
		l5.setBounds(525,405,110,30);
		b1.setBounds(435,455,130,30);
		
	    cb1.addActionListener(this);
        cb2.addActionListener(this);
        
        b1.addActionListener(this);
        
        t1.addActionListener(this);
        
        add(l1);
        add(l2);
        add(l3);
        add(l4);        
        add(cb1);
        add(cb2);       
        add(t1);
        add(b1);       
        add(l5);
        add(lbkg);
        l5.setVisible(false);
    }
	
	public void actionPerformed(ActionEvent ae)
	{
		LocalDate ld;
		try 
		{
		  p = String.valueOf(cb1.getSelectedItem());
		  m = String.valueOf(cb2.getSelectedItem());
		
		  ld=LocalDate.now();
		  String time = ""+ld;
		  if(ae.getSource()==b1)
		  {
		  	 if(p.equals("-Select-") || m.equals("-Select-"))
			 {
				JOptionPane jop = new  JOptionPane();
				jop.showMessageDialog(this, "Select The Product name and the Model number");
			 }
			 else
			 {
			  qty = Integer.parseInt(t1.getText());
              ResultSet rs = stm.executeQuery("select * from cost where product = '"+p+"' and modelno = '"+m+"' ");
              while(rs.next())
              {
            	cost = rs.getInt("costperunit");
            	total = (cost*qty);
              }
              total_cost = Integer.toString(total);
              l5.setText(total_cost);
              l5.setVisible(true);
              stm.executeUpdate("insert into order_details values (NULL,'"+p+"','"+m+"','"+qty+"',"+id+",'"+time+"',"+total+")");
			  JOptionPane jop = new JOptionPane();
jop.showMessageDialog(this,"Order Placed Successfully.\n Order Details:-\n Product - "+p+"\n Model - "+m+"\n Quantity - "+qty+"\n Amount to be paid - "+total_cost+" ");
		     }
	      }
	   }
		catch(Exception e) 
		{
	    	System.out.println(e);
	    }
    }
};

 class porder extends JPanel
 {
	 Statement stm;
	 int oid,qty,id;
	 String prod,model,date;
	 JTable table; 
	 JScrollPane js;
	 int v,h;
	 
	 porder(Statement stm,int id) throws Exception
	 {
		 try 
		 {
		  this.id=id;
		  this.stm=stm;
		  ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
			JLabel lbkg = new JLabel(imgi);
			lbkg.setBounds(0,0,1000,800);
		  setLayout(new FlowLayout());
		 
		  v = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
		  h = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		 
		  int i=0;
		  ResultSet r1 = stm.executeQuery("select count(*) from order_details where custid = "+id+" ");
		  while(r1.next())
		  {
			 i =r1.getInt("COUNT(*)");
		  }
     	 
		  Object data[][] = new Object [i][5];
 
		  ResultSet rs = stm.executeQuery("select * from order_details where custid = "+id+"");
		  String cname[]= {"Order id","Product","Model no","Quantity","Date"};
		  for(int j=0;j<i&&rs.next();j++)
		  {
        	data[j][0]=rs.getInt("orderid");
        	data[j][1]=rs.getString("product");
        	data[j][2]=rs.getString("modelno");
        	data[j][3]=rs.getInt("Quantity");
        	data[j][4]=rs.getString("date");
		  }
		  table = new JTable(data,cname);
		  js = new JScrollPane(table,v,h);
		  js.setPreferredSize(new Dimension(950,800));
		  table.setFont(new Font(Font.SANS_SERIF,Font.BOLD,10));
		  add(js);
		  add(lbkg);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }		
}; 
 






