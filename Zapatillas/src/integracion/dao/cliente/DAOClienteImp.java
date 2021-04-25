package integracion.dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import integracion.dao.connection.DatabaseConnection;
import negocio.cliente.TransferCliente;

public class DAOClienteImp implements DAOCliente {

	@Override
	public int alta(TransferCliente transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "INSERT INTO Clientes(nombre, socio, DNI) VALUES (?, ?, ?)";
		int result = -1;
		
		try {
			PreparedStatement statment = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statment.setString(1, transfer.getNombre());
			statment.setBoolean(2, transfer.isSocio());
			statment.setString(3, transfer.getDNI());
			
			statment.executeUpdate();
			
			ResultSet resultSet = statment.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			statment.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int baja(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Clientes SET activo=? WHERE idCliente=?";
		int result = -1;
		
		try {
			PreparedStatement statment = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statment.setBoolean(1, false);
			statment.setInt(2, ID);
			
			statment.executeUpdate();
			
			ResultSet resultSet = statment.getGeneratedKeys();
			
			if (resultSet.next())
				result = resultSet.getInt(1);
			
			statment.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public TransferCliente getCliente(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String query = String.format("SELECT * FROM Clientes WHERE idCliente = %d", ID);
		
		TransferCliente cliente = null;

		try {
			Statement statment = conn.createStatement();
			ResultSet resultSet = statment.executeQuery(query);
			
			if (resultSet.next()) {
				cliente = new TransferCliente(resultSet.getInt("idCliente"),
											  resultSet.getString("nombre"),
											  resultSet.getBoolean("socio"),
											  resultSet.getString("DNI"),
											  resultSet.getBoolean("activo"));
			}
			
			resultSet.close();
			statment.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return cliente;
	}

	@Override
	public List<TransferCliente> getAllClientes() {
		Connection conn = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Clientes";
		
		List<TransferCliente> clientes = new ArrayList<>();

		try {
			Statement statment = conn.createStatement();
			ResultSet resultSet = statment.executeQuery(query);
			
			
			while (resultSet.next()) {
				TransferCliente cliente = new TransferCliente(resultSet.getInt("idCliente"),
															  resultSet.getString("nombre"),
															  resultSet.getBoolean("socio"),
															  resultSet.getString("DNI"),
															  resultSet.getBoolean("activo"));
				clientes.add(cliente);
			}
			
			resultSet.close();
			statment.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
				
		return clientes;
	}

	@Override
	public int modificar(TransferCliente transfer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
