package negocio.cliente;

import java.util.List;

public interface SACliente {

	public int alta(TransferCliente t);
	public int borrar(int id);
	public int modificar(int id);
	public TransferCliente mostrarUno(int id);
	public List<TransferCliente> mostrarTodos();
}
