package negocio.almacen;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAAlmacenImp implements SAAlmacen{

	@Override
	public int alta(TransferAlmacen t) {
		return DAOAbstractFactory.getInstance().getDAOAlmacen().alta(t);
	}

	@Override
	public int borrar(int id) {
		return DAOAbstractFactory.getInstance().getDAOAlmacen().baja(id);
	}

	@Override
	public int modificar(TransferAlmacen t) {
		return DAOAbstractFactory.getInstance().getDAOAlmacen().modificar(t);
	}

	@Override
	public TransferAlmacen mostrarUno(int id) {
		return DAOAbstractFactory.getInstance().getDAOAlmacen().getAlmacen(id);
	}

	@Override
	public List<TransferAlmacen> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOAlmacen().getAllAlmacenes();
	}

}
