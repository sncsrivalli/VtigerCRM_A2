package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains reusable methods to read or write to database
 * @author Srivalli
 */
public class DatabaseUtility {

	Connection connection;
	Statement statement;
	
	/**
	 * This method initializes database connection
	 * @param jdbcUrl
	 * @param username
	 * @param password
	 */
	public void databaseInit(String jdbcUrl, String username, String password) {
		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method reads data from database
	 * @param query
	 * @param columnName
	 * @return List<Object>
	 */
	public List<Object> readFromDatabase(String query, String columnName) {
		ResultSet result = null;
		List<Object> list = new ArrayList<Object>();
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(result.next()) {
				list.add(result.getObject(columnName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * This method modifies the database
	 * @param query
	 * @return int
	 */
	public int modifyDatabase(String query) {
		int result = 0;
		try {
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * This method closes database connection
	 */
	public void closeDatabase() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
