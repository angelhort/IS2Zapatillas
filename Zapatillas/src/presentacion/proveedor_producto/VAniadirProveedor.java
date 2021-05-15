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

import negocio.proveedor_producto.TransferProveedor_producto;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VAniadirProveedor extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VAniadirProveedor() {
		super("Foot World");
		this.setBounds(100, 100, 330, 350);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x350.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initGUI() {
		JLabel label = ComponentsBuilder.createLabel("<html>Aniadir proveedor<br>a producto</html>", 85, 20, 190, 70, Color.BLACK, new Font("Serif", Font.PLAIN, 25));
		this.add(label);

		JLabel labelIDProducto = ComponentsBuilder.createLabel("ID Producto:", 10, 120, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelIDProducto);
		
		JTextField fieldIDProducto = ComponentsBuilder.createTextField(100, 122, 200, 20);
		this.add(fieldIDProducto);
		
		JLabel labelIDProveedor = ComponentsBuilder.createLabel("ID Proveedor:", 10, 180, 80, 20, Color.BLACK, new Font("Serif", Font.PLAIN, 14));
		this.add(labelIDProveedor);
		
		JTextField fieldIDProveedor = ComponentsBuilder.createTextField(100, 182, 200, 20);
		this.add(fieldIDProveedor);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VAniadirProveedor.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProveedorProducto, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JButton aceptarButton = ComponentsBuilder.createButton("Aceptar", 115, 250, 100, 30, new Font("Serif", Font.PLAIN, 14));
		this.add(aceptarButton);
		
		ActionListener lAceptar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(Evento.AniadirProveedor, new TransferProveedor_producto(
						Integer.parseInt(fieldIDProveedor.getText()), Integer.parseInt(fieldIDProducto.getText())));
				VAniadirProveedor.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProveedorProducto, null);
			}
			
		};
		
		aceptarButton.addActionListener(lAceptar);
	}

	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.GUIAniadirProveedor:
			initGUI();
			this.setVisible(true);
			break;
		}
	}
}
