package cdac;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class supply extends JFrame
{
	String t;
	int q1,q2;
	static Statement stm;
	JTable table;
	JScrollPane js;
	int finalqty;
	supply(Statement stm) throws Exception
	{
		setTitle("Supply");
		ImageIcon imgi = new ImageIcon("bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		this.stm=stm;
		setLayout(new FlowLayout());
		int v=JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		ResultSet rs=stm.executeQuery( "select * from stock");
		Object data[][] = new Object [3][2];
		String cname[]= {"Type of Product","Quantity Required"};
		
		for(int j=0;j<3&&rs.next();j++)
		{
			 q1=rs.getInt("qty_present");
		     q2=rs.getInt("qty_needed");	
		     if((q1-q2)<0)
		     {
			 finalqty = q2-q1;
			 data[j][0]=rs.getString("type");
		     data[j][1]=finalqty;
		     }
		     else
		     j--;
		}
		table = new JTable(data,cname);
		js = new JScrollPane(table,v,h);
		js.setPreferredSize(new Dimension(900,700));
		changeFont(js);
		add(js);
		
		setSize(1000,800);
		setDefaultCloseOperation(2);
		add(lbkg);
		setVisible(true);
		
	}
	
//	public static void main(String[] args) {
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
//		Statement stm=con.createStatement();
//        supply s =new supply(stm);
//	}
//	catch(Exception e)
//	{
//		System.out.println(e);
//	}
	public void changeFont ( Component component )
	{
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,16);
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

