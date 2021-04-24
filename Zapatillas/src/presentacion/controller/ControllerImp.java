package presentacion.controller;

import java.util.List;

import negocio.cliente.SAClienteImp;
import negocio.cliente.TransferCliente;
import negocio.sa.SAAbstractFactory;

import java.util.ArrayList;

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

public class ControllerImp extends Controller{
	
	private List<List<IGUI>> vistas;
	
	public ControllerImp() {
		//SE INICIALIZAN TODAS LAS VISTAS Y SE INTRODUCEN EN LA MATRIZ VISTAS
		// LOS EVENTOS TIENEN 3 NUMEROS: EL PRIMERO REPRESENTA LA ENTIDAD Y EL ULTIMO LA FUNCION
		
		initGUIs();
	}

	@SuppressWarnings("null")
	@Override
	public void action(int evento, Object datos) {
		
		IGUI gui;
		
		if(((evento/10) % 10) == 0)
			gui = (vistas.get(evento/100)).get(evento%100);			
		
		else
			gui = null;
		
		switch(evento) {
			case Evento.AltaCliente:
				SAClienteImp t = (SAClienteImp) SAAbstractFactory.getInstance().getSA(evento);
				
				t.alta((TransferCliente) datos);
				
				break;
			case Evento.ModificarCliente:
				//TODO MANDAR EL ID A LA BD Y QUE DEVUELVA UN TRANSFER CON LOS DATOS DE LA ENTIDAD
				vistas.get(1).get(0).actualizar(Evento.ModificarCliente, new TransferCliente("Angel Hortelano", true, "98765432P")); //PARA PROBAR QUE FUNCIONA
				break;
				
			default: gui.actualizar(evento, datos);
		}
	}
	
	private void initGUIs() {
		//HE HABLADO CON ANTONIO Y CON HECTOR Y HECTOR ME RECOMENDO HACERLO ASI
		// Y ANTONIO ME LO PERMITIO, TENIENDO EN CUENTA QUE HABRA QUE CAMBIARLO EN 3º
		
		vistas = new ArrayList<>();
		
		List<IGUI> aux = new ArrayList<>();
		
		//GUI Principal
		aux.add(new GUIPrincipal());
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs CLIENTE
		aux.add(new GUICliente());
		aux.add(new VAltaCliente());
		aux.add(new VBajaCliente());
		aux.add(new VModificar("Cliente"));
		aux.add(new VMostrarUno("Cliente"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs TRABAJADOR
		aux.add(new GUITrabajador());
		aux.add(new VAltaTrabajador());
		aux.add(new VBajaTrabajador());
		aux.add(new VModificar("Trabajador"));
		aux.add(new VMostrarUno("Trabajador"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//TODO GUIs VENTA
		vistas.add(new ArrayList<>());
		
		//GUIs ALMACEN
		aux.add(new GUIAlmacen());
		aux.add(new VAltaAlmacen());
		aux.add(new VBajaAlmacen());
		aux.add(new VModificar("Almacen"));
		aux.add(new VMostrarUno("Almacen"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs PRODUCTO
		aux.add(new GUIProducto());
		aux.add(new VAltaProducto());
		aux.add(new VBajaProducto());
		aux.add(new VModificar("Producto"));
		aux.add(new VMostrarUno("Producto"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs PRODUCTO
		aux.add(new GUIProveedor());
		aux.add(new VAltaProveedor());
		aux.add(new VBajaProveedor());
		aux.add(new VModificar("Proveedor"));
		aux.add(new VMostrarUno("Proveedor"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs MARCA
		aux.add(new GUIMarca());
		aux.add(new VAltaMarca());
		aux.add(new VBajaMarca());
		aux.add(new VModificar("Marca"));
		aux.add(new VMostrarUno("Marca"));
		vistas.add(new ArrayList<>(aux));
		aux.clear();
		
		//GUIs PROVEEDOR-PRODUCTO
		aux.add(new GUIProveedorProducto());
		aux.add(new VAniadirProveedor());
		aux.add(new VEliminarProveedor());
		aux.add(new VEliminarProveedores());
		vistas.add(new ArrayList<>(aux));
		aux.clear();
	}

}
