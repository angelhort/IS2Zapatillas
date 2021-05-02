package presentacion.controller;

import negocio.FactoriaSA.SAAbstractFactory;
import negocio.almacen.TransferAlmacen;
import negocio.cliente.TransferCliente;
import negocio.marca.TransferMarca;
import negocio.proveedor.TransferProveedor;
import negocio.trabajador.TransferTrabajador;
import presentacion.factoryGUI.GUIFactory;
import presentacion.vista.GUIPrincipal;
import presentacion.vista.IGUI;

public class ControllerImp extends Controller{
		
	public ControllerImp() {
		@SuppressWarnings("unused")
		GUIPrincipal principal = new GUIPrincipal();
	}

	@Override
	public void action(int evento, Object datos) {
		
		IGUI gui = GUIFactory.getInstance().getFrame(evento);
		int id;
		
		switch(evento) {
		//CLIENTE
			case Evento.AltaCliente:
				// Angel TODO: SI ID = -1 ERROR, SINO EXITO
				id = SAAbstractFactory.getInstance().getSACliente().alta((TransferCliente)datos);
				if(id != -1)gui.actualizar(Evento.ClienteOK, id);
				else gui.actualizar(Evento.ClienteKO, null);
				break;
				
			case Evento.MostrarModificarCliente:
				TransferCliente cliente = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarCliente, cliente);
				break;
				
			case Evento.BajaCliente:
				id = SAAbstractFactory.getInstance().getSACliente().borrar(Integer.parseInt((String) datos));
				break;	
				
			case Evento.ModificarCliente:
				SAAbstractFactory.getInstance().getSACliente().modificar((TransferCliente) datos);
				break;
				
			case Evento.MostrarUnCliente: 
				gui.actualizar(Evento.MostrarUnCliente, SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos)));
				break;
				
			case Evento.MostrarTodosLosClientes:
				gui.actualizar(Evento.MostrarTodosLosClientes, SAAbstractFactory.getInstance().getSACliente().mostrarTodos());
				break;
		//MARCA
			case Evento.AltaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().alta((TransferMarca)datos);
				break;
			case Evento.BajaMarca:
				id = SAAbstractFactory.getInstance().getSAMarca().borrar(Integer.parseInt((String) datos));
				break;
			case Evento.MostrarModificarMarca:
				TransferMarca marca = SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarMarca, marca);
				break;
			case Evento.ModificarMarca:
				SAAbstractFactory.getInstance().getSAMarca().modificar((TransferMarca) datos);
				break;
			case Evento.MostrarUnaMarca:
				gui.actualizar(Evento.MostrarUnaMarca, SAAbstractFactory.getInstance().getSAMarca().mostrarUno(Integer.parseInt((String) datos)));
				break;
			case Evento.MostrarTodasLasMarcas:
				gui.actualizar(Evento.MostrarTodasLasMarcas, SAAbstractFactory.getInstance().getSAMarca().mostrarTodos());
				break;
		//TRABAJADOR
			case Evento.AltaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().alta((TransferTrabajador) datos);
				break;
			case Evento.BajaTrabajador:
				id = SAAbstractFactory.getInstance().getSATrabajador().borrar(Integer.parseInt((String) datos));
				break;
			case Evento.MostrarTodosLosTrabajadores:
				gui.actualizar(Evento.MostrarTodosLosTrabajadores, SAAbstractFactory.getInstance().getSATrabajador().mostrarTodos());
				break;
			case Evento.MostrarModificarTrabajador:
				TransferTrabajador trabajador = SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarTrabajador, trabajador);
				break;
			case Evento.ModificarTrabajador:
				SAAbstractFactory.getInstance().getSATrabajador().modificar((TransferTrabajador) datos);
				break;
			case Evento.MostrarUnTrabajador:
				gui.actualizar(Evento.MostrarUnTrabajador, SAAbstractFactory.getInstance().getSATrabajador().mostrarUno(Integer.parseInt((String) datos)));
				break;
			
		//PROVEEDOR
			case Evento.AltaProveedor:
				// Angel TODO: SI ID = -1 ERROR, SINO EXITO
				id = SAAbstractFactory.getInstance().getSAProveedor().alta((TransferProveedor)datos);
				break;
			
			case Evento.BajaProveedor:
				id = SAAbstractFactory.getInstance().getSAProveedor().borrar(Integer.parseInt((String) datos));
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
				SAAbstractFactory.getInstance().getSAProveedor().modificar((TransferProveedor) datos);
				break;
				
		//ALMACEN
			case Evento.AltaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().alta((TransferAlmacen) datos);
				break;
			case Evento.MostrarTodosLosAlmacenes:
				gui.actualizar(Evento.MostrarTodosLosAlmacenes, SAAbstractFactory.getInstance().getSAAlmacen().mostrarTodos());
				break;
			case Evento.BajaAlmacen:
				id = SAAbstractFactory.getInstance().getSAAlmacen().borrar(Integer.parseInt((String) datos));
				break;
			case Evento.MostrarModificarAlmacen:
				TransferAlmacen almacen = SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarAlmacen, almacen);
				break;
			case Evento.ModificarAlmacen:
				SAAbstractFactory.getInstance().getSAAlmacen().modificar((TransferAlmacen) datos);
				break;
			case Evento.MostrarUnAlmacen:
				gui.actualizar(Evento.MostrarUnAlmacen, SAAbstractFactory.getInstance().getSAAlmacen().mostrarUno(Integer.parseInt((String) datos)));
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
