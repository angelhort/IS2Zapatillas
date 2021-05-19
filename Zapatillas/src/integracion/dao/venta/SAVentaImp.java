package integracion.dao.venta;

import integracion.dao.DAOFactory.DAOAbstractFactory;
import negocio.venta.TProductoEnFactura;
import negocio.venta.TransferVenta;

public class SAVentaImp implements SAVenta{

	@Override
	public int altaVenta(TransferVenta venta) {
		double precioTotal = 0;
		for(TProductoEnFactura p : venta.getProductos()) {
			double precioUnidad = DAOAbstractFactory.getInstance().getDAOProducto().getPrecioProducto(p.getProducto().getID());
			p.setPrecio(precioUnidad);
			precioTotal += precioUnidad;
		}
		
		venta.setPrecioTotal();
		
		return DAOAbstractFactory.getInstance().getDAOVenta().alta(venta);
	}

}
