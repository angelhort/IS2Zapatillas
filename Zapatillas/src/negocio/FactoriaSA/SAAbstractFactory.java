package negocio.FactoriaSA;

import negocio.almacen.SAAlmacen;
import negocio.cliente.SACliente;
import negocio.marca.SAMarca;
import negocio.proveedor.SAProveedor;
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
}
