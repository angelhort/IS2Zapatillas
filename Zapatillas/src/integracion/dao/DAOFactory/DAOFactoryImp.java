package integracion.dao.DAOFactory;

import integracion.dao.almacen.DAOAlmacen;
import integracion.dao.almacen.DAOAlmacenImp;
import integracion.dao.cliente.DAOCliente;
import integracion.dao.cliente.DAOClienteImp;
import integracion.dao.marca.DAOMarca;
import integracion.dao.marca.DAOMarcaImp;
import integracion.dao.proveedor.DAOProveedor;
import integracion.dao.proveedor.DAOProveedorImp;
import integracion.dao.trabajador.DAOTrabajador;
import integracion.dao.trabajador.DAOTrabajadorImp;

public class DAOFactoryImp extends DAOAbstractFactory{

	@Override
	public DAOCliente getDAOCliente() {
		return new DAOClienteImp();
	}
	
	@Override
	public DAOProveedor getDAOProveedor() {
		return new DAOProveedorImp();
	}
	
	public DAOMarca getDAOMarca() {
		return new DAOMarcaImp();
	}

	@Override
	public DAOTrabajador getDAOTrabajador() {
		return new DAOTrabajadorImp();
	}

	@Override
	public DAOAlmacen getDAOAlmacen() {
		return new DAOAlmacenImp();
	}

}
