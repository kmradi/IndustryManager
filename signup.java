package cdac;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class signup extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3;
	JPasswordField p1,p2;
	JButton b1;
	static Statement stm;
	int id = 0;
	
	signup(Statement stm)
	{
		this.stm=stm;
		setTitle("Sign Up");	
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		l1 = new JLabel("Name");
		l2 = new JLabel("Password");
		l3 = new JLabel("Confirm Password");
		l4 = new JLabel("Phone No.");
		l5 = new JLabel("E-Mail");
		l6 = new JLabel("Password and Confirm Password do not match.");
		
		t1 = new JTextField(50);
		p1 = new JPasswordField(10);
		p2 = new JPasswordField(10);
		t2 = new JTextField(50);
		t3 = new JTextField(50);
		
		b1 = new JButton("Submit");
		
		l1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l4.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l5.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		l6.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		t1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t2.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		t3.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		b1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,18));
		
		setLayout(null);
		
		l1.setBounds(330,240,150,30);
		t1.setBounds(490,240,180,30);
		
		l2.setBounds(330,290,150,30);
		p1.setBounds(490,290,180,30);
		
		l3.setBounds(330,340,150,30);
		p2.setBounds(490,340,180,30);
		
		l4.setBounds(330,390,150,30);
		t2.setBounds(490,390,180,30);
		
		l5.setBounds(330,440,150,30);
		t3.setBounds(490,440,180,30);
		
		b1.setBounds(455,490,90,30);
		
		l6.setBounds(310,540,380,40);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		t3.addActionListener(this);
		
		b1.addActionListener(this);
		
		add(l1);add(l2);add(l3);add(l4);add(l5);
		add(t1);add(p1);add(p2);add(t2);add(t3);
		add(b1);
		
		setSize(1000,800);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				dispose();
			}
		});
		this.add(l6);
		add(lbkg);
		l6.setVisible(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String n="",p="",cp="",em="",ph="";
		long phn;
		try
		{
		 String s = ae.getActionCommand();
		 if(s.equals("Submit"))
		 {
			 n = t1.getText();
			 p = String.copyValueOf(p1.getPassword());
			 cp = String.copyValueOf(p2.getPassword());
			 ph = t2.getText();
			 phn = Long.parseLong(ph);
			 em = t3.getText();
			
			 if(p.equals(cp))
			 {
				 stm.executeUpdate("insert into login values(null,'"+p+"','Customer','"+n+"','"+phn+"','"+em+"')");
				 ResultSet rs = stm.executeQuery("select * from login where password = '"+p+"' ");
			     while(rs.next())
			     {
				  id = rs.getInt("userid");
			     }
			  JOptionPane jop = new JOptionPane();
			  jop.showMessageDialog(this,"Account Created Successfully. \nYour UserId is " + id+"\nRemember id for future use...");
			  setVisible(false);
			 }
			 else
			 {
				 l6.setVisible(true);
			 }
		     
		 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        signup s = new signup(stm);
	}

}
