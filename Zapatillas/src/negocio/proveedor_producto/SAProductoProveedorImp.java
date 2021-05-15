package negocio.proveedor_producto;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;
import negocio.producto.TransferProducto;

public class SAProductoProveedorImp implements SAProductoProveedor{

	@Override
	public int aniadirProveedor(TransferProveedor_producto t) {	
		return DAOAbstractFactory.getInstance().getDAOProveedorProducto().alta(t);
	}

	@Override
	public int eliminarProveedor(TransferProveedor_producto t) {	
		return DAOAbstractFactory.getInstance().getDAOProveedorProducto().baja(t);
	}

	@Override
	public List<TransferProducto> getProveedor_producto(int idProveedor) {
		return DAOAbstractFactory.getInstance().getDAOProveedorProducto().getProveedor_producto(idProveedor);
	}

}
