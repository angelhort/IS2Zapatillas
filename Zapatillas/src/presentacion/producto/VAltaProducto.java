package presentacion.producto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VAltaProducto extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
		
	public VAltaProducto() {
		super("Foot World");
		this.setBounds(100, 100, 330, 450);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x450.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initSelectGUI();
		this.setVisible(false);
	}
	
	public void initGUI(String tipoProducto) {
		this.setVisible(true);
		JLabel labelProducto = ComponentsBuilder.createLabel("Alta " + tipoProducto, 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(labelProducto);
		
		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelNombre);
		
		JTextField fieldNombre = ComponentsBuilder.createTextField(80, 100, 220, 20);
		this.add(fieldNombre);
		
		JLabel labelTelef = ComponentsBuilder.createLabel("Stock:", 10, 150, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTelef);
		
		JTextField fieldTelef = ComponentsBuilder.createTextField(80, 150, 55, 20);
		this.add(fieldTelef);
		
		JLabel labelPrecio = ComponentsBuilder.createLabel("Precio:", 10, 200, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelPrecio);
		
		JTextField fieldPrecio = ComponentsBuilder.createTextField(80, 200, 55, 20);
		this.add(fieldPrecio);
		
		JLabel labelTalla = ComponentsBuilder.createLabel("Talla:", 145, 150, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTalla);
		
		JLabel labelColor = ComponentsBuilder.createLabel("Color:", 145, 200, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelColor);
		
		@SuppressWarnings("serial")
		ArrayList<String> talla = new ArrayList<String>() {{add("40"); add("41"); add("42");}};
		JComboBox<String> comboTalla = ComponentsBuilder.createComboBox(talla, 200, 152, 100, 20);
		this.add(comboTalla);
		
		@SuppressWarnings("serial")
		ArrayList<String> colors = new ArrayList<String>() {{add("Azul"); add("Rojo"); add("Verde");}};
		JComboBox<String> comboColor = ComponentsBuilder.createComboBox(colors, 200, 202, 100, 20);
		this.add(comboColor);
		
		JLabel labelMarca = ComponentsBuilder.createLabel("ID Marca:", 10, 250, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelMarca);
		
		JTextField fieldMarca = ComponentsBuilder.createTextField(80, 250, 55, 20);
		this.add(fieldMarca);
		
		if(tipoProducto == "Zapatillas") {
			JLabel labelTipo = ComponentsBuilder.createLabel("Tipo:", 145, 250, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
			this.add(labelTipo);
			@SuppressWarnings("serial")
			ArrayList<String> tipo = new ArrayList<String>() {{add("Deportivas"); add("Casual"); add("Futbol");}};
			JComboBox<String> comboTipo = ComponentsBuilder.createComboBox(tipo, 200, 252, 100, 20);
			this.add(comboTipo);
		}
		else if(tipoProducto == "Calcetines") {
			JLabel labelTejido = ComponentsBuilder.createLabel("Tejido:", 145, 250, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
			this.add(labelTejido);
			@SuppressWarnings("serial")
			ArrayList<String> tejido = new ArrayList<String>() {{add("Seda"); add("Algodon"); add("Lana");}};
			JComboBox<String> comboTejido = ComponentsBuilder.createComboBox(tejido, 200, 252, 100, 20);
			this.add(comboTejido);
		}
		
		
		JLabel labelAlmacen = ComponentsBuilder.createLabel("ID Almacen:", 10, 300, 70, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelAlmacen);
		
		JTextField fieldAlmacen = ComponentsBuilder.createTextField(90, 300, 210, 20);
		this.add(fieldAlmacen);
		
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.MostrarGUIProducto, null);
				VAltaProducto.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 350, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}
	
	private void initSelectGUI() {
		
		JFrame frameEleccion = new JFrame("Foot World");
		frameEleccion.setBounds(100, 100, 330, 230);
		frameEleccion.setVisible(true);
		frameEleccion.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		frameEleccion.setLayout(null);
		frameEleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel labelEleccion = ComponentsBuilder.createLabel("¿Que prodcuto desea añadir?", 65, 20, 230, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 20));
		frameEleccion.add(labelEleccion);
		
		JButton zapatillaButton = ComponentsBuilder.createButton("Zapatillas", 40, 110, 100, 30, new Font("Serif", Font.PLAIN, 14));
		frameEleccion.add(zapatillaButton);
		
		ActionListener lZapatillas = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameEleccion.dispose();
				VAltaProducto.this.initGUI("Zapatillas");
			}
			
		};
		
		zapatillaButton.addActionListener(lZapatillas);
		
		JButton calcetinButton = ComponentsBuilder.createButton("Calcetines", 180, 110, 100, 30, new Font("Serif", Font.PLAIN, 14));
		frameEleccion.add(calcetinButton);
		
		ActionListener lCalcetines = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameEleccion.dispose();
				VAltaProducto.this.initGUI("Calcetines");
			}
			
		};
		
		calcetinButton.addActionListener(lCalcetines);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		frameEleccion.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameEleccion.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProducto, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		
	}
}
