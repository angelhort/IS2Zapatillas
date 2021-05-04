package main;

import presentacion.controller.Controller;
import presentacion.controller.Evento;

public class Main {

	public static void main(String[] args) {
		Controller.getInstance().action(Evento.MostrarGUIPrincipal, null);;
	}

}
