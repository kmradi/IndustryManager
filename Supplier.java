package cdac;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	
public class Supplier  extends JPanel
{
	String name,email;
	int phoneno;
	public Supplier()
	{
		dbmsWork();
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		setLayout(null);
		JLabel l1,l2,l3,l5,l6,l7;
		l1 = new JLabel("Supplier Name - "+name);
		l2 = new JLabel("email id      -   "+email);
		l3 = new JLabel("Phone Number  -  "+phoneno);
		changeFont(l1);changeFont(l2);changeFont(l3);
		l1.setBounds(200,200,400,40);
		l2.setBounds(200,300,400,40);
		l3.setBounds(200,400,400,40);
		add(l1);add(l2);add(l3);add(lbkg);
		setVisible(true);
	}
	void dbmsWork()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("select * from login where category = 'Supplier'");
			rs.next();
			name = rs.getString("name");
			email = rs.getString("email");
			phoneno = rs.getInt("phoneno");
			
		}catch (Exception e) { System.out.println(e);
		}
		
	}
	public void changeFont ( Component component )
	{
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,20);
	    component.setFont ( font );
	    if ( component instanceof Container )
	    {
	        for ( Component child : ( ( Container ) component ).getComponents () )
	        {
	            changeFont ( child );
	        }
	    }
	}
}
