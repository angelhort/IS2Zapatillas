package negocio.venta;

import integracion.dao.DAOFactory.DAOAbstractFactory;
import negocio.producto.TransferProducto;

public class SAVentaImp implements SAVenta{

	@Override
	public int altaVenta(TransferVenta venta) {
		if(DAOAbstractFactory.getInstance().getDAOCliente().getCliente(venta.getCliente().getID()) != null) {
			if(DAOAbstractFactory.getInstance().getDAOTrabajador().getTrabajador(venta.getTrabajador().getID()) != null) {
				
				for(TProductoEnFactura p : venta.getProductos()) {
					TransferProducto producto = DAOAbstractFactory.getInstance().getDAOProducto().getProducto(p.getProducto().getID());
					if(producto == null) return -2;
					if(producto.getStock() >= p.getUnidades()) {
						double precioUnidad = DAOAbstractFactory.getInstance().getDAOProducto().getPrecioProducto(p.getProducto().getID());
						p.setPrecio(precioUnidad);						
					}
					else return -4;
				}
				
				for(TProductoEnFactura p : venta.getProductos()) 
					DAOAbstractFactory.getInstance().getDAOProducto().restarStock(p.getProducto().getID(), p.getUnidades());
				
				venta.setPrecioTotal();
				
				return DAOAbstractFactory.getInstance().getDAOVenta().alta(venta);							
			}
		}
		return -2;
	}

	@Override
	public TransferVenta getVenta(int id) {
		return DAOAbstractFactory.getInstance().getDAOVenta().getVenta(id);
	}

}
