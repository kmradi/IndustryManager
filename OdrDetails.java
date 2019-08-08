package cdac;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.ChangedCharSetException;	
public class OdrDetails extends JPanel
{
	String tot_odr;
	Object data[][];
	String col_name[] = {"Order ID","Department 1","Department 2","Department 3"};
	OdrDetails() 
	{
		
		backend();
		ImageIcon imgi = new ImageIcon("D:\\misc\\bkgcdac.jpg");
		JLabel lbkg = new JLabel(imgi);
		lbkg.setBounds(0,0,1000,800);
		JLabel l1 = new JLabel(tot_odr);
		setLayout(new FlowLayout());
		JPanel jp = new JPanel();
		
		jp.setBounds(0,0,1000,50);
		jp.setLayout(new FlowLayout());
		jp.add(l1);
		
		changeFont(jp);
		add(jp);	
		JTable jt = new JTable(data,col_name);
		jt.setSize(900,950);
		JScrollPane scrollpane = new JScrollPane(jt);
		changeFont(scrollpane);
		scrollpane.setPreferredSize(new Dimension(900,600));
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        scrollpane.add(lbkg);
		add(scrollpane);
		add(lbkg);
		setVisible(true);
	}
	public void backend() 
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from order_details");
		rs.last();
		int k = 0;
		data = new Object[rs.getRow()][4];
		tot_odr = "Total number of orders in processing is "+rs.getRow();
		ResultSet rd1 = st.executeQuery("select * from dep_1");
		while(rd1.next())
		{
			data[k][0] = rd1.getInt(1);
			int cs = rd1.getInt(2);
			int es = rd1.getInt(3);
			if(cs<es)
				data[k][1] = "Behind Schedule";
			else 
				data[k][1] = "On time";
			k++;
		}
		k=0;
		ResultSet rd2 = st.executeQuery("select * from dep_2");
		while(rd2.next())
		{
			
			int cs = rd2.getInt(2);
			int es = rd2.getInt(3);
			if(cs<es)
				data[k][2] = "Behind Schedule";
			else 
				data[k][2] = "On time";
			k++;
		}
		k=0;
		ResultSet rd3 = st.executeQuery("select * from dep_3");		
		while(rd3.next())
		{
			int cs = rd3.getInt(2);
			int es = rd3.getInt(3);
			if(cs<es)
				data[k][3] = "Behind Schedule";
			else 
				data[k][3] = "On time";
			k++;
		}
		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void changeFont ( Component component )
	{
		Font font = new Font(Font.SANS_SERIF,Font.PLAIN,15);
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
