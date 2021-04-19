package presentacion.almacen;

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
import presentacion.vista.GUIPrincipal;
import presentacion.vista.IGUI;

public class GUIAlmacen extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIAlmacen() {		
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setVisible(true);
		this.setContentPane(new JLabel(new ImageIcon("resources/Logo1.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void initGUI(GUIPrincipal instance) {
		JLabel label = ComponentsBuilder.createLabel("Almacen", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAlta = ComponentsBuilder.createButton("Alta Almacen", 100, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAlta);
		
		ActionListener lAlta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAltaAlmacen frameAlta = new VAltaAlmacen();
				frameAlta.initGUI(GUIAlmacen.this);
				GUIAlmacen.this.setVisible(false);
			}
			
		};
		
		buttonAlta.addActionListener(lAlta);
		
		JButton buttonBaja = ComponentsBuilder.createButton("Baja Almacen", 407, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonBaja);
		
		ActionListener lBaja = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VBajaAlmacen frameBaja = new VBajaAlmacen();
				frameBaja.initGUI(GUIAlmacen.this);
				GUIAlmacen.this.setVisible(false);
			}
			
		};
		
		buttonBaja.addActionListener(lBaja);
		
		JButton buttonModificar = ComponentsBuilder.createButton("Modificar Almacen", 715, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonModificar);
		
		ActionListener lModificar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonModificar.addActionListener(lModificar);
		
		JButton buttonMostrarUno = ComponentsBuilder.createButton("Mostrar un Almacen", 213, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonMostrarUno);
		
		ActionListener lMostrarUno = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarUno frameMostrarUno = new VMostrarUno("Almacen");
				frameMostrarUno.initGUI(GUIAlmacen.this);
				GUIAlmacen.this.setVisible(false);
			}
			
		};
		
		buttonMostrarUno.addActionListener(lMostrarUno);
		
		JButton buttonMostrarTodos = ComponentsBuilder.createButton("Mostrar todos los Almacenes", 602, 290, 185, 100, new Font("Serif", Font.PLAIN, 12));
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
				GUIAlmacen.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar() {
		
	}
}
