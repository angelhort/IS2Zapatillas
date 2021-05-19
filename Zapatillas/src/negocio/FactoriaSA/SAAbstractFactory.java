package negocio.FactoriaSA;

import integracion.dao.venta.SAVenta;
import negocio.almacen.SAAlmacen;
import negocio.cliente.SACliente;
import negocio.marca.SAMarca;
import negocio.producto.SAProducto;
import negocio.proveedor.SAProveedor;
import negocio.proveedor_producto.SAProductoProveedor;
import negocio.trabajador.SATrabajador;

public abstract class SAAbstractFactory {
	
	private static SAAbstractFactory instance;
	
	public static SAAbstractFactory getInstance() {
		if (instance == null) instance = new SAFactoryImp();
		return instance;
	}
	
	public abstract SACliente getSACliente();
	public abstract SAProveedor getSAProveedor();
	public abstract SAMarca getSAMarca();
	public abstract SATrabajador getSATrabajador();
	public abstract SAAlmacen getSAAlmacen();
	public abstract SAProducto getSAProducto();
	public abstract SAProductoProveedor getSAProductoProveedor();
	public abstract SAVenta getSAVenta();
}
