package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AddJob {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr"))
		{
		  Statement st = con.createStatement();
		  Scanner s = new Scanner(System.in);
		  System.out.print("Enter job id      : ");
		  String id = s.nextLine();
		  
		  System.out.print("Enter job title   : ");
		  String title  = s.nextLine();
		  
		  System.out.print("Enter min salary  : ");
		  String minsal = s.nextLine();
		  
		  System.out.print("Enter max salary  : ");
		  String maxsal = s.nextLine();
		  
		  String cmd  = "insert into jobs values ('" + id + "','" + title + "'," + minsal + "," + maxsal + ")";
		  System.out.println("Executing ... " + cmd);
		  st.executeUpdate(cmd);
          System.out.println("Added Job successfully!");
		}
		catch(Exception ex){
			System.out.println("Error : " + ex.getMessage());
		}
	}

}
