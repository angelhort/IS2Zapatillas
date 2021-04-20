package presentacion.controller;

import java.util.List;

import java.util.ArrayList;

import presentacion.almacen.*;
import presentacion.cliente.*;
import presentacion.marca.*;
import presentacion.mostrar.*;
import presentacion.producto.*;
import presentacion.proveedor.*;
import presentacion.proveedor_producto.*;
import presentacion.trabajador.*;
import presentacion.vista.GUIPrincipal;
import presentacion.vista.IGUI;

public class ControllerImp extends Controller{
	
	private IGUI gui;
	private GUIPrincipal guiPrincipal;
	
	private List<Object> vistas;
	
	public ControllerImp() {
		
		guiPrincipal = new GUIPrincipal();
		vistas = new ArrayList<>();
		
		vistas.add(guiPrincipal);
		vistas.add(new GUICliente());
		vistas.add(new GUITrabajador());
		vistas.add(null); 				//TODO VENTA
		vistas.add(new GUIAlmacen());
		vistas.add(new GUIProducto());
		vistas.add(new GUIProveedor());
		vistas.add(new GUIMarca());
		vistas.add(new GUIProveedorProducto());
	}

	@Override
	public void action(int evento, Object datos) {
		
		gui = (IGUI) vistas.get(evento/100);
		
		switch(evento) {
			case Evento.MostrarGUIPrincipal:
				gui.actualizar(Evento.MostrarGUIPrincipal, datos);
				break;
				
			case Evento.MostrarGUICliente : 
				gui.actualizar(Evento.MostrarGUICliente, null);
				break;
					
			case Evento.GUIAltaCliente:
				VAltaCliente altaCliente = new VAltaCliente();
				break;
				
			case Evento.GUIBajaCliente:
				VBajaCliente bajaCliente = new VBajaCliente();
				break;
				
			case Evento.GUIMostrarUnCliente:
				VMostrarUno mostrarUnCliente = new VMostrarUno("Cliente");
				break;
				
			case Evento.MostrarGUIAlmacen : 
				gui.actualizar(Evento.MostrarGUIAlmacen, null);
				break;
					
			case Evento.GUIAltaAlmacen:
				VAltaAlmacen altaAlmacen = new VAltaAlmacen();
				break;
				
			case Evento.GUIBajaAlmacen:
				VBajaAlmacen bajaAlmacen = new VBajaAlmacen();
				break;
				
			case Evento.GUIMostrarUnAlmacen:
				VMostrarUno mostrarUnAlmacen = new VMostrarUno("Almacen");
				break;
				
			case Evento.MostrarGUIMarca : 
				gui.actualizar(Evento.MostrarGUIMarca, null);
				break;
					
			case Evento.GUIAltaMarca:
				VAltaMarca altaMarca = new VAltaMarca();
				break;
				
			case Evento.GUIBajaMarca:
				VBajaMarca bajaMarca = new VBajaMarca();
				break;
				
			case Evento.GUIMostrarUnaMarca:
				VMostrarUno mostrarUnaMarca = new VMostrarUno("Marca");
				break;
				
			case Evento.MostrarGUIProducto : 
				gui.actualizar(Evento.MostrarGUIProducto, null);
				break;
					
			case Evento.GUIAltaProducto:
				VAltaProducto altaProducto = new VAltaProducto();
				break;
				
			case Evento.GUIBajaProducto:
				VBajaProducto bajaProducto = new VBajaProducto();
				break;
				
			case Evento.GUIMostrarUnProducto:
				VMostrarUno mostrarUnProducto = new VMostrarUno("Producto");
				break;
				
			case Evento.MostrarGUIProveedor : 
				gui.actualizar(Evento.MostrarGUIProveedor, null);
				break;
					
			case Evento.GUIAltaProveedor:
				VAltaProveedor altaProveedor = new VAltaProveedor();
				break;
				
			case Evento.GUIBajaProveedor:
				VBajaProveedor bajaProveedor = new VBajaProveedor();
				break;
				
			case Evento.GUIMostrarUnProveedor:
				VMostrarUno mostrarUnProveedor = new VMostrarUno("Proveedor");
				break;
				
			case Evento.MostrarGUITrabajador : 
				gui.actualizar(Evento.MostrarGUITrabajador, null);
				break;
					
			case Evento.GUIAltaTrabajador:
				VAltaTrabajador altaTrabajador = new VAltaTrabajador();
				break;
				
			case Evento.GUIBajaTrabajador:
				VBajaTrabajador bajaTrabajador = new VBajaTrabajador();
				break;
				
			case Evento.GUIMostrarUnTrabajador:
				VMostrarUno mostrarUnTrabajador = new VMostrarUno("Trabajador");
				break;
				
			case Evento.MostrarGUIProveedorProducto: 
				gui.actualizar(Evento.MostrarGUIProveedorProducto, null);
				break;
				
			case Evento.GUIAniadirProveedor: 
				VAniadirProveedor aniadirProveedor = new VAniadirProveedor();
				break;
				
			case Evento.GUIEliminarProveedor:
				VEliminarProveedor eliminarProveedor = new VEliminarProveedor();
				break;	
				
			case Evento.GUIEliminarProveedores:
				VEliminarProveedores eliminarProveedores = new VEliminarProveedores();
				break;
		}
	}

}
