package integracion.dao.connection;

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
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
			return (conn != null) ? conn : null;
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}