package presentacion.factoryGUI;

import presentacion.VComunes.*;
import presentacion.almacen.*;
import presentacion.cliente.*;
import presentacion.controller.Evento;
import presentacion.marca.*;
import presentacion.producto.*;
import presentacion.proveedor.*;
import presentacion.proveedor_producto.*;
import presentacion.trabajador.*;
import presentacion.vista.GUIPrincipal;
import presentacion.vista.IGUI;

public class GUIFactoryImp extends GUIFactory{

	@Override
	public IGUI getFrame(int evento) {
		switch(evento) {
		//GUIPrincipal
		case Evento.MostrarGUIPrincipal:
			return new GUIPrincipal();
		
		//CLIENTE
		case Evento.MostrarGUICliente:
			return new GUICliente();
		case Evento.GUIAltaCliente:
		case Evento.AltaCliente:
			return new VAltaCliente();
		case Evento.GUIBajaCliente:
			return new VBajaCliente();
		case Evento.GUIMostrarUnCliente:
			return new VMostrarUno("Cliente");
		case Evento.GUIModificarCliente:
			return new VModificar("Cliente");
		case Evento.MostrarModificarCliente:
			return new VModificarCliente();
		case Evento.MostrarUnCliente:
			return new VMostrarUnCliente();
		case Evento.MostrarTodosLosClientes:
			return new VMostrarTodosLosClientes();
		
		//TRABAJADOR
		case Evento.MostrarGUITrabajador:
			return new GUITrabajador();
		case Evento.GUIAltaTrabajador:
			return new VAltaTrabajador();
		case Evento.GUIBajaTrabajador:
			return new VBajaTrabajador();
		case Evento.GUIMostrarUnTrabajador:
			return new VMostrarUno("Trabajador");
		case Evento.GUIModificarTrabajador:
			return new VModificar("Trabajador");
		case Evento.MostrarTodosLosTrabajadores:
			return new VMostrarTodosLosTrabajadores();
		case Evento.MostrarModificarTrabajador:
			return new VModificarTrabajador();
		case Evento.MostrarUnTrabajador:
			return new VMostrarUnTrabajador();
		
		//VENTA
		case Evento.MostrarGUIVenta: //TODO VENTA
			break;
		
		//ALMACEN
		case Evento.MostrarGUIAlmacen:
			return new GUIAlmacen();
		case Evento.GUIAltaAlmacen:
			return new VAltaAlmacen();
		case Evento.GUIBajaAlmacen:
			return new VBajaAlmacen();
		case Evento.GUIMostrarUnAlmacen:
			return new VMostrarUno("Almacen");
		case Evento.GUIModificarAlmacen:
			return new VModificar("Almacen");
		case Evento.MostrarTodosLosAlmacenes:
			return new VMostrarTodosLosAlmacenes();
		case Evento.MostrarModificarAlmacen:
			return new VModificarAlmacen();
		case Evento.MostrarUnAlmacen:
			return new VMostrarUnAlmacen();
			
		//PRODUCTO
		case Evento.MostrarGUIProducto:
			return new GUIProducto();
		case Evento.GUIAltaProducto:
			return new VAltaProducto();
		case Evento.GUIBajaProducto:
			return new VBajaProducto();
		case Evento.GUIMostrarUnProducto:
			return new VMostrarUno("Producto");
		case Evento.GUIModificarProducto:
			return new VModificar("Producto");
		
		//PROVEEDOR
		case Evento.MostrarGUIProveedor:
			return new GUIProveedor();
		case Evento.GUIAltaProveedor:
			return new VAltaProveedor();
		case Evento.GUIBajaProveedor:
			return new VBajaProveedor();
		case Evento.GUIMostrarUnProveedor:
			return new VMostrarUno("Proveedor");
		case Evento.GUIModificarProveedor:
			return new VModificar("Proveedor");
		case Evento.MostrarUnProveedor:
			return new VMostrarUnProveedor();
		case Evento.MostrarTodosLosProveedores:
			return new VMostrarTodosLosProveedores();
		case Evento.MostrarModificarProveedor:
			return new VModificarProveedor();
		
		//MARCA
		case Evento.MostrarGUIMarca:
			return new GUIMarca();
		case Evento.GUIAltaMarca:
			return new VAltaMarca();
		case Evento.GUIBajaMarca:
			return new VBajaMarca();
		case Evento.GUIMostrarUnaMarca:
			return new VMostrarUno("Marca");
		case Evento.GUIModificarMarca:
			return new VModificar("Marca");
		case Evento.MostrarModificarMarca:
			return new VModificarMarca();
		case Evento.MostrarUnaMarca:
			return new VMostrarUnaMarca();
		case Evento.MostrarTodasLasMarcas:
			return new VMostrarTodasLasMarcas();
		
		//PROVEEDOR-PRODUCTO
		case Evento.MostrarGUIProveedorProducto:
			return new GUIProveedorProducto();
		case Evento.GUIAniadirProveedor:
			return new VAniadirProveedor();
		case Evento.GUIEliminarProveedor:
			return new VEliminarProveedor();
		case Evento.GUIEliminarProveedores:
			return new VEliminarProveedores();
		}
		return null;
	}

}
