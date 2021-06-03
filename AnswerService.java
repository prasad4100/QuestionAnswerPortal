import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AnswerService extends Connection1
{
	//3
	protected static void PostAnswer()
	{
		try 
		{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into answer values(?,?,?,?,?,'Non-usefull')");

		
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Answer ID : ");
			String answer_id = sn.nextLine();

			System.out.println("Answer : ");
			String answer = sn.nextLine();
			
			System.out.println("Date of Posting : ");
			String posted_date = sn.nextLine();
			
			System.out.println("Your Member ID : ");
			String member_id = sn.nextLine();
			
			System.out.println("Question ID : ");
			String question_id = sn.nextLine();

			sn.close();

			ps.setString(1, answer_id);
			ps.setString(2, answer);
			ps.setString(3, posted_date);
			ps.setString(4, member_id);
			ps.setString(5, question_id);
			
			int count = ps.executeUpdate();
			System.out.println("Count : " + count);
			System.out.println("Answer Posted successfully");
			con.close();
		}
		
		catch(Exception ex)
		{
		 ex.printStackTrace(); 
		}
		
	}
	
	
	
	
	
	
	//5
	public static void ShowAnswers()
	{

		try {

			Connection con = getConnection();
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Question ID ");
			String question_id = sn.next();


			sn.close();
			
			PreparedStatement pst = con.prepareStatement("select answer from answer where question_id = '" +question_id+ "'");

			ResultSet rs= pst.executeQuery();
			
		if (rs.next())
		{
				System.out.println("Question ID="+question_id);
				System.out.println("Following is the list of Answers to this Question..");
				
				PreparedStatement pstm = con.prepareStatement("select answer from answer where question_id = '" +question_id+"'");

				ResultSet rst= pstm.executeQuery();

				while(rst.next())
				{
					System.out.print(rst.getString("answer")+"\t");
				}
				
				
		}
		
		else
		{
			System.out.println("Please check your Question ID or No one Answered yet..");
		}
			
		
			con.close();
		  
			
		}	
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	
	}
	
	
	//8
	public static void UpdateAnswerStatus()
	{
		
		
		try {
			Connection con = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Answer ID");
			String answer_id = sc.next();
			
			System.out.println("Enter Member ID");
			String member_id = sc.next();
			
			PreparedStatement ps = con.prepareStatement("select * from answer where answer_id= '"+answer_id+"' and member_id='"+member_id+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Change Answer Status Here :");
				String status = sc.next();
				sc.close();
				PreparedStatement ps1 = con.prepareStatement("UPDATE answer SET a.status = '"+status+"' from question q, answer a WHERE q.question_id = a.question_id and a.answer_id = '"+answer_id+"' and q.member_id = '"+member_id+"'");
				int count = ps1.executeUpdate();
				//System.out.println("Count : " + count);
				ps1.close();
				con.close();
				System.out.println("Answer Status Updated");
				
			}
			
			else
			{
				System.out.println("Invalid input");
			}
		}
		
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	
	}
	
	
	
}
