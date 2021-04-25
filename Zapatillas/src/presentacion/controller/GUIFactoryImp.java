package presentacion.controller;

import presentacion.VComunes.*;
import presentacion.almacen.*;
import presentacion.cliente.*;
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
		case Evento.ModificarCliente:
			return new GUICliente();
		case Evento.GUIAltaCliente:
			return new VAltaCliente();
		case Evento.GUIBajaCliente:
			return new VBajaCliente();
		case Evento.GUIMostrarUnCliente:
			return new VMostrarUno("Cliente");
		case Evento.GUIModificarCliente:
			return new VModificar("Cliente");
		
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
		
		//VENTA
		case Evento.MostrarGUIVenta: //TODO VENTA
			break;
		
		//ALMACEN
		case Evento.MostrarGUIAlmacen:
		case Evento.ModificarAlmacen:
			return new GUIAlmacen();
		case Evento.GUIAltaAlmacen:
			return new VAltaAlmacen();
		case Evento.GUIBajaAlmacen:
			return new VBajaAlmacen();
		case Evento.GUIMostrarUnAlmacen:
			return new VMostrarUno("Almacen");
		case Evento.GUIModificarAlmacen:
			return new VModificar("Almacen");
			
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