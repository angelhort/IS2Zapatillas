package presentacion.proveedor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.proveedor.TransferProveedor;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VModificarProveedor extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VModificarProveedor() {
		super("Foot World");
		this.setBounds(100, 100, 330, 350);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x350.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI(TransferProveedor proveedor) {
		this.setVisible(true);
		JLabel labelProveedor = ComponentsBuilder.createLabel("Modificar Proveedor", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 22));
		this.add(labelProveedor);
		
		JLabel labelDireccion = ComponentsBuilder.createLabel("Direccion:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelDireccion);
		
		JTextField fieldDireccion = ComponentsBuilder.createTextField(80, 100, 220, 20);
		fieldDireccion.setText(proveedor.getDireccion());
		this.add(fieldDireccion);
		
		JLabel labelTelef = ComponentsBuilder.createLabel("Telefono:", 10, 150, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTelef);
		
		JTextField fieldTelef = ComponentsBuilder.createTextField(80, 150, 220, 20);
		fieldTelef.setText(proveedor.getTelefono() + "");
		this.add(fieldTelef);
		
		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre:", 10, 200, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelNombre);
		
		JTextField fieldNombre = ComponentsBuilder.createTextField(80, 200, 220, 20);
		fieldNombre.setText(proveedor.getNombre());
		this.add(fieldNombre);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUIProveedor, null);
				VModificarProveedor.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 250, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.ModificarProveedor, new TransferProveedor(proveedor.getID(),
																		Integer.parseInt(fieldTelef.getText()),
																		fieldDireccion.getText(), 
																		fieldNombre.getText(), true));
				VModificarProveedor.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProveedor, null);	
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento){
		case Evento.MostrarModificarProveedor:
			initGUI((TransferProveedor) datos);	
			break;
		}
	}
}