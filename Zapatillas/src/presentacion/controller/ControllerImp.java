package presentacion.controller;

import negocio.almacen.TransferAlmacen;
import negocio.cliente.TransferCliente;
import negocio.sa.SAAbstractFactory;
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
		
		/* if(((evento/10) % 10) == 0)
			gui = (vistas.get(evento/100)).get(evento%100);			
		
		else
			gui = (vistas.get(evento/100).get(0));*/
		
		switch(evento) {
			case Evento.AltaCliente:
				// GUILLE TODO: Es necesario guardarlo en una variable ID?
				int id = SAAbstractFactory.getInstance().getSACliente().alta((TransferCliente)datos);
				break;
			case Evento.ModificarCliente:
				/* GUILLE TODO: Este evento debería de llamarse de otra manera, no modifica.
				 * Debería ser algo como MostrarModificarCliente y este dejarlo para cuando se envie el form */
				
				TransferCliente cliente = SAAbstractFactory.getInstance().getSACliente().mostrarUno((int)datos);
				gui.actualizar(Evento.ModificarCliente, cliente);
				break;
				
			case Evento.ModificarAlmacen:
				//TODO MANDAR EL ID A LA BD Y QUE DEVUELVA UN TRANSFER CON LOS DATOS DE LA ENTIDAD
				gui.actualizar(Evento.ModificarAlmacen, new TransferAlmacen(87654329, 5000, "Paseo de la Castellana Nº3")); //PARA PROBAR QUE FUNCIONA
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
