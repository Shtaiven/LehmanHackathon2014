import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	public static ArrayList<String> tagSearch(ArrayList<String> tags, Integer index) {
	
		try {
		ArrayList<String> events = new ArrayList<String>();
		Connection connection = getConnection();
	
			
			for (Integer i = 1; i <= 3; i++){
				for (String tag : tags) {
				
					String selectStatement = "select EVENTNAME from EVENTS where TAG" + index.toString() +"=";
					Statement sqlStatement = connection.createStatement();
					ResultSet resultSet = sqlStatement.executeQuery(selectStatement + "'" + tag + "'");
				
					while(resultSet.next()) {
						
//						for (String event: events) {
					
//						}
						events.add(resultSet.getString(1));
					}
				}
			}

		return events;
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		ArrayList<String> events = new ArrayList<String>();
		return events;
	}
	
	private static Connection getConnection() {
		Connection connection = null;
		try {
			String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
			connection = DriverManager.getConnection(connectionString);
		}
		catch (SQLException e) {
			System.out.println(e.getStackTrace());
		}
		return connection;
	}
	

	
}
