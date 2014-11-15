import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	
	public static ArrayList<String> findEvents(ArrayList<String> tags) {
		
		/**
		 * returns an ArrayList of event names from the database which contain the tags specified in the 
		 * tags parameter.
		 */
	
		try {
		ArrayList<String> events = new ArrayList<String>();
		Connection connection = getConnection();
	
			
			for (Integer i = 1; i <= 3; i++){
				for (String tag : tags) {
				
					String selectStatement = "select EVENTNAME from EVENTS where TAG" + i.toString() +"=";
					Statement sqlStatement = connection.createStatement();
					ResultSet resultSet = sqlStatement.executeQuery(selectStatement + "'" + tag + "'");
				
					while(resultSet.next()) {
						if(searchList(events, resultSet.getString(1)) == false) {
								events.add(resultSet.getString(1));
						}
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
	
	
	public static String getLocation(String event) {
		
		
		try {
			
			ArrayList<String> location = new ArrayList<String>();
			Connection connection = getConnection();				
			String selectStatement = "select LOCATION from EVENTS where EVENTNAME='"+ event +"'";
			Statement sqlStatement = connection.createStatement();
			ResultSet resultSet = sqlStatement.executeQuery(selectStatement);
				
			while(resultSet.next()) {
						 
				location.add(resultSet.getString(1));
						
			}
				
		return location.get(0);
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		return null;
	}
	
	public static String getTime(String event) {
		
		try {
			
			ArrayList<String> time = new ArrayList<String>();
			Connection connection = getConnection();				
			String selectStatement = "select EVENTTIME from EVENTS where EVENTNAME='"+ event +"'";
			Statement sqlStatement = connection.createStatement();
			ResultSet resultSet = sqlStatement.executeQuery(selectStatement);
				
			while(resultSet.next()) {
						 
				time.add(resultSet.getString(1));
						
			}
				
		return time.get(0);
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		return null;
		
	}
	
	public static ArrayList<String> getTags(String event) { //not currently working
		

		
		try {
			
			ArrayList<String> tags = new ArrayList<String>();
			Connection connection = getConnection();
			for (Integer i = 1; i <=3;) {
				String selectStatement = "select TAG"+ i.toString() + " from EVENTS where EVENTNAME='"+ event +"'";
				Statement sqlStatement = connection.createStatement();
				ResultSet resultSet = sqlStatement.executeQuery(selectStatement);
				
				while(resultSet.next()) {
						 
					tags.add(resultSet.getString(3));
						
				}
				i++;
			}
				
		return tags;
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		return null;

		
	}
	
	public static String getCost(String event) {
		
		try {
			
			ArrayList<Double> cost = new ArrayList<Double>();
			Connection connection = getConnection();				
			String selectStatement = "select COST from EVENTS where EVENTNAME='"+ event +"'";
			Statement sqlStatement = connection.createStatement();
			ResultSet resultSet = sqlStatement.executeQuery(selectStatement);
				
			while(resultSet.next()) {
						 
				cost.add(resultSet.getDouble(1));
						
			}
			
			String costString = "$" + cost.get(0);
		return costString;
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		return null;

		
	}
	
	public static String getInfo(String event) {
		
		try {
			
			ArrayList<String> info = new ArrayList<String>();
			Connection connection = getConnection();				
			String selectStatement = "select INFO from EVENTS where EVENTNAME='"+ event +"'";
			Statement sqlStatement = connection.createStatement();
			ResultSet resultSet = sqlStatement.executeQuery(selectStatement);
				
			while(resultSet.next()) {
						 
				info.add(resultSet.getString(1));
						
			}
				
		return info.get(0);
		
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}	
		
		return null;

		
	}
	
	private static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			String connectionString = "jdbc:hsqldb:hsql://localhost:9001";
			connection = DriverManager.getConnection(connectionString);
			
		} catch (SQLException e) {
			
			System.out.println(e.getStackTrace());
			
		}
		
		return connection;
		
	}
	
	private static Boolean searchList(ArrayList<String> list, String item) {
		
		for (String i : list) {
			if (i == item) {
				return true;
			}
		}
		return false;
	}
	
}
