package negocio.proveedor;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAProveedorImp implements SAProveedor {
	
	// TODO: Comprobar validez de los datos

	@Override
	public int alta(TransferProveedor t) {
		int id = -1;
		
		id = DAOAbstractFactory.getInstance().getDAOProveedor().alta(t);
		
		return id;
	}

	@Override
	public int borrar(int id) {
		if(DAOAbstractFactory.getInstance().getDAOProveedor().getProveedor(id) != null) {
			return (DAOAbstractFactory.getInstance().getDAOProveedor().baja(id));
		}
		return -1;
	}

	@Override
	public int modificar(TransferProveedor t) {
		return (DAOAbstractFactory.getInstance().getDAOProveedor().modificar(t));
	}

	@Override
	public TransferProveedor mostrarUno(int id) {
		return DAOAbstractFactory.getInstance().getDAOProveedor().getProveedor(id);
	}

	@Override
	public List<TransferProveedor> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOProveedor().getAllProveedores();
	}

}
