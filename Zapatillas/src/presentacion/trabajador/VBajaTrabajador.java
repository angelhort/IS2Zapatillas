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

import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VBajaTrabajador extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VBajaTrabajador() {
		super("Foot World");
		this.setBounds(100, 100, 330, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	public void initGUI() {
		JLabel labelTrabajador = ComponentsBuilder.createLabel("Baja Trabajador", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 26));
		this.add(labelTrabajador);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		JLabel labelID = ComponentsBuilder.createLabel("ID Trabajador:", 10, 100, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 12));
		this.add(labelID);
		
		JTextField fieldID = ComponentsBuilder.createTextField(100, 100, 200, 20);
		this.add(fieldID);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
				VBajaTrabajador.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 140, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VBajaTrabajador.this.dispose();
				Controller.getInstance().action(Evento.BajaTrabajador, fieldID.getText());
				Controller.getInstance().action(Evento.MostrarGUITrabajador, null);
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.GUIBajaTrabajador:
		this.setVisible(true);
		break;
		
		case Evento.TrabajadorOK:
			JOptionPane.showMessageDialog(this,"El trabajador se dio de baja", "Baja Trabajador", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Evento.TrabajadorKO:
			JOptionPane.showMessageDialog(this,"El trabajador no existe o ya esta dado de baja", "ERROR Baja Trabajador", JOptionPane.ERROR_MESSAGE);
			break;
	}
	}
}
