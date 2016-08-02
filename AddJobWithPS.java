package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddJobWithPS {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr"))
		{
		
		  Scanner s = new Scanner(System.in);
		  System.out.print("Enter job id      : ");
		  String id = s.nextLine();
		  
		  System.out.print("Enter job title   : ");
		  String title  = s.nextLine();
		  
		  System.out.print("Enter min salary  : ");
		  String minsal = s.nextLine();
		  
		  System.out.print("Enter max salary  : ");
		  String maxsal = s.nextLine();
		  
		  PreparedStatement ps = con.prepareStatement("insert into jobs values (?,?,?,?)");
		  ps.setString(1,id);
		  ps.setString(2,title);
		  ps.setString(3,minsal);
		  ps.setString(4,maxsal);
		  ps.executeUpdate();
		  
          System.out.println("Added Job successfully!");
		}
		catch(Exception ex){
			System.out.println("Error : " + ex.getMessage());
		}
	}

}
