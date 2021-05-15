package presentacion.proveedor_producto;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.vista.IGUI;

public class VProductosProveedor extends JFrame implements IGUI{
	
	private static final long serialVersionUID = 1L;
	
	public VProductosProveedor() {
		super("Foot World");
		this.setBounds(100, 100, 1010, 500);
		this.setContentPane(new JLabel(new ImageIcon("resources/1010x500.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actualizar(int evento, Object datos) {
		
	}
}
