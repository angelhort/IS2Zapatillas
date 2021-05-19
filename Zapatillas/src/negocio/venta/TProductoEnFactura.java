package negocio.venta;

import negocio.producto.TransferProducto;

public class TProductoEnFactura {
	
	private TransferProducto producto;
	private int unidades;
	private double precio; //PRECIO = PRECIOPRODUCTO * UNIDADES 
	
	public TProductoEnFactura(TransferProducto producto, int unidades) {
		this.producto = producto;
		this.unidades = unidades;
	}
	
	public void setPrecio(int precioUnidad) {
		this.precio = precioUnidad * unidades;
	}
	
	public void addUnidades(int unidades) {
		this.unidades += unidades;
	}

	public TransferProducto getProducto() {
		return producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public double getPrecio() {
		return precio;
	}
}
