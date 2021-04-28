package integracion.dao;

import integracion.dao.cliente.DAOCliente;
import integracion.dao.proveedor.DAOProveedor;

public abstract class DAOAbstractFactory {
	private static DAOAbstractFactory instance;
	
	public static DAOAbstractFactory getInstance() {
		if(instance == null) instance = new DAOFactoryImp();
		return instance;
	}
	
	public abstract DAOCliente getDAOCliente();
	public abstract DAOProveedor getDAOProveedor();

}
