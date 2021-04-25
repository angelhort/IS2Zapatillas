package integracion.dao.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
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
		String insert = String.format("INSERT INTO CLIENTES(nombre, socio, DNI) VALUES (%s, %d, %s)", 
										transfer.getNombre(),
										transfer.isSocio(),
										transfer.getDNI());
		int result = -1;
		
		try {
			Statement statment = conn.createStatement();
			result = statment.executeUpdate(insert);
			
			statment.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int baja(int ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TransferCliente getCliente(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String query = String.format("SELECT * FROM Clientes WHERE ID = %d", ID);
		
		TransferCliente cliente = null;

		try {
			Statement statment = conn.createStatement();
			ResultSet resultSet = statment.executeQuery(query);
			
			if (resultSet.next()) {
				cliente = new TransferCliente(resultSet.getInt("idCliente"),
															  resultSet.getString("nombre"),
															  resultSet.getBoolean("socio"),
															  resultSet.getString("DNI"));
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
															  resultSet.getString("DNI"));
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
