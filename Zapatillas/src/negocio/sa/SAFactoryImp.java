package negocio.sa;

import negocio.cliente.SAClienteImp;

public class SAFactoryImp  extends SAAbstractFactory {

	@Override
	public Object getSA(int evento) {
		
		int entity = evento / 100;
		
		switch (entity) {
			case 1:
				return new SAClienteImp();
		}
		
		return null;
	}
}
