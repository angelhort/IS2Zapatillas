package presentacion.VComunes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VModificar extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	private String entidad = null;
	
	public VModificar(String entidad){
		super("Foot World");
		this.entidad = entidad;
		this.setBounds(100, 100, 330, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	public void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Modificar un " + entidad, 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 19));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		JLabel labelID = ComponentsBuilder.createLabel("ID " + entidad +":", 10, 100, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 13));
		this.add(labelID);
		
		JTextField fieldID = ComponentsBuilder.createTextField(100, 100, 200, 20);
		this.add(fieldID);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(entidad) {
				case "Cliente": Controller.getInstance().action(Evento.MostrarGUICliente, null);
				break;
				case "Almacen": Controller.getInstance().action(Evento.MostrarGUIAlmacen, null);
				break;
				case "Trabajador": Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
				break;
				case "Marca": Controller.getInstance().action(Evento.MostrarGUIMarca, null);
				break;
				case "Producto": Controller.getInstance().action(Evento.MostrarGUIProducto, null);
				break;
				case "Proveedor": Controller.getInstance().action(Evento.MostrarGUIProveedor, null);
				break;
				
				default : Controller.getInstance().action(Evento.MostrarGUIPrincipal, null);			
				
				}
				VModificar.this.setVisible(false);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 140, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch(entidad) {
				case "Cliente": Controller.getInstance().action(Evento.ModificarCliente, fieldID.getText());
				break;
				case "Almacen": Controller.getInstance().action(Evento.ModificarAlmacen, fieldID.getText());
				break;
				case "Trabajador": Controller.getInstance().action(Evento.ModificarTrabajador, fieldID.getText());
				break;
				case "Marca": Controller.getInstance().action(Evento.ModificarMarca, fieldID.getText());
				break;
				case "Producto": Controller.getInstance().action(Evento.ModificarProducto, fieldID.getText());
				break;
				case "Proveedor": Controller.getInstance().action(Evento.ModificarProveedor, fieldID.getText());
				break;
				
				default : Controller.getInstance().action(Evento.MostrarGUIPrincipal, fieldID.getText());			
				
				}
				VModificar.this.setVisible(false);
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.GUIModificarMarca:
		case Evento.GUIModificarProveedor:
		case Evento.GUIModificarProducto:
		case Evento.GUIModificarAlmacen:
		case Evento.GUIModificarTrabajador: 
		case Evento.GUIModificarCliente : this.setVisible(true);
		break;
	}
	}
}
