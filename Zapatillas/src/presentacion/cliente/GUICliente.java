package presentacion.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.mostrar.VMostrarUno;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;
import presentacion.vista.GUIPrincipal;

public class GUICliente extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUICliente() {		
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setVisible(true);
		this.setContentPane(new JLabel(new ImageIcon("resources/Logo1.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void initGUI(GUIPrincipal instance) {
		JLabel label = ComponentsBuilder.createLabel("Cliente", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAlta = ComponentsBuilder.createButton("Alta Cliente", 100, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAlta);
		
		ActionListener lAlta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaCliente frameAlta = new VAltaCliente();
				frameAlta.initGUI(GUICliente.this);
				GUICliente.this.setVisible(false);
			}
			
		};
		
		buttonAlta.addActionListener(lAlta);
		
		JButton buttonBaja = ComponentsBuilder.createButton("Baja Cliente", 407, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonBaja);
		
		ActionListener lBaja = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VBajaCliente frameBaja = new VBajaCliente();
				frameBaja.initGUI(GUICliente.this);
				GUICliente.this.setVisible(false);
			}
			
		};
		
		buttonBaja.addActionListener(lBaja);
		
		JButton buttonModificar = ComponentsBuilder.createButton("Modificar Cliente", 715, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonModificar);
		
		ActionListener lModificar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonModificar.addActionListener(lModificar);
		
		JButton buttonMostrarUno = ComponentsBuilder.createButton("Mostrar un Cliente", 213, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonMostrarUno);
		
		ActionListener lMostrarUno = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarUno frameMostrarUno = new VMostrarUno("Cliente");
				frameMostrarUno.initGUI(GUICliente.this);
				GUICliente.this.setVisible(false);
			}
			
		};
		
		buttonMostrarUno.addActionListener(lMostrarUno);
		
		JButton buttonMostrarTodos = ComponentsBuilder.createButton("Mostrar todos los Clientes", 602, 290, 185, 100, new Font("Serif", Font.PLAIN, 14));
		this.add(buttonMostrarTodos);
		
		ActionListener lMostrarTodos = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			}
			
		};
		
		buttonMostrarTodos.addActionListener(lMostrarTodos);
		
		JButton atrasButton = ComponentsBuilder.createBackButton();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				GUICliente.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar() {
		
	}
}
