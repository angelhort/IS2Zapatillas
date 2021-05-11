package presentacion.trabajador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.trabajador.TransferTrabajador;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VAltaTrabajador extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VAltaTrabajador() {
		super("Foot World");
		this.setBounds(100, 100, 330, 350);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x350.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	public void initGUI() {
		JLabel labelTrabajador = ComponentsBuilder.createLabel("Alta Trabajador", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(labelTrabajador);
		
		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelNombre);
		
		JTextField fieldNombre = ComponentsBuilder.createTextField(80, 100, 220, 20);
		this.add(fieldNombre);
		
		JLabel labelTelef = ComponentsBuilder.createLabel("Telefono:", 10, 150, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTelef);
		
		JTextField fieldTelef = ComponentsBuilder.createTextField(80, 150, 220, 20);
		this.add(fieldTelef);
		
		JLabel labelDNI = ComponentsBuilder.createLabel("DNI:", 10, 200, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelDNI);
		
		JTextField fieldDNI = ComponentsBuilder.createTextField(80, 200, 220, 20);
		this.add(fieldDNI);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
				VAltaTrabajador.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 250, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaTrabajador.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
				Controller.getInstance().action(Evento.AltaTrabajador, new TransferTrabajador(Integer.parseInt(fieldTelef.getText()), fieldDNI.getText(), fieldNombre.getText()));
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.GUIAltaTrabajador:
		this.setVisible(true);
		break;
		
		case Evento.TrabajadorOK:
			JOptionPane.showMessageDialog(this,"El trabajador se dio de alta con ID: " + datos, "Alta Trabajador", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Evento.TrabajadorKO:
			JOptionPane.showMessageDialog(this,"El trabajador ya existe o los datos fueron mal introducidos", "ERROR Alta Trabajador", JOptionPane.ERROR_MESSAGE);
			break;
	}
	}
}
