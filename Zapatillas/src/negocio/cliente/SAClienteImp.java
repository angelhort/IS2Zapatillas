package negocio.cliente;

import java.util.List;

import integracion.dao.DAOAbstractFactory;

public class SAClienteImp implements SACliente {

	@Override
	public int alta(TransferCliente t) {
		int id = -1;
		
		if(t.getDNI().length() == 9) {
			if(t.getNombre().length() < 30) { //TODO SUSTITUIR 30 POR EL LIMITE QUE HAYA EN LA BD
				id = DAOAbstractFactory.getInstance().getDAOCliente().alta(t);
			}
		}
		
		return id;
	}

	@Override
	public int borrar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TransferCliente mostrarUno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransferCliente> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
