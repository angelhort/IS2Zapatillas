package integracion.dao.connection;

import java.sql.*;

public class TestConn2 {

   public static void main(String[] args) {
	   ConnectionAbstract c = ConnectionAbstract.getInstance();
	   
	   try {
		   Connection conn = c.createConn();
		   Statement st = conn.createStatement();
		   
		   String sql = "SELECT * FROM Clientes";
		   ResultSet rs = st.executeQuery(sql);
		   
		   while (rs.next()) {
			   int idCliente = rs.getInt("idCliente");
			   int dni = rs.getInt("dni");
			   String nombre = rs.getString("nombre");
			   
			   System.out.println(String.format("ID: %d  DNI: %d  Nombre: %s", 
					   								idCliente, dni, nombre));
		   }
		   
		   rs.close();
		   st.close();
		   conn.close();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
   }
}
