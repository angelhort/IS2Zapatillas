package presentacion.producto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import negocio.producto.TransferCalcetines;
import negocio.producto.TransferProducto;
import negocio.producto.TransferZapatillas;
import presentacion.controller.Controller;
import presentacion.controller.Evento;
import presentacion.vista.ComponentsBuilder;
import presentacion.vista.IGUI;

public class VMostrarUnProducto extends JFrame implements IGUI{

	private static final long serialVersionUID = 1L;
	
	public VMostrarUnProducto() {
		super("Foot World");
		this.setBounds(100, 100, 1000, 230);
		this.setContentPane(new JLabel(new ImageIcon("resources/1000x230.png")));
		this.setLayout(null); this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initGUI(TransferProducto producto) {
		JLabel label = ComponentsBuilder.createLabel("Mostrar Producto", 355, 20, 290, 50, Color.BLACK, new Font("Serif", Font.PLAIN, 30));
		this.add(label);
		
		JButton atrasButton = ComponentsBuilder.createBackButtonSmall();
		this.add(atrasButton);
		
		ActionListener lAtras = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VMostrarUnProducto.this.dispose();
				Controller.getInstance().action(Evento.MostrarGUIProducto, null);
			}
			
		};
		
		atrasButton.addActionListener(lAtras);
		
		JTable table = ComponentsBuilder.creteTable(2, 11, 50, 115, 900, 32);
		table.setValueAt("ID", 0, 0);	
		table.setValueAt("Nombre", 0, 1);		
		table.setValueAt("Tipo", 0, 2);		
		table.setValueAt("Stock", 0, 3);		
		table.setValueAt("Precio", 0, 4);
		table.setValueAt("Talla", 0, 5);
		table.setValueAt("Color", 0, 6);
		table.setValueAt("Tejido/Tipo", 0, 7);
		table.setValueAt("Marca", 0, 8);
		table.setValueAt("Almacen", 0, 9);
		table.setValueAt("Activo", 0, 10);
		
		table.setValueAt(producto.getID(), 1, 0);
		table.setValueAt(producto.getNombre(), 1, 1);
		table.setValueAt(producto.getClass() == TransferZapatillas.class ? "Zapatillas" : "Calcetines", 1, 2);
		table.setValueAt(producto.getStock(), 1, 3);
		table.setValueAt(producto.getPrecio(), 1, 4);
		table.setValueAt(producto.getTalla(), 1, 5);
		table.setValueAt(producto.getColor(), 1, 6);
		table.setValueAt(producto.getClass() == TransferZapatillas.class ? ((TransferZapatillas) producto).getTipo() : ((TransferCalcetines) producto).getTejido(), 1, 7);
		table.setValueAt(producto.getMarca(), 1, 8);
		table.setValueAt(producto.getAlmacen(), 1, 9);
		table.setValueAt(producto.getActivo() ? "SI" : "NO", 1, 10);
		
		table.setDefaultEditor(Object.class, null);
		
		this.add(table);
	}
	
	@Override
	public void actualizar(int evento, Object datos) {
		switch(evento) {
		case Evento.MostrarUnProducto:
			initGUI((TransferProducto) datos);
			this.setVisible(true);
			break;
		}
	}


}
