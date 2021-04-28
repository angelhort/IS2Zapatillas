package negocio.FactoriaSA;

import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.proveedor.SAProveedor;
import negocio.proveedor.SAProveedorImp;

public class SAFactoryImp  extends SAAbstractFactory {

	@Override
	public SACliente getSACliente() {
		return new SAClienteImp();
	}
	
	@Override
	public SAProveedor getSAProveedor() {
		return new SAProveedorImp();
	}
}
