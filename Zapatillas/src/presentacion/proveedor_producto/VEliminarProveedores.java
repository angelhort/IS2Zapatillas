package presentacion.proveedor_producto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentacion.vista.ComponentsBuilder;

public class VEliminarProveedores extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public VEliminarProveedores() {
		super("Foot World");
		this.setBounds(100, 100, 330, 230);
		this.setVisible(true);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI(JFrame instance) {
		JLabel labelTrabajador = ComponentsBuilder.createLabel("<html>Eliminar proveedores<br>a producto</html>", 85, 20, 190, 70, Color.BLACK, new Font("Serif", Font.PLAIN, 22));
		this.add(labelTrabajador);
		
		JLabel labelIDProducto = ComponentsBuilder.createLabel("ID Producto:", 10, 100, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelIDProducto);
		
		JTextField fieldIDProducto = ComponentsBuilder.createTextField(100, 102, 200, 20);
		this.add(fieldIDProducto);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				VEliminarProveedores.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 140, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}
}
