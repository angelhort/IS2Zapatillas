package negocio.proveedor_producto;

public class TransferProveedor_producto {
	private int idProveedor;
	private int idProducto;
	
	public TransferProveedor_producto(int idProveedor, int idProducto){
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}
}
