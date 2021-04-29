package integracion.connection;

import java.sql.*;

public class DatabaseConnection {
	
	public static final String DB_URL = "jdbc:mysql://db4free.net/zapatillas";
	public static final String USERNAME = "zapatillas";
	public static final String PASSWORD = "zapatillas";
	
	public DatabaseConnection() {
		// Empty
	}

	public static Connection getConnection() {
		try {			
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			return (conn != null) ? conn : null;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}