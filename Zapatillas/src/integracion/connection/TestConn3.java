package integracion.connection;

import java.sql.*;

import integracion.dao.cliente.DAOClienteImp;
import integracion.dao.producto.DAOProductoImp;
import negocio.producto.TransferCalcetines;
import negocio.trabajador.TransferTrabajador;

public class TestConn3 {

   public static void main(String[] args) {	   
	   DAOProductoImp dao = new DAOProductoImp();
	   
	   TransferCalcetines c1 = new TransferCalcetines(43, 33.2, "Yeezy", "Gris", "Deportivas", 3, 1, 1);
	   
	   dao.alta(c1);
	   
	   TransferCalcetines t = dao.getCalcetines(1);
	   
	   System.out.println(t.getNombre());
   }
}
