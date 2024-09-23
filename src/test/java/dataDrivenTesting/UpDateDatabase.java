package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpDateDatabase {

	public static void main(String[] args) throws SQLException {
		// Step 1: Establish JDBC connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel_a2", 
																			"root", "root");

		// Step 2: Create statement
		Statement statement = connection.createStatement();
		
		// Step 3: Execute update query
		int result = statement.executeUpdate("insert into employee (ID, Name, Phone, Salary) values (105, 'EFG', '9867452301',45000);");
		System.out.println(result);
		
		// Step 4: Close database
		connection.close();
	}

}
