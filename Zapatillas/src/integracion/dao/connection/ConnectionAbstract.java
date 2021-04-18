package integracion.dao.connection;

import java.sql.*;

public abstract class ConnectionAbstract {
	private static ConnectionAbstract instance;
	
	String URL;
	String USER;
	String PASS;
	
	Connection conn = null;
	
	public static ConnectionAbstract getInstance() {
		if (instance == null) instance = new ConnectionImpl();
		return instance;
	}
	
	public abstract Connection createConn();

}
