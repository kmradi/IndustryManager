package cdac;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	
public class Stock extends JPanel
{
	Object data[][];
	String col_name[]= {"Material category","Quantity Present","Quantity Required"};;
	public Stock() 
	{
		backend();
		setLayout(new FlowLayout());
		JTable jt = new JTable(data,col_name);
		JScrollPane sp = new JScrollPane(jt);
		changeFont(sp);
		sp.setPreferredSize(new Dimension(900,700));
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		add(sp);
		setVisible(true);
	}
	private void backend()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from stock");
			rs.last();
			data = new Object[rs.getRow()][3];
			rs.beforeFirst();
			int k =0;
			while(rs.next())
			{
				data[k][0] = rs.getInt(1);
				data[k][1] = rs.getInt(2);
				data[k][2] = rs.getInt(3);
				k++;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
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
