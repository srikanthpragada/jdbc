package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateSalary {

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter employee id :");
		int empid = s.nextInt();
		System.out.print("Enter New Salary :");
		int salary = s.nextInt();

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr")) {
			PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
			ps.setInt(1, salary);
			ps.setInt(2, empid);
			
			if ( ps.executeUpdate() == 1)
				System.out.println("Done");
			else
				System.out.println("Employee Not Found");
		}
		catch(Exception ex) {
			System.out.println("Sorry! Error : " + ex.getMessage());
		}

	}
}
