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

import presentacion.vista.ComponentsBuilder;

public class VAltaProducto extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public VAltaProducto() {
		super("Foot World");
		this.setBounds(100, 100, 330, 350);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x350.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI(JFrame instance) {
		
		//initSelectGUI(instance);
		
		JLabel labelProducto = ComponentsBuilder.createLabel("Alta Producto", 85, 20, 190, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(labelProducto);
		
		JLabel labelNombre = ComponentsBuilder.createLabel("Nombre:", 10, 100, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelNombre);
		
		JTextField fieldNombre = ComponentsBuilder.createTextField(80, 100, 220, 20);
		this.add(fieldNombre);
		
		JLabel labelTelef = ComponentsBuilder.createLabel("Stock:", 10, 150, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTelef);
		
		JTextField fieldTelef = ComponentsBuilder.createTextField(80, 150, 40, 20);
		this.add(fieldTelef);
		
		JLabel labelPrecio = ComponentsBuilder.createLabel("Precio:", 10, 200, 60, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelPrecio);
		
		JTextField fieldPrecio = ComponentsBuilder.createTextField(80, 200, 40, 20);
		this.add(fieldPrecio);
		
		JLabel labelTalla = ComponentsBuilder.createLabel("Talla:", 130, 150, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelTalla);
		
		JLabel labelColor = ComponentsBuilder.createLabel("Color:", 130, 200, 50, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelColor);
		
		ArrayList<String> colors = new ArrayList<String>() {{add("Azul"); add("Rojo"); add("Verde");}};
		JComboBox<String> comboColor = ComponentsBuilder.createComboBox(colors, 190, 202, 110, 20);
		this.add(comboColor);
		
		ArrayList<String> talla = new ArrayList<String>() {{add("40"); add("41"); add("42");}};
		JComboBox<String> comboTalla = ComponentsBuilder.createComboBox(talla, 190, 152, 110, 20);
		this.add(comboTalla);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				VAltaProducto.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 250, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}
	
	private void initSelectGUI(JFrame instance) {
		
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
			}
			
		};
		
		zapatillaButton.addActionListener(lZapatillas);
		
		JButton calcetinButton = ComponentsBuilder.createButton("Calcetines", 180, 110, 100, 30, new Font("Serif", Font.PLAIN, 14));
		frameEleccion.add(calcetinButton);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		frameEleccion.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				frameEleccion.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}
}
