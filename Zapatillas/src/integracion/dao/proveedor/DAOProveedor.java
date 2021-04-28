package integracion.dao.proveedor;

import java.util.List;
import negocio.proveedor.TransferProveedor;

public interface DAOProveedor {

	public int alta(TransferProveedor transfer);
	public int baja(int ID);
	public int modificar(TransferProveedor transfer);
	public TransferProveedor getProveedor(int ID);
	public List<TransferProveedor> getAllProveedores();
}
