package negocio.trabajador;

import java.util.List;

import integracion.dao.DAOFactory.DAOAbstractFactory;

public class SATrabajadorImp implements SATrabajador{

	@Override
	public int alta(TransferTrabajador t) {
		//TODO COMPROBAR SI EL TRABAJADOR YA ESTA DADO DE ALTA
		if(t.getDNI().length() == 9) 
			if(t.getNombre().length() < 35)
				return DAOAbstractFactory.getInstance().getDAOTrabajador().alta(t);
		return -1;
	}

	@Override
	public int borrar(int id) {
		return DAOAbstractFactory.getInstance().getDAOTrabajador().baja(id);
	}

	@Override
	public int modificar(TransferTrabajador t) {
		return DAOAbstractFactory.getInstance().getDAOTrabajador().modificar(t);
	}

	@Override
	public TransferTrabajador mostrarUno(int id) {
		return  DAOAbstractFactory.getInstance().getDAOTrabajador().getTrabajador(id);
	}

	@Override
	public List<TransferTrabajador> mostrarTodos() {
		return DAOAbstractFactory.getInstance().getDAOTrabajador().getAllTrabajadores();
	}

}
