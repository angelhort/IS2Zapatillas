package presentacion.vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public GUIPrincipal() {
		super("Foot World");
		this.setBounds(100, 100, 1000, 500);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
	}
	
	private void initGUI() {
		this.add(createLabel("Selecciona la entidad sobre la que trabajar", 50, 10, 900, 50, Color.BLACK));
		
		JButton buttonCliente = createButton("Cliente", 50, 80, 185, 100);
		this.add(buttonCliente);
		
		JButton buttonTrabajador = createButton("Trabajador", 288, 80, 185, 100);
		this.add(buttonTrabajador);
		
		JButton buttonVenta = createButton("Venta", 526, 80, 185, 100);
		this.add(buttonVenta);
		
		JButton buttonAlmacen = createButton("Almacen", 764, 80, 185, 100);
		this.add(buttonAlmacen);
	}
	
	private JLabel createLabel(String text, int x, int y, int width, int height, Color color) {
		JLabel label = new JLabel(text);
		
		label.setBounds(x, y, width, height);
		label.setForeground(color);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
	}
	
	private JButton createButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		
		return button;
	}
}
