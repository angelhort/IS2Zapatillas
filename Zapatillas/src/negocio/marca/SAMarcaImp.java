package negocio.marca;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAMarcaImp implements SAMarca{

	@Override
	public int alta(TransferMarca t) {
		//TODO COMPROBACIONES
		return DAOAbstractFactory.getInstance().getDAOMarca().alta(t);
	}

	@Override
	public int borrar(int id) {
		if ( DAOAbstractFactory.getInstance().getDAOMarca().getMarca(id) != null)
		return DAOAbstractFactory.getInstance().getDAOMarca().baja(id);
		else return -1;
	}

	@Override
	public int modificar(TransferMarca t) {
		return DAOAbstractFactory.getInstance().getDAOMarca().modificar(t);
	}

	@Override
	public TransferMarca mostrarUno(int id) {
		return DAOAbstractFactory.getInstance().getDAOMarca().getMarca(id);
	}

	@Override
	public List<TransferMarca> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOMarca().getAllMarcas();
	}

}
