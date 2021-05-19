package negocio.venta;

import java.util.ArrayList;
import java.util.List;

import negocio.cliente.TransferCliente;
import negocio.producto.TransferProducto;
import negocio.trabajador.TransferTrabajador;

public class TOAVenta {
	
	private TransferCliente cliente;
	private TransferTrabajador trabajador;
	private List<TransferProducto> productos;
	
	public TOAVenta(TransferCliente cliente, 
						 TransferTrabajador trabajador) {
		this.cliente = cliente;
		this.trabajador = trabajador;
		this.productos = new ArrayList<>();
	}
	
	public void addProduct(TransferProducto producto) {
		productos.add(producto);
	}
	
	public TransferCliente getCliente() {
		return cliente;
	}
	
	public TransferTrabajador getTrabajador() {
		return trabajador;
	}
	
	public List<TransferProducto> getProductos() {
		return productos;
	}
}
