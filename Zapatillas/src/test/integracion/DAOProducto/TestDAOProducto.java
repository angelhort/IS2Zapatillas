package test.integracion.DAOProducto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import integracion.connection.DatabaseConnection;
import integracion.dao.almacen.DAOAlmacenImp;
import integracion.dao.marca.DAOMarcaImp;
import integracion.dao.producto.DAOProductoImp;
import negocio.almacen.TransferAlmacen;
import negocio.marca.TransferMarca;
import negocio.producto.TransferCalcetines;
import negocio.producto.TransferZapatillas;

public class TestDAOProducto {
	
	private DAOAlmacenImp daoAlmacen = new DAOAlmacenImp();
	private DAOMarcaImp daoMarca = new DAOMarcaImp();
	private DAOProductoImp daoProducto = new DAOProductoImp();
	
	private TransferAlmacen almacen = new TransferAlmacen(675948395, 754, "Calle de la fortuna");
	private TransferMarca marca = new TransferMarca("Asics");	
	
	@Test
	public void altaZapatillas() {
		int idAlmacen = daoAlmacen.alta(almacen);
		int idMarca = daoMarca.alta(marca);
		
		TransferZapatillas zapatillas = new TransferZapatillas(41, 34.99, "Test", "Test", "Test", 20, idAlmacen, idMarca);
		
		int idProducto = daoProducto.alta(zapatillas);
		
		assertTrue(String.format("Se esperaba >0 y se encontró %s", idProducto), idProducto > 0);
		
		deleteRegister(idProducto, idAlmacen, idMarca);
	}
	
	@Test
	public void altaCalcetines() {
		int idAlmacen = daoAlmacen.alta(almacen);
		int idMarca = daoMarca.alta(marca);
		
		TransferCalcetines calcetines = new TransferCalcetines(41, 34.99, "Test", "Test", 20, idAlmacen, idMarca, "Test");
		
		int idProducto = daoProducto.alta(calcetines);
		
		assertTrue(String.format("Se esperaba >0 y se encontró %s", idProducto), idProducto > 0);
		
		deleteRegister(idProducto, idAlmacen, idMarca);
	}
	
	@Test
	public void bajaProducto() {
		int idAlmacen = daoAlmacen.alta(almacen);
		int idMarca = daoMarca.alta(marca);
		
		TransferCalcetines calcetines = new TransferCalcetines(41, 34.99, "Test", "Test", 20, idAlmacen, idMarca, "Test");
		int idProducto = daoProducto.alta(calcetines);
		
		int baja = daoProducto.bajaProducto(idProducto);
		
		assertEquals(String.format("Se esperaba 1 y se encontró %s", baja), 1, baja);
		
		deleteRegister(idProducto, idAlmacen, idMarca);
	}
	
	private void deleteRegister(int idProducto, int idAlmacen, int idMarca) {
		String sql1 = "DELETE FROM Productos WHERE idProducto=?";
		String sql2 = "DELETE FROM Almacen WHERE idAlmacen=?";
		String sql3 = "DELETE FROM Marca WHERE idMarca=?";
		
		DatabaseConnection.dropRegisterWithID(sql1, idProducto);
		DatabaseConnection.dropRegisterWithID(sql2, idAlmacen);
		DatabaseConnection.dropRegisterWithID(sql3, idMarca);
	}
}
