package presentacion.controller;

import negocio.FactoriaSA.SAAbstractFactory;
import negocio.almacen.TransferAlmacen;
import negocio.cliente.TransferCliente;
import negocio.marca.TransferMarca;
import negocio.producto.TransferProducto;
import negocio.proveedor.TransferProveedor;
import negocio.proveedor_producto.TransferProveedor_producto;
import negocio.trabajador.TransferTrabajador;
import negocio.venta.TransferVenta;
import presentacion.factoryGUI.GUIFactory;
import presentacion.vista.IGUI;

public class ControllerImp extends Controller{
		
	public ControllerImp() {
		
	}

	@Override
	public void action(int evento, Object datos) {
		
		IGUI gui = GUIFactory.getInstance().getFrame(evento);
		int id;
		
		switch(evento) {
		//CLIENTE
			case Evento.AltaCliente:
				id = SAAbstractFactory.getInstance().getSACliente().alta((TransferCliente)datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.MostrarModificarCliente:
				TransferCliente cliente = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((cliente != null) ? Evento.MostrarModificarCliente : Evento.EntidadSiNoExiste, cliente);
				break;
				
			case Evento.BajaCliente:
				id = SAAbstractFactory.getInstance().getSACliente().borrar(Integer.parseInt((String) datos));
				gui.actualizar(id , null);
				break;	
				
			case Evento.ModificarCliente:
				id = SAAbstractFactory.getInstance().getSACliente().modificar((TransferCliente) datos);
				gui.actualizar(id , id);
				break;
				
			case Evento.MostrarUnCliente: 
				TransferCliente clienteM = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((clienteM != null) ? Evento.MostrarUnCliente : Evento.EntidadSiNoExiste, clienteM);
				break;
				
			case Evento.MostrarTodosLosClientes:
				gui.actualizar(Evento.MostrarTodosLosClientes, SAAbstractFactory.getInstance().getSACliente().mostrarTodos());
				break;
				
		//MARCA
			case Evento.AltaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().alta((TransferMarca) datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.BajaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().borrar(Integer.parseInt((String) datos));
				gui.actualizar(id, null);
				break;
				
			case Evento.MostrarModificarMarca:
				TransferMarca marca = SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((marca != null) ? Evento.MostrarModificarMarca : Evento.EntidadSiNoExiste, marca);
				break;
				
			case Evento.ModificarMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().modificar((TransferMarca) datos);
				gui.actualizar(id , id);
				break;
				
			case Evento.MostrarUnaMarca:
				TransferMarca marcaM = SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((marcaM != null) ? Evento.MostrarUnaMarca : Evento.EntidadSiNoExiste, marcaM);
				break;
				
			case Evento.MostrarTodasLasMarcas:
				gui.actualizar(Evento.MostrarTodasLasMarcas, SAAbstractFactory.getInstance().getSAMarca().mostrarTodos());
				break;
				
		//TRABAJADOR
			case Evento.AltaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().alta((TransferTrabajador) datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.BajaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().borrar(Integer.parseInt((String) datos));
				gui.actualizar(id, null);
				break;
				
			case Evento.MostrarTodosLosTrabajadores:
				gui.actualizar(Evento.MostrarTodosLosTrabajadores, SAAbstractFactory.getInstance().getSATrabajador().mostrarTodos());
				break;
				
			case Evento.MostrarModificarTrabajador:
				TransferTrabajador trabajador = SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((trabajador != null) ? Evento.MostrarModificarTrabajador : Evento.EntidadSiNoExiste, trabajador);
				break;
				
			case Evento.ModificarTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().modificar((TransferTrabajador) datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.MostrarUnTrabajador:
				TransferTrabajador trabajadorM = SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((trabajadorM != null) ? Evento.MostrarUnTrabajador : Evento.EntidadSiNoExiste, trabajadorM);
				break;
				
		//PRODUCTO
			case Evento.AltaProducto:
				id = SAAbstractFactory.getInstance().getSAProducto().alta((TransferProducto) datos);
				gui.actualizar(id, id);
				break;
			case Evento.MostrarTodosLosProductos:
				gui.actualizar(Evento.MostrarTodosLosProductos, SAAbstractFactory.getInstance().getSAProducto().mostrarTodos());
				break;
			case Evento.BajaProducto:
				id = SAAbstractFactory.getInstance().getSAProducto().borrar(Integer.parseInt((String)datos));
				gui.actualizar(id, null);
				break;
			case Evento.MostrarUnProducto:
				TransferProducto producto = SAAbstractFactory.getInstance().getSAProducto().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((producto != null) ? Evento.MostrarUnProducto : Evento.EntidadSiNoExiste, producto);
				break;
			case Evento.MostrarModificarProducto:
				TransferProducto productoM = SAAbstractFactory.getInstance().getSAProducto().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((productoM != null) ? Evento.MostrarModificarProducto : Evento.EntidadSiNoExiste, productoM);
				break;
			case Evento.ModificarProducto:
				id = SAAbstractFactory.getInstance().getSAProducto().modificar((TransferProducto) datos);
				gui.actualizar(id, id);
				break;
			
		//PROVEEDOR
			case Evento.AltaProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().alta((TransferProveedor)datos);
				gui.actualizar(id, id);
				break;
			
			case Evento.BajaProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().borrar(Integer.parseInt((String) datos));
				gui.actualizar(id, null);
				break;
				
			case Evento.MostrarUnProveedor:
				TransferProveedor proveedor = SAAbstractFactory.getInstance().getSAProveedor().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((proveedor != null) ? Evento.MostrarUnProveedor : Evento.EntidadSiNoExiste, proveedor);
				break;
				
			case Evento.MostrarTodosLosProveedores:
				gui.actualizar(Evento.MostrarTodosLosProveedores, SAAbstractFactory.getInstance().getSAProveedor().mostrarTodos());
				break;
				
			case Evento.MostrarModificarProveedor:
				TransferProveedor proveedorM = SAAbstractFactory.getInstance().getSAProveedor().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((proveedorM != null) ? Evento.MostrarModificarProveedor : Evento.EntidadSiNoExiste, proveedorM);
				break;
				
			case Evento.ModificarProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().modificar((TransferProveedor) datos);
				gui.actualizar(id, id);
				break;
				
		//ALMACEN
			case Evento.AltaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().alta((TransferAlmacen) datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.MostrarTodosLosAlmacenes:
				gui.actualizar(Evento.MostrarTodosLosAlmacenes, SAAbstractFactory.getInstance().getSAAlmacen().mostrarTodos());
				break;
				
			case Evento.BajaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().borrar(Integer.parseInt((String) datos));
				gui.actualizar(id, null);
				break;
				
			case Evento.MostrarModificarAlmacen:
				TransferAlmacen almacen = SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((almacen != null) ? Evento.MostrarModificarAlmacen : Evento.EntidadSiNoExiste, almacen);
				break;
				
			case Evento.ModificarAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().modificar((TransferAlmacen) datos);
				gui.actualizar(id, id);
				break;
				
			case Evento.MostrarUnAlmacen:
				TransferAlmacen almacenMostrar = SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((almacenMostrar != null) ? Evento.MostrarUnAlmacen : Evento.EntidadSiNoExiste, almacenMostrar);
				break;
				
		//PROVEEDOR-PRODUCTO
			case Evento.AniadirProveedor:
				SAAbstractFactory.getInstance().getSAProductoProveedor().aniadirProveedor((TransferProveedor_producto) datos);
				break;
			case Evento.EliminarProveedor:
				SAAbstractFactory.getInstance().getSAProductoProveedor().eliminarProveedor((TransferProveedor_producto) datos);
				break;
			case Evento.MostrarProductosProveedor:
				gui.actualizar(Evento.MostrarProductosProveedor, SAAbstractFactory.getInstance().getSAProductoProveedor().getProveedor_producto(Integer.parseInt((String) datos)));
				break;
				
		//VENTA
			case Evento.CerrarVenta:
				SAAbstractFactory.getInstance().getSAVenta().altaVenta((TransferVenta) datos);
				break;
			case Evento.MostrarVenta:
				gui.actualizar(Evento.MostrarVenta, SAAbstractFactory.getInstance().getSAVenta().getVenta(Integer.parseInt((String)datos)));
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
