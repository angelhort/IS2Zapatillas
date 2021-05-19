package integracion.dao.venta;

import negocio.venta.TOAVenta;

public interface DAOVenta {
	public int alta(TOAVenta transfer);
	public TOAVenta getVenta(String DNI);
}
