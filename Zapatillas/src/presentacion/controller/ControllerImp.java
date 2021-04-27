package presentacion.controller;

import negocio.FactoriaSA.SAAbstractFactory;
import negocio.almacen.TransferAlmacen;
import negocio.cliente.TransferCliente;
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
		
		/* if(((evento/10) % 10) == 0)
			gui = (vistas.get(evento/100)).get(evento%100);			
		
		else
			gui = (vistas.get(evento/100).get(0));*/
		
		switch(evento) {
			case Evento.AltaCliente:
				// Angel TODO: SI ID = -1 ERROR, SINO EXITO
				id = SAAbstractFactory.getInstance().getSACliente().alta((TransferCliente)datos);
				break;
			case Evento.MostrarModificarCliente:
				/* GUILLE TODO: Este evento debería de llamarse de otra manera, no modifica.
				 * Debería ser algo como MostrarModificarCliente y este dejarlo para cuando se envie el form */
				TransferCliente cliente = SAAbstractFactory.getInstance().getSACliente().mostrarUno(Integer.parseInt((String) datos));
				gui.actualizar(Evento.MostrarModificarCliente, cliente);
				break;
			case Evento.BajaCliente:
				id = SAAbstractFactory.getInstance().getSACliente().borrar(Integer.parseInt((String) datos));
				break;
				
			case Evento.ModificarAlmacen:
				//TODO MANDAR EL ID A LA BD Y QUE DEVUELVA UN TRANSFER CON LOS DATOS DE LA ENTIDAD
				gui.actualizar(Evento.ModificarAlmacen, new TransferAlmacen(87654329, 5000, "Paseo de la Castellana Nº3")); //PARA PROBAR QUE FUNCIONA
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
