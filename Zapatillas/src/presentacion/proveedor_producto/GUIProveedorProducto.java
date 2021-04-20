package presentacion.proveedor_producto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.vista.ComponentsBuilder;
import presentacion.vista.GUIPrincipal;
import presentacion.vista.IGUI;

public class GUIProveedorProducto extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;

	public GUIProveedorProducto() {		
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	public void initGUI(GUIPrincipal instance) {
		JLabel label = ComponentsBuilder.createLabel("Productos - Proveedores", 250, 30, 500, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton buttonAniadir = ComponentsBuilder.createButton("<html>Aniadir proveedor<br>a producto</html>", 100, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttonAniadir);
		
		ActionListener lAniadir = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAniadirProveedor aniadirProveedor = new VAniadirProveedor();
				aniadirProveedor.initGUI(GUIProveedorProducto.this);
				GUIProveedorProducto.this.setVisible(false);
			}
			
		};
		
		buttonAniadir.addActionListener(lAniadir);
		
		JButton buttoneliminar1 = ComponentsBuilder.createButton("<html>Eliminar proveedor<br>de producto</html>", 407, 200, 185, 100, new Font("Serif", Font.PLAIN, 18));
		this.add(buttoneliminar1);
		
		ActionListener leliminar1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VEliminarProveedor eliminarProveedor = new VEliminarProveedor();
				eliminarProveedor.initGUI(GUIProveedorProducto.this);
				GUIProveedorProducto.this.setVisible(false);
			}
			
		};
		
		buttoneliminar1.addActionListener(leliminar1);
		
		JButton buttoneliminarTodos = ComponentsBuilder.createButton("<html>Eliminar proveedores<br>de producto</html>", 715, 200, 185, 100, new Font("Serif", Font.PLAIN, 17));
		this.add(buttoneliminarTodos);
		
		ActionListener leliminarTodos = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VEliminarProveedores eliminarProveedores = new VEliminarProveedores();
				eliminarProveedores.initGUI(GUIProveedorProducto.this);
				GUIProveedorProducto.this.setVisible(false);
			}
			
		};
		
		buttoneliminarTodos.addActionListener(leliminarTodos);
		
		JButton atrasButton = ComponentsBuilder.createBackButton();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(true);
				GUIProveedorProducto.this.dispose();
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		
	}
}
