package test.integracion.DAOProducto;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import integracion.dao.almacen.DAOAlmacenImp;
import integracion.dao.marca.DAOMarcaImp;
import negocio.almacen.TransferAlmacen;
import negocio.marca.TransferMarca;
import negocio.producto.TransferCalcetines;
import negocio.producto.TransferZapatillas;

public class TestDAOProducto {
	private int idAlmacen;
	private int idMarca;
	
	public static final TransferAlmacen almacen1 = new TransferAlmacen(675948395, 754, "Calle de la fortuna");
	public static final TransferMarca marca1 = new TransferMarca("Asics");
	
	
	@Before
	public void setUpTest() {
		DAOAlmacenImp daoAlmacen = new DAOAlmacenImp();
		idAlmacen = daoAlmacen.alta(almacen1);
		
		DAOMarcaImp daoMarca = new DAOMarcaImp();
		idMarca = daoMarca.alta(marca1);
	}
	
	@Test
	public void altaZapatillas() {
		TransferZapatillas zapatillas = new TransferZapatillas(41, 34.99, "Janoski",
																"negro", "streetwear", 20, 
																idAlmacen, idMarca);
		
		
	}
}
