package negocio.almacen;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SAAlmacenImp implements SAAlmacen{

	@Override
	public int alta(TransferAlmacen t) {
		if(String.valueOf(t.getTelefono()).length() == 9)
			if(t.getDireccion().length() <= 30) {
				TransferAlmacen almacen = DAOAbstractFactory.getInstance().getDAOAlmacen().getAlmacen(t.getDireccion());
				if(almacen == null)
					return DAOAbstractFactory.getInstance().getDAOAlmacen().alta(t);
				else if (!almacen.getActivo()) return DAOAbstractFactory.getInstance().getDAOAlmacen().activarEntidad(almacen.getID());
			}
		
		return -1;
	}

	@Override
	public int borrar(int id) {
		if(DAOAbstractFactory.getInstance().getDAOAlmacen().getAlmacen(id) != null)
			return DAOAbstractFactory.getInstance().getDAOAlmacen().baja(id);
		else return -1;
	}

	@Override
	public int modificar(TransferAlmacen t) {
		if(String.valueOf(t.getTelefono()).length() == 9)
			if(t.getDireccion().length() <= 30) {
				TransferAlmacen almacen = DAOAbstractFactory.getInstance().getDAOAlmacen().getAlmacen(t.getDireccion());
				if(almacen.getID() == t.getID())
				return DAOAbstractFactory.getInstance().getDAOAlmacen().modificar(t);
			}
		return -1;
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
