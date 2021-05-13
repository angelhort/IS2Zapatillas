package presentacion.controller;

import negocio.FactoriaSA.SAAbstractFactory;
import negocio.almacen.TransferAlmacen;
import negocio.cliente.TransferCliente;
import negocio.marca.TransferMarca;
import negocio.producto.TransferProducto;
import negocio.proveedor.TransferProveedor;
import negocio.trabajador.TransferTrabajador;
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
				gui.actualizar((id != -1) ? Evento.ClienteOK : Evento.ClienteKO , id);
				break;
				
			case Evento.MostrarModificarCliente:
				TransferCliente cliente = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((cliente != null) ? Evento.MostrarModificarCliente : Evento.ClienteKO, cliente);
				break;
				
			case Evento.BajaCliente:
				id = SAAbstractFactory.getInstance().getSACliente().borrar(Integer.parseInt((String) datos));
				gui.actualizar((id != -1) ? Evento.ClienteOK : Evento.ClienteKO , id);
				break;	
				
			case Evento.ModificarCliente:
				id = SAAbstractFactory.getInstance().getSACliente().modificar((TransferCliente) datos);
				gui.actualizar((id != -1) ? Evento.ClienteOK : Evento.ClienteKO , id);
				break;
				
			case Evento.MostrarUnCliente: 
				TransferCliente clienteM = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((clienteM != null) ? Evento.MostrarUnCliente : Evento.ClienteKO, clienteM);
				break;
				
			case Evento.MostrarTodosLosClientes:
				gui.actualizar(Evento.MostrarTodosLosClientes, SAAbstractFactory.getInstance().getSACliente().mostrarTodos());
				break;
				
		//MARCA
			case Evento.AltaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().alta((TransferMarca) datos);
				gui.actualizar((id != -1) ? Evento.MarcaOK : Evento.MarcaKO , id);
				break;
				
			case Evento.BajaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().borrar(Integer.parseInt((String) datos));
				gui.actualizar((id != -1) ? Evento.MarcaOK : Evento.MarcaKO , id);
				break;
				
			case Evento.MostrarModificarMarca:
				TransferMarca marca = SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarMarca, marca);
				break;
				
			case Evento.ModificarMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().modificar((TransferMarca) datos);
				gui.actualizar((id != -1) ? Evento.MarcaOK : Evento.MarcaKO , id);
				break;
				
			case Evento.MostrarUnaMarca:
				TransferMarca marcaM = SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar((marcaM != null) ? Evento.MostrarUnaMarca : Evento.MarcaKO, marcaM);
				break;
				
			case Evento.MostrarTodasLasMarcas:
				gui.actualizar(Evento.MostrarTodasLasMarcas, SAAbstractFactory.getInstance().getSAMarca().mostrarTodos());
				break;
				
		//TRABAJADOR
			case Evento.AltaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().alta((TransferTrabajador) datos);
				gui.actualizar((id != -1) ? Evento.TrabajadorOK : Evento.TrabajadorKO, id);
				break;
				
			case Evento.BajaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().borrar(Integer.parseInt((String) datos));
				gui.actualizar((id != -1) ? Evento.TrabajadorOK : Evento.TrabajadorKO, id);
				break;
				
			case Evento.MostrarTodosLosTrabajadores:
				gui.actualizar(Evento.MostrarTodosLosTrabajadores, SAAbstractFactory.getInstance().getSATrabajador().mostrarTodos());
				break;
				
			case Evento.MostrarModificarTrabajador:
				TransferTrabajador trabajador = SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarTrabajador, trabajador);
				break;
				
			case Evento.ModificarTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().modificar((TransferTrabajador) datos);
				gui.actualizar((id != -1) ? Evento.TrabajadorOK : Evento.TrabajadorKO, id);
				break;
				
			case Evento.MostrarUnTrabajador:
				gui.actualizar(Evento.MostrarUnTrabajador, SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos)));
				break;
				
		//PRODUCTO
			case Evento.AltaProducto:
				id = SAAbstractFactory.getInstance().getSAProducto().alta((TransferProducto) datos);
				//TODO MENSAJE EXITO O ERROR
				break;
			case Evento.MostrarTodosLosProductos:
				gui.actualizar(Evento.MostrarTodosLosProductos, SAAbstractFactory.getInstance().getSAProducto().mostrarTodos());
				break;
			case Evento.BajaProducto:
				id = SAAbstractFactory.getInstance().getSAProducto().borrar(Integer.parseInt((String)datos));
				//TODO MENSAJE EXITO O ERROR
				break;
			
		//PROVEEDOR
			case Evento.AltaProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().alta((TransferProveedor)datos);
				gui.actualizar((id != -1) ? Evento.ProveedorOK : Evento.ProveedorKO, id);
				break;
			
			case Evento.BajaProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().borrar(Integer.parseInt((String) datos));
				gui.actualizar((id != -1) ? Evento.ProveedorOK : Evento.ProveedorKO, id);
				break;
				
			case Evento.MostrarUnProveedor:
				gui.actualizar(Evento.MostrarUnProveedor, SAAbstractFactory.getInstance().getSAProveedor().mostrarUno(Integer.parseInt((String) datos)));
				break;
				
			case Evento.MostrarTodosLosProveedores:
				gui.actualizar(Evento.MostrarTodosLosProveedores, SAAbstractFactory.getInstance().getSAProveedor().mostrarTodos());
				break;
				
			case Evento.MostrarModificarProveedor:
				TransferProveedor proveedor = SAAbstractFactory.getInstance().getSAProveedor().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarProveedor, proveedor);
				break;
				
			case Evento.ModificarProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().modificar((TransferProveedor) datos);
				gui.actualizar((id != -1) ? Evento.ProveedorOK : Evento.ProveedorKO, id);
				break;
				
		//ALMACEN
			case Evento.AltaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().alta((TransferAlmacen) datos);
				gui.actualizar((id != -1) ? Evento.AlmacenOK : Evento.AlmacenKO, id);
				break;
				
			case Evento.MostrarTodosLosAlmacenes:
				gui.actualizar(Evento.MostrarTodosLosAlmacenes, SAAbstractFactory.getInstance().getSAAlmacen().mostrarTodos());
				break;
				
			case Evento.BajaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().borrar(Integer.parseInt((String) datos));
				gui.actualizar((id != -1) ? Evento.AlmacenOK : Evento.AlmacenKO, id);
				break;
				
			case Evento.MostrarModificarAlmacen:
				TransferAlmacen almacen = SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarAlmacen, almacen);
				break;
				
			case Evento.ModificarAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().modificar((TransferAlmacen) datos);
				gui.actualizar((id != -1) ? Evento.AlmacenOK : Evento.AlmacenKO, id);
				break;
				
			case Evento.MostrarUnAlmacen:
				gui.actualizar(Evento.MostrarUnAlmacen, SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos)));
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
