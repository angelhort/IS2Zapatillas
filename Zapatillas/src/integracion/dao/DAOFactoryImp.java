package integracion.dao;

import integracion.dao.cliente.DAOCliente;
import integracion.dao.cliente.DAOClienteImp;

public class DAOFactoryImp extends DAOAbstractFactory{

	@Override
	public DAOCliente getDAOCliente() {
		return new DAOClienteImp();
	}

}
