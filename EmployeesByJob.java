package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeesByJob {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter job id :");
		String jobid = s.nextLine();

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")) {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery
					("select first_name, salary from employees where job_id = '" + jobid + "'");

			while (rs.next()) {
				System.out.println(rs.getString(1) + " - " + rs.getInt(2));
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
