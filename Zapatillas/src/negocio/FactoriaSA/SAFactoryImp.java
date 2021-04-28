package negocio.FactoriaSA;

import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.marca.SAMarca;
import negocio.marca.SAMarcaImp;
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

	@Override
	public SAMarca getSAMarca() {
		return new SAMarcaImp();
	}
}
