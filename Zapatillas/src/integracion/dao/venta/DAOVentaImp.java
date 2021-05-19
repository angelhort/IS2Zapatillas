package integracion.dao.venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import integracion.connection.DatabaseConnection;
import negocio.venta.TProductoEnFactura;
import negocio.venta.TransferVenta;

public class DAOVentaImp implements DAOVenta {

	@Override
	public int alta(TransferVenta transfer) {
		// crear factura
		// id factura de la anterior
		// por cada producto un insert en contiene
		Connection conn = DatabaseConnection.getConnection();
		
		String insertFacturas = "INSERT INTO Facturas(precioTotal, idTrabajador, idCliente) VALUES (?, ?, ?)";
		String insertContiene = "INSERT INTO Contiene(unidades, precio, idProducto, idFactura) VALUES (?, ?, ?, ?)";
		
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insertFacturas, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setDouble(1, transfer.getPrecioTotal());
			statement.setInt(2, transfer.getTrabajador().getID());
			statement.setInt(3, transfer.getCliente().getID());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			for (TProductoEnFactura producto : transfer.getProductos()) {
				statement = conn.prepareStatement(insertContiene);
				
				statement.setInt(1, producto.getUnidades());
				statement.setDouble(2, producto.getPrecio());
				statement.setInt(3, producto.getProducto().getID());
				statement.setInt(4, result);
				
				statement.executeUpdate();
			}
			
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
	public TransferVenta getVenta(String DNI) {
		// TODO Auto-generated method stub
		return null;
	}

}
