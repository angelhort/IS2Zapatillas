package integracion.dao.producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import integracion.connection.DatabaseConnection;
import negocio.producto.TransferCalcetines;
import negocio.producto.TransferZapatillas;

// TODO: idAlmacen e idMarca no está bien 

public class DAOProductoImp implements DAOProducto{

	@Override
	public int alta(TransferZapatillas transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "INSERT INTO Productos(color, talla, stock, nombre, precio, tipo, idAlmacen, idMarca, tipoProducto)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, transfer.getColor());
			statement.setInt(2, transfer.getTalla());
			statement.setInt(3, transfer.getStock());
			statement.setString(4, transfer.getNombre());
			statement.setDouble(5, transfer.getPrecio());
			statement.setString(6, transfer.getTipo());
			statement.setInt(7, transfer.getAlmacen());
			statement.setInt(8,  transfer.getMarca());
			statement.setInt(9, 0);
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int alta(TransferCalcetines transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "INSERT INTO Productos(color, talla, stock, nombre, precio, tejido, idAlmacen, idMarca, tipoProducto)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, transfer.getColor());
			statement.setInt(2, transfer.getTalla());
			statement.setInt(3, transfer.getStock());
			statement.setString(4, transfer.getNombre());
			statement.setDouble(5, transfer.getPrecio());
			statement.setString(6, transfer.getTejido());
			statement.setInt(7, transfer.getAlmacen());
			statement.setInt(8,  transfer.getMarca());
			statement.setInt(9, 1);
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public int bajaProducto(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Productos SET activo=? WHERE idProducto=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setBoolean(1, false);
			statement.setInt(2, ID);
			
			result = statement.executeUpdate(); // Number of updated rows
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	/*@Override
	public int bajaZapatillas(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Productos SET activo=? WHERE idProducto=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setBoolean(1, false);
			statement.setInt(2, ID);
			
			result = statement.executeUpdate(); // Number of updated rows
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	
	@Override
	public int bajaCalcetines(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Productos SET activo=? WHERE idProductos=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setBoolean(1, false);
			statement.setInt(2, ID);
			
			result = statement.executeUpdate(); // Number of updated rows
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}*/

	@Override
	public int modificar(TransferZapatillas transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Productos SET color=?, talla=?, stock=?, nombre=?, precio=?, tipo=?, "
						+ "idAlmacen=?, idMarca=?, activo=? WHERE idProducto=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setString(1, transfer.getColor());
			statement.setInt(2, transfer.getTalla());
			statement.setInt(3, transfer.getStock());
			statement.setString(4, transfer.getNombre());
			statement.setDouble(5, transfer.getPrecio());
			statement.setString(6, transfer.getTipo());
			statement.setInt(7, transfer.getAlmacen());
			statement.setInt(8,  transfer.getMarca());
			statement.setBoolean(9, transfer.getActivo());
			statement.setInt(10, transfer.getID());
			
			result = statement.executeUpdate();
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int modificar(TransferCalcetines transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Productos SET color=?, talla=?, stock=?, nombre=?, precio=?, tejido=?, "
						+ "idAlmacen=?, idMarca=?, activo=? WHERE idProducto=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setString(1, transfer.getColor());
			statement.setInt(2, transfer.getTalla());
			statement.setInt(3, transfer.getStock());
			statement.setString(4, transfer.getNombre());
			statement.setDouble(5, transfer.getPrecio());
			statement.setString(6, transfer.getTejido());
			statement.setInt(7, transfer.getAlmacen());
			statement.setInt(8,  transfer.getMarca());
			statement.setBoolean(9, transfer.getActivo());
			statement.setInt(10, transfer.getID());
			
			result = statement.executeUpdate();
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Object getProducto(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String query = String.format("SELECT * FROM Productos WHERE idProducto = %d", ID);
		
		Object producto = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				if (resultSet.getInt("tipoProducto") == 0) 
					producto = new TransferZapatillas(resultSet.getInt("idZapatillas"),
														   resultSet.getInt("talla"),
														   resultSet.getDouble("precio"),
														   resultSet.getString("nombre"),
														   resultSet.getString("color"),
														   resultSet.getString("tipo"),
														   resultSet.getInt("stock"),
														   resultSet.getInt("idAlmacen"),
														   resultSet.getInt("idMarca"),
														   resultSet.getBoolean("activo"));
				else
					producto = new TransferCalcetines(resultSet.getInt("idZapatillas"),
														   resultSet.getInt("talla"),
														   resultSet.getDouble("precio"),
														   resultSet.getString("nombre"),
														   resultSet.getString("color"),
														   resultSet.getString("tejido"),
														   resultSet.getInt("stock"),
														   resultSet.getInt("idAlmacen"),
														   resultSet.getInt("idMarca"),
														   resultSet.getBoolean("activo"));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return producto;
	}
	
	/*@Override
	public TransferZapatillas getZapatillas(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String query = String.format("SELECT * FROM Productos WHERE idProducto = %d", ID);
		
		TransferZapatillas zapatilla = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				zapatilla = new TransferZapatillas(resultSet.getInt("idZapatillas"),
												   resultSet.getInt("talla"),
												   resultSet.getDouble("precio"),
												   resultSet.getString("nombre"),
												   resultSet.getString("color"),
												   resultSet.getString("tipo"),
												   resultSet.getInt("stock"),
												   resultSet.getInt("idAlmacen"),
												   resultSet.getInt("idMarca"),
												   resultSet.getBoolean("activo"));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return zapatilla;
	}

	@Override
	public TransferCalcetines getCalcetines(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String query = String.format("SELECT * FROM Productos WHERE idProducto = %d", ID);
		
		TransferCalcetines calcetin = null;

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				calcetin = new TransferCalcetines(resultSet.getInt("idCalcetines"),
												   resultSet.getInt("talla"),
												   resultSet.getDouble("precio"),
												   resultSet.getString("nombre"),
												   resultSet.getString("color"),
												   resultSet.getString("tejido"),
												   resultSet.getInt("stock"),
												   resultSet.getInt("idAlmacen"),
												   resultSet.getInt("idMarca"),
												   resultSet.getBoolean("activo"));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return calcetin;
	}*/
	

	@Override
	public List<Object> getAllProductos() {
		Connection conn = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Productos";
		
		List<Object> productos = new ArrayList<>();

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				if (resultSet.getInt("tipoProducto") == 0) 
					productos.add(new TransferZapatillas(resultSet.getInt("idZapatillas"),
														   resultSet.getInt("talla"),
														   resultSet.getDouble("precio"),
														   resultSet.getString("nombre"),
														   resultSet.getString("color"),
														   resultSet.getString("tipo"),
														   resultSet.getInt("stock"),
														   resultSet.getInt("idAlmacen"),
														   resultSet.getInt("idMarca"),
														   resultSet.getBoolean("activo")));
				else
					productos.add(new TransferCalcetines(resultSet.getInt("idZapatillas"),
														   resultSet.getInt("talla"),
														   resultSet.getDouble("precio"),
														   resultSet.getString("nombre"),
														   resultSet.getString("color"),
														   resultSet.getString("tejido"),
														   resultSet.getInt("stock"),
														   resultSet.getInt("idAlmacen"),
														   resultSet.getInt("idMarca"),
														   resultSet.getBoolean("activo")));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return productos;
	}
	
	/*
	@Override
	public List<TransferZapatillas> getAllZapatillas() {
		Connection conn = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Zapatillas";
		
		List<TransferZapatillas> zapatillas = new ArrayList<>();

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				zapatillas.add(new TransferZapatillas(resultSet.getInt("idZapatillas"),
												   resultSet.getInt("talla"),
												   resultSet.getDouble("precio"),
												   resultSet.getString("nombre"),
												   resultSet.getString("color"),
												   resultSet.getString("tipo"),
												   resultSet.getInt("stock"),
												   resultSet.getInt("idAlmacen"),
												   resultSet.getInt("idMarca"),
												   resultSet.getBoolean("activo")));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return zapatillas;
	}

	@Override
	public List<TransferCalcetines> getAllCalcetines() {
		Connection conn = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Calcetines";
		
		List<TransferCalcetines> calcetines = new ArrayList<>();

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				calcetines.add(new TransferCalcetines(resultSet.getInt("idZapatillas"),
												   resultSet.getInt("talla"),
												   resultSet.getDouble("precio"),
												   resultSet.getString("nombre"),
												   resultSet.getString("color"),
												   resultSet.getString("tejido"),
												   resultSet.getInt("stock"),
												   resultSet.getInt("idAlmacen"),
												   resultSet.getInt("idMarca"),
												   resultSet.getBoolean("activo")));
			}
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return calcetines;
	}*/

}
