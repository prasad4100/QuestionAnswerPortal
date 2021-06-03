
import java.sql.Connection;


import java.sql.DriverManager;

public class Connection1
{
public static Connection getConnection() 
	{
		Connection con = null;
		try {
			
			PropertiesLoader loader=new PropertiesLoader();
			Class.forName(loader.getValues("driver"));
			//System.out.println("checking1");
			con = DriverManager.getConnection(loader.getValues("url"),loader.getValues("username"),loader.getValues("password"));
			System.out.println("Connection successful");
			} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return con;
	}
}