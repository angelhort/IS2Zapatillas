package presentacion.venta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class GUIVenta extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;

	public GUIVenta() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
		
	private void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Venta", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAbrir = ComponentsBuilder.createButton("Abrir Venta", 213, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAbrir);
		
		ActionListener lAbrir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.GUIAbrirVenta, null);
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonAbrir.addActionListener(lAbrir);
		
		JButton buttonModificar = ComponentsBuilder.createButton("Modificar Venta", 602, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonModificar);
		
		ActionListener lModificar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonModificar.addActionListener(lModificar);
		
		JButton buttonCerrarVenta = ComponentsBuilder.createButton("Cerrar Venta", 213, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonCerrarVenta);
		
		ActionListener lCerrarVenta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonCerrarVenta.addActionListener(lCerrarVenta);
		
		JButton buttonMostrarVenta = ComponentsBuilder.createButton("Mostrar una Venta", 602, 290, 185, 100, new Font("Serif", Font.PLAIN, 14));
		this.add(buttonMostrarVenta);
		
		ActionListener lMostrarVenta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
			}
			
		};
		
		buttonMostrarVenta.addActionListener(lMostrarVenta);
		
		JButton atrasButton = ComponentsBuilder.createBackButton();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIVenta.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIPrincipal, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
			case Evento.MostrarGUIVenta:
			this.setVisible(true);
			break;
		}
	}

}
