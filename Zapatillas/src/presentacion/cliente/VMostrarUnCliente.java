package presentacion.cliente;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import presentacion.vista.IGUI;

public class VMostrarUnCliente extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarUnCliente(){
		super("Foot World");
		this.setBounds(100, 100, 330, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/330x230.png")));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGUI();
		this.setVisible(true);
		
	}
	
	private void initGUI() {
		
	}

	@Override
	public void actualizar(int evento, Object datos) {
		
	}

}
