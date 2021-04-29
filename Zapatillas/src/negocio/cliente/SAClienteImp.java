package negocio.cliente;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAClienteImp implements SACliente {

	@Override
	public int alta(TransferCliente t) {
		int id = -1;
		
		if(t.getDNI().length() == 9) {
			if(t.getNombre().length() < 35) {
				id = DAOAbstractFactory.getInstance().getDAOCliente().alta(t);
			}
		}
		
		return id;
	}

	@Override
	public int borrar(int id) {
		if(DAOAbstractFactory.getInstance().getDAOCliente().getCliente(id) != null) {
			return (DAOAbstractFactory.getInstance().getDAOCliente().baja(id));
		}
		return -1;
	}

	@Override
	public int modificar(TransferCliente t) {
		if(t.getDNI().length() == 9) {
			if(t.getNombre().length() < 35) {
				return (DAOAbstractFactory.getInstance().getDAOCliente().modificar(t));
			}
			
		}
		return 0;
	}

	@Override
	public TransferCliente mostrarUno(int id) {
		return DAOAbstractFactory.getInstance().getDAOCliente().getCliente(id);
	}

	@Override
	public List<TransferCliente> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOCliente().getAllClientes();
	}

}
