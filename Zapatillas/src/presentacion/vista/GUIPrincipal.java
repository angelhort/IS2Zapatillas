package presentacion.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.cliente.GUICliente;

public class GUIPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public GUIPrincipal() {		
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	private void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("Selecciona la entidad sobre la que trabajar", 50, 30, 900, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		
		this.add(label);
		
		JButton buttonCliente = ComponentsBuilder.createButton("Cliente", 50, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonCliente);
		
		ActionListener lCliente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GUICliente guiCliente = new GUICliente();
				guiCliente.initGUI();
			}
			
		};
		
		buttonCliente.addActionListener(lCliente);
		
		JButton buttonTrabajador = ComponentsBuilder.createButton("Trabajador", 288, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonTrabajador);
		
		ActionListener lTrabajador = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lTrabajador);
		
		JButton buttonVenta = ComponentsBuilder.createButton("Venta", 526, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonVenta);
		
		ActionListener lVenta = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lVenta);
		
		JButton buttonAlmacen = ComponentsBuilder.createButton("Almacen", 764, 120, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAlmacen);
		
		ActionListener lAlmacen = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lAlmacen);
		
		JButton buttonProducto = ComponentsBuilder.createButton("Producto", 50, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonProducto);
		
		ActionListener lProducto = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lProducto);
		
		JButton buttonProveedor = ComponentsBuilder.createButton("Proveedor", 288, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonProveedor);
		
		ActionListener lProveedor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lProveedor);
		
		JButton buttonMarca = ComponentsBuilder.createButton("Marca", 526, 290, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonMarca);
		
		ActionListener lMarca = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lMarca);
		
		JButton buttonProdProv = ComponentsBuilder.createButton("Productos - Proveedores", 764, 290, 185, 100, new Font("Serif", Font.PLAIN, 13));
		this.add(buttonProdProv);
		
		ActionListener lProdProv = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		};
		
		buttonCliente.addActionListener(lProdProv);
	}
	
}