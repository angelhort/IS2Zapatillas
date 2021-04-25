package integracion.dao.cliente;

import negocio.cliente.TransferCliente;
import java.util.List;

public interface DAOCliente {

	public int alta(TransferCliente transfer);
	public int baja(int ID);
	public int modificar(TransferCliente transfer);
	public TransferCliente getCliente(int ID);
	public List<TransferCliente> getAllClientes();
}