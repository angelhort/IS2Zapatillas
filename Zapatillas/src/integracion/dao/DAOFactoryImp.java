package integracion.dao;

import integracion.dao.cliente.DAOCliente;
import integracion.dao.cliente.DAOClienteImp;
import integracion.dao.proveedor.DAOProveedor;
import integracion.dao.proveedor.DAOProveedorImp;

public class DAOFactoryImp extends DAOAbstractFactory{

	@Override
	public DAOCliente getDAOCliente() {
		return new DAOClienteImp();
	}
	
	@Override
	public DAOProveedor getDAOProveedor() {
		return new DAOProveedorImp();
	}

}
