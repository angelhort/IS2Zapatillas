package integracion.dao.connection;

import java.util.List;

import integracion.dao.cliente.DAOClienteImp;
import negocio.cliente.TransferCliente;

public class TestCliente {

	public static void main(String[] args) {
		DAOClienteImp dao = new DAOClienteImp();
		
		List<TransferCliente> clientes = dao.getAllClientes();
		
		for (TransferCliente cliente : clientes)
			System.out.println(cliente.getDNI());
	}

}
