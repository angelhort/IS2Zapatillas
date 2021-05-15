package negocio.proveedor_producto;

public class TransferProveedor_producto {
	private int idProveedor;
	private int idProducto;
	private double precioSuministro;
	
	public TransferProveedor_producto(int idProveedor, int idProducto, int precioSuministro){
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
		this.precioSuministro = precioSuministro;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}
	
	public double getPrecioSuministro() {
		return precioSuministro;
	}
}
