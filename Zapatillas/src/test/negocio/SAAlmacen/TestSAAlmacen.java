package test.negocio.SAAlmacen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import negocio.almacen.SAAlmacen;
import negocio.almacen.SAAlmacenImp;
import negocio.almacen.TransferAlmacen;

public class TestSAAlmacen {
	public static final TransferAlmacen almacen1 = new TransferAlmacen(665768765, 65, "Calle estrellas 1");
	public static final TransferAlmacen almacen2 = new TransferAlmacen(654447532, 76, "Calle pluton 3");
	
	private int idAlmacen1;
	private int idAlmacen2;
	private SAAlmacenImp saAlmacen;
	
	@Before
	public void setUp() {
		saAlmacen = new SAAlmacenImp();

		idAlmacen1 = saAlmacen.alta(almacen1);
		idAlmacen2 = saAlmacen.alta(almacen2);
	}
	
	@Test
	public void alta() {		
		assertTrue(String.format("Se ha devuelto %d" , idAlmacen1 ), idAlmacen1 >= 1);
	}
	
	@Test
	public void borrar() {		
		int idBaja = saAlmacen.borrar(idAlmacen1);
		
		assertEquals(String.format("Se esperaba 1 como salida y se encontro %d", idBaja), 1, idBaja);
	}
	
	@Test
	public void modificar() {		
		TransferAlmacen almacenModificado = new TransferAlmacen(idAlmacen2, 655433745, 456,"Calle luces 2", true);
		int modificar = saAlmacen.modificar(almacenModificado);
		
		assertEquals(String.format("Se esperaba un 1 como salida y se encontro %d", modificar), 1, modificar);
	}
	
	@Test
	public void mostrarUno() {		
		TransferAlmacen almacen = saAlmacen.mostrarUno(idAlmacen2);
		
		areEqual(almacen2, almacen);
	}
	
	@Test
	public void mostrarTodos() {		
		List<TransferAlmacen> almacenes = saAlmacen.mostrarTodos();
		
		assertNotNull(almacenes);
	}
	
	private void areEqual(TransferAlmacen a1, TransferAlmacen a2) {
		assertEquals(a1.getTelefono(), a2.getTelefono());
		assertEquals(a1.getCapacidad(), a2.getCapacidad());
		assertEquals(a1.getDireccion(), a2.getDireccion());
	}
	
	
}
