package integracion.connection;

import java.sql.*;

public class DatabaseConnection {
	
	//public static final String DB_URL = "jdbc:mysql://db4free.net/zapatillas";
	//public static final String USERNAME = "zapatillas";
	//public static final String PASSWORD = "zapatillas";
	public static final String DB_URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11412469";
	public static final String USERNAME = "sql11412469";
	public static final String PASSWORD = "uW94nI67ke";
	
	public DatabaseConnection() {
		// Empty
	}

	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println(conn);
			return (conn != null) ? conn : null;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void killConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}