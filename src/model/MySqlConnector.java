package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySqlConnector {
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/assignment2";
	
	static final String USER="root";
	static final String	PASS="studentii din cluj";
	
	public Connection connection;
	public static MySqlConnector db;
	
	public MySqlConnector() {
		try {
			System.out.println("Connecting to database...");
		connection = DriverManager.getConnection(DB_URL,USER,PASS);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized MySqlConnector getConnection() {
		if (db==null) {
			db=new MySqlConnector();
		}
		return db;	

}

public static void main( String[] args )
{
	
	MySqlConnector conexiune=MySqlConnector.getConnection();
}

public PreparedStatement prepareStatement(String statement) {
	// TODO Auto-generated method stub
	return null;
}
}
