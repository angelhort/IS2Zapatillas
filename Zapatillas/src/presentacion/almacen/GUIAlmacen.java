package presentacion.almacen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.almacen.TransferAlmacen;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class GUIAlmacen extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIAlmacen() {		
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		this.setVisible(true);
	}
	

	public void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Almacen", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAlta = ComponentsBuilder.createButton("Alta Almacen", 100, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAlta);
		
		ActionListener lAlta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.GUIAltaAlmacen, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		buttonAlta.addActionListener(lAlta);
		
		JButton buttonBaja = ComponentsBuilder.createButton("Baja Almacen", 407, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonBaja);
		
		ActionListener lBaja = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.GUIBajaAlmacen, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		buttonBaja.addActionListener(lBaja);
		
		JButton buttonModificar = ComponentsBuilder.createButton("Modificar Almacen", 715, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonModificar);
		
		ActionListener lModificar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.GUIModificarAlmacen, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		buttonModificar.addActionListener(lModificar);
		
		JButton buttonMostrarUno = ComponentsBuilder.createButton("Mostrar un Almacen", 213, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonMostrarUno);
		
		ActionListener lMostrarUno = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.GUIMostrarUnAlmacen, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		buttonMostrarUno.addActionListener(lMostrarUno);
		
		JButton buttonMostrarTodos = ComponentsBuilder.createButton("Mostrar todos los Almacenes", 602, 290, 185, 100, new Font("Serif", Font.PLAIN, 12));
		this.add(buttonMostrarTodos);
		
		ActionListener lMostrarTodos = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarTodosLosAlmacenes, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		buttonMostrarTodos.addActionListener(lMostrarTodos);
		
		JButton atrasButton = ComponentsBuilder.createBackButton();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUIPrincipal, null);
				GUIAlmacen.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {		
		case Evento.ModificarAlmacen:
			this.setVisible(false);
			initModificar((TransferAlmacen) datos);
		break;	
		}
	}


	private void initModificar(TransferAlmacen datos) {
		
		JFrame modificar = new JFrame("Foot World");
		
		modificar.setBounds(100, 100, 330, 350);
		modificar.setContentPane(new JLabel(new ImageIcon("resources/330x350.png")));
		modificar.setLayout(null);
		modificar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modificar.setVisible(true);
		
		JLabel labelAlmacen = ComponentsBuilder.createLabel("Alta Almacen", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		modificar.add(labelAlmacen);
		
		JLabel labelDireccion = ComponentsBuilder.createLabel("Direccion:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		modificar.add(labelDireccion);
		
		JTextField fieldDireccion = ComponentsBuilder.createTextField(80, 100, 220, 20);
		fieldDireccion.setText(datos.getDireccion());
		modificar.add(fieldDireccion);
		
		JLabel labelTelef = ComponentsBuilder.createLabel("Telefono:", 10, 150, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		modificar.add(labelTelef);
		
		JTextField fieldTelef = ComponentsBuilder.createTextField(80, 150, 220, 20);
		fieldTelef.setText("" + datos.getTelefono());
		modificar.add(fieldTelef);
		
		JLabel labelCapacidad = ComponentsBuilder.createLabel("Capacidad:", 10, 200, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 12));
		modificar.add(labelCapacidad);
		
		JTextField fieldCapacidad = ComponentsBuilder.createTextField(80, 200, 220, 20);
		fieldCapacidad.setText("" + datos.getCapacidad());
		modificar.add(fieldCapacidad);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		modificar.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modificar.dispose();
				Controller.getInstance().action(Evento.MostrarGUIAlmacen, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 250, 100, 30, new Font("Serif", Font.PLAIN, 14));
		modificar.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}
}
