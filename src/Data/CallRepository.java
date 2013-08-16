package Data;

import java.sql.*;
import java.util.ArrayList;

import logic.Caller;

public class CallRepository {
	private static java.sql.Connection connection = null;
	private static ResultSet resultSet = null;
	private static Statement statement = null;
	
	public static ArrayList<Caller> LoadCalls(){
		ArrayList<Caller> collection = new ArrayList<>();
		try{
			
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Contacts.sqlite3");
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM 'main'.Log");
			
			while(resultSet.next())
			{
				Caller c = new Caller();
				c.setID(Integer.parseInt(resultSet.getString("id")));
				c.setCustomerName(resultSet.getString("CustomerName"));
				c.setStartTime(resultSet.getDate("StartTime"));
				c.setEndTime(resultSet.getDate("EndTime"));
				c.setNote(resultSet.getString("Note"));
				
				collection.add(c);
			}
			
			
		}catch(Exception e)
		{
			
		}
		
		return collection;
	}
	
	public static boolean AddCall(Caller c)
	{
		try{
			
			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:Contacts.sqlite3");
			
			statement = connection.createStatement();
			
			StringBuilder values = new StringBuilder();
			
			values.append("VALUES(");
			values.append(c.getStartTime().getTime() + ",");
			values.append(c.getEndTime().getTime() + ",");
			values.append("'" + c.getNote() + "',");
			values.append("'" + c.getCustomerName() + "')");
			
			String insertStmt = "INSERT INTO 'main'.Log('StartTime','EndTime','Notes','CustomerName') " + values.toString();
			
			int result = statement.executeUpdate(insertStmt);
			
			return result == 1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
