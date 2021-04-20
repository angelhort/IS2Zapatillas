package presentacion.controller;

import java.util.List;
import java.util.ArrayList;

import presentacion.almacen.GUIAlmacen;
import presentacion.cliente.GUICliente;
import presentacion.marca.GUIMarca;
import presentacion.producto.GUIProducto;
import presentacion.proveedor.GUIProveedor;
import presentacion.proveedor_producto.GUIProveedorProducto;
import presentacion.trabajador.GUITrabajador;
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
			case Evento.GUICliente : 
				GUICliente guiCliente = new GUICliente();
				guiCliente.initGUI();
				break;
			
			case Evento.MostrarGUIPrincipal:
				gui.actualizar(Evento.MostrarGUIPrincipal, datos);
				break;
		}
	}

}
