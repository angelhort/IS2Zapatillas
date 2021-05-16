package negocio.producto;

import java.util.List;
import java.util.StringTokenizer;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAProductoImp implements SAProducto{
	
	@Override
	public int alta(TransferProducto t) {
		if(t.getNombre().length() <= 35) {
			
			String stringAux = String.valueOf(t.getPrecio());
			StringTokenizer sT = new StringTokenizer(stringAux, ".");
			
			if(sT.nextToken().length() <= 8 && sT.nextToken().length() <= 2) {
				if(DAOAbstractFactory.getInstance().getDAOMarca().getMarca(t.getMarca()) != null) {
					if(DAOAbstractFactory.getInstance().getDAOAlmacen().getAlmacen(t.getAlmacen()) != null) {
						if(t.getClass() == TransferZapatillas.class)
							return DAOAbstractFactory.getInstance().getDAOProducto().alta((TransferZapatillas) t);
						else if(t.getClass() == TransferCalcetines.class)
							return DAOAbstractFactory.getInstance().getDAOProducto().alta((TransferCalcetines) t);						
					}
				}
				
			}
		}
		return -1;
	}

	@Override
	public int borrar(int id) {
		if(DAOAbstractFactory.getInstance().getDAOProducto().getProducto(id) != null)
			return DAOAbstractFactory.getInstance().getDAOProducto().bajaProducto(id);
		else return -1;
	}

	@Override
	public int modificar(TransferProducto t) {
		if(t.getClass() == TransferZapatillas.class)
			return DAOAbstractFactory.getInstance().getDAOProducto().modificar((TransferZapatillas) t);
		else if(t.getClass() == TransferCalcetines.class)
			return DAOAbstractFactory.getInstance().getDAOProducto().modificar((TransferCalcetines) t);
		return -1;
	}

	@Override
	public TransferProducto mostrarUno(int id) {
		return DAOAbstractFactory.getInstance().getDAOProducto().getProducto(id);
	}

	@Override
	public List<TransferProducto> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOProducto().getAllProductos();
	}

}
