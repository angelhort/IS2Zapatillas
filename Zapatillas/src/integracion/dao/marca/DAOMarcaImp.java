package integracion.dao.marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import integracion.dao.connection.DatabaseConnection;
import negocio.marca.TransferMarca;

public class DAOMarcaImp implements DAOMarca {
	
	public int alta(TransferMarca transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "INSERT INTO Marca(nombre) VALUES (?)";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, transfer.getNombre());
			
			statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next())
				resultSet.getInt(1);
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int baja(int ID) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Marca SET activo=? WHERE codigoMarca=?";
		int result = -1;
	
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setBoolean(1, false);
			statement.setInt(2, ID);
			
			result = statement.executeUpdate();
			
			statement .close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public int modificar(TransferMarca transfer) {
		Connection conn = DatabaseConnection.getConnection();
		String insert = "UPDATE Marca SET nombre=?, activo=? WHERE codigoMarca=?";
		int result = -1;
		
		try {
			PreparedStatement statement = conn.prepareStatement(insert);
			
			statement.setString(1, transfer.getNombre());
			statement.setBoolean(2, transfer.getActivo());
			statement.setInt(3, transfer.getID());
			
			result = statement.executeUpdate();
			
			statement.close();
			conn.close();
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
			
		return result;
	}

	@Override
	public TransferMarca getMarca(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransferMarca getMarca(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferMarca> getAllMarcas() {
		// TODO Auto-generated method stub
		return null;
	}
}
