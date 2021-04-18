package integracion.dao.connection;

import java.sql.*;
import java.sql.DriverManager;

public class ConnectionImpl extends ConnectionAbstract {
	
	public static final String DB_URL = "jdbc:mysql://db4free.net/zapatillas";
	public static final String USERNAME = "zapatillas";
	public static final String PASSWORD = "zapatillas";
	
	public ConnectionImpl() {
		super.URL = DB_URL;
		super.USER = USERNAME;
		super.PASS = PASSWORD;
		
		createConn();
	}

	@Override
	public Connection createConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			super.conn = DriverManager.getConnection(super.URL, super.USER, super.PASS);
			
			return (conn != null) ? super.conn : null;
		}catch (Exception e) {
			System.err.println(String.format("Exception ocurred: %s", e));
		}
		
		return null;
	}
}