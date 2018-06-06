package textfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Flatfile 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	    String sno;
	    String id;
	    String name;
	    String city;
	    String mobilenum;
	    PreparedStatement ps = null;
	    Connection con = null;
	    ResultSet rs = null;

	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
	        String username ="postgres";
	        String pwd = "elghorrim";
	        String connurl = "jdbc:postgresql://localhost:5432/BDS_CSF_AuqliteEau";

	        con = DriverManager.getConnection(connurl, username, pwd);
	        Class.forName("org.postgresql.Driver");

	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            sno = tmp[0];
	            id = tmp[1];
	            name = tmp[2];
	            city = tmp[3];
	            mobilenum = tmp[4];

	            System.out.println(sno + "\t" + id + "\t" + name + "\t" + city + "/t" + mobilenum);
	            String sql =
	                    "INSERT INTO resultant (sno_resultant,id,name_pc,code_city,mobilenum_resultant) values ('"
	                            + sno + "','" + id + "','" + name + "','" + city+ "','" + mobilenum +
	                            "')";

	            ps = con.prepareStatement(sql);
	            ps.executeUpdate();
	        }

	        br.close();
	        con.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
	}



