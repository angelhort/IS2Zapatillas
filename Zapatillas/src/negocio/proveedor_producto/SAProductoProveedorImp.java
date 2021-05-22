package negocio.proveedor_producto;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;
import negocio.producto.TransferProducto;

public class SAProductoProveedorImp implements SAProductoProveedor{

	@Override
	public int aniadirProveedor(TransferProveedor_producto t) {	
		if(DAOAbstractFactory.getInstance().getDAOProducto().getProducto(t.getIdProducto()) != null)
			if(DAOAbstractFactory.getInstance().getDAOProveedor().getProveedor(t.getIdProveedor()) != null)
				return DAOAbstractFactory.getInstance().getDAOProveedorProducto().alta(t);
		return -2;
	}

	@Override
	public int eliminarProveedor(TransferProveedor_producto t) {
		if(DAOAbstractFactory.getInstance().getDAOProducto().getProducto(t.getIdProducto()) != null)
			if(DAOAbstractFactory.getInstance().getDAOProveedor().getProveedor(t.getIdProveedor()) != null)
				return DAOAbstractFactory.getInstance().getDAOProveedorProducto().baja(t);
		return -2;
	}

	@Override
	public List<TransferProducto> getProveedor_producto(int idProveedor) {
		if(DAOAbstractFactory.getInstance().getDAOProveedor().getProveedor(idProveedor) != null)
			return DAOAbstractFactory.getInstance().getDAOProveedorProducto().getProveedor_producto(idProveedor);
		return null;
	}

}
