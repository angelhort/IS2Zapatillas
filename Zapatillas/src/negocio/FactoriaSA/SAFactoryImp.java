package negocio.FactoriaSA;

import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;

public class SAFactoryImp  extends SAAbstractFactory {

	@Override
	public SACliente getSACliente() {
		return new SAClienteImp();
	}	
}
