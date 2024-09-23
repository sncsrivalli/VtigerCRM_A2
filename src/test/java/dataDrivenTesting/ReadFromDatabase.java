package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadFromDatabase {

	public static void main(String[] args) throws SQLException {
		// Step 1: Create instance for database driver
		Driver dbDriver = new Driver();

		// Step 2: Register Driver to JDBC
		DriverManager.registerDriver(dbDriver);

		// Step 3: Establish JDBC connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel_a2", 
																			"root", "root");

		// Step 4: Create statement
		Statement statement = connection.createStatement();

		// Step 5: Execute Query
		ResultSet result = statement.executeQuery("select * from employee;");

		while (result.next()) {
			System.out.println(result.getInt("ID") + "\t" + result.getString("Name") + "\t" 
					+ result.getString("Phone") + "\t" + result.getInt("Salary"));
		}

		// Step 6: Close database connection
		connection.close();
	}

}
