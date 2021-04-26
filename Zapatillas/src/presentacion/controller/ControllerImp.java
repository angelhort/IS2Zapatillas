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
				int id = SAAbstractFactory.getInstance().getSACliente().alta((TransferCliente)datos);
				break;
			case Evento.ModificarCliente:
				//TODO MANDAR EL ID A LA BD Y QUE DEVUELVA UN TRANSFER CON LOS DATOS DE LA ENTIDAD
				gui.actualizar(Evento.ModificarCliente, new TransferCliente("Angel Hortelano", true, "98765432P")); //PARA PROBAR QUE FUNCIONA
				break;
				
			case Evento.ModificarAlmacen:
				//TODO MANDAR EL ID A LA BD Y QUE DEVUELVA UN TRANSFER CON LOS DATOS DE LA ENTIDAD
				gui.actualizar(Evento.ModificarAlmacen, new TransferAlmacen(87654329, 5000, "Paseo de la Castellana Nº3")); //PARA PROBAR QUE FUNCIONA
				break;
				
			default: if(gui != null) gui.actualizar(evento, datos);
		}
	}

}
