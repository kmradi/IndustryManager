package cdac;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	
public class Customer extends JPanel
{
	String[] col_name = {"Customer ID","Name","Email","Phone no.","Number of orders","Order IDs"};
	Object[][] data;
	String str="";
	public Customer() 
	{
		dbmsWork();
		setLayout(new FlowLayout());
		setSize(1000,800);
		JTable jt = new JTable(data,col_name);
		JScrollPane jp = new JScrollPane(jt);
		jp.setPreferredSize(new Dimension(900,700));
		changeFont(jp);
		add(jp);
		setVisible(true);
	}
	@SuppressWarnings("resource")
	void dbmsWork()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/industry","root","tismysql");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login");
			String ctg; 
			int count = 0;
			while(rs.next())
			{
				ctg = rs.getString("category");
				if(ctg.equals("Customer"))
				{
					count++;
				}
			}
			data = new Object[count][7];
			rs.beforeFirst();
			int k =0,num_of_odr=0,rownum=0;
			while(rs.next())
			{
				rownum = rs.getRow();
				ctg = rs.getString("category");
				if(ctg.equals("Customer"))
				{
					data[k][0] = rs.getInt("userid");
					data[k][1] = rs.getString("name");
					data[k][2] = rs.getString("email");
					data[k][3] = rs.getLong("phoneno");
					int id = rs.getInt("userid");
					ResultSet rd = st.executeQuery("select * from order_details");
					while(rd.next())
					{
						if(rd.getInt("custid")==id)
						{
							int oid = rd.getInt("orderid");
							str = str + oid+",";
							num_of_odr++;
						}
					}
					if(str.length()>1 && str.charAt(str.length()-1)==',')
					{str = str.substring(0,str.length()-1);}
					data[k][4] = num_of_odr;
					data[k][5] = str;
					num_of_odr = 0;
					str = "";
					k++;
					rd.close();
				}
				rs = st.executeQuery("select * from login");
				rs.absolute(rownum);
			}
			rs.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
