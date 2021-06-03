import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MemberService extends Connection1
{
	//1
	public static void RegisterNewMember()
	{
		try 
		{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into member values(?,?,?,?,'Active')");

		
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Member ID : ");
			String member_id = sn.next();

			System.out.println("Enter Name : ");
			String name = sn.next();

			System.out.println("Enter Email ID : ");
			String email = sn.next();
			
			System.out.println("Enter Password : ");
			String password = sn.next();

			sn.close();

			ps.setString(1, member_id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, password);
			
			int count = ps.executeUpdate();
			System.out.println("Count : " + count);
			System.out.println("New Member registered successfully");
			con.close();
		}
		
		catch(Exception ex)
		{
		 ex.printStackTrace(); 
		}
		
		
		
		
	}
	
	
	
	
}