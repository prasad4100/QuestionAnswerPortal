import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class QuestionService extends Connection1
{
	
	//2
	protected static void PostQuestion()
	{
		try 
		{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?,?,'Un-Solved')");

		
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Question ID : ");
			String question_id = sn.nextLine();
			
			System.out.println("Question : ");
			String question = sn.nextLine();
			
			System.out.println("Description : ");
			String desc1 = sn.nextLine();
			
			System.out.println("Date of Posting : ");
			String posted_date = sn.nextLine();
			
			System.out.println("Your Member ID : ");
			String member_id = sn.nextLine();

			sn.close();

			ps.setString(1, question_id);
			ps.setString(2, question);
			ps.setString(3, desc1);
			ps.setString(4, posted_date);
			ps.setString(5, member_id);
			
			int count = ps.executeUpdate();
			System.out.println("Count : " + count);
			System.out.println("Question Posted successfully");
			con.close();
		}
		
		catch(Exception ex)
		{
		 ex.printStackTrace(); 
		}
		
	}
	
	
	
	//4
	public static void ShowAllQuestions()
	{
		
		try {

			Connection con = getConnection();
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Your Member ID ");
			String member_id = sn.next();


			sn.close();
			
			PreparedStatement pst = con.prepareStatement("select * from member where member_id = '" +member_id+ "'");

			ResultSet rs= pst.executeQuery();
			
		if (rs.next())
		{
				System.out.println("Welcome"+member_id);
				System.out.println("Following is the list of Questions..");
				
				PreparedStatement pstm = con.prepareStatement("select question from question");

				ResultSet rst= pstm.executeQuery();

				while(rst.next())
				{
					System.out.print(rst.getString("question")+"\t");
				}
				
		}
		
		else
		{
			System.out.println("Please check your Member ID or Register");
		}
			
		
			con.close();
		  
			
		}	
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
			
	}
	
	
	//6
	public static void ShowQuestionAnswers()
	{

		try {

			Connection con = getConnection();
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Question ID ");
			String question_id = sn.next();


			sn.close();
			
			PreparedStatement pst = con.prepareStatement("select q.question,a.answer from question q,answer a where q.question_id = a.question_id and a.question_id = '" +question_id+ "' ");

			ResultSet rs= pst.executeQuery();
			
		if (rs.next())
		{
				System.out.println("Question ID="+question_id);
				System.out.println("Following is the list of Answers to this Question..");
				
				PreparedStatement pstm = con.prepareStatement("select q.question,a.answer from question q,answer a where q.question_id = a.question_id and a.question_id = '" +question_id+ "' ");

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
	
	
	//9
	public static void ShowQuestionAnswersName()
	{

		try {

			Connection con = getConnection();
			
			Scanner sn = new Scanner(System.in);

			System.out.println("Enter Question ID ");
			String question_id = sn.next();


			sn.close();
			
			PreparedStatement pst = con.prepareStatement("select m.name,q.question,a.answer from member m ,question q,answer a where m.member_id = q.member_id and q.question_id = a.question_id and a.question_id = '" +question_id+ "' ");

			ResultSet rs= pst.executeQuery();
			
		if (rs.next())
		{
				
				PreparedStatement pstm = con.prepareStatement("select m.name,q.question,a.answer from member m ,question q,answer a where m.member_id = q.member_id and q.question_id = a.question_id and a.question_id = '" +question_id+ "' ");

				ResultSet rst= pstm.executeQuery();

				while(rst.next())
				{
					System.out.println("Question asked by:");
					System.out.print(rst.getString("name")+"\n");
					System.out.print(rst.getString("question")+"\n");	
					System.out.print(rst.getString("answer")+"\n");
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
	
	
	//7
	public static void UpdateQuestionStatus()
	{
		
		
		try {
			Connection con = getConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Question ID");
			String question_id = sc.next();
			
			System.out.println("Enter Member ID");
			String member_id = sc.next();
			
			PreparedStatement ps = con.prepareStatement("select * from question where question_id= '"+question_id+"' and member_id='"+member_id+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Change Question Status Here :");
				String status = sc.next();
				sc.close();
				PreparedStatement ps1 = con.prepareStatement("UPDATE question SET status = '"+status+"' WHERE question_id = '"+question_id+"' and member_id = '"+member_id+"'");
				int count = ps1.executeUpdate();
				//System.out.println("Count : " + count);
				ps1.close();
				con.close();
				System.out.println("Question Status Updated");
				
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
