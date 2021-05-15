package integracion.dao.proveedor_producto;

import java.util.List;

import negocio.producto.TransferProducto;
import negocio.proveedor_producto.TransferProveedor_producto;

public interface DAOProveedorProducto {

	public int alta(TransferProveedor_producto transfer);
	public int baja(TransferProveedor_producto transfer);
	public List<TransferProducto> getProveedor_producto(int idProveedor);
}
