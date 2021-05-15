package negocio.venta;

import java.util.List;

import negocio.cliente.TransferCliente;
import negocio.producto.TransferProducto;
import negocio.trabajador.TransferTrabajador;

public class TransferVenta {
	
	TransferCliente cliente;
	TransferTrabajador trabajador;
	List<TransferProducto> productos;
	
	public TransferVenta(TransferCliente cliente, 
						 TransferTrabajador trabajador, 
						 List<TransferProducto> productos) {
		this.cliente = cliente;
		this.trabajador = trabajador;
		this.productos = productos;
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
