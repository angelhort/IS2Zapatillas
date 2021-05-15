package integracion.dao.proveedor_producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import integracion.connection.DatabaseConnection;
import negocio.producto.TransferProducto;
import negocio.proveedor_producto.TransferProveedor_producto;

public class DAOProveedorProductoImp implements DAOProveedorProducto {

	@Override
	public int alta(TransferProveedor_producto transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "INSERT INTO Suministra(idProveedor, idProducto, precioSuministro) VALUES (?, ?, ?)";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, transfer.getIdProveedor());
			statement.setInt(2, transfer.getIdProducto());
			statement.setDouble(3, transfer.getPrecioSuministro());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			resultSet.close();
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		DatabaseConnection.killConnection(conn);
		return result;
	}

	@Override
	public int baja(TransferProveedor_producto transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Suministra SET activo=? WHERE idProveedor=? AND idProducto=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setBoolean(1, false);
			statement.setInt(2, transfer.getIdProveedor());
			statement.setInt(2, transfer.getIdProducto());
			
			result = statement.executeUpdate(); // Number of updated rows
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		DatabaseConnection.killConnection(conn);
		return result;
	}

	@Override
	public List<TransferProducto> getProveedor_producto(int idProveedor) {
		// TODO Auto-generated method stub
		return null;
	}

}
