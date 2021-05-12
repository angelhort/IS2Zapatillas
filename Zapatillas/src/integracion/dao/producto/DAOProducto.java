package integracion.dao.producto;

import java.util.List;

import negocio.producto.TransferZapatillas;
import negocio.producto.TransferCalcetines;
import negocio.producto.TransferProducto;

public interface DAOProducto {
	public int alta(TransferZapatillas transfer);
	public int alta(TransferCalcetines transfer);
	public int bajaProducto(int ID);
	//public int bajaCalcetines(int ID);
	public int modificar(TransferZapatillas transfer);
	public int modificar(TransferCalcetines transfer);
	public Object getProducto(int ID);
	//public TransferZapatillas getZapatillas(int ID);
	//public TransferCalcetines getCalcetines(int ID);
	public List<TransferProducto> getAllProductos();
	//public List<TransferZapatillas> getAllZapatillas();
	//public List<TransferCalcetines> getAllCalcetines();
}
