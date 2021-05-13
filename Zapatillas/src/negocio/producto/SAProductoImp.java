package negocio.producto;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAProductoImp implements SAProducto{
	
	@Override
	public int alta(TransferProducto t) {
		if(t.getClass() == TransferZapatillas.class)
			return DAOAbstractFactory.getInstance().getDAOProducto().alta((TransferZapatillas) t);
		else if(t.getClass() == TransferCalcetines.class)
			return DAOAbstractFactory.getInstance().getDAOProducto().alta((TransferCalcetines) t);
		return -1;
	}

	@Override
	public int borrar(int id) {
		return DAOAbstractFactory.getInstance().getDAOProducto().bajaProducto(id);
	}

	@Override
	public int modificar(TransferProducto t) {
		return 0;
	}

	@Override
	public TransferProducto mostrarUno(int id) {
		return null;
	}

	@Override
	public List<TransferProducto> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOProducto().getAllProductos();
	}

}
